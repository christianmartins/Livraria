
package dao;

import bd.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Livro;

public class DAOLivro {
    
    public void inserir (Livro livro){
        
        Connection con = ConnectionFactory.getConnection(); 
        final String SQL = "INSERT INTO LIVRO("
        + "NOME, AUTOR, EDITORA, EDICAO, ANOPUBLICACAO)"
        + "VALUES (?, ?, ?, ? , ?)";
        try{ 
            PreparedStatement stmt = con.prepareStatement(SQL);
            
            stmt.setString(1, livro.getNome());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getEditora());
            stmt.setString(4, livro.getEdicao());
            stmt.setInt(5, livro.getAnoPublicacao());
            
            stmt.execute(); 
        }
        catch(SQLException e){
            throw new RuntimeException("Não foi possivel inserir na tabela livro\n"+ e);
        }
        finally{
            try {
                System.out.println("Foi inserido com sucesso");
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Não a conexão não foi fechada! ");
            }
        }
    }
    
    public static void listar(){
        
        Connection con = ConnectionFactory.getConnection(); 
        final String SQL = "SELECT * FROM LIVRO";
        try{ 
            PreparedStatement stmt = con.prepareStatement(SQL);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                rs.getString("nome");
            }
            //stmt.execute(); 
        }
        catch(SQLException e){
            throw new RuntimeException("Não foi possivel listar na tabela livro\n"+ e);
        }
        finally{
            try {
                System.out.println("Foi listado com sucesso");
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Não a conexão não foi fechada! ");
            }
        }    
    }
    
}
