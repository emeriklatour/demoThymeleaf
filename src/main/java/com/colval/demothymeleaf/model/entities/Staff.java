package com.colval.demothymeleaf.model.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "staff")
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s")
        , @NamedQuery(name = "Staff.findByStaffId", query = "SELECT s FROM Staff s WHERE s.staffId = :staffId")
        , @NamedQuery(name = "Staff.findByFirstName", query = "SELECT s FROM Staff s WHERE s.firstName = :firstName")
        , @NamedQuery(name = "Staff.findByLastName", query = "SELECT s FROM Staff s WHERE s.lastName = :lastName")
        , @NamedQuery(name = "Staff.findByEmail", query = "SELECT s FROM Staff s WHERE s.email = :email")
        , @NamedQuery(name = "Staff.findByActive", query = "SELECT s FROM Staff s WHERE s.active = :active")
        , @NamedQuery(name = "Staff.findByUsername", query = "SELECT s FROM Staff s WHERE s.username = :username")
        , @NamedQuery(name = "Staff.findByPassword", query = "SELECT s FROM Staff s WHERE s.password = :password")
        , @NamedQuery(name = "Staff.findByLastUpdate", query = "SELECT s FROM Staff s WHERE s.lastUpdate = :lastUpdate")
        , @NamedQuery(name = "Staff.findAllByStore", query = "SELECT s FROM Staff s WHERE s.store.storeId = :storeId")})

public class Staff implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "staff_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long staffId;

    @Column(name = "first_name")
    @Size(min = 2, max = 50)
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 2, max = 50)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    @Column(name = "picture")
    private byte[] picture;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    private Store store;

    @Column(name = "active")
    private Byte active;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "last_update")
    private java.sql.Timestamp lastUpdate;

    public long getStaffId() {
        return this.staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddressId() {
        return this.address;
    }

    public void setAddressId(Address address) {
        this.address = address;
    }

    public byte[] getPicture() {
        return this.picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getStoreId() {
        return this.store.getStoreId();
    }

    public void setStoreId(Store store) {
        this.store = store;
    }

    public Byte getActive() {
        return this.active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public java.sql.Timestamp getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(java.sql.Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
