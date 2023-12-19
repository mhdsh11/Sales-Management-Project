package com.quiz.service.serviceImplementation;

import com.quiz.model.Seller;
import com.quiz.repository.SellerRepository;
import com.quiz.service.serviceInterface.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller getSellerById(Integer sellerId) {
        Optional<Seller> optionalSeller = sellerRepository.findById(sellerId);
        return optionalSeller.orElse(null);
    }

    @Override
    public Seller createSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public Seller updateSeller(Integer sellerId, Seller updatedSeller) {
        Optional<Seller> optionalSeller = sellerRepository.findById(sellerId);
        if (optionalSeller.isPresent()) {
            Seller existingSeller = optionalSeller.get();
            existingSeller.setName(updatedSeller.getName());
            return sellerRepository.save(existingSeller);
        }
        return null;
    }

    @Override
    public void deleteSeller(Integer sellerId) {
        sellerRepository.deleteById(sellerId);
    }
}

