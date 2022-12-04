import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("basket.txt");
        Basket2 basket = null;
        if (!file.exists()) {
            try {
                Files.copy(Path.of("template.txt"), Path.of("basket.txt"));
                basket = Basket2.loadFromTxtFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            basket = Basket2.loadFromTxtFile(file);
        }

        basket.printCart();
        while (true) {
            System.out.println("Choose a product, quantity or input end");
            System.out.print(">>");
            String input = scanner.nextLine();
            if (input.toLowerCase().equals("end")) {
                basket.result();
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println("You haven't written two numbers, please try again");
                continue;
            }

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