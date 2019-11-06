package database.rmi;

/**
 *
 * @author TechnoBoy
 */
public class Students implements java.io.Serializable {
    
    private int id,billamt,dueamt;

    public int getBillamt() {
        return billamt;
    }

    public void setBillamt(int billamt) {
        this.billamt = billamt;
    }

    public int getDueamt() {
        return dueamt;
    }

    public void setDueamt(int dueamt) {
        this.dueamt = dueamt;
    }
    private String name,address;
    
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    
    public void setAddress(String address){
        this.address=address;
    }
}
