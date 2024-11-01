package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.util.Timing;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.Claw;

import java.util.concurrent.TimeUnit;

public class ClawClose extends CommandBase {

    public ClawClose() {

    }

    @Override
    public void initialize(){
        ClawCommand.clawCheck += ClawCommand.clawChange;}

    @Override
    public boolean isFinished() {
        return true;
    }

}

