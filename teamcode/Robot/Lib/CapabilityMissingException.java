package org.firstinspires.ftc.teamcode.Robot.Lib;


public class CapabilityMissingException extends RuntimeException{

    public Capability missing;
    
    public CapabilityMissingException(Capability c, String message){
        super(message);
        this.missing = c;
    }
}