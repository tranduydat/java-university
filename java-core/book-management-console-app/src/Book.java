
/**
 *
 * @author Dat Duy Tran
 */
public class Book {

    private String code;
    private String title;
    private int qua;
    private double price;

    public Book() {
    }

    public Book(String code, String title, int qua, double price) {
        this.code = code;
        this.title = title;
        this.qua = qua;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getQua() {
        return qua;
    }

    public double getPrice() {
        return price;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQua(int qua) {
        this.qua = qua;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-15s%-15s%-15.2f\n", this.code,
                this.title, this.qua, this.price);
    }
}
