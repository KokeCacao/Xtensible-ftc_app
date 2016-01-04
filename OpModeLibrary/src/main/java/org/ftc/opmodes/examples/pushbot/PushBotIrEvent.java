/*
 * Copyright © 2016 David Sargent
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation  the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM,OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.ftc.opmodes.examples.pushbot;

//------------------------------------------------------------------------------
//
// PushBotIrEvent
//

/**
 * Provide a basic autonomous operational mode that demonstrates the use of an
 * IR seeker implemented using a state machine for the Push Bot.
 *
 * @author SSI Robotics
 * @version 2015-08-16-08-41
 */
public class PushBotIrEvent extends PushBotTelemetrySensors {
    //--------------------------------------------------------------------------
    //
    // PushBotIrEvent
    //

    /**
     * Construct the class.
     * <p>
     * The system calls this member when the class is instantiated.
     */
    public PushBotIrEvent() {
        //
        // Initialize base classes.
        //
        // All via self-construction.

        //
        // Initialize class members.
        //
        // All via self-construction.

    } // PushBotIrEvent

    //--------------------------------------------------------------------------
    //
    // loop
    //

    /**
     * Implement a state machine that controls the robot during auto-operation.
     * <p>
     * The system calls this member repeatedly while the OpMode is running.
     */
    @Override
    public void loop() {
        //
        // When the robot is close to the IR beacon, stop the motors and
        // transition to the next state.
        //
        int l_status = drive_to_ir_beacon();
        if (l_status == drive_to_ir_beacon_running) {
            set_first_message("Driving to IR beacon.");
        } else if (l_status == drive_to_ir_beacon_done) {
            set_error_message("IR beacon is close!");
        } else if (l_status == drive_to_ir_beacon_not_detected) {
            set_error_message("IR beacon not detected!");
        } else if (l_status == drive_to_ir_beacon_invalid) {
            set_error_message("IR beacon return value is invalid!");
        }

        //
        // Send telemetry data to the driver station.
        //
        update_telemetry(); // Update common telemetry

    } // loop

} // PushBotIrEvent
