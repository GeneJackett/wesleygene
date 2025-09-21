package com.personalsite.wesleygene.controller;

import com.ordersdemo.ordersdemo.dto.OrderRequest;
import com.ordersdemo.ordersdemo.model.Order;
import com.ordersdemo.ordersdemo.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/")
//@CrossOrigin(origins = "http://localhost:4200/orders") // allow angular frontend
public class BlogController {

    @Autowired
    private final BlogService BlogService;

    public BlogController(BlogService BlogService){
        this.BlogService = BlogService;
    }
    @GetMapping("/admin")
    public String admin(){
        return "Here!";
    }

    //get all Orders
    @GetMapping("/Orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> Orders = BlogService.getAllOrders();
       return (Orders != null) ? ResponseEntity.ok(Orders)
                       : ResponseEntity.notFound().build();
        
    }

    @GetMapping("/getOrdersByCustomerId")
    public ResponseEntity<List<Order>> getOrdersByCustomerId(@RequestParam String customerId){
         List<Order> Orders = BlogService.getOrdersByCustomerId(customerId);
        return (Orders != null) ? ResponseEntity.ok(Orders)
                : ResponseEntity.notFound().build();
    }

    //request sent to db to remove record
    //print out success response after
    //what happens if we call the same delete request and no record matches?
    //
    @DeleteMapping("/delete/Order/{id}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable Long id){
            boolean deleted = BlogService.deleteOrderById(id);
        return deleted ? ResponseEntity.noContent().build() 
                       : ResponseEntity.notFound().build();
    } 

    //but what happens if 
    @PostMapping("/create/Order")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest request){
        Order savedOrder = BlogService.createOrder(request);
        return ResponseEntity.ok(savedOrder);
    }

    
    @PutMapping("/update/Order/{id}")
    public ResponseEntity<Order> updateOrder(@RequestBody OrderRequest request, @PathVariable Long id){
        return BlogService.updateOrder(request, id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
}
