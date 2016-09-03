
public class AddressBookMain {
	public static AddressBook myAddressBook;
	public static void main(String[] args) {
		 myAddressBook = new AddressBook();
		while (true){
			System.out.println("\n--------------------------------\nWelcome to Kyla's address book!");
			System.out.println("(a)dd to address book");
			System.out.println("(r)emove from address book");
			System.out.println("(f)ind contact");
			System.out.println("(p)rint address book");
			System.out.println("(q)uit");
			String choice = ConsoleInput.input("\nWhat would you like to do?");
			
			if (choice.equalsIgnoreCase("a")){
				String fn = ConsoleInput.input("First Name:");
				String ln = ConsoleInput.input("Last Name:");
				String a = ConsoleInput.input("Address:");
				String p = ConsoleInput.input("Phone Number:");
				Contact newContact = new Contact(fn, ln,a,p);
				System.out.println("Contact Created...");
				String addChoice = ConsoleInput.input("\nWould you like to add to (f)ront, (e)nd or at an (i)nt? ");
				
				if (addChoice.equalsIgnoreCase("f")){
					myAddressBook.add(0, newContact);
				}
				
				if (addChoice.equalsIgnoreCase("i")){
					int i = ConsoleInput.inputInt("Int:");
					myAddressBook.add(i, newContact);
				}
				else if (addChoice.equalsIgnoreCase("e")){
					myAddressBook.add(newContact);
				}
			}
			
			else if (choice.equalsIgnoreCase("r")){
				Contact fContact = new Contact();
				if (myAddressBook.getSize() == 0)
					System.out.println("No contacts. Please add a new contact");
				if (myAddressBook.getSize() > 0){
					String removeChoice = ConsoleInput.input("Would you like to remove from (f)ront, (e)nd, at an (i)nt? ");
					if (removeChoice.equalsIgnoreCase("i")){
						int removeInt = ConsoleInput.inputInt("Int: ");
						fContact = myAddressBook.remove(removeInt);
					}
					
					if (removeChoice.equalsIgnoreCase("f")){
						fContact = myAddressBook.remove(0);
					}
					else if (removeChoice.equalsIgnoreCase("e")){
						fContact = myAddressBook.remove(myAddressBook.getSize()-1);
					}

					if (fContact == null){ System.out.println("\nNo contact found");}
					else System.out.println("\nContact Removed:"+ fContact.getFirstName()+" "+fContact.getLastName());
				}
			}
			else if (choice.equalsIgnoreCase("p")){
				if (myAddressBook.getSize() == 0){
					System.out.println("No contacts. Please add a new contact");
				}
				else
				System.out.println("\n");
				myAddressBook.print();
			}
			else if (choice.equalsIgnoreCase("f")){
				if (myAddressBook.getSize() == 0)
					System.out.println("No contacts. Please add a new contact");
				if (myAddressBook.getSize() > 0){
					int findInt = ConsoleInput.inputInt("Enter Int:");
					Contact fContact = myAddressBook.find(findInt);
					if (fContact == null){ System.out.println("\nNo contact found");}
					else System.out.println("\nContact Found: \n"+ fContact.getFirstName()+" "+fContact.getLastName() + "\n" +
					fContact.getAddress() + "\n" + fContact.getPhoneNumber());
				}
				
			}
			
			else if (choice.equalsIgnoreCase("q")){
				System.out.println("Goodbye");
				break;
				
			}
		}
	}

}
