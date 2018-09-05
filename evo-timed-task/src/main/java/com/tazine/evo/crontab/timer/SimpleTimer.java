package com.tazine.evo.crontab.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer 的简单用法
 *
 * @author jiaer.ly
 * @date 2018/09/05
 */
public class SimpleTimer {

    private static long start = System.currentTimeMillis();

    public static void main(String[] args) throws ParseException {

        Timer timer = new Timer();

        // 在指定延迟（毫秒）后执行定时任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long end = System.currentTimeMillis();
                System.out.println("Time exec gap : " + (end - start));
            }
        }, 5000);

        // 在指定时间执行定时任务
        // 如果代码运行的时间已经超过设置的定时时间，则定时任务会立即执行
        String dateTime = "20180905143900";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyyMMddHHmmss").parse(dateTime));
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        }, new Date(calendar.getTimeInMillis()));

        // 在指定延迟（毫秒）后按照固定时间间隔（毫秒）重复执行定时任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long now = System.currentTimeMillis();
                System.out.println(now - start);
                start = now;
            }
        },1000, 5000);

    }
}
