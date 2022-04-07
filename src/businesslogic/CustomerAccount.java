package businesslogic;

public class CustomerAccount {

    public String getCustomerName() {
        return customerName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getContact() {
        return contact;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public Boolean getPayLate() {
        return payLate;
    }

    public Boolean getBusiness() {
        return isBusiness;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPayLate(Boolean payLate) {
        this.payLate = payLate;
    }

    public void setBusiness(Boolean business) {
        isBusiness = business;
    }

    private String customerName,addressLine1,addressLine2,addressLine3,postCode,contact,contactTitle,telephone,mobile;

    private Boolean payLate = false;
    private Boolean isBusiness = false;

    public CustomerAccount() {

    }

    // GETTERS AND SETTERS
}
