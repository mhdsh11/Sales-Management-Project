package com.quiz.controller;
import com.quiz.model.Seller;
import com.quiz.service.serviceInterface.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @GetMapping
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @GetMapping("/{sellerId}")
    public Seller getSellerById(@PathVariable Integer sellerId) {
        return sellerService.getSellerById(sellerId);
    }

    @PostMapping
    public Seller createSeller(@RequestBody Seller seller) {
        return sellerService.createSeller(seller);
    }

    @PutMapping("/{sellerId}")
    public Seller updateSeller(@PathVariable Integer sellerId, @RequestBody Seller seller) {
        return sellerService.updateSeller(sellerId, seller);
    }

    @DeleteMapping("/{sellerId}")
    public void deleteSeller(@PathVariable Integer sellerId) {
        sellerService.deleteSeller(sellerId);
    }
}
