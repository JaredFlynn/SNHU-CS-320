/**************************\
* Name:     Jared Flynn    *
* Course:   CS-320         *
* Date:     12 Nov 2023    *
\**************************/

package ContactServicePkg;

import java.util.ArrayList;
import java.util.List;

public class ContactService{
	
/*		// Method to auto generate a unique ID for a contact
		private String uniqueContactId;
		private String newUniqueContactId() {
				uniqueContactId = UUID.randomUUID().toString().substring(0, Math.min(toString().length(),10));
				return uniqueContactId;
		}
*/
				
		// Create an array structure to store contacts
		public static List<Contact> contactList = new ArrayList<Contact>();
		
		/*
		//Display the entire list of contacts
		public void displayContact() {
				for (int i = 0; i < contactList.size(); i++) {
						System.out.println("\t Contact ID:   " + contactList.get(i).getContactId());
						System.out.println("\t First Name:   " + contactList.get(i).getFirstName());
						System.out.println("\t Last Name:	 " + contactList.get(i).getLastName());
						System.out.println("\t Phone Number: " + contactList.get(i).getPhoneNum());
						System.out.println("\t Address:		 " + contactList.get(i).getAddress() + "\n");
				}
		}
		*/
		
		// Method to add a new contact with a unique ID
		public void addContact(String contactId, String firstName, String lastName, String phoneNum, String address) {
				
				if(!(contactList.isEmpty())) {
						for(Contact contact:contactList) {
								if(contact.getContactId().equals(contactId)) {
										throw new IllegalArgumentException("This ID is already in use.");
								}
						}
				}
				
				Contact newContact = new Contact(contactId, firstName, lastName, phoneNum, address);
				contactList.add(newContact);
		}
		
		// Method to search list for a contact using a unique ID
		private Contact searchContact(String contactId) throws Exception{
				for(int i = 0; i < contactList.size(); i++) {
						if(contactList.get(i).getContactId().equals(contactId)) {
								return contactList.get(i);
						}
				}
				throw new Exception("Contact ID: " + contactId + " not found.");
		}
		
		public void deleteContact(String contactId) throws Exception {
				contactList.remove(searchContact(contactId));
		}
				
		public void updateFirstName(String contactId, String newFirstName) throws Exception{
				searchContact(contactId).setFirstName(newFirstName);
		}
		
		public void updateLastName(String contactId, String newLastName) throws Exception{
				searchContact(contactId).setLastName(newLastName);
		}
		
		public void updatePhoneNum(String contactId, String newPhone) throws Exception{
				searchContact(contactId).setPhoneNum(newPhone);
		}
		
		public void updateAddress(String contactId, String newAddress) throws Exception{
				searchContact(contactId).setAddress(newAddress);
		}
		
}
