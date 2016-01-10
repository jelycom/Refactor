package cn.jely.cd;

/**
 * Created by Administrator on 2016/1/10.
 */
public class Rental {
    Movie _movie;
    private int _daysRented;

    public Rental(Movie _movie, int _daysRented) {
        this._movie = _movie;
        this._daysRented = _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public void setMovie(Movie _movie) {
        this._movie = _movie;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public void setDaysRented(int _daysRented) {
        this._daysRented = _daysRented;
    }

    int getFrequentRenterPoints() {
        if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1) {
            return 2;
        }else{
            return 1;
        }
    }
}
