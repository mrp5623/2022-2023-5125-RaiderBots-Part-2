package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.DriveCommand;

public class MechaDrive extends SubsystemBase {
    Motor fl, bl, fr, br;
    MecanumDrive driveTrain;
    Telemetry telemetry;
    Gyro gyro;
    RevColorSensorV3 color;

    final double WHEEL_DIAMETER = 4;
    final int PULSES_PER_ROTATION = 280;

    public MechaDrive(final HardwareMap hwMap, Telemetry telemetry) {
        fl = new Motor(hwMap, "fl");
        bl = new Motor(hwMap, "bl");
        fr = new Motor(hwMap, "fr");
        br = new Motor(hwMap, "br");
        fl.setInverted(true);
        bl.setInverted(true);
        fr.setInverted(true);
        br.setInverted(true);
        fl.setRunMode(Motor.RunMode.RawPower);
        bl.setRunMode(Motor.RunMode.RawPower);
        fr.setRunMode(Motor.RunMode.RawPower);
        br.setRunMode(Motor.RunMode.RawPower);
        fl.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        bl.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        fr.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        br.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        driveTrain = new MecanumDrive(fl, fr, bl, br);
        this.telemetry = telemetry;
        gyro = new Gyro(hwMap);
        //color = hwMap.get(RevColorSensorV3.class, "color");

    }

    public void powerInit() {
        fl.setRunMode(Motor.RunMode.RawPower);
        fr.setRunMode(Motor.RunMode.RawPower);
        bl.setRunMode(Motor.RunMode.RawPower);
        br.setRunMode(Motor.RunMode.RawPower);
    }
    /*public int colorRed(){
        return color.red();
    }

    public int colorGreen(){
        return color.green();

    }

    public int colorBlue(){
        return color.blue();

    }*/



    public void reset() {
        gyro.resetAngle();
        br.resetEncoder();
        fr.resetEncoder();
        bl.resetEncoder();
        fr.resetEncoder();
    }

    public void robotCentricDrive(double strafeSpeed, double forwardSpeed, double turnSpeed) {
        driveTrain.driveRobotCentric(strafeSpeed, forwardSpeed, turnSpeed);
        telemetry.addLine().addData("Speed", forwardSpeed);
        telemetry.addLine().addData("Turn", turnSpeed);
    }

    public void fieldCentricDrive(double strafeSpeed, double forwardSpeed, double turnSpeed, double heading) {
        driveTrain.driveFieldCentric(strafeSpeed, forwardSpeed, turnSpeed, heading);
    }

    public void tankDrive(double pfr, double pfl, double pbr, double pbl){
        fr.set(pfr);
        fl.set(pfl);
        br.set(pbr);
        bl.set(pbl);
    }

    public boolean atTargetPos() {
        return fl.atTargetPosition() &&
                bl.atTargetPosition() &&
                fr.atTargetPosition() &&
                br.atTargetPosition();
    }

    public void driveToPosition(int afr, int afl, int abr, int abl) {
        fl.setTargetPosition(afl);
        bl.setTargetPosition(abl);
        fr.setTargetPosition(afr);
        br.setTargetPosition(abr);
    }


    public void stop() {
        driveTrain.driveRobotCentric(0, 0, 0);
        driveTrain.driveFieldCentric(0,0,0,gyro.getAngle());
    }
}
