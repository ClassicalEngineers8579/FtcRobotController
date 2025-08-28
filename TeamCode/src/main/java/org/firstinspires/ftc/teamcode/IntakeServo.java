package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "IntakeServoTest", group = "Robot")
@Config
public class IntakeServo extends OpMode {
    //BUCKET VARIABLES
    public static double BUCKET_UNLOAD=0.80;
    public static double BUCKET_LOAD=0.34;
    public static double BUCKET_MID=0.6;

    //VERTICAL SLIDE VARIABLES
    public static int verticalUp=3500;
    public static boolean verticalDown;

    CRServo Intake;
    Servo Bucket;
    DcMotor Vertical;
    @Override
    public void init() {
        Intake = hardwareMap.get(CRServo.class, "IntakeServo");
        Bucket = hardwareMap.get(Servo.class, "Bucket Servo");
        Vertical = hardwareMap.get(DcMotor.class, "Vertical Slide");
        telemetry=new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

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
        if (gamepad2.triangle) {
            if(verticalDown == false){
                Vertical.setPower(1);
                Vertical.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                Vertical.setTargetPosition(verticalUp);
            }
        }
        else if (gamepad2.cross) {
            Vertical.setPower(-0.35);
            if(verticalDown == true){
                Vertical.setPower(0);
            }
        }

        //telementry stuff
        //Vertical Slide
        telemetry.addData("Vert. Slide POS", Vertical.getCurrentPosition());
        telemetry.addData("Vert. Slide PWR", Vertical.getPower());

        //Intake
        telemetry.addData("Intake PWR", Intake.getPower());
        telemetry.addData("Intake Direction", Intake.getDirection());
        //bucket
        telemetry.addData("Bucket Position", Bucket.getPosition());
    }
}
