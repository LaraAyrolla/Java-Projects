package entity;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isLoaned;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isLoaned = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isLoaned() {
        return isLoaned;
    }

    public void setLoaned(boolean isLoaned) {
        this.isLoaned = isLoaned;
    }

    public String toString() {
        String isLoaned = this.isLoaned() ? "Yes" : "No";

        return String.format(
            " Title: %s \n Author: %s \n ISBN: %s \n Is Loaned? %s",
            this.title,
            this.author,
            this.isbn,
            isLoaned
        );
    }
}
