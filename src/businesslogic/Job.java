package businesslogic;

public class Job {

    private String customerName,numberPlate,make,model,telephone,notes,status;
    private int jobID;

    public int getJobID() { return jobID; }

    public String getCustomerName() { return customerName; }

    public String getNumberPlate() {return numberPlate; }

    public String getMake() { return make; }

    public String getModel() { return model; }

    public String getTelephone() { return telephone; }

    public String getNotes() { return notes; }

    public String getStatus() { return status; }

    public void setJobID(int jobID) { this.jobID = jobID; }

    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public void setNumberPlate(String numberPlate) { this.numberPlate = numberPlate; }

    public void setMake(String make) { this.make = make; }

    public void setModel(String model) { this.model = model; }

    public void setTelephone(String telephone) { this.telephone = telephone; }

    public void setNotes(String notes) { this.notes = notes; }

    public void setStatus(String status) { this.status = status; }

    public Job(){

    }
}
