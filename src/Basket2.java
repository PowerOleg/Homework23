import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Basket2 {
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

    public static Basket2 loadFromTxtFile(File textFile) {
        Basket2 basket2 = new Basket2();
        String[] goodsList;
        int[] quantitylist;
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
        Object[] s = text.toString().lines().toArray();
        System.out.println(s[0]);
        System.out.println(s[1]);
        System.out.println(s[2]);

//        int i = text.indexOf(";");
//        int ii = text.indexOf(";", i+1);
//        int iii = text.indexOf(";", ii+1);
//        String s = text.toString().substring(0, i);
//        String ss = text.toString().substring(i+3, ii);
//        String sss = text.toString().substring(ii+3, iii);
//        System.out.println(s);
//        System.out.println(ss);
//        System.out.println(sss);







//        String[] goodsList3String = text.toString().split();
//        System.out.println(Arrays.toString(goodsList3String));



//        basket.setGoodsList(goodsList);
//        basket.setGoodsList(quantitylist);
        return basket2;
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
