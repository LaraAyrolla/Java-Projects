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
        String input = "Dom Casmurro\nMachado de Assis\n9788542221091\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        actionRegisterBook(scanner, library);

        Book book = library.findBookByISBN("9788542221091");
        Assert.assertNotNull(book);
        Assert.assertEquals("Dom Casmurro", book.getTitle());
        Assert.assertEquals("Machado de Assis", book.getAuthor());
        Assert.assertEquals("9788542221091", book.getIsbn());
    }

    @Test
    public void testActionRetrieveBookInfo() {
        // Add a book first
        Book book = new Book("Dom Casmurro", "Machado de Assis", "9788542221091");
        library.addBook(book);

        // Simulate user input for the ISBN
        String input = "9788542221091\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        actionRetrieveBookInfo(scanner, library);

        Assert.assertNotNull(library.findBookByISBN("9788542221091"));
    }

    @Test
    public void testActionRegisterLoan() {
        Book book = new Book("Dom Casmurro", "Machado de Assis", "9788542221091");
        library.addBook(book);

        String input = "9788542221091\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        actionRegisterLoan(scanner, library);

        Assert.assertTrue(library.findBookByISBN("9788542221091").isLoaned());
    }

    @Test
    public void testActionRegisterReturn() {
        Book book = new Book("Dom Casmurro", "Machado de Assis", "9788542221091");
        library.addBook(book);
        library.registerLoan("9788542221091");

        String input = "9788542221091\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        actionRegisterReturn(scanner, library);

        Assert.assertFalse(library.findBookByISBN("9788542221091").isLoaned());
    }

    @Test
    public void testActionRemoveBook() {
        Book book = new Book("Dom Casmurro", "Machado de Assis", "9788542221091");
        library.addBook(book);

        String input = "9788542221091\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        actionRemoveBook(scanner, library);

        Assert.assertNull(library.findBookByISBN("9788542221091"));
    }
}
