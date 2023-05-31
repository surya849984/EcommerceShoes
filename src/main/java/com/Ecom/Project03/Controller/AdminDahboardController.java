package com.Ecom.Project03.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AdminDahboardController {


	    @GetMapping("/")
	    public String index() {
	        return "dashboard";
	    }
	    
	    @GetMapping("/change-password")
	    public String changePassword() {
	        // Add your logic to handle the change password action
	        return "admin";
	    }

	    @GetMapping("/search-users")
	    public String searchUsers() {
	        // Add your logic to handle the search users action
	        return "search-users";
	    }

	    @GetMapping("/manage-products")
	    public String manageProducts() {
	        // Add your logic to handle the manage products action
	        return "manage_products";
	    }

	    @GetMapping("/purchase-report")
	    public String purchaseReport() {
	        // Add your logic to handle the purchase report action
	        return "purchase_report";
	    }
	}


