import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int total = 0;
//    static String[] goodsList = {"Bread(500g)", "Milk(1000g)", "Buckwheat(900g)",
//            "Rice(900g)", "Butter(175g)", "Broiler_Chicken_Thighs(900g)", "Tea(20*1.5g)"};
//    static int[] quantitylist = new int[goodsList.length];
//    static int[] prices = {21, 64, 129, 156, 129, 216, 120};












    //переделать чтобы выводил исходя из того что в basket.txt
//    public static void result() {
//        int lineNumber = 1;
//        int productIterationNumber = 0;
//        System.out.println("Orders:");
//        for (int i : quantitylist) {
//            if (i != 0) {
//                int priceInOrder = i * prices[productIterationNumber];
//                total += priceInOrder;
//                System.out.printf("%d. %s %d pieces %d rub/piece %d rub in order\n",
//                        lineNumber, goodsList[productIterationNumber], i,
//                        prices[productIterationNumber], priceInOrder);
//                lineNumber++;
//            }
//            productIterationNumber++;
//        }
//        System.out.println("Total: " + total + " rubles");
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("basket.txt");
        Basket2 basket = null;
        if (!file.exists()) {
            try {
                file.createNewFile();
                //надо сделать чтобы создавался с шаблонным содержимым
                basket = Basket2.loadFromTxtFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            basket = Basket2.loadFromTxtFile(file);
        }




        basket.printCart();
        while (true) {
            System.out.println("Choose a product, quantity or input end");
            System.out.print(">>");
            String input = scanner.nextLine();
            if (input.toLowerCase().equals("end")) {
//!!                result();
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println("You haven't written two numbers, please try again");
                continue;
            }
            //надо подумать как basket.getGoodsList сделать чтоб он воспринимал разные basket
                try {
                    if (Integer.parseInt(parts[0]) > basket.getGoodsList().length || Integer.parseInt(parts[0]) <= 0) {
                        System.out.println("Please input a correct product number");
                        continue;
                    }
                    if (Integer.parseInt(parts[1]) < 0) {
                    System.out.println("Goods quantity should be a positive number," +
                        " please input a correct number");
                    continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You entered not a number, please input a number");
                    continue;
                }
            int productNumber = (Integer.parseInt(parts[0]) - 1);
            int quantity = Integer.parseInt(parts[1]);

            basket.addToCart(productNumber, quantity);
            basket.saveTxt(file);
        }
    }
}