package com.quiz.service.serviceImplementation;

import com.quiz.model.Sales;
import com.quiz.model.Transaction;
import com.quiz.repository.SalesRepository;
import com.quiz.repository.TransactionRepository;
import com.quiz.service.serviceInterface.SalesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    private static final Logger log = LoggerFactory.getLogger(SalesServiceImpl.class);

    @Override
    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    @Override
    public Sales getSalesById(Integer id) {
        Optional<Sales> optionalSales = salesRepository.findById(id);
        return optionalSales.orElse(null);
    }

    @Override
    public Sales createSales(Sales sales) {
        Sales s=salesRepository.save(sales);
        List<Transaction> transactions=new ArrayList<>();
        for(Transaction t:s.getTransactions())
        {
            t.setSales(s);
            t.setSalesId(s.getId());
            transactions.add(t);
        }
        transactionRepository.saveAll(transactions);
        return s;
    }

    @Override
    public Sales updateSales(Integer id, Sales updatedSales) {
        Optional<Sales> optionalSales = salesRepository.findById(id);
        if (optionalSales.isPresent()) {
            Sales existingSales = optionalSales.get();

            // Update common attributes
            existingSales.setCreationDate(updatedSales.getCreationDate());
            existingSales.setClient(updatedSales.getClient());
            existingSales.setSeller(updatedSales.getSeller());
            existingSales.setTotal(updatedSales.getTotal());

            // Update quantities and prices in transactions
            List<Transaction> existingTransactions = existingSales.getTransactions();
            List<Transaction> updatedTransactions = updatedSales.getTransactions();

            if (existingTransactions != null && updatedTransactions != null) {
                for (int i = 0; i < existingTransactions.size(); i++) {
                    Transaction existingTransaction = existingTransactions.get(i);
                    Transaction updatedTransaction = updatedTransactions.get(i);

                    // Update quantity and price
                    existingTransaction.setQuantity(updatedTransaction.getQuantity());
                    existingTransaction.setPrice(updatedTransaction.getPrice());

                    // Log the update operation
                    log.info("Updated transaction for Sale ID {} - Transaction ID {}: Quantity={}, Price={}",
                            existingSales.getId(), existingTransaction.getId(),
                            existingTransaction.getQuantity(), existingTransaction.getPrice());
                }
            }

            return salesRepository.save(existingSales);
        }
        return null;
    }
}
