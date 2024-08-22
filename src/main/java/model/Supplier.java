package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "suppliers")
public class Supplier {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;

    private String companyName;
    private String website;
    private String location;

    @Enumerated(EnumType.STRING)
    private NatureOfBusiness natureOfBusiness;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "supplier_manufacturing_processes", joinColumns = @JoinColumn(name = "supplier_id"))
    @Column(name = "manufacturing_process")
    @Enumerated(EnumType.STRING)
    private List<ManufacturingProcess> manufacturingProcesses;

    public enum NatureOfBusiness {
        SMALL_SCALE, MEDIUM_SCALE, LARGE_SCALE
    }

    public enum ManufacturingProcess {
        MOULDING, PRINTING_3D, CASTING, COATING
    }
}
