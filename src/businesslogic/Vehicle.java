package businesslogic;

public class Vehicle {

    public String getNumberPlate() { return numberPlate; }

    public String getColour() { return colour; }

    public String getLastMoT() { return lastMoT; }

    public String getMake() { return make; }

    public String getModel() { return model; }

    public void setNumberPlate(String numberPlate) { this.numberPlate = numberPlate; }

    public void setColour(String colour) { this.colour = colour; }

    public void setLastMoT(String lastMoT) {this.lastMoT = lastMoT;}

    public void setMake(String make) { this.make = make; }

    public void setModel(String model) { this.model = model; }

    private String numberPlate,colour,lastMoT,make,model;

public Vehicle(){

}

}
