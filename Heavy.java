public class Heavy extends Container {
    public Heavy(int ID, int weight) {
        super(ID, weight);
    }
    @Override
    public int getType() {
        return 2;
    }
    @Override
    public double consumption() {
        return this.weight * 3.0;
    }
}
