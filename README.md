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
- 1A - checkIfFindEventWorks()
- 1B - checkIfTicketAmmountDecreasesProperly()
- 1C - checkIfTicketsAreRemovedFromAvailableTicketsList()
- 1D - checkIfTicketIsAddedToSoldTicketsListWhenPaymentIsAccepted()

### 2 - EventManagerTest
#### EventManagerTest is used for testing methods associated with the EventManager class. EventManager contains methods for creating events, creating unique ID's for events, creating tickets ticket control and marking tickets as used. 

##### Index of unit tests: 
- 2A - checkIfMarkTicketMethodWorks()
- 2B - checkIfEventIsAddedToListWhenCreateEventMethodIsCalled()
- 2C - checkIfCreateIndexWorks()
- 2D - checkIfCreateTicketsWorks()
- 2E - checkIfTicketControlFailsCorrectly()
- 2F - checkIfTicketControlWorks()
- 2G - checkIfEventStatisticsWorks()

### 3 - LoginCustomerTest
#### LoginCustomerTest is used for testing the method associated with the Login class. The only thing this method does is checking if a customer exists in the customerList.

##### Index of unit tests
- 3A - checkIfUserLoginReturnsObjectIfFounnd()
- 3B - checkIfUserLoginReturnsNullWhenNotFound()

### 4 - LoginOrganizerTest
#### LoginOrganizerTest is used for testing the method associated with the Login class. The only thing this method does is checking if a organizer exists in the organizerList.

##### Index of unit tests
- 4A - checkIfOrganizerLoginReturnsObjectIfFound()
- 4B - checkIfOrganizerLoginReturnsNullWhenNotFound()

### 5 - NewUserAccountTest
#### NewUserAccountTest is used for testing methods associated with the NewUserAccount class. NewUserAccount is mainly used for validating input from users, aswell as creating new user accounts.

##### Index of unit tests
- 5A - checkStringLengthTestReturnsTrue(String checkString)
- 5B - checkStringLengthTestReturnsFalse(String checkString)
- 5C - checkEmailTestReturnsTrue(String checkString)
- 5D - checkEmailTestReturnsFalse(String checkString)
- 5E - checkPasswordTestReturnsTrue(String checkString)
- 5F - checkPasswordTestReturnsFalse(String checkString)
- 5G - checkIfUserIsAddedToList()

### 6 - PaymentTest
#### PaymentTest is used for testing methods associated with the Payment class. Payment contains various methods for validating card information, such as cardnumber, cvc and date. 

##### Index of unit tests
- 6A - checkIfCardNumberValidationWorks()
- 6B - checkIfFixDateFormatterForCardPaymentWorks()
- 6C - checkIfDatePatternForPaymentCardWorks()
- 6D - checkIfCVCMethodsWorks(int cvc)
- 6E - checkIfDateCheckMethodWorks

### 7 - SearchEventTest
#### SearchEventTest is used for testing methods associated with the SearchEvent class. SearchEvent contains two methods for searching after event by event name, and searching trought different categories.

##### Index of unit tests
- 7A - checkIfSearchEventByEventNameReturnsArrayOfEventObject()
- 7B - checkIfSearchEventByEventNameReturnsEmptyArrayIfNoMatche()
- 7C - checkIfSearchEventByCategoryNameReturnsArrayOfEventObject()
- 7D - checkIfSearchEventByCategoryReturnsEmptyArrayIfNoMatche()

<hr>

## Developers

- Martin Skåksrud
- Elin Skaret Larald
- Enis Jasharaj
- Ingrid Elise Krogh Dahl
- William Svea-Lochert    


<hr>


<img height="87" width="421" src="https://blogg.hiof.no/fremmedsprak/files/2015/02/logo_hiof_sort.png"> </img>


