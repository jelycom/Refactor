package cn.jely.cd;

/**
 * Created by Administrator on 2016/1/10.
 */
public class ChildrenPrice extends PriceType{

    @Override
    int getType() {
        return Movie.CHILDRENS;
    }

    @Override
    public double getCharge(int daysRented) {
        double result= 1.5;
        if (daysRented > 3) {
            result+=(daysRented-3)*1.5;
        }
        return result;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
