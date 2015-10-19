/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connector;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import spaceshooter.Astroids;

/**
 *
 * @author 0775768 <Hesam.Zarza>
 */
public class Connector {

    private EntityManagerFactory emf = null;
    private EntityManager em = null;
    private EntityTransaction tx = null;

    public Connector() {
    }
    
    public void fetchOpenConnection(){
        emf = Persistence.createEntityManagerFactory("SpaceShooterPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }
    //Create
    public void CreateAstroids(Astroids astroid){
        fetchOpenConnection();
        tx.begin();
        em.flush();
        em.persist(astroid);
        tx.commit();
        em.close();
        emf.close();
    }
    //Read
    public Astroids ReadAstroids(String id_astroids){
        fetchOpenConnection();
        return em.find(Astroids.class, id_astroids);
    }
    //Update
    public Astroids UpdateAstroids(Astroids updateAstoid){
        Astroids currentAstroids = ReadAstroids(updateAstoid.getIdAstroid());
        tx.begin();
        em.merge(currentAstroids);
        currentAstroids.setIdAstroid("Nieuw Id");
        tx.commit();
        em.close();
        emf.close();
        
        return currentAstroids;
    }
    //Delete
    public void DeleteAstroids(String id_astroids){
        Astroids astroid = ReadAstroids(id_astroids);
        if(astroid != null){
            tx.begin();
            em.flush();
            em.remove(astroid);
            tx.commit();
            em.close();
            emf.close();
        }
    }
    
    
    
    
    
}
