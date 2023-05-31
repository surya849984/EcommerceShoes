package com.Ecom.Project03.Controller;

import com.Ecom.Project03.entity.UserEntity;
import com.Ecom.Project03.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchUsersController {

    private final UserRepo userRepo;

    @Autowired
    public SearchUsersController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/searchUsers")
    public String searchUsers(@RequestParam("keyword") String keyword, Model model) {
        List<UserEntity> users = (List<UserEntity>) userRepo.findByUsername(keyword);
        model.addAttribute("users", users);
        return "search-users";
    }
}
