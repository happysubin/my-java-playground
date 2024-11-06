package happysubin.javapractice.lab.multi_tx.main.one_to_one;


import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class One {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
    @NotFound(action = NotFoundAction.IGNORE) //이거 달면 쿼리가 더 나감
    private ChildOne childOne;

    protected One() {}


    public One(String name) {
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

    public ChildOne getChildOne() {
        return childOne;
    }

    public void setChildOne(ChildOne childOne) {
        this.childOne = childOne;
    }
}
