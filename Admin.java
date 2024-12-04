public class Admin {
    private static Admin instance;
    private Admin() {}
    public static Admin getInstance(){
        if(instance==null){
            instance=new Admin();
        }
        return instance;
    }
    public Sauce addSauce(String sauceName){
        return new Sauce(sauceName);
    }

    public Topping addTopping(String toppingName, float toppingCost){
        return new Topping(toppingName,toppingCost);
    }

    public Drink addDrink(String drinkName, float drinkCost){
        return new Drink(drinkName,drinkCost);
    }

    public Dessert addDessert(String dessertName, float dessertCost){
        return new Dessert(dessertName,dessertCost);
    }

    public void modifyDiscount(float discount){
        Promotion promotion= Promotion.getInstance();
        promotion.setCurrentDiscount(discount);
    }

    public void addDiscountType(String productType){
        Promotion promotion= Promotion.getInstance();
        promotion.addType(productType);
    }

}
