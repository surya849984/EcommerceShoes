package com.Ecom.Project03.Controller;

import com.Ecom.Project03.Repo.UserRepo;
import com.Ecom.Project03.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PasswordChangeController {
    private final UserRepo userRepository;

    @Autowired
    public PasswordChangeController(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/admin")
    public String showLoginForm() {
        return "admin";
    }

    @PostMapping("/admin")
    public String changePassword(@RequestParam("currentPassword") String currentPassword,
                                 @RequestParam("newPassword") String newPassword,
                                 @RequestParam("confirmPassword") String confirmPassword){

        // Retrieve the currently logged-in admin (you may use session or authentication mechanism)
        UserEntity admin = userRepository.findByUsername("surya");

        // Check if the current password matches
     // Check if the current password matches
        if (admin.getPassword().equals(currentPassword)) {
            // Check if the new password and confirm password match
            if (newPassword.equals(confirmPassword)) {
                // Update the admin's password with the new password
                admin.setPassword(newPassword);
                userRepository.save(admin);
                
                return "redirect:/admin?succuss";
            } else {
                // New password and confirm password do not match
                return "redirect:/admin?error";
            }
        } else {
            // Invalid current password
            return "redirect:/admin?invalid";
        }
    }}

     
        
   

