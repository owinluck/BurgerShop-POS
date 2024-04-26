package DB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import model.Orders;

public class List {

    private static List instance;
    private Node first;

    private  List(){

    }
    public void add(Orders data){
        Node n1=new Node(data);
        if(isEmpty()){
            first=n1;
        }else{
            Node lastNode=first;
            while(lastNode.next!=null){
                lastNode=lastNode.next;
            }
            lastNode.next=n1;
        }
    }
    public Orders get(int index){
        if(index>=0 && index<size()){
            int count=0;
            Node temp=first;
            while(count<index){
                temp=temp.next;
                count++;
            }
            return temp.data;
        }
        return null;
    }
    public int size(){
        int count=0;
        Node temp=first;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    public boolean isEmpty(){
        return first==null;
    }

    //---------------Get index-----------------------
    public int getindex(String data){
        Node temp=first;
        int index=0;
        while(temp!=null){
            if(temp.data.getPhoneNumber().equals(data)){
                return index;
            }
            index++;
            temp=temp.next;
        }
        return -1;
    }
    //--------------------Index Check---------------
    public boolean isIndexcheck(String data){
        return getindex(data) != -1;
    }

    public ObservableList<Orders> toArray(String num){
        Orders[] tempArray=new Orders[size()];

        ObservableList<Orders> obList= FXCollections.observableArrayList();

        int i=0;
        Node temp=first;
        while(temp!=null){
            tempArray[i++]=temp.data;
            if(num.equals(temp.data.getPhoneNumber())) {
                obList.add(temp.data);
            }
            temp=temp.next;
        }
        return obList;
    }

    public ObservableList<Orders> CustomerDetails(String customerID) {
        ObservableList<Orders> obList= FXCollections.observableArrayList();

        int i=0;
        Node temp=first;
        while(temp!=null){
            if(customerID.equals(temp.data.getPhoneNumber())) {
                obList.add(temp.data);
            }
            temp=temp.next;
        }
        return obList;
    }

    public ObservableList<Orders> placeOrder() {
        ObservableList<Orders> obList= FXCollections.observableArrayList();

        int i=0;
        Node temp=first;
        while(temp!=null){
            if(0==temp.data.getStatus()) {
                obList.add(temp.data);
            }
            temp=temp.next;
        }
        return obList;
    }

    public ObservableList<Orders> deleverOrder() {
        ObservableList<Orders> obList= FXCollections.observableArrayList();

        int i=0;
        Node temp=first;
        while(temp!=null){
            if(1==temp.data.getStatus()) {
                obList.add(temp.data);
            }
            temp=temp.next;
        }
        return obList;
    }

    public ObservableList<Orders> cancelOrder() {
        ObservableList<Orders> obList= FXCollections.observableArrayList();

        int i=0;
        Node temp=first;
        while(temp!=null){
            if(2==temp.data.getStatus()) {
                obList.add(temp.data);
            }
            temp=temp.next;
        }
        return obList;
    }

    class Node{
        private Orders data;
        private Node next;

        Node(Orders data){
            this.data=data;
        }
    }
    public static List getInstance(){
        if(instance==null){
            return instance=new List();
        }
        return instance;
    }
}
