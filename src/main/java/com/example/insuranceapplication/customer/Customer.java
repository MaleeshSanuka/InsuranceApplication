package com.example.insuranceapplication.customer;

import com.example.insuranceapplication.insurance.Insurance;
import com.example.insuranceapplication.insurance.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(length = 45, nullable = false)
    private String firstName;

    @Column(length = 15, nullable = false)
    private String lastName;

    @Column(length = 10, nullable = false)
    private String telephone;

    private boolean enabled;

    @Column(length = 45, nullable = false)
    private String insuranceName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", enabled=" + enabled +
                ", insuranceName='" + insuranceName + '\'' +
                '}';
    }
}
