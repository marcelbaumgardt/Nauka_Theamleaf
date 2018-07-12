package pl.marcelbaungardt.naukatheamleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.marcelbaungardt.naukatheamleaf.model.User;
import pl.marcelbaungardt.naukatheamleaf.service.UserService;

import java.util.List;

@Controller
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(path = "/users")
    public String getUsers(Model model){
        List<User> allUser = userService.getAllUser();
        model.addAttribute("users",allUser);
        return "users2";
    }



    @GetMapping(path = "/addUser")
    public String addUserForm(Model model){
        model.addAttribute("user",new User());
        return "addUser";
    }

    @PostMapping(path = "/addUser")
    public String addUser(@ModelAttribute User user){
        userService.createUser(user);
        return "redirect:/users";
    }
    // localhost:8080/delete?id=2
    @GetMapping(path = "/delete")
    public String deleteUser(@RequestParam Long id){
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping(path = "/users/{id}")
    public String showProfile(@PathVariable Long id, Model model) {
        User user = userService.getUser(id);
            model.addAttribute("user",user);
            return "profile";

    }


    //  /adduser-> mapujemy posta -> wyciagamy usera przy pomocy model.atribute -> dodajemy do bazy przy pomocy serwisu
}
