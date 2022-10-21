package frc.robot.commands.Manual;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.RobotContainer;

public class TimedIntake extends CommandBase {
    Timer timer;
    private final double seconds;
     

    public TimedIntake(double duration) {
        timer = new Timer();
        seconds = duration;
    }

    public void initialize() {
        timer.reset();
        timer.start();
        RobotContainer.m_intakeSystem.setIntakeSystem(1, 0.7);
    }

    public void execute() {
        RobotContainer.m_intakeSystem.setIntakeSystem(1, 0.7);
    }

    public boolean isFinished() {
        return timer.get() > seconds;
    }

    public void end() {
        RobotContainer.m_intakeSystem.setIntakeSystem(1, 0.7);
    }
}