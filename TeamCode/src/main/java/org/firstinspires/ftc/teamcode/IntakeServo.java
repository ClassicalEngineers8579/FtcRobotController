package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Robot: Field Relative Mecanum Drive", group = "Robot")


public class IntakeServo extends OpMode {

    CRServo Intake;
    @Override
    public void init() {
    Intake = hardwareMap.get(CRServo.class, "IntakeServo");
    }

    @Override
    public void loop() {
        if (gamepad2.right_bumper) {

        }

    }
}
