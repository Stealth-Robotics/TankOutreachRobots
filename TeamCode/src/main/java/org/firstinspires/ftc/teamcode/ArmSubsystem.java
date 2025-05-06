package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Command;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.StealthyLib.StealthSubsystem;

import java.util.function.DoubleSupplier;

public class ArmSubsystem extends StealthSubsystem {
    private final DcMotorEx arm;

    public ArmSubsystem(HardwareMap hardwareMap) {
        arm = hardwareMap.get(DcMotorEx.class, "armMotor");

        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public Command defaultCommand(DoubleSupplier leftBumper, DoubleSupplier rightBumper) {
        return this.run(() -> controlArm((leftBumper.getAsDouble() - rightBumper.getAsDouble())));
    }

    public void controlArm(double power) {
        if (Math.abs(power) > 0.1)
            arm.setPower(power);
        else arm.setPower(0);
    }
}
