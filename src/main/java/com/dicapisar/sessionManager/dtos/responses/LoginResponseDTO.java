package com.dicapisar.sessionManager.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginResponseDTO {
    private Long id;
    private String name;
    private Long rolId;
    private String rolName;
    private String idSession;
}
