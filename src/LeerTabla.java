import java.sql.*;
import java.util.Scanner;

public class LeerTabla {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/BD_EXAMEN";
        String usuario = "root";
        String password = "practica";

        Scanner sc = new Scanner(System.in);

        Connection connection = DriverManager.getConnection(url,usuario,password);
        Statement statement = connection.createStatement();

        System.out.println("introduce la tabla que quiere leer: ");
        String tabla = sc.nextLine();

        String query = "SELECT * FROM "+tabla;

        try (ResultSet resultado = statement.executeQuery(query)) {
            System.out.println("información de la tabla "+ tabla);
            System.out.println("---------------------------------------------------");
            while (resultado.next()) {
                if (tabla =="alumnos") {
                    String nombre = resultado.getString("nombre");
                    String apellido = resultado.getString("apellido");
                    int edad = resultado.getInt("edad");



                }else  if (tabla =="asignaturas") {
                    String nombre = resultado.getString("nombre");

                }

            }
        }

    }

}
