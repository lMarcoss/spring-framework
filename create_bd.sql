-- DROP DATABASE IF EXISTS aserradero1;
CREATE DATABASE IF NOT EXISTS aserradero1;
USE aserradero1;
-- catálogo de estados
DROP TABLE IF EXISTS ase_cat_estados;
CREATE TABLE ase_cat_estados(
  clave_estado    varchar(2),
  nombre_estado   varchar(50),
  PRIMARY KEY (clave_estado)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS ase_cat_municipios;
CREATE TABLE ase_cat_municipios(
  clave_estado      varchar(2),
  clave_municipio   varchar(5),
  nombre_municipio  varchar(100),
  PRIMARY KEY (clave_estado, clave_municipio),
  FOREIGN KEY (clave_estado) REFERENCES ase_cat_estados (clave_estado)
    ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE = InnoDB;

DROP TABLE IF EXISTS ase_cat_localidades;
CREATE TABLE ase_cat_localidades(
  codigo_postal     varchar(5),
  nombre_localidad  varchar(100),
  tipo_asentamiento varchar(50),
  id_asentamiento   varchar(5),
  clave_estado      varchar(2),
  clave_municipio   varchar(5),
  PRIMARY KEY (codigo_postal, id_asentamiento),
  FOREIGN KEY (clave_estado, clave_municipio)
  REFERENCES ase_cat_municipios (clave_estado, clave_municipio)
    ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE = InnoDB;

/*SELECT * FROM ase_cat_estados;
SELECT * FROM ase_cat_municipios;
SELECT * FROM ase_cat_localidades;*/

DROP TABLE IF EXISTS ase_cat_personas;
CREATE TABLE ase_cat_personas(
  id_persona        int auto_increment,
  codigo_postal     varchar(5),
  id_asentamiento   varchar(5),
  tipo_persona      ENUM('Persona', 'Empresa'),
  PRIMARY KEY (id_persona),
  FOREIGN KEY (codigo_postal, id_asentamiento)
  REFERENCES ase_cat_localidades (codigo_postal, id_asentamiento)
    ON UPDATE CASCADE
) ENGINE = InnoDB;


DROP TABLE IF EXISTS ase_cat_personas_fisicas;
CREATE TABLE ase_cat_personas_fisicas(
  id_persona_fisica int auto_increment,
  curp              char(18),
  nombre_persona    varchar(100),
  apellido_paterno  varchar(100),
  apellido_materno  varchar(100),
  sexo              ENUM('H', 'M'),
  telefono          char(10),
  direccion         varchar(100),
  PRIMARY KEY (id_persona_fisica),
  FOREIGN KEY (id_persona_fisica) REFERENCES ase_cat_personas (id_persona)
    ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE = InnoDB;

DROP TABLE IF EXISTS ase_cat_personas_morales;
CREATE TABLE ase_cat_personas_morales(
  id_empresa            int auto_increment,
  curp_empresa          VARCHAR(20)  NOT NULL,
  nombre_empresa        VARCHAR(100) NOT NULL,
  codigo_identificacion VARCHAR(100) NULL,
  registro_forestal_nac VARCHAR(100) NULL,
  telefono              char(10),
  direccion             varchar(100),
  PRIMARY KEY (id_empresa),
  FOREIGN KEY (id_empresa) REFERENCES ase_cat_personas (id_persona)
    ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE = InnoDB;


SELECT * FROM ase_cat_localidades;
