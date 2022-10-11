package frc.robot.commands.AutonomousSequencing;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoAim.AutoAimCommand;
import frc.robot.commands.AutoAim.AutoshootCommand;
import frc.robot.commands.Manual.TimedMovement;
import frc.robot.commands.Manual.TimedRotation;
import frc.robot.commands.Movement.PIDDriveCommand;
import frc.robot.commands.Movement.PIDTurn;
import frc.robot.commands.PIDTesting.PIDRotateTurret;
import frc.robot.commands.PIDTesting.PIDTurnLeft;
import frc.robot.commands.TurretAuto.ConveyorCommand;
import frc.robot.commands.TurretAuto.IntakeCommand;

public class TestCommand {
    public Command Autonomous1() { //Left side autonomous
        return new SequentialCommandGroup(
            new TimedMovement(0.75),
            new TimedRotation(0.5)
        );
    }

    }
