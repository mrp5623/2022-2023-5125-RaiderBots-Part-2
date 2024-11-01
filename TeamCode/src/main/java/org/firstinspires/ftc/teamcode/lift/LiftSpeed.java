package org.firstinspires.ftc.teamcode.lift;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.commands.DriveCommand;

public class LiftSpeed extends CommandBase {

    public LiftSpeed(){

    }

    @Override
    public void execute(){LiftCommand.speed = !LiftCommand.speed;}

    @Override
    public boolean isFinished() {
        return true;
    }

}
