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
            
            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
           
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CadAluno.class.getName()).log(Level.SEVERE, null, ex);
        }

         JFrame.setDefaultLookAndFeelDecorated(true);

    }
}
