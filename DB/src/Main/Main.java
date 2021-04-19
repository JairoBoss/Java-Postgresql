/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.sql.SQLException;

/**
 *
 * @author jairo
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = new Connection();
   connection.mostrarElementos();
//        System.out.println("");
        ///connection.añadir("Chicha", "dios", 29);
//connection.eliminar("Esteban");
        
//connection.eliminar("Esteban");
    }

}
