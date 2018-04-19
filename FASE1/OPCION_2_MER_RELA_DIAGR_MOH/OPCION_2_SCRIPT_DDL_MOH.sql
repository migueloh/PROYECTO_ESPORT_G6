-- Generado en Oracle SQL Developer Data Modeler 4.1.1.888
--   autor  Miguel Olmo Hernando
--   fecha: 2018-04-19 19:51:45 CEST
--   sitio: Oracle Database 12c - Puesto A222P12
--   tipo:  Oracle Database 12c
--   version: OPCION 2


--   notas: faltan que las claves primarias sean autoincrementales y reordenar codigo a mi gusto
--	    porque este es el autogenerado, aun asi no ha generado ningun tipo de error al crear


CREATE TABLE ADMIN
  (
    COD_PERSONA    NUMBER (30) NOT NULL ,
    EMAIL_CONTACTO VARCHAR2 (30) NOT NULL
  ) ;
ALTER TABLE ADMIN ADD CONSTRAINT ADMIN_PK PRIMARY KEY ( COD_PERSONA ) ;


CREATE TABLE DUENO
  (
    COD_PERSONA       NUMBER (30) NOT NULL ,
    TELEFONO_CONTACTO NUMBER (9) ,
    EQUIPO_COD_EQUIPO NUMBER (8) NOT NULL
  ) ;
ALTER TABLE DUENO ADD CONSTRAINT DUENO_PK PRIMARY KEY ( COD_PERSONA ) ;


CREATE TABLE EQUIPO
  (
    COD_EQUIPO           NUMBER (8) NOT NULL ,
    NOMBRE               VARCHAR2 (20) NOT NULL ,
    PRESUPUESTO          NUMBER (6) NOT NULL ,
    ANO_FUNDACION        NUMBER (4) NOT NULL ,
    CIUDAD               VARCHAR2 (20) NOT NULL ,
    ESTADIO              VARCHAR2 (20) NOT NULL ,
    DUENO_COD_PERSONA    NUMBER (30) NOT NULL ,
    PARTIDO_COD_PARTIDO  NUMBER (48) NOT NULL ,
    PARTIDO_COD_PARTIDO1 NUMBER (48) NOT NULL
  ) ;
ALTER TABLE EQUIPO ADD CONSTRAINT EQUIPO_PK PRIMARY KEY ( COD_EQUIPO ) ;


CREATE TABLE JORNADA
  (
    COD_JORNADA      NUMBER (18) NOT NULL ,
    FECHA_INICIO     DATE NOT NULL ,
    FECHA_FIN        DATE NOT NULL ,
    NUMERO_TEMPORADA NUMBER (20) NOT NULL ,
    EQUIPO_LOCAL     VARCHAR2 (20) NOT NULL ,
    EQUIPO_VISITANTE VARCHAR2 (20) NOT NULL
  ) ;
ALTER TABLE JORNADA ADD CONSTRAINT JORNADA_PK PRIMARY KEY ( COD_JORNADA ) ;


CREATE TABLE JUGADOR
  (
    COD_PERSONA       NUMBER (30) NOT NULL ,
    NICKNAME          VARCHAR2 (10) NOT NULL ,
    SUELDO            NUMBER NOT NULL ,
    POSICION          VARCHAR2 (10) ,
    NACIONALIDAD      VARCHAR2 (20) ,
    EQUIPO_COD_EQUIPO NUMBER (8) NOT NULL
  ) ;
ALTER TABLE JUGADOR ADD CONSTRAINT JUGADOR_PK PRIMARY KEY ( COD_PERSONA ) ;


CREATE TABLE PARTIDO
  (
    COD_PARTIDO         NUMBER (48) NOT NULL ,
    FECHA               DATE NOT NULL ,
    HORA                DATE NOT NULL ,
    PUNTOS_LOCAL        NUMBER (3) NOT NULL ,
    PUNTOS_VISITANTE    NUMBER (3) NOT NULL ,
    EQUIPO_COD_EQUIPO   NUMBER (8) NOT NULL ,
    EQUIPO_COD_EQUIPO1  NUMBER (8) NOT NULL ,
    JORNADA_COD_JORNADA NUMBER (18) NOT NULL
  ) ;
ALTER TABLE PARTIDO ADD CONSTRAINT PARTIDO_PK PRIMARY KEY ( COD_PARTIDO ) ;


CREATE TABLE PERSONA
  (
    COD_PERSONA NUMBER (30) NOT NULL ,
    NOMBRE      VARCHAR2 (20) NOT NULL ,
    APELLIDO    VARCHAR2 (20) NOT NULL ,
    "USER"      VARCHAR2 (8) NOT NULL ,
    PASS        VARCHAR2 (8) NOT NULL
  ) ;
ALTER TABLE PERSONA ADD CONSTRAINT PERSONA_PK PRIMARY KEY ( COD_PERSONA ) ;


CREATE TABLE USUARIO
  (
    COD_PERSONA      NUMBER (30) NOT NULL ,
    FECHA_NACIMIENTO DATE NOT NULL
  ) ;
ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_PK PRIMARY KEY ( COD_PERSONA ) ;


ALTER TABLE ADMIN ADD CONSTRAINT ADMIN_PERSONA_FK FOREIGN KEY ( COD_PERSONA ) REFERENCES PERSONA ( COD_PERSONA ) ;

ALTER TABLE DUENO ADD CONSTRAINT DUENO_EQUIPO_FK FOREIGN KEY ( EQUIPO_COD_EQUIPO ) REFERENCES EQUIPO ( COD_EQUIPO ) ;

ALTER TABLE DUENO ADD CONSTRAINT DUENO_PERSONA_FK FOREIGN KEY ( COD_PERSONA ) REFERENCES PERSONA ( COD_PERSONA ) ;

ALTER TABLE EQUIPO ADD CONSTRAINT EQUIPO_DUENO_FK FOREIGN KEY ( DUENO_COD_PERSONA ) REFERENCES DUENO ( COD_PERSONA ) ;

ALTER TABLE EQUIPO ADD CONSTRAINT EQUIPO_PARTIDO_FK FOREIGN KEY ( PARTIDO_COD_PARTIDO ) REFERENCES PARTIDO ( COD_PARTIDO ) ;

ALTER TABLE EQUIPO ADD CONSTRAINT EQUIPO_PARTIDO_FKv1 FOREIGN KEY ( PARTIDO_COD_PARTIDO1 ) REFERENCES PARTIDO ( COD_PARTIDO ) ;

ALTER TABLE JUGADOR ADD CONSTRAINT JUGADOR_EQUIPO_FK FOREIGN KEY ( EQUIPO_COD_EQUIPO ) REFERENCES EQUIPO ( COD_EQUIPO ) ;

ALTER TABLE JUGADOR ADD CONSTRAINT JUGADOR_PERSONA_FK FOREIGN KEY ( COD_PERSONA ) REFERENCES PERSONA ( COD_PERSONA ) ;

ALTER TABLE PARTIDO ADD CONSTRAINT PARTIDO_EQUIPO_FK FOREIGN KEY ( EQUIPO_COD_EQUIPO ) REFERENCES EQUIPO ( COD_EQUIPO ) ;

ALTER TABLE PARTIDO ADD CONSTRAINT PARTIDO_EQUIPO_FKv1 FOREIGN KEY ( EQUIPO_COD_EQUIPO1 ) REFERENCES EQUIPO ( COD_EQUIPO ) ;

ALTER TABLE PARTIDO ADD CONSTRAINT PARTIDO_JORNADA_FK FOREIGN KEY ( JORNADA_COD_JORNADA ) REFERENCES JORNADA ( COD_JORNADA ) ;

ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_PERSONA_FK FOREIGN KEY ( COD_PERSONA ) REFERENCES PERSONA ( COD_PERSONA ) ;



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             8
-- CREATE INDEX                             0
-- ALTER TABLE                             20
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- TSDP POLICY                              0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
