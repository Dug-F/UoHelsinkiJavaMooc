
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros = euros + cents / 100;
            cents = cents % 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return this.euros;
    }

    public int cents() {
        return this.cents;
    }

    public String toString() {
        String zero = "";
        if (this.cents < 10) {
            zero = "0";
        }

        return this.euros + "." + zero + this.cents + "e";
    }
    
    private int toCents() {
        return this.euros * 100 + this.cents;
    }
    
    private Money toMoney(int inputCents) {
        int euros = (int) Math.floor(inputCents / 100);
        int cents = inputCents % 100;
        return new Money(euros, cents);
    }
    
    public Money plus(Money addition) {
        return toMoney(this.toCents() + addition.toCents());

    }
    
    public boolean lessThan(Money compared) {
        return this.toCents() < compared.toCents();
    }
    
    public Money minus(Money decreaser) {
        int total = this.toCents() - decreaser.toCents();
        if (total < 0) {
            return new Money(0, 0);
        }
        return toMoney(total);
    }
}
