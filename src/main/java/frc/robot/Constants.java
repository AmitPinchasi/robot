// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final class Drive{
        final public static int Right_Rear_Motor = 3, Right_Front_Motor = 4 , Left_Rear_Motor = 2, Left_Front_Motor = 1;
    }
    public final class Climb {
        final public static int ClimbMotor = 6, PullMotor = 7;
    }
    public final class Shoot{
        final public static int ShootMotor = 5;
    }
    public final class collect{
        final public static int CollectMotor = 8;
    }
    public final class color{
    }
}
