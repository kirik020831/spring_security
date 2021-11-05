package spring.mvc.hibernate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import spring.mvc.hibernate.dao.UserDaoImp;
import spring.mvc.hibernate.model.Role;
import spring.mvc.hibernate.model.User;
import spring.mvc.hibernate.service.RoleService;
import spring.mvc.hibernate.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String showAllUser(Model model) {
        List<User> allUsers = userService.listUsers();
        model.addAttribute("allUs", allUsers);
        return "admin-page";
    }

    @GetMapping("/user")
    public String userInfo(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        return "user-page";
    }

    @GetMapping("/user/new")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("role", roleService.listRole());
        return "user-info";
    }

    @PostMapping("/user/new")
    public String addNewUser(@ModelAttribute User user, @RequestParam("rolles") String[] role) {
        Set<Role> roleSet = new HashSet<>();
        for (String roles :
                role) {
            roleSet.add(roleService.getByName(roles));
        }
        user.setRoles(roleSet);
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/user/edit/{id}")
    public String editUser(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("role", roleService.listRole());
        return "edit-user";
    }

    @PatchMapping(value = "/user/edit/{id}")
    public String editUser(@ModelAttribute User user, @RequestParam("rolles") String[] role) {
        Set<Role> rolesSet = new HashSet<>();
        for (String roles : role) {
            rolesSet.add((roleService.getByName(roles)));
        }
        user.setRoles(rolesSet);
        userService.update(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
