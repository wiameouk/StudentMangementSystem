package com.example.demo.Payload.Request;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;

public record StudentRequest(
    
    @NotBlank
    @NonNull
    String matricule,

    @NotBlank
    @NonNull
    String nom,

    @NotBlank
    @NonNull
    String prenom,

    @NonNull
    int age
) {
} 
