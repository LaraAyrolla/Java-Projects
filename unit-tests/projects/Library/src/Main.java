import java.util.Scanner;
import entity.Book;
import entity.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        System.out.println("Welcome to the library!\n");

        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("* Type 1 to register a new book");
            System.out.println("* Type 2 for info on a registered book");
            System.out.println("* Type 3 to loan a registered book");
            System.out.println("* Type 4 to return a loaned book");
            System.out.println("* Type 5 to remove a registered book\n");

            String action = scanner.nextLine();

            switch (action) {
                case "1":
                    actionRegisterBook(scanner, library);
                    break;
                case "2":
                    actionRetrieveBookInfo(scanner, library);
                    break;
                case "3":
                    actionRegisterLoan(scanner, library);
                    break;
                case "4":
                    actionRegisterReturn(scanner, library);
                    break;
                case "5":
                    actionRemoveBook(scanner, library);
                    break;
                default:
                    System.out.println("\nInvalid option!\n");
                    break;
            }
        } while (true);
    }

    private static void actionRegisterBook(Scanner scanner, Library library) {
        System.out.print("\nTitle: ");
        String title = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        if (library.findBookByISBN(isbn) != null) {
            System.out.println("\nBook is already registered!\n");
            return;
        }

        library.addBook(new Book(title, author, isbn));

        System.out.println("\nBook successfully registered!\n");
    }

    private static void actionRetrieveBookInfo(Scanner scanner, Library library) {
        System.out.print("\nISBN: ");
        Book book = library.findBookByISBN(scanner.nextLine());

        if (book == null) {
            System.out.println("\nBook is not registered!\n");
        } else {
            System.out.println("\nBook information:\n");
            System.out.println(book);
            System.out.println();
        }
    }

    private static void actionRegisterLoan(Scanner scanner, Library library) {
        System.out.print("\nISBN: ");
        Book book = library.findBookByISBN(scanner.nextLine());

        if (book == null) {
            System.out.println("\nBook is not registered!\n");
            return;
        }

        if (book.isLoaned()) {
            System.out.println("\nBook is already loaned!\n");
            return;
        }

        library.registerLoan(book.getIsbn());
        System.out.println("\nBook successfully loaned!\n");
    }

    private static void actionRegisterReturn(Scanner scanner, Library library) {
        System.out.print("\nISBN: ");
        Book book = library.findBookByISBN(scanner.nextLine());

        if (book == null) {
            System.out.println("\nBook is not registered!\n");
            return;
        }

        if (!book.isLoaned()) {
            System.out.println("\nBook is not loaned!\n");
            return;
        }

        library.registerReturn(book.getIsbn());
        System.out.println("\nBook successfully returned!\n");
    }

    private static void actionRemoveBook(Scanner scanner, Library library) {
        System.out.print("\nISBN: ");
        Book book = library.findBookByISBN(scanner.nextLine());

        if (book == null) {
            System.out.println("\nBook is not registered!\n");
        } else {
            library.removeBook(book);
            System.out.println("\nBook successfully removed!\n");
        }
    }
}