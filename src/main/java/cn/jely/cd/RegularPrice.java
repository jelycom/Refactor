package cn.jely.cd;

/**
 * Created by Administrator on 2016/1/10.
 */
public class RegularPrice extends PriceType {

    @Override
    int getType() {
        return Movie.REGULAR;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 0;
        result +=2;
        if (daysRented > 2) {
            result+=(daysRented -2)*1.5;
        }
        return result;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
