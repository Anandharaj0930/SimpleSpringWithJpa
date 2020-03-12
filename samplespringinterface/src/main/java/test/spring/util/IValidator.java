package test.spring.util;

public interface IValidator<E> {
   void validate(E request);
}
