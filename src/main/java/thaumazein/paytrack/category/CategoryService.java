package thaumazein.paytrack.category;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thaumazein.paytrack.category.dto.CategoryResponse;
import thaumazein.paytrack.category.dto.CreateCategoryRequest;

@Service
@RequiredArgsConstructor
public class CategoryService {

  private final CategoryRepository categoryRepository;
  private final CategoryMapper categoryMapper;

  @Transactional
  public CategoryResponse createCategory(CreateCategoryRequest request) {
    String name = request.name().trim();

    if (categoryRepository.existsByNameIgnoreCase(name)) {
      throw new CategoryAlreadyExistsException(name);
    }

    Category category = new Category();
    category.setName(name);
    category.setDescription(request.description());

    Category savedCategory = categoryRepository.save(category);

    return categoryMapper.toResponse(savedCategory);
  }
}
