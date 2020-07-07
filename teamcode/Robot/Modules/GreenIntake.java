package org.firstinspires.ftc.teamcode.Robot.Modules;

import org.firstinspires.ftc.teamcode.Robot.Lib.HardwareConfig;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Lib.Module;
import org.firstinspires.ftc.teamcode.Robot.Lib.HardwareConfig;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.Utilities.Constants;

public class GreenIntake extends Module{

    private CRServo left;
    private CRServo right;
    
    public GreenIntake(HardwareConfig conf, String left, String right){
        super(conf, left, right);
    }
    
    public void init(HardwareMap hwMap) {
        left = hwMap.get(CRServo.class, this.mapping.get(0));
        right = hwMap.get(CRServo.class, this.mapping.get(1));
        
        left.setDirection(DcMotorSimple.Direction.REVERSE);
        
    }
    
    public void intake(){
        left.setPower(1);
        right.setPower(1);
    }
    
    public void outtake(){
        left.setPower(-1);
        right.setPower(-1);
    }
    
    public void stop(){
        left.setPower(0);
        right.setPower(0);
    }
    
    public String getName(){
        return "GreenIntake";
    }
}