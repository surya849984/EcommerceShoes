package com.Ecom.Project03.Controller;

import com.Ecom.Project03.entity.ProductEntity;
import com.Ecom.Project03.Repo.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String productList(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new ProductEntity(null, null, null, null));
        return "product/add";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") ProductEntity product) {
        productService.createProduct(product);
        return "redirect:/products/list";
    }

    @GetMapping("/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        ProductEntity product = productService.getProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id: " + id));
        model.addAttribute("product", product);
        return "product/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute("product") ProductEntity product) {
        productService.updateProduct(product);
        return "redirect:/products/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/products/list";
    }
}
