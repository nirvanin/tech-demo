package com.vanin.techdemo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Disk implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "disk_generator", sequenceName = "disk_sequence")
    @GeneratedValue(generator = "disk_generator")
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private User owner;

    @ManyToOne
    private User currentHolder;

    protected Disk() {
    }

    public Disk(String name, User owner, User currentHolder) {
        this.name = name;
        this.owner = owner;
        this.currentHolder = currentHolder;
    }

    public String getName() {
        return this.name;
    }

    public User getOwner() {
        return this.owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getCurrentHolder() {
        return this.currentHolder;
    }

    public void setCurrentHolder(User currentHolder) {
        this.currentHolder = currentHolder;
    }

    @Override
    public String toString() {
        return getName() + ", by " + getOwner();
    }
}
