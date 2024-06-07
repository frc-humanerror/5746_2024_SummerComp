// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LauncherConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Launcher extends SubsystemBase {
  private WPI_TalonSRX launchmotorleft = new WPI_TalonSRX(7);
  private WPI_TalonSRX launchmotorright = new WPI_TalonSRX(8);

  
  /** Creates a new ExampleSubsystem. */
  public void Launch(double getLeftXboxJoystickY) {
    launchmotorleft.set(getLeftXboxJoystickY*LauncherConstants.launchSpeed);
  }

  public Launcher() {
    launchmotorright.follow(launchmotorleft);
  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
