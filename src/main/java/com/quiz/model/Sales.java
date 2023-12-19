package com.quiz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;

    @Column(name = "creationDate")
    private Date creationDate;
    @Column(name = "client")
    private Integer clientId;

    @Column(name = "seller")
    private Integer sellerId;

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Client client;

    @ManyToOne
    @JoinColumn(name = "seller", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Seller seller;

    @Column(name = "total")
    private Double total;

    @OneToMany(mappedBy = "sales", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

}
