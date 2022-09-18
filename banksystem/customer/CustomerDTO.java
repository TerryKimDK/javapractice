package customer;

public class CustomerDTO {
    private int customerNumber;
    private String customerName;
    private String customerPhone;
    private String customerAddress;
    private String customerRRN;
    private String customerGender;

    public int getCustomerNumber() {
        return customerNumber;
    }
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerPhone() {
        return customerPhone;
    }
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    public String getCustomerRRN() {
        return customerRRN;
    }
    public void setCustomerRRN(String customerRRN) {
        this.customerRRN = customerRRN;
    }
    public String getCustomerGender() {
        return customerGender;
    }
    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    @Override
    public String toString() {
        return "customerDTO [customerNumber=" + customerNumber + ", customerName=" + customerName + ", customerPhone="
                + customerPhone + ", customerAddress=" + customerAddress + ", customerRRN=" + customerRRN
                + ", customerGender=" + customerGender + "]";
    }
}