# CMP_SCI-2261-Java-OOP-Project-2-Container-Trucks

Project 2: Container Trucks
You can do it in intellij.
You can choose to work in groups of 2 for project2 or individually.
If you are working in groups, you have to write your partner's name in
comments when submitting on canvas. Please also submit your. java files and
outputs screenshots.
Grading Policy
Using your own creativity, Creating required classes, interfaces, methods ,objects,
functionality and interlinking them with details given -11 points
Required Output -8 points
Ease of understanding, maintainability of code -1 point
Task Description
In this project, you are required to implement a simulation of a Truck management
system. The main objective is to analyse the requests provided in input and carry out
the necessary actions.
There are truck terminals, and container trucks are moving between them. Trucks are
carrying the following types of containers and goods: basic, heavy, Refrigerator
trucks and tankers. Trucks need a certain amount of fuel to go from one Terminal to
another.
Also, as a significant remark, the signature of the methods and the field names that
you are going to implement can be adjusted according to your creativity. If a specific
method is not enforced by the project description, you can feel free to implement it
in your way (i.e. you can implement extra methods considering your own design
choice and creativity). However, you should also consider the proper usage of access
modifiers for preserving the desired visibility and accessibility throughout the project.
In other words, you should not define everything as “public”.
Class Hierarchy and Details
You are already provided with the following interfaces:
public interface ITruck {
/*
*
* You are responsible for all the compilation errors that originated
from the changes
* made in including the addition or removal of libraries.
*
*/
boolean goTo(Terminal p);
void reFuel(double newFuel);
boolean load(Container cont);
boolean unLoad(Container cont);
}
● ITerminal.java
public interface ITerminal {
/*
* You are responsible for all the compilation errors that originated
from the changes
* made in including the addition or removal of libraries.
*
*/
void incomingTrucks(Truck T);
void outgoingTruck(Truck T);
}
However, in this project, You can keep any number of classes that interact with each
other during execution according to your creativity. Therefore, before starting the
implementation, you are advised to allocate some time to understand the main logic
behind the design and the relation among the code pieces and try to draw a UML
class diagram for different classes.
Within the scope of this project, you are expected to implement these classes (which
will be explained in detail in the rest of this document):
1. Main.java
2. Terminal.java
3. Truck.java
4. Container.java
5. Basic.java
6. Heavy.java
7. Refrigeratortruck.java
8. Tanker.java
Tanker and Refrigeratortruck extends Heavy
Heavy and Basic extends Container which is an Abstract class
Main.java
The main method will simply read inputs that is composed of sequential commands
related to the operations. You can use this class to make a menu selections and test
your code. Scanners for input and output and the array lists defined are given to you.
We will use the Main class to test your code for various inputs and outputs.
Terminal.java
Terminal class can have the following variables.
● int ID
● double X
● double Y
● ArrayList<Container> containers
● ArrayList<Truck> history : keeps track of every Truck that has
visited
● ArrayList<Truck> current : keeps track of the Trucks currently here
Terminal must implement the ITerminal interface and the methods it requires. The
class can have the following methods.
● A constructor with three parameters, ID, X, and Y.
● A method that calculates the distance between the object itself
and another Terminal, double getDistance(Terminal other)
Additionally, the choice of defining the variables as private, protected, or public may
require additional getter and setter methods. This applies to all other classes as well,
unless specified otherwise.
Truck.java
Truck class should have the following variables, exactly named as below:
● int ID
● double fuel
● Terminal currentTerminal
Truck must implement the ITruck interface and the methods it requires. The class
should have the following methods.
● public Truck(int ID, Terminal p, int totalloadCapacity,
double fuelConsumptionPerKM……)
● ArrayList<Container> getCurrentContainers() : should return the
list of all containers currently in the Truck sorted by ID.
Container.java
Container is an abstract class and should have the following fields atleast:
● int ID
● int weight
It should have the following methods atleast:
● A constructor with parameters ID, weight
● double consumption() : should return fuel consumption required by
the container
● boolean equals(Container other) : check type, ID, and weight of a
container. If they are the same, return true; otherwise, return
false.
Basic.java and Heavy.java
They extend the Container class. They should have a constructor with inputs like a
Container.
● Weight of a Basic ● Weight of a Heavy :
Fuel consumption is as follows: ● Basic: 2.50 per unit of weight ● Heavy 3.00 per unit
of weight
Refrigerator truck.java and Tanker.java
They are special types of Heavy Containers and should extend the Heavy class with
their constructors.
Fuel consumption is as follows: ● Refrigerator truck : 5.00 per unit of weight ● Tanker
: 4.00 per unit of weight
Interface Details
ITerminal.java
It contains the following method:
● void incomingTruck(Truck s) : should add this Truck
to current ArrayList.
● void outgoingTruck(Truck s) : should add this Truck to history
ArrayList.
Note that there should not be any duplicates in the current and history ArrayLists (i.e.
do not add the same truck to history if it has already visited that Terminal before)
ITruck.java
● boolean goTo(Terminal p) : returns true if a Truck successfully
reached to the destination Terminal
● void reFuel(double newFuel) : adds fuel to a Truck
● boolean load(Container cont) : returns true if a container was
successfully loaded to a Truck
● boolean unLoad(Container cont) : returns true if a container was
successfully unloaded from a Truck
Input/Output
Input
The actions are specified in their customized format as described below. In other
words, each distinct line represents an event with a specific action in the Terminal
management system. Please note that the test cases will not cover any erroneous
input regarding the format.
The possible actions are encoded through separate numbers:
1. Creating a container
2. Creating a Truck
3. Creating a Terminal
4. Loading a container to a Truck
5. Unloading a container from a Truck
6. Truck goes to another Terminal
7. Truck is refueled
1. When creating a container, three or four inputs are given depending on the
type of container. The first input represents the id of the Terminal where that
container should be placed initially. Note that there will not be a test case
where a Terminal of that id has not been created yet. The next input is a non-
zero positive integer, denoting the weight of that container.
Depending on the weight you need to decide the type of container: ● Weight <=
3000 : BasicTruck ● Otherwise: HeavyTruck
The special type of heavy Truck is given as “R” or “T” , which stand for Refrigerator
truck and Tanker, respectively. The ID of a Truck is determined by the simulation and
should be unique to each Truck. In other words, no two Trucks can have the same ID,
even if one of them is a basic one and the other a heavy/Refrigerator truck/Tanker
one. Successive numbers should be assigned as IDs according to the order of adding
them to the simulation by starting indexing from 0, such that the first Truck must
have the ID 0 and the second 1 and so on.
2. When creating a Truck positive integers are given: ● The ID of the Terminal
where the Truck initially is ● Maximum weight of all containers in that
Truck (nonzero) .A nonzero positive double is the input denoting the fuel
consumption per km of that Truck.
3. When creating a Terminal, two double inputs are given, which are the x and y
coordinates of the Terminal. The IDs of the Terminals are also determined by
the simulation.
4. When loading a container into a Truck, IDs of Truck and container are given. A
container with that ID will always exist but may or may not be in the Terminal
where the Truck currently is. Truck with the given ID will always exist. If the
container is currently in the Terminal, it may or may not be loaded into the
Truck depending on the restrictions of that Truck.
5. When unloading a container from a Truck, IDs of Truck and container are
given. A container with that ID will always exist but may or may not be on the
Truck. Truck with the given ID will always exist. If a container with the given ID
exists in a Truck, it will be placed into the storage of the Terminal where the
Truck currently is.
6. When Trucks travel from one Terminal to another, IDs of the Truck and
destination Terminal are given. Fuel consumption of the Truck consists of the
value that was given in the creation stage and consumption of containers. We
will provide more information about how fuel consumption is calculated in the
following sections. In short, if a Truck has enough fuel it will go to the
destination Terminal.
7. When fuel is added to a Truck, the ID of the Truck and the amount of fuel is
given. The fuel amount is a nonzero positive double.
Output
You must print the Trucks in the Terminals list in the main class with their attributes.
Please note that the double values should have 2 digits after the fraction point. The
output format should be ordered in ascending order of the Terminal IDs, while in
each Terminal, the Trucks should be also ordered according to their IDs. A Terminal
should be printed as “Terminal ID: (x, y)”, followed by IDs of containers located in the
Terminal: “{Basic, Heavy, Refrigerator truck, Tanker}: [IDLIST]”. You should also list all
Trucks located in that Terminal as “Truck ID: FUEL_LEFT”. Additionally, containers in
each Truck should be listed too. Note that Terminal and Truck contents are indented
with 2 whitespaces. Order of containers types matter and should be as follows: Basic,
Heavy, Refrigerator truck, Tanker.
You are free to use your own creativity to build this project if you need more
requirements.
