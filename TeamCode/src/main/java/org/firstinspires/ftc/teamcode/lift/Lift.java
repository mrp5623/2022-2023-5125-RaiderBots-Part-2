
package org.firstinspires.ftc.teamcode.lift;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.DifferentialDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Lift extends SubsystemBase {

   Telemetry telemetry;
   private final Motor lift;
   double liftPower = .75;


    public Lift(HardwareMap hwMap, Telemetry telemetry) {
        Motor lift = new Motor(hwMap,"lift");
        //lift.setTargetPosition(0);
        lift.set(0);
        this.telemetry = telemetry;
        this.lift = lift;
        lift.setRunMode(Motor.RunMode.RawPower);

    }

    public void powerInit(){
        lift.setRunMode(Motor.RunMode.RawPower);
    }
    public void rise(double power){
        lift.set(power);
        telemetry.addData("Lift", power);
    }

    public void reset(){
        lift.resetEncoder();
    }

    public void liftToPosition(int elift) {
        lift.setTargetPosition(elift);
    }

    public boolean atTargetPos() {
        return lift.atTargetPosition();
    }


    public int currentPosition() {
        return lift.getCurrentPosition();

    }

    public void stop(){
        lift.set(0);
    }

    public void encoderLift(int position){
        lift.setRunMode(Motor.RunMode.PositionControl);
        lift.setTargetPosition(position);
    }

    public void liftTelemetry(){
        telemetry.addData("lTarget", lift.getCurrentPosition());
    }

    public boolean LiftCheck(){
        return true; //lift.atTargetPosition();

    }

    public void Small(){
        lift.setTargetPosition(700);
        while (!LiftCheck()) {
            lift.set(liftPower);
        }
        telemetry.addLine("Lift Small");
        telemetry.update();
    }

    public void Medium(){
        lift.setTargetPosition(900);
        while (!LiftCheck()) {
            lift.set(liftPower);
        }
        telemetry.addLine("Lift Mid");
        telemetry.update();
    }

    public void Large(){
        lift.setTargetPosition(1100);
        while (!LiftCheck()) {
            lift.set(liftPower);
        }
        telemetry.addLine("Lift Large");
        telemetry.update();
    }

    public void Bottom(){
        lift.setTargetPosition(0);
        while (!LiftCheck()) {
            lift.set(liftPower);
        }
        telemetry.addLine("Lift Bottom");
        telemetry.update();
    }

}

