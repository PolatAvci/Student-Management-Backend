package com.polatavci.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_card")
public class StudentCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String cardNumber;

    @Column
    private Boolean active;

    @OneToOne(mappedBy = "studentCard") // mappedby ile fk oluşturması engellenir
    private Student student;

}
