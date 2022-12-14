/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     25/11/2022 04:38:51 p. m.                    */
/*==============================================================*/


drop index if exists ACCION_PK;

drop table if exists ACCION;

drop index if exists RELATIONSHIP_15_FK;

drop index if exists AVION_PK;

drop table if exists AVION;

drop index if exists DESTINO2_FK;

drop index if exists DESTINO_FK;

drop index if exists DESTINO_PK;

drop table if exists DESTINO;

drop index if exists DIA2_FK;

drop index if exists DIA_FK;

drop index if exists DIA_PK;

drop table if exists DIA;

drop index if exists DIAS_PK;

drop table if exists DIAS;

drop index if exists RELATIONSHIP_14_FK;

drop index if exists RELATIONSHIP_13_FK;

drop index if exists AEROPUERTO_FK;

drop index if exists ESCALA_PK;

drop table if exists ESCALA;

drop index if exists RELATIONSHIP_26_FK;

drop index if exists RELATIONSHIP_11_FK;

drop index if exists ATERRIZAR_DESPEGAR_FK;

drop index if exists RELACION_FK;

drop index if exists EVENTOPISTA_PK;

drop table if exists EVENTOPISTA;

drop index if exists HORA_PK;

drop table if exists HORA;

drop index if exists LINEAAEREA_PK;

drop table if exists LINEAAEREA;

drop index if exists RELACIONN_FK;

drop index if exists S_FK;

drop index if exists LUGAR_PK;

drop table if exists LUGAR;

drop index if exists MODELOAVION_PK;

drop table if exists MODELOAVION;

drop index if exists SUBIR_BAJAR_FK;

drop index if exists RELATIONSHIP_22_FK;

drop index if exists RELATIONSHIP_20_FK;

drop index if exists RELATIONSHIP_19_FK;

drop index if exists OCUPACION_PK;

drop table if exists OCUPACION;

drop index if exists NACIONALIDAD_FK;

drop index if exists PASAJERO_PK;

drop table if exists PASAJERO;

drop index if exists AEORPUERTO_FK;

drop index if exists PISTA_PK;

drop table if exists PISTA;

drop index if exists RELATIONSHIP_31_FK;

drop index if exists RELATIONSHIP_30_FK;

drop index if exists RELATIONSHIP_29_FK;

drop index if exists RELATIONSHIP_28_FK;

drop index if exists RELATIONSHIP_27_FK;

drop index if exists LINEA_FK;

drop index if exists RELATIONSHIP_10_FK;

drop index if exists RELATIONSHIP_9_FK;

drop index if exists RELATIONSHIP_8_FK;

drop index if exists PROGRAMAVUELO_PK;

drop table if exists PROGRAMAVUELO;

drop index if exists RELATIONSHIP_21_FK;

drop index if exists RELATIONSHIP_18_FK;

drop index if exists SILLA_PK;

drop table if exists SILLA;

drop index if exists TIPOESCALA_PK;

drop table if exists TIPOESCALA;

drop index if exists TIPOEVENTO_PK;

drop table if exists TIPOEVENTO;

drop index if exists TIPOLUGAR_PK;

drop table if exists TIPOLUGAR;

drop index if exists RELATIONSHIP_17_FK;

drop index if exists PROGRAMA_FK;

drop index if exists VUELO_PK;

drop table if exists VUELO;

/*==============================================================*/
/* Table: ACCION                                                */
/*==============================================================*/
create table ACCION (
   IDACCION             VARCHAR(2)           not null,
   DESCACCION           VARCHAR(10)          not null,
   constraint PK_ACCION primary key (IDACCION)
);

/*==============================================================*/
/* Index: ACCION_PK                                             */
/*==============================================================*/
create unique index ACCION_PK on ACCION (
IDACCION
);

/*==============================================================*/
/* Table: AVION                                                 */
/*==============================================================*/
create table AVION (
   PLACAAVION           VARCHAR(6)           not null,
   IDMODELO             VARCHAR(3)           not null,
   CODLINEA				VARCHAR(3)			 not null,
   constraint PK_AVION primary key (PLACAAVION)
);

/*==============================================================*/
/* Index: AVION_PK                                              */
/*==============================================================*/
create unique index AVION_PK on AVION (
PLACAAVION
);

/*==============================================================*/
/* Index: RELATIONSHIP_15_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_15_FK on AVION (
IDMODELO
);

/*==============================================================*/
/* Index: RELATIONSHIP_16_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_16_FK on AVION (
CODLINEA
);

/*==============================================================*/
/* Table: DESTINO                                               */
/*==============================================================*/
create table DESTINO (
   IDHORA               NUMERIC(12)          not null,
   CODLINEA             VARCHAR(3)           not null,
   IDPROGRAMA           NUMERIC(5,0)         not null,
   constraint PK_DESTINO primary key (IDHORA, CODLINEA, IDPROGRAMA)
);

/*==============================================================*/
/* Index: DESTINO_PK                                            */
/*==============================================================*/
create unique index DESTINO_PK on DESTINO (
IDHORA,
CODLINEA,
IDPROGRAMA
);

/*==============================================================*/
/* Index: DESTINO_FK                                            */
/*==============================================================*/
create  index DESTINO_FK on DESTINO (
IDHORA
);

/*==============================================================*/
/* Index: DESTINO2_FK                                           */
/*==============================================================*/
create  index DESTINO2_FK on DESTINO (
CODLINEA,
IDPROGRAMA
);

/*==============================================================*/
/* Table: DIA                                                   */
/*==============================================================*/
create table DIA (
   IDDIA                VARCHAR(1)           not null,
   CODLINEA             VARCHAR(3)           not null,
   IDPROGRAMA           NUMERIC(5,0)         not null,
   constraint PK_DIA primary key (IDDIA, CODLINEA, IDPROGRAMA)
);

/*==============================================================*/
/* Index: DIA_PK                                                */
/*==============================================================*/
create unique index DIA_PK on DIA (
IDDIA,
CODLINEA,
IDPROGRAMA
);

/*==============================================================*/
/* Index: DIA_FK                                                */
/*==============================================================*/
create  index DIA_FK on DIA (
IDDIA
);

/*==============================================================*/
/* Index: DIA2_FK                                               */
/*==============================================================*/
create  index DIA2_FK on DIA (
CODLINEA,
IDPROGRAMA
);

/*==============================================================*/
/* Table: DIAS                                                  */
/*==============================================================*/
create table DIAS (
   IDDIA                VARCHAR(1)           not null,
   NOMDIA               VARCHAR(12)          not null,
   constraint PK_DIAS primary key (IDDIA)
);

/*==============================================================*/
/* Index: DIAS_PK                                               */
/*==============================================================*/
create unique index DIAS_PK on DIAS (
IDDIA
);

/*==============================================================*/
/* Table: ESCALA                                                */
/*==============================================================*/
create table ESCALA (
   CODLINEA             VARCHAR(3)           not null,
   IDPROGRAMA           NUMERIC(5,0)         not null,
   CONSCEC              NUMERIC(2,0)         not null,
   IDTIPOESCALA         VARCHAR(1)           not null,
   IDLUGAR              VARCHAR(5)           not null,
   constraint PK_ESCALA primary key (CODLINEA, IDPROGRAMA, CONSCEC)
);

/*==============================================================*/
/* Index: ESCALA_PK                                             */
/*==============================================================*/
create unique index ESCALA_PK on ESCALA (
CODLINEA,
IDPROGRAMA,
CONSCEC
);

/*==============================================================*/
/* Index: AEROPUERTO_FK                                         */
/*==============================================================*/
create  index AEROPUERTO_FK on ESCALA (
IDLUGAR
);

/*==============================================================*/
/* Index: RELATIONSHIP_13_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_13_FK on ESCALA (
CODLINEA,
IDPROGRAMA
);

/*==============================================================*/
/* Index: RELATIONSHIP_14_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_14_FK on ESCALA (
IDTIPOESCALA
);

/*==============================================================*/
/* Table: EVENTOPISTA                                           */
/*==============================================================*/
create table EVENTOPISTA (
   CONSCECEVENTO        NUMERIC(4,0)         not null,
   IDVUELO              VARCHAR(6)           not null,
   IDTIPOEVENTO         VARCHAR(1)           not null,
   CODLINEA             VARCHAR(3)           null,
   IDPROGRAMA           NUMERIC(5,0)         null,
   IDLUGAR              VARCHAR(5)           not null,
   NUMPISTA             NUMERIC(2,0)         not null,
   FECHAEVENTO          DATE                 null,
   HORAEVENTO           TIME                 null,
   constraint PK_EVENTOPISTA primary key (CONSCECEVENTO)
);

/*==============================================================*/
/* Index: EVENTOPISTA_PK                                        */
/*==============================================================*/
create unique index EVENTOPISTA_PK on EVENTOPISTA (
CONSCECEVENTO
);

/*==============================================================*/
/* Index: RELACION_FK                                           */
/*==============================================================*/
create  index RELACION_FK on EVENTOPISTA (
IDLUGAR,
NUMPISTA
);

/*==============================================================*/
/* Index: ATERRIZAR_DESPEGAR_FK                                 */
/*==============================================================*/
create  index ATERRIZAR_DESPEGAR_FK on EVENTOPISTA (
IDTIPOEVENTO
);

/*==============================================================*/
/* Index: RELATIONSHIP_11_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_11_FK on EVENTOPISTA (
CODLINEA,
IDPROGRAMA
);

/*==============================================================*/
/* Index: RELATIONSHIP_26_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_26_FK on EVENTOPISTA (
IDVUELO
);

/*==============================================================*/
/* Table: HORA                                                  */
/*==============================================================*/
create table HORA (
   IDHORA               NUMERIC(12)          not null,
   constraint PK_HORA primary key (IDHORA)
);

/*==============================================================*/
/* Index: HORA_PK                                               */
/*==============================================================*/
create unique index HORA_PK on HORA (
IDHORA
);

/*==============================================================*/
/* Table: LINEAAEREA                                            */
/*==============================================================*/
create table LINEAAEREA (
   CODLINEA             VARCHAR(3)           not null,
   NOMBRELINEA          VARCHAR(30)          not null,
   constraint PK_LINEAAEREA primary key (CODLINEA)
);

/*==============================================================*/
/* Index: LINEAAEREA_PK                                         */
/*==============================================================*/
create unique index LINEAAEREA_PK on LINEAAEREA (
CODLINEA
);

/*==============================================================*/
/* Table: LUGAR                                                 */
/*==============================================================*/
create table LUGAR (
   IDLUGAR              VARCHAR(5)           not null,
   LUG_IDLUGAR          VARCHAR(5)           null,
   IDTIPOLU             VARCHAR(3)           not null,
   NOMLUGAR             VARCHAR(30)          not null,
   constraint PK_LUGAR primary key (IDLUGAR)
);

/*==============================================================*/
/* Index: LUGAR_PK                                              */
/*==============================================================*/
create unique index LUGAR_PK on LUGAR (
IDLUGAR
);

/*==============================================================*/
/* Index: S_FK                                                  */
/*==============================================================*/
create  index S_FK on LUGAR (
IDTIPOLU
);

/*==============================================================*/
/* Index: RELACIONN_FK                                          */
/*==============================================================*/
create  index RELACIONN_FK on LUGAR (
LUG_IDLUGAR
);

/*==============================================================*/
/* Table: MODELOAVION                                           */
/*==============================================================*/
create table MODELOAVION (
   IDMODELO             VARCHAR(3)           not null,
   CAPACIDAD            NUMERIC(5,0)         not null,
   constraint PK_MODELOAVION primary key (IDMODELO)
);

/*==============================================================*/
/* Index: MODELOAVION_PK                                        */
/*==============================================================*/
create unique index MODELOAVION_PK on MODELOAVION (
IDMODELO
);

/*==============================================================*/
/* Table: OCUPACION                                             */
/*==============================================================*/
create table OCUPACION (
   CONSOCUPA            NUMERIC(5)           not null,
   CODLINEA             VARCHAR(3)           not null,
   IDPROGRAMA           NUMERIC(5,0)         not null,
   CONSCEC              NUMERIC(2,0)         not null,
   PLACAAVION           VARCHAR(6)           not null,
   IDSILLA              VARCHAR(4)           not null,
   IDACCION             VARCHAR(2)           not null,
   NDOCUMENTO           VARCHAR(15)          not null,
   constraint PK_OCUPACION primary key (CONSOCUPA)
);

/*==============================================================*/
/* Index: OCUPACION_PK                                          */
/*==============================================================*/
create unique index OCUPACION_PK on OCUPACION (
CONSOCUPA
);

/*==============================================================*/
/* Index: RELATIONSHIP_19_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_19_FK on OCUPACION (
CODLINEA,
IDPROGRAMA,
CONSCEC
);

/*==============================================================*/
/* Index: RELATIONSHIP_20_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_20_FK on OCUPACION (
PLACAAVION,
IDSILLA
);

/*==============================================================*/
/* Index: RELATIONSHIP_22_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_22_FK on OCUPACION (
NDOCUMENTO
);

/*==============================================================*/
/* Index: SUBIR_BAJAR_FK                                        */
/*==============================================================*/
create  index SUBIR_BAJAR_FK on OCUPACION (
IDACCION
);

/*==============================================================*/
/* Table: PASAJERO                                              */
/*==============================================================*/
create table PASAJERO (
   NDOCUMENTO           VARCHAR(15)          not null,
   IDLUGAR              VARCHAR(5)           not null,
   NOMBRE               VARCHAR(20)          not null,
   APELLIDO             VARCHAR(20)          not null,
   FECHANACIMIENTO      DATE                 not null,
   constraint PK_PASAJERO primary key (NDOCUMENTO)
);

/*==============================================================*/
/* Index: PASAJERO_PK                                           */
/*==============================================================*/
create unique index PASAJERO_PK on PASAJERO (
NDOCUMENTO
);

/*==============================================================*/
/* Index: NACIONALIDAD_FK                                       */
/*==============================================================*/
create  index NACIONALIDAD_FK on PASAJERO (
IDLUGAR
);

/*==============================================================*/
/* Table: PISTA                                                 */
/*==============================================================*/
create table PISTA (
   IDLUGAR              VARCHAR(5)           not null,
   NUMPISTA             NUMERIC(2,0)         not null,
   constraint PK_PISTA primary key (IDLUGAR, NUMPISTA)
);

/*==============================================================*/
/* Index: PISTA_PK                                              */
/*==============================================================*/
create unique index PISTA_PK on PISTA (
IDLUGAR,
NUMPISTA
);

/*==============================================================*/
/* Index: AEORPUERTO_FK                                         */
/*==============================================================*/
create  index AEORPUERTO_FK on PISTA (
IDLUGAR
);

/*==============================================================*/
/* Table: PROGRAMAVUELO                                         */
/*==============================================================*/
create table PROGRAMAVUELO (
   CODLINEA             VARCHAR(3)           not null,
   IDPROGRAMA           NUMERIC(5,0)         not null,
   IDLUGAR              VARCHAR(5)           not null,
   LUG_IDLUGAR          VARCHAR(5)           not null,
   LUG_IDLUGAR2         VARCHAR(5)           not null,
   LUG_IDLUGAR3         VARCHAR(5)           not null,
   LUG_IDLUGAR4         VARCHAR(5)           not null,
   LUG_IDLUGAR5         VARCHAR(5)           not null,
   LUG_IDLUGAR6         VARCHAR(5)           not null,
   LUG_IDLUGAR7         VARCHAR(5)           not null,
   FECHACREA            DATE                 not null,
   constraint PK_PROGRAMAVUELO primary key (CODLINEA, IDPROGRAMA)
);

/*==============================================================*/
/* Index: PROGRAMAVUELO_PK                                      */
/*==============================================================*/
create unique index PROGRAMAVUELO_PK on PROGRAMAVUELO (
CODLINEA,
IDPROGRAMA
);

/*==============================================================*/
/* Index: RELATIONSHIP_8_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_8_FK on PROGRAMAVUELO (
LUG_IDLUGAR7
);

/*==============================================================*/
/* Index: RELATIONSHIP_9_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_9_FK on PROGRAMAVUELO (
LUG_IDLUGAR5
);

/*==============================================================*/
/* Index: RELATIONSHIP_10_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_10_FK on PROGRAMAVUELO (
IDLUGAR
);

/*==============================================================*/
/* Index: LINEA_FK                                              */
/*==============================================================*/
create  index LINEA_FK on PROGRAMAVUELO (
CODLINEA
);

/*==============================================================*/
/* Index: RELATIONSHIP_27_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_27_FK on PROGRAMAVUELO (
LUG_IDLUGAR
);

/*==============================================================*/
/* Index: RELATIONSHIP_28_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_28_FK on PROGRAMAVUELO (
LUG_IDLUGAR4
);

/*==============================================================*/
/* Index: RELATIONSHIP_29_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_29_FK on PROGRAMAVUELO (
LUG_IDLUGAR3
);

/*==============================================================*/
/* Index: RELATIONSHIP_30_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_30_FK on PROGRAMAVUELO (
LUG_IDLUGAR2
);

/*==============================================================*/
/* Index: RELATIONSHIP_31_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_31_FK on PROGRAMAVUELO (
LUG_IDLUGAR6
);

/*==============================================================*/
/* Table: SILLA                                                 */
/*==============================================================*/
create table SILLA (
   PLACAAVION           VARCHAR(6)           not null,
   IDSILLA              VARCHAR(4)           not null,
   IDACCION             VARCHAR(2)           not null,
   constraint PK_SILLA primary key (PLACAAVION, IDSILLA)
);

/*==============================================================*/
/* Index: SILLA_PK                                              */
/*==============================================================*/
create unique index SILLA_PK on SILLA (
PLACAAVION,
IDSILLA
);

/*==============================================================*/
/* Index: RELATIONSHIP_18_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_18_FK on SILLA (
PLACAAVION
);

/*==============================================================*/
/* Index: RELATIONSHIP_21_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_21_FK on SILLA (
IDACCION
);

/*==============================================================*/
/* Table: TIPOESCALA                                            */
/*==============================================================*/
create table TIPOESCALA (
   IDTIPOESCALA         VARCHAR(1)           not null,
   DESCTIPOESCALA       VARCHAR(20)          not null,
   constraint PK_TIPOESCALA primary key (IDTIPOESCALA)
);

/*==============================================================*/
/* Index: TIPOESCALA_PK                                         */
/*==============================================================*/
create unique index TIPOESCALA_PK on TIPOESCALA (
IDTIPOESCALA
);

/*==============================================================*/
/* Table: TIPOEVENTO                                            */
/*==============================================================*/
create table TIPOEVENTO (
   IDTIPOEVENTO         VARCHAR(1)           not null,
   DESCTIPOEVENTO       VARCHAR(10)          not null,
   constraint PK_TIPOEVENTO primary key (IDTIPOEVENTO)
);

/*==============================================================*/
/* Index: TIPOEVENTO_PK                                         */
/*==============================================================*/
create unique index TIPOEVENTO_PK on TIPOEVENTO (
IDTIPOEVENTO
);

/*==============================================================*/
/* Table: TIPOLUGAR                                             */
/*==============================================================*/
create table TIPOLUGAR (
   IDTIPOLU             VARCHAR(3)           not null,
   DESCTIPOLUGAR        VARCHAR(30)          not null,
   constraint PK_TIPOLUGAR primary key (IDTIPOLU)
);

/*==============================================================*/
/* Index: TIPOLUGAR_PK                                          */
/*==============================================================*/
create unique index TIPOLUGAR_PK on TIPOLUGAR (
IDTIPOLU
);

/*==============================================================*/
/* Table: VUELO                                                 */
/*==============================================================*/
create table VUELO (
   IDVUELO              VARCHAR(6)           not null,
   CODLINEA             VARCHAR(3)           null,
   IDPROGRAMA           NUMERIC(5,0)         null,
   PLACAAVION           VARCHAR(6)           not null,
   FECHA                DATE                 not null,
   PLAZASVACIA          NUMERIC(3)           not null,
   constraint PK_VUELO primary key (IDVUELO)
);

/*==============================================================*/
/* Index: VUELO_PK                                              */
/*==============================================================*/
create unique index VUELO_PK on VUELO (
IDVUELO
);

/*==============================================================*/
/* Index: PROGRAMA_FK                                           */
/*==============================================================*/
create  index PROGRAMA_FK on VUELO (
CODLINEA,
IDPROGRAMA
);

/*==============================================================*/
/* Index: RELATIONSHIP_17_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_17_FK on VUELO (
PLACAAVION
);

alter table AVION
   add constraint FK_AVION_RELATIONS_MODELOAV foreign key (IDMODELO)
      references MODELOAVION (IDMODELO)
      on delete restrict on update restrict;
	  
alter table AVION
   add constraint FK_AVION_RELATIONS_LINEAAEREA foreign key (CODLINEA)
      references LINEAAEREA (CODLINEA)
      on delete restrict on update restrict;

alter table DESTINO
   add constraint FK_DESTINO_DESTINO_HORA foreign key (IDHORA)
      references HORA (IDHORA)
      on delete restrict on update restrict;

alter table DESTINO
   add constraint FK_DESTINO_DESTINO2_PROGRAMA foreign key (CODLINEA, IDPROGRAMA)
      references PROGRAMAVUELO (CODLINEA, IDPROGRAMA)
      on delete restrict on update restrict;

alter table DIA
   add constraint FK_DIA_DIA_DIAS foreign key (IDDIA)
      references DIAS (IDDIA)
      on delete restrict on update restrict;

alter table DIA
   add constraint FK_DIA_DIA2_PROGRAMA foreign key (CODLINEA, IDPROGRAMA)
      references PROGRAMAVUELO (CODLINEA, IDPROGRAMA)
      on delete restrict on update restrict;

alter table ESCALA
   add constraint FK_ESCALA_AEROPUERT_LUGAR foreign key (IDLUGAR)
      references LUGAR (IDLUGAR)
      on delete restrict on update restrict;

alter table ESCALA
   add constraint FK_ESCALA_RELATIONS_PROGRAMA foreign key (CODLINEA, IDPROGRAMA)
      references PROGRAMAVUELO (CODLINEA, IDPROGRAMA)
      on delete restrict on update restrict;

alter table ESCALA
   add constraint FK_ESCALA_RELATIONS_TIPOESCA foreign key (IDTIPOESCALA)
      references TIPOESCALA (IDTIPOESCALA)
      on delete restrict on update restrict;

alter table EVENTOPISTA
   add constraint FK_EVENTOPI_ATERRIZAR_TIPOEVEN foreign key (IDTIPOEVENTO)
      references TIPOEVENTO (IDTIPOEVENTO)
      on delete restrict on update restrict;

alter table EVENTOPISTA
   add constraint FK_EVENTOPI_RELACION_PISTA foreign key (IDLUGAR, NUMPISTA)
      references PISTA (IDLUGAR, NUMPISTA)
      on delete restrict on update restrict;

alter table EVENTOPISTA
   add constraint FK_EVENTOPI_RELATIONS_PROGRAMA foreign key (CODLINEA, IDPROGRAMA)
      references PROGRAMAVUELO (CODLINEA, IDPROGRAMA)
      on delete restrict on update restrict;

alter table EVENTOPISTA
   add constraint FK_EVENTOPI_RELATIONS_VUELO foreign key (IDVUELO)
      references VUELO (IDVUELO)
      on delete restrict on update restrict;

alter table LUGAR
   add constraint FK_LUGAR_RELACIONN_LUGAR foreign key (LUG_IDLUGAR)
      references LUGAR (IDLUGAR)
      on delete restrict on update restrict;

alter table LUGAR
   add constraint FK_LUGAR_S_TIPOLUGA foreign key (IDTIPOLU)
      references TIPOLUGAR (IDTIPOLU)
      on delete restrict on update restrict;

alter table OCUPACION
   add constraint FK_OCUPACIO_RELATIONS_ESCALA foreign key (CODLINEA, IDPROGRAMA, CONSCEC)
      references ESCALA (CODLINEA, IDPROGRAMA, CONSCEC)
      on delete restrict on update restrict;

alter table OCUPACION
   add constraint FK_OCUPACIO_RELATIONS_SILLA foreign key (PLACAAVION, IDSILLA)
      references SILLA (PLACAAVION, IDSILLA)
      on delete restrict on update restrict;

alter table OCUPACION
   add constraint FK_OCUPACIO_RELATIONS_PASAJERO foreign key (NDOCUMENTO)
      references PASAJERO (NDOCUMENTO)
      on delete restrict on update restrict;

alter table OCUPACION
   add constraint FK_OCUPACIO_SUBIR_BAJ_ACCION foreign key (IDACCION)
      references ACCION (IDACCION)
      on delete restrict on update restrict;

alter table PASAJERO
   add constraint FK_PASAJERO_NACIONALI_LUGAR foreign key (IDLUGAR)
      references LUGAR (IDLUGAR)
      on delete restrict on update restrict;

alter table PISTA
   add constraint FK_PISTA_AEORPUERT_LUGAR foreign key (IDLUGAR)
      references LUGAR (IDLUGAR)
      on delete restrict on update restrict;

alter table PROGRAMAVUELO
   add constraint FK_PROGRAMA_LINEA_LINEAAER foreign key (CODLINEA)
      references LINEAAEREA (CODLINEA)
      on delete restrict on update restrict;

alter table PROGRAMAVUELO
   add constraint FK_PROGRAMA_RELATIONS_LUGAR4 foreign key (IDLUGAR)
      references LUGAR (IDLUGAR)
      on delete restrict on update restrict;

alter table PROGRAMAVUELO
   add constraint FK_PROGRAMA_RELATIONS_LUGAR5 foreign key (LUG_IDLUGAR)
      references LUGAR (IDLUGAR)
      on delete restrict on update restrict;

alter table PROGRAMAVUELO
   add constraint FK_PROGRAMA_RELATIONS_LUGAR6 foreign key (LUG_IDLUGAR4)
      references LUGAR (IDLUGAR)
      on delete restrict on update restrict;

alter table PROGRAMAVUELO
   add constraint FK_PROGRAMA_RELATIONS_LUGAR7 foreign key (LUG_IDLUGAR3)
      references LUGAR (IDLUGAR)
      on delete restrict on update restrict;

alter table PROGRAMAVUELO
   add constraint FK_PROGRAMA_RELATIONS_LUGAR8 foreign key (LUG_IDLUGAR2)
      references LUGAR (IDLUGAR)
      on delete restrict on update restrict;

alter table PROGRAMAVUELO
   add constraint FK_PROGRAMA_RELATIONS_LUGAR foreign key (LUG_IDLUGAR6)
      references LUGAR (IDLUGAR)
      on delete restrict on update restrict;

alter table PROGRAMAVUELO
   add constraint FK_PROGRAMA_RELATIONS_LUGAR2 foreign key (LUG_IDLUGAR7)
      references LUGAR (IDLUGAR)
      on delete restrict on update restrict;

alter table PROGRAMAVUELO
   add constraint FK_PROGRAMA_RELATIONS_LUGAR3 foreign key (LUG_IDLUGAR5)
      references LUGAR (IDLUGAR)
      on delete restrict on update restrict;

alter table SILLA
   add constraint FK_SILLA_RELATIONS_AVION foreign key (PLACAAVION)
      references AVION (PLACAAVION)
      on delete restrict on update restrict;

alter table SILLA
   add constraint FK_SILLA_RELATIONS_ACCION foreign key (IDACCION)
      references ACCION (IDACCION)
      on delete restrict on update restrict;

alter table VUELO
   add constraint FK_VUELO_PROGRAMA_PROGRAMA foreign key (CODLINEA, IDPROGRAMA)
      references PROGRAMAVUELO (CODLINEA, IDPROGRAMA)
      on delete restrict on update restrict;

alter table VUELO
   add constraint FK_VUELO_RELATIONS_AVION foreign key (PLACAAVION)
      references AVION (PLACAAVION)
      on delete restrict on update restrict;

