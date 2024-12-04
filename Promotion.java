import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Promotion {
    private static Promotion instance;
    private static float currentDiscount=0;
    private static HashSet<String> applicableTypes=new HashSet<>();

    private Promotion() {}

    public static Promotion getInstance(){
        if(instance==null){
            instance=new Promotion();
        }
        return instance;
    }
    public static float getCurrentDiscount() {
        return currentDiscount;
    }

    public void setCurrentDiscount(float currentDiscount) {
        this.currentDiscount = currentDiscount;
    }

    public void addType(String productType){
        applicableTypes.add(productType);
    }

    public static HashSet<String> getApplicableTypes(){
        return applicableTypes;
    }


}
