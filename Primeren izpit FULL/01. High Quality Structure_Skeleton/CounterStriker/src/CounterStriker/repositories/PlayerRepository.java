package CounterStriker.repositories;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.List;

import static CounterStriker.common.ExceptionMessages.INVALID_PLAYER_REPOSITORY;

public class PlayerRepository implements Repository<Player> {

    private List<Player> models;

    public PlayerRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public List<Player> getModels() {
        return models;
    }

    @Override
    public void add(Player model) {
        if (model == null){
            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
        }

        this.models.add(model);
    }

    @Override
    public boolean remove(Player model) {
        return models.remove(model);
    }

    @Override
    public Player findByName(String name) {
        return models.stream()
                .filter(gun1 -> gun1.getUsername().equals(name))
                .findFirst().orElse(null);
    }

}
