package thaumazein.paytrack.category;

import org.mapstruct.Mapper;
import thaumazein.paytrack.category.dto.CategoryResponse;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
  CategoryResponse toResponse(Category category);
}
