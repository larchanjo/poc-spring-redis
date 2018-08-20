package com.poc.springredis.domain;

import java.io.Serializable;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

/**
 * @author Luram Archanjo / 20180820
 */
@RedisHash("Student")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

  private final String id = UUID.randomUUID().toString();
  private String name;
  private Integer grade;

}