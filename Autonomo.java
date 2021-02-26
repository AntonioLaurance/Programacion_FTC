// Programacion_FTC_Sputnik

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous
public class Autonomo extends LinearOpMode{

    // todo: write your code here
    // Métodos de Java de FTC: http://ftctechnh.github.io/ftc_app/doc/javadoc/index.html
    
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

        // Reconocimiento de motores
        frontLeft = hardwareMap.get(DcMotor.class, "left_front_drive");
        frontRight = hardwareMap.get(DcMotor.class, "right_front_drive");
        backLeft = hardwareMap.get(DcMotor.class, "back_left_drive");
        backRight = hardwareMap.get(DcMotor.class, "back_right_drive"); 

        //setDirection();
        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.FORWARD);

        // Dar distancias en cm 
        private void moverDistanciaRecta(double distancia){
          frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
          frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
          backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
          backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

          // Calculo del diametro de las ruedas
          // Calcular (rad/cm)
          // Ver dirección de los motores
          frontLeft.setTargetPosition((int)(distancia*288/9));
          frontRight.setTargetPosition((int)(distancia*288/9d));
          backLeft.setTargetPosition((int)(distancia*288/9));
          backRight.setTargetPosition((int)(distancia*288/9d));

          while (opModeIsActive() && frontLeft.isBusy() && frontRight.isBusy()){

            frontLeft.setPower(0.75);
            frontRight.setPower(0.75);
            backLeft.setPower(0.75);
            backRight.setPower(0.75);

          }
        }   
    
    private void moverLateralmente(double distancia){
        
    }
    
    
}
