import java.io.*;
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
        StringBuilder text = new StringBuilder();
//        BufferedReader bufferedReader = new LineNumberReader();

        try (FileReader fileReader = new FileReader(textFile)) {
        int c;
        while ((c = fileReader.read()) != -1) {
            text.append((char) c);
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(text);
//        int i = text.indexOf(";");
//        int ii = text.indexOf(";", i+1);
//        int iii = text.indexOf(";", ii+1);
//        String s = text.toString().substring(0, i);
//        String ss = text.toString().substring(i+3, ii);
//        String sss = text.toString().substring(ii+3, iii);
//        System.out.println(s);
//        System.out.println(ss);
//        System.out.println(sss);

//        String ss = text.toString().trim();         //??
        try {
            String s = Files.readString(Path.of("basket.txt"));
            System.out.println(s);
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
