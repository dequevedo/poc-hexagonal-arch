package com.pocspringboot.model.domain;

import com.pocspringboot.model.request.CreateProductRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class ProductDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @GeneratedValue(generator = "uuid2")
    @Column(name = "internal_tag", columnDefinition = "VARCHAR(255)")
    private UUID internalTag;

    public static ProductDomain valueOf(CreateProductRequest createProductRequest) {
        return ProductDomain.builder()
                .name(createProductRequest.getName())
                .build();
    }
}