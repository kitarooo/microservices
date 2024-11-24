package com.backend.restarauntservice.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "NAME",unique = true, nullable = false)
    String name;

    @Column(name = "ADDRESS")
    String address;

    @Column(name = "PHONE_NUMBER", unique = true, nullable = false)
    String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Menu> menu;

}
