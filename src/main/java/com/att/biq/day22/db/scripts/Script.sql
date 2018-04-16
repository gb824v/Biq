
CREATE TABLE `Addresses` (
  `address_id` int NOT NULL,
   PRIMARY KEY (address_id),
  `city` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zip_code` bigint(20) DEFAULT NULL
);

INSERT INTO Addresses VALUES (1, 'ashkelon', 'ziyonut', 76812);
INSERT INTO Addresses VALUES (2, 'Tell Aviv', 'KK', 76812);

CREATE TABLE `Chains` (
  `chain_id` int NOT NULL,
   PRIMARY KEY (chain_id),
  `chain_name` varchar(255) DEFAULT NULL,
  `chain_type` varchar(255) DEFAULT NULL
);

INSERT INTO Chains VALUES (100, 'Fox',"Clothes");

CREATE TABLE `Stores` (
  `stores_id` int NOT NULL,
   PRIMARY KEY (stores_id),
  `store_name` varchar(255) DEFAULT NULL,
  `address_id` int NOT NULL,
  `chain_id` int NOT null,
  FOREIGN KEY (chain_id) REFERENCES Chains(chain_id)
);

INSERT INTO Stores VALUES (1000, 'Fox Home',2, 100);

CREATE TABLE `Employees` (
  `employee_id` int NOT NULL,
   PRIMARY KEY (employee_id),
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `age` int NOT NULL,
  `stores_id` int NOT null,
  FOREIGN KEY (stores_id) REFERENCES Stores(stores_id)
);

INSERT INTO Employees VALUES (10, 'Guy', 'Bitan', 40,1000);
INSERT INTO Employees VALUES (20, 'Doron', 'Niv', 32,1000);
INSERT INTO Employees VALUES (30, 'Ilan', 'Valershtein', 40,1000);

CREATE TABLE `Malls` (
  `mall_id` int NOT NULL,
  `mall_name` varchar(255) DEFAULT NULL,
  `address_id` int NOT null,
  PRIMARY KEY (mall_id),
  FOREIGN KEY (address_id) REFERENCES Addresses(address_id)
);

INSERT INTO Malls VALUES (10000, 'Azriely',2);
