package controlador;

import modelo.*;
import vista.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import static modelo.ModeloDailyDairy.convertBlobToBufferedImage;
import static modelo.ModeloDailyDairy.convertBufferedImageToBlob;

public class ControladorDailyDairy implements ActionListener, MouseListener, ListSelectionListener, ItemListener {

    public ControladorDailyDairy(ModeloDailyDairy modelo, ArrayList<Object> vistas) {
        this.modelo = modelo;
        this.frame = (JFrameDailyDairy) vistas.get(0);

        this.connection = ModeloDailyDairy.getConnection();
        this.panelInicio = (PanelInicio) vistas.get(1);
        this.panelAgregar = (PanelAgregar) vistas.get(2);
        this.panelEditar = (PanelEditar) vistas.get(3);
        this.panelGanado = (PanelGanado) vistas.get(4);
        this.panelEliminar = (PanelEliminar) vistas.get(5);
        this.panelOrdena = (PanelOrdena) vistas.get(6);
        this.panelProduccion = (PanelProduccion) vistas.get(7);
        this.panelAgregarOrdena = (PanelAgregarOrdena) vistas.get(8);
        this.panelEliminarOrdena = (PanelEliminarOrdena) vistas.get(9);

        frame.setControlador(this);

        this.getPanelInicio().setControlador(this);
        this.getPanelAgregar().setControlador(this);
        this.getPanelGanado().setControlador(this);
        this.getPanelEliminar().setControlador(this);
        this.getPanelModificar().setControlador(this);
        this.getPanelAgregarOrdena().setControlador(this);
        this.getPanelEliminarOrdena().setControlador(this);
        this.getPanelOrdena().setControlador(this);
        this.getPanelProduccion().setControlador(this);


//        this.getPanelInicio().addActionListenersPanelInicioComponents();


//        this.getPanelAgregar().setControlador(this);
//        this.getPanelGanado().setControlador(this);
//        this.getPanelEliminar().setControlador(this);
//        this.getPanelModificar().setControlador(this);
        this.frame.add(this.getPanelInicio());


    }


    private void refrescarPanelEliminar() {

        try {
            this.modelo.loadTuplas(this.connection, "1");
            //System.out.println("El modelo tiene las tuplas");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        DefaultTableModel defaultModel = (DefaultTableModel) panelEliminar.getTablaGanado().getModel();
        panelEliminar.setTablaGanado(modelo.updateJTableEliminar(defaultModel));


    }

    private void refrescarPanelOrdena() {

        DefaultTableModel model = (DefaultTableModel) this.panelOrdena.getTablaOrdena().getModel();
        model.setRowCount(0);
        try {
            // Realizar la consulta y obtener el ResultSet
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT numeroGanado, fierroGanado, colorGanado, razaGanado, Ordeña.noCriaOrdeña " + "FROM Ganado INNER JOIN Ordeña ON Ganado.numeroGanado = Ordeña.noVacaOrdeña");

            // Recorrer el ResultSet y mostrar los resultados en la consola
            int row = 0;
            while (resultSet.next()) {

                String numeroGanado = resultSet.getString("numeroGanado");
                String fierroGanado = resultSet.getString("fierroGanado");
                String colorGanado = resultSet.getString("colorGanado");
                String razaGanado = resultSet.getString("razaGanado");
                String noCriaOrdeña = resultSet.getString("noCriaOrdeña");

                model.addRow(new Object[]{numeroGanado, fierroGanado, colorGanado, razaGanado, noCriaOrdeña});

            }

            // Cerrar el ResultSet y el Statement
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.panelOrdena.setTablaOrdena(new JTable(model));


    }

    private void refrescarPanelAgregarOrdena() {
        try {
            this.modelo.loadTuplas(this.connection);
            //System.out.println("El modelo tiene las tuplas");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        DefaultTableModel defaultModel = (DefaultTableModel) panelAgregarOrdena.getTablaOrdena().getModel();
        panelAgregarOrdena.setTablaOrdena(modelo.updateJTableGanado(defaultModel));
    }

    private void refrescarPanelProduccion() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // -> Inicio
        if (e.getSource() == panelGanado.getBtnRegresar()) {
            frame.remove(panelGanado);
            frame.add(panelInicio);
        }

        // -> Ganado
        if (e.getSource() == panelInicio.getBtnGanado()) {
            frame.remove(panelInicio);
            frame.add(panelGanado);

            try {
                this.defaultImage = ImageIO.read(new File("src/main/resources/imagenes/vacaDefaultverde2.png"));
            } catch (IOException exx) {
                throw new RuntimeException(exx);
            }

            DefaultTableModel tableModel = (DefaultTableModel) panelGanado.tablaGanado.getModel();
            tableModel.setRowCount(0);
            panelGanado.refreshPanel();

        }

        if (e.getSource() == panelEditar.getBtnRegresar()) {
            frame.remove(panelEditar);
            frame.add(panelGanado);

            DefaultTableModel tableModel = (DefaultTableModel) panelGanado.tablaGanado.getModel();
            tableModel.setRowCount(0);
            panelGanado.refreshPanel();
        }

        if (e.getSource() == panelAgregar.getBtnRegresar()) {
            frame.remove(panelAgregar);
            frame.add(panelGanado);

            DefaultTableModel tableModel = (DefaultTableModel) panelGanado.tablaGanado.getModel();
            tableModel.setRowCount(0);
            panelGanado.refreshPanel();
        }

        if (e.getSource() == panelEliminar.getBtnRegresar()) {
            frame.remove(panelEliminar);
            frame.add(panelGanado);

            DefaultTableModel tableModel = (DefaultTableModel) panelGanado.tablaGanado.getModel();
            tableModel.setRowCount(0);
            panelGanado.refreshPanel();
        }

        if (e.getSource() == panelOrdena.getBtnRegresar()) {
            frame.remove(panelOrdena);
            frame.add(panelGanado);

            DefaultTableModel tableModel = (DefaultTableModel) panelGanado.tablaGanado.getModel();
            tableModel.setRowCount(0);
            panelGanado.refreshPanel();
        }

        if (e.getSource() == panelAgregarOrdena.getBtnRegresar()) {
            frame.remove(panelAgregarOrdena);
            frame.add(panelOrdena);
            refrescarPanelOrdena();
        }

        if (e.getSource() == panelProduccion.getBtnRegresarFromRegistro() || e.getSource() == panelProduccion.getBtnRegresarFromConsulta()) {
            frame.remove(panelProduccion);
            frame.add(panelOrdena);
            refrescarPanelProduccion();
        }


        //Agregar ganado
        if (e.getSource() == panelAgregar.getBtnAgregar()) {
            //FALTA VALIDACION
            String bajaMuerteExtravio = "0";
            String statusordeña = "0";
//            String sexoGanado = panelAgregar.getCboxSexo().getSelectedItem().toString();
            String sexoGanado = "h";
//            System.out.println(panelAgregar.getCboxDescripcion().getSelectedItem().toString());
            String descripcionGanado = panelAgregar.getCboxDescripcion().getSelectedItem().toString();
            String fierroGanado = panelAgregar.getTxtFierro().getText();
            String razaGanado = panelAgregar.getTxtRaza().getText();
            String colorGanado = panelAgregar.getTxtColor().getText();
            String numeroGanado = panelAgregar.getTxtNumero().getText();
            Blob fotografiaGanado = ModeloDailyDairy.convertBufferedImageToBlob(panelAgregar.image,this.connection);

            try {
                ModeloDailyDairy.insertTuplaBD(this.connection, new VacasDailyDairy(numeroGanado, fierroGanado, colorGanado, razaGanado, descripcionGanado, sexoGanado, statusordeña, fotografiaGanado, bajaMuerteExtravio));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }

        //Eliminar ganado
        if (e.getSource() == panelEliminar.getBtnEliminar()) {
            //FALTA VALIDACION
            System.out.println("Eliminar");
            String numID = panelEliminar.getTxtNumero().getText();

            try {
                ModeloDailyDairy.updateTuplaBD(this.connection, numID);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            refrescarPanelEliminar();

        }

        // -> Editar
        if (e.getSource() == panelEditar.getBtnGuardar()) {

            //FALTA VALIDACION
            String bajaMuerteExtravio = "0";
            String statusordeña = "0";
            String sexoGanado = panelAgregar.getCboxSexo().getSelectedItem().toString();
            if (sexoGanado == "Macho") {
                sexoGanado = "M";
            }
            if (sexoGanado == "Hembra") {
                sexoGanado = "H";
            }



            String descripcionGanado = panelEditar.getCboxDescripcion().getSelectedItem().toString();
            String fierroGanado = panelEditar.getTxtFierro().getText();
            String razaGanado = panelEditar.getTxtRaza().getText();
            String colorGanado = panelEditar.getTxtColor().getText();
            String numeroGanado = panelEditar.getTxtNumero().getText();
            Blob fotografiaGanado = convertBufferedImageToBlob(panelEditar.image,this.connection);
            System.out.println(panelEditar.image);


            try {
                ModeloDailyDairy.updateTuplaBD(this.connection, new VacasDailyDairy(numeroGanado, fierroGanado, colorGanado, razaGanado, descripcionGanado, sexoGanado, statusordeña, fotografiaGanado, bajaMuerteExtravio));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }


        }

        if (e.getSource() == panelEditar.getBtnBuscar()) {
            System.out.println("Busco busco");
            VacasDailyDairy tupla = new VacasDailyDairy();
            tupla.setNumeroGanado(panelEditar.getTxtNumero().getText().toString());
            VacasDailyDairy tuplaTemporal = null;
            try {
                tuplaTemporal = ModeloDailyDairy.getVacasBD(this.connection, tupla);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            String bajaMuerteExtravio = "0";
            String statusordeña = "0";
//            String sexoGanado = panelAgregar.getCboxSexo().getSelectedItem().toString();
            String sexoGanado = "h";
//            System.out.println(panelAgregar.getCboxDescripcion().getSelectedItem().toString());
            panelEditar.getCboxDescripcion().setSelectedItem(1);
            panelEditar.getTxtFierro().setText(tuplaTemporal.getFierroGanado());
            panelEditar.getTxtRaza().setText(tuplaTemporal.getRazaGanado());
            panelEditar.getTxtColor().setText(tuplaTemporal.getColorGanado());
            panelEditar.getTxtNumero().setText(tuplaTemporal.getNumeroGanado());
            InputStream imagen;
            try {
                imagen = tuplaTemporal.getFotografiaGanado().getBinaryStream();
                panelEditar.getLblImagenGanado().setIcon(new ImageIcon(ImageIO.read(imagen)));
                panelEditar.image = ImageIO.read(imagen);
            } catch (Exception ex) {
                System.out.println(ex);
                try {
                    panelEditar.image = ImageIO.read(new File("src/main/resources/imagenes/vacaDefaultverde2.png"));
                    panelEditar.getLblImagenGanado().setIcon(new ImageIcon(panelEditar.image));
                } catch (IOException exx) {
                    throw new RuntimeException(exx);
                }

            }

        }

        // -> Ordeña

        if (e.getSource() == panelAgregarOrdena.getBtnAgregar()) {
            try {
                String cria = panelAgregarOrdena.getTxtCria().getText();
                String numGanado = panelAgregarOrdena.getTxtNumero().getText();

                String query = "INSERT INTO ordeña (noVacaOrdeña, noCriaOrdeña) SELECT '" + numGanado + "', '" + cria + "'";
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);


            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


        }

        if (e.getSource() == panelProduccion.getBtnRegistrar()) {

            JTable table = panelProduccion.getTablaRegistroProduccion();

            int numRows = table.getRowCount();
            int numCols = table.getColumnCount();

            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("INSERT INTO produccionordeña (noVacaOrdeña, fechaRegistroProduccion, kgLeche) VALUES ");

            for (int row = 0; row < numRows; row++) {
                if (!table.getValueAt(row, 0).equals(new String(" "))) {
                    String numero = (String) table.getValueAt(row, 0).toString();
                    String fecha = (String) table.getValueAt(row, 1).toString();
                    String leche = (String) table.getValueAt(row, 2).toString();

                    queryBuilder.append("('").append(numero).append("','").append(fecha).append("','").append(leche).append("')");

                    if (row != numRows - 1) {
                        queryBuilder.append(",");
                    }

                }
            }

            String query = queryBuilder.toString();
            query.trim();
            String textoSinUltimaLetra = query.substring(0, query.length() - 1);

            System.out.println(textoSinUltimaLetra);
            Statement statement = null;
            try {
                statement = connection.createStatement();
                statement.execute(textoSinUltimaLetra);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }


        frame.revalidate();
        frame.repaint();

    }

    @Override
    public void mouseClicked(MouseEvent e) {

//        if (e.getSource()==panelGanado.getBtnAgregar() || e.getSource()==panelGanado.getLblSubAgregar() || e.getSource()==panelGanado.getLblTituloAgregar() ){
//            frame.remove(panelGanado);
//            frame.add(panelAgregar);
//        }
//        if (e.getSource()==panelGanado.getBtnEditar() || e.getSource()==panelGanado.getLblSubEditar() || e.getSource()==panelGanado.getLblTituloEditar()){
//            frame.remove(panelGanado);
//            frame.add(panelEditar);
//        }
//        if (e.getSource()==panelGanado.getBtnEliminar() || e.getSource()==panelGanado.getLblSubEliminar() || e.getSource()==panelGanado.getLblTituloEliminar()){
//            frame.remove(panelGanado);
//            frame.add(panelEliminar);
//        }
//        if (e.getSource()==panelGanado.getBtnMostrarOrdena() || e.getSource()==panelGanado.getLblSubMostrarOrdena() || e.getSource()==panelGanado.getLblTituloMostrarOrdena()){
//            frame.remove(panelGanado);
//            frame.add(panelOrdena);
//        }
//        if (e.getSource()==panelGanado.getBtnListaGanado() || e.getSource()==panelGanado.getLblSubListaGanado() || e.getSource()==panelGanado.getLblTituloListaGanado()){
//            frame.remove(panelGanado);
//            frame.add(panelGanado);
//        }
//
//
//
//        frame.revalidate();
//        frame.repaint();


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (e.getSource() == panelGanado.getBtnAgregar() || e.getSource() == panelGanado.getLblSubAgregar() || e.getSource() == panelGanado.getLblTituloAgregar()) {
            frame.remove(panelGanado);
            frame.add(panelAgregar);

            this.panelAgregar.getCboxSexo().setEnabled(false);
            panelAgregar.refreshPanel();
        }
        if (e.getSource() == panelGanado.getBtnEditar() || e.getSource() == panelGanado.getLblSubEditar() || e.getSource() == panelGanado.getLblTituloEditar()) {
            frame.remove(panelGanado);
            frame.add(panelEditar);
            this.panelEditar.getCboxDescripcion().setSelectedIndex(0);
            this.panelEditar.getCboxSexo().setEnabled(false);

            panelEditar.refreshPanel();
        }
        if (e.getSource() == panelGanado.getBtnEliminar() || e.getSource() == panelGanado.getLblSubEliminar() || e.getSource() == panelGanado.getLblTituloEliminar()) {
            System.out.println(panelGanado.getTablaGanado().getSelectedColumn());
            frame.remove(panelGanado);
            frame.add(panelEliminar);


            DefaultTableModel tableModel = (DefaultTableModel) panelEliminar.getTablaGanado().getModel();
            tableModel.setRowCount(0);
            panelEliminar.refreshPanel();

        }
        if (e.getSource() == panelGanado.getBtnMostrarOrdena() || e.getSource() == panelGanado.getLblSubMostrarOrdena() || e.getSource() == panelGanado.getLblTituloMostrarOrdena()) {
            frame.remove(panelGanado);
            frame.add(panelOrdena);

            refrescarPanelOrdena();
        }
        /*if (e.getSource()==panelGanado.getBtnListaGanado() || e.getSource()==panelGanado.getLblSubListaGanado() || e.getSource()==panelGanado.getLblTituloListaGanado()){
            frame.remove(panelGanado);
            frame.add(panelGanado);
        }*/

        //ETIQUETAS AGREGAR

        if (e.getSource() == panelAgregar.getBtnSelecImagen() || e.getSource() == panelAgregar.getLblSubSelec() || e.getSource() == panelAgregar.getLblTituloSelec()){
            System.out.println("Click");

            File imageFile = selectImageFile();
            if (imageFile != null) {
                // Aquí puedes hacer algo con el archivo seleccionado
                System.out.println("Ruta de la imagen seleccionada: " + imageFile.getAbsolutePath());
                panelAgregar.image = loadImageFromFile(imageFile);
                panelAgregar.getLblImagenGanado().setIcon( new ImageIcon(panelAgregar.image));
                panelAgregar.getLblImagenGanado().revalidate();
                panelAgregar.getLblImagenGanado().repaint();


            }else{
                System.out.println("Error en la seleccion de la imagen");
                JOptionPane.showMessageDialog(null, "Imagen no valida, por favor seleccione una distinta", "Error en la imagen", JOptionPane.INFORMATION_MESSAGE);
            }



        }

        if (e.getSource() == panelAgregar.getBtnEliminarImagen()){
            ImageIcon imageIcon = new ImageIcon("src/main/resources/imagenes/vacaDefaultverde2.png");
            panelAgregar.getLblImagenGanado().setIcon(imageIcon);
            panelAgregar.getLblImagenGanado().repaint();
            panelAgregar.getLblImagenGanado().setOpaque(true);
            try {
                panelAgregar.image = ImageIO.read(new File("src/main/resources/imagenes/vacaDefaultverde2.png"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }


        //ETIQUETAS DE ORDEÑA
        if (e.getSource() == panelOrdena.getBtnAgregarOrdena() || e.getSource() == panelOrdena.getLblSubAgregar() || e.getSource() == panelOrdena.getLblTituloAgregar()) {
            frame.remove(panelOrdena);
            frame.add(panelAgregarOrdena);
            refrescarPanelAgregarOrdena();
        }

        //Etiqueta panel mostrar produccion

        if (e.getSource() == panelOrdena.getLblSubMostrarProduccion() || e.getSource() == panelOrdena.getLblTituloMostrarProduccion() || e.getSource() == panelOrdena.getBtnMostrarProduccion()) {
            frame.remove(panelOrdena);
            frame.add(panelProduccion);
            refrescarPanelProduccion();
        }

        //Etiqueta regresar ordeña


        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

        System.out.println(this.panelGanado.tablaGanado.getSelectedRow());
        this.selectedRow = (this.panelGanado.tablaGanado.getSelectedRow());


        if(this.selectedRow != -1){

            this.selectedCow = new VacasDailyDairy();
            this.selectedCow.setNumeroGanado((String) this.panelGanado.tablaGanado.getValueAt(this.selectedRow,0));
            this.selectedCow.setFierroGanado((String) this.panelGanado.tablaGanado.getValueAt(this.selectedRow,1));
            this.selectedCow.setColorGanado((String) this.panelGanado.tablaGanado.getValueAt(this.selectedRow,2));
            this.selectedCow.setRazaGanado((String) this.panelGanado.tablaGanado.getValueAt(this.selectedRow,3));
            this.selectedCow.setDescripcionGanado((String) this.panelGanado.tablaGanado.getValueAt(this.selectedRow,4));
            this.selectedCow.setSexoGanado((String) this.panelGanado.tablaGanado.getValueAt(this.selectedRow,5));

            //SELECT fotografiaGanado FROM sistemaganaderiadb.ganado where numeroGanado = "022";

            String numeroGanado = this.selectedCow.getNumeroGanado();
            Blob blob = null;

            try{
                // Consulta SQL para obtener el campo BLOB
                String consulta = "SELECT fotografiaGanado FROM sistemaganaderiadb.ganado WHERE numeroGanado = ?";

                // Crea una declaración preparada
                PreparedStatement statement = connection.prepareStatement(consulta);

                // Configura el parámetro en la consulta preparada
                statement.setString(1, numeroGanado);

                // Ejecuta la consulta
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    // Obtiene el valor del campo BLOB del resultado
                    blob = resultSet.getBlob("fotografiaGanado");
                    // Convierte el campo BLOB a un arreglo de bytes
                    if (blob!=null) {
                        byte[] bytes = blob.getBytes(1, (int) blob.length());
                        // Guarda el contenido del BLOB en un archivo
                        try (OutputStream outputStream = new FileOutputStream("imagen.jpg")) {
                            outputStream.write(bytes);

                            if (blob != null) {
                                ImageIcon imageIcon = new ImageIcon(convertBlobToBufferedImage(blob));

                                panelGanado.getLblImagenGanado().setIcon(imageIcon);
                                panelGanado.getPanelImagenGanado().setBackground(new Color(143, 190, 0, 25));
                                panelGanado.revalidate();
                                panelGanado.repaint();

                            } else {
                                ImageIcon imageIcon = new ImageIcon(defaultImage);
                                panelGanado.getLblTituloListaGanado().setIcon(imageIcon);
                            }


                        } catch (IOException ex2) {
                            ex2.printStackTrace();
                        }
                    }else{
                        System.out.println("es null");
                        ImageIcon imageIcon = new ImageIcon(defaultImage);
                        panelGanado.getLblImagenGanado().setIcon(imageIcon);
                        panelGanado.repaint();
                    }
                }

                resultSet.close();
                statement.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }

            this.selectedCow.setFotografiaGanado(blob);




        }


        /*if (!e.getValueIsAdjusting()) {


            String inputSource = e.getSource().toString();
            System.out.println(inputSource);
            int start = inputSource.indexOf("{");  // Índice del primer carácter después de la llave "{"

            String result = inputSource.substring(start);  // Obtener la subcadena desde el índice "start" hasta el final

            String cleanedInput = result.replace("{", "").replace("}", "");

            // Dividir la cadena en elementos individuales
            String[] elements = cleanedInput.split(",");

            // Crear un nuevo array de int
            int[] array = new int[elements.length];

            // Convertir los elementos a int y almacenarlos en el array
            for (int i = 0; i < elements.length; i++) {
                array[i] = Integer.parseInt(elements[i].trim());
            }

            System.out.println(array.length);
            System.out.println("Fila seleccionada: " + array[0] );
            this.SelectedRow = (array[0]);

        }*/

    }

    public PanelInicio getPanelInicio() {
        return panelInicio;
    }

    public PanelGanado getPanelGanado() {
        return panelGanado;
    }

    public PanelAgregar getPanelAgregar() {
        return panelAgregar;
    }

    public PanelEliminar getPanelEliminar() {
        return panelEliminar;
    }

    public PanelEditar getPanelModificar() {
        return panelEditar;
    }

    public PanelOrdena getPanelOrdena() {
        return panelOrdena;
    }

    public PanelAgregarOrdena getPanelAgregarOrdena() {
        return panelAgregarOrdena;
    }

    public PanelEliminarOrdena getPanelEliminarOrdena() {
        return panelEliminarOrdena;
    }

    public PanelProduccion getPanelProduccion() {
        return panelProduccion;
    }


    public void setPanelInicio(PanelInicio panelInicio) {
        this.panelInicio = panelInicio;
    }

    public void setPanelGanado(PanelGanado panelGanado) {
        this.panelGanado = panelGanado;
    }

    public void setPanelAgregar(PanelAgregar panelAgregar) {
        this.panelAgregar = panelAgregar;
    }

    public void setPanelEliminar(PanelEliminar panelEliminar) {
        this.panelEliminar = panelEliminar;
    }

    public void setPanelModificar(PanelEditar panelEditar) {
        this.panelEditar = panelEditar;
    }

    public void setPanelOrdena(PanelOrdena panelOrdena) {
        this.panelOrdena = panelOrdena;
    }

    public void setPanelAgregarOrdena(PanelAgregarOrdena panelAgregarOrdena) {
        this.panelAgregarOrdena = panelAgregarOrdena;
    }

    public void setPanelEliminarOrdena(PanelEliminarOrdena panelEliminarOrdena) {
        this.panelEliminarOrdena = panelEliminarOrdena;
    }

    public void setPanelProduccion(PanelProduccion panelProduccion) {
        this.panelProduccion = panelProduccion;
    }
    private JFrameDailyDairy frame;
    private ModeloDailyDairy modelo;
    private PanelInicio panelInicio;
    private PanelGanado panelGanado;
    private PanelAgregar panelAgregar;
    private PanelEliminar panelEliminar;
    private PanelEditar panelEditar;
    private PanelOrdena panelOrdena;
    private PanelAgregarOrdena panelAgregarOrdena;
    private PanelEliminarOrdena panelEliminarOrdena;
    private PanelProduccion panelProduccion;
    public Connection connection;
    public int selectedRow = -1;

    public VacasDailyDairy selectedCow;

    public JPanel currentPanel;

    public BufferedImage defaultImage;

    @Override
    public void itemStateChanged(ItemEvent e) {

        this.panelAgregar.getCboxDescripcion().getSelectedItem().toString();
        this.panelEditar.getCboxDescripcion().getSelectedItem().toString();

        if (e.getSource()==panelAgregar.getCboxDescripcion()){
            System.out.println(this.panelAgregar.getCboxDescripcion().getSelectedItem().toString());
            switch (this.panelAgregar.getCboxDescripcion().getSelectedItem().toString()){
                case "Vaca":
                    System.out.println("Vaca");
                    this.panelAgregar.getCboxSexo().setSelectedItem("Hembra");
                    this.panelAgregar.getCboxSexo().setEnabled(false);
                    break;
                case "Toro":
                    System.out.println("Toro");
                    this.panelAgregar.getCboxSexo().setSelectedItem("Macho");
                    this.panelAgregar.getCboxSexo().setEnabled(false);
                    break;
                case "Novillo":
                    this.panelAgregar.getCboxSexo().setSelectedItem("Macho");
                    this.panelAgregar.getCboxSexo().setEnabled(false);
                    break;
                case "Novilla":
                    this.panelAgregar.getCboxSexo().setSelectedItem("Hembra");
                    this.panelAgregar.getCboxSexo().setEnabled(false);
                    break;
                case "Vaquilla":
                    this.panelAgregar.getCboxSexo().setEnabled(true);
                    break;
                case "Cria":
                    this.panelAgregar.getCboxSexo().setEnabled(true);
                    break;
            }
        }

        if (e.getSource()==panelEditar.getCboxDescripcion()){
            System.out.println(this.panelEditar.getCboxDescripcion().getSelectedItem().toString());
            switch (this.panelEditar.getCboxDescripcion().getSelectedItem().toString()){
                case "Vaca":
                    System.out.println("Vaca");
                    this.panelEditar.getCboxSexo().setSelectedItem("Hembra");
                    this.panelEditar.getCboxSexo().setEnabled(false);
                    break;
                case "Toro":
                    System.out.println("Toro");
                    this.panelEditar.getCboxSexo().setSelectedItem("Macho");
                    this.panelEditar.getCboxSexo().setEnabled(false);
                    break;
                case "Novillo":
                    this.panelEditar.getCboxSexo().setSelectedItem("Macho");
                    this.panelEditar.getCboxSexo().setEnabled(false);
                    break;
                case "Novilla":
                    this.panelEditar.getCboxSexo().setSelectedItem("Hembra");
                    this.panelEditar.getCboxSexo().setEnabled(false);
                    break;
                case "Vaquilla":
                    this.panelEditar.getCboxSexo().setEnabled(true);
                    break;
                case "Cria":
                    this.panelEditar.getCboxSexo().setEnabled(true);
                    break;
            }
        }

    }

    public static File selectImageFile(){
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }

        return null;
    }

    public static BufferedImage loadImageFromFile(File file) {
        try {
            return ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
