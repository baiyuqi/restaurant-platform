package com.dy.restaurant.commons.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * @author: Yuqi.Bai, Date : 2019-04-12 12:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {

  private UUID uuid;
  private List<Error> errors;

}
