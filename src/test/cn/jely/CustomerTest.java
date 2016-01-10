package cn.jely;

import cn.jely.cd.Customer;
import cn.jely.cd.Movie;
import cn.jely.cd.Rental;
import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/1/10.
 */
public class CustomerTest {

    @org.junit.Test
    public void testStatement() throws Exception {
        String result = "Rental Record forname\n" +
                "\tspider man\t15.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 2 frequent reter points";
        Customer customer = new Customer("name");
        customer.addRental(new Rental(new Movie("spider man", Movie.NEW_RELEASE),5));
        System.out.println(customer.statement());
        Assert.assertEquals(result,customer.statement());
    }
}