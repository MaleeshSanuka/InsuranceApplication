package com.example.insuranceapplication.insurance;

import javax.persistence.*;

@Entity
@Table(name = "insurances")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true, name = "insurance_name")
    private String insuranceName;

    @Column(nullable = false, name = "insurance_type")
    private String insuranceType;

    @Column(nullable = false, name = "insurance_cost")
    private Double insuranceCost;

//    @OneToMany(targetEntity = Customer.class, cascade = CascadeType.ALL)
//    private List<Customer> customers;


    private boolean enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public Double getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(Double insuranceCost) {
        this.insuranceCost = insuranceCost;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "id=" + id +
                ", insuranceName='" + insuranceName + '\'' +
                ", insuranceType='" + insuranceType + '\'' +
                ", insuranceCost=" + insuranceCost +
                ", enabled=" + enabled +
                '}';
    }
}
