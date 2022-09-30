package com.souritra.jpwh.domain.helloworld;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// Every persistent entity class must have at least the @Entity annotation.
// Hibernate maps this class to a table called MESSAGE.
@Entity
public class Message {

    // Every persistent entity class must have an identifier attribute annotated with @Id
    // Hibernate maps this attribute to a column named ID
    @Id
    
    // Someone must generate identifier values; this annotation enables automatic generation of IDs.
    // default statargy is GeneratedStatargy.AUTO
    @GeneratedValue
    private Long id;

    // regular attributes(fields) of a persistent class with private or protected and
    // public getter/setter method pairs. 
    // Hibernate will map this attribute to a column called TEXT by default autometically 
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
