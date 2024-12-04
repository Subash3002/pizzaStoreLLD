public class Order {
    private String productType;
    private String orderName;
    private float orderCost;


    public Order(String productType,String orderName, float orderCost) {
        this.productType=productType;
        this.orderName = orderName;
        this.orderCost = orderCost;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public float getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(float orderCost) {
        this.orderCost = orderCost;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
