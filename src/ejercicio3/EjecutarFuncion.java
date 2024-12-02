package ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EjecutarFuncion {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/BD_EXAMEN?allowMultiQueries=true";
        String usuario = "root";
        String password = "practica";

        StringBuilder sqlString = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("./src/ejercicio3/funcproc.sql"))){

            String linea;
            while ((linea = br.readLine()) != null) {
                sqlString.append(linea).append("\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("SQL: " + sqlString);

        try (Connection conn = DriverManager.getConnection(url, usuario, password);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sqlString.toString());
            System.out.println("Funcion exitosa");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
