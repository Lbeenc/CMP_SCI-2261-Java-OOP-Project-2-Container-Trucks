import java.util.ArrayList;

public class Terminal implements ITerminal{
    private int ID;
    private double X;
    private double Y;
    private ArrayList<Container> containers;
    private ArrayList<Truck> history;
    private ArrayList<Truck> current;

    public Terminal(int ID, double X, double Y) {
        this.ID = ID;
        this.X = X;
        this.Y = Y;
        this.containers = new ArrayList<>();
        this.current = new ArrayList<>();
        this.history = new ArrayList<>();
    }

    public void incomingTrucks(Truck T) {
        this.current.add(T);
        if (!this.history.contains(T)){
            this.history.add(T);
        }
    }

    public void outgoingTruck(Truck T) {
        this.current.remove(T);
        //System.out.println("terminal outgoing has removed a truck");
    }

    public double getDistance(Terminal other) {
        return Math.sqrt(Math.pow(this.X - other.X, 2) + Math.pow(this.Y - other.Y, 2));
    }

    public ArrayList<Container> getContainers() {
        return this.containers;
    }

    public ArrayList<Truck> getCurrent() {
        return this.current;
    }
    public ArrayList<Truck> getHistory() {
        return this.history;
    }

    public double getX() {
        return this.X;
    }

    public double getY() {
        return this.Y;
    }

    public int getID() {
        return this.ID;
    }
}
