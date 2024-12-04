import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class User {
    private Pizza pizza;
    private static List<Order> orders=new ArrayList<>();
    public User() {

    }
    public void chooseBaseType(String baseType){
        if(baseType.equals("Regular"))pizza=new RegularPizza();
        else if(baseType.equals("Wheat"))pizza=new WheatPizza();
        else System.out.println("Sorry,The base type you are requesting currently is not available!");
        orders.add(new Order("base",baseType,pizza.getCost()));
    }

    public Sauce chooseSauce(String sauceName){
        Sauce sauce=Sauce.availableSauces.get(sauceName);
        orders.add(new Order("sauce",sauce.getSauceName(),0));
        return sauce;
    }

    public Topping chooseTopping(String toppingName){
        Topping topping=Topping.availableToppings.get(toppingName);
        orders.add(new Order("topping",topping.getToppingName(),topping.getToppingPrice()));
        return topping;
    }

    public Object chooseAddOns(String addOnName){
        if(Drink.availableDrinks.containsKey(addOnName)){
            return Drink.availableDrinks.get(addOnName);
        }else if(Dessert.availableDesserts.containsKey(addOnName)){
            return Dessert.availableDesserts.get(addOnName);
        }
        System.out.println("The Add-On is not available!");
        return null;
    }
    public Drink chooseDrink(String drinkName){
        Drink drink=Drink.availableDrinks.get(drinkName);
        orders.add(new Order("drink",drink.getDrinkName(),drink.getDrinkCost()));
        return drink;
    }

    public Dessert chooseDessert(String dessertName){
        Dessert dessert=Dessert.availableDesserts.get(dessertName);
        orders.add(new Order("dessert",dessert.getDessertName(),dessert.getDessertCost()));
        return dessert;
    }

    public void displayOrders(){
        for(Order order:orders){
            System.out.println(order.getOrderName()+"->"+order.getOrderCost());
        }
    }

    public void calculateBill(){
        float totalCost=0;
        HashSet<String> promotionsCopy=Promotion.getApplicableTypes();
        int i=1;
        System.out.println("Your Orders : ");
        for(Order order:orders){
            totalCost+=order.getOrderCost();
            if(!order.getProductType().equals("sauce"))System.out.println(i+++"."+order.getOrderName()+"  "+order.getOrderCost());
            if(promotionsCopy.contains(order.getProductType()))promotionsCopy.remove(order.getProductType());
        }
        System.out.println("Total Cost = "+totalCost);
        if(promotionsCopy.isEmpty()){
            float discount=totalCost*(Promotion.getCurrentDiscount()/100);
            System.out.println("Discount = "+discount);
            System.out.println("Total Cost After Discount = "+(totalCost-discount));
        }
    }

}
