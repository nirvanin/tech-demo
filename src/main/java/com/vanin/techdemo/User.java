package com.vanin.techdemo;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "user_generator", sequenceName = "user_sequence")
    @GeneratedValue(generator = "user_generator")
    private Long id;

    @Column(nullable = false)
    @NaturalId
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String zip;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private Set<Disk> disksThatHeOwns;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "currentHolder")
    private Set<Disk> disksThatHeHolds;

    protected User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getZip() {
        return this.zip;
    }

    public Set<Disk> getDisksThatHeOwns() {
        return disksThatHeOwns;
    }

    public void setDisksThatHeOwns(Set<Disk> disksThatHeOwns) {
        this.disksThatHeOwns = disksThatHeOwns;
    }

    public Set<Disk> getDisksThatHeHolds() {
        return disksThatHeHolds;
    }

    public void setDisksThatHeHolds(Set<Disk> disksThatHeHolds) {
        this.disksThatHeHolds = disksThatHeHolds;
    }
}
