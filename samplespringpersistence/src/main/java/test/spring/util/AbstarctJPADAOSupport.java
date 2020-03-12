package test.spring.util;

import test.spring.SpringProPersistenceException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.Collection;

public abstract class AbstarctJPADAOSupport<Entity> implements JPADAOSupport<Entity> {

    public abstract Class<Entity> getEntityClass();

    public abstract EntityManager getEntityManager();

    @Override
    public void refresh(Entity entity) {
        refresh(entity, true);
    }

    @Override
    public Entity get(Serializable id) {
        return getEntityManager().find(getEntityClass(), id);
    }

    @Override
    public Entity save(Entity entity, boolean flushMode) {
        try {
            getEntityManager().persist(entity);
            flush(flushMode);
            refresh(entity, flushMode);
        } catch (PersistenceException ex) {
            throw new SpringProPersistenceException("Exception in Save ", ex);
        }

        return entity;
    }

    @Override
    public Entity update(Entity entity, boolean flushMode) {
        return null;
    }

    @Override
    public Entity delete(Entity entity, boolean flushMode) {
        return null;
    }

    @Override
    public Collection<Entity> getAllEntity() {
        return null;
    }

    private void refresh(final Entity entity, final boolean isRefresh) {
        if (isRefresh) {
            getEntityManager().refresh(entity);
        }
    }

    private void flush(final boolean flushMode) {
        if (flushMode) {
            getEntityManager().flush();
        }
    }
}
