package ua.kiev.prog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.kiev.prog.exception.UserException;
import ua.kiev.prog.service.UserService;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/registration")
    public String getRegistration() {
        return "registration";
    }

    @PostMapping("/login")
    @ResponseBody
    public boolean login(@RequestParam String login, @RequestParam String password) {
        try {
            return userService.login(login, password);
        } catch (UserException e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "/registration")
    public ModelAndView register(@RequestParam String login, @RequestParam String password) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            userService.registration(login, password);
            modelAndView.addObject("success", true);
        } catch (UserException e) {
            e.printStackTrace();
            modelAndView.addObject("success", false);
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
