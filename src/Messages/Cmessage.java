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
    }
    
    public void msgFormGeraMensalidade() {
        confirma = new ImageIcon("/Img/Check.png");
        JOptionPane.showMessageDialog(null, "Informe um aluno!", "", JOptionPane.INFORMATION_MESSAGE); 
    }
    public void msgEditado() {

        JOptionPane.showMessageDialog(null, "Registro Editado com Sucesso!");
    }

    public void msgExcluido() {

        JOptionPane.showMessageDialog(null, "Registro Excluído com Sucesso!");
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
    public void msgNenhumRegistroDisc() {

        JOptionPane.showMessageDialog(null, "Esse curso não possui Disciplinas cadastradas!");
    }
    public boolean MsgConfMatricula() {

        if (JOptionPane.showConfirmDialog(null, "Deseja Gerar Matricula Agora?", "Matricula",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            return true;

        } else {

            return false;
        }
    }
    public boolean MsgConfItens() {

        if (JOptionPane.showConfirmDialog(null, "Deseja Informar /n/r Quantidade desse Item?", "Itens",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            return true;

        } else {

            return false;
        }
    }
}
