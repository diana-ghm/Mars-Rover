# Mars-Rover

#### I Design
The Mars Rover problem deals with moving rover objects inside a Mars plateau (seen as a graph). Each rover will have 2 coordinates x and y to represent the position in the plateau and a cardinal point representing the orientation of the rover (either if it faces North, South, East or West). Once on the plateau, the rover will be able to change its position (by moving one cell at a time) in the direction where it is facing, or change direction by rotating either left or right. 
All the rovers will be dealt with sequentially (as soon as rover number 1 finishes all moves, and has a final position in the plateau, rover number 2 will be next to start moving and so on). After all the rovers finish their actions, the program will output the new position for each of them (the 2 new coordinates x and y together with the new cardinal point).  

#### II Requirements
There are several options for running the progam...

---RUN IN AN IDE---
You can run the Mars Rover program in an IDE, such as Intellij or Eclipse, by copying the contents of the folder (the src folder containing the 2 classes Rover.java and Mars_Rover.java as well as the index.txt file) into a new project or by opening the existing Mars Rover project. 

---COMPILE AND RUN ON THE COMMAND LINE---
You can easily compile and run the program on the command line. You just need to change into the program directory into the "source" folder (src) and use the command:
javac Mars_Rover.java
in order to compile the Mars_Rover class on the command line. If javac is not recognised as an internal or external command, make sure you first set the environment path variable with the command: 
set path = "C:\Program Files\Java\jdk1.8.0_60\bin" (or change to the folder in which you installed jdk).
After compiling, you can run the program using the java command as following:
java Mars_Rover.
You will see the output of the problem in the command prompt.


#### III Implementation
The problem consists of 2 classes. One is Rover.java used to construct a rover object and maintaining its attributes (the coordinates, the cardinal point and also a boolean value to indicate if the current rover is placed inside the plateau or not), as well as a list of methods used to access or modify these attributes. The second class is Mars_Rover.java, used to read from the input file (with the help of a Scanner and a FileStream). It uses the information inside the text file to create a new plateau of given sizes (for the number of rows and columns) and sequentially add new rovers to that plateau, moving them according to the commands given. The plateau is created using a 2D matrix that stores objects of type Rover. Checks are being made before creating and adding each rover to the plateau to see if the coordinates give a cell inside the plateau and if the cardinal point is valid. Also, there are checks to see if the cell in which you want to add or move a rover is not already occupied (proper messages will be display to the command prompt if any of these assumptions is not satisfied).


#### IV Analysis
The complexity of the program depends on the size of the input file and the length of the sequences of moves for each rover (the program will read 2 line at a time in order to create a new rover, place it in the plateau, and move it by iterating through the sequence of moves and execute each one of them).  


#### V Testing
In a first phase, manual testing is performed by running the program on different types of input and considering corner cases (all done by changing input.txt file and running Mars_Rover class).
To ensure more reliaility in a faster way, automed testing is also performed using JUnit library (a unit testing framework for Java programming language). 
