DROP TABLE address CASCADE CONSTRAINTS PURGE;
DROP TABLE app_roles CASCADE CONSTRAINTS PURGE;
DROP TABLE app_user CASCADE CONSTRAINTS PURGE;
DROP TABLE ship CASCADE CONSTRAINTS PURGE ;
DROP TABLE shipPositions CASCADE CONSTRAINTS PURGE ;
DROP TABLE energyGenerator CASCADE CONSTRAINTS PURGE ;
DROP TABLE ship_Container CASCADE CONSTRAINTS PURGE ;
DROP TABLE continent CASCADE CONSTRAINTS PURGE;
DROP TABLE wareHouse CASCADE CONSTRAINTS PURGE ;
DROP TABLE ship_Port CASCADE CONSTRAINTS PURGE ;
DROP TABLE trip CASCADE CONSTRAINTS PURGE;
DROP TABLE trip_port CASCADE CONSTRAINTS PURGE;
DROP TABLE container_trip CASCADE CONSTRAINTS PURGE;
DROP TABLE trip_users CASCADE CONSTRAINTS PURGE;
DROP TABLE container_cargo CASCADE CONSTRAINTS PURGE;
DROP TABLE cargoManifest CASCADE CONSTRAINTS PURGE;


CREATE TABLE continent(
continentId int, 
country varchar(255),
continent varchar(255),
CONSTRAINT pk_Continent PRIMARY KEY (continentId)
);

CREATE TABLE address(
addressId int,
description varchar(255),
postalCode varchar(255),
country varchar(255),
CONSTRAINT pk_Address PRIMARY KEY (addressId)
);

CREATE TABLE app_user(
userId int,
username varchar(255) CONSTRAINT un_Username UNIQUE,
password varchar(255),
addressId int,
CONSTRAINT pk_appUser PRIMARY KEY (userId)
);

CREATE TABLE app_roles(
roleId int,
name varchar(255),
CONSTRAINT pk_roleId PRIMARY KEY (roleId)
);

CREATE TABLE ship_Port (
identification int,
port_name varchar(255),
latitude decimal(19,0),
longitude decimal(19,0),
continentId int,
CONSTRAINT pk_port PRIMARY KEY (identification)
);

CREATE TABLE ship (
MMSI int,
IMO varchar(255) CONSTRAINT un_IMO UNIQUE, 
ship_name varchar(255),
callSign varchar(255) CONSTRAINT un_CallSign UNIQUE,
ship_length decimal(19,0) not null,
width decimal(19,0) not null,
draft decimal(19,0),
ship_capacity decimal(19,0) default 0,
vesselType int,
userId int,
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
MMSI int,
CONSTRAINT pk_shipPos PRIMARY KEY(MMSI)
);

CREATE TABLE energyGenerator (
enGen_number int,
powerOutput decimal(19,0) default 0,
MMSI int,
CONSTRAINT pk_EnergyGen PRIMARY KEY (enGen_number,MMSI)
);

CREATE TABLE ship_Container (
containerNumber int,
checkDigit int,
xCoord int,
yCoord int,
zCoord int,
tareWeight decimal not null,
maxVolume decimal not null,
isoCode varchar(255),
certificate varchar(255),
repairRec varchar(255),
refrigerated int,
temp decimal,
wareHouseId int,
identification int,
cargoManifestId int,
MMSI int,
userId int,
CONSTRAINT pk_container PRIMARY KEY(containerNumber)
);

CREATE TABLE wareHouse (
wareHouseId int,
warehouse_name varchar(255),
latitude decimal,
longitude decimal,
continentId int,
CONSTRAINT pk_warehouse PRIMARY KEY (wareHouseId)
);

CREATE TABLE cargoManifest (
cargoManifestId int,
MMSI int,
tripId int,
departureDate date,
arrivalDate date,
CONSTRAINT pk_cargoMan PRIMARY KEY (cargoManifestId)
);

CREATE TABLE container_cargo(
cargoManifestId int,
containerNumber int,
departurePortId int,
arrivalPortId int,
xCoord int,
yCoord int,
zCoord int,
containerDepDate date,
containerArrDate date,
payload int,
grossWeight int,
CONSTRAINT pk_cargo_container PRIMARY KEY (cargoManifestId,containerNumber)
);

CREATE TABLE trip (
tripId int,
MMSI int,
startDate date,
endDate date,
departureLat int,
departureLong int,
arrivalLong int,
arrivalLat int,
CONSTRAINT pk_trip PRIMARY KEY (tripId)
);

CREATE TABLE trip_port(
tripId int,
identification int,
port_order int,
CONSTRAINT pk_trip_port PRIMARY KEY (tripId,identification)
);


CREATE TABLE container_trip(
tripId int,
containerNumber int,
CONSTRAINT pk_container_trip PRIMARY KEY (containerNumber)
);

CREATE TABLE trip_users(
tripId int,
userId int,
CONSTRAINT pk_tripUsers PRIMARY KEY (userId)
);
------------------------------------------------------------------------------------------------------

ALTER TABLE ship_Container 
ADD CONSTRAINT fk_container_ship FOREIGN KEY (MMSI) REFERENCES ship(MMSI);


ALTER TABLE ship_Container 
ADD CONSTRAINT fk_container_port FOREIGN KEY (identification) REFERENCES ship_Port(identification);

ALTER TABLE ship_Container
ADD CONSTRAINT fk_container_warehouse FOREIGN KEY (wareHouseId) REFERENCES wareHouse(wareHouseId);


ALTER TABLE shipPositions 
ADD CONSTRAINT fk_ship_shippos FOREIGN KEY (MMSI) REFERENCES ship(MMSI);


ALTER TABLE energyGenerator 
ADD CONSTRAINT fk_enGen_ship FOREIGN KEY (MMSI) REFERENCES ship(MMSI);

ALTER TABLE trip
ADD CONSTRAINT fk_trip_ship FOREIGN KEY (MMSI) REFERENCES ship(MMSI);

ALTER TABLE CargoManifest 
ADD CONSTRAINT fk_ship_cargoManifest FOREIGN KEY (MMSI) REFERENCES ship(MMSI);

ALTER TABLE trip_port
ADD CONSTRAINT fk_trip_port_trip FOREIGN KEY (tripId) REFERENCES trip(tripId);

ALTER TABLE trip_port
ADD CONSTRAINT fk_trip_port_port FOREIGN KEY (identification) REFERENCES ship_Port(identification);

ALTER TABLE container_trip
ADD CONSTRAINT fk_container_trip_trip FOREIGN KEY (tripId) REFERENCES trip(tripId);

ALTER TABLE container_trip
ADD CONSTRAINT fk_container_trip_container FOREIGN KEY (containerNumber) REFERENCES ship_Container(containerNumber);

ALTER TABLE app_user
ADD CONSTRAINT fk_user_Address FOREIGN KEY (addressId) REFERENCES address(addressId);

ALTER TABLE ship_container
ADD CONSTRAINT fk_user_container FOREIGN KEY (userId) REFERENCES app_user(userId);

ALTER TABLE ship
ADD CONSTRAINT fk_user_ship FOREIGN KEY (userId) REFERENCES app_user(userId);

ALTER TABLE trip_users
ADD CONSTRAINT fk_ship_tripUsers FOREIGN KEY (tripId) REFERENCES trip(tripId);

ALTER TABLE trip_users
ADD CONSTRAINT fk_user_tripUsers FOREIGN KEY (userId) REFERENCES app_user(userId);

ALTER TABLE ship_port 
ADD CONSTRAINT fk_ship_port_continent FOREIGN KEY (continentId) REFERENCES continent(continentId);

ALTER TABLE wareHouse
ADD CONSTRAINT fk_wareHouse_continent FOREIGN KEY (continentId) REFERENCES continent(continentId);

ALTER TABLE cargoManifest
ADD CONSTRAINT fk_trip_cargo FOREIGN KEY (tripId) REFERENCES trip(tripId);

ALTER TABLE container_cargo
ADD CONSTRAINT fk_containerCargo_CargoMan FOREIGN KEY (cargoManifestId) REFERENCES cargoManifest(cargoManifestId);

------------------------------------------------------------------------------------------------------------------------------






