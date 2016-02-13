package com.learnandroid.laladriver.iohandler;

import com.learnandroid.lalataxi.bean.CodeBean;
import com.learnandroid.lalataxi.bean.CustomBean;
import com.learnandroid.lalataxi.bean.DriverBean;
import com.learnandroid.lalataxi.bean.LocationBean;
import com.learnandroid.lalataxi.bean.LoginResultBean;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class MyIoHandler implements IoHandler {

    @Override
    public void sessionCreated(IoSession ioSession) throws Exception {

    }

    @Override
    public void sessionOpened(IoSession ioSession) throws Exception {

    }

    @Override
    public void sessionClosed(IoSession ioSession) throws Exception {

    }

    @Override
    public void sessionIdle(IoSession ioSession, IdleStatus idleStatus) throws Exception {

    }

    @Override
    public void exceptionCaught(IoSession ioSession, Throwable throwable) throws Exception {

    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        if (message.getClass() == CodeBean.class) {
            CodeBean code = (CodeBean) message;
            reCode.showCode(code);
        } else if (message.getClass() == LoginResultBean.class) {
            LoginResultBean result = (LoginResultBean)message;
            reLoginResult.showLoginResult(result);
        } else if (message.getClass() == CustomBean.class) {
            CustomBean custom = (CustomBean)message;
            reCustom.showCustom(custom);
        } else if (message.getClass() == DriverBean.class) {
            DriverBean driver = (DriverBean)message;
            reDriver.deleteCustom(driver);
        }
    }

    @Override
    public void messageSent(IoSession ioSession, Object o) throws Exception {
    }

    @Override
    public void inputClosed(IoSession ioSession) throws Exception {

    }

    //接口们
    private ReCode reCode;
    public void setReCodeListener(ReCode r) {
        this.reCode = r;
    }

    private ReLoginResult reLoginResult;
    public void setReLoginResultListener(ReLoginResult r){
        this.reLoginResult = r;
    }

    private ReCustom reCustom;
    public void setReCustomListener(ReCustom r){
        this.reCustom = r;
    }

    private ReDriver reDriver;
    public void setReDriverListener(ReDriver r){
        this.reDriver = r;
    }
}
