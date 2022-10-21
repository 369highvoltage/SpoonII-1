package frc.robot.commands.AutonomousSequencing;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Manual.TimedIntake;
import frc.robot.commands.Manual.TimedIntakeForward;
import frc.robot.commands.Manual.TimedMovement;
import frc.robot.commands.Manual.TimedRotation;
import frc.robot.commands.Manual.TimedShoot;
import frc.robot.commands.PIDTesting.PIDSteering;

public class TestCommand {
    public Command Autonomous1() { //Left side autonomous
        return new SequentialCommandGroup(
            new ParallelCommandGroup(
                new TimedIntakeForward(0.8),
                new TimedMovement(0.8),
                new TimedIntake(0.8)
            ),
            new TimedRotation(0.84),
            new TimedShoot(2)
        );
    }

    public Command PIDTesting(){
        return new SequentialCommandGroup(
            new PIDSteering(90),
            new TimedMovement(1),
            new PIDSteering(-90)
        );
    }

    }
