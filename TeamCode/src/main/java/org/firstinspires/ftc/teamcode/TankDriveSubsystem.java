package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.stealthrobotics.stealthylib.ftc.StealthSubsystem;

public class TankDriveSubsystem extends StealthSubsystem {
    public final DcMotor left;
    public final DcMotor right;

    public TankDriveSubsystem(HardwareMap hardwareMap) {
        left = hardwareMap.get(DcMotor.class, "leftDrive");
        right = hardwareMap.get(DcMotor.class, "rightDrive");
    }

    public void driveTeleop(double leftSickY, double rightStickX) {
        if (Math.abs(rightStickX) < 0.1) {
            right.setPower(leftSickY);
            left.setPower(leftSickY);
        }
        else {
            if (rightStickX > 0) {
                right.setPower(1);
                left.setPower(-1);
            }
            else {
                right.setPower(-1);
                left.setPower(1);
            }
        }
    }
}