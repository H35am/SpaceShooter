/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;
import java.sql.DriverManager;
import connector.Connector;

/**
 *
 * @author 0775768 <Hesam.Zarza>
 */
public class SpaceShooter {

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
        Connector connect = new Connector();
        Astroids astroid = new Astroids("iets", "nog iets", "extra iets");
        
       
        
    }
    
    
}
