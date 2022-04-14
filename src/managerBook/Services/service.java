
package managerBook.Services;

import managerBook.Dao.bookDao;
import managerBook.Model.book;
import java.util.List;

public class service {
    private bookDao dao;
    
    public service(){
        dao = new bookDao();
    }
    
    public List<book> getAllInformationBook(){
        return dao.getAllInformationBook();
    }
    
    public void deleteBookById(int id){
        dao.deleteBookById(id);
    }
    
    public void addBook(book bookk){
        dao.addBook(bookk);
    }
    
    public List<book> getBookByTitle(String title){
        return dao.getBookByTitle(title);
    }
    
    public List<book> getAllId(){
        return dao.getAllId();
    }
    
    public book getBookById(int id){
        return dao.getBookById(id);
    }
    
    public void upDateById(int id,String title,String price){
        dao.upDateById(id,title,price);
    }
}
