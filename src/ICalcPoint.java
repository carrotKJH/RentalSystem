public abstract class ICalcPoint {
    protected abstract int calcAdditionalPoint();
    public int calcPoint(int daysRented, int daysRentedLimit, int tLateReturnPointPenalty) {
        int eachPoint = 0;
        eachPoint++;

        eachPoint += calcAdditionalPoint();
        if ( daysRented > daysRentedLimit)
            eachPoint -= Math.min(eachPoint, tLateReturnPointPenalty) ;

        return eachPoint;
    }
}
