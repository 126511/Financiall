package vnct.projects.financiall.entities;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private String name;

    private String description;

    private BigDecimal amount;

    private String receipt;

    public Transaction(String name, float amount) {
        this.name = name;
        this.amount = BigDecimal.valueOf(amount);
    }
}
