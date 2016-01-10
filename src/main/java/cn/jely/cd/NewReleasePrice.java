package cn.jely.cd;

/**
 * Created by Administrator on 2016/1/10.
 */
public class NewReleasePrice extends PriceType {
    @Override
    int getType() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
       return daysRented*3;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        if (daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
