package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

public class DriveMode extends CommandBase {

    public DriveMode(){

    }

    @Override
    public void execute() {
        DriveCommand.state = !DriveCommand.state;
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}