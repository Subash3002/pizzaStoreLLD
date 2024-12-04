import java.util.HashMap;

public class Sauce {
    private String sauceName;
    public static HashMap<String,Sauce> availableSauces=new HashMap<>();

    public Sauce(String sauceName) {
        this.sauceName = sauceName;
        availableSauces.put(sauceName,this);
    }
    public String getSauceName() {
        return sauceName;
    }

    public void setSauceName(String sauceName) {
        this.sauceName = sauceName;
    }

    public static void displaySauces(){
        int i=1;
        for(String sauce:availableSauces.keySet()){
            System.out.println(i+++"."+sauce);
        }
    }
}
