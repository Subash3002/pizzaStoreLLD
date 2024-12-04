import java.util.HashMap;

public class Drink {
    private String drinkName;
    private float drinkCost;

    public static HashMap<String,Drink> availableDrinks=new HashMap<>();

    public Drink(String drinkName, float drinkCost) {
        this.drinkName = drinkName;
        this.drinkCost = drinkCost;
        availableDrinks.put(drinkName,this);
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public float getDrinkCost() {
        return drinkCost;
    }

    public void setDrinkCost(float drinkCost) {
        this.drinkCost = drinkCost;
    }

    public static void displayDrinks(){
        int i=1;
        for(String drink:availableDrinks.keySet()){
            System.out.println(i+++"."+drink+" = "+availableDrinks.get(drink).drinkCost);
        }
    }
}
