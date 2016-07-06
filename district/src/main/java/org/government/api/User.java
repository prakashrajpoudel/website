package org.government.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class User {
  private String username;
  private String firstName;
  private String lastName;
}
