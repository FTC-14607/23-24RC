package org.firstinspires.ftc.teamcode.Teles;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;

import org.checkerframework.checker.index.qual.NonNegative;
import java.text.DecimalFormat;
import java.util.Arrays;

import org.firstinspires.ftc.teamcode.Robots.Octonaut;

@TeleOp(name = "Main TeleOp", group = "main")
public class IdiotsInCars extends LinearOpMode {
    // Finite States
    private enum OpState { START, }

    // Etc
    Octonaut robot;

    //test servo (11/30/2023)
    private double servoPos = 0.666;
    public void moveServo(@NonNull Gamepad gamepad) {
        if (gamepad.left_bumper && gamepad.right_bumper) servoPos = 0.666; // straighten arm
        else if (gamepad.right_bumper) servoPos += 0.01;
        else if (gamepad.left_bumper) servoPos -= 0.01;
        robot.setServo(servoPos);
    }

    public void runOpMode() {
        robot = new Octonaut(this, 0,0, 8192, 5, 30, 0);

        waitForStart();
        while(opModeIsActive())
        {
//            telemetry.addData("imu", robot.imu.getAngularOrientation());
//            telemetry.addData("context", robot.odometry.getContext());
            telemetry.update();
            moveServo(gamepad1);
            telemetry.addData("Swivel position", servoPos);
        }
    }
}
