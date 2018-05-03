/*
PROCEDIMIENTO ALMACENADO - PAL 1
POR MIGUEL OLMO HERNANDO - 04/04/2018

ESTE PROCEDIMIENTO MEDIANTE LOS PARAMETROS DE ENTRADA (DNI, NOMBRE Y APELLIDO) GENERA EL USUARIO Y LA CONTRASE�A 
Y QUE ACTUA SOBRE EL INSERT EN LA TABLA LOGIN. LUEGO ME GENERA/RETORNA UN PARAMETRO DE SALIDA QUE SERA EL CODLOGIN 
NECESARIO PARA VINCULARLO A LOS USUARIOS PARA LOS USUARIOS A /D / U
*/

CREATE OR REPLACE PROCEDURE PROCE_generarAutoUserPass(v_dni IN VARCHAR , v_nombre IN VARCHAR, v_apellido IN VARCHAR, v_tipo IN VARCHAR, v_codlogin OUT INTEGER) AS
  usuario VARCHAR(30);
  contrasenia VARCHAR(30);
BEGIN 
  usuario := LOWER(v_dni);
  contrasenia := LOWER(substr(v_nombre,1,1) || v_apellido);
   INSERT INTO login (usuario, passwd, tipo) VALUES (usuario, contrasenia, v_tipo) RETURNING codlogin INTO v_codlogin;
EXCEPTION 
  WHEN OTHERS THEN 
    RAISE_APPLICATION_ERROR (-20100, 'ERROR INEXPERADO AL GENERAR EL LOGIN - USUARIO/CONTRASENIA: '|| SQLERRM);
END;

/*
PROCEDIMIENTO ANONIMO - PAN 1
POR MIGUEL OLMO HERNANDO - 04/04/2018

ESTE PROCEDIMIENTO ANONIMO ME PERMITE LLAMAR AL PROCEDIMIENTO ALMACENADO generarAutoUserPass

SET SERVEROUTPUT ON

DECLARE
  v_codlogin INTEGER;
BEGIN
  generarAutoUserPass ('12345678A', 'Prueba', 'Prueba', 'A',v_codlogin);
END;
*/


