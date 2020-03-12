package test.spring.util;

import java.io.Serializable;
import java.util.Collection;

public interface PersistenceSupport<Entity> {

    Entity get(Serializable id);

    Entity save(final Entity entity, final boolean flushMode);

    Entity update(final Entity entity, final boolean flushMode);

    Entity delete(final Entity entity, final boolean flushMode);

    Collection<Entity> getAllEntity();

}
