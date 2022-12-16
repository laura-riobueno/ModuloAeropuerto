--Insertar datos
insert into hora (idhora) values (hora);
insert into programavuelo (codlinea,idprograma,idlugar,lug_idlugar,lug_idlugar2,fechacrea) values (aerolinea,novuelo,pais, origen, destino,fechacrea,);					   
insert into dia (iddia, codlinea, idprograma) values (dia, aerolinea, novuelo);
insert into destino (idhora, codlinea, idprograma) values (hora, aerolinea, novuelo);
insert into vuelo (idvuelo,codlinea,idprograma,placaavion,fecha,plazasvacia) values (novuelo, aerolinea,novuelo,avion,fecha, 
	(select capacidad 
	from modeloavion MA, avion AV
	where MA.idmodelo = AV.idmodelo
	and AV.placaavion = avion));
	
-- Consulta Aeropuertos
select idlugar ||' '|| nomlugar as "aeropuertos"
from lugar
where idtipolu = '5' or idtipolu = '6';

-- Consulta Paises
select idlugar ||' '|| nomlugar as "paises"
from lugar
where idtipolu = '1';

-- Consulta Aerolineas
select * from LineaAerea;

-- Consulta de aviones por aerolinea
select * from avion where codlinea = codLinea;

-- Consulta para crear el reporte
select PV.codlinea, PV.idprograma, L1.nomlugar, L2.nomlugar, V.fecha, Di.iddia, Ds.idhora
from programavuelo PV, vuelo V, dia DI, destino DS, lugar L1, lugar L2
where PV.idprograma = V.idprograma and PV.idprograma = DI.idprograma and PV.idprograma = DS.idprograma
	and PV.lug_idlugar = L1.idlugar and PV.lug_idlugar2 = L2.idlugar;

select * from programavuelo;
select * from vuelo;
select * from destino;
select * from hora;
select * from dias;
select * from avion;
select * from lugar;
select * from tipolugar;
select * from lineaaerea;

delete from dia where idprograma = '485';
delete from destino  where idprograma = '485';
delete from vuelo where idprograma = '485';
delete from programavuelo where idprograma = '485';
delete from hora where idhora = '100';