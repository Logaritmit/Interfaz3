import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Formulario1 extends JFrame {

    private JPanel panel4;
    private JTextField nombreTextField;
    private JButton subirImagenButton;
    private JComboBox<String> comboBox1;
    private JCheckBox XLCheckBox;
    private JCheckBox XSCheckBox;
    private JCheckBox lCheckBox;
    private JCheckBox sCheckBox;
    private JCheckBox mCheckBox;
    private JTextField escribaElPrecioEnTextField;
    private JCheckBox hombresCheckBox;
    private JCheckBox mujeresCheckBox;
    private JCheckBox niñosCheckBox;
    private JTextField escribaUnaDescripciónDelTextField;
    private JTextField númeroDeTeléfonoTextField;
    private JTextField nombreDeLaEmpresaTextField;
    private JButton cerrarButton;
    private JButton guardarButton;

    private static final String link_base = "";
    private static final String usuario = "";
    private static final String contraseña = "";

    public Formulario1() {
        super("Bienvenido!!");
        setContentPane(panel4);

        comboBox1.addItem("Opción 1");
        comboBox1.addItem("Opción 2");
        comboBox1.addItem("Opción 3");

        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }
        });

        subirImagenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int resultado = fileChooser.showOpenDialog(Formulario1.this);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File archivoSeleccionado = fileChooser.getSelectedFile();
                }
            }
        });





    }

    private void guardarDatos() {
        String nombre = nombreTextField.getText();
        String precio = escribaElPrecioEnTextField.getText();
        String descripcion = escribaUnaDescripciónDelTextField.getText();
        String telefono = númeroDeTeléfonoTextField.getText();
        String empresa = nombreDeLaEmpresaTextField.getText();

        String opcionSeleccionada = (String) comboBox1.getSelectedItem();

        boolean xlSeleccionado = XLCheckBox.isSelected();
        boolean sSeleccionado =  sCheckBox.isSelected();
        boolean mSeleccionado =  mCheckBox.isSelected();
        boolean xsSeleccionado = XSCheckBox.isSelected();
        boolean lSeleccionado = lCheckBox.isSelected();
        boolean hombresSeleccionado = hombresCheckBox.isSelected();
        boolean mujeresSeleccionado = mujeresCheckBox.isSelected();
        boolean niñosSeleccionado = niñosCheckBox.isSelected();



        try (Connection conn = DriverManager.getConnection(link_base, usuario, contraseña)) {
            String sql = "()";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nombre);
                stmt.setString(2, precio);
                stmt.setString(3, descripcion);
                stmt.setString(4, telefono);
                stmt.setString(5, empresa);

                stmt.setString(6, opcionSeleccionada);
                stmt.setBoolean(7, xlSeleccionado);
                stmt.setBoolean(8, xsSeleccionado);
                stmt.setBoolean(9, lSeleccionado);
                stmt.setBoolean(10, sSeleccionado);
                stmt.setBoolean(11, mSeleccionado);
                stmt.setBoolean(12, xsSeleccionado);
                stmt.setBoolean(13, lSeleccionado);
                stmt.setBoolean(14, niñosSeleccionado);

                int filasInsertadas = stmt.executeUpdate();
                if (filasInsertadas > 0) {
                    JOptionPane.showMessageDialog(Formulario1.this, "Datos guardados correctamente.");
                } else {
                    JOptionPane.showMessageDialog(Formulario1.this, "Error al guardar los datos.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Formulario1.this, "Error al conectar con la base de datos.");
        }
    }



}



