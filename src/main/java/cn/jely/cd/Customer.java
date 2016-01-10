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

    private double amountFor(Rental rental) {
        double result =0;
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result +=2;
                if (rental.getDaysRented() > 2) {
                    result+=(rental.getDaysRented()-2)*1.5;
                }
                break;

            case Movie.NEW_RELEASE:
                    result+=rental.getDaysRented()*3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (rental.getDaysRented() > 3) {
                    result+=(rental.getDaysRented()-3)*1.5;
                }
                break;
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
