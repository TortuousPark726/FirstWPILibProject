// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.WheelSubsystem;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class TurnToPositionCommand extends Command {
    /**
     * Creates a new ExampleCommand.
     */
    private double pos;
    private PIDController p1;
    public TurnToPositionCommand(double pos) {
        setName("ExampleCommand");
        this.pos = pos;
        p1 = new PIDController(1, 0, 0);
        
        p1.setTolerance(3);
        p1.enableContinuousInput(0, 360);
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(WheelSubsystem.getInstance());
        
    }


    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        p1.reset();
        
    }


    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        WheelSubsystem.getInstance().setSpeedTurn(this.p1.calculate(WheelSubsystem.getInstance().getDrivingPosition(), pos));
    }


    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        WheelSubsystem.getInstance().setSpeedDrive(0);
    }


    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return this.p1.atSetpoint();
    }
}

