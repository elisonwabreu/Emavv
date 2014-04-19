package Daos;

import org.entities.classes.tb_cargos;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Messages.Cmessage;
import org.entities.classes.tb_cursos;
import ConnectionFactory.Conexao;

public class DaoCursos {
    //Metodo para inserir um curso
    Cmessage msg = new Cmessage();
    public boolean Inserir(tb_cursos a) throws SQLException {
        if(msg.MsgConfGravacao() == true){
        Connection conn = Conexao.getConexao();
            String SQL = "INSERT INTO tb_cursos (fd_descricao, fd_status, fd_valor) VALUES (? , ? , ?)";
            PreparedStatement pstm = conn.prepareStatement(SQL);
                pstm.setString(1, a.getDescricao());
                pstm.setString(2, a.getStatus());
                pstm.setDouble(3, 0.0);
                pstm.execute();
                conn.close();
           msg.msgGravado();
           return true;
        }else{
        
            return false;
        
        }

    }
    //Metodo para deletar um curso

    public void Delete(int codigo) throws SQLException {

      Connection conn = Conexao.getConexao(); 
            String SQL = "UPDATE tb_cursos SET fd_status = 'I' WHERE fd_curso = ?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
                pstm.setInt(1, codigo);
                pstm.execute();
                conn.close();
            

    
    }
    //Metodo para sele��o de um curso

    public List<tb_cursos> Select(int codigo) throws SQLException {

        Connection conn = Conexao.getConexao();
        List<tb_cursos> curso = new ArrayList<>();

        String SQL = "SELECT * FROM tb_cursos WHERE fd_status <> 'E' and fd_curso = ?";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setInt(1, codigo);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {

            curso.add(new tb_cursos(rs.getInt("fd_curso"), rs.getString("fd_descricao"), 
                                                        rs.getString("fd_status")));
        }
        pstm.close();
        conn.close();
        return curso;
    }
    
    public List<tb_cursos> Select(String descricao) throws SQLException {
        Connection conn = Conexao.getConexao();

        List<tb_cursos> curso = new ArrayList<>();
        
        String sql = "";
  
            sql = "select "
                + "c.fd_curso, "
                + "c.fd_descricao, 	"
                + "case when (c.fd_status = 'A') then 'Ativo' "
                + "when (c.fd_status = 'I') then 'Inativo' "
                + "else 'Excluído' end as fd_status "
                + "from "
                + "tb_cursos c "
                + "where "
                + "c.fd_status <> 'E' and "
                + "c.fd_descricao like ? ";
                
                    
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1,"%"+descricao+"%");

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {

            curso.add(new tb_cursos(rs.getInt("fd_curso"), 
                    rs.getString("fd_descricao"), rs.getString("fd_status")));

        }
        pstm.close();
        conn.close();

        return curso;
    }

    public void Update(int codigo, String descricao, String status) throws SQLException {
        Connection conn = Conexao.getConexao();
            String SQL = "UPDATE tb_cursos SET fd_descricao = '?' , fd_status = '?' WHERE fd_curso = ?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
                pstm.setString(1, descricao);
                pstm.setString(2, status);
                pstm.setInt(3, codigo);
                pstm.execute();
                conn.close();
        

    }
}
