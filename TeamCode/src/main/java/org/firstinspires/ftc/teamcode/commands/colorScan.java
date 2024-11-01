/*
package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.MechaDrive;

public class colorScan extends CommandBase {
    private MechaDrive drive;
    static int whatcolor = 0 ;


    public colorScan(MechaDrive drive) {
        this.drive = drive;

    }

    @Override
    public void execute(){
        if (drive.colorRed()> drive.colorBlue() && drive.colorRed()> drive.colorGreen()){
            whatcolor = 1;
        }

        else if (drive.colorGreen()> drive.colorRed() && drive.colorGreen()> drive.colorBlue()) {
            whatcolor = 2;
        }

        else if (drive.colorBlue()>drive.colorRed() && drive.colorBlue()>drive.colorGreen()){
            whatcolor = 3;
        }

    }

    }


*/
