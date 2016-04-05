/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author guilhermeferreira
 */
public class ProdutoHelper extends Produto {
    
    // connection 
    private Connection conn;
    
    
    // INSERT
public void insert(Produto nProduto){
        
    try{
        
    //Registra JDBC driver
    Class.forName("com.mysql.jdbc.Driver");
    
    this.makeConnection();
    
        String query = "INSERT INTO produto (idproduto, nome, descricao, valor, quantidade) VALUES ("
            +nProduto.getId() + ",'"
            +nProduto.getNome() + "','"
            +nProduto.getDescricao() + "',"
            +nProduto.getValor() + ","
            +nProduto.getQuantidade() +")";
    
    // cria o statement e executa a query
    Statement statement = conn.createStatement();
    statement.executeUpdate(query);

    } 
    catch (SQLException |ClassNotFoundException e)
    {
        System.out.print("" + e);
    }    
}
    
    // UPDATE
public void update(Produto nProduto){
    
    try{
        
    //Registra JDBC driver
    Class.forName("com.mysql.jdbc.Driver");
    
    this.makeConnection();
    
        String query = "UPDATE produto SET nome='"
            +nProduto.getNome() + "', descricao='"
            +nProduto.getDescricao() + "', valor='"
            +nProduto.getValor() + "', quantidade='"
            +nProduto.getQuantidade() +"' WHERE idproduto='"
            +nProduto.getId() + "'";
    
    // cria o statement e executa a query
    Statement statement = conn.createStatement();
    statement.executeUpdate(query);

    } 
    catch (SQLException |ClassNotFoundException e)
    {
        System.out.print("" + e);
    }       
}

public void updateVenda(Produto nProduto){
    
        try{
        
    //Registra JDBC driver
    Class.forName("com.mysql.jdbc.Driver");
    
    this.makeConnection();
    
        String query = "UPDATE produto SET quantidade='"+nProduto.getQuantidade() + "' WHERE idproduto='"+nProduto.getId() + "'";
        
    // cria o statement e executa a query
    Statement statement = conn.createStatement();
    statement.executeUpdate(query);

    } 
    catch (SQLException |ClassNotFoundException e)
    {
        System.out.print("" + e);
    }    
}
    // DELETE
public void delete(Produto nProduto){
    
    try{
        
    //Registra JDBC driver
    Class.forName("com.mysql.jdbc.Driver");
    
    this.makeConnection();
    
            String query = "DELETE FROM produto WHERE idproduto='"+nProduto.getId()+"'";
    
    // cria o statement e executa a query
    Statement statement = conn.createStatement();
    statement.executeUpdate(query);

    } 
    catch (SQLException |ClassNotFoundException e)
    {
        System.out.print("" + e);
    }       
}
    // SELECT
public void selectList(){
    
    try{
        
    //Registra JDBC driver
    Class.forName("com.mysql.jdbc.Driver");
    
    this.makeConnection();
    
            // cria a query update com os dados do aluno
            String query = "SELECT * FROM produto";
                    
            // cria o statement e executa a query
            Statement statement = conn.createStatement();
            statement.executeQuery(query);
            
            // exibe os dados do select
            ResultSet rs = statement .getResultSet();
            
            while (rs.next()){
                System.out.print(rs.getString("idproduto") + ", ");
                System.out.print(rs.getString("nome") + ", ");
                System.out.print(rs.getString("descricao") + ", ");
                System.out.print(rs.getString("valor") + ", ");
                System.out.println(rs.getString("quantidade"));
            }

    } 
    catch (SQLException |ClassNotFoundException e)
    {
        System.out.print("" + e);
    }       
}

private void makeConnection(){
    
    try
    {
        //Registra JDBC driver
        Class.forName("com.mysql.jdbc.Driver");
                        
        // retorna uma conexão 
        conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/produto?zeroDateTimeBehavior=convertToNull", "root", "root");
            
        } catch (SQLException | ClassNotFoundException e)
        {
            System.out.print("" + e);
        }
}
        
}
