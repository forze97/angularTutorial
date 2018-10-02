package com.forze.sa.demo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class BloodTypeEntity {
    @SequenceGenerator(name="blood_seq",sequenceName="blood_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="blood_seq")
    @Id private Long id;
    private String name;

    public void setName(String name) {
        this.name = name;
    }
}
