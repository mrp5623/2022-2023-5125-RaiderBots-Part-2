package org.firstinspires.ftc.teamcode.lift;

import com.arcrobotics.ftclib.command.CommandBase;

public class HeightCheckUp extends CommandBase {

    public HeightCheckUp(){}

    @Override
    public void initialize(){LiftCommand.heightCheck += LiftCommand.heightChange;}

    @Override
    public boolean isFinished() {
        return true;
    }




}
