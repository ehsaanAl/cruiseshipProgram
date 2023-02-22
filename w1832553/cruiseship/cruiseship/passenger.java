package cruiseship;

public class passenger {

//	initialise the variables below 
	
	String firstName;
	String lastName; 
	int expenses;


	public passenger() {

	}

	// 
	public passenger(String firstName, String lastName, int expenses) {
//		predefined variables
		this.firstName = firstName;
		this.lastName = lastName;
		this.expenses = expenses;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public int getExpenses() {
		return expenses;
	}

	public void setExpenses(int expenses) {
		this.expenses = expenses;
	}
}


