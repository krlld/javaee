package by.teachmeskills.lesson23.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import java.time.LocalTime;

@WebListener
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletRequestListener.super.requestDestroyed(sre);
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Time of request: " + LocalTime.now());
        ServletRequestListener.super.requestInitialized(sre);
    }
}
