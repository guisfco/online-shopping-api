package br.com.guisfco.onlineshopping.controller;

import br.com.guisfco.onlineshopping.domain.OrderListResponse;
import br.com.guisfco.onlineshopping.domain.OrderRequest;
import br.com.guisfco.onlineshopping.domain.OrderResponse;
import br.com.guisfco.onlineshopping.service.order.FindAllOrdersService;
import br.com.guisfco.onlineshopping.service.order.SaveOrderService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final SaveOrderService saveOrderService;

    private final FindAllOrdersService findAllOrdersService;

    @ApiOperation("Consulta todos os pedidos")
    @GetMapping("/order")
    public ResponseEntity<OrderListResponse> findAll() {
        return ResponseEntity.ok(findAllOrdersService.findAll());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Adiciona um pedido para um consumidor")
    @PostMapping("/order")
    public ResponseEntity<OrderResponse> saveOrder(@RequestBody final OrderRequest request) {
        return ResponseEntity.ok(saveOrderService.save(request));
    }
}
