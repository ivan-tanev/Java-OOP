package bakery.repositories.interfaces;

import java.util.Collection;

public class TableRepositoryImpl<T> implements Repository<T> {

    public TableRepositoryImpl() {
    }

    @Override
    public Collection<T> models() {
        return null;
    }

    @Override
    public Collection<T> getAll() {
        return null;
    }

    @Override
    public void add(T t) {

    }
}
