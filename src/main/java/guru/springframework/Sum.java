package guru.springframework;

public class Sum implements Expression{

    Expression augmend;
    Expression addend;

    Sum(Expression augmend, Expression addend){
        this.addend = addend;
        this.augmend = augmend;
    }

    @Override
    public Expression plus(Expression addend){
        return new Sum(this,addend);
    }

    @Override
    public Expression times(int multiplier){
        return new Sum(augmend.times(multiplier),addend.times(multiplier));
    }

    @Override
    public Money reduce(Bank bank, String to){
        int amount = augmend.reduce(bank,to).getAmount() + addend.reduce(bank, to).getAmount();
        return new Money(amount, to);
    }

}
