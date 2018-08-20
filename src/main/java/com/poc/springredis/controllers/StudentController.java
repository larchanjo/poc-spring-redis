package com.poc.springredis.controllers;

import com.poc.springredis.converters.StudentConverter;
import com.poc.springredis.domain.Student;
import com.poc.springredis.domain.StudentPayload;
import com.poc.springredis.services.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Luram Archanjo / 20180820
 */
@RestController
@RequestMapping("/students")
@Slf4j
@AllArgsConstructor
public class StudentController {

  private final StudentService studentService;

  @GetMapping
  public Iterable<Student> get() {
    log.info("Received get request");
    return studentService.getAll();
  }

  @GetMapping("/{id}")
  public Student getById(@PathVariable String id) {
    log.info("Received get request");
    return studentService.getById(id).get();
  }

  @PostMapping
  public Student post(@RequestBody StudentPayload studentPayload) {
    log.info("Received post request {}", studentPayload);

    Student student = StudentConverter.builder()
        .studentPayload(studentPayload)
        .build()
        .convert();

    return studentService.save(student);
  }

  @PutMapping("/{id}")
  public Student put(@PathVariable String id, @RequestBody StudentPayload studentPayload) {
    log.info("Received put request {}", studentPayload);

    Student student = StudentConverter.builder()
        .studentPayload(studentPayload)
        .build()
        .convert();

    return studentService.update(student);
  }

  @DeleteMapping("/{id}")
  public Student delete(@PathVariable String id) {
    log.info("Received delete request {}", id);
    return studentService.delete(id);
  }

}