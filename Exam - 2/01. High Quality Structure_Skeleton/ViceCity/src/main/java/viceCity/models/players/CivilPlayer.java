package viceCity.models.players;

public class CivilPlayer extends BasePlayer {

    private int initialLifePoints = 50;
    //Has 50 initial life points.

    protected CivilPlayer(String name, int lifePoints) {
        super(name, lifePoints);
        //name = this.name;
        //lifePoints = initialLifePoints;
    }
}
