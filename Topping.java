import java.util.HashMap;

public class Topping {
    private String toppingName;
    private float toppingPrice;
    public static HashMap<String,Topping> availableToppings=new HashMap<>();

    public Topping(String toppingName, float toppingPrice) {
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
        availableToppings.put(toppingName,this);
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public float getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(float toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    public static void displayToppings(){
        int i=1;
        for(String topping:availableToppings.keySet()){
            System.out.println(i+++"."+topping+" = "+availableToppings.get(topping).toppingPrice);
        }
    }
}
