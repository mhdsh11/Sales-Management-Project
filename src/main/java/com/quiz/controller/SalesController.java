package com.quiz.controller;
import com.quiz.model.Sales;
import com.quiz.service.serviceInterface.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping
    public List<Sales> getAllSales() {
        return salesService.getAllSales();
    }

    @GetMapping("/{id}")
    public Sales getSalesById(@PathVariable Integer id) {
        return salesService.getSalesById(id);
    }

    @PostMapping
    public Sales createSales(@RequestBody Sales sales) {
        return salesService.createSales(sales);
    }

    @PutMapping("/{id}")
    public Sales updateSales(@PathVariable Integer id, @RequestBody Sales updatedSales) {
        return salesService.updateSales(id, updatedSales);
    }
}
