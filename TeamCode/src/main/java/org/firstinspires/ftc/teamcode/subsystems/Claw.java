package org.firstinspires.ftc.teamcode.subsystems;

import static android.os.SystemClock.sleep;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Claw extends SubsystemBase {
    public ServoEx clawSL;
    public ServoEx clawSR;
    public ServoEx clawIn;
    Telemetry telemetry;
    public double angleOpen = 360;
    public double angleClose = 130;


    public Claw(final HardwareMap hwMap, Telemetry telemetry){
        this.clawSL = new SimpleServo(hwMap, "clawL",-360,360);
        this.clawSR = new SimpleServo(hwMap, "clawR",-360,360);
        this.clawIn = new SimpleServo(hwMap, "clawIn", -50, 100);
        this.telemetry = telemetry;
        clawSR.setInverted(true);
    }

    @Override
    public void periodic() {
        telemetry.addData("clawL", clawSL.getAngle());
        telemetry.addData("clawR", clawSR.getAngle());

    }

    public void Open(){

        clawSL.turnToAngle(angleOpen);
        clawSR.turnToAngle(angleOpen);


    }

    public void Close(){

        clawSL.turnToAngle(angleClose);
       clawSR.turnToAngle(angleClose);
    }

}

