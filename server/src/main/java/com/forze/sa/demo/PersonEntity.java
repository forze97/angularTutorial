package com.forze.sa.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class PersonEntity {

    @SequenceGenerator(name="person_seq",sequenceName="person_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="person_seq")
    @Id private Long id;
    private String name;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "blood" ,nullable = false)
    @JsonIgnore
    private BloodTypeEntity bloodType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gender",nullable = false)
    @JsonIgnore
    private GenderEntity gender;

    public void setBloodType(BloodTypeEntity bloodType) {
        this.bloodType = bloodType;
    }

    public void setGender(GenderEntity gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
