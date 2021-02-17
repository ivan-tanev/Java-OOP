package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {

    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.setGun(gun);
        this.setAlive();
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()){
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }

        this.username = username;
    }

    public void setHealth(int health) {
        if (health < 0){
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }

        this.health = health;
    }

    public void setArmor(int armor) {
        if (armor < 0){
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }

        this.armor = armor;
    }

    public void setAlive() {
        if (this.health > 0){
            this.isAlive = true;
        } else {
            this.isAlive = false;
        }

    }

    public void setGun(Gun gun) {
        if (gun == null){
            throw new NullPointerException(INVALID_GUN);
        }

        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public void takeDamage(int points) {
        if (points >= this.getArmor()){
            points = points - this.getArmor();
            this.setArmor(0);

            if (points >= this.getHealth() && this.getArmor() == 0){
                this.setHealth(0);

            } else if (points < this.getHealth() && this.getArmor() == 0){
                this.setHealth(this.getHealth() - points);
            }
        } else {
            this.setArmor(this.getArmor() - points);

        }

//        if (points >= this.getHealth() && this.getArmor() == 0){
//            this.setHealth(0);
//
//        } else if (points < this.getHealth() && this.getArmor() == 0){
//            this.setHealth(this.getHealth() - points);
//        }

        //???????
        this.setAlive();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: %s", getClass().getSimpleName(), getUsername()));
        sb.append(System.lineSeparator());
        sb.append(String.format("--Health: %d", getHealth()));
        sb.append(System.lineSeparator());
        sb.append(String.format("--Armor: %d", getArmor()));
        sb.append(System.lineSeparator());
        sb.append(String.format("--Gun: %s", getGun().getName()));
        sb.append(System.lineSeparator());

        return sb.toString().trim();
    }
}
