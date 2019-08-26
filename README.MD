Steps to run this Program

This Program can be run via 3 ways:

Requirements :-
1. Maven
2. Java 1.8

Note : 
    - This program accepts 2 input in which one is total number of prime numbers and start number of prime number. 
    - The default value of total number of prime number is 10 and start is 1 

Step 1  :- 
    1. Load This project into IDE
    2. Maven plugin is required in IDE to build this project
    2. Execute PrimeTable.java to call the program
    3. Use PrimeTableTest.java to run test cases

Step 2  :- 
    1. Pass the total number of prime number in PrimeTable.java class and run it
    2. Optionally you can pass the second parameter of start of prime number and run PrimeTable.java

Step 3  :-
    1. Open the directory of project in terminal.
    2. Make sure java and maven are added in path (To check run "java -version" and "mvn")
    3. Build the project using the command  "mvn clean compile assembly:single"
    4. Execute the jar file from target folder - "java -jar target/prime-table-1.0.0-SNAPSHOT-jar-with-dependencies.jar"
    5. Enter total number of Prime Number

Its output will be a table having selected range of prime numbers in first row followed by its multiplication in each row



Answers to Questions :- 

Consider complexity. How fast does your code run?
-> Complexity is being considered while checking if a number is prime. Complexity is O(log(n))

How does it scale?
-> The code does all manipulations line by line while printing on console. So, there is no overhead of on-memory load. In-case memory usage goes high, we can scale it by writing each 10 results in file and then clubbing them at the end of execution.

Consider cases where we want N primes. 
-> This code is written to accept the number of prime numbers to be computed from user. It takes minimal time complexity.

Do not use the Prime class from stdlib (write your own code). 
-> Java Prime class is not used.

Write tests using Selenium/TestNG. Try to demonstrate TDD/BDD. 
-> TestNG is used. And, both TDD and BDD kind of tests are written. BDD consist of integration test for this problem.

If you’re using external dependencies please specify those dependencies and how to install them. 
-> TestNg dependency is used with maven-assembly-plugin
