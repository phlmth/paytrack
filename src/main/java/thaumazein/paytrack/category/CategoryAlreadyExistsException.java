package thaumazein.paytrack.category;

public class CategoryAlreadyExistsException extends RuntimeException {
  public CategoryAlreadyExistsException(String name) {
    super("Category with %s already exists".formatted(name));
  }
}
