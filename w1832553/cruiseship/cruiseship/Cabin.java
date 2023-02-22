package cruiseship;

public class Cabin {

//	initialise the variables 
	
	String mainName;
	int guestsInCabin;
	
	
	public Cabin() {
		mainName = "k";
		System.out.println(" made a room");
		
	}
	
	public void setName (String aName) {
		System.out.println("add name class method ");
		mainName = aName;
		
	}
	
	public String getName () { 
		return mainName;
		
	}
}
