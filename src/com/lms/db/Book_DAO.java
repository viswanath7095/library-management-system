package com.lms.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.lms.model.Book;

public class Book_DAO {

    public boolean addBook(Book book) {

        String sql = "INSERT INTO books(title, author, status) VALUES (?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getStatus());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error adding book");
            return false;
        }
    }

    public boolean bookExists(String title) {

        String sql = "SELECT * FROM books WHERE title = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, title);

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            return false;
        }
    }

    public List<Book> getAllBooks() {

        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection con = DatabaseConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Book(
                    rs.getInt("book_id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("status")
                ));
            }

        } catch (Exception e) {
            System.out.println("Error fetching books");
        }

        return list;
    }

    public boolean deleteBook(int id) {

        String sql = "DELETE FROM books WHERE book_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateStatus(int id, String status) {

        String sql = "UPDATE books SET status=? WHERE book_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
    }

    public List<Book> searchBooks(String keyword) {

        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE title LIKE ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Book(
                    rs.getInt("book_id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("status")
                ));
            }

        } catch (Exception e) {
            System.out.println("Search error");
        }

        return list;
    }
}