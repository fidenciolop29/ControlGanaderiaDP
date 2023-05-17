package modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloDailyDairy {

    private static final String URL = "jdbc:mysql://localhost:3306/sistemaganaderiadb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "toor";

    private ArrayList<TuplaDailyDairy> tuplas;

    public ModeloDailyDairy(){

    }

    public static void insertTuplaBD(Connection connection, TuplaDailyDairy tupla) throws Exception {

        String sql = "INSERT INTO ganado (numeroGanado, fierroGanado, colorGanado, razaGanado, descripcionGanado, sexoGanado, statusordeña, fotografiaGanado, bajaMuerteExtravio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, tupla.numeroGanado);
        stmt.setString(2, tupla.fierroGanado);
        stmt.setString(3, tupla.colorGanado);
        stmt.setString(4, tupla.razaGanado);
        stmt.setString(5, tupla.descripcionGanado);
        stmt.setString(6, tupla.sexoGanado);
        stmt.setString(7, tupla.statusordeña);
        stmt.setString(8, tupla.fotografiaGanado);
        stmt.setString(9, tupla.bajaMuerteExtravio);
        stmt.execute();
        stmt.close();

    }

    public static TuplaDailyDairy getTuplaBD(Connection connection, String numeroGanado) throws SQLException {

        String sql = "SELECT * FROM ganado WHERE numeroGanado = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, numeroGanado);

        ResultSet resultado = stmt.executeQuery();

        while (resultado.next()) {
            // Aquí puedes obtener los valores de cada columna del resultado
            numeroGanado = resultado.getString("numeroGanado");
            String fierroGanado = resultado.getString("fierroGanado");
            String colorGanado = resultado.getString("colorGanado");
            String razaGanado = resultado.getString("razaGanado");
            String descripcionGanado = resultado.getString("descripcionGanado");
            String sexoGanado = resultado.getString("sexoGanado");
            String statusordeña = resultado.getString("statusordeña");
            String fotografiaGanado = resultado.getString("fotografiaGanado");
            String bajaMuerteExtravio = resultado.getString("bajaMuerteExtravio");
            resultado.close();
            stmt.close();
            return new TuplaDailyDairy(numeroGanado,fierroGanado,colorGanado,razaGanado,descripcionGanado,sexoGanado,statusordeña,fotografiaGanado,bajaMuerteExtravio);
        }

        resultado.close();
        stmt.close();


        return null;
    }

    public void loadTuplas(Connection connection) throws SQLException {
        String sql = "SELECT * FROM ganado";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet resultado = stmt.executeQuery();

        ArrayList<TuplaDailyDairy> tuplas = new ArrayList<>();

        while (resultado.next()) {
            String numeroGanado = resultado.getString("numeroGanado");
            String fierroGanado = resultado.getString("fierroGanado");
            String colorGanado = resultado.getString("colorGanado");
            String razaGanado = resultado.getString("razaGanado");
            String descripcionGanado = resultado.getString("descripcionGanado");
            String sexoGanado = resultado.getString("sexoGanado");
            String statusordeña = resultado.getString("statusordeña");
            String fotografiaGanado = resultado.getString("fotografiaGanado");
            String bajaMuerteExtravio = resultado.getString("bajaMuerteExtravio");

            TuplaDailyDairy tupla = new TuplaDailyDairy(numeroGanado, fierroGanado, colorGanado, razaGanado, descripcionGanado, sexoGanado, statusordeña, fotografiaGanado, bajaMuerteExtravio);
            tuplas.add(tupla);
        }

        resultado.close();
        stmt.close();

        this.tuplas = tuplas;
    }

    public static Connection getConnection() {
        try {
            System.out.println("conexion exitosa");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos MySQL: " + e.getMessage());
            return null;
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión a la base de datos MySQL: " + e.getMessage());
            }
        }
    }

    public ArrayList<TuplaDailyDairy> getTuplas() {
        return tuplas;
    }

    public void addTuplas(TuplaDailyDairy tupla) {
        this.tuplas.add(tupla);
    }
}

