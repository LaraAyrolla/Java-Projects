package tests;

import entity.Book;
import entity.Library;
import org.junit.Assert;
import org.junit.Test;

public class LibraryTest {
    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("Pop Princess", "Rachel Cohn", "9781416902638");

        library.addBook(book);

        Assert.assertEquals(book, library.findBookByISBN("9781416902638"));
    }

    @Test
    public void testRemoveBook() {
        Library library = new Library();
        Book book = new Book("Sense and Sensibility", "Jane Austen", "B096LMV46Q");

        library.addBook(book);
        Assert.assertEquals(book, library.findBookByISBN("B096LMV46Q"));

        library.removeBook(book);
        Assert.assertNull(library.findBookByISBN("B096LMV46Q"));
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
        Assert.assertFalse(book.isLoaned());

        library.registerLoan("154209769X");
        Assert.assertTrue(book.isLoaned());
    }

    @Test
    public void testRegisterReturn() {
        Library library = new Library();
        Book book = new Book("Beautiful Redemption", "Kami Garcia", "9780316123532");

        library.addBook(book);
        Assert.assertFalse(book.isLoaned());

        library.registerLoan("9780316123532");
        Assert.assertTrue(book.isLoaned());

        library.registerReturn("9780316123532");
        Assert.assertFalse(book.isLoaned());
    }
}
