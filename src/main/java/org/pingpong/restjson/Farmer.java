package org.pingpong.restjson;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "farmer")
//@JsonIgnoreProperties({"location", "fruits"})
public class Farmer extends PanacheEntity {

    @Column(unique = true)
    //@JsonProperty(value = "supplier")
    public String name;

    @Column
    public String location;

    @JsonIgnore
    @OneToMany(mappedBy = "farmer")
    public Set<Fruit> fruits;
    
    public Farmer() {}

    public Farmer(String name, String location) {
        this.name = name;
        this.location = location;
    }
}
