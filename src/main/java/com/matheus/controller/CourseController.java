package com.matheus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.model.Course;
import com.matheus.repository.CourseRepository;

import lombok.AllArgsConstructor;

@RestController //@RestController fala que essa classe tem um end point, tem os métodos post, get, delete put....
@RequestMapping("/api/courses") //Expõe o end point
@AllArgsConstructor //Cria o construtor com lombok

public class CourseController {
    
    //@Autowired dá pra fazer a injeção de depêndencia mas por boa prática é interessante fazer pelo construtor
    
    private final CourseRepository courseRepository;

    /*  public CourseController(CourseRepository courseRepository) { //Injeção de dependência gerada com botão direito, actions, gerar construtor
            //this.courseRepository = courseRepository; 
    } */

    @GetMapping //Seria mesma coisa que fazer @RequestMapping(method = ResquestMethod.GET)
    public List<Course> list() { //Criando um método para retonar uma lista utilizando o java útil
        return courseRepository.findAll(); //Select * from da table
    }
}