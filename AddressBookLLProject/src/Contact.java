public class Contact {
	public String firstName;
	public String lastName;
	public String phoneNumber;
	public String address;

	public Contact(){	
	}
	
	public Contact(String fn, String ln){
		firstName = fn;
		lastName = ln;
	}
	
	public Contact(String fn, String ln,String a, String p){
		firstName = fn;
		lastName = ln;
		address = a;
		phoneNumber = p;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString(){
		String contact =  getFirstName() + " " + getLastName() + ":\n" + getAddress() + "\n"+ getPhoneNumber() + "\n";
		return contact;
	}
}