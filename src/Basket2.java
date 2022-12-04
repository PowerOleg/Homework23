import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Basket2 {
    private String[] goodsList;
    private int[] quantitylist;
    private int[] prices;

    public Basket2(String[] goodsList, int[] prices, int[] quantitylist) {
        this.goodsList = goodsList;
        this.prices = prices;
        this.quantitylist = quantitylist;
    }

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

    public static Basket2 loadFromTxtFile(File textFile) {
        String[] goodsList;
        int[] quantitylist;
        int[] prices;
        StringBuilder text = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(textFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line);
                text.append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object[] o = text.toString().lines().toArray();

        goodsList = o[0].toString().split(" ");
        prices = Arrays.stream(o[1].toString().split(" ")).mapToInt(n -> Integer.parseInt(n)).toArray();
        quantitylist = Arrays.stream(o[2].toString().split(" ")).mapToInt(n -> Integer.parseInt(n)).toArray();

        return new Basket2(goodsList, prices, quantitylist);
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

    public void setGoodsList(String[] goodsList) {
        this.goodsList = goodsList;
    }

    public void setQuantitylist(int[] quantitylist) {
        this.quantitylist = quantitylist;
    }

    public void setPrices(int[] prices) {
        this.prices = prices;
    }
}
