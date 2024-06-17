package tests;

import entity.Book;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void testBookCreation() {
        Book book = new Book("The Gilded Wolves", "Roshani Chokshi", "9781250144546");

        assertEquals("The Gilded Wolves", book.getTitle());
        assertEquals("Roshani Chokshi", book.getAuthor());
        assertEquals("9781250144546", book.getIsbn());
        assertFalse(book.isLoaned());
    }

    @Test
    public void testSetters() {
        Book book = new Book("The Gilded Wolves", "Roshani Chokshi", "9781250144546");

        book.setTitle("100 Days of Sunlight");
        book.setAuthor("Abbie Emmons");
        book.setIsbn("9781733973311");
        book.setLoaned(true);

        assertEquals("100 Days of Sunlight", book.getTitle());
        assertEquals("Abbie Emmons", book.getAuthor());
        assertEquals("9781733973311", book.getIsbn());
        assertTrue(book.isLoaned());
    }
}
