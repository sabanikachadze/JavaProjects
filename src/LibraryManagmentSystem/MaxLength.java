package LibraryManagmentSystem;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MaxLength {
    int value();
    String message() default "Field exceeds maximum length";
}
