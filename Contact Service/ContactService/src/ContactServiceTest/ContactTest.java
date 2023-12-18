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

import ContactServicePkg.Contact;

class ContactTest{
		
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
		}
				
		
		@Test
		final void testCreateContact() {
				
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				
				Contact test = new Contact(contactId, firstName, lastName, phoneNum, address);
				
				
				assertEquals(test.getContactId(), contactId);
				assertEquals(test.getFirstName(), firstName);
				assertEquals(test.getLastName(), lastName);
				assertEquals(test.getPhoneNum(), phoneNum);
				assertEquals(test.getAddress(), address);
		}

		
		@Test
		final void testSetContactMethods() {
				
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				
				Contact test = new Contact(contactId, firstName, lastName, phoneNum, address);
				
				
				String newFirstName = "Jerod";
				String newLastName  = "Flinn";
				String newPhoneNum  = "8005552222";
				String newAddress   = "222 2nd Ave";
				
				test.setFirstName(newFirstName);
				test.setLastName(newLastName);
				test.setPhoneNum(newPhoneNum);
				test.setAddress(newAddress);
				
				assertEquals(test.getFirstName(), newFirstName);
				assertEquals(test.getLastName(), newLastName);
				assertEquals(test.getPhoneNum(), newPhoneNum);
				assertEquals(test.getAddress(), newAddress);
		}
		
		
		
		@Test
		final void testContactIdTooLong() {
			
				String contactId = "1111111111111111111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
						new Contact(contactId, firstName, lastName, phoneNum, address);
				});
		}
		
		@Test
		final void testContactIdNull() {
				
				String contactId = null;
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
						new Contact(contactId, firstName, lastName, phoneNum, address);
				});
		}

		@Test
		final void testFirstNameTooLong() {
			
				String contactId = "11111";
				String firstName = "Jared asdfasdfasdfasdf";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
						new Contact(contactId, firstName, lastName, phoneNum, address);
				});
		}
		
		@Test
		final void testFirstNameNull() {
				
				String contactId = "11111";
				String firstName = null;
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
						new Contact(contactId, firstName, lastName, phoneNum, address);
				});
		}

		@Test
		final void testLastNameTooLong() {
			
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn asdfasdfasdfasdf";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
						new Contact(contactId, firstName, lastName, phoneNum, address);
				});
		}
		
		@Test
		final void testLastNameNull() {
				
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = null;
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave";
				
				
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
						new Contact(contactId, firstName, lastName, phoneNum, address);
				});
		}

		@Test
		final void testPhoneNumTooLong() {
			
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111 00000000000";
				String address   = "111 1st Ave";
				
				
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
						new Contact(contactId, firstName, lastName, phoneNum, address);
				});
		}
		
		@Test
		final void testPhoneNumTooShort() {
				
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "800";
				String address   = "111 1st Ave";
				
				
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
						new Contact(contactId, firstName, lastName, phoneNum, address);
				});
		}
		
		@Test
		final void testPhoneNumDigits() {
			
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "(800) 555-1111 @#$%";
				String address   = "111 1st Ave";
				
				
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
						new Contact(contactId, firstName, lastName, phoneNum, address);
				});
		}
		
		@Test
		final void testPhoneNumNull() {
				
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = null;
				String address   = "111 1st Ave";
				
				
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
						new Contact(contactId, firstName, lastName, phoneNum, address);
				});
		}
		
		@Test
		final void testAdressTooLong() {
			
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = "111 1st Ave askdjf;lkajsdfkljasdklfja;sl";
				
				
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
						new Contact(contactId, firstName, lastName, phoneNum, address);
				});
		}
		
		@Test
		final void testAddressNull() {
				
				String contactId = "11111";
				String firstName = "Jared";
				String lastName  = "Flynn";
				String phoneNum  = "8005551111";
				String address   = null;
				
				
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
						new Contact(contactId, firstName, lastName, phoneNum, address);
				});
		}
		
}