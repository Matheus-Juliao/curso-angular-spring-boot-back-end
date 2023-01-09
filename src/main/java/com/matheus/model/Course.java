package com.matheus.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data; //O lombok Gera os Getters e Setters, Construtor, etc. O Data gera todos que existe no pacote.

@Data  
@Entity //Especifica essa classe com uma entidade fazendo o mapeamento com o banco dados. Podemos usar também @Table(name = "Nome da tabela no banco")
public class Course {

    @Id //Expecifica que esse é um campo de chave primária
    @GeneratedValue(strategy = GenerationType.AUTO) //Auto Increment
    @JsonProperty("_id") //Anotação para transformar a variável com underscore. ex: _id
    //@JsonIgnore Serve para ignorar
    private Long id;

    @Column(name = "name", length = 200, nullable = false) //Consegue especificar o nome da tabela no banco, tamanho do banco e se o campo é not null
    private String name;

    @Column(length = 10, nullable = false)
    private String category;

}
