package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;

import java.util.ArrayList;
import java.util.List;

import static CounterStriker.common.ExceptionMessages.INVALID_GUN_REPOSITORY;

public class GunRepository implements Repository<Gun> {

    private List<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public List<Gun> getModels() {
        return models;
    }

    @Override
    public void add(Gun model) {
        if (model == null){
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }

        this.models.add(model);
    }

    @Override
    public boolean remove(Gun model) {
        return models.remove(model);
    }

    @Override
    public Gun findByName(String name) {
        //models.stream().findFirst().equals(name)
        return models.stream()
                .filter(gun1 -> gun1.getName().equals(name))
                .findFirst().orElse(null);

    }
}
