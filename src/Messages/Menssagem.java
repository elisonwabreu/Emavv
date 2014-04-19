package Messages;

import javax.swing.JOptionPane;

public class Menssagem {

    public static void Menssagem() {

        System.out.print("ok");

    }

    public void MsgCadastro() {

        JOptionPane.showMessageDialog(null, "Gravado com Sucesso!");
    }

    public void MsgDeletar() {

        System.out.print("Registro Apagado com Sucesso!");
    }

    public void MsgAlterar() {

        System.out.print("Registro Alterado com Sucesso!");
    }

    public void MsgAcesso() {
        System.out.println("Voc� n�o tem acesso.");
    }
}
