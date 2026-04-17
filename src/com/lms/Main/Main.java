package com.lms.Main;

import com.lms.model.Book;
import com.lms.service.BookService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookService service = new BookService();

        while (true) {
            System.out.println("\n--- Library System ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Update Status");
            System.out.println("5. Search Book");
            System.out.println("6. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    service.addBook(new Book(0, title, author, ""));
                    break;

                case 2:
                    List<Book> books = service.getAllBooks();
                    books.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    service.deleteBook(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Status (AVAILABLE/ISSUED/LOST): ");
                    String status = sc.nextLine();

                    service.updateStatus(id, status);
                    break;

                case 5:
                    System.out.print("Keyword: ");
                    String key = sc.nextLine();

                    List<Book> result = service.searchBooks(key);
                    if (result != null) result.forEach(System.out::println);
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}