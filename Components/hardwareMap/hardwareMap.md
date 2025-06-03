
# hardwareMap

## What is a hardwareMap?

A hardwareMap is a **class** in the FTC SDK that, using its *get* method, takes a class for a specific device and its **name** in the **configuration file** you made using your REV Driver Hub. It then returns an **object** for the device you inputted and allows for you to **control** it in code.

```kt

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
        digitalTouch = hardwareMap.get(DigitalChannel::class.java, "digitalTouch")
        sensorColorRange = hardwareMap.get(DistanceSensor::class.java, "sensorColorRange")
        servoTest = hardwareMap.get(Servo::class.java, "servoTest")
    }







}

```

## What would you use it for?

The hardwareMap class is used to **initializing** every component of your robot into your code so you can control each of them. For example, for a **DcMotor** assigned to the variable `frontLeftMotor`, you would turn it on full power using `frontLeftMotor.power = 1.0`. Note how power for motors is stored as a **Double**. Overall, the hardwareMap class is vital to programming, and it will be used extensively throughout your entire FTC programming career.
