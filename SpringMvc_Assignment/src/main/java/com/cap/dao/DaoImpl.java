package com.cap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cap.model.Book;
import com.cap.model.Library;


public class DaoImpl implements IDao{
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Servlet");
	private static EntityManager e = emf.createEntityManager();
	
	public void addBook(Book b) {
		e.getTransaction().begin();
		
		e.persist(b);
		
		e.getTransaction().commit();
	}
	
	public Library getLibrary(String libraryName) {
		EntityManager e1 = emf.createEntityManager();
		
		TypedQuery<Library> q = e1.createQuery("SELECT l FROM Library l", Library.class);
		List<Library> lib = q.getResultList();
		
		for(Library l : lib ) {
			if(l.getLibraryName().equals(libraryName)) {
				return l;
			}
		}
		return null;
	}
	
	public Book findBook(int bookId) {
		return e.find(Book.class,bookId);
	}

	public void deleteBook(int bookId) {
		e.getTransaction().begin();
		Book b = findBook(bookId);
		e.remove(b);
		
		e.getTransaction().commit();
	}
	
	public List<Book> getAllBooks(){
		EntityManager e1 = emf.createEntityManager();
		TypedQuery<Book> query = e.createQuery("SELECT b FROM Book b", Book.class);
		List<Book> books = query.getResultList();
		e1.close();
		return books;
	}
	
	public Book updateBookDetails(int id,String bname,String author,String publisher) {
		Book b = findBook(id);
		
		e.getTransaction().begin();
		
		if(bname.length()!=0) {
			b.setBookName(bname);
		}
		if(author.length()!=0) {
			b.setAuthor(author);
		}
		if(publisher.length()!=0) {
			b.setPublisher(publisher);
		}
		
		e.getTransaction().commit();
		return b;
	}
}
