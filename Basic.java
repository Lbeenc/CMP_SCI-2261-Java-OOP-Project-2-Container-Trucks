public class Basic extends Container {
    public Basic(int ID, int weight) {
        super(ID, weight);
    }
    @Override
    public int getType() {
        return 1;
    }

    @Override
    public double consumption() {
        return this.weight * 2.5;
    }
}
