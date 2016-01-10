package cn.jely.cd;

/**
 * Created by Administrator on 2016/1/10.
 */
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String _title;
    private int _priceCode;
    PriceType priceType;

    public Movie(String _title, int _priceCode) {
        this._title = _title;
        setPriceCode(_priceCode);
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String _title) {
        this._title = _title;
    }

    public int getPriceCode() {
        return priceType.getType();
    }

    public void setPriceCode(int _priceCode) {
        switch (_priceCode) {
            case CHILDRENS:
                priceType = new ChildrenPrice();
                break;
            case REGULAR:
                priceType = new RegularPrice();
                break;
            case NEW_RELEASE:
                priceType = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    double getCharge(int daysRented) {
        return priceType.getCharge(daysRented);
    }

}
