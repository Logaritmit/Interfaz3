
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new Formulario1();
                frame.setSize(650,650);
                frame.setVisible(true);
            }
        });
    }
}


