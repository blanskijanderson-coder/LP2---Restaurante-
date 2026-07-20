package restaurante;

import java.awt.EventQueue;
import javax.swing.UIManager;
import restaurante.view.Inicio;

public class Main {

    public static void main(String[] args) {
        configurarTema();

        EventQueue.invokeLater(() -> {
            new Inicio().setVisible(true);
        });
    }

    private static void configurarTema() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}