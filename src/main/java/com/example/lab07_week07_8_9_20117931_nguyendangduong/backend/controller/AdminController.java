package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.controller;

import fit.se.week7.backend.dto.ProductDto;
import fit.se.week7.backend.dto.UserDto;
import fit.se.week7.backend.models.Role;
import fit.se.week7.backend.models.User;
import fit.se.week7.backend.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private EmployeeService employeeService;
    @Qualifier("productImplement")
    @Autowired
    private ProductService service;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;
    @GetMapping
    public String adminForm(Model model,@RequestParam(name = "userName", required = false) String userName,@RequestParam(name = "select", required = false) String select){
        getCartItem(model,userName,select);
        return "admin";
    }
    public void AccHadle(Model model){
        List<User> list = userService.getAll();
        List<UserDto> listDto= new ArrayList<>();
        for(User u: list){
            List<Role> listR = roleService.findByUserName(u.getUserName());
            System.out.println(listR);
            UserDto dto= new UserDto(u,listR);
            listDto.add(dto);
        }
        model.addAttribute("users", listDto);
    }
    public void getCartItem(Model model,String userName,String select){
        List<ProductDto> l = service.getProduct(userName);
        model.addAttribute("productsCart",l);
        if(userName!=null){
            model.addAttribute("n", userName);
            Optional<User> u = userService.findByUserName(userName);
            if(u.isPresent()){
                model.addAttribute("admin",true);
            }
        }
        if(select!=null){
        switch (select) {
            case "acc":
                AccHadle(model);
                break;
            case "emp":
                model.addAttribute("employees", employeeService.getAll());
                break;
            case "cus":
                model.addAttribute("customers", customerService.getAll());
                break;
            case "date":

                break;
            case "Semp":
                break;
            default:
                AccHadle(model);
                break;
        }
        }else AccHadle(model);
        model.addAttribute("cartSize",l==null?0:l.size());
    }
}
