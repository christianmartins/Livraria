package bd;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private static String URL;
    
    //private static final String URL = "jdbc:sqlite:C:\\Users\\chris\\Desktop\\MonitoriaLivraria\\src\\jdbc\\livraria";
    private static final String USUARIO = "";
    private static final String SENHA = "";
  
    
    public static Connection getConnection(){
        
        
        try {
            URL = "jdbc:sqlite:"+ new File("src/jdbc/livraria").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
          
        try{
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        }
        catch(SQLException ex){
            throw new RuntimeException("Erro na conexão!", ex);
        }
        finally{
            System.out.println("Conectou com sucesso!");
        }
    }
}
