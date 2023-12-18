/**************************\
* Name:     Jared Flynn    *
* Course:   CS-320         *
* Date:     12 Nov 2023    *
\**************************/

package ContactServiceTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ContactServicePkg.ContactService;

class ContactServiceTest {
				
		@BeforeAll
		static void beforeClass() throws Exception {
		}
		
		@AfterAll
		static void afterClass() throws Exception {
		}
		
		@BeforeEach
		void setUp() throws Exception {
		}
		
		@AfterEach
		void tearDown() throws Exception {
				ContactService.contactList.removeAll(ContactService.contactList);
		}
		
		
		
		@Test
		final void testAddContact() {
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				// Create a ContactService object to create a contact for test
				ContactService test = new ContactService();
				test.addContact(contactId, firstName, lastName, phoneNum, address);
				
				assertTrue(!(ContactService.contactList.isEmpty()));
				assertEquals(ContactService.contactList.get(0).getContactId(), "11111");
				assertEquals(ContactService.contactList.get(0).getFirstName(), "Jared");
				assertEquals(ContactService.contactList.get(0).getLastName(), "Flynn");
				assertEquals(ContactService.contactList.get(0).getPhoneNum(), "8005551111");
				assertEquals(ContactService.contactList.get(0).getAddress(), "111 1st Ave");
		}
		
		@Test
		final void testAddManyContacts() {
				
				// Create a ContactService object to create contacts for test
				ContactService test = new ContactService();
				test.addContact("11111", "Jared", "Flynn", "8005551111", "111 1st Ave");
				test.addContact("22222", "Jerod", "Flinn", "8005552222", "222 2nd Ave");
				test.addContact("33333", "Gerad", "Phlin", "8005553333", "333 3rd Ave");
				
				final int listSize = ContactService.contactList.size();
				assertEquals(3, listSize);
				
				// Assertions for the addition of each new contact
				assertTrue(!(ContactService.contactList.isEmpty()));
				assertEquals(ContactService.contactList.get(0).getContactId(), "11111");
				assertEquals(ContactService.contactList.get(0).getFirstName(), "Jared");
				assertEquals(ContactService.contactList.get(0).getLastName(), "Flynn");
				assertEquals(ContactService.contactList.get(0).getPhoneNum(), "8005551111");
				assertEquals(ContactService.contactList.get(0).getAddress(), "111 1st Ave");
				
				assertTrue(!(ContactService.contactList.isEmpty()));
				assertEquals(ContactService.contactList.get(1).getContactId(), "22222");
				assertEquals(ContactService.contactList.get(1).getFirstName(), "Jerod");
				assertEquals(ContactService.contactList.get(1).getLastName(), "Flinn");
				assertEquals(ContactService.contactList.get(1).getPhoneNum(), "8005552222");
				assertEquals(ContactService.contactList.get(1).getAddress(), "222 2nd Ave");
				
				assertTrue(!(ContactService.contactList.isEmpty()));
				assertEquals(ContactService.contactList.get(2).getContactId(), "33333");
				assertEquals(ContactService.contactList.get(2).getFirstName(), "Gerad");
				assertEquals(ContactService.contactList.get(2).getLastName(), "Phlin");
				assertEquals(ContactService.contactList.get(2).getPhoneNum(), "8005553333");
				assertEquals(ContactService.contactList.get(2).getAddress(), "333 3rd Ave");
		}
		
		@Test
		final void testDuplicateContactId() {
				
				// Create a ContactService object to create a contact for test
				ContactService test = new ContactService();
				test.addContact("11111", "Jared", "Flynn", "8005551111", "111 1st Ave");
				
				
				Assertions.assertThrows(IllegalArgumentException.class, () ->{
						test.addContact("11111", "Jorge", "Jones", "8005554444", "444 4th Ave");
				});
		}
		
		@Test
		final void testDeleteContact() throws Exception {
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				// Create a ContactService object to create a contact for test
				ContactService test = new ContactService();
				test.addContact(contactId, firstName, lastName, phoneNum, address);
				
				assertTrue(!(ContactService.contactList.isEmpty()));
				
				if (!(ContactService.contactList.isEmpty())) {
						test.deleteContact(contactId);
				}
				
				assertTrue(ContactService.contactList.isEmpty());
		}

		final void testUpdateFirstName() throws Exception {
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				// Create a ContactService object to create a contact for test
				ContactService test = new ContactService();
				test.addContact(contactId, firstName, lastName, phoneNum, address);
				
				// Declare test string
				String testString = "Jorge";
				test.updateFirstName(contactId, testString);
				
				assertEquals(ContactService.contactList.get(0).getFirstName(), "Jorge");
		}
		
		final void testUpdateFirstNameTooLong() throws Exception {
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				// Create a ContactService object to create a contact for test
				ContactService test = new ContactService();
				test.addContact(contactId, firstName, lastName, phoneNum, address);
				
				// Declare test string
				String testString = "Jorge1234567890";
				
				Assertions.assertThrows(IllegalArgumentException.class, () ->{
						test.updateFirstName("11111", testString);
				});
		}
		
		@Test
		final void testUpdateFirstNameNull() throws Exception{
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				// Create a ContactService object to create a contact for test
				ContactService test = new ContactService();
				test.addContact(contactId, firstName, lastName, phoneNum, address);
				
				// Declare test string
				String testString = null;
				
				Assertions.assertThrows(IllegalArgumentException.class, () ->{
						test.updateFirstName("11111", testString);
				});
		}

		final void testUpdateLastName() throws Exception {
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				// Create a ContactService object to create a contact for test
				ContactService test = new ContactService();
				test.addContact(contactId, firstName, lastName, phoneNum, address);
				
				// Declare test string
				String testString = "Jones";
				test.updateLastName(contactId, testString);
				
				assertEquals(ContactService.contactList.get(0).getLastName(), "Jones");
		}
		
		final void testUpdateLastNameTooLong() throws Exception {
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				// Create a ContactService object to create a contact for test
				ContactService test = new ContactService();
				test.addContact(contactId, firstName, lastName, phoneNum, address);
				
				// Declare test string
				String testString = "Jones1234567890";
				
				Assertions.assertThrows(IllegalArgumentException.class, () ->{
						test.updateLastName("11111", testString);
				});
		}
		
		@Test
		final void testUpdateLastNameNull() throws Exception{
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				// Create a ContactService object to create a contact for test
				ContactService test = new ContactService();
				test.addContact(contactId, firstName, lastName, phoneNum, address);
				
				// Declare test string
				String testString = null;
				
				Assertions.assertThrows(IllegalArgumentException.class, () ->{
						test.updateLastName("11111", testString);
				});
		}
		
		final void testUpdatePhoneNum() throws Exception {
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				// Create a ContactService object to create a contact for test
				ContactService test = new ContactService();
				test.addContact(contactId, firstName, lastName, phoneNum, address);
				
				// Declare test string
				String testString = "8005554444";
				test.updatePhoneNum(contactId, testString);
				
				assertEquals(ContactService.contactList.get(0).getPhoneNum(), "8005554444");
		}
		
		final void testUpdatePhoneNumTooLong() throws Exception{
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				// Create a ContactService object to create a contact for test
				ContactService test = new ContactService();
				test.addContact(contactId, firstName, lastName, phoneNum, address);
				
				String testString = "8005554444234523452345";
				
				Assertions.assertThrows(IllegalArgumentException.class, () ->{
						test.updatePhoneNum("11111", testString);
				});
		}
		
		final void testUpdatePhoneNumTooShort() throws Exception{
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				// Create a ContactService object to create a contact for test
				ContactService test = new ContactService();
				test.addContact(contactId, firstName, lastName, phoneNum, address);
				
				String testString = "800";
				
				Assertions.assertThrows(IllegalArgumentException.class, () ->{
						test.updatePhoneNum("11111", testString);
				});
		}
		
		
		final void testUpdatePhoneNumNull() throws Exception{
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				// Create a ContactService object to create a contact for test
				ContactService test = new ContactService();
				test.addContact(contactId, firstName, lastName, phoneNum, address);
				
				String testString = null;
				
				Assertions.assertThrows(IllegalArgumentException.class, () ->{
						test.updatePhoneNum("11111", testString);
				});
		}

		
		final void testUpdatePhoneNumDigits() throws Exception{
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				// Create a ContactService object to create a contact for test
				ContactService test = new ContactService();
				test.addContact(contactId, firstName, lastName, phoneNum, address);
				
				String testString = "(800)555-4444#$%@#$";
				
				Assertions.assertThrows(IllegalArgumentException.class, () ->{
						test.updatePhoneNum("11111", testString);
				});
		}
		
		final void testUpdateAddress() throws Exception {
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				// Create a ContactService object to create a contact for test
				ContactService test = new ContactService();
				test.addContact(contactId, firstName, lastName, phoneNum, address);
				
				// Declare test string
				String testString = "444 4th Ave";
				test.updateAddress(contactId, testString);
				
				assertEquals(ContactService.contactList.get(0).getAddress(), "444 4th Ave");
		}
		
		final void testUpdateAddressTooLong() throws Exception{
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				// Create a ContactService object to create a contact for test
				ContactService test = new ContactService();
				test.addContact(contactId, firstName, lastName, phoneNum, address);
				
				String testString = "444 4th Ave asdfasdfasdfasdasdfasdfasdfasdfa"
						+ "asdfasdfasdfasdfasdfasdfasdfasdfasdfas4444234523452345";
				
				Assertions.assertThrows(IllegalArgumentException.class, () ->{
						test.updateAddress("11111", testString);
				});
		}
		
		final void testUpdateAddressNull() throws Exception{
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				// Create a ContactService object to create a contact for test
				ContactService test = new ContactService();
				test.addContact(contactId, firstName, lastName, phoneNum, address);
				
				String testString = null;
				
				Assertions.assertThrows(IllegalArgumentException.class, () ->{
						test.updateAddress("11111", testString);
				});
		}
		
}
