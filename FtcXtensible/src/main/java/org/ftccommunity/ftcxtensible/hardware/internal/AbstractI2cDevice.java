///*
// * Copyright © 2016 David Sargent
// * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
// * and associated documentation files (the "Software"), to deal in the Software without restriction,
// * including without limitation  the rights to use, copy, modify, merge, publish, distribute, sublicense,
// * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to
// * the following conditions:
// *
// * The above copyright notice and this permission notice shall be included in all copies or
// * substantial portions of the Software.
// *
// * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
// * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
// * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
// * FROM,OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
// */
//
//package org.ftccommunity.ftcxtensible.hardware.internal;
//
//import com.qualcomm.robotcore.hardware.HardwareDevice;
//import com.qualcomm.robotcore.hardware.I2cAddr;
//import com.qualcomm.robotcore.hardware.I2cController;
//import com.qualcomm.robotcore.hardware.I2cDevice;
//
//import java.util.concurrent.locks.Lock;
//
//public class AbstractI2cDevice implements I2cDevice {
//    private I2cController i2cController = null;
//    private int port = -1;
//
//    public AbstractI2cDevice(I2cController controller, int port) {
//        this.i2cController = controller;
//        this.port = port;
//    }
//
//    @Override
//    public void enableI2cReadMode(int i2cAddress, int memAddress, int length) {
//        this.i2cController.enableI2cReadMode(this.port, i2cAddress, memAddress, length);
//    }
//
//    @Override
//    public void enableI2cWriteMode(int i2cAddress, int memAddress, int length) {
//        this.i2cController.enableI2cWriteMode(this.port, i2cAddress, memAddress, length);
//    }
//
//    @Override
//    public byte[] getCopyOfReadBuffer() {
//        return this.i2cController.getCopyOfReadBuffer(this.port);
//    }
//
//    @Override
//    public byte[] getCopyOfWriteBuffer() {
//        return this.i2cController.getCopyOfWriteBuffer(this.port);
//    }
//
//    @Override
//    public void copyBufferIntoWriteBuffer(byte[] buffer) {
//        this.i2cController.copyBufferIntoWriteBuffer(this.port, buffer);
//    }
//
//    @Override
//    public void setI2cPortActionFlag() {
//        this.i2cController.setI2cPortActionFlag(this.port);
//    }
//
//    @Override
//    public boolean isI2cPortActionFlagSet() {
//        return this.i2cController.isI2cPortActionFlagSet(this.port);
//    }
//
//    @Override
//    public void clearI2cPortActionFlag() {
//        this.i2cController.isI2cPortActionFlagSet(this.port);
//    }
//
//    @Override
//    public void readI2cCacheFromController() {
//        this.i2cController.readI2cCacheFromController(this.port);
//    }
//
//    @Override
//    public void writeI2cCacheToController() {
//        this.i2cController.writeI2cCacheToController(this.port);
//    }
//
//    @Override
//    public void writeI2cPortFlagOnlyToController() {
//        this.i2cController.writeI2cPortFlagOnlyToController(this.port);
//    }
//
//    /**
//     * Enable read mode for this I2C device. This simply sets bytes in the header of the write-cache;
//     * it does not enqueue or transmit any data.
//     *
//     * @param i2cAddr  the address of the device on the I2c bus which should be read
//     * @param register I2c register number within the device at which to start reading
//     * @param count    number of bytes to read
//     * @see #writeI2cCacheToController()
//     */
//    @Override
//    public void enableI2cReadMode(I2cAddr i2cAddr, int register, int count) {
//        this.i2cController.enableI2cReadMode(i2cAddr, register, count);
//    }
//
//    /**
//     * Enable write mode for this I2C device. This simply sets bytes in the header of the write-cache;
//     * it does not enqueue or transmit any data.
//     *
//     * @param i2cAddr  the address of the device on the I2c bus which should be written
//     * @param register mem address at which to start writing
//     * @param count    number of bytes to write
//     * @see #writeI2cCacheToController()
//     */
//    @Override
//    public void enableI2cWriteMode(I2cAddr i2cAddr, int register, int count) {
//
//    }
//
//    @Override
//    public boolean isI2cPortInReadMode() {
//        return this.i2cController.isI2cPortInReadMode(this.port);
//    }
//
//    @Override
//    public boolean isI2cPortInWriteMode() {
//        return this.i2cController.isI2cPortInWriteMode(this.port);
//    }
//
//    @Override
//    public boolean isI2cPortReady() {
//        return this.i2cController.isI2cPortReady(this.port);
//    }
//
//    @Override
//    public void registerForPortReadyBeginEndCallback(I2cController.I2cPortReadyBeginEndNotifications i2cPortReadyBeginEndNotifications) {
//        this.i2cController.registerForPortReadyBeginEndCallback(i2cPortReadyBeginEndNotifications, this.port);
//    }
//
//    @Override
//    public I2cController.I2cPortReadyBeginEndNotifications getPortReadyBeginEndCallback() {
//        return this.i2cController.getPortReadyBeginEndCallback(this.port);
//    }
//
//    @Override
//    public void deregisterForPortReadyBeginEndCallback() {
//        this.i2cController.deregisterForPortReadyBeginEndCallback(this.port);
//    }
//
//    @Override
//    public boolean isArmed() {
//        return this.i2cController.isArmed();
//    }
//
//    @Override
//    public I2cController getController() {
//        return this.i2cController;
//    }
//
//    @Override
//    public Lock getI2cReadCacheLock() {
//        return this.i2cController.getI2cReadCacheLock(this.port);
//    }
//
//    @Override
//    public Lock getI2cWriteCacheLock() {
//        return this.i2cController.getI2cWriteCacheLock(this.port);
//    }
//
//    @Override
//    public byte[] getI2cReadCache() {
//        return this.i2cController.getI2cReadCache(this.port);
//    }
//
//    @Override
//    public byte[] getI2cWriteCache() {
//        return this.i2cController.getI2cWriteCache(this.port);
//    }
//
//    @Override
//    public void registerForI2cPortReadyCallback(I2cController.I2cPortReadyCallback callback) {
//        this.i2cController.registerForI2cPortReadyCallback(callback, this.port);
//    }
//
//    @Override
//    public I2cController.I2cPortReadyCallback getI2cPortReadyCallback() {
//        return this.i2cController.getI2cPortReadyCallback(this.port);
//    }
//
//    @Override
//    public void deregisterForPortReadyCallback() {
//        this.i2cController.deregisterForPortReadyCallback(this.port);
//    }
//
//    @Deprecated
//    @Override
//    public int getCallbackCount() {
//        return 0;
//    }
//
//    /**
//     * @deprecated
//     */
//    @Deprecated
//    @Override
//    public void readI2cCacheFromModule() {
//        this.readI2cCacheFromController();
//    }
//
//    /**
//     * @deprecated
//     */
//    @Deprecated
//    @Override
//    public void writeI2cCacheToModule() {
//        this.writeI2cCacheToController();
//    }
//
//    /**
//     * @deprecated
//     */
//    @Deprecated
//    @Override
//    public void writeI2cPortFlagOnlyToModule() {
//        this.writeI2cPortFlagOnlyToController();
//    }
//
//    /**
//     * Returns an indication of the manufacturer of this device.
//     *
//     * @return the device's manufacturer
//     */
//    @Override
//    public Manufacturer getManufacturer() {
//        return null;
//    }
//
//    public String getDeviceName() {
//        return "I2cDevice";
//    }
//
//    public String getConnectionInfo() {
//        return this.i2cController.getConnectionInfo() + "; port " + this.port;
//    }
//
//    public I2cController getI2cController() {
//        return i2cController;
//    }
//
//    @Deprecated
//    @Override
//    public int getPort() {
//        return 0;
//    }
//
//    public int getVersion() {
//        return 1;
//    }
//
//    /**
//     * Resets the device's configuration to that which is expected at the beginning of an OpMode.
//     * For example, motors will reset the their direction to 'forward'.
//     */
//    @Override
//    public void resetDeviceConfigurationForOpMode() {
//
//    }
//
//    public void close() {}
//}
