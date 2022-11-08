package frc.robot.commands.Manual;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.RobotContainer;

public class TimedShoot extends CommandBase {
    Timer timer;
    private final double seconds;

    public TimedShoot(double duration) {
        timer = new Timer();
        seconds = duration;
    }

    public void initialize() {
        timer.reset();
        timer.start();
        RobotContainer.m_shooterSubsystem.setShooterSpeed(0.58);

    }

    public void execute() {
            while(timer.get() < seconds) {
                RobotContainer.m_shooterSubsystem.setShooterSpeed(0.58);
                RobotContainer.m_intakeSystem.setFeederSystem(1, 0.7);
                RobotContainer.m_intakeSystem.setConveyorSpeed(1, 1);
              }
    }

    public boolean isFinished() {
        return timer.get() > seconds;
    }

    public void end() {
        RobotContainer.m_shooterSubsystem.setShooterSpeed(0.58);
        RobotContainer.m_intakeSystem.setFeederSystem(1, 0.7);
        RobotContainer.m_intakeSystem.setConveyorSpeed(1, 1);

    }
}