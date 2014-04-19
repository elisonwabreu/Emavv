package ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*Esta clase efetuara a conexao com BD 
 */
public class Conexao {

    public static Connection getConexao() throws SQLException {

        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);

            String serveName = "localhost"; 							// local onde esta o banco
            String dbName = "dbemavv";									//nome do banco de dados	
            String url = "jdbc:mysql://" + serveName + "/" + dbName;;	//url de conexao
            String userName = "root";									//usuario de conexao
            String password = "skate159";									//senha para conexao

            Connection con = DriverManager.getConnection(url, userName, password);
            return con;

        } catch (ClassNotFoundException e) {
            System.out.println("N�o foi possivel conectar" + e.getException());
        }
        return null;
    }
    
    public EntityManagerFactory getEntityManager(){
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dbemavv");
        return factory;
    }
}
/*Fim da classe*/
