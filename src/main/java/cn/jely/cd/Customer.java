package cn.jely.cd;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Administrator on 2016/1/10.
 */
public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental retal) {
        rentals.add(retal);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints =0;
        String result = "Rental Record for" + getName() + "\n";
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            frequentRenterPoints += getFrequentRenterPoints(each);
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
            }
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent reter points";
        return result;
    }

    private int getFrequentRenterPoints(Rental each) {
        if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1) {
            return 2;
        }else{
            return 1;
        }
    }

    public static void main(String[] args) {
    }
}
