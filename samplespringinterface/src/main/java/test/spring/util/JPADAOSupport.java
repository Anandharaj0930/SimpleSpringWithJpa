package test.spring.util;

public interface JPADAOSupport<Entity> extends PersistenceSupport<Entity> {

    void refresh(final Entity entity);
}
