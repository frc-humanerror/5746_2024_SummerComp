// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomi;

import frc.robot.commands.DriveAutoCommand;
import frc.robot.commands.IntakeAutoCommand;
import frc.robot.commands.LaunchAutoCommand;
import frc.robot.commands.ReverseWristAutoCommand;
import frc.robot.commands.TurnAutoCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.WristIntake;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/** An example command that uses an example subsystem. */
public class FourNote_rightfirst_2 extends SequentialCommandGroup {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Drivetrain m_drivetrain;
  private Launcher m_launcher;
  private Intake m_intake;
  private WristIntake m_wristintake;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public FourNote_rightfirst_2(Launcher launcher, Intake intake, Drivetrain drivetrain, WristIntake wristintake) {
    SmartDashboard.putString("FourNote: ", "Started");
    m_launcher = launcher;
    m_intake = intake;
    m_drivetrain = drivetrain;
    m_wristintake = wristintake;
    // Use addRequirements() here to declare subsystem dependencies.
    addCommands(
    new SequentialCommandGroup(
      new ParallelCommandGroup(
        new LaunchAutoCommand(launcher, 1),
        new IntakeAutoCommand(intake, 1, .5, false)
      ),
      new ParallelCommandGroup(
        new DriveAutoCommand(drivetrain, 1, 0.7),
        new ReverseWristAutoCommand(wristintake, true),
        new IntakeAutoCommand(intake, 3, 0, true)
      ),
      new ParallelCommandGroup(
        new DriveAutoCommand(drivetrain, -1, -.7),
        new ReverseWristAutoCommand(wristintake, false)
      ),
      new ParallelCommandGroup(
        new LaunchAutoCommand(launcher, 1),
        new IntakeAutoCommand(intake, 1, .5, false)
      ),
      new DriveAutoCommand(drivetrain, .2, .7),
      new TurnAutoCommand(drivetrain, 25, 0.05),
      new ParallelCommandGroup(
        new DriveAutoCommand(drivetrain, 1.2, 0.7),
        new IntakeAutoCommand(intake, 3, 0, true),
        new ReverseWristAutoCommand(wristintake,true)
      ),
      new ParallelCommandGroup(
        new DriveAutoCommand(drivetrain, -1.2, 0.7),
        new ReverseWristAutoCommand(wristintake, false)
      ),
      new TurnAutoCommand(drivetrain, -25, 0.05),
      new DriveAutoCommand(drivetrain, 0.1, 0.7),
        new ParallelCommandGroup(
        new LaunchAutoCommand(launcher, 1),
        new IntakeAutoCommand(intake, 1, .5, false)
      ),
      new DriveAutoCommand(drivetrain, .2, .7),
      new TurnAutoCommand(drivetrain, -25, 0.05),
      new ParallelCommandGroup(
        new DriveAutoCommand(drivetrain, 1.2, 0.7),
        new IntakeAutoCommand(intake, 3, 0, true),
        new ReverseWristAutoCommand(wristintake,true)
      ),
      new ParallelCommandGroup(
        new DriveAutoCommand(drivetrain, -1.2, 0.7),
        new ReverseWristAutoCommand(wristintake, false)
      ),
      new TurnAutoCommand(drivetrain, 25, 0.05),
      new DriveAutoCommand(drivetrain, 0.1, 0.7),
        new ParallelCommandGroup(
        new LaunchAutoCommand(launcher, 1),
        new IntakeAutoCommand(intake, 1, .5, false)
      )
    )
    );
  }
}