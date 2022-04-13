package businesslogic;

public class Discounts {

private String discountType;

public String getDiscountType() { return discountType; }

    public int getCustomerID() { return discountID; }

    public String getVariableBusinessType() { return variableBusinessType; }

    public int getDiscountPercentage() { return discountPercentage; }

    public int getFlexibleLowRange() { return flexibleLowRange; }

    public int getFlexibleHighRange() { return flexibleHighRange; }

    private String variableBusinessType;

    public void setDiscountID(int discountID) { this.discountID = discountID; }

    public void setDiscountType(String discountType) { this.discountType = discountType; }

    public void setVariableBusinessType(String variableBusinessType) { this.variableBusinessType = variableBusinessType; }

    public void setDiscountPercentage(int discountPercentage) { this.discountPercentage = discountPercentage; }

    public void setFlexibleLowRange(int flexibleLowRange) { this.flexibleLowRange = flexibleLowRange; }

    public void setFlexibleHighRange(int flexibleHighRange) { this.flexibleHighRange = flexibleHighRange; }

    private int discountPercentage,flexibleLowRange,flexibleHighRange,discountID;



}
