package test.java.com.natalio;

import main.java.com.natalio.money.Bank;
import main.java.com.natalio.money.Expression;
import main.java.com.natalio.money.Money;
import main.java.com.natalio.money.Sum;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class MoneyTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testFrancMultiplication() {
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    public void testEquality() throws Exception {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(6).equals(Money.dollar(5)));
        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(6).equals(Money.franc(5)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testCurrency() throws Exception {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void differentClassEquality() throws Exception {
        assertTrue(Money.franc(10).equals(new Money(10, "CHF")));
    }

    @Test
    public void simpleAddition() throws Exception {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    public void testPlusReturnSum() throws Exception {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(sum.augend, five);
        assertEquals(sum.addend, five);
    }

    @Test
    public void testReduceSum() throws Exception {
        Expression sum = Money.dollar(3).plus(Money.dollar(4));
        Money reduce = new Bank().reduce(sum, "USD");
        assertEquals(Money.dollar(7), reduce);
    }

    @Test
    public void reduceMoney() throws Exception {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void reduceMoneyIfDifferentCurrency() throws Exception {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void mixedAddition() throws Exception {
        Expression fiveDollars = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveDollars.plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10), result);
    }

    @Test
    public void sumPlusMoney() throws Exception {
        Expression fiveDollars = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveDollars, tenFrancs).plus(fiveDollars);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(15), result);
    }

    @Test
    public void sumTimesMoney() throws Exception {
        Expression fiveDollars = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveDollars, tenFrancs).times(2);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(20), result);
    }
}
