package modelo;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ModeloDailyDairy {

    private static final String URL = "jdbc:mysql://localhost:3306/sistemaganaderiadb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "toor";
    public ModeloDailyDairy() {

    }

    public static void insertTuplaBD(Connection connection, VacasDailyDairy vacas) throws Exception {

        String sql = "INSERT INTO ganado (numeroGanado, fierroGanado, colorGanado, razaGanado, descripcionGanado, sexoGanado, statusordeña, fotografiaGanado, bajaMuerteExtravio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, vacas.numeroGanado);
        stmt.setString(2, vacas.fierroGanado);
        stmt.setString(3, vacas.colorGanado);
        stmt.setString(4, vacas.razaGanado);
        stmt.setString(5, vacas.descripcionGanado);
        stmt.setString(6, vacas.sexoGanado);
        stmt.setString(7, vacas.statusordeña);
        stmt.setBlob(8, vacas.fotografiaGanado);
        stmt.setString(9, vacas.bajaMuerteExtravio);
        stmt.execute();
        stmt.close();

    }

    public static VacasDailyDairy getVacasBD(Connection connection, String numeroGanado) throws SQLException {

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
            Blob fotografiaGanado = resultado.getBlob("fotografiaGanado");
            String bajaMuerteExtravio = resultado.getString("bajaMuerteExtravio");
            resultado.close();
            stmt.close();
            return new VacasDailyDairy(numeroGanado, fierroGanado, colorGanado, razaGanado, descripcionGanado, sexoGanado, statusordeña, fotografiaGanado, bajaMuerteExtravio);
        }

        resultado.close();
        stmt.close();


        return null;
    }

    public static void updateTuplaBD(Connection connection, String numID) throws SQLException {
        Statement statement = connection.createStatement();
        String query = "UPDATE ganado SET bajaMuerteExtravio = '1' WHERE numeroGanado = '" + numID + "'";
        System.out.println(query);
        statement.execute(query);
    }

    public static VacasDailyDairy getVacasBD(Connection connection, VacasDailyDairy tupla) throws SQLException {
        String query = "SELECT * FROM ganado WHERE numeroGanado = '" + tupla.getNumeroGanado() + "'";
        System.out.println("Querry ejecutando: " + query.toString());
        Statement statement = connection.createStatement();
        System.out.println(connection);

        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            // Guardar los valores obtenidos en 'tupla'
            tupla.numeroGanado = resultSet.getString("numeroGanado");
            System.out.println(tupla.numeroGanado);
            tupla.fierroGanado = resultSet.getString("fierroGanado");
            tupla.colorGanado = resultSet.getString("colorGanado");
            tupla.razaGanado = resultSet.getString("razaGanado");
            tupla.descripcionGanado = resultSet.getString("descripcionGanado");
            tupla.sexoGanado = resultSet.getString("sexoGanado");
            tupla.statusordeña = resultSet.getString("statusordeña");
            tupla.fotografiaGanado = resultSet.getBlob("fotografiaGanado");
            tupla.bajaMuerteExtravio = resultSet.getString("bajaMuerteExtravio");
        }

        resultSet.close();
        statement.close();

        return tupla;
    }

    public static void updateTuplaBD(Connection connection, VacasDailyDairy tupla) throws SQLException {
        try {
//            String query = "UPDATE ganado SET numeroGanado = ?, fierroGanado = ?, colorGanado = ?, razaGanado = ?, descripcionGanado = ?, sexoGanado = ?, statusordeña = ?, fotografiaGanado = ?, bajaMuerteExtravio = ?";
            //String query = "UPDATE ganado SET numeroGanado = '" + tupla.getNumeroGanado() + "', fierroGanado = '" + fierroGanado + "', colorGanado = '" + colorGanado + "', razaGanado = '" + razaGanado + "', descripcionGanado = '" + descripcionGanado + "', sexoGanado = '" + sexoGanado + "', statusordeña = '" + statusOrdeña + "', bajaMuerteExtravio = '" + bajaMuerteExtravio + "', fotografiaGanado = '" + fotografiaGanado + "'";
            String query = "UPDATE ganado SET fierroGanado = '" + tupla.getFierroGanado() + "', colorGanado = '" + tupla.getColorGanado() + "', razaGanado = '" + tupla.getRazaGanado() + "', descripcionGanado = '" + tupla.getDescripcionGanado() + "', sexoGanado = '" + tupla.getSexoGanado() + "', statusordeña = '" + tupla.getStatusordeña() + "', bajaMuerteExtravio = '" + tupla.getBajaMuerteExtravio() + "', fotografiaGanado = '" + tupla.getFotografiaGanado() + "' WHERE numeroGanado = '" + tupla.getNumeroGanado() + "'";


            Statement statement = connection.createStatement();
            statement.execute(query);

            statement.close();
        } catch (SQLException e) {
            // Manejar cualquier excepción que pueda ocurrir durante la ejecución de la consulta
            e.printStackTrace();
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

    public void loadTuplas(Connection connection) throws SQLException {
        String sql = "SELECT * FROM ganado WHERE bajaMuerteExtravio = '0' ";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet resultado = stmt.executeQuery();

        ArrayList<VacasDailyDairy> tuplas = new ArrayList<>();

        while (resultado.next()) {
            String numeroGanado = resultado.getString("numeroGanado");
            String fierroGanado = resultado.getString("fierroGanado");
            String colorGanado = resultado.getString("colorGanado");
            String razaGanado = resultado.getString("razaGanado");
            String descripcionGanado = resultado.getString("descripcionGanado");
            String sexoGanado = resultado.getString("sexoGanado");
            String statusordeña = resultado.getString("statusordeña");
            Blob fotografiaGanado = resultado.getBlob("fotografiaGanado");
            String bajaMuerteExtravio = resultado.getString("bajaMuerteExtravio");

            VacasDailyDairy tupla = new VacasDailyDairy(numeroGanado, fierroGanado, colorGanado, razaGanado, descripcionGanado, sexoGanado, statusordeña, fotografiaGanado, bajaMuerteExtravio);
            tuplas.add(tupla);
        }

        resultado.close();
        stmt.close();

        this.vacas = tuplas;
    }

    public void loadTuplas(Connection connection, String bajaMuerteExtravio) throws SQLException {
        String sql = "SELECT * FROM ganado WHERE bajaMuerteExtravio = '" + bajaMuerteExtravio + "'";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet resultado = stmt.executeQuery();

        ArrayList<VacasDailyDairy> tuplas = new ArrayList<>();

        while (resultado.next()) {
            String numeroGanado = resultado.getString("numeroGanado");
            String fierroGanado = resultado.getString("fierroGanado");
            String colorGanado = resultado.getString("colorGanado");
            String razaGanado = resultado.getString("razaGanado");
            String descripcionGanado = resultado.getString("descripcionGanado");
            String sexoGanado = resultado.getString("sexoGanado");
            String statusordeña = resultado.getString("statusordeña");
            Blob fotografiaGanado = resultado.getBlob("fotografiaGanado");
            String bajaMuerteExtravio2 = resultado.getString("bajaMuerteExtravio");

            VacasDailyDairy tupla = new VacasDailyDairy(numeroGanado, fierroGanado, colorGanado, razaGanado, descripcionGanado, sexoGanado, statusordeña, fotografiaGanado, bajaMuerteExtravio2);
            tuplas.add(tupla);
        }

        resultado.close();
        stmt.close();

        this.vacas = tuplas;
    }

    public void loadTuplas(Connection connection, boolean Ordena) throws SQLException {
        String sql = "SELECT * FROM ganado WHERE bajaMuerteExtravio = '0' AND statusordeña = '1'";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet resultado = stmt.executeQuery();

        ArrayList<VacasDailyDairy> tuplas = new ArrayList<>();

        while (resultado.next()) {
            String numeroGanado = resultado.getString("numeroGanado");
            String fierroGanado = resultado.getString("fierroGanado");
            String colorGanado = resultado.getString("colorGanado");
            String razaGanado = resultado.getString("razaGanado");
            String descripcionGanado = resultado.getString("descripcionGanado");
            String sexoGanado = resultado.getString("sexoGanado");
            String statusordeña = resultado.getString("statusordeña");
            Blob fotografiaGanado = resultado.getBlob("fotografiaGanado");
            String bajaMuerteExtravio = resultado.getString("bajaMuerteExtravio");

            VacasDailyDairy tupla = new VacasDailyDairy(numeroGanado, fierroGanado, colorGanado, razaGanado, descripcionGanado, sexoGanado, statusordeña, fotografiaGanado, bajaMuerteExtravio);
            tuplas.add(tupla);
        }

        resultado.close();
        stmt.close();

        this.vacas = tuplas;
    }

    /*public void loadTupla(Connection connection, String numID) throws SQLException {
        String sql = "SELECT * FROM ganado WHERE bajaMuerteExtravio = '0' AND statusordeña = '0'";
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

            TuplaDailyDairy tupla2 = new TuplaDailyDairy(numeroGanado, fierroGanado, colorGanado, razaGanado, descripcionGanado, sexoGanado, statusordeña, fotografiaGanado, bajaMuerteExtravio);
            tuplas.add(tupla2);
        }

        resultado.close();
        stmt.close();

        this.tuplas = tuplas;
    }*/

    public void addVacas(VacasDailyDairy vacas) {
        this.vacas.add(vacas);
    }

    public JTable updateJTableGanado(DefaultTableModel modelo) {
        ArrayList<VacasDailyDairy> tuplas = this.getVacas();
        modelo.setRowCount(0);
        for (VacasDailyDairy tupla : tuplas) {
            Object[] fila = {
                    tupla.numeroGanado,
                    tupla.fierroGanado,
                    tupla.colorGanado,
                    tupla.razaGanado,
                    tupla.descripcionGanado,
                    tupla.sexoGanado,
                    tupla.statusordeña,
                    tupla.fotografiaGanado,
                    tupla.bajaMuerteExtravio
            };
            modelo.addRow(fila);
        }

        JTable tabla = new JTable(modelo);

        return tabla;
    }

    public JTable updateJTableEliminar(DefaultTableModel modelo) {
        ArrayList<VacasDailyDairy> tuplas = this.getVacas();
        modelo.setRowCount(0);
        for (VacasDailyDairy tupla : tuplas) {
            Object[] fila = {
                    tupla.numeroGanado,
                    tupla.fierroGanado,
                    tupla.colorGanado,
                    tupla.razaGanado,
            };
            modelo.addRow(fila);
        }

        JTable tabla = new JTable(modelo);

        return tabla;
    }

    public JTable updateJTableOrdena(DefaultTableModel modelo) {
        ArrayList<VacasDailyDairy> tuplas = this.getVacas();
        modelo.setRowCount(0);
        for (VacasDailyDairy tupla : tuplas) {
            Object[] fila = {
                    tupla.numeroGanado,
                    tupla.fierroGanado,
                    tupla.colorGanado,
                    tupla.razaGanado,
            };
            modelo.addRow(fila);
        }

        JTable tabla = new JTable(modelo);

        return tabla;
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

    public ArrayList<VacasDailyDairy> getVacas() {
        return vacas;
    }
    private ArrayList<VacasDailyDairy> vacas;

    public static Blob convertBufferedImageToBlob(BufferedImage image, Connection connection) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            byte[] bytes = baos.toByteArray();
            Blob blob = connection.createBlob();
            blob.setBytes(1, bytes);
            return blob;
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static BufferedImage convertBlobToBufferedImage(Blob blob) {
        try {
            byte[] bytes = blob.getBytes(1, (int) blob.length());
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            return ImageIO.read(bis);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }



}

