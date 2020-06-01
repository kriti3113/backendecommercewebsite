package com.example.demo.controller;

import com.example.demo.model.items;
import com.example.demo.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping( value = "/product" , method = { RequestMethod.GET , RequestMethod.POST})
public class itemsController {
    @Autowired
    ItemsRepository ItemsRepo;

    @PostMapping("/post1")
    public items createNote(@RequestBody items user1) {
        return ItemsRepo.save(user1);
    }

    @GetMapping("/get_cate/{category}")
    public List<items> getItem(@PathVariable( value = "category") String cate)
    {
        return ItemsRepo.findAllByCategory(cate);
    }
    @GetMapping("/search/{description}")
    public List<items> search(@PathVariable (value = "description") String description)
    {
        return ItemsRepo.findAllByDescriptionContaining(description);
    }
    @GetMapping("/get_name/{name}")
    public List<items> getItem2(@PathVariable( value = "name") String name)
    {
        return ItemsRepo.findAllByName(name);
    }

}
