package web.controller;

import web.model.User;
import web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/table")
public class FirstController {
    private UserService userService;
    @Autowired
    public FirstController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("users",userService.getAll());
        return "/all";
    }
    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user",userService.get(id));
        return "/user";
    }
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user",new User());
        return "/newUser";
    }
    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "/newUser";
        }
            userService.save(user);
            return "redirect:/table";
    }
    @GetMapping("/user/{id}/edit")
    public String edit(@PathVariable("id")int id,Model model) {
       model.addAttribute("user",userService.get(id));
       return "/edit";
    }
    @PatchMapping("/user/{id}")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if(bindingResult.hasErrors()) {
            return "/edit";
        }
        userService.update(id,user);
        return "redirect:/table";

    }
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/table";
    }


}
