package com.polatavci.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private LocalDate dateOfBirth;

    // card_id adında fk sütunu oluşur ve studentCard'ın id alanıyla ilişkilendirilir
    // CascadeType.ALL tüm student'a yapılan tüm işlemleri studentCard'a da uygular
    // FetchType.LAZY olursa studentCard'a ihtiyaç olursa veri tabanından yüklenir
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private StudentCard studentCard;

}
