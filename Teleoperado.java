// Programacion_FTC
// Métodos de Java de FTC: http://ftctechnh.github.io/ftc_app/doc/javadoc/index.html

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
    
    
    @Override
    public void runOpMode(){
        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    // Dar distancias en cm (rad/m)
    private void moverDistanciaRecta(double distancia){
      frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

      // Calculo del diametro de las ruedas
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
    
    frontLeft = hardwareMap.get(DcMotor.class, "left_front_drive");
    frontRight = hardwareMap.get(DcMotor.class, "right_front_drive");
    backLeft = hardwareMap.get(DcMotor.class, "back_left_drive");
    backRight = hardwareMap.get(DcMotor.class, "back_right_drive");


    // Reseteo del encoder
    frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    frontRight.setMode(DcMotor.RunMode.RUM_WITHOUT_ENCODER);
    backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    
            // elegir potencia

        //setPower();

    //setDirection();
    frontLeft.setDirection(DcMotor.Direction.FORWARD);
    frontRight.setDirection(DcMotor.Direction.REVERSE);
    backLeft.setDirection(DcMotor.Direction.FORWARD);
    backRight.setDirection(DcMotor.Direction.REVERSE); 

    // Método waitForStart();
    waitForStart();
    runtime.reset();
    double position = 0;


    // todo: write your code here
    while(opModeIsActive()){
      double frontLeftPower;
      double frontRightPower;
      double backLeftPower;
      double backRightPower;
      double drive = - gamepad1.left_stick_y;
      double lateral = gamepad1.left_stick_x;
      double turn = gamepad1.right_stick_x;

      // Asignación de las potencias
      frontLeftPower = drive + lateral + turn;
      frontRightPower = drive - lateral - turn;
      backLeftPower = drive - lateral + turn;
      backRightPower = drive + lateral - turn;

      frontLeft.setPower(frontLeftPower);
      frontRight.setPower(frontRightPower);
      backLeft.setPower(backLeftPower);
      backRight.setPower(backRightPower);

    }

    
    
}



}
}
