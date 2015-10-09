package org.ftc.opmodes;

import org.ftccommunity.ftcxtensible.opmodes.Autonomous;
import org.ftccommunity.ftcxtensible.robot.ExtensibleOpMode;
import org.ftccommunity.ftcxtensible.robot.RobotContext;
import org.ftccommunity.ftcxtensible.robot.RobotStatus;

import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;

@Autonomous(name = "Hello World Example")
public class HelloWorld extends ExtensibleOpMode {
    @Override
    public void init(RobotContext ctx, LinkedList<Object> out) throws Exception {
        ctx.enableNetworking().startNetworking();
    }

    @Override
    public void init_loop(RobotContext ctx, LinkedList<Object> out) throws Exception {

    }

    @Override
    public void start(RobotContext ctx, LinkedList<Object> out) throws Exception {
        ctx.telemetry().data("TIME", "Start Date: " +
                (new Date(System.nanoTime() / 1000)).toString());
    }

    @Override
    public void loop(RobotContext ctx, LinkedList<Object> out) throws Exception {
        ctx.status().log(Level.INFO, "LOOP", "Current loop count: " + getLoopCount());
        ctx.telemetry().data("MESS", "Hello, World!");
        ctx.telemetry().data("MESS", "How are you doing?");
    }

    @Override
    public void stop(RobotContext ctx, LinkedList<Object> out) throws Exception {
        ctx.status().log(Level.WARNING, "TIME", "End Date: " +
                (new Date(System.nanoTime() / 1000)).toString() + "This ran for " + getRuntime());
    }

    @Override
    public void onSuccess(RobotContext ctx, Object event, Object in) {
        // Don't worry about this; it is used for the advanced stuff
    }

    @Override
    public int onFailure(RobotContext ctx, RobotStatus.Type eventType, Object event, Object in) {
        // Return the default value; for when things go south
        return -1;
    }
}
