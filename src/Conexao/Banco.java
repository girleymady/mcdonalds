package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Banco {
    
    public static Connection con = null;
    
    public static java.sql.Connection conectar() { 
        System.out.println("Conectando ao banco...");
        try {   
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/mcdonalds", "root", ""); 
            System.out.println("Conectado.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe não encontrada, adicione o driver de conexação nas bibliotecas.");
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
        } catch(SQLException e) {
            System.out.println(e); 
            throw new RuntimeException(e);
        }
            return con;
    } 
    
}
