package com.quiz.service.serviceInterface;
import com.quiz.model.Seller;

import java.util.List;

public interface SellerService {
    List<Seller> getAllSellers();

    Seller getSellerById(Integer sellerId);

    Seller createSeller(Seller seller);

    Seller updateSeller(Integer sellerId, Seller seller);

    void deleteSeller(Integer sellerId);
}
