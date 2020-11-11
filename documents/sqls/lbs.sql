
set global log_bin_trust_function_creators=1;

drop function getDistance;
DELIMITER $$  
CREATE DEFINER=`root`@`localhost` FUNCTION `getDistance`(
     lon1 float(10,7) 
    ,lat1 float(10,7)
    ,lon2 float(10,7) 
    ,lat2 float(10,7)
) RETURNS double
begin
    declare d double;
    declare radius int;
    set radius = 6378140; #假设地球为正球形，直径为6378140米
    set d = (2*ATAN2(SQRT(SIN((lat1-lat2)*PI()/180/2)   
        *SIN((lat1-lat2)*PI()/180/2)+   
        COS(lat2*PI()/180)*COS(lat1*PI()/180)   
        *SIN((lon1-lon2)*PI()/180/2)   
        *SIN((lon1-lon2)*PI()/180/2)),   
        SQRT(1-SIN((lat1-lat2)*PI()/180/2)   
        *SIN((lat1-lat2)*PI()/180/2)   
        +COS(lat2*PI()/180)*COS(lat1*PI()/180)   
        *SIN((lon1-lon2)*PI()/180/2)   
        *SIN((lon1-lon2)*PI()/180/2))))*radius;
    return d;
end