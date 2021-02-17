package robotService.models.procedures;

import robotService.models.procedures.BaseProcedure;
import robotService.models.robots.interfaces.Robot;

public class Work extends BaseProcedure {
    public Work() {

    }

    @Override
    public void doService(Robot robot, int procedureTime) {
        super.doService(robot, procedureTime);

        int newEnergy = robot.getEnergy() - 6;
        int newHappiness = robot.getHappiness() + 12;
        robot.setEnergy(newEnergy);
        robot.setHappiness(newHappiness);
    }
}
