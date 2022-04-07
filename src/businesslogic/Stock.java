package businesslogic;

public class Stock {

    public String getPartName() { return partName; }

    public String getPartType() { return partType; }

    public String getVehicle() { return vehicle; }

    public String getSoldIn() { return soldIn; }

    public String getManufacturer() { return manufacturer; }

    public float getManufacturerPrice() { return manufacturerPrice; }

    public float getCustomerCost() { return customerCost; }

    public int getStockLevel() { return stockLevel; }

    public int getLowLevelThreshold() { return lowLevelThreshold; }

    public int getOrdered() { return ordered; }

    private String partName,partType,vehicle,soldIn,manufacturer;
    private float manufacturerPrice,customerCost;
    private int stockLevel,lowLevelThreshold,ordered;


    public Stock(){

}
}
