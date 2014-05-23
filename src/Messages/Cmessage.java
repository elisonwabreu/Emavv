package Messages;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Cmessage {

    Icon confirma;

    public boolean MsgConfGravacao() {

        if (JOptionPane.showConfirmDialog(null, "Confirma Gravação?", "Gravação",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            return true;

        } else {

            return false;
        }
    }

    public boolean MsgConfExclusao() {

        if (JOptionPane.showConfirmDialog(null, "Confirma Exclusão?", "Exclusão",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            return true;

        } else {

            return false;
        }
    }

    public boolean MsgConfEdicao() {

        if (JOptionPane.showConfirmDialog(null, "Confirma Edição?", "Editar",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            return true;

        } else {

            return false;
        }
    }

    public void msgGravado() {

        confirma = new ImageIcon("/Img/Check.png");

        JOptionPane.showMessageDialog(null, "Registro Salvo com Sucesso!", "Gravação", JOptionPane.INFORMATION_MESSAGE);
        // JOptionPane.showMessageDialog(null, "Registro Salvo com Sucesso!","Gravação",JOptionPane.confirma);
    }

    public void msgEditado() {

        JOptionPane.showMessageDialog(null, "Registro Editado com Sucesso!");
    }

    public void msgExcluido() {

        JOptionPane.showMessageDialog(null, "Registro Exclu�do com Sucesso!");
    }

    public void MsgAcesso() {
        System.out.println("Você não tem acesso.");
    }

    public void msgLogin() {

        JOptionPane.showMessageDialog(null, "Usuário ou Senha não conferem.", "", JOptionPane.ERROR_MESSAGE);
    }

    public void MsgCamposObrigatorios(String campo) {

        JOptionPane.showMessageDialog(null, "Campo " + campo + " obrigatório, favor preencher");
    }

    public void msgNenhumRegistro() {

        JOptionPane.showMessageDialog(null, "Nenhum registo encontrado!");
    }
}
