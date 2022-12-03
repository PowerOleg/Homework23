import java.io.File;
import java.io.PrintWriter;

public class Basket {
    String[] goodsList;

//    int[] quantitylist;
    int[] prices;

    public void addToCart(int productNum, int amount) {

    }
//сохранить по массиву в каждой строке. Вначале строка из названий, затем строка из цен, строка из количеств
    public void saveTxt(File textFile) {


        try (PrintWriter out = new PrintWriter(file)) {
        ...
            for (String e : longArrInField)
                out.print(e + " ");
        }
        ...

    }

    static Basket loadFromTxtFile(File textFile) {

        return new Basket();
    }
}
