package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Command;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.StealthyLib.StealthSubsystem;

import java.util.function.DoubleSupplier;

public class TankDriveSubsystem extends StealthSubsystem {
    public final DcMotor left;
    public final DcMotor right;

    public TankDriveSubsystem(HardwareMap hardwareMap) {
        left = hardwareMap.get(DcMotor.class, "leftDrive");
        right = hardwareMap.get(DcMotor.class, "rightDrive");
    }

    public Command defaultCommand(DoubleSupplier leftY, DoubleSupplier rightY) {
        return this.run(() -> driveTeleop(leftY.getAsDouble(), rightY.getAsDouble()));
    }

    public void driveTeleop(double leftSickY, double rightStickY) {
        if (Math.abs(leftSickY) > 0.1)
            left.setPower(-leftSickY);
        else left.setPower(0);
        if (Math.abs(rightStickY) > 0.1)
            right.setPower(-rightStickY);
        else right.setPower(0);
    }
}