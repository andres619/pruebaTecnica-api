DROP TABLE IF EXISTS movimiento_producto;
DROP TABLE IF EXISTS tipo_movimiento;
DROP TABLE IF EXISTS producto;

CREATE TABLE tipo_movimiento
(
  id_tipo integer NOT NULL,
  tipo character varying NOT NULL,
  descripcion character varying,
  fecha_registro date,
  CONSTRAINT pk_id_tipo PRIMARY KEY (id_tipo)
);

CREATE TABLE producto
(
  id_producto integer NOT NULL,
  referencia character varying NOT NULL,
  descripcion character varying,
  cantidad_disponible integer,
  fecha_ingreso date,
  CONSTRAINT pk_id_producto PRIMARY KEY (id_producto)
);

CREATE TABLE movimiento_producto
(
  id_movimiento integer NOT NULL,
  referencia_producto integer,
  fecha date,
  cantidad integer,
  descripcion character varying,
  tipo_movimiento integer,
  CONSTRAINT pk_id_movimiento PRIMARY KEY (id_movimiento),
  CONSTRAINT fk_producto FOREIGN KEY (referencia_producto)
      REFERENCES producto (id_producto),
  CONSTRAINT fk_tipo_movimiento FOREIGN KEY (tipo_movimiento)
      REFERENCES tipo_movimiento (id_tipo)
);

create sequence sq_productos
  start with 1
  increment by 1;
  
create sequence sq_tipo_movimientos
  start with 1
  increment by 1;
  
create sequence sq_movimiento_productos
  start with 1
  increment by 1;

  
  INSERT INTO tipo_movimiento values (NEXTVAL('sq_tipo_movimientos'), 'ENTRADA', 'Entrada a inventario', CURRENT_DATE)
  INSERT INTO tipo_movimiento values (NEXTVAL('sq_tipo_movimientos'), 'SALIDA', 'Salida de inventario', CURRENT_DATE)

