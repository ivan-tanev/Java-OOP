package CounterStriker.core;


import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_GUN;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_PLAYER;

public class ControllerImpl implements Controller {

    private GunRepository guns;
    private PlayerRepository players;
    private FieldImpl field;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        switch (type){
            case "Pistol":
                Gun pistol = new Pistol(name, bulletsCount);
                guns.add(pistol);
                break;
            case "Rifle":
                Gun rifle = new Rifle(name, bulletsCount);
                guns.add(rifle);
                break;
            default:
                throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        switch (type){
            case "Terrorist":

                if (guns.findByName(gunName) == null){
                    throw new NullPointerException(GUN_CANNOT_BE_FOUND);
                }
                Gun gun = guns.findByName(gunName);

                Player terrorist = new Terrorist(username, health, armor, gun);
                players.add(terrorist);
                break;
            case "CounterTerrorist":

                if (guns.findByName(gunName) == null){
                    throw new NullPointerException(GUN_CANNOT_BE_FOUND);
                }
                Gun gun2 = guns.findByName(gunName);

                Player counterTerrorist = new CounterTerrorist(username, health, armor, gun2);
                players.add(counterTerrorist);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        return field.start(players.getModels());
    }

    @Override
    public String report() {

//        List<Player> collectedPlayers = this.players.getModels()
//                .stream()
//                .sorted(Comparator.comparing(player -> player.getClass().getSimpleName()))
//                .sorted((h1, h2) -> Math.min(h1.getHealth(), h2.getHealth()))
//                .sorted(Comparator.comparing(Player::getUsername))
//                .collect(Collectors.toList());

        //compare = Math.max(player1.getHealth(), player2.getHealth());
        //if (compare == 0){
        //}
        List<Player> collectedPlayers = this.players.getModels()
                .stream()
                .sorted(Comparator.comparing((Player player) -> player.getClass().getSimpleName())
                        .thenComparing(Player::getUsername))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (Player collectedPlayer : collectedPlayers) {
            sb.append(collectedPlayer);
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
