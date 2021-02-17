package CounterStriker.repositories;

import CounterStriker.models.players.Player;

import java.util.Collection;

public class PlayerRepository<T extends Player> implements Repository<T> {

    private Collection<T> models;


    @Override
    public Collection<T> getModels() {
        return null;
    }

    @Override
    public void add(T model) {

    }

    @Override
    public boolean remove(T model) {
        return false;
    }

    @Override
    public T findByName(String name) {
        return null;
    }
}
