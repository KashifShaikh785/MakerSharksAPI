CREATE TABLE suppliers (
    supplier_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    company_name VARCHAR(255) NOT NULL,
    website VARCHAR(255),
    location VARCHAR(255) NOT NULL,
    nature_of_business VARCHAR(20) NOT NULL
);

CREATE TABLE supplier_manufacturing_processes (
    supplier_id BIGINT NOT NULL,
    manufacturing_process VARCHAR(50) NOT NULL,
    FOREIGN KEY (supplier_id) REFERENCES suppliers(supplier_id) ON DELETE CASCADE
);
