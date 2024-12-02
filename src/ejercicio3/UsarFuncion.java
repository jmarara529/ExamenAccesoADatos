package ejercicio3;

import java.sql.*;

public class UsarFuncion {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/BD_EXAMEN";
        String usuario = "root";
        String password = "practica";

        try (Connection conn = DriverManager.getConnection(url, usuario, password);){

            String procedimiento = "{call obtener_promedio_alumno(?,?)}";



            try (CallableStatement cstmt = conn.prepareCall(procedimiento)) {

                try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select id from alumnos")) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        cstmt.setInt(1, id);
                        cstmt.registerOutParameter(2, Types.VARCHAR);
                        cstmt.execute();

                        String nombre = cstmt.getString(2);

                        System.out.println(nombre);


                    }


                }


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
