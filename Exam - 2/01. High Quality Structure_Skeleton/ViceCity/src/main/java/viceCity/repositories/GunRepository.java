package viceCity.repositories;

import viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;

public class GunRepository<T> implements Repository<T> {

    private Collection<T> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<T> getModels() {
        return this.models;
    }

    @Override
    public void add(T model) {
        if (models.contains(model)){

        } else {
            models.add(model);
        }
    }

    @Override
    public boolean remove(T model) {
        return models.remove(model);
    }

    @Override
    public T find(String name) {


        return null;
    }
}
