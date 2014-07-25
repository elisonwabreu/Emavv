/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Theme;

import Views.CadAluno;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author suporte
 */
public class Tema {

    public static void Tema() {
        try {
            //UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
            // UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CadAluno.class.getName()).log(Level.SEVERE, null, ex);
        }

//Aqui tem mais alguns skins para você ver, todos tem no Jar do JTattoo
//Comente a linha de cima, e descomente essa debaixo
//        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//        UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
//        UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
//Essa linha serve para decorar também a caixa de controle da janela (botões minimizar, restaurar, fechar, a caixa de controle em si, e o que mais tiver)
        JFrame.setDefaultLookAndFeelDecorated(true);

    }
}
