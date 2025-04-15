package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.TankDriveSubsystem;

import java.util.function.DoubleSupplier;

/**
 * Drive a Mecanum drivetrain based on stick inputs from a gamepad. This is a "default command" and runs forever.
 */
public class DefaultDriveCommand extends CommandBase {
    final TankDriveSubsystem drive;
    final DoubleSupplier leftY, rightX;

    public DefaultDriveCommand(TankDriveSubsystem drive, DoubleSupplier leftY, DoubleSupplier rightX) {
        this.drive = drive;
        this.leftY = leftY;
        this.rightX = rightX;
        addRequirements(drive);
    }

    /**
     * Called continuously while the robot is running. This asks the suppliers of the stick positions
     * what the current position is and passes those to the drive subsystem to actually move the
     * wheels.
     */
    @Override
    public void execute() {
        drive.driveTeleop(leftY.getAsDouble(), rightX.getAsDouble());
    }
}
