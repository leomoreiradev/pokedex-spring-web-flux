package com.api.pokedex.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Pokemon implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    private String id;
    private String nome;
    private String categoria;
    private String habilidade;
    private Double peso;
}
