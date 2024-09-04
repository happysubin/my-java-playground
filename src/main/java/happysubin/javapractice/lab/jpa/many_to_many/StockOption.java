package happysubin.javapractice.lab.jpa.many_to_many;

import jakarta.persistence.*;


@Entity
public class StockOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long stockId;
    private Long optionId;

    public StockOption(Long stockId, Long optionId) {
        this.stockId = stockId;
        this.optionId = optionId;
    }

    protected StockOption() {}

    public Long getId() {
        return id;
    }

    public Long getStockId() {
        return stockId;
    }

    public Long getOptionId() {
        return optionId;
    }
}

