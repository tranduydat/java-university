
import java.io.IOException;

/**
 *
 * @author Dat Duy Tran
 */
public class Main {

    public static void displayMenu() {
        System.out.println("BOOK MANAGEMENT SYSTEM");
        System.out.println("-----------------------------------");
        System.out.println("1. Input and add book(s) to the end");
        System.out.println("2. Display all books");
        System.out.println("3. Search a book for given code");
        System.out.println("4. Update the book's price for given code");
        System.out.println("5. Find the (first) max price value");
        System.out.println("6. Sort the list ascendingly by code");
        System.out.println("7. Remove the book having given code");
        System.out.println("8. Load data from file");
        System.out.println("0. Exit");
    }

    public static void main(String[] args) throws IOException {
        int userChoice;
        BookList book = new BookList();

        // update the database without print out the message (false)
        book.loadDataFromFile(false);
        
        while (true) {
            // prompt user to get their choice
            displayMenu();
            userChoice = GetInput.Integer("Enter your choice", 0, 8);

            switch (userChoice) {
                case 0:
                    // exit program
                    book.exitProgram();
                    break;
                case 1:
                    // input and add book(s) to the end.
                    book.addOnes();
                    break;
                case 2:
                    // display all books
                    book.displayAllBooks();
                    break;
                case 3:
                    // search a book for given code.
                    book.searchByCode();
                    break;
                case 4:
                    // update the book’s price for given code.
                    book.updatePriceByCode();
                    break;
                case 5:
                    // find the (first) max price value.
                    book.printMaxPriceValue();
                    break;
                case 6:
                    // sort the list ascendingly by code.
                    book.sortByCode();
                    break;
                case 7:
                    // remove the book having given code.
                    book.removeByCode();
                    break;
                case 8:
                    // load data from file.
                    book.loadDataFromFile(true);
                    break;
            }
            System.out.println();
        }
    }
}
