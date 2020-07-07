package org.firstinspires.ftc.teamcode.Robot.Lib;

import java.util.EnumSet;
import java.util.Arrays;

public abstract class OrientationModule extends Module{

    public OrientationModule(HardwareConfig c, String... map){
        super(c, map);
    }

    protected EnumSet<Capability> capabilities = EnumSet.of(Capability.GET_HEADING);
    
    public abstract int getHeading();
}