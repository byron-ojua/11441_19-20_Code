package org.firstinspires.ftc.teamcode.Robot;

import org.firstinspires.ftc.teamcode.Robot.Lib.HardwareConfig;
import org.firstinspires.ftc.teamcode.Robot.Modules.*;

public class HardwareCompBot extends HardwareConfig{
    public HardwareCompBot(){
        this.addModule(new MecanumDrive(this, "leftFrontDrive", "leftBackDrive", "rightFrontDrive", "rightBackDrive"));
        this.addModule(new Virtual4Bar(this, "leftArm", "rightArm"));
        //this.addModule(new SyringePump("syringePump", "syringePumpMax", "syringePumpMin"));
        this.addModule(new SyringePumpV2(this, "pumpMotor", "limitSwitch"));
        this.addModule(new FoundationGrab(this, "leftFoundation", "rightFoundation"));
        this.addModule(new GreenIntake(this, "leftIntake", "rightIntake"));
        
        this.addModule(new GyroscopeModule(this, "gyroSensor"));
    }
}