package mk.finki.ukim.wp.lab.web.servlet.controller;

import mk.finki.ukim.wp.lab.model.User;
import mk.finki.ukim.wp.lab.service.AuthService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.Option;
import java.net.http.HttpRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/auth")

public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getLoginPage(){
        return "login";
    }

    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest request){
        Optional<User> tmp = authService.login(username, password);

        if(tmp.isEmpty()){
            return "redirect:/auth";
        }

        request.getSession().setAttribute("user", tmp);
        return "redirect:/balloons";
    }

    @GetMapping("/register")
    public String showRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String name, @RequestParam String surname,
                           @RequestParam String username, @RequestParam String password,
                           @RequestParam("dateOfBirth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth){
        authService.register(username, name, surname, password, dateOfBirth);
        return "redirect:/auth";
    }
}
