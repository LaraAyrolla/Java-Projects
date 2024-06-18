package tests;

import entity.Book;
import entity.Library;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.concurrent.CountDownLatch;
import java.util.Scanner;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static main.Main.*;

public class MainTest {
    private Library library;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        library = new Library();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
    }

    @Test(expected = NoSuchElementException.class)
    public void testNoInput() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        main(new String[]{});
    }

    @Test
    public void testActionRegisterBook() {
        String input = "Title6\nAuthor6\nISBN6\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        actionRegisterBook(scanner, library);

        Book book = library.findBookByISBN("ISBN6");
        Assert.assertNotNull(book);
        Assert.assertEquals("Title6", book.getTitle());
        Assert.assertEquals("Author6", book.getAuthor());
        Assert.assertEquals("ISBN6", book.getIsbn());
    }

    @Test
    public void testActionRetrieveBookInfo() {
        // Add a book first
        Book book = new Book("Title7", "Author7", "ISBN7");
        library.addBook(book);

        // Simulate user input for the ISBN
        String input = "ISBN7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        actionRetrieveBookInfo(scanner, library);

        Assert.assertNotNull(library.findBookByISBN("ISBN7"));
    }

    @Test
    public void testActionRegisterLoan() {
        Book book = new Book("Title8", "Author8", "ISBN8");
        library.addBook(book);

        String input = "ISBN8\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        actionRegisterLoan(scanner, library);

        Assert.assertTrue(library.findBookByISBN("ISBN8").isLoaned());
    }

    @Test
    public void testActionRegisterReturn() {
        Book book = new Book("Title9", "Author9", "ISBN9");
        library.addBook(book);
        library.registerLoan("ISBN9");

        String input = "ISBN9\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        actionRegisterReturn(scanner, library);

        Assert.assertFalse(library.findBookByISBN("ISBN9").isLoaned());
    }

    @Test
    public void testActionRemoveBook() {
        Book book = new Book("Title10", "Author10", "ISBN10");
        library.addBook(book);

        String input = "ISBN10\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        actionRemoveBook(scanner, library);

        Assert.assertNull(library.findBookByISBN("ISBN10"));
    }
}
