package org.firstinspires.ftc.teamcode.Robot.Modules;

import org.firstinspires.ftc.teamcode.Robot.Lib.HardwareConfig;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.Robot.HardwareCompBot;
import org.firstinspires.ftc.teamcode.Robot.Lib.Module;
import org.firstinspires.ftc.teamcode.Utilities.Constants;

public class MecanumDrive extends Module{

    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;
    
    private double speed = 1;
    
    private int encoderThreshold = 50;
    
    
    public MecanumDrive(HardwareConfig c, String lf, String lb, String rf, String rb){
        super(c, lf, lb, rf, rb);
    }
    
    public void init(HardwareMap map){
        leftFront = map.get(DcMotor.class, this.mapping.get(0));
        leftBack = map.get(DcMotor.class, this.mapping.get(1));
        rightFront = map.get(DcMotor.class, this.mapping.get(2));
        rightBack = map.get(DcMotor.class, this.mapping.get(3));
        
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); //BRAKE is to stop ASAP
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);  //FLOAT is to glide to a stop
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        
        rightBack.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
    }
    
    public void resetAllEncoders(){
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public boolean encodersDone(){
        int leftFrontDistance = Math.abs(leftFront.getTargetPosition() - leftFront.getCurrentPosition());
        int leftBackDistance = Math.abs(leftBack.getTargetPosition() - leftBack.getCurrentPosition());
        int rightBackDistance = Math.abs(rightBack.getTargetPosition() - rightBack.getCurrentPosition());
        int rightFrontDistance = Math.abs(rightFront.getTargetPosition() - rightFront.getCurrentPosition());
        
        int distance = (leftFrontDistance + rightBackDistance + leftBackDistance + rightFrontDistance) / 4;
        
        if(distance >= -encoderThreshold && distance <= encoderThreshold){
            return true;
        }
        return false;
    }

    public void driveMecanum(double forward, double rotate, double strafe){
        leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        
        double r = Math.hypot(strafe, -forward);
        double robotAngle = Math.atan2(-forward, strafe) - Math.PI / 4;
        final double velocity1 = r * Math.cos(robotAngle) + rotate;
        final double velocity2 = r * Math.sin(robotAngle) - rotate;
        final double velocity3 = r * Math.sin(robotAngle) + rotate;
        final double velocity4 = r * Math.cos(robotAngle) - rotate;
        
        leftFront.setPower(velocity1 * speed);
        leftBack.setPower(velocity3 * speed);
        rightFront.setPower(velocity2 * speed);
        rightBack.setPower(velocity4 * speed);
    }
    
    public void driveEncoders(double distance){
        double rotations = distance / Constants.WHEEL_CIRCUMFERENCE;
        
        int ticks = (int) Math.round(rotations * Constants.AM_401_MOTOR_TICKS_PER_REV * 0.78);
        
        leftFront.setTargetPosition(leftFront.getCurrentPosition() + ticks);
        leftBack.setTargetPosition(leftBack.getCurrentPosition() + ticks);
        rightFront.setTargetPosition(rightFront.getCurrentPosition() + ticks);
        rightBack.setTargetPosition(rightBack.getCurrentPosition() + ticks);
        
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        leftFront.setPower(speed);
        leftBack.setPower(speed);
        rightFront.setPower(speed);
        rightBack.setPower(speed);
        
        while(!encodersDone()/* && opModeIsActive()*/){
            //telemetry.addData("Driving", "beep beep");
            //telemetry.update();
        }
    }
    
    public void strafeEncoders(double distance){
        double rotations = distance / Constants.WHEEL_CIRCUMFERENCE;
        
        int ticks = (int) Math.round(rotations * Constants.AM_401_MOTOR_TICKS_PER_REV * 0.78);
        
        leftFront.setTargetPosition(leftFront.getCurrentPosition() + ticks);
        leftBack.setTargetPosition(leftBack.getCurrentPosition() - ticks);
        rightFront.setTargetPosition(rightFront.getCurrentPosition() - ticks);
        rightBack.setTargetPosition(rightBack.getCurrentPosition() + ticks);
        
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        leftFront.setPower(speed);
        leftBack.setPower(speed);
        rightFront.setPower(speed);
        rightBack.setPower(speed);
        
        while(!encodersDone() /*&& opModeIsActive()*/){
            //telemetry.addData("Driving", "beep beep");
            //telemetry.update();
        }
    }
    
    public void turnDegrees(int degrees){
        
        
        if(true){
            
        }else{
            
        }
    }
    
    
    
    public void driveRaw(double s1, double s2, double s3, double s4){
        leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        
        leftFront.setPower(s1);
        leftBack.setPower(s2);
        rightFront.setPower(s3);
        rightBack.setPower(s4);
    }
    
    public void stop(){
        leftFront.setPower(0);
        leftBack.setPower(0);
        rightFront.setPower(0);
        rightBack.setPower(0);
        
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    
    public double getSpeed(){
        return speed;
    }
    
    public MecanumDrive setSpeed(double newSpeed){
        this.speed = newSpeed;
        return this;
    }
    
    public String getName(){
        return "MecanumDrive";
    }
}
