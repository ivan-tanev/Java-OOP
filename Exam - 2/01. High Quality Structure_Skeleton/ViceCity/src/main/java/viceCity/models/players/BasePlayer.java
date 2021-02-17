package viceCity.models.players;

import viceCity.models.guns.Gun;
import viceCity.repositories.GunRepository;
import viceCity.repositories.interfaces.Repository;

import static viceCity.common.ExceptionMessages.PLAYER_LIFE_POINTS_LESS_THAN_ZERO;
import static viceCity.common.ExceptionMessages.PLAYER_NULL_USERNAME;


public abstract class BasePlayer implements Player {

    private String name;
    private int lifePoints;
    private Repository<Gun> gunRepository;

    protected BasePlayer(String name, int lifePoints) {
        this.setName(name);
        this.setLifePoints(lifePoints);
        this.gunRepository = new GunRepository<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(PLAYER_NULL_USERNAME);
        }

        this.name = name;
    }

    public void setLifePoints(int lifePoints) {
        if (lifePoints < 0){
            throw new IllegalArgumentException(PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }

        this.lifePoints = lifePoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public boolean isAlive() {
        if (lifePoints > 0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return this.gunRepository;
    }

    @Override
    public void takeLifePoints(int points) {
        int newLifePoints = this.lifePoints - points;
        setLifePoints(newLifePoints);

        if (this.lifePoints >= 0){
            setLifePoints(0);
        }
        //TODO
    }
}
