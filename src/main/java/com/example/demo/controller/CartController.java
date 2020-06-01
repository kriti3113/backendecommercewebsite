package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.OrderHistory;
import com.example.demo.service.CartService;
import com.example.demo.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping( value = "/cart")
public class CartController {

    @Autowired
    CartService cartserv;
    @Autowired(required =true)
    CurrentUserService currentserv;

    @RequestMapping( value = "/addtocart/recieve/{ProductId}" , method = RequestMethod.GET)
    @ResponseBody
    public Cart addtocart(@PathVariable Long ProductId , Principal principal)
    {
        return cartserv.addtocart( currentserv.getuserid(principal),ProductId );
    }

    @RequestMapping( value = "/removeproduct/recieve/{ProductId}" , method = RequestMethod.GET)
    @ResponseBody
    public Cart removeproduct(@PathVariable Long ProductId , Principal principal)
    {
        return cartserv.removeproduct(currentserv.getuserid(principal),ProductId);
    }

    @RequestMapping( value = "/addproduct/recieve/{ProductId}" , method = RequestMethod.GET)
    @ResponseBody
    public String addproduct(@PathVariable Long ProductId , Principal principal)
    {
        return cartserv.addproduct(currentserv.getuserid(principal),ProductId);
    }

    @RequestMapping( value = "/removefromcart/recieve/{ProductId}" , method = RequestMethod.GET)
    @ResponseBody
    public Cart removefromcart(@PathVariable Long ProductId , Principal principal)
    {
        return cartserv.removefromcart(currentserv.getuserid(principal),ProductId);
    }

    @RequestMapping( value = "/remove1fromcart/recieve/{ProductId}" , method = RequestMethod.GET)
    @ResponseBody
    public Cart remove1fromcart(@PathVariable Long ProductId , Principal principal)
    {
        return cartserv.remove1fromcart(currentserv.getuserid(principal),ProductId);
    }

    @RequestMapping( value = "/showcart/recieve" , method = RequestMethod.GET)
    @ResponseBody
    public List<Cart> showcart(Principal principal)
    {
        return cartserv.showcart(currentserv.getuserid(principal),principal);
    }

    @RequestMapping( value = "/history/recieve" , method = RequestMethod.GET)
    @ResponseBody
    public List<OrderHistory> history(Principal principal)
    {
        return cartserv.history(currentserv.getuserid(principal),principal);
    }

    @RequestMapping( value = "/checkout/recieve" , method = RequestMethod.GET)
    @ResponseBody
    public double checkout(Principal principal)
    {
        return cartserv.checkout(currentserv.getuserid(principal),principal);
    }

    @RequestMapping( value = "/clearcart/recieve" , method = RequestMethod.GET)
    @ResponseBody
    public Cart clearcart(Principal principal)
    {
        return cartserv.clearcart(currentserv.getuserid(principal),principal);
    }
}
