package org.firstinspires.ftc.teamcode.AveryStuff

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DigitalChannel
import com.qualcomm.robotcore.hardware.DistanceSensor
import com.qualcomm.robotcore.hardware.Gyroscope
import com.qualcomm.robotcore.hardware.Servo
import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap


class HardwareMapExample {
    private val imu: Gyroscope
    private val motorTest: DcMotor
    private val digitalTouch: DigitalChannel
    private val sensorColorRange: DistanceSensor
    private val servoTest: Servo

    init {
        imu = hardwareMap.get(Gyroscope::class.java, "imu")
        motorTest = hardwareMap.get(DcMotor::class.java, "motorTest")
        sensorColorRange = hardwareMap.get(DistanceSensor::class.java, "sensorColorRange")
        servoTest = hardwareMap.get(Servo::class.java, "servoTest")
    }






}


