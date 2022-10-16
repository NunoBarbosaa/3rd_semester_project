
create or replace function fnc_shipAvailability( ts cargoManifest.arrivalDate%type)
return SYS_REFCURSOR
is 
rc SYS_REFCURSOR;
begin 
    open rc for 
            select q1.MMSI
                from (
                select MMSI, arrivalDate
                from cargoManifest
                order by arrivalDate desc
                )q1
               where ts > q1.arrivalDate
             group by MMSI;
return rc;
end;
/
