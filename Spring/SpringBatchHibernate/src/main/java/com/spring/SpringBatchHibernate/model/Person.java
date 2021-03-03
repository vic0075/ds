package com.spring.SpringBatchHibernate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"firstName", "lastName"})
public class Person {
    @Id
    @GeneratedValue
    private int id;

    @Transient
    @NonNull
    private String lastName;

    @Transient
    @NonNull
    private String firstName;

    @NonNull
    private String name;

    public void concatenateName() {
        this.setName(this.firstName + " " + this.lastName);
    }
}
