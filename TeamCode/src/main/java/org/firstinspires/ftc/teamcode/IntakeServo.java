package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "IntakeServoTest", group = "Robot")
@Config
public class IntakeServo extends OpMode {
    public static double BUCKET_UNLOAD=0.80;
    public static double BUCKET_LOAD=0.34;
    public static double BUCKET_MID=0.6;

    CRServo Intake;
    Servo Bucket;
    @Override
    public void init() {
    Intake = hardwareMap.get(CRServo.class, "IntakeServo");
    Bucket = hardwareMap.get(Servo.class, "Bucket Servo");

    }

    @Override
    public void loop() {

        //Bucket Controls
        //Set Bucket to UNLOAD
        if (gamepad2.dpad_right){
            Bucket.setPosition(BUCKET_UNLOAD);
        }

        //Set Bucket to LOAD
        if (gamepad2.dpad_down){
            Bucket.setPosition(BUCKET_LOAD);
        }

        //Set bucket to MID
        if (gamepad2.dpad_up){
            Bucket.setPosition(BUCKET_MID);
        }


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
        //Intake
        telemetry.addData("Intake Power", Intake.getPower());
        telemetry.addData("Intake Direction???", Intake.getDirection());
        //bucket
        telemetry.addData("Bucket Position", Bucket.getPosition());
    }
}
