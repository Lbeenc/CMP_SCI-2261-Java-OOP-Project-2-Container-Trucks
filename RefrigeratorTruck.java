public class RefrigeratorTruck extends Heavy {
    public RefrigeratorTruck(int ID, int weight) {
        super(ID, weight);
    }
    @Override
    public int getType() {
        return 3;
    }
    @Override
    public double consumption() {
        return this.weight * 5.0;
    }
}
