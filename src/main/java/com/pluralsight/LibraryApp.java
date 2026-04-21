package com.pluralsight;
import java.util.Scanner;
public class LibraryApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            Book[] books = new Book[20];

            // books
            books[0] = new Book(1, "ISBN001", "Java Basics");
            books[1] = new Book(2, "ISBN002", "OOP Concepts");
            books[2] = new Book(3, "ISBN003", "Data Structures");
            books[3] = new Book(4, "ISBN004", "Algorithms");
            books[4] = new Book(5, "ISBN005", "Database Systems");
            books[5] = new Book(6, "ISBN006", "Operating Systems");
            books[6] = new Book(7, "ISBN007", "Computer Networks");
            books[7] = new Book(8, "ISBN008", "Web Development");
            books[8] = new Book(9, "ISBN009", "Python Basics");
            books[9] = new Book(10, "ISBN010", "Machine Learning");
            books[10] = new Book(11, "ISBN011", "Artificial Intelligence");
            books[11] = new Book(12, "ISBN012", "Cybersecurity");
            books[12] = new Book(13, "ISBN013", "Cloud Computing");
            books[13] = new Book(14, "ISBN014", "Mobile App Development");
            books[14] = new Book(15, "ISBN015", "Game Development");
            books[15] = new Book(16, "ISBN016", "Software Engineering");
            books[16] = new Book(17, "ISBN017", "Big Data");
            books[17] = new Book(18, "ISBN018", "Blockchain Basics");
            books[18] = new Book(19, "ISBN019", "DevOps");
            books[19] = new Book(20, "ISBN020", "UI/UX Design");

            boolean running = true;
            while (running) {
                System.out.println("\n1. Show Available Books");
                System.out.println("2. Show Checked Out Books");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    showAvailableBooks(scanner, books);
                }else if (choice == 2) {
                    showCheckedOutBooks(scanner, books);
                }else if (choice == 3) {
                    running = false;
                }else{
                    System.out.println("Invalid choice.");

                        }
                    }


        scanner.close();
    }

    public static void showAvailableBooks(Scanner scanner, Book[] books) {
        while (true) {
            System.out.println("\nAvailable Books:");
            for (Book book : books) {
                if (!book.isCheckOut()) {
                    System.out.println(book.getId() + " | " + book.getIsbn() + " | " + book.getTitle());
                }
            }

            System.out.print("Enter book ID to check out, or 0 to go back: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            if (id == 0) {
                return;
            }

            Book selectedBook = findBookById(books, id);
            if (selectedBook == null) {
                System.out.println("Book not found.");
            } else if (selectedBook.isCheckOut()) {
                System.out.println("That book is already checked out.");
            } else {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                selectedBook.checkOut(name);
                System.out.println("Book checked out successfully.");
            }
        }
    }

    public static void showCheckedOutBooks(Scanner scanner, Book[] books) {
        while (true) {
            System.out.println("\nChecked Out Books:");
            for (Book book : books) {
                if (book.isCheckOut()) {
                    System.out.println(book.getId() + " | " + book.getIsbn() + " | " + book.getTitle() + " | " + book.getCheckedOutTo());
                }
            }

            System.out.println("C - Check In a book");
            System.out.println("X - Go back");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim().toUpperCase();

            if (choice.equals("X")) {
                return;
            } else if (choice.equals("C")) {
                System.out.print("Enter the book ID to check in: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Book selectedBook = findBookById(books, id);
                if (selectedBook == null) {
                    System.out.println("Book not found.");
                } else if (!selectedBook.isCheckOut()) {
                    System.out.println("That book is not checked out.");
                } else {
                    selectedBook.checkIn();
                    System.out.println("Book checked in successfully.");
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    public static Book findBookById(Book[] books, int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
