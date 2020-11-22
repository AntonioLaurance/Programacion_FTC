# Programacion_FTC_Sputnik

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous

public class Autonomo extends LinearOpMode{

    // todo: write your code here
    
    // definir las variables de nuestros motores
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;
    
    
    waitForStart();
    runtime.reset();
    double position = 0;
    
    
    @Override 
    public void runOpMode(){
        telemetry.addData("Status", "Initialized");
        telemetry.update();    
    }
    
    private void moverDistanciaRecta(double distancia){
        
    }
    
    private void moverLateralmente(double distancia){
        
    }
    
    
}
