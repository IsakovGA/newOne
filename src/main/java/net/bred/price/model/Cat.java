package net.bred.price.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CAT")
public class Cat {

    private Integer id;
    private String name;
    private Set<Prod> prodSet;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cat")
    public Set<Prod> getProdSet() {
        return prodSet;
    }

    public void setProdSet(Set<Prod> prodSet) {
        this.prodSet = prodSet;
    }
}
