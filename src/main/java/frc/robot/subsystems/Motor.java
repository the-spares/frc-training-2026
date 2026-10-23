// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkMax;
import org.littletonrobotics.junction.Logger;
import com.revrobotics.spark.SparkBase.ResetMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.MotorConstants;

public class Motor extends SubsystemBase {
  /** Creates a new Motor. */
  private SparkMax m_motor = new SparkMax(MotorConstants.kDeviceID, MotorType.kBrushless);
  private SparkMaxConfig m_motorConfig = new SparkMaxConfig();
  public Motor() {
    m_motorConfig.idleMode(IdleMode.kBrake);
    m_motor.configure(m_motorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    
  }

  @Override
  public void periodic() {
    Logger.recordOutput("motorSpeed", m_motor.get());
    // This method will be called once per scheduler run
  }
  public void setSpeed(double speed){
    m_motor.set(speed);

  }

}
