package account;

public class AccountDTO {
    private String accountNumber;
    private int customerNumber;
    private int accountPW;
    private long balance;
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public int getCustomerNumber() {
        return customerNumber;
    }
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }
    public int getAccountPW() {
        return accountPW;
    }
    public void setAccountPW(int accountPW) {
        this.accountPW = accountPW;
    }
    public long getBalance() {
        return balance;
    }
    public void setBalance(long balance) {
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "AccountDTO [accountNumber=" + accountNumber + ", customerNumber=" + customerNumber + ", accountPW="
                + accountPW + ", balance=" + balance + "]";
    }

}