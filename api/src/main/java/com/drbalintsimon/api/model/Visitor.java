package com.drbalintsimon.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Visitor {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @EqualsAndHashCode.Exclude
    @JsonBackReference
    @ManyToMany
    private List<Subcategory> subcategories;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    @OneToMany(mappedBy = "visitor", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Spenditure> spenditures;
}
