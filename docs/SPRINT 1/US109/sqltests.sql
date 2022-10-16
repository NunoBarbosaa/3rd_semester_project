INSERT INTO ship_port(identification, port_name, continent ,country ,latitude ,longitude) 
VALUES (6, 'porto','europa','portugal',3.6,6.4);

INSERT INTO ship 
(MMSI,IMO,ship_name,callSign,ship_length,width,ship_capacity,draft,identification)
VALUES (1,2,'algo','algo2',2.4,3.5,6.0,7.5,6);

INSERT INTO shipPositions
(BaseDataTime,latitude,longitude,SOG,COG,ship_Heading,TranscieverClass,shipId,MMSI) 
VALUES ('2000-01-01',456,678,3.78,9.06,3,'algo3',2,1);

INSERT INTO energyGenerator 
(enGen_number,powerOutput,MMSI)
VALUES (7,3.14,1);

INSERT INTO vesselType 
(numericCode,MMSI)
VALUES (6,1);

INSERT INTO ship_Port
(identification,port_name,continent,country,latitude,longitude) 
VALUES (1,'name','Asia','China',41.0,60.0);

INSERT INTO wareHouse 
(wareHouseId,warehouse_name,continent,country,latitude,longitude)
VALUES (-1,'algo7','algo8','algo9',9.9,1.3);

INSERT INTO cargoManifest 
(containerId,containerPos,ContainerGW)
VALUES (20,21,0.6);


INSERT INTO ship_Container (container_number,checkDigit ,xCoord ,yCoord ,zCoord ,payload ,tareWeight,grossWeight ,maxVolume,isoCode,certificate ,repairRec ,wareHouseId,identification ,containerId ,MMSI)
VALUES(99,98,97,96,95,94.1,93.1,92.1,91.1,'cod1','certi1','repairrec1',-1,1,20,1);

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
select * from ship_Port;
select * from ship;
select * from shipPositions;
select * from energyGenerator;
select * from vesselType;
select * from ship_Container;
select * from wareHouse;
select * from cargoManifest;
