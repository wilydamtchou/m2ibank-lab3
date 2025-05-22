package com.m2i.dto;

public record ClientCreateDTO(
    String nom,
    String prenom,
    String email,
    String telephone
) {}
