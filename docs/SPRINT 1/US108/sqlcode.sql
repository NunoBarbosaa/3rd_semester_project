DROP TABLE ship CASCADE CONSTRAINTS PURGE ;
DROP TABLE shipPositions CASCADE CONSTRAINTS PURGE ;
DROP TABLE ship_Port CASCADE CONSTRAINTS PURGE ;
DROP TABLE energyGenerator CASCADE CONSTRAINTS PURGE ;
DROP TABLE vesselType CASCADE CONSTRAINTS PURGE ;
DROP TABLE ship_Container CASCADE CONSTRAINTS PURGE ;
DROP TABLE wareHouse CASCADE CONSTRAINTS PURGE ;
DROP TABLE cargoManifest CASCADE CONSTRAINTS PURGE;




CREATE TABLE ship_Port (
identification int CONSTRAINT pk_port PRIMARY KEY,
port_name varchar(255),
continent varchar(255),
country varchar(255),
latitude decimal(19,0),
longitude decimal(19,0)
);

CREATE TABLE ship (
MMSI integer,
IMO integeR CONSTRAINT un_IMO UNIQUE, 
ship_name varchar(255),
callSign varchar(255) CONSTRAINT un_CallSign UNIQUE,
ship_length decimal(19,0) not null,
width decimal(19,0) not null,
ship_capacity decimal(19,0) default 0,
draft decimal(19,0),
identification int,
CONSTRAINT pk_ship PRIMARY KEY (MMSI)
);

CREATE TABLE shipPositions (
BaseDataTime date,
latitude number(7,2),
longitude number(7,2),
SOG float default 0,
COG float default 0,
ship_Heading int,
TranscieverClass varchar(255),
shipId int,
MMSI int,
CONSTRAINT pk_shipPos PRIMARY KEY(shipId)
);

CREATE TABLE energyGenerator (
enGen_number int,
powerOutput decimal(19,0) default 0,
MMSI int,
CONSTRAINT pk_EnergyGen PRIMARY KEY (enGen_number)
);

CREATE TABLE vesselType (
numericCode int,
MMSI int
);

CREATE TABLE ship_Container (
container_number int,
checkDigit int,
xCoord int,
yCoord int,
zCoord int,
payload decimal,
tareWeight decimal not null,
grossWeight decimal not null,
maxVolume decimal not null,
isoCode varchar(255),
certificate varchar(255),
repairRec varchar(255),
wareHouseId int,
identification int,
containerId int,
MMSI int
);

CREATE TABLE wareHouse (
wareHouseId int,
warehouse_name varchar(255),
continent varchar(255)not null,
country varchar(255)not null,
latitude decimal,
longitude decimal,
CONSTRAINT pk_warehouse PRIMARY KEY (wareHouseId)
);

CREATE TABLE cargoManifest (
containerId int,
containerPos int,
ContainerGW decimal,
CONSTRAINT pk_cargoMan PRIMARY KEY (containerID)
);


ALTER TABLE ship 
ADD CONSTRAINT fk_ship_port  FOREIGN KEY (identification) REFERENCES ship_Port(identification);

ALTER TABLE ship_Container 
ADD CONSTRAINT fk_container_ship FOREIGN KEY (MMSI) REFERENCES ship(MMSI);

ALTER TABLE ship_Container 
ADD CONSTRAINT pk_container PRIMARY KEY(container_number);

ALTER TABLE ship_Container 
ADD CONSTRAINT fk_container_port FOREIGN KEY (identification) REFERENCES ship_Port(identification);

ALTER TABLE ship_Container
ADD CONSTRAINT fk_container_warehouse FOREIGN KEY (wareHouseId) REFERENCES wareHouse(wareHouseId);


ALTER TABLE shipPositions 
ADD CONSTRAINT fk_ship_shippos FOREIGN KEY (MMSI) REFERENCES ship(MMSI);


ALTER TABLE energyGenerator 
ADD CONSTRAINT fk_enGen_ship FOREIGN KEY (MMSI) REFERENCES ship(MMSI);

ALTER TABLE vesselType
ADD CONSTRAINT fk_vesselType_ship FOREIGN KEY (MMSI) REFERENCES ship(MMSI);






