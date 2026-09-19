public class Tanker extends Heavy {
    public Tanker(int ID, int weight) {
        super(ID, weight);
    }

    @Override
    public int getType() {
        return 4;
    }
    @Override
    public double consumption() {
        return this.weight * 4.0;
    }
}
