// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class WheelSubsystem extends SubsystemBase {
    // Thread-safe singleton design pattern.

    private CANSparkMax example = new CANSparkMax(2, MotorType.kBrushless);

    public void setSpeed(double speed)
    {
        example.set(speed);
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
