package com.matheus.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id) {
        return courseRepository.findById(id)
            .map(rec -> ResponseEntity.ok().body(rec))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course create(@RequestBody Course course) {
        //System.out.println(course.getName());
        return courseRepository.save(course);
        // return ResponseEntity.status(HttpStatus.CREATED)
        //     .body(courseRepository.save(course));
    }
}
