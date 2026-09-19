import java.util.ArrayList;
 class Truck implements ITruck {
    private int ID;
    private double fuel;
    public Terminal currentTerminal;
    private ArrayList<Container> containers;

    public Truck(int ID, Terminal p, int totalloadCapacity, double fuelConsumptionPerKM) {
        this.ID = ID;
        this.fuel = totalloadCapacity * fuelConsumptionPerKM;
        this.currentTerminal = p;
        this.containers = new ArrayList<>();
    }

    public boolean goTo(Terminal p) {
        if (this.fuel >= this.currentTerminal.getDistance(p)) {
            //System.out.println("Before: " + this.fuel);
            this.fuel -= this.currentTerminal.getDistance(p);
            //System.out.println("after" + this.fuel + "Dist is: " + this.currentTerminal.getDistance(p));
            this.currentTerminal = p;


            return true;
        } else {
            return false;
        }
    }

    public void reFuel(double newFuel) {
        this.fuel += newFuel;
    }

    public boolean load(Container cont) {
        if (this.fuel >= cont.consumption()) {
            currentTerminal.getContainers().remove(cont);
            this.containers.add(cont);
            this.fuel -= cont.consumption();
            return true;
        } else {
            return false;
        }
    }

    public boolean unLoad(Container cont) {
        this.containers.remove(cont);
        currentTerminal.getContainers().add(cont);
        return true;
    }

    public ArrayList<Container> getContainers() {
        return this.containers;
    }

    public int getID() {
        return this.ID;
    }

    public double getFuel() {
        return this.fuel;
    }

     public int getTerm() {
         return this.currentTerminal.getID();}

}
