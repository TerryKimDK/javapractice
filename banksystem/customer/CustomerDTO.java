package customer;

public class CustomerDTO {
    private String customerName;
    private long customerPhone;
    private String customerAddress;
    private String customerRRN;
    private String customerGender;
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public Long getCustomerPhone() {
        return customerPhone;
    }
    public void setCustomerPhone(Long customerPhone) {
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
        return "CustomerDTO{" +
                "customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerRRN='" + customerRRN + '\'' +
                ", customerGender='" + customerGender + '\'' +
                '}';
    }
}