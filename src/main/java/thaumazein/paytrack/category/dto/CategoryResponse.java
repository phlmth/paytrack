package thaumazein.paytrack.category.dto;

import java.time.LocalDateTime;

public record CategoryResponse(
    String id, String name, String description, LocalDateTime createdAt) {}
