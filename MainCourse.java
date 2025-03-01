public class MainCourse extends Food
{
   private String FreeVeg;
    private String Gluten;
    
    
    
    public MainCourse(){
        super();
        this.FreeVeg = "no";
        this.Gluten = "no";
        
        
    }
       	public MainCourse(String name, String desc, double price, String FreeVeg, String Gluten){
		super(name, desc, price, "MainCourse");
	    this.FreeVeg = FreeVeg;
        this.Gluten = Gluten;
		
	} 
	       
	       
	public MainCourse(MainCourse copy)
	{
		super(copy.getName(), copy.getDescription(), copy.getPrice(), copy.getType());
	    this.FreeVeg = copy.FreeVeg;
        this.Gluten = copy.Gluten;
		
	} 
	
	
	public String getFreeVeg(){
	    return this.FreeVeg;
	}
	public String getGluten(){
	    return this.Gluten;
	}
	public void setFreeVeg(String FreeVeg){
	     this.FreeVeg = FreeVeg; 
	}
	public void setGluten(String Gluten){
	    this.Gluten = Gluten;
	}
	
	
	
	public void print(){
	    super.print();
	    System.out.println("FreeVeg " + this.FreeVeg);
	    
	     System.out.println("Gluten " + this.Gluten);
	    
	}
	
	
	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}