package spring.mvc.hibernate.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.mvc.hibernate.model.User;
import spring.mvc.hibernate.service.RoleService;
import spring.mvc.hibernate.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String userInfo(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        return "user-page";
    }
}
