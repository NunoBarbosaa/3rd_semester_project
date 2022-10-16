--This worksheet as forced input in the function content so we can test their output--

--US204 function test--
--This is the row input--
--INSERT INTO container_cargo(containerNumber, cargoManifestId, arrivalportId,departureportId, xCoord,yCoord,zCoord,containerDepDate, containerArrDate,payload,grossWeight) VALUES('5773',1,6,8,6,3,8,TO_TIMESTAMP('2015-09-10 04:22','YYYY-MM-DD HH:MI'),TO_TIMESTAMP('2015-10-17 04:22','YYYY-MM-DD HH:MI'),240,1000);--

SELECT
    CASE
        WHEN q1.container_position = 'in_arrival_port' OR q1.container_position = 'in_departure_port' THEN 'PORT'
        ELSE 'SHIP'
    END AS position_type,
    CASE
        WHEN q1.container_position = 'in_arrival_port' 
        THEN ( 
            SELECT sp.port_name FROM container_cargo cc
            INNER JOIN ship_PORT sp ON (sp.identification = cc.arrivalportId)
            WHERE cc.containerNumber = 5773
        )
        WHEN container_position = 'in_departure_port'
        THEN ( 
            SELECT sp.port_name FROM container_cargo cc
            INNER JOIN ship_PORT sp ON (sp.identification = cc.departureportId)
            WHERE cc.containerNumber = 5773
        )
        ELSE ( 
            SELECT sh.ship_name FROM container_cargo cc
            INNER JOIN ship_PORT sp ON (sp.identification = cc.departureportId)
            INNER JOIN CARGOMANIFEST cm ON (cc.cargoManifestId = cm.cargoManifestId) 
            INNER JOIN ship sh ON (cm.MMSI = sh.MMSI) 
            WHERE cc.containerNumber = 5773
        )
    END AS position_name
    FROM (
        SELECT
            CASE
                WHEN current_timestamp >= cc.containerArrDate THEN 'in_arrival_port'
                WHEN current_timestamp <= cc.containerDepDate THEN 'in_departure_port'
                ELSE 'in_the_ship'
            END AS container_position
        FROM container_cargo cc
        WHERE cc.containerNumber = 5773
    ) q1;
    
   ------------------------------------------------------------------------
   
--This is the test for US208 function--
--this is the row Insert--
--INSERT INTO CARGOMANIFEST(cargoManifestId, tripId, MMSI, departureDate, ArrivalDate) VALUES (1,1,1234498,TO_TIMESTAMP('2015-09-10 04:22','YYYY-MM-DD HH:MI'),TO_TIMESTAMP('2015-09-11 04:22','YYYY-MM-DD HH:MI'));--

   select 
            MMSI, 
            ship_capacity, 
            trunc(
            (
                select (count(1) * 40.918)/ship_capacity*100
                from container_cargo
                where cargoManifestId = 1
            ),1) as occupancyRate
        from ship
        where MMSI = 1234498;
   ---------------------------------------------------------------------------
   --This is the test for US209--
   --this is the row insert--
   --INSERT INTO CARGOMANIFEST(cargoManifestId, tripId, MMSI, departureDate, ArrivalDate) VALUES (2,1,1234498,TO_TIMESTAMP('2015-09-15 04:22','YYYY-MM-DD HH:MI'),TO_TIMESTAMP('2015-09-16 04:22','YYYY-MM-DD HH:MI'));--
   
         select MMSI,ship_capacity,
        trunc(
            (
                select (count(*)*40.918)/ship_capacity*100
                from container_cargo
                where cargoManifestId = (
                    select cargoManifestId 
                    from cargoManifest c 
                    where (
                        MMSI =  1234498 AND TO_TIMESTAMP('2015-09-15 04:22','YYYY-MM-DD HH:MI') > c.departureDate AND TO_TIMESTAMP('2015-09-15 04:22','YYYY-MM-DD HH:MI') < c.arrivalDate
                    )
                ) 
            ), 1
        ) as occupancyRate
        from ship
        where MMSI = 1234498;
    
--------------------------------------------------------------------------
--This is the test for us210 function--
--Inputed longest date--
 select q1.MMSI
                from (
                select MMSI, arrivalDate
                from cargoManifest
                order by arrivalDate desc
                )q1
               where to_timestamp('2030-09-15 04:22','YYYY-MM-DD HH:MI') > q1.arrivalDate
             group by MMSI;