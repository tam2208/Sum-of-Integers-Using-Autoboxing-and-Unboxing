📌 Nimbus Java Assignment

This project demonstrates Java concepts such as Autoboxing, Unboxing, Serialization, File Handling, and Efficient Data Processing.
It is a menu-driven console application with three main parts.

🚀 Features
1. Sum of Integers Using Autoboxing and Unboxing

Accepts multiple integer inputs as strings.

Uses Integer.parseInt() for parsing.

Stores them in ArrayList<Integer>.

Demonstrates:

Autoboxing (int → Integer) when adding to the list.

Unboxing (Integer → int) during summation.

Example:

Enter integers (type 'stop' to finish):
10
20
30
stop
The sum of entered integers is: 60

2. Student Serialization and Deserialization

Student class implements Serializable.

Program:

Accepts Student ID, Name, and Grade from user.

Serializes the object to student.ser.

Deserializes the object from file.

Displays the student details.

Example:

Enter Student ID: 101
Enter Student Name: Alice
Enter Grade: A
Student object serialized to student.ser
Deserialized Student:
StudentID: 101
Name: Alice
Grade: A

3. Employee Management System Using File Handling

Menu-driven system for managing employees:

Add Employee

Appends new employee record to employees.txt.

Display All Employees

Reads from file and prints all records.

Back to Main Menu

Uses BufferedWriter/BufferedReader for file handling.

Example:

--- Employee Management ---
1. Add Employee
2. Display All Employees
3. Back to Main Menu


After adding two employees:

--- Employee Records ---
ID: 201, Name: Bob, Designation: Manager, Salary: 75000.0
ID: 202, Name: Carol, Designation: Developer, Salary: 60000.0

🛠️ Technologies Used

Java SE

Concepts:

Autoboxing & Unboxing

Serialization / Deserialization

File Handling (Text Files)

Menu-driven console interaction with Scanner

📂 File Structure
NimbusAssignment.java    # Main program file
student.ser              # Serialized student object (auto-created)
employees.txt            # Employee records (auto-created/updated)

▶️ How to Run

Compile the program:

javac NimbusAssignment.java


Run:

java NimbusAssignment


Follow on-screen menu options.

✅ Sample Run
=== Nimbus Java Assignment ===
1. Sum of Integers (Autoboxing/Unboxing)
2. Student Serialization/Deserialization
3. Employee Management System (File Handling)
4. Exit
Enter your choice: 1

Enter integers (type 'stop' to finish):
5
15
20
stop
The sum of entered integers is: 40
