package happysubin.javapractice.lab.multi_tx.main.many_to_many;

import jakarta.persistence.*;

@Table(name = "opt")
@Entity
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String optionName;

    public Option(String optionName) {
        this.optionName = optionName;
    }

    protected Option() {}

    public Long getId() {
        return id;
    }

    public String getOptionName() {
        return optionName;
    }

}
