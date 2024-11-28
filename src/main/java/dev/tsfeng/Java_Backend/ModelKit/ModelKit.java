package dev.tsfeng.Java_Backend.ModelKit;

import jakarta.validation.constraints.NotEmpty;

public record ModelKit(
   Integer id,
   @NotEmpty
   String name,
   Manufacturer manufacturer
) {}
