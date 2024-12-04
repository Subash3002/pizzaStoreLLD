import java.util.Scanner;

public class PizzaStore {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to pizza store");
        while (true){
            boolean flg=true;
            System.out.println("Choose your user type \n1.Admin\n2.User");
            int userType=sc.nextInt();
            sc.nextLine();
            if(userType==1){
                System.out.println("Logged in as Admin!");
                Admin admin= Admin.getInstance();
                do{
                    System.out.println("What you want to do?\n1.Add a Sauce\n2.Add a Topping\n3.Add a Drink\n4.Add a Dessert\n5.Set Promotion\n6.Update Promotion Eligible types\n7.Exit");
                    int choice=sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1 -> {
                            System.out.println("Enter the sauce name to be added to the store");
                            String sauceName=sc.nextLine();
                            admin.addSauce(sauceName);
                        }
                        case 2 -> {
                            System.out.println("Enter the topping name and cost to be added to the store");
                            String toppingName=sc.nextLine();
                            float toppingCost=sc.nextFloat();
                            sc.nextLine();
                            admin.addTopping(toppingName,toppingCost);
                        }
                        case 3 -> {
                            System.out.println("Enter the drink name and cost to be added to the store");
                            String drinkName=sc.nextLine();
                            float drinkCost=sc.nextFloat();
                            sc.nextLine();
                            admin.addDrink(drinkName,drinkCost);
                        }
                        case 4 -> {
                            System.out.println("Enter the dessert name and cost to be added to the store");
                            String dessertName=sc.nextLine();
                            float dessertCost=sc.nextFloat();
                            sc.nextLine();
                            admin.addDessert(dessertName,dessertCost);
                        }
                        case 5 -> {
                            System.out.println("Set the discount rate");
                            float discountRate=sc.nextFloat();
                            sc.nextLine();
                            admin.modifyDiscount(discountRate);
                        }
                        case 6 -> {
                            System.out.println("Add Product type for promotion");
                            String productType=sc.nextLine();
                            admin.addDiscountType(productType);
                        }
                        case 7 -> {
                            System.out.println("Exiting!!!");
                            flg=false;
                        }
                        default -> {
                            System.out.println("Invalid Choice!!!");
                            flg=false;
                        }
                    }
                }while (flg);
            }else if(userType==2){
                System.out.println("Logged in as User!");
                User user=new User();
                System.out.println("Choose the base type for the pizza ");
                String baseType=sc.nextLine();
                user.chooseBaseType(baseType);
                System.out.println("Choose the sauce you need or (no) if not needeed");
                Sauce.displaySauces();
                String sauceName=sc.nextLine();
                user.chooseSauce(sauceName);
                System.out.println("Choose the toppings to be added ");
                Topping.displayToppings();
                String toppingName=sc.nextLine();
                user.chooseTopping(toppingName);
                System.out.println("Need Add-Ons or enter no");
                Drink.displayDrinks();
                Dessert.displayDesserts();
                String addOn=sc.nextLine();
                if(Drink.availableDrinks.containsKey(addOn))user.chooseDrink(addOn);
                else if(Dessert.availableDesserts.containsKey(addOn))user.chooseDessert(addOn);
                else System.out.println("Not available!!!");
                user.calculateBill();

                System.out.println("Do you want to continue (Y/N)");
                char ch=sc.next().charAt(0);
                if(ch!='Y')return;
            }else{
                System.out.println("Invalid User type !!!");
                return;
            }
        }

    }
}
