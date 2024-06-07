// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class DriveAutoCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain m_Drivetrain;
  private double m_distanceMeters;
  private double m_encoderSetpoint;
  private double m_motorSpeed;
  private double m_autoDriveMult;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveAutoCommand(Drivetrain drivetrain, double distanceMeters, double motorSpeed) {
    m_Drivetrain = drivetrain;
    m_distanceMeters = distanceMeters;
    m_motorSpeed = motorSpeed;
    m_encoderSetpoint = m_Drivetrain.getMetersDriven() + m_distanceMeters;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Drivetrain.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Drivetrain.move(-m_motorSpeed*DriveConstants.autoDriveMult, -m_motorSpeed*DriveConstants.autoDriveMult);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Drivetrain.move(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Math.abs(m_Drivetrain.getMetersDriven()) > m_encoderSetpoint) {
      return true;
    }
    else {
    return false;
    }
  }
}