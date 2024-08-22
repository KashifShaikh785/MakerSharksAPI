package controller;

import model.Supplier;
import service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
@RequiredArgsConstructor
public class SupplierController {
    
    private final SupplierService supplierService = new SupplierService();

    @PostMapping("/query")
    public Page<Supplier> querySuppliers(
            @RequestParam String location,
            @RequestParam Supplier.NatureOfBusiness natureOfBusiness,
            @RequestParam Supplier.ManufacturingProcess manufacturingProcess,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        return supplierService.findSuppliers(location, natureOfBusiness, manufacturingProcess, page, size);
    }
}
