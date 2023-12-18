/**************************\
* Name:     Jared Flynn    *
* Course:   CS-320         *
* Date:     12 Nov 2023    *
\**************************/

package ContactServicePkg;

public class Contact {
		
		//Declaring the variables used
		private String contactId;
		private String firstName;
		private String lastName;
		private String phoneNum;
		private String address;
		
		//Constructor
		public Contact(String contactId, String firstName, String lastName, String phoneNum, String address) {
				// handling exceptions
				if (contactId == null || contactId.length() > 10) {
						throw new IllegalArgumentException("Invalid ID. Cannot be blank or exceed 10 characters.");
				}
				
				if (firstName == null || firstName.length() > 10) {
						throw new IllegalArgumentException("Invalid input. Cannot be blank or exceed 10 characters.");
				}
				
				if (lastName == null || lastName.length() > 10) {
						throw new IllegalArgumentException("Invalid input. Cannot be blank or exceed 10 characters.");
				}
				
				if (phoneNum == null || phoneNum.length() != 10) {
						throw new IllegalArgumentException("Invalid input. Phone number must contain 10 numbers.");
				}
				
				if (address == null || address.length() > 30) {
						throw new IllegalArgumentException("Invalid input. Cannot be blank or exceed 30 characters.");
				}
				
				this.contactId = contactId;
				this.firstName = firstName;
				this.lastName = lastName;
				this.phoneNum = phoneNum;
				this.address = address;
		}
		
		//Getters
		public final String getContactId() {
				return contactId;
		}
		
		public final String getFirstName() {
				return firstName;
		}
		
		public final String getLastName() {
				return lastName;
		}
		
		public final String getPhoneNum() {
				return phoneNum;
		}
		
		public final String getAddress() {
				return address;
		}
		
		
		// Setters
		// No set method for contactId as it cannot be modified
		public void setFirstName(String newFirstName) {
				if (newFirstName == null || newFirstName.length() > 10) {
						throw new IllegalArgumentException("Invalid input. Cannot be blank or exceed 10 characters.");
				}
				this.firstName = newFirstName;
		}
		
		public void setLastName(String newLastName) {
				if (newLastName == null || newLastName.length() > 10) {
						throw new IllegalArgumentException("Invalid input. Cannot be blank or exceed 10 characters.");
				}
				this.lastName = newLastName;
		}
		
		public void setPhoneNum(String newPhone) {
				
				//Using a Regular Expression to check if the string contains only digits
				String regex = "[0-9]+";
				
				if (newPhone == null || newPhone.length() != 10) {
						throw new IllegalArgumentException("Invalid input. Cannot be blank or exceed 10 characters.");
						} else if (!phoneNum.matches(regex)) {
								throw new IllegalArgumentException("Invalid Input. Must contain only numbers.");
						} else {
								this.phoneNum = newPhone;
				}
		}
		
		public void setAddress(String newAddress) {
				if (newAddress == null || newAddress.length() > 30) {
						throw new IllegalArgumentException("Invalid input. Cannot be blank or exceed 30 characters.");
				}
				this.address = newAddress;
		}
		
	}