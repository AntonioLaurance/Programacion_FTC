// Programacion_FTC
// Métodos de Java de FTC: http://ftctechnh.github.io/ftc_app/doc/javadoc/index.html

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;
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

      // Reconocimiento de motores
      frontLeft = hardwareMap.get(DcMotor.class, "left_front_drive");
      frontRight = hardwareMap.get(DcMotor.class, "right_front_drive");
      backLeft = hardwareMap.get(DcMotor.class, "back_left_drive");
      backRight = hardwareMap.get(DcMotor.class, "back_right_drive");

      // Reseteo del encoder
      frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
      frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
      backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
      backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    //setDirection();
    frontLeft.setDirection(DcMotor.Direction.FORWARD);
    frontRight.setDirection(DcMotor.Direction.REVERSE);
    backLeft.setDirection(DcMotor.Direction.REVERSE);
    backRight.setDirection(DcMotor.Direction.FORWARD); 

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

      // elegir potencia
      //setPower();
      frontLeft.setPower(frontLeftPower);
      frontRight.setPower(frontRightPower);
      backLeft.setPower(backLeftPower);
      backRight.setPower(backRightPower);

    }   
