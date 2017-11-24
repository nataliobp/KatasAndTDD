package main.java.com.natalio.money;

public class Money implements Expression{
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        Money aMoney = (Money) o;

        return aMoney.amount ==  amount && aMoney.currency.equals(currency);
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }


    public Expression times(int multiplier) {

        return new Money(amount*multiplier, currency);
    }

    public String currency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Money{" +
            "amount=" + amount +
            ", currency='" + currency + '\'' +
            '}';
    }

    public Expression plus(Expression money) {

        return new Sum(this, money);
    }

    public Money reduce(Bank bank, String to){
        int rate = bank.rate(currency, to);

        return new Money(amount/rate, to);
    }
}
