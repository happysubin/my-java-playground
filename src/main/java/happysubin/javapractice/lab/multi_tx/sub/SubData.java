package happysubin.javapractice.lab.multi_tx.sub;

import jakarta.persistence.*;

@Entity
@Table(name = "sub_data")
public class SubData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String data;

    protected SubData() {}

    public SubData(String data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }
}
