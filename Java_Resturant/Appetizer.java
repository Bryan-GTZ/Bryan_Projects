public class Appetizer extends Food
{
   private int portions;
    private String temp;
    
    
    
    public Appetizer(){
        super();
        this.portions = 0;
        this.temp = "no";
        
        
    }
       	public Appetizer(String name, String desc, double price, int portions, String temp){
		super(name, desc, price, "Appetizer");
	    this.portions = portions;
        this.temp = temp;
		
	} 
	       
	       
	public Appetizer(Appetizer copy)
	{
		super(copy.getName(), copy.getDescription(), copy.getPrice(), copy.getType());
	    this.portions = copy.portions;
        this.temp = copy.temp;
		
	} 
	
	
	public int getPortions(){
	    return this.portions;
	}
	public String getTemp(){
	    return this.temp;
	}
	public void setPortions(int portions){
	     this.portions = portions; 
	}
	public void setTemp(String temp){
	    this.temp = temp;
	}
	
	
	
	public void print(){
	    super.print();
	    System.out.println("Portions " + this.portions);
	    
	     System.out.println("Cold or hot " + this.temp);
	    
	}
	
	
	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
