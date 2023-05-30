package com.Ecom.Project03.Controller;

import com.Ecom.Project03.entity.UserEntity;
import com.Ecom.Project03.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserController {

    private final UserRepo userRepository;

    @Autowired
    public UserController(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // Perform authentication logic here
        UserEntity user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // Successful login
            return "home";
        }
        else if (username.equals("admin") && password.equals("admin123")) {
            // Successful login
            return "admin-login";
        }
        
         else {
            // Invalid credentials
            return "redirect:/login?error";
        }
    }
  
    }




