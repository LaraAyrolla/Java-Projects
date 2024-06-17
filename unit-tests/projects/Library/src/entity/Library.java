package entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void registerLoan(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null && !book.isLoaned()) {
            book.setLoaned(true);
        }
    }

    public void registerReturn(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null && book.isLoaned()) {
            book.setLoaned(false);
        }
    }
}
