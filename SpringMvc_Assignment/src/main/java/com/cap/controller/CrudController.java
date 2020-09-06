package com.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.cap.dao.DaoImpl;
import com.cap.model.Book;
import com.cap.model.Library;

@Controller
public class CrudController {

	DaoImpl dao = new DaoImpl();
	
	@RequestMapping("/add")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		Book book = new Book();
		String libname = request.getParameter("library");
		Library library = dao.getLibrary(libname);
		book.setLibrary(library);
		
		book.setBookId(Integer.parseInt(request.getParameter("bookId")));
		
		book.setAuthor(request.getParameter("author"));
		book.setBookName(request.getParameter("bookName"));
		book.setPublisher(request.getParameter("publisher"));
		
		dao.addBook(book);
		out.println("Book added");
		
	}
	@RequestMapping("/delete")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		dao.deleteBook(Integer.parseInt(request.getParameter("deletebookId")));
		out.println("Book ID "+request.getParameter("deletebookId")+" deleted. ");
	}
	
	@RequestMapping("/search")
	protected void doGet1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Book b = dao.findBook(Integer.parseInt(request.getParameter("getbookId")));
		if(b!=null) {
			out.println("Book Id : "+b.getBookId());
			out.print("<br>");
			out.println("Book Name : "+b.getBookName());
			out.print("<br>");
			out.println("Author of Book : "+b.getAuthor());
			out.print("<br>");
			out.println("Publisher of Book : "+b.getPublisher());
		}
		else 
		{
			out.println("Invalid bookid");
		}
	}
	
	@RequestMapping("/update")
	protected void doPost1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
	
		
		int bId = Integer.parseInt(request.getParameter("updatebookId"));
		String newBname = request.getParameter("updatebookName");
		String newBauthor = request.getParameter("updateAuthor");
		String newBpublisher = request.getParameter("updatePublisher");
		
		Book book = dao.findBook(bId);
		
	     out.println("<html>");
		 out.println("<body>");
			
		 	out.println("Before Update");out.print("<br>");
		 	out.print("<br>");
		 	out.println("Book Name : " +book.getBookName());
		 	out.print("<br>");
		 	out.println("Book Author : "+book.getAuthor());
		 	out.print("<br>");
		 	out.println("Book Publisher Name : "+book.getPublisher());
		 	out.print("<br>");
		 
		Book updatebook = dao.updateBookDetails(bId,newBname,newBauthor,newBpublisher);
		 	
			out.println("After Update");out.print("<br>");
			out.print("<br>");
			out.println("Book Name : " +updatebook.getBookName());
			out.print("<br>");
			out.println("Book Author : "+updatebook.getAuthor());
			out.print("<br>");
			out.println("Book Publisher Name : "+updatebook.getPublisher());
			out.print("<br>");
			
		out.println("</html>");
		out.println("</body>");
}

	
}
