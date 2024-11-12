package com.mouts.orders_manegement_api.controller;


import com.mouts.orders_manegement_api.dto.OrderDTO;
import com.mouts.orders_manegement_api.exception.OrderNotFoundException;
import com.mouts.orders_manegement_api.service.OrderManagementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private OrderManagementService orderManagementService;

    @GetMapping
    public ResponseEntity<OrderDTO> getOrderById(@RequestParam String id) throws Exception {
        return ResponseEntity.ok().body(orderManagementService.getOrderById(id));
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) throws Exception {
        orderManagementService.createOrder(orderDTO);
        return ResponseEntity.ok().build();
    }
}
