package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.StealthyLib.opmodes.StealthOpMode;

public abstract class Teleop extends StealthOpMode {
    TankDriveSubsystem drive;
    ArmSubsystem arm;

    GamepadEx driveGamepad;

    @Override
    public void initialize() {
        drive = new TankDriveSubsystem(hardwareMap);
        arm = new ArmSubsystem(hardwareMap);
        driveGamepad = new GamepadEx(gamepad1);

        register(drive, arm);

        drive.setDefaultCommand(
                drive.defaultCommand(() -> driveGamepad.getLeftY(), () -> driveGamepad.getRightY())
        );

        arm.setDefaultCommand(
                arm.defaultCommand(() -> driveGamepad.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER), () -> driveGamepad.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER))
        );
    }

    @SuppressWarnings("unused")
    @TeleOp(name = "RedTeleop", group = "Red")
    public static class RedTeleop extends Teleop {
    }

    @SuppressWarnings("unused")
    @TeleOp(name = "BlueTeleop", group = "Blue")
    public static class BlueTeleop extends Teleop {
    }
}