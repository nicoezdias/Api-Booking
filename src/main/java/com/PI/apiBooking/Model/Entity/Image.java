package com.PI.apiBooking.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Image {
    @Id
    @SequenceGenerator(name = "imageSequence",sequenceName = "imageSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imageSequence")
    private Long id;
    @Column(length = 50)
    private String title;
    @Lob
    private String url;
    private String text_alt;
    private Boolean profile;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Product product;

    //Default
    public Image() {
    }
}
