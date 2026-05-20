package thaumazein.paytrack.category;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import thaumazein.paytrack.category.dto.CategoryResponse;
import thaumazein.paytrack.category.dto.CreateCategoryRequest;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

  private final CategoryService categoryService;

  @PostMapping
  public ResponseEntity<CategoryResponse> createCategory(
      @Valid @RequestBody CreateCategoryRequest request, UriComponentsBuilder uriBuilder) {
    var response = categoryService.createCategory(request);
    var uri = uriBuilder.path("/api/v1/categories/{id}").buildAndExpand(response.id()).toUri();

    return ResponseEntity.created(uri).body(response);
  }
}
