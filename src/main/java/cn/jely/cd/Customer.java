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
        String result = "Rental Record for" + getName() + "\n";
        Enumeration elements = rentals.elements();
        while (elements.hasMoreElements()) {
            Rental each = (Rental) elements.nextElement();
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getMovie().getCharge(each.getDaysRented())) + "\n";
        }
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent reter points";
        return result;
    }

    private int getFrequentRenterPoints() {
        Enumeration rentals = this.rentals.elements();
        int frequentRenterPoints =0;
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints(each.getDaysRented());
        }
        return frequentRenterPoints;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration elements = rentals.elements();
        while (elements.hasMoreElements()) {
            Rental each = (Rental) elements.nextElement();
            result += each.getCharge(each.getDaysRented());
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
