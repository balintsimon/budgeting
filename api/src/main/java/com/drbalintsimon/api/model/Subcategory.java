package com.drbalintsimon.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "subcategory")
public class Subcategory {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Category category;

    @ManyToMany
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private List<Visitor> visitors;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    @OneToMany(mappedBy = "subcategory", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Spenditure> spenditures;

}
