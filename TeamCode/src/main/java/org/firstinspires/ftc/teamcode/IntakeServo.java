package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "IntakeServoTest", group = "Robot")
public class IntakeServo extends OpMode {

    CRServo Intake;
    @Override
    public void init() {
    Intake = hardwareMap.get(CRServo.class, "IntakeServo");
    }

    @Override
    public void loop() {
        //forward intake controls
        if (gamepad2.right_bumper) {
            Intake.setPower(-1);
        }
        else if (gamepad2.left_bumper) {
            Intake.setPower(1);
        }
        else{
            Intake.setPower(0);
        }

        //telementry stuff
        telemetry.addData("Intake Power", Intake.getPower());
        telemetry.addData("Intake Direction???", Intake.getDirection());
    }
}
