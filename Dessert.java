public class Dessert extends Food
{
   private int calories;
    private String nuts;
    
    
    
    public Dessert(){
        super();
        this.calories = 0;
        this.nuts = "no";
        
        
    }
       	public Dessert(String name, String desc, double price, int calories, String nuts){
		super(name, desc, price, "Dessert");
	    this.calories = calories;
        this.nuts = nuts;
		
	} 
	       
	       
	public Dessert(Dessert copy)
	{
		super(copy.getName(), copy.getDescription(), copy.getPrice(), copy.getType());
	    this.calories = copy.calories;
        this.nuts = copy.nuts;
		
	} 
	
	
	public int getCalories(){
	    return this.calories;
	}
	public String getNuts(){
	    return this.nuts;
	}
	public void setCalories(int calories){
	     this.calories = calories; 
	}
	public void setNuts(String nuts){
	    this.nuts = nuts;
	}
	
	
	
	public void print(){
	    super.print();
	    System.out.println("calories " + this.calories);
	    
	     System.out.println("Nuts " + this.nuts);
	    
	}
	
	
	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}