SET GLOBAL log_bin_trust_function_creators = 1;
delimiter //
CREATE PROCEDURE obtener_promedio_alumno (IN alumno_id INT, OUT promedio DECIMAL(3,1))
BEGIN
  SELECT AVG(nota) INTO promedio
  FROM notas
  WHERE id_alumno = alumno_id;
END;

SET GLOBAL log_bin_trust_function_creators = 1;
delimiter //
CREATE FUNCTION obtener_nombre_alumno (alumno_id INT)
RETURNS VARCHAR(100)
BEGIN
  DECLARE nom VARCHAR(100);
  SELECT nombre INTO nom
  FROM alumnos
  WHERE id = alumno_id;
  RETURN nom;
END