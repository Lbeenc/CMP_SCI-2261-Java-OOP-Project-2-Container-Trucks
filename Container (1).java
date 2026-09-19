public abstract class Container {
    protected int ID;
    protected int weight;

    public Container(int ID, int weight) {
        this.ID = ID;
        this.weight = weight;
    }

    public abstract int getType();

    public abstract double consumption();

    public boolean equals(Container other) {
        return this.ID == other.ID && this.weight == other.weight && this.getClass() == other.getClass();
    }

    public int getID() {
        return this.ID;
    }
    public int getWeight() {
        return this.weight;
    }
}
