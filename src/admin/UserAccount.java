package admin;

public class UserAccount {

    public int getAccountID() { return accountID; };

    public String getAccountHolder() { return accountHolder; }

    public String getAccountType() { return accountType; }

    public String getUsername() { return username; }

    public String getPassword() { return password; }

    public float getHourlyRate() { return hourlyRate; }

    public void setAccountID(int accountID) { this.accountID = accountID; }

    public void setAccountHolder(String accountHolder) { this.accountHolder = accountHolder; }

    public void setAccountType(String accountType) { this.accountType = accountType; }

    public void setUsername(String username) { this.username = username; }

    public void setPassword(String password) { this.password = password; }

    public void setHourlyRate(float hourlyRate) { this.hourlyRate = hourlyRate; }

    private String accountHolder,accountType,username,password;
    private float hourlyRate;
    private int accountID;
}
