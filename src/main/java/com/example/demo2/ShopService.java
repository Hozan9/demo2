package com.example.demo2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ShopService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
   private final IdService idService;
  // private final Order order;

    public ShopService(ProductRepository productRepository, OrderRepository orderRepository, IdService idService) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
     this.idService = idService;

    }

    public List<Product> listProducts() {
        return productRepository.list();
    }

    public Product getProduct(String id) {
        return productRepository.get(id);
    }

    public List<Order> listOrders() {
        return orderRepository.list();
    }

    public Order getOrder(String id) {
        return orderRepository.get(id);
    }

    public Order addOrder(List<String> productIds) {
        List<Product> allProducts = new ArrayList<>();

        for (String productId : productIds) {
            Product product = productRepository.get(productId);

            if (product == null) {
                throw new NoSuchElementException("Product with Id: " + productId + " not found!");
            }

            allProducts.add(product);
        }

        Order order = new Order(UUID.randomUUID().toString(), allProducts);
        return orderRepository.add(order);
    }
    public void deleteOrder(String id){
        orderRepository.deleteOrder(id);
    }


}