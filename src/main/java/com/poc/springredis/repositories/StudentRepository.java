package com.poc.springredis.repositories;

import com.poc.springredis.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Luram Archanjo / 20180820
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

}