// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.CANcoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class WheelSubsystem extends SubsystemBase {
    // Thread-safe singleton design pattern.

    private CANSparkMax driving = new CANSparkMax(2, MotorType.kBrushless);
    private CANSparkMax turning = new CANSparkMax(3, MotorType.kBrushless);
    private CANcoder sensor = new CANcoder(1);
    

    public void setSpeedDrive(double speed)
    {
        driving.set(speed);
    }
    public void setSpeedTurn(double speed)
    {
        turning.set(speed);
    }
    public double getDrivingPosition()
    {
        return Units.rotationsToDegrees(sensor.getAbsolutePosition().getValueAsDouble());
    }





    private static volatile WheelSubsystem instance;
    private static Object mutex = new Object();


    public static WheelSubsystem getInstance() {
        WheelSubsystem result = instance;
       
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null) {
                    instance = result = new WheelSubsystem();
                }
            }
        }
        return instance;
    }


    /** Creates a new ExampleSubsystem. */
    private WheelSubsystem() {
        super("ExampleSubsystem");
    }


    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
