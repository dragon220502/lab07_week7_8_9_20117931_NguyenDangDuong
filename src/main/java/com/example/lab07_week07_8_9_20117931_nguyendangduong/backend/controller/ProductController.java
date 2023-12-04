package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.controller;

import fit.se.week7.backend.dto.CheckoutDto;
import fit.se.week7.backend.dto.CheckoutForm;
import fit.se.week7.backend.dto.ProductDto;
import fit.se.week7.backend.dto.SignupDto;
import fit.se.week7.backend.enums.CartStatus;
import fit.se.week7.backend.models.*;
import fit.se.week7.backend.pks.CartKey;
import fit.se.week7.backend.pks.OrderDetailPK;
import fit.se.week7.backend.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Qualifier("productImplement")
    @Autowired
    private ProductService service;
    @Autowired
    private ProductPriceService productPriceService;
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailsService orderDetailsService;
    private int PAGE;
    private int SIZE;
    private List<CheckoutDto> list = new ArrayList();
    @PostMapping(value = "/check", consumes = "application/x-www-form-urlencoded")
    public String check(@ModelAttribute("checkoutForm") CheckoutForm checkoutForm,@RequestParam(name = "userName", required = false) String userName, Model model, RedirectAttributes attributes){
        System.out.println(checkoutForm);
        List<CheckoutDto> products = checkoutForm.getProducts();
        System.out.println(products);
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        double total=0;
        for(CheckoutDto d : products) {
            if (d.getQuantity() == 0) {
                products.remove(d);
            } else {
                total += d.getTotal();
            }
        }
        SignupDto dto = new SignupDto();
        Employee emp= new Employee();
        model.addAttribute("dto",dto);
        model.addAttribute("emp",emp);
        getCartItem(model,userName);
        CheckoutForm from = new CheckoutForm();
        from.setProducts(products);
        String formattedTotal = decimalFormat.format(total);
        model.addAttribute("products", products);
        model.addAttribute("finalTotal", formattedTotal);
        model.addAttribute("checkoutForm", from);
        attributes.addFlashAttribute("checkoutForm", from);
        list= from.getProducts();
//        redirectAttributes.addFlashAttribute("products",products);
//        redirectAttributes.addFlashAttribute("finalTotal",total);
        return "checkout";
    }
    @PostMapping(value = "/payment", consumes = "application/x-www-form-urlencoded")
    public String payment(@RequestParam(name = "userName", required = false) String userName,@ModelAttribute("dto") SignupDto dto, @ModelAttribute("checkoutForm")CheckoutForm checkoutForm ,  @ModelAttribute("emp") Employee emp){
        Optional<User> u = userService.findByUserName(userName);
        Optional<Employee> e = employeeService.findById(emp.getId());
        Optional<Customer> cus = customerService.findByEmail(dto.getEmail());
        System.out.println(checkoutForm);
        if(cus.isEmpty()||u.isEmpty()||!u.get().getPassWord().equalsIgnoreCase(dto.getPassWord())){
            return "errorLogin";
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        if(e.isPresent()){

            Order o = new Order(LocalDateTime.now(),e.get(),cus.get());
            orderService.save(o);
            checkoutForm.setProducts(list);
            List<CheckoutDto> products = checkoutForm.getProducts();
            double total=0;
            for(CheckoutDto d : products){
                Optional<Product> p= service.findById(d.getId());
                if(p.isEmpty()){
                    return "errorLogin";
                }
                if(d.getQuantity()==0){
                    products.remove(dto);
                }
                else {
                    total+=d.getTotal();
                }
                CartKey key = new CartKey(p.get(),u.get());
                Optional<Cart> c = cartService.findById(key);
                if(c.isEmpty()){
                    return "errorLogin";
                }
                Cart c0 = c.get();
                c0.setStatus(CartStatus.PURCHASED);
                cartService.save(c0);
                OrderDetailPK pk = new OrderDetailPK(o,p.get());
                OrderDetail od = new OrderDetail(pk,d.getQuantity(),d.getPrice(),dto.getNote());
                orderDetailsService.save(od);
            }
            String formattedTotal = decimalFormat.format(total);
            System.out.println(formattedTotal);

        }
       return  "redirect:/product/index?userName="+userName;
    }

    public void getCartItem(Model model,String userName){
        List<ProductDto> l = service.getProduct(userName);
        model.addAttribute("productsCart",l);
        if(userName!=null){
            model.addAttribute("n", userName);
            Optional<User> u = userService.findByUserName(userName);
            if(u.isPresent()){
                model.addAttribute("admin",true);
            }
        }

        model.addAttribute("cartSize",l==null?0:l.size());
    }
    @GetMapping("/shop-details/{prod_id}")
    public String shopDetails( @PathVariable Long prod_id, Model model,@RequestParam(name = "userName", required = false) String userName){
        Optional<ProductDto> p = service.findByProdId(prod_id);

        if(p.isEmpty()){
            return "errorLogin";
        }
        getCartItem(model, userName);

        model.addAttribute("productDetail",p.get());
        return "shop-details";
    }

    @GetMapping("/cart")
    public String cartForm(Model model,@RequestParam(name = "userName", required = false) String userName){
        if(userName==null){
            model.addAttribute("isLogin","you not login");
        }
        else {
            getCartItem(model, userName);
            model.addAttribute("checkoutForm", new CheckoutForm());
        }
        return "shoping-cart";
    }
    @GetMapping("/cart/{user_id}/{prod_id}")
    public String cartInsert(@PathVariable("user_id") String userName, @PathVariable Long prod_id){
        Optional<User> u = userService.findByUserName(userName);
        Optional<Product> p = service.findById(prod_id);
        if(u.isEmpty()||p.isEmpty()){
            return "errorLogin";
        }
        CartKey key = new CartKey(p.get(),u.get());
        Cart c= new Cart(key, CartStatus.INCART);
        cartService.save(c);

        return "redirect:/product/index?userName="+userName;
    }
    @GetMapping
    private String formProduct(Model model, @RequestParam(name = "userName", required = false) String userName){
        model.addAttribute("products",service.getProduct(userName));
        model.addAttribute("n",userName);
        return "index";
    }
    @GetMapping("/cart/delete/{user_id}/{prod_id}")
    public String cartDelete(@PathVariable("user_id") String userName, @PathVariable Long prod_id){
        Optional<User> u = userService.findByUserName(userName);
        Optional<Product> p = service.findById(prod_id);
        if(u.isEmpty()||p.isEmpty()){
            return "errorLogin";
        }
        CartKey key = new CartKey(p.get(),u.get());
        Optional<Cart> cart = cartService.findById(key);
        if(cart.isEmpty()){
            return "errorLogin";
        }
        Cart c= cart.get();
        c.setStatus(CartStatus.DELETED);
        cartService.save(c);
        return "redirect:/product/cart?userName="+userName;
    }

    @GetMapping("/index")
    public String getAllBySort(Model model,@RequestParam(name = "userName", required = false) String userName, @RequestParam(value = "page", required = false) Optional<Integer> page, @RequestParam(value = "size", required = false) Optional<Integer> size, RedirectAttributes redirectAttributes){
        int currentPage= page.orElse(1);
        int currentSize=size.orElse(10);
        Page<ProductDto> p = service.findPage(currentPage - 1, currentSize, "name", "asc");
        model.addAttribute("pageProduct",p);
        getCartItem(model, userName);
        int totalPage= p.getTotalPages();
        if(totalPage>0){
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
            PAGE=currentPage;
            SIZE=currentSize;
        }
        return "index";
    }
}
