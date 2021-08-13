
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dat Duy Tran
 */
public class BookList implements IBook {

    ArrayList<Book> t;

    public BookList() {
        this.t = new ArrayList<>();
    }

    /**
     * To check whether this code (as parameter) does exist or not. Return -1 if
     * it does not, otherwise return the index of exists code in List
     *
     * @param t
     * @param code
     * @return
     */
    public static int doesCodeExist(ArrayList<Book> t, String code) {
        for (int i = 0; i < t.size(); i++) {
            if (t.get(i).getCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Input & add book(s) to the end.
     *
     * @throws IOException
     */
    @Override
    public void addOnes() throws IOException {
        String code;
        int numberOfBooksToAdd = GetInput.Integer("Enter number of books you want to add");
        int existStatus;

        for (int i = 0; i < numberOfBooksToAdd; i++) {
            do {
                System.out.printf("\nEnter info for book[%d]\n", i + 1);
                code = GetInput.String("Enter code");
                existStatus = doesCodeExist(t, code);

                // the book’s code must be unique in the list.
                if (existStatus != -1) {
                    System.out.printf("\nError: The book code entered has already been existed (code = %s). Please try again!\n", code);
                }
            } while (existStatus != -1);

            String title = GetInput.String("Enter title");
            int qua = GetInput.Integer("Enter amount", 0, Integer.MAX_VALUE);
            double price = GetInput.Double("Enter price", 0);

            t.add(new Book(code, title, qua, price));
            saveDataToFile();
            System.out.println("\nSuccessful: You added a new book into database");
        }

        // update book list from database
        loadDataFromFile(false);
    }

    /**
     * Display all books in list following format
     */
    @Override
    public void displayAllBooks() {
        if (t.isEmpty()) {
            System.out.println("List of books is empty now! Please add some.");
        } else {
            System.out.printf("\n%-15s%-15s%-15s%-15s\n", "Code", "Title",
                    "Quantity", "Price");
            System.out.println("---------------------------------------------------");
            for (int i = 0; i < t.size(); i++) {
                System.out.printf("%-15s%-15s%-15s%-15.2f\n", t.get(i).getCode(),
                        t.get(i).getTitle(), t.get(i).getQua(), t.get(i).getPrice());
            }
            System.out.println();
        }
    }

    /**
     * Search a book for given code.
     */
    @Override
    public void searchByCode() {
        String code;
        boolean hasResult = false;

        code = GetInput.String("Enter code");

        for (int i = 0; i < t.size(); i++) {
            if (t.get(i).getCode().equals(code)) {
                System.out.println("Result:");
                System.out.printf("\n%-15s%-15s%-15s%-15s\n", "Code", "Title",
                        "Quantity", "Price");
                System.out.println("---------------------------------------------------");
                System.out.println(t.get(i).toString());
                hasResult = true;
                break;
            }
        }

        if (hasResult == false) {
            System.out.printf("\nNot found: The book with code %s does not exist in this library.\n", code);
        }

    }

    /**
     * Update the book’s price for given code.
     */
    @Override
    public void updatePriceByCode() {
        double price;
        String code;

        code = GetInput.String("Enter code");
        int resultPos = doesCodeExist(t, code);

        if (resultPos != -1) {
            price = GetInput.Double("Enter new price");
            t.get(resultPos).setPrice(price);
        } else {
            System.out.printf("\nError: The book with the code %s does not exist. Please try again!\n", code);
        }

        try {
            saveDataToFile();
        } catch (IOException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Find and return the index of the (first) max value.
     *
     * @return eMaxPosition
     */
    @Override
    public int findMaxPriceIndex() {
        double eMaxPrice = t.get(0).getPrice();
        double ePrice;
        int eMaxIndex = -1;
        boolean isFirst = true;

        if (t.isEmpty()) {
            return eMaxIndex;
        } else {
            // to get the max price value in list of books
            for (int i = 1; i < t.size(); i++) {
                ePrice = t.get(i).getPrice();
                if (eMaxPrice < ePrice) {
                    eMaxPrice = ePrice;
                }
            }

            // to get the (first) position of max price value in list of books
            for (int i = 0; i < t.size(); i++) {
                ePrice = t.get(i).getPrice();
                if (ePrice == eMaxPrice) {
                    eMaxIndex = i;
                    break;
                }
            }
        }

        return eMaxIndex;
    }

    /**
     * Find the max value price and its (first) index in book list
     */
    @Override
    public void printMaxPriceValue() {
        int maxIndex = findMaxPriceIndex();

        if (maxIndex == -1) {
            System.out.println("\nError: The list of books is empty now!");
        } else {
            System.out.println("\nMax price value: " + t.get(maxIndex).getPrice() + "\n(in the index " + maxIndex + ")");
        }
    }

    /**
     * Sort the list ascending by code.
     */
    @Override
    public void sortByCode() {
        Collections.sort(t, (Book o1, Book o2) -> {
            return o1.getCode().compareTo(o2.getCode());
        });

        try {
            saveDataToFile();
        } catch (IOException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("\nSuccessful! The list of book has been sorted ascending by their code.");
    }

    /**
     * Remove the book having given code.
     */
    @Override
    public void removeByCode() {
        String code = GetInput.String("Enter code");

        int pos = doesCodeExist(t, code);

        if (pos == -1) {
            System.err.printf("\nFailed! The book with code \"%s\" does not exists.\n", code);
        } else {
            t.remove(pos);
            System.out.printf("\nSuccessful! The book with code \"%s\" has been permanently removed.\n", code);
        }

        try {
            saveDataToFile();
        } catch (IOException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Load data from file.
     */
    @Override
    public void exitProgram() {
        System.out.println("\nSee you again!");
        System.exit(0);
    }

    /**
     * Load data from file, replacing all given data. parameter to control the
     * showing of success message
     *
     * @param isInMain
     * @throws IOException
     */
    @Override
    public void loadDataFromFile(boolean isInMain) throws IOException {
        final String pathToDB = "db.txt";
        int countRecords = 0;

        String lineCursor;
        String[] dataInLine;
        String eCode;
        String eTitle;
        int eQuantity;
        double ePrice;

        FileReader fr = null;
        BufferedReader br = null;

        // remove all objects in ArrayList t
        t.removeAll(t);

        try {
            fr = new FileReader(pathToDB);
            br = new BufferedReader(fr);

            while (true) {
                lineCursor = br.readLine();
                if (lineCursor == null || lineCursor.trim().length() < 3) {
                    break;
                }
                dataInLine = lineCursor.split("[|]");
                try {
                    eCode = dataInLine[0].trim();
                    eTitle = dataInLine[1].trim();
                    eQuantity = Integer.parseInt(dataInLine[2].trim());
                    ePrice = Double.parseDouble(dataInLine[3].trim());
                    t.add(new Book(eCode, eTitle, eQuantity, ePrice));
                    countRecords++;
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                }

            }

        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            fr.close();
            br.close();
        }

        if (isInMain) {
            System.out.println("\nThe list of book has been updated successfully!");
            System.out.printf("(%d records)\n", countRecords);
        }
    }

    /**
     * Save all new book records into file database
     *
     * @throws IOException
     */
    @Override
    public void saveDataToFile() throws IOException {
        final String pathToDB = "db.txt";
        Book aBook;
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter(pathToDB);
            pw = new PrintWriter(fw);

            for (int i = 0; i < t.size(); i++) {
                aBook = t.get(i);
                pw.printf("%10s | %10s | %10s | %10s\r\n", aBook.getCode(), aBook.getTitle(), aBook.getQua(), aBook.getPrice());
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            fw.close();
            pw.close();
        }
    }
}
