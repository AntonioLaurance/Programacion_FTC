# Programacion_FTC

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp

public class TeleOperado extends LinearOpMode{
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;
    
    // Método waitForStart();
    waitForStart();
    runtime.reset();
    double position = 0;
    
    @Override
    public void runOpMode(){
        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }
    
    while(opModelsActive()){
        // elegir potencia 
    }

    // todo: write your code here
    
}



}
}
