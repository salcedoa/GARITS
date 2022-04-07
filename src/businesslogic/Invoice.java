package businesslogic;

public class Invoice {


    public String getCustomerName() { return customerName; }

    public String getMake() { return make; }

    public String getModel() { return model; }

    public String getDescriptionDoneWork() { return descriptionDoneWork; }

    public float getTotalPartCost() { return totalPartCost; }

    public float getLabourCost() { return labourCost; }

    public float getAddedVAT() { return addedVAT; }

    public float getTotal() { return total; }

    public float getDiscountApplied() { return discountApplied; }

    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public void setMake(String make) { this.make = make; }

    public void setModel(String model) { this.model = model; }

    public void setDescriptionDoneWork(String descriptionDoneWork) { this.descriptionDoneWork = descriptionDoneWork; }

    public void setTotalPartCost(float totalPartCost) { this.totalPartCost = totalPartCost; }

    public void setLabourCost(float labourCost) { this.labourCost = labourCost; }

    public void setAddedVAT(float addedVAT) { this.addedVAT = addedVAT; }

    public void setTotal(float total) { this.total = total; }

    public void setDiscountApplied(float discountApplied) { this.discountApplied = discountApplied; }

    private String customerName,make,model,descriptionDoneWork;
    private float totalPartCost,labourCost,addedVAT,total,discountApplied;

    public Invoice(){

    }
}
