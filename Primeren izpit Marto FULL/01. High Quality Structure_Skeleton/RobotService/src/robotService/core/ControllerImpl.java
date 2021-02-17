package robotService.core;

import robotService.core.interfaces.Controller;
import robotService.models.garages.GarageImpl;
import robotService.models.garages.interfaces.Garage;
import robotService.models.procedures.Charge;
import robotService.models.procedures.Repair;
import robotService.models.procedures.Work;
import robotService.models.procedures.interfaces.Procedure;
import robotService.models.robots.Cleaner;
import robotService.models.robots.Housekeeper;
import robotService.models.robots.interfaces.Robot;

import static robotService.common.ExceptionMessages.INVALID_ROBOT_TYPE;
import static robotService.common.ExceptionMessages.NON_EXISTING_ROBOT;
import static robotService.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Garage garage;
    private Procedure charge;
    private Procedure repair;
    private Procedure work;

    public ControllerImpl() {
        this.garage = new GarageImpl();
        this.charge = new Charge();
        this.repair = new Repair();
        this.work = new Work();
    }

    @Override
    public String manufacture(String robotType, String name, int energy, int happiness, int procedureTime) {

        Robot robot;
        if (robotType.equals("Cleaner")){
            robot = new Cleaner(name, energy, happiness, procedureTime);
            garage.getRobots().put(name, robot);
            return String.format(ROBOT_MANUFACTURED, name);

        } else if (robotType.equals("Housekeeper")){
            robot = new Housekeeper(name, energy, happiness, procedureTime);
            garage.getRobots().put(name, robot);
            return String.format(ROBOT_MANUFACTURED, name);

        } else {
            //TODO
            throw new IllegalArgumentException(String.format(INVALID_ROBOT_TYPE, robotType));
        }
    }

    @Override
    public String repair(String robotName, int procedureTime) {
        if (!garage.getRobots().containsKey(robotName)){
            throw new IllegalArgumentException(String.format(NON_EXISTING_ROBOT, robotName));
        }

        repair.doService(garage.getRobots().get(robotName), procedureTime);
        return String.format(REPAIR_PROCEDURE, robotName);
    }

    @Override
    public String work(String robotName, int procedureTime) {
        if (!garage.getRobots().containsKey(robotName)){
            throw new IllegalArgumentException(String.format(NON_EXISTING_ROBOT, robotName));
        }

        work.doService(garage.getRobots().get(robotName), procedureTime);
        return String.format(WORK_PROCEDURE, robotName, procedureTime);
    }

    @Override
    public String charge(String robotName, int procedureTime) {
        if (!garage.getRobots().containsKey(robotName)){
            throw new IllegalArgumentException(String.format(NON_EXISTING_ROBOT, robotName));
        }

        charge.doService(garage.getRobots().get(robotName), procedureTime);
        return String.format(CHARGE_PROCEDURE, robotName);
    }

    @Override
    public String sell(String robotName, String ownerName) {
        if (!garage.getRobots().containsKey(robotName)){
            throw new IllegalArgumentException(String.format(NON_EXISTING_ROBOT, robotName));
        }

        garage.sell(robotName, ownerName);
        return String.format(SELL_ROBOT, ownerName, robotName);
    }

    @Override
    public String history(String procedureType) {

        if (procedureType.equals("Charge")){
            return this.charge.history();
        } else if (procedureType.equals("Repair")){
            return this.repair.history();
        } else {
            return this.work.history();
        }

    }
}
