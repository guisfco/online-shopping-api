package br.com.guisfco.onlineshopping.controller;

import br.com.guisfco.onlineshopping.domain.CustomerListResponse;
import br.com.guisfco.onlineshopping.domain.CustomerRequest;
import br.com.guisfco.onlineshopping.entity.Customer;
import br.com.guisfco.onlineshopping.service.customer.DeleteCustomerService;
import br.com.guisfco.onlineshopping.service.customer.FindAllCustomersService;
import br.com.guisfco.onlineshopping.service.customer.SaveCustomerService;
import br.com.guisfco.onlineshopping.service.customer.UpdateCustomerService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final SaveCustomerService saveCustomerService;

    private final FindAllCustomersService findAllCustomersService;

    private final DeleteCustomerService deleteCustomerService;

    private final UpdateCustomerService updateCustomerService;

    @ApiOperation("Consulta todos os consumidores")
    @GetMapping("/customer")
    private ResponseEntity<CustomerListResponse> get() {
        return ResponseEntity.ok(findAllCustomersService.findAll());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Adiciona um consumidor")
    @PostMapping("/customer")
    private ResponseEntity<Customer> save(@RequestBody final CustomerRequest request) {
        return ResponseEntity.ok(saveCustomerService.save(request));
    }

    @ApiOperation("Atualiza as informações de um consumidor através do id")
    @PutMapping("/customer/{id}")
    private ResponseEntity<Customer> update(@PathVariable("id") final Long id,
                                            @RequestBody final CustomerRequest request) {

        return ResponseEntity.ok(updateCustomerService.update(id, request));
    }

    @ApiOperation("Deleta um consumidor através do id")
    @DeleteMapping("/customer/{id}")
    private ResponseEntity<Void> deleteById(@PathVariable("id") final Long id) {
        deleteCustomerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
