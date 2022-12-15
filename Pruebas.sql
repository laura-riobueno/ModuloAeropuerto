insert into hora (idhora) values (hora);

insert into programavuelo (codlinea,idprograma,idlugar,lug_idlugar,lug_idlugar2,fechacrea) values (aerolinea,novuelo,pais, origen, destino,fechacrea,);
						   
insert into dia (iddia, codlinea, idprograma) values (dia, aerolinea, novuelo);

insert into destino (idhora, codlinea, idprograma) values (hora, aerolinea, novuelo);

insert into vuelo (idvuelo,codlinea,idprograma,placaavion,fecha,plazasvacia) values (novuelo, aerolinea,novuelo,avion,fecha, 
	(select capacidad 
	from modeloavion MA, avion AV
	where MA.idmodelo = AV.idmodelo
	and AV.placaavion = avion));
	
select capacidad 
from modeloavion MA, avion AV
where MA.idmodelo = AV.idmodelo
and AV.placaavion ='101101'

insert into hora (idhora) values ('0530');
insert into programavuelo (codlinea,idprograma,idlugar,lug_idlugar,lug_idlugar2,fechacrea) values ('101','555','1', '28', '29','15/12/2022');
insert into dia (iddia, codlinea, idprograma) values ('1', '101', '555');
insert into destino (idhora, codlinea, idprograma) values ('14', '101', '555');
insert into vuelo (idvuelo,codlinea,idprograma,placaavion,fecha,plazasvacia) values ('555', '101', '555','101101','15/12/2022', 
	(select capacidad 
	from modeloavion MA, avion AV
	where MA.idmodelo = AV.idmodelo
	and AV.placaavion ='101101'));
	
						
select idlugar ||' '|| nomlugar as "paises"
from lugar
where idtipolu = '5' or idtipolu = '6';

select PV.codlinea, PV.idprograma, PV.lug_idlugar,PV.lug_idlugar2, V.fecha, Di.iddia, Ds.idhora
from programavuelo PV, vuelo V, dia DI, destino DS
where PV.idprograma = V.idprograma and PV.idprograma = DI.idprograma and PV.idprograma = DS.idprograma;

select PV.codlinea, PV.idprograma, L1.nomlugar, L2.nomlugar, V.fecha, Di.iddia, Ds.idhora
from programavuelo PV, vuelo V, dia DI, destino DS, lugar L1, lugar L2
where PV.idprograma = V.idprograma and PV.idprograma = DI.idprograma and PV.idprograma = DS.idprograma
	and PV.lug_idlugar = L1.idlugar and PV.lug_idlugar2 = L2.idlugar;

select * from programavuelo;
select * from vuelo;
select * from destino;
select * from hora;

delete from dia where idprograma = '555';

delete from destino  where idprograma = '555';

delete from vuelo where idprograma = '555';

delete from programavuelo where idprograma = '555';

delete from hora where idhora = '1330';

