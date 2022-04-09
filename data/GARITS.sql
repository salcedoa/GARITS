CREATE TABLE stock      
(
PartID integer(10) NOT NULL AUTO_INCREMENT primary key,
PartName varchar(255) NOT NULL,
PartType char(30),
Vehicle varchar(30) NOT NULL,
SoldIn char(30),
Manufacturer varchar(255),
ManufacturerPrice decimal(10,2),
StockLevel integer(4) NOT NULL,
LowLevelThreshold integer(5) NOT NULL DEFAULT 10,
CustomerCost decimal(10,2),
Ordered integer(4)
);

CREATE TABLE suppliers
(
SupplierID integer(10) NOT NULL AUTO_INCREMENT primary key,
SupplierName varchar(255) NOT NULL,
Address varchar(255) NOT NULL,
Postcode varchar(10) NOT NULL,
Telephone varchar(30),
Notes varchar(255)
);

/* Wasn't sure so made 2 tables as supplier/ manufactures are techincally different just to be safe delete if not */

CREATE TABLE manufacturer
(
ManufacturerName varchar(255) NOT NULL,
ManufacturerID integer(10) NOT NULL AUTO_INCREMENT primary key,
Address varchar(255) NOT NULL,
Postcode varchar(10) NOT NULL,
Telephone varchar(30),
Notes varchar(255)
);

CREATE TABLE jobs
(
JobID int(30) NOT NULL AUTO_INCREMENT primary key,
CustomerName varchar(255),
NumberPlate varchar (10) NOT NULL,
Make varchar(30),
Model varchar(30) NOT NULL,
CustomerTelephone varchar(30),
DescriptionRequiredWork varchar(400),
FOREIGN KEY (NumberPlate) REFERENCES vehicles(NumberPlate)
);

CREATE TABLE invoices(
InvoiceID int(30) NOT NULL AUTO_INCREMENT primary key,
JobID int(30)NOT NULL,
CustomerName varchar(255),
VehicleID int(10) NOT NULL,
Make varchar(30),
Model varchar(30) NOT NULL,
DescriptionDoneWork varchar(400),
TotalPartCost decimal(10,2),
LabourCost decimal(10,2),
AddedVAT decimal(10,2)NOT NULL,
Total decimal (10,2)NOT NULL,
DiscountApplied decimal (10,2),
FOREIGN KEY (VehicleID) REFERENCES vehicles(Vehicle),
FOREIGN KEY (JobID) REFERENCES jobs(JobID)
);

CREATE TABLE users(
AccountID integer(10) NOT NULL AUTO_INCREMENT primary key,
AccountHolder varchar(30) NOT NULL,
AccountType varchar(30) NOT NULL,
HourlyRate int(5),
Username varchar(30) NOT NULL,
Password varchar(30) NOT NULL
);

CREATE TABLE customerRecords(
CustomerID integer(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
CustomerName varchar(255) NOT NULL,
AddressLine1 varchar(255) NOT NULL,
AddressLine2 varchar(255),
AddressLine3 varchar(255),
Postcode varchar(10) NOT NULL,
Contact varchar(30),
ContactTitle varchar(30),
Telephone varchar(30),
Mobile varchar(30),
isBusiness boolean NOT NULL DEFAULT FALSE,
PayLate boolean NOT NULL DEFAULT FALSE
);

CREATE TABLE vehicles (
NumberPlate varchar(10) NOT NULL PRIMARY KEY,
Colour varchar(10) NOT NULL,
LastMoT date,
Make varchar(30),
Model varchar(30) NOT NULL,
CustomerID int(10) NOT NULL,
FOREIGN KEY (CustomerID) REFERENCES customerRecords(CustomerID)
);

CREATE TABLE discounts (
discountID integer(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
discountType varchar(30) NOT NULL,
discountPercentage int(10) NOT NULL,
flexibleLowRange int(10),
flexibleHighRange int(10),
variableBusinessType varchar(30),
CustomerID int(10) NOT NULL,
CHECK (discountType = 'flexible' OR 'variable' OR 'fixed'),
FOREIGN KEY (CustomerID) REFERENCES customerRecords(CustomerID)
);


DESCRIBE stock;
INSERT INTO stock 
(PartName,PartType,Vehicle,SoldIn,Manufacturer,ManufacturerPrice,StockLevel,LowLevelThreshold,CustomerCost,Ordered)
VALUES 
('Tyre','heavy tread','Fjord Transit Van',null,'Fjord',null,8,6,45.00,null),
('Exhaust','Complete Box','Fjord Estate',null,'Fjord',null,3,2,200.00,null),
('Engine Mounts','set','All',null,null,null,6,4,15.00,null),
('Spark Plugs','each','All',null,null,null,23,20,1.50,null),
('Spark Leads','set','All',null,null,null,16,10,12.50,null),
('Distributor Cap','null','Fjord Vehicles',null,null,null,10,5,35.00,null),
('Paint','Arrogant Red','All','litres','Slap-it-on-paints',null,3,2,60.00,null),
('Interior Bulb',null,'Rolls Royce','null','Switch-it-on',null,2,1,118.00,null),
('Motor Oil',null,'All','Gallons',null,null,30,25,25.00,null),
('Oil Filter',null,'All',null,null,null,16,15,10.00,null),
('Air Filter',null,'All',null,null,null,15,10,15.00,null);

INSERT INTO suppliers
(SupplierName,Address,Postcode,Telephone,Notes)
Values
('Fjord Supplies','10 Largeunits, Trade Estate, Reading','RG10 4PT','01895 453 857','Fjord Suppliers can supply any of the parts kept in stock'),
('Halfords',' 1 Enormous Office, Trading Park, Harlesdon, London,','NW10 4UP','0208 333 5555','Halfords can supply everything in stock but Tyre, heavy tread, for Fjord Transit Van and Exhaust, complete box, for Fjord Estate');

INSERT INTO users (AccountHolder, AccountType, Username, Password)
VALUES ('Penelope Carr', 'Receptionist', 'Penelope', 'PinkMobile'),
('Sunny Evans', 'Foreman', 'Sunny', 'Attitude'),
('Glynne Lancaster', 'Franchisee', 'Glynne', 'Gnasher'),
('Administrator Role', 'Administrator', 'SYSDBA', 'Masterkey'),
('Gavin Ross', 'Mechanic', 'Gavin', 'LondonWeight'),
('Anthony Wild', 'Mechanic', 'Anthony', 'MelodyMan');

INSERT INTO customerRecords (customerName, AddressLine1, AddressLine2, AddressLine3, Postcode, Contact, ContactTitle, Telephone, Mobile, Notes, isBusiness)
VALUES ('Transco Gas Supplies','Methane Buildings', 'Sulpher Lane', 'Stenchville, Bucks', 'HP19 2MT', 'Mr Jack Varta', 'Fleet Controller', 01494683725, null, 'Transco have a fleet of vehicles.', TRUE),
('John Doherty', 'Miscellaneous House', 'Unknown Street', 'Whichville, Nowhereshire','MT1 2UP', null, null, '0101 010 0101', '07070 070 707', null, FALSE),
('William Gates','World Domination House','Enormous Street','Richville', 'NW10 4AT', null,null,'020 7477 3333', '0666 666 666', null, FALSE);

INSERT INTO vehicles (NumberPlate, Colour, LastMoT, Make, Model, CustomerID)
VALUES ('AA69 CPG', 'White', '2019-12-05', 'Fjord', 'Transit Van', 1),
('CT70 DWR', 'White', '2020-12-12', 'Fjord', 'Transit Van', 1),
('FF71 GHT', 'White', '2021-02-03', 'Fjord', 'Transit Van', 1),
('VV71 BHN', 'White', '2021-11-19', 'Fjord', 'Transit Van', 1),
('GG14 PUB', 'Green', '2014-01-01', 'Fjord', 'Estate MK8',2),
('BB19 OLE', 'Red', '2019-01-01', 'Rolls Royce', 'Silver Shadow',3);

INSERT INTO discounts (discountType, discountPercentage, flexibleLowRange, flexibleHighRange, CustomerID)
VALUES ('flexible', 1, 0, 1000, 3),
('flexible', 2, 1001, 5000, 3),
('flexible', 3, 5001, 10000, 3);