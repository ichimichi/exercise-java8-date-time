### Java 8 Date and Time

- Create a class BankDepositExercise for calculating the dates for a  Bank fixed deposit

	Define the below static methods:
 
  - getMaturityDate(String investmentDate, Period duration): 
  		- Method should take investment date and duration as input and return the maturity date as a string in the format <dd-mmm-yyyy>
  - getInvestmentPeriod(String investmentDate, String maturityDate)
  		- Method should take investment date and maturity dates as input and return the duration as a string in the format <x years, y months>
 
   The investment and maturity date can be in either of the formats <dd/mm/yyyy, dd-mm-yyyy>. Test the above methods
 
 
- Create a class Tablet with attributes,tablet name, manufacturer, manufacture date and expiry date(LocalDate). 
	- Create a class DateTimeExercise with the following methods and variables
	  - create a variable tablets of type ArrayList<Tablet> and initialize with some tablet objects 
	
	  - getExpiringTables(int months):List<String>
	    - method should take number of months as parameter and return a List of tablet names expiring within the given months from today.
	
	  -	getExpiringTabletsSorted
	  	- return a  List of Tablets, in the ascending order of expiry date
	  	
	  - getTabletExpiryPeriod
	  	- return a Map with the tablet name as key and the period between the manufacture date and expiry date as value. 
	  	  The period should be a string containing years, months and days (ex: 1 year/s 2 month/s 5 day/s , 3 month/s 5 day/s, 3 year/s ..)
	  - getSameYearExpiry
	  	- Return a Map with key as manufacturer and value as list of tablet names which are manufactured in the current year and are already expired
    Test the above methods
	 
- Create a class WorkingDaysExercise with the below static method
	
	- getNextMonthsWorkingDays():List<String>
		- Method should return a List of String containing the working days for the next month given todays date.
		- Saturday and Sunday should be considered non working days
		- The date returned should be in format dd-mm-yyyy

- Create a class Utility with the below static method
	- getBusSchedule(String start, Duration frequency) : List<String>
		- Method should return a List of String containing the bus timings for a day given the start time and duration as parameters.
		- The timing in the list should be in 24 hour format hh:mm
