package repository;

import model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long>, JpaSpecificationExecutor<Supplier> {
    List<Supplier> findByLocationAndNatureOfBusinessAndManufacturingProcessesContains(
            String location, Supplier.NatureOfBusiness natureOfBusiness, Supplier.ManufacturingProcess manufacturingProcess);
}
