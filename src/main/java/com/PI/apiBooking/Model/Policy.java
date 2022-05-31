package com.PI.apiBooking.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Policy {

    @Id
    @SequenceGenerator(name = "policySequence",sequenceName = "policySequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "policySequence")
    private Long id;

    @OneToMany(mappedBy = "policy", fetch = FetchType.LAZY)
    private Set<Rule> rules;

    @OneToMany(mappedBy = "policy", fetch = FetchType.LAZY)
    private Set<HealthAndSecurity> healthAndSecurity;

    @Lob
    private String cancellationPolicy;
}
