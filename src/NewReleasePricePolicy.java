public class NewReleasePricePolicy implements IPricePolicy {
    private double newReleaseCost = 3;
    public double GetPrice(int daysRented) {
        return daysRented * newReleaseCost;
    }
}
