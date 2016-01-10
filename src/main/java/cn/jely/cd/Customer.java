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
            double thisAmount = amountFor(each);
            frequentRenterPoints++;
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
            }
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent reter points";
        return result;
    }

    private double amountFor(Rental each) {
        double thisAmount =0;
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount +=2;
                if (each.getDaysRented() > 2) {
                    thisAmount+=(each.getDaysRented()-2)*1.5;
                }
                break;

            case Movie.NEW_RELEASE:
                    thisAmount+=each.getDaysRented()*3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (each.getDaysRented() > 3) {
                    thisAmount+=(each.getDaysRented()-3)*1.5;
                }
                break;
        }
        return thisAmount;
    }

    public static void main(String[] args) {
    }
}
