package net.bred.price.model;

import javax.persistence.*;

@Entity
@Table(name = "PROD")
public class Prod {

    private Integer id;
    private Cat cat;
    private String name;
    private Float price;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CAT_ID")
    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Column(name = "PRICE")
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Prod{" +
                "id=" + id +
                ", catId=" + cat +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
