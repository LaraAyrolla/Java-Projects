package tests;

import entity.Book;
import org.junit.Assert;
import org.junit.Test;

public class BookTest {
    @Test
    public void testBookCreation() {
        Book book = new Book("The Gilded Wolves", "Roshani Chokshi", "9781250144546");

        Assert.assertEquals("The Gilded Wolves", book.getTitle());
        Assert.assertEquals("Roshani Chokshi", book.getAuthor());
        Assert.assertEquals("9781250144546", book.getIsbn());
        Assert.assertFalse(book.isLoaned());
    }

    @Test
    public void testSettersAndGetters() {
        Book book = new Book("The Gilded Wolves", "Roshani Chokshi", "9781250144546");

        book.setTitle("100 Days of Sunlight");
        book.setAuthor("Abbie Emmons");
        book.setIsbn("9781733973311");
        book.setLoaned(true);

        Assert.assertEquals("100 Days of Sunlight", book.getTitle());
        Assert.assertEquals("Abbie Emmons", book.getAuthor());
        Assert.assertEquals("9781733973311", book.getIsbn());
        Assert.assertTrue(book.isLoaned());
    }

    @Test
    public void testBookToString() {
        Book book = new Book("White Nights", "Fyodor Dostoevsky", "9783863524456");

        Assert.assertEquals(
                " Title: White Nights \n Author: Fyodor Dostoevsky \n ISBN: 9783863524456 \n Is Loaned? No",
                book.toString()
        );
    }
}
