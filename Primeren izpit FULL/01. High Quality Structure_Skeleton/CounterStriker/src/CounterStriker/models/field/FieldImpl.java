package CounterStriker.models.field;

import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field {

    @Override
    public String start(Collection<Player> players) {

        ArrayList<Player> terrorists = players.stream()
                .filter(player -> player instanceof Terrorist)
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Player> counterTerrorists = players.stream()
                .filter(player -> player instanceof CounterTerrorist)
                .collect(Collectors.toCollection(ArrayList::new));

        while (!terrorists.isEmpty() && !counterTerrorists.isEmpty()) {
            for (Player terrorist : terrorists) {
                for (Player counterTerrorist : counterTerrorists) {
                    counterTerrorist.takeDamage(terrorist.getGun().fire());
                }
            }

            counterTerrorists = counterTerrorists
                    .stream()
                    .filter(Player::isAlive)
                    .collect(Collectors.toCollection(ArrayList::new));

            for (Player counterTerrorist : counterTerrorists) {
                for (Player terrorist : terrorists) {
                    terrorist.takeDamage(counterTerrorist.getGun().fire());
                }
            }

            terrorists = terrorists
                    .stream()
                    .filter(Player::isAlive)
                    .collect(Collectors.toCollection(ArrayList::new));

        }

        return terrorists.isEmpty() ? COUNTER_TERRORIST_WINS : TERRORIST_WINS;
    }
}
