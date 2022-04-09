package businesslogic;

public class Job {

    public String getCustomerName() { return customerName; }

    public String getVehicleID() {return vehicleID; }

    public String getMake() { return make; }

    public String getModel() { return model; }

    public String getTelephone() { return telephone; }

    public String getNotes() { return notes; }

    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public void setVehicleID(String vehicleID) { this.vehicleID = vehicleID; }

    public void setMake(String make) { this.make = make; }

    public void setModel(String model) { this.model = model; }

    public void setTelephone(String telephone) { this.telephone = telephone; }

    public void setNotes(String notes) { this.notes = notes; }

    private String customerName,vehicleID,make,model,telephone,notes;

    public Job(){

    }
}
