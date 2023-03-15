package com.example.demo2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class OrderController {

    private final ShopService shopService;

    public OrderController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("orders")
    public List<Order> getOrders() {
        return shopService.listOrders();
    }

    @GetMapping("orders/{id}")
    public Order getOrder(@PathVariable String id) {
        return shopService.getOrder(id);
    }

    @PostMapping("orders/")
    public Order addOrder(@RequestBody List<String> productIds) {
        return shopService.addOrder(productIds);
    }

    @DeleteMapping("orders/{id}")
    public ResponseEntity delete0rder (@PathVariable String id) {
        shopService.deleteOrder(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
}
