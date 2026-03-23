public class Client {
    private String name;
    private String type; //must be a VIP, BUSINESS, or REGULAR
    private int arrivalOrder;

    public Client(String name, String type,  int arrivalOrder){
        setName(name);
        setType(type);
        setArrivalOrder(arrivalOrder);
    }

    //getters
    public String getName() {return name;}
    public String getType() {return type;}
    public int getArrivalOrder() {return arrivalOrder;}

    //setters 
    public void setName(String name) {
        if(name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be blank");
        else
            this.name = name.trim();    
    }

    public void setType(String type) {
        if(type == null)
            throw new IllegalArgumentException("Type cannot be null");

        String validType = type.trim().toUpperCase();
        if(!validType.equals("VIP") && !validType.equals("BUSINESS") && !validType.equals("REGULAR"))
            throw new IllegalArgumentException("Type must be VIP, BUSINESS, or REGULAR");
        else
            this.type = validType;
    }

    public void setArrivalOrder(int arrivalOrder) {
        this.arrivalOrder = arrivalOrder;
    }
    

    @Override
    public String toString() {
        return name + " (" + type + ", " + "order= " + arrivalOrder + ")";
    }


}
