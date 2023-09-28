package happysubin.javapractice.lab.jpa.many_to_many;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StockTest {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    StockOptionRepository stockOptionRepository;

    @Autowired
    OptionRepository optionRepository;

    @Test
    void test(){
        Stock stock = stockRepository.save(new Stock(9));
        Option opt1 = optionRepository.save(new Option("opt1"));
        Option opt2 = optionRepository.save(new Option("opt2"));

        StockOption stockOption1 = new StockOption(stock.getId(), opt1.getId());
        StockOption stockOption2 = new StockOption(stock.getId(), opt2.getId());
        stockOptionRepository.saveAll(List.of(stockOption1, stockOption2));

        List<StockOption> all = stockOptionRepository.findAll();

        if(all.get(0).getStockId() != all.get(1).getStockId()){
            return;
        }

        Stock result = stockRepository.findById(all.get(0).getStockId()).get();

        Assertions.assertThat(result.getQuantity()).isEqualTo(9);

    }
}