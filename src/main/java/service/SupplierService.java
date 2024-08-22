package service;

import model.Supplier;
import repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {
    
    private final SupplierRepository supplierRepository = null;

    public Page<Supplier> findSuppliers(String location, Supplier.NatureOfBusiness natureOfBusiness,
                                        Supplier.ManufacturingProcess manufacturingProcess, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return supplierRepository.findAll((root, query, criteriaBuilder) -> {
            var predicates = criteriaBuilder.and(
                    criteriaBuilder.equal(root.get("location"), location),
                    criteriaBuilder.equal(root.get("natureOfBusiness"), natureOfBusiness),
                    criteriaBuilder.isMember(manufacturingProcess, root.get("manufacturingProcesses"))
            );
            return predicates;
        }, pageable);
    }
}
