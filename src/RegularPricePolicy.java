public class RegularPricePolicy implements IPricePolicy {
    private double lateCost = 1.5;
    public double GetPrice(int daysRented) {
        int price = 2;
        if (daysRented > 2)
            price += (daysRented - 2) * lateCost;

        return price;
    }
}
