import java.io.*;

public class Basket {
    private String[] goodsList;

    private int[] quantitylist;
    private int[] prices;

    public void addToCart(int productNum, int amount) {

    }
//сохранить по массиву в каждой строке. Вначале строка из названий, затем строка из цен, строка из количеств
    public void saveTxt(File textFile) {


//        try (PrintWriter out = new PrintWriter(file)) {
//        ...
//            for (String e : longArrInField)
//                out.print(e + " ");
//        }
//        ...

    }

    public static Basket loadFromTxtFile(File textFile) {
//        BufferedReader bufferedReader = new LineNumberReader();

        try (FileReader fileReader = new FileReader(textFile)) {

            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return new Basket();
    }


    public String[] getGoodsList() {
        return goodsList;
    }

    public int[] getQuantitylist() {
        return quantitylist;
    }

    public int[] getPrices() {
        return prices;
    }
}
