package org.firstinspires.ftc.teamcode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.stealthrobotics.stealthylib.ftc.opmodes.StealthOpMode;

public abstract class Teleop extends StealthOpMode {

    TankDriveSubsystem drive;

    GamepadEx driveGamepad;

    @Override
    public void initialize() {
        // Setup and register all of your subsystems here
        drive = new TankDriveSubsystem(hardwareMap);

        register(drive);

        driveGamepad = new GamepadEx(gamepad1);

        // Automatically reset the elevator all the way down when we init
//        schedule(new ResetElevatorCommand(elevator));

        // A subsystem's default command runs all the time. Great for drivetrains and such.
        drive.setDefaultCommand(
                new DefaultDriveCommand(
                        drive,
                        () -> driveGamepad.gamepad.left_stick_y,
                        () -> driveGamepad.gamepad.right_stick_x
                )
        );
    }

    @SuppressWarnings("unused")
    @TeleOp(name = "Teleop for 1", group = "Red")
    public static class RedTeleop extends Teleop {
    }
}