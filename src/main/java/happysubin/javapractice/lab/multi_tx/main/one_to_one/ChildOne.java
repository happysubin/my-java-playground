package happysubin.javapractice.lab.multi_tx.main.one_to_one;

import jakarta.persistence.*;

@Entity
public class ChildOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "childOne")
    private One one;

    public ChildOne() {

    }

    public ChildOne(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public One getOne() {
        return one;
    }

    public void setOne(One one) {
        this.one = one;
    }
}
