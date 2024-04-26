package model;

public class Orders {
    private String orderID;
    private String phoneNumber;
    private String name;
    private int quantity;
    private double total;
    private int Status;

    public Orders(String orderIDs,String phoneNumbers,String name,int quantity,double total,int Status){
        this.orderID=orderIDs;
        this.phoneNumber=phoneNumbers;
        this.name=name;
        this.quantity=quantity;
        this.total=total;
        this.Status=Status;
    }
    public Orders(){}

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    /* public void setOrderId(String orderIDs){
            this.orderID=orderIDs;
        }
        public String getOrderId(){
            return orderID;
        }
        public void setPhonenumbers(String phoneNumbers){
            this.phoneNumber=phoneNumbers;
        }
        public String getPhonenumbers(){
            return phoneNumber;
        }
        public void setName(String name){
            this.name=name;
        }
        public String getName(){
            return name;
        }
        public void setQuanty(int quantity){
            this.quantity=quantity;
        }
        public int getQuanty(){
            return quantity;
        }
        public void setTotal(double total){
            this.total=total;
        }
        public double getTotal(){
            return total;
        }
        public void setStatus(int Status){
            this.Status=Status;
        }
        public int getStatus(){
            return Status;
        }*/
    public String toString(){
        return "{"+orderID+"-"+phoneNumber+"-"+name+"-"+quantity+"-"+total+"-"+Status+"}";
    }
}
