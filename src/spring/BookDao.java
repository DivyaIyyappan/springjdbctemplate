package com.dao;

import java.util.List;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.model.Customer;
import com.util.ConnectionUtil;

public class BookDao {
	
	private JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	
	public List<Book> findAll(){

		String sql = "SELECT * FROM BOOK";

		List<Book> books  = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper(book.class));

		return Book;
	}
	
	public int findTotalBook(){

		String sql = "SELECT COUNT(*) FROM BOOK";

		int total = jdbcTemplate.queryForInt(sql);

		return total;
	}
	
	public void saveOrUpdate(Book book) {
	    if (Book.getCust_id() < 0) {
	        // update
	        String sql = "UPDATE book SET book_id=?, book_name=?, "
	                    + " WHERE book_id=?";
	        jdbcTemplate.update(sql, book.getCust_id(), book.getCust_name(),book.getCust_id());
	    } else {
	        // insert
	        String sql = "INSERT INTO book (book_id,book_name,)"
	                    + " VALUES (?, ?, ?)";
	        jdbcTemplate.update(sql, book.getBook_id(), book.getBook_name());
	    }
	 
	}
	
	public void delete(int book_id) {
	    String sql = "DELETE FROM book WHERE book_id=?";
	    jdbcTemplate.update(sql, book_id);
	    
	    System.out.println("Successfully deleted");
	}
	

}
