package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Messages.Cmessage;
import org.entities.classes.tb_disciplinas;
import ConnectionFactory.Conexao;
import ConnectionFactory.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.entities.classes.tb_cursos;

public class DaoDisciplinas {

    Cmessage msg = new Cmessage();
    EntityManager manager = JPAUtil.getEntityManager();

    public boolean Inserir(tb_disciplinas a) throws SQLException {

        if (msg.MsgConfGravacao() == true) {
            manager.getTransaction().begin();
            manager.persist(a);
            manager.getTransaction().commit();
            manager.close();
            msg.msgGravado();
            return true;
        } else {

            return false;

        }
    }

    public void Delete() throws SQLException {

        Connection conn = Conexao.getConexao();

        String SQL = "DELETE FROM tb_disciplinas WHERE fd_disciplinas = ?";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setInt(1, 1);
        pstm.execute();
        pstm.close();
        conn.close();
    }

    public List<tb_disciplinas> Select(int codigo) throws SQLException {

        Connection conn = Conexao.getConexao();
        List<tb_disciplinas> disciplina = new ArrayList<>();

        String SQL = "SELECT * FROM tb_disciplinas WHERE fd_disciplina = ?";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setInt(1, codigo);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {

            disciplina.add(new tb_disciplinas(rs.getInt("fd_disciplina"), rs.getString("fd_descricao"), rs.getString("fd_status")));
        }
        pstm.close();
        conn.close();

        return disciplina;
    }

    public List<tb_disciplinas> Select(String descricao) throws SQLException {
        String jpql = "";

        if (descricao.equals("")) {
            jpql = "select a from tb_disciplinas a";
        } else {
            jpql = "select a from tb_disciplinas a where a.fd_descricao "
                    + "like :fd_descricao";
        }

        Query q = manager.createQuery(jpql);

        if (descricao.equals("")) {

        } else {
            q.setParameter("fd_descricao", "%" + descricao + "%");
        }

        List<tb_disciplinas> disc = q.getResultList();
        return disc;
    }

    public void Update() throws SQLException {

        Connection conn = Conexao.getConexao();

        String SQL = "UPDATE tb_disciplinas SET fd_descricao = ? and fd_status = ? WHERE fd_disciplina = ?";
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setString(1, "");
        pstm.setString(2, "");
        pstm.setInt(3, 0);
        pstm.execute();
        pstm.close();
        conn.close();
    }
}
