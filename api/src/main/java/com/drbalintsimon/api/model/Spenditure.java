package com.drbalintsimon.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Spenditure {
    @Id
    @GeneratedValue
    private Long id;

    private String description;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Visitor visitor;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Subcategory subcategory;
}
