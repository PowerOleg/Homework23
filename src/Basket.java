import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

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
        Basket basket = new Basket();
        String[] goodsList;
        int[] quantitylist;

//        BufferedReader bufferedReader = new BufferedReader();

        try {
            Object[] s = Files.lines(Path.of("basket.txt")).toArray();
            System.out.println(s[0]);
            System.out.println(s[1]);
            System.out.println(s[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        String[] goodsList3String = text.toString().split();
//        System.out.println(Arrays.toString(goodsList3String));



//        basket.setGoodsList(goodsList);
//        basket.setGoodsList(quantitylist);
        return basket;
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
