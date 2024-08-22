INSERT INTO suppliers (company_name, website, location, nature_of_business) VALUES
('Company A', 'http://companya.com', 'India', 'SMALL_SCALE'),
('Company B', 'http://companyb.com', 'India', 'MEDIUM_SCALE'),
('Company C', 'http://companyc.com', 'India', 'LARGE_SCALE');

INSERT INTO supplier_manufacturing_processes (supplier_id, manufacturing_process) VALUES
(1, 'PRINTING_3D'),
(2, 'MOULDING'),
(3, 'CASTING');
