import java.sql.*;
import java.util.Random;

public class AnyadirRegistros {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/BD_EXAMEN";
        String usuario = "root";
        String password = "practica";

        String query = "Select id as id_alumno from alumnos";

        try (Connection conn = DriverManager.getConnection(url, usuario, password);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);) {

            Random random = new Random();

            while (rs.next()) {
                int id_alumno = rs.getInt("id_alumno");
                try (Statement st2 = conn.createStatement();
                     ResultSet rs2 = st2.executeQuery("Select id as id_asignatura from asignaturas");) {
                    int id_nota = 1;

                    while (rs2.next()) {

                        int id_asignatura= rs2.getInt("id_asignatura");

                        double nota = Math.round(random.nextDouble() * 10);

                        String insert = "INSERT INTO notas values default, "+ id_alumno+ ", "+ id_asignatura+ ", "+ nota;

                        PreparedStatement pst = conn.prepareStatement(insert);
                        pst.executeUpdate();

                        id_nota++;
                    }

                }
            }


            while (rs.next()) {

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
