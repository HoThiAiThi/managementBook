/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBook.Dao;

import managerBook.Model.book;
import java.sql.Connection;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class bookDao {
    
    //Lay tat ca thong tin cua sach
    public List<book> getAllInformationBook(){
        List<book> books = new ArrayList<book>();
        Connection connection = connectionJDBC.connectionJDBC();
        String sql = "select * from Book ";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                book bookk = new book();
                bookk.setId(rs.getInt("id"));
                bookk.setTitle(rs.getString("title"));
                bookk.setPrice(rs.getDouble("price"));
                books.add(bookk);
            }
        }catch(SQLException ex ){
            ex.printStackTrace();
        }
        System.out.println(books);
        return books;
    }

    //Them sach vao database
    public void addBook(book bookk){
        Connection connection = connectionJDBC.connectionJDBC();
        String sql = "insert into Book(title,price) values(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,bookk.getTitle());
            preparedStatement.setDouble(2, bookk.getPrice());
            int rs = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Xoa sach theo id
    public void deleteBookById(int id){
        Connection connection  = connectionJDBC.connectionJDBC();
        String sql = "Delete from Book where id = " + id;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            int rs = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(bookDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    //Cap nhat lai thong tin cua sach theo id vao database
    public void upDateById(int id, String title, String price){
        Connection connection = connectionJDBC.connectionJDBC();
        String sql = "Update Book set title = ?,  price = ? where id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,price);
            preparedStatement.setInt(3,id);
            int rs = preparedStatement.executeUpdate(); 
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    
    //Lay tat ca cac id co trong database
    public List<book> getAllId(){
        List<book> bok = new ArrayList<book>();
        Connection connection = connectionJDBC.connectionJDBC();
        String sql = "select id from Book";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                book bokk = new book();
                bokk.setId(rs.getInt("id"));
                bok.add(bokk);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return bok;
    }
    
    //Lay thong tin sach theo id
    public book getBookById(int id){
        Connection connection = connectionJDBC.connectionJDBC();
        String sql = "select * from Book where id = " + id;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                book bok = new book();
                bok.setTitle(rs.getString("title"));
                bok.setPrice(rs.getDouble("price"));
                return bok;
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    //lay tat cac thong tin ve sach theo "Title"
    public List<book> getBookByTitle(String title){
       List<book> books = new ArrayList<book>();
        Connection connection = connectionJDBC.connectionJDBC();
        String sql = "select * from Book where title = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,title);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                book bookk = new book();
                bookk.setId(rs.getInt("id"));
                bookk.setTitle(rs.getString("title"));
                bookk.setPrice(rs.getDouble("price"));
                books.add(bookk);            }
        }
        catch(SQLException ex ){
            ex.printStackTrace();
        }
        return books;
    } 
}
