package thaumazein.paytrack.category.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateCategoryRequest(
    @NotBlank(message = "Name is Required") @Size(max = 100, message = "Name must have at most 100 characters") String name,
    String description) {}
