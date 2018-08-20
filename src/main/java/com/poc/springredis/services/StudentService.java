package com.poc.springredis.services;

import com.poc.springredis.domain.Student;
import com.poc.springredis.repositories.StudentRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Luram Archanjo / 20180820
 */
@Service
@Slf4j
@AllArgsConstructor
public class StudentService {

  private final StudentRepository studentRepository;

  @Transactional
  public Student save(Student student) {
    log.info("Saving {}", student);
    return studentRepository.save(student);
  }

  @Transactional
  public Student update(Student student) {
    log.info("Updating {}", student);
    return studentRepository.save(student);
  }

  @Transactional
  public Student delete(String id) {
    log.info("Deleting {}", id);
    Student student = getById(id).get();
    studentRepository.delete(student);
    return student;
  }

  @Transactional(readOnly = true)
  public Optional<Student> getById(String id) {
    log.info("Getting {} {}", Student.class.getSimpleName(), id);
    return studentRepository.findById(id);
  }

  @Transactional(readOnly = true)
  public Iterable<Student> getAll() {
    log.info("Getting all {}", Student.class.getSimpleName());
    return studentRepository.findAll();
  }

}
