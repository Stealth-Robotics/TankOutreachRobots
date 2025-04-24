package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.stealthrobotics.stealthylib.ftc.opmodes.StealthOpMode;

public abstract class Teleop extends StealthOpMode {
    TankDriveSubsystem drive;
    GamepadEx driveGamepad;

    @Override
    public void initialize() {
        drive = new TankDriveSubsystem(hardwareMap);
        driveGamepad = new GamepadEx(gamepad1);

        register(drive);

        drive.setDefaultCommand(
                drive.driveDefaultCommand(() -> driveGamepad.getLeftY(), () -> driveGamepad.getRightX())
        );
    }

    @SuppressWarnings("unused")
    @TeleOp(name = "Teleop", group = "Red")
    public static class RedTeleop extends Teleop {
    }
}