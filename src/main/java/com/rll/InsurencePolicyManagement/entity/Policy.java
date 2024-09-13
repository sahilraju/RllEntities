package com.rll.InsurencePolicyManagement.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "policy")
@Data 
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String details;

//    @Column(nullable = false)
//    private String status; 

    @ManyToOne
    @JoinColumn(name = "category_id")
    private PolicyCategory category;

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private List<CustomerPolicy> customerPolicies;
    
}
