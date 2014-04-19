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
    
    private static final EntityManagerFactory emf = 
                            Persistence.createEntityManagerFactory("dbemavv");
    
    public static EntityManager getEntityManager(){
        
        return emf.createEntityManager();
    }
    
}
