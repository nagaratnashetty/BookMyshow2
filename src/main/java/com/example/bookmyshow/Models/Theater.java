package com.example.bookmyshow.Models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theaters")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterId;

    private String name;

    private String address;

    private Integer noOfScreens;

    //Bidirectional mapping in the parent to keep a record of the child
    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<TheaterSeat> theaterSeatList = new ArrayList<>();

}
//@Data generates getters, setters, toString, equals, and hashCode methods for the class.
//@Builder generates a builder class within MyObject, allowing you to construct instances using a
// fluent API style.This approach can be especially beneficial when dealing with complex objects with
// many fields, as it makes object creation more readable and less error-prone.
//@Entity to indicate that it is a JPA entity. The @Table(name = "theaters") annotation specifies that
// instances of the Theater class should be stored in a database table named "theaters." The @Id annotation
// marks the id field as the primary key of the table.