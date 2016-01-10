package cn.jely.cd;

/**
 * Created by Administrator on 2016/1/10.
 */
public abstract class PriceType {
    abstract int getType();

    public abstract double getCharge(int daysRented);

    abstract int getFrequentRenterPoints(int daysRented) ;
}
