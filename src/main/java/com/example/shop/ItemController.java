package com.example.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @GetMapping("/list")
    String list(Model model){
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items", result);
        return "list";
    }
    @GetMapping("/write")
    String write(){
        return "write";

    }
    @Transactional
    @PostMapping("/add")
    String addPost( String title, Integer price) {
        itemService.saveItem(title, price);
        return "redirect:/list";
    }
    @Transactional
    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model) {
        Optional<Item> result = itemRepository.findById(id);
        if(result.isPresent()) {
            model.addAttribute("data", result.get());
            return "detail.html";
        } else {
            return "redirect:/list";
        }

    }


}
