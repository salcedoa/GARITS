package businesslogic;

public class Stock {

    public int getPartID() { return partID; }

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

    public void setPartID(int partID) { this.partID = partID; }

    public void setPartName(String partName) { this.partName = partName; }

    public void setPartType(String partType) { this.partType = partType; }

    public void setVehicle(String vehicle) { this.vehicle = vehicle; }

    public void setSoldIn(String soldIn) { this.soldIn = soldIn; }

    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public void setManufacturerPrice(float manufacturerPrice) { this.manufacturerPrice = manufacturerPrice; }

    public void setCustomerCost(float customerCost) { this.customerCost = customerCost; }

    public void setStockLevel(int stockLevel) { this.stockLevel = stockLevel; }

    public void setLowLevelThreshold(int lowLevelThreshold) { this.lowLevelThreshold = lowLevelThreshold; }

    public void setOrdered(int ordered) { this.ordered = ordered; }

    private String partName,partType,vehicle,soldIn,manufacturer;
    private float manufacturerPrice,customerCost;
    private int partID, stockLevel,lowLevelThreshold,ordered;


    public Stock(){

}
}
