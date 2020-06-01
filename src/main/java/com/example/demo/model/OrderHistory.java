package com.example.demo.model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

    @Entity
    public class OrderHistory {

        public OrderHistory(){}

        @Id
        @GeneratedValue ( strategy = GenerationType.IDENTITY )
        private Long OrderId;
        @ManyToOne
        private items item;
        @ManyToOne
        private Users user;
        @Column
        private int quantity;
        @Column
        private double price;
        @Column( nullable = false)
        private LocalDate date1;

        public LocalDate getDate1() {
            return date1;
        }

        public void setdate1()
        {
            this.date1 = LocalDate.now();
        }

        public Long getOrderId() {
            return OrderId;
        }

        public void setOrderId(Long orderId) {
            OrderId = orderId;
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

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }


    }

