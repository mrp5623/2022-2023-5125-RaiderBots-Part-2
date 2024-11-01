package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

public class DriveSpeed extends CommandBase {

    public DriveSpeed(){

    }

    @Override
    public void execute(){DriveCommand.speed = !DriveCommand.speed;}

    @Override
    public boolean isFinished() {
        return true;
    }

}
