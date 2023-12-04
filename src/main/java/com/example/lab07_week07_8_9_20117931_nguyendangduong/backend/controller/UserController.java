package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.controller;

import fit.se.week7.backend.dto.SignupDto;
import fit.se.week7.backend.enums.RoleName;
import fit.se.week7.backend.enums.UserRoleStatus;
import fit.se.week7.backend.enums.UserStatus;
import fit.se.week7.backend.models.Customer;
import fit.se.week7.backend.models.Role;
import fit.se.week7.backend.models.User;
import fit.se.week7.backend.models.UserRole;
import fit.se.week7.backend.pks.UserRolePK;
import fit.se.week7.backend.services.CustomerService;
import fit.se.week7.backend.services.RoleService;
import fit.se.week7.backend.services.UserRoleService;
import fit.se.week7.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {
    @Qualifier("userImplement")
    @Autowired
    private UserService service;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleService roleService;

    @GetMapping
    public String logForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("signupDto", new SignupDto());
        return "signIn";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user) {
        Optional<User> f = service.findByUserName(user.getUserName());
        Optional<User> e = service.findByEmail(user.getUserName());
        if (f.isPresent()) {
            if (f.get().getPassWord().equalsIgnoreCase(user.getPassWord())) {
                return "redirect:/product/index?userName=" + user.getUserName();
            }
        }
        if (e.isPresent()) {
            if (e.get().getPassWord().equalsIgnoreCase(user.getPassWord())) {
                return "redirect:/product/index?userName=" + user.getUserName();
            }
        }
        return null;
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("signupDto") SignupDto dto, @ModelAttribute("user") User user) {
        Optional<User> f = service.findByUserName(dto.getUserName());
        System.out.println(f);
        Optional<User> e = service.findByEmail(dto.getEmail());
        System.out.println(e);
        if (dto.getUserName() == null || dto.getEmail() == null) {
            return "errorLogin";
        }
        if (f.isPresent() || e.isPresent() || !dto.getPassWord().equalsIgnoreCase(dto.getConfirmPassWord())) {
            return "errorLogin";
        }
        User u = new User(dto.getUserName(), dto.getPassWord(), dto.getEmail(), UserStatus.ACTIVE);
        Optional<Role> r = roleService.findByRoleName(RoleName.USER);
        UserRolePK pk= new UserRolePK(u,r.get());
        UserRole userRole= new UserRole(pk, UserRoleStatus.ACTIVE);
        userRoleService.save(userRole);
        Customer c = new Customer(dto.getName(), dto.getEmail(), dto.getPhone(), dto.getAddress());
        Optional<Customer> cus = customerService.findByEmail(dto.getEmail());
        if (cus.isPresent()) {

        } else
            customerService.save(c);
        userService.save(u);
        return "signIn";
    }

}
