
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Dat Duy Tran
 */
public interface IBook {

    public void addOnes() throws IOException;

    public void displayAllBooks();

    public void searchByCode();

    public void updatePriceByCode();

    public int findMaxPriceIndex();

    public void printMaxPriceValue();

    public void sortByCode();

    public void removeByCode();

    public void loadDataFromFile(boolean isInMain) throws IOException;

    public void saveDataToFile() throws IOException;

    public void exitProgram();
}
