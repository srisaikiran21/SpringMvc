package com.cap.dao;

import java.util.List;

import com.cap.model.Book;
import com.cap.model.Library;



public interface IDao {
	public void addBook(Book b);
	public Library getLibrary(String libraryName);
	public Book findBook(int bookId);
	public void deleteBook(int bookId);
	public List<Book> getAllBooks();
	public Book updateBookDetails(int id,String bname,String author,String publisher);
	
}
