import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Basket2 {
    private String[] goodsList;
    private int[] quantitylist;
    private int[] prices;

    public Basket2(String[] goodsList, int[] prices) {
        this.goodsList = goodsList;
        this.prices = prices;
    }

    public void addToCart(int productNum, int number) {
        this.quantitylist[productNum] += number;
    }
    public void printCart() {
        System.out.println("The product list for purchase:");
        for (int i = 0; i < goodsList.length; i++) {
            System.out.printf("%d. %s %d rub/piece\n", i + 1, goodsList[i], prices[i]);
        }
    }
    public void saveTxt(File textFile) {
        try (BufferedWriter out = new BufferedWriter(new PrintWriter(textFile))) {
            for (String e : goodsList)
                out.append(e + " ");
                out.newLine();
            for (int i : prices)
                out.append(i + " ");
                out.newLine();
            for (int i : quantitylist)
                out.append(i + " ");
                out.newLine();
                out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//надо попробовать вынести объявление BufferedReader из метода
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

        Basket2 basket2 = new Basket2(goodsList, prices);
        basket2.setQuantitylist(quantitylist);
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
