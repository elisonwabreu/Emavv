/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author athalias
 */
public class JPAUtil {

    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("dbemavv");
        }

        return emf.createEntityManager();
    }
    
   public static void close() {
        emf.close();
    }
}
