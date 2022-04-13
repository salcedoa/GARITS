package businesslogic;

public class Vehicle {

    public String getNumberPlate() { return numberPlate; }

    public String getColour() { return colour; }

    public String getMake() { return make; }

    public String getModel() { return model; }

    public String getLastMoT() {
        return lastMoT;
    }

    public int getCustomerID() { return customerID; }

    public void setNumberPlate(String numberPlate) { this.numberPlate = numberPlate; }

    public void setColour(String colour) { this.colour = colour; }

    public void setMake(String make) { this.make = make; }

    public void setModel(String model) { this.model = model; }

    public void setCustomerID(int customerID) { this.customerID = customerID; }

    public void setLastMoT(String lastMoT) {
        this.lastMoT = lastMoT;
    }

    private String numberPlate,colour,make,model;
    private int customerID;
    private String lastMoT;

    public Vehicle(){

    }

}
