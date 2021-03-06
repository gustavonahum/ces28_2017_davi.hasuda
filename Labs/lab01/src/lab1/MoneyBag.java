package lab1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoneyBag implements MoneyInterface {
    private List<Money> _monies;

    public MoneyBag() {
        this._monies = new ArrayList<>();
    }

    public boolean isEmpty() {
        return (this._monies==null || this._monies.isEmpty());
    }

    public MoneyInterface add(Money money) {
        for (Money m : this._monies) {
            if (money.getCurrency().equals(m.getCurrency())) {
            		m.setAmount(m.getAmount() + money.getAmount());
                return this;
            }
        }
        this._monies.add(money);
        return this;
    }

    public MoneyBag add(MoneyBag moneyBag) {
        for (Money m : moneyBag.getMonies()) {
            this.add(m);
        }
        return this;
    }

    public MoneyBag remove(Money m) {
        this._monies.remove(m);
        return this;
    }

    public MoneyBag remove(MoneyBag moneyBag) {
        for (Money m : moneyBag.getMonies()) {
            this.remove(m);
        }
        return this;
    }

    public Money findMoney(Currency currency) {
        for (Money m : this._monies) {
            if (m.getCurrency().equals(currency)) {
                return m;
            }
        }
        return null;
    }

    public boolean contains(Money m) {
        return this._monies.contains(m);
    }

    public int totalValueInBRL ()
    {
        int valueInUSD = 0, valueInBRL = 0, valueInCHF = 0;
        for (Money m : this._monies) {
            if (m.getCurrency().getName().equals("USD"))
                valueInUSD = m.getAmount();
            if (m.getCurrency().getName().equals("BRL"))
                valueInBRL = m.getAmount();
            if (m.getCurrency().getName().equals("CHF"))
                valueInCHF = m.getAmount();
        }
        return (valueInUSD * 3) + (valueInBRL) + (valueInCHF * 2);
    }

    @Override
    public boolean equals(Object ob) {
        if (ob != null) {
            if (ob instanceof MoneyBag){
                for (Money m : ((MoneyBag)ob).getMonies()) {
                    if (!this.contains(m)) {
                        return false;
                    }
                }

                return true;
            }
        }

        return false;
    }

    // Getters and setters
    public List<Money> getMonies() {
        return Collections.unmodifiableList(this._monies);
    }


}
