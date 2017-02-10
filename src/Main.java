import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Auto> autos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Greet User
        System.out.println("Welcome to Inventory Tracker!");

        while (true) {

            // Prompt Menu
            System.out.println("==INVENTORY CONTROL PANEL==");
            System.out.println("PRESS 1 to see inventory list");
            System.out.println("PRESS 2 to add an item");
            System.out.println("PRESS 3 to remove an item");
            System.out.println("PRESS 4 to update the quantity in stock" + "\n");

            // Run method based on user's choice from prompt menu above

            String menuChoice = scanner.nextLine();


            switch (menuChoice) {

                case "1":
                    displayInventoryList();
                    break;

                case "2":
                    autos.add(createItem());
                    break;

                case "3":
                    deleteItem();
                    break;

                case "4":
                    updateAnItemQuantity();

            }

        }

    }


    static void displayInventoryList() {
        int i = 1;
        for (Auto auto : autos) {
            // System.out.println(i + ". " + auto.model + " (" + auto.quantity + " in stock)");
            System.out.printf("%d. %s (%s) - %d in stock! \n\n", i, auto.model, auto.segment, auto.quantity);
            i++;

        }
    }


    private static Auto createItem() {
        Scanner scanner = new Scanner(System.in);
        Auto auto = null;

        System.out.println("Enter new item name.");
        String autoModel = scanner.nextLine();

        System.out.println("Enter new item quantity currently in stock.");
        int autoQuantity = Integer.parseInt(scanner.nextLine());

        while (auto == null) {
            System.out.println("Choose an item category...");
            System.out.println("Enter: Sedan, Coupe, SUV, Pickup, or Minivan");
            String autoSegment = scanner.nextLine();

            switch (autoSegment) {

                case "Sedan":
                    auto = new Sedan(autoModel, autoQuantity, autoSegment);
                    break;

                case "Coupe":
                    auto = new Coupe(autoModel, autoQuantity, autoSegment);
                    break;

                case "SUV":
                    auto = new SUV(autoModel, autoQuantity, autoSegment);
                    break;

                case "Pickup":
                    auto = new Pickup(autoModel, autoQuantity, autoSegment);
                    break;

                case "Minivan":
                    auto = new Minivan(autoModel, autoQuantity, autoSegment);
                    break;

                default:
                    System.out.println("Not a valid selection.\n");


            }

        }

        return auto;

    }

    private static void deleteItem() {
        Scanner scanner = new Scanner(System.in);

        displayInventoryList();
        System.out.println("Enter item number to remove item.");

        int itemNum = Integer.parseInt(scanner.nextLine());
        autos.remove(itemNum - 1);

        System.out.println("Item removed.");

    }

    private static void updateAnItemQuantity() {
        Scanner scanner = new Scanner(System.in);

        displayInventoryList();
        System.out.println("Enter item number to update quantity.");

        int itemNum = Integer.parseInt(scanner.nextLine());
        Auto auto = autos.get(itemNum - 1);


        System.out.println("Enter the new quantity for the item you selected");
        int newQuantity = Integer.parseInt(scanner.nextLine());
        auto.quantity = newQuantity;
    }

}