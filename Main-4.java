import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a new Scanner object to read data from the input file with directory "args[0]".
        Scanner in = new Scanner(System.in);

// make seperate array lists for each container type

        // Create ArrayLists in order to reach any container, Truck or Terminal.
        ArrayList<Container> conts = new ArrayList<Container>();
        ArrayList<Truck> Trucks = new ArrayList<Truck>();
        ArrayList<Terminal> Terminals = new ArrayList<Terminal>();
        System.out.println("1. make container 2. create truck 3. create terminal 4. load container 5 unload container 6 move truck 7 refuel truck 8 check status");

        while (in.hasNext()) {
            final int operation_type = in.nextInt();
            switch(operation_type) {
                case 1: { // Create a container.
                    System.out.println("case 1");
                    final int cont_ID = conts.size();
                    System.out.println("Enter teminal ID");
                    final int Terminal_ID = in.nextInt();
                    System.out.println("Enter weight");
                    int W = 0;
                    int tempWeight = 0;
                    while(W == 0){
                        tempWeight = in.nextInt();
                        if(tempWeight >= 0){
                            W = 1;
                        }
                        else{System.out.println("The weight must be positive, input a positive number");}
                    }
                    final int weight = tempWeight;
                    Container cont;
                    System.out.println("Enter R for fridge, T for tanker, or 0 to skip");
                    if(in.hasNextInt()) { // If the next input is an integer, the container is either type Heavy or Basic.
                        if (weight > 3000) {
                            System.out.println("Heavy");

                            cont = new Heavy(cont_ID, weight);}

                        else{
                            System.out.println("Basic");
                            cont = new Basic(cont_ID, weight);
                    }}
                    else { // If the next input is a character, the container is either type Liquid or Refrigerated.
                        final char special_type = in.next().charAt(0);
                        if(special_type == 'R')
                            cont = new RefrigeratorTruck(cont_ID, weight);
                        else if(special_type == 'T')
                            cont = new Tanker(cont_ID, weight);
                        else
                            throw new IllegalArgumentException("Invalid special type");
                    }
                    // Add the generated container to the Terminals "containers" ArrayList and the general "conts" ArrayList.
                    Terminals.get(Terminal_ID).getContainers().add(cont);
                    conts.add(cont);
                    System.out.println("Done making container");


                    System.out.println("1. make container 2. create truck 3. create terminal 4. load container 5 unload container 6 move truck 7 refuel truck 8 check status");


                    break; }
                case 2: { // Create a Truck.
                    final int Truck_ID = Trucks.size();
                    System.out.println("Enter the terminal ID ");
                    final int Terminal_ID = in.nextInt();
                    System.out.println("Enter the load capacity");
                    int L = 0;
                    int tempLoad = 0;
                    while(L == 0){
                        tempLoad = in.nextInt();
                        if(tempLoad >= 0){
                            L = 1;
                        }
                        else{System.out.println("The load capacity must be positive, input a positive number");}
                    }
                    final int totalloadCapacity = tempLoad;

                    System.out.println("Enter the Fuel consumption of the truck");
                    int C = 0;
                    int tempCons = 0;
                    while(C == 0){
                        tempCons = in.nextInt();
                        if(tempCons >= 0){
                            C = 1;
                        }
                        else{System.out.println("The fuel consumption must be positive, input a positive number");}
                    }
                    final double fuelConsumptionPerKM = tempCons;

                    Truck truck = new Truck(Truck_ID, Terminals.get(Terminal_ID), totalloadCapacity, fuelConsumptionPerKM);
                    // Add the generated Truck to the Terminal's "current" ArrayList and the general "Trucks" ArrayList.
                    Terminals.get(Terminal_ID).getCurrent().add(truck);
                    Trucks.add(truck);

                    System.out.println("1. make container 2. create truck 3. create terminal 4. load container 5 unload container 6 move truck 7 refuel truck 8 check status");
                    break; }
                case 3: { // Create a Terminal.
                    System.out.println("case 3");
                    final int Terminal_ID = Terminals.size();
                    System.out.println("Enter X");
                    final double X = in.nextDouble();
                    System.out.println("Y");
                    final double Y = in.nextDouble();
                    Terminal terminal = new Terminal(Terminal_ID, X, Y);
                    // Add the generated Terminal to the "Terminal" ArrayList.
                    Terminals.add(terminal);
                    System.out.println("Terminal_ID = " + Terminal_ID);

                    System.out.println("1. make container 2. create truck 3. create terminal 4. load container 5 unload container 6 move truck 7 refuel truck 8 check status");
                    break; }
                case 4: { // Load a container to a Truck.
                    System.out.println("case 4");
                    System.out.println("Load the Truck");
                    System.out.println("Input Truck ID");
                    final int Truck_ID = in.nextInt();
                    System.out.println("Input Container ID");
                    final int cont_ID = in.nextInt();
                    int termID = Trucks.get(Truck_ID).getTerm();
                    if(Terminals.get(termID).getContainers().contains(conts.get(cont_ID))){
                        System.out.println("Loading Container");
                        Trucks.get(Truck_ID).load(conts.get(cont_ID));
                    }
                    else System.out.println("Not at your terminal");
                    System.out.println("1. make container 2. create truck 3. create terminal 4. load container 5 unload container 6 move truck 7 refuel truck 8 check status");
                    break; }
                case 5: { // Unload a container from a Truck.
                    System.out.println("Unload Container ");
                    System.out.println("Input Truck ID");
                    final int Truck_ID = in.nextInt();
                    System.out.println("Input Container ID");
                    final int cont_ID = in.nextInt();
                    if(Trucks.get(Truck_ID).getContainers().contains(conts.get(cont_ID))){
                        System.out.println("container was in truck, unloading");
                        Trucks.get(Truck_ID).unLoad(conts.get(cont_ID));
                    }
                    //Trucks.get(Truck_ID).unLoad(conts.get(cont_ID));
                    else System.out.println("container not in truck");

                    System.out.println("1. make container 2. create truck 3. create terminal 4. load container 5 unload container 6 move truck 7 refuel truck 8 check status");
                    break; }
                case 6: { // send Truck to another port.
                    System.out.println("Send Truck to another Terminal");
                    System.out.println("Enter Truck ID");
                    final int Truck_ID = in.nextInt();
                    int oldTerm = Trucks.get(Truck_ID).currentTerminal.getID();
                    System.out.println("Enter Terminal ID");
                    final int Terminal_ID = in.nextInt();
                   if( Trucks.get(Truck_ID).goTo(Terminals.get(Terminal_ID))){
                       Terminals.get(Terminal_ID).incomingTrucks(Trucks.get(Truck_ID));
                       Terminals.get(oldTerm).outgoingTruck(Trucks.get(Truck_ID));

                       System.out.println("Truck has moved");}
                   else System.out.println("Truck has not moved");



                    System.out.println("1. make container 2. create truck 3. create terminal 4. load container 5 unload container 6 move truck 7 refuel truck 8 check status");
                    break; }
                case 7: { // Refuel Truck.
                    System.out.println("Refuel The Truck");
                    System.out.println("Enter Truck ID");
                    final int Truck_ID = in.nextInt();
                    System.out.println("Amount of fuel in the truck is " + Trucks.get(Truck_ID).getFuel());
                    System.out.printf("%.2f",Trucks.get(Truck_ID).getFuel());
                    System.out.println("How much Fuel DO you want to Add");

                    int F = 0;
                    double tempFuel =0;
                    while(F == 0){
                        tempFuel = in.nextDouble();
                        if(tempFuel >= 0){
                            F = 1;
                        }
                        else{System.out.println("You cannot remove fuel, input a positive number");}
                    }
                    final double fuel = tempFuel;
                    Trucks.get(Truck_ID).reFuel(fuel);

                    System.out.println("1. make container 2. create truck 3. create terminal 4. load container 5 unload container 6 move truck 7 refuel truck 8 check status");
                    break; }
                case 8: {
                    //goes thru terminals
                    for (Terminal terminal : Terminals) {
                        System.out.println("\n Terminal ID: " + terminal.getID() + " (" + terminal.getX() + ", " + terminal.getY() + ")");
                        System.out.print("{Basic, Heavy, Refrigerator truck, Tanker}:  [");
                        for (int i = 1; i < 5; i++) {

                        for (Container container : terminal.getContainers()) {
                            if(container.getType() == i){
                                if(i == 1){
                                    System.out.println("\nBasic: ");
                                }
                                else if(i == 2){
                                    System.out.println("\nHeavy: ");
                                }
                                else if(i == 3){
                                    System.out.println("\nRefrigerator: ");
                                }
                                else if(i == 4){
                                    System.out.println("\nTanker: ");
                                }
                            System.out.print(container.getID() + ", ");
                        }}}

                        System.out.println("]\n");
                       // System.out.print("\n Truck ID: \n");

                        for (Truck truck : terminal.getCurrent()) {


                            System.out.print("\n Truck ID: \n");
                            System.out.print(truck.getID() + " FUEL_LEFT :  ("   );
                            System.out.printf("%.2f",truck.getFuel());
                            System.out.print("), is at " + truck.getTerm());
                            for (Container container : truck.getContainers()) {
                            System.out.print(". Containers : " + container.getID() );}
                        }

                    }
                    System.out.println("\n 1. make container 2. create truck 3. create terminal 4. load container 5 unload container 6 move truck 7 refuel truck 8 check status");
                        }


                    }
                }


        in.close();
    }

}
// Closes the Scanner object.

        /* // Print output.
        for (Terminal terminal : Terminals) {
            System.out.println("Terminal ID: (" + terminal.getX() + ", " + terminal.getY() + ")");
            System.out.print("{Basic, Heavy, Refrigerator truck, Tanker}: [");
            for (Container container : terminal.getContainers()) {
                System.out.print(container.getID() + ", ");
            }
            System.out.println("]");
            System.out.print("Truck ID: ");
            for (Truck truck : terminal.getCurrent()) {
                System.out.print(truck.getID() + " (" + truck.getFuel() + "), ");
            }
            System.out.println();
        }
        */
