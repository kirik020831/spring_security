package spring.mvc.hibernate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.mvc.hibernate.dao.UserDaoImp;
import spring.mvc.hibernate.model.User;
import spring.mvc.hibernate.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAllUser(Model model) {
        List<User> allUsers = userService.listUsers();
        model.addAttribute("allUs", allUsers);
        return "all-users";
    }
}
