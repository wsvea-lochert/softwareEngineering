# softwareEngineering

#### Prototype for a flexsible booking application.

## Requirements to run the application (IMPORTANT)
#### These are the tools and versions we have used for this project, other versions of the tools may or may not work, so it is recommended to use exactly the versions that are stated below to avoid any potential problems:
- Java version 11
- Junit 5
- Maven 3.3.9

<hr>

## Table of contents for UNIT TESTS, contains classes and method index.
### 1 - BookingTest
#### BookingTest is used for testing methods accociated with the Booking Class. Finding events, booking tickets, removing the booked tickets from available tickets and adding tickets to sold tickets list is some of the functioanlity that is tested.

##### Index of unit tests:
- 1A - Finding events
- 1B - Check if ticket amount decreases properly
- 1C - Check if available tickets are removed from availableTickets list
- 1D - Check if sold list is updated correctly when tickets are sold

### 2 - EventManagerTest
#### EventManagerTest is used for testing methods associated with the EventManager class. EventManager contains methods for creating events, creating unique ID's for events, creating tickets ticket control and marking tickets as used. 

##### Index of unit tests: 
- 2A - Marking tickets as used
- 2B - Creating events
- 2C - Creating unique ID's for events
- 2D - Creating tickets 
- 2E - Ticket controll - failing correctly 
- 2F - Ticket controll - working correctly
- 2G - Showing data about my events 

### 3 - LoginCustomerTest
#### LoginCustomerTest is used for testing the method associated with the Login class. The only thing this method does is checking if a customer exists in the customerList.

##### Index of unit tests
- 3A - Returning the correct object
- 3B - Returning null if no object is found

### 4 - LoginOrganizerTest
#### LoginOrganizerTest is used for testing the method associated with the Login class. The only thing this method does is checking if a organizer exists in the organizerList.

##### Index of unit tests
- 4A - Returning the correct object
- 4B - Returning null if no object is found

### 5 - NewUserAccountTest
#### NewUserAccountTest is used for testing methods associated with the NewUserAccount class. NewUserAccount is mainly used for validating input from users, aswell as creating new user accounts.

##### Index of unit tests
- 5A - Validating string length
- 5B - Checking string length fails correctly 
- 5C - Validating emails
- 5D - Email validation fails correctly
- 5E - Validating passwords
- 5F - Password validation fails correctly
- 5G - Check if customer is added to list

### 6 - PaymentTest
#### PaymentTest is used for testing methods associated with the Payment class. Payment contains various methods for validating card information, such as cardnumber, cvc and date. 

##### Index of unit tests
- 6A - Validating card number
- 6B - Date formatting
- 6C - Making sure the date pattern works
- 6D - Validating CVC
- 6E - Validating date

### 7 - SearchEventTest
#### SearchEventTest is used for testing methods associated with the SearchEvent class. SearchEvent contains two methods for searching after event by event name, and searching trought different categories.

##### Index of unit tests
- 7A - Check if an array of Event objects are returned when searching for event names
- 7B - Check if empty array is returned when no matches are found when searching for event names
- 7C - Check if an array of Event objects are returned when searching for categories
- 7D - Check if empty array is returned when no matches are found when searching for categories

<hr>

## Developers

- Martin Skåksrud
- Elin Skaret Larald
- Enis Jasharaj
- Ingrid Elise Krogh Dahl
- William Svea-Lochert    


<hr>


<img height="87" width="421" src="https://blogg.hiof.no/fremmedsprak/files/2015/02/logo_hiof_sort.png"> </img>


