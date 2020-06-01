package com.example.demo.model;


import javax.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private items item;
    @ManyToOne
    private Users user;
    @Column
    private int quantity;

    public Cart(){}

    public Cart(items item,Users user, int quantity) {

        this.item = item;
        this.user = user;
        this.quantity = quantity;
    }


    public items getItem() {
        return item;
    }

    public void setItem(items item) {
        this.item = item;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }
}
