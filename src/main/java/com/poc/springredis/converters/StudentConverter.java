package com.poc.springredis.converters;

import com.poc.springredis.domain.Student;
import com.poc.springredis.domain.StudentPayload;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Luram Archanjo / 20180820
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class StudentConverter implements Converter<Student> {

  private StudentPayload studentPayload;

  @Override
  public Student convert() {
    Student student = null;

    log.info("Converting {} to {}", studentPayload, Student.class.getSimpleName());
    if (Objects.nonNull(studentPayload)) {
      student = new Student();
      student.setName(studentPayload.getName());
      student.setGrade(studentPayload.getGrade());
    }

    return student;
  }

}
