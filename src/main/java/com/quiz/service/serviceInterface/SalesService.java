package com.quiz.service.serviceInterface;
import com.quiz.model.Sales;

import java.util.List;

public interface SalesService {
    List<Sales> getAllSales();
    Sales getSalesById(Integer id);
    Sales createSales(Sales sales);
    Sales updateSales(Integer id, Sales sales);
}
