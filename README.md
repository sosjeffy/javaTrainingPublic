# Jeff's Repo
## Week 1
### Stringy.java 
Both of the below functions are called and tested in the main function:
1. reverso() reverses a string
2. containsSameChars() checks whether two given strings contain the same set of characters and have the same length

### ThrowingGames.java
Both of the below functions are called in the main function. LostGameException is caught in main. By running main, you'd get thrown right into the "game"
1. LostGameException is a custom exception thrown when imaThrow() is called
2. imaThrow()'s only purpose is to throw
3. startGame() is the program that accepts numbers from the user through CLI and handles all the possible unchecked exceptions that can occur

### Hashbrown.java
Both of the below functions are called and demonstrated in the main function. Stream map() example is also accomplished within main()
1. hashMapping() creates and adds and removes elements on a HashMap<String, String>
2. linkedHashMapping() creates and adds and removes elements on a LinkedHashMap<String, String>

### Threading Folder
1. Futures.java demonstrates usage of CompletableFuture
2. MultiThreadr.java demonstrates usage of multithreading

## Week 2
### DSA.java
1. vowelCounter() counts the number of vowels in a given string
2. secondLargest() finds the second-largest number in an unordered array of positive integers. It returns -1 if the array is too short.
3. Stack class: A stack is implemented using a custom-made Node class to simulate a linked list.

### CC Folder
1. ccdata folder contains example files to process and example writeouts based on those inputs
2. parsers folder contains file parser implementations for various file types
3. writers folder contains file writer implementations for various file writeout types
4. AmExCC, CreditCard, MasterCC, VisaCC are classes to represent various credit card types
5. DesignPatterns.java is the main class that provides an example on how everything comes together
Parser reads file of the type its meant for -> data is converted to credit cards -> credit cards are converted and written back to files

## Week 3
### JDBC Example
1. Employee.java (in com.example.demo) is a class representing an Employee object with basic getter and setters
2. EmployeeRepository.java creates a bean with a database connection and methods for initializing the Employee table, clearing the table, inserting Employees into the table, and getting a list of all employees
3. DemoApplication: Autowires employeeRepository and runs a function that tests out Employee Repository functionality after the Spring application runs 

### BinaryTree.java
Basic implementation of binary tree for a DSA2 problem, with features for insertion, getters, and setters

### DSA2.java
1. strLength() finds length of a string without using built-in methods. Two possible implementations are given. Time complexity is O(n), where n is the length of the string
2. removeDupes() removes duplicates from an unsorted LinkedList created by my custom Node class. Time and space complexity is O(n), where n is the number of nodes in the LinkedList
3. printLeafNode() takes the head of a BinaryTree and prints out found leaf nodes. The binary tree is traversed through breadth first search
4. findTargetIndex() takes two arguments, an integer array and an integer to search for (aka "target"). utilizes binary search to accomplish a search time in O(logn) time complexity, where n is the length of the array. Returns index where we found that number

### Spring Boot Rest API (SBRA)
Run DemoApplication.java to start the Spring application. Please note that all requests will need the key "Authorization" with value of "abc1234567890" in the request header.
1. controller folder: Contains RestControllers that handles all incoming requests. Methods here calls upon services to accomplish the request
2. dto folder: Contain DTO (data transfer object) classes meant for receiving/sending data through api. May contain less information than entities
3. entity folder: Entity classes that represent objects in databases
4. interfaces folder: Contains converter interfaces for dtos/entities to implement for easier conversion between types
5. repository folder: Classes representing our various repositories. If this is not working, note that you need to start the mysql server via `mysql.server start`
6. service folder: Contains service interfaces and their implementations. Service implementations interact with the required repositories to accomplish some task
7. utility folder: Somewhat of a miscellaneous folder that contains a RestControllerAdvice to handle validation exceptions in our REST API and a filter to log incoming requests before they are seen by the DispatchServlet. There is also a filter to refuse requests made out to the wrong URI or without the correct Authorization key.
8. test folder: Contains tests for the basic functionalities of each of the controllers