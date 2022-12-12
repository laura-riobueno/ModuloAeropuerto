
insert into tipolugar (idtipolu,desctipolugar) values ('1','País');
insert into tipolugar (idtipolu,desctipolugar) values ('2','Departamento');
insert into tipolugar (idtipolu,desctipolugar) values ('3','Municipio');
insert into tipolugar (idtipolu,desctipolugar) values ('4','Ciudad');
insert into tipolugar (idtipolu,desctipolugar) values ('5','Aeropuerto Internacional');
insert into tipolugar (idtipolu,desctipolugar) values ('6','Aeropuerto Nacional');

insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('1','1',null,'Colombia');

insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('2','2','1','Quindío');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('3','2','1','Atlántico');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('4','2','1','Distrito Capital');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('5','2','1','Santander');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('6','2','1','Valle Del Cauca');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('7','2','1','Bolívar');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('8','2','1','Norte de Santander');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('9','2','1','Amazonas');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('10','2','1','Antioquia');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('11','2','1','Risaralda');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('12','2','1','La Guajira');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('13','2','1','San Andrés y Providencia');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('14','2','1','Magdalena');

insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('15','3','2','La Tebaida');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('16','3','3','Soledad');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('17','3','4','Bogotá');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('18','3','5','Lebrija');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('19','3','6','Palmira');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('20','3','7','Cartagena');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('21','3','8','Cúcuta');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('22','3','9','Leticia');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('23','3','10','Rionegro');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('24','3','11','Pereira');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('25','3','12','Riohacha');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('26','3','13','San Andrés');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('27','3','14','Santa Marta');

insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('AXM-SKAR','5','15','El Edén');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('BAQ-SKBQ','5','16','Ernesto Cortissoz');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('BOG-SKBO','5','17','El Dorado');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('BGA-SKBG','5','18','Palonegro');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('CLO-SKCL','5','19','Alfonso Bonilla Aragón');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('CTG-SKCG','5','20','Rafael Nuñez');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('CUC-SKCC','5','21','Camilo Daza');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('LET-SKLT','5','22','Alfredo Vásquez Cobo');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('MDE-SKRG','5','23','José María Córdova');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('PEI-SKPE','5','24','Matecaña');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('RCH-SKRH','5','25','Almirante Padilla');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('ADZ-SKSP','5','26','Gistavo Rojas Pinilla');
insert into lugar (idlugar,idtipolu,lug_idlugar,nomlugar) values ('SMR-SKSM','5','27','Simón Bolívar');

insert into dia (iddia,anomdia) values ('1','Lunes');
insert into dia (iddia,anomdia) values ('2','Martes');
insert into dia (iddia,anomdia) values ('3','Miercoles');
insert into dia (iddia,anomdia) values ('4','Jueves');
insert into dia (iddia,anomdia) values ('5','Viernes');
insert into dia (iddia,anomdia) values ('6','Sábado');
insert into dia (iddia,anomdia) values ('7','Domingo');

insert into lineaaerea (codlinea,nomlinea) values ('101','Avianca');
insert into lineaaerea (codlinea,nomlinea) values ('102','Latam');
insert into lineaaerea (codlinea,nomlinea) values ('103','Viva Air Colombia');
insert into lineaaerea (codlinea,nomlinea) values ('104','Wingo');

insert into modeloavion (idmodelo, capacidad) values ('Boeing757', '289');
insert into modeloavion (idmodelo, capacidad) values ('AirbusA3030', '252');
insert into modeloavion (idmodelo, capacidad) values ('AirbusA321', '194');
insert into modeloavion (idmodelo, capacidad) values ('AirbusA320', '143');
insert into modeloavion (idmodelo, capacidad) values ('AirbusA319', '120');
insert into modeloavion (idmodelo, capacidad) values ('ATR-72', '68');
insert into modeloavion (idmodelo, capacidad) values ('Boeing787-9', '304');
insert into modeloavion (idmodelo, capacidad) values ('Boeing787-8', '247');
insert into modeloavion (idmodelo, capacidad) values ('Boeing767', '238');
insert into modeloavion (idmodelo, capacidad) values ('Boeing777', '410');
insert into modeloavion (idmodelo, capacidad) values ('AirbusB320', '339');
insert into modeloavion (idmodelo, capacidad) values ('AirbusB321', '224');
insert into modeloavion (idmodelo, capacidad) values ('AirbusB322', '180');
insert into modeloavion (idmodelo, capacidad) values ('AirbusB323', '144');


insert into avion (placaavion, codlinea, idmodelo) values ('101101', '101','Boeing757');

insert into avion (placaavion, codlinea, idmodelo) values ('101201', '101','AirbusA3030');
insert into avion (placaavion, codlinea, idmodelo) values ('101202', '101','AirbusA3030');
insert into avion (placaavion, codlinea, idmodelo) values ('101203', '101','AirbusA3030');

insert into avion (placaavion, codlinea, idmodelo) values ('101301', '101','AirbusA321');
insert into avion (placaavion, codlinea, idmodelo) values ('101302', '101','AirbusA321');
insert into avion (placaavion, codlinea, idmodelo) values ('101303', '101','AirbusA321');
insert into avion (placaavion, codlinea, idmodelo) values ('101304', '101','AirbusA321');
insert into avion (placaavion, codlinea, idmodelo) values ('101305', '101','AirbusA321');
insert into avion (placaavion, codlinea, idmodelo) values ('101306', '101','AirbusA321');
insert into avion (placaavion, codlinea, idmodelo) values ('101307', '101','AirbusA321');

insert into avion (placaavion, codlinea, idmodelo) values ('101401', '101','AirbusA320');
insert into avion (placaavion, codlinea, idmodelo) values ('101402', '101','AirbusA320');
insert into avion (placaavion, codlinea, idmodelo) values ('101403', '101','AirbusA320');
insert into avion (placaavion, codlinea, idmodelo) values ('101404', '101','AirbusA320');

insert into avion (placaavion, codlinea, idmodelo) values ('101501', '101','AirbusA319');
insert into avion (placaavion, codlinea, idmodelo) values ('101502', '101','AirbusA319');

insert into avion (placaavion, codlinea, idmodelo) values ('101601', '101','ATR-72');
insert into avion (placaavion, codlinea, idmodelo) values ('101602', '101','ATR-72');
insert into avion (placaavion, codlinea, idmodelo) values ('101603', '101','ATR-72');
insert into avion (placaavion, codlinea, idmodelo) values ('101604', '101','ATR-72');
insert into avion (placaavion, codlinea, idmodelo) values ('101605', '101','ATR-72');
insert into avion (placaavion, codlinea, idmodelo) values ('101606', '101','ATR-72');

insert into avion (placaavion, codlinea, idmodelo) values ('102101', '102','Boeing787-9');

insert into avion (placaavion, codlinea, idmodelo) values ('102201', '102','Boeing787-8');
insert into avion (placaavion, codlinea, idmodelo) values ('102202', '102','Boeing787-8');
insert into avion (placaavion, codlinea, idmodelo) values ('102203', '102','Boeing787-8');
insert into avion (placaavion, codlinea, idmodelo) values ('102204', '102','Boeing787-8');
insert into avion (placaavion, codlinea, idmodelo) values ('102205', '102','Boeing787-8');
insert into avion (placaavion, codlinea, idmodelo) values ('102206', '102','Boeing787-8');
insert into avion (placaavion, codlinea, idmodelo) values ('102207', '102','Boeing787-8');
insert into avion (placaavion, codlinea, idmodelo) values ('102208', '102','Boeing787-8');

insert into avion (placaavion, codlinea, idmodelo) values ('102301', '102','Boeing767');
insert into avion (placaavion, codlinea, idmodelo) values ('102302', '102','Boeing767');

insert into avion (placaavion, codlinea, idmodelo) values ('102401', '102','Boeing777');
insert into avion (placaavion, codlinea, idmodelo) values ('102402', '102','Boeing777');
insert into avion (placaavion, codlinea, idmodelo) values ('102403', '102','Boeing777');

insert into avion (placaavion, codlinea, idmodelo) values ('102501', '102','AirbusB320');
insert into avion (placaavion, codlinea, idmodelo) values ('102502', '102','AirbusB320');
insert into avion (placaavion, codlinea, idmodelo) values ('102503', '102','AirbusB320');
insert into avion (placaavion, codlinea, idmodelo) values ('102504', '102','AirbusB320');

insert into avion (placaavion, codlinea, idmodelo) values ('102601', '102','AirbusB321');
insert into avion (placaavion, codlinea, idmodelo) values ('102602', '102','AirbusB321');
insert into avion (placaavion, codlinea, idmodelo) values ('102603', '102','AirbusB321');
insert into avion (placaavion, codlinea, idmodelo) values ('102604', '102','AirbusB321');
insert into avion (placaavion, codlinea, idmodelo) values ('102605', '102','AirbusB321');

insert into avion (placaavion, codlinea, idmodelo) values ('102701', '102','AirbusB322');
insert into avion (placaavion, codlinea, idmodelo) values ('102702', '102','AirbusB322');

insert into avion (placaavion, codlinea, idmodelo) values ('102801', '102','AirbusB323');
insert into avion (placaavion, codlinea, idmodelo) values ('102802', '102','AirbusB323');
insert into avion (placaavion, codlinea, idmodelo) values ('102803', '102','AirbusB323');
insert into avion (placaavion, codlinea, idmodelo) values ('102804', '102','AirbusB323');
insert into avion (placaavion, codlinea, idmodelo) values ('102805', '102','AirbusB323');
insert into avion (placaavion, codlinea, idmodelo) values ('102806', '102','AirbusB323');
insert into avion (placaavion, codlinea, idmodelo) values ('102807', '102','AirbusB323');
insert into avion (placaavion, codlinea, idmodelo) values ('102808', '102','AirbusB323');
insert into avion (placaavion, codlinea, idmodelo) values ('102809', '102','AirbusB323');
insert into avion (placaavion, codlinea, idmodelo) values ('102810', '102','AirbusB323');
insert into avion (placaavion, codlinea, idmodelo) values ('102811', '102','AirbusB323');
insert into avion (placaavion, codlinea, idmodelo) values ('102812', '102','AirbusB323');
