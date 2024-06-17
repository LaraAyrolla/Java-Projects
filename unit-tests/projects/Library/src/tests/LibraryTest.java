package tests;

import entity.Book;
import entity.Library;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {
    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("Pop Princess", "Rachel Cohn", "9781416902638");

        library.addBook(book);

        assertEquals(book, library.findBookByISBN("9781416902638"));
    }

    @Test
    public void testRemoveBook() {
        Library library = new Library();
        Book book = new Book("Sense and Sensibility", "Jane Austen", "B096LMV46Q");

        library.addBook(book);
        assertEquals(book, library.findBookByISBN("B096LMV46Q"));

        library.removeBook(book);
        assertNull(library.findBookByISBN("B096LMV46Q"));
    }

    @Test
    public void testRegisterLoan() {
        Library library = new Library();
        Book book = new Book(
            "The Strange Case of Dr. Jekyll and Mr. Hyde",
            "Robert Louis Stevenson",
            "154209769X"
        );

        library.addBook(book);
        assertFalse(book.isLoaned());

        library.registerLoan("154209769X");
        assertTrue(book.isLoaned());
    }

    @Test
    public void testRegisterReturn() {
        Library library = new Library();
        Book book = new Book("Beautiful Redemption", "Kami Garcia", "9780316123532");

        library.addBook(book);
        assertFalse(book.isLoaned());

        library.registerLoan("9780316123532");
        assertTrue(book.isLoaned());

        library.registerReturn("9780316123532");
        assertFalse(book.isLoaned());
    }
}
