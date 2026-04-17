package com.lms.service;

import com.lms.db.Book_DAO;
import com.lms.model.Book;
import com.lms.util.Constants;

import java.util.List;

public class BookService {

    private Book_DAO dao = new Book_DAO();

    public boolean addBook(Book book) {

        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            System.out.println("Title cannot be empty");
            return false;
        }

        if (dao.bookExists(book.getTitle())) {
            System.out.println("Book already exists!");
            return false;
        }

        book.setStatus(Constants.AVAILABLE);

        return dao.addBook(book);
    }

    public List<Book> getAllBooks() {
        return dao.getAllBooks();
    }

    public boolean deleteBook(int id) {

        if (id <= 0) {
            System.out.println("Invalid ID");
            return false;
        }

        if (!dao.deleteBook(id)) {
            System.out.println("Book not found with ID: " + id);
            return false;
        }

        System.out.println("Book deleted successfully");
        return true;
    }

    public boolean updateStatus(int id, String status) {

        if (!status.equalsIgnoreCase(Constants.AVAILABLE) &&
            !status.equalsIgnoreCase(Constants.ISSUED) &&
            !status.equalsIgnoreCase(Constants.LOST)) {

            System.out.println("Invalid status!");
            return false;
        }

        if (!dao.updateStatus(id, status.toUpperCase())) {
            System.out.println("Book not found!");
            return false;
        }

        System.out.println("Status updated successfully");
        return true;
    }

    public List<Book> searchBooks(String keyword) {

        if (keyword == null || keyword.trim().isEmpty()) {
            System.out.println("Invalid search");
            return null;
        }

        return dao.searchBooks(keyword);
    }
}