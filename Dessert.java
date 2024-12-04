import java.util.HashMap;

public class Dessert {
    private String dessertName;
    private float dessertCost;

    public static HashMap<String,Dessert> availableDesserts=new HashMap<>();

    public Dessert(String dessertName, float dessertCost) {
        this.dessertName = dessertName;
        this.dessertCost = dessertCost;
        availableDesserts.put(dessertName,this);
    }

    public String getDessertName() {
        return dessertName;
    }

    public void setDessertName(String dessertName) {
        this.dessertName = dessertName;
    }

    public float getDessertCost() {
        return dessertCost;
    }

    public void setDessertCost(float dessertCost) {
        this.dessertCost = dessertCost;
    }

    public static void displayDesserts(){
        int i=1;
        for(String dessert:availableDesserts.keySet()){
            System.out.println(i+++"."+dessert+" = "+availableDesserts.get(dessert).dessertCost);
        }
    }
}
