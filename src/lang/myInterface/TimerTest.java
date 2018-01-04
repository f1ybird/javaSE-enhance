package lang.myInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimerTest
{
    public static void main(String[] args)
    {
        ActionListener listener = new TimePrinter();//实现接口的类的实例赋值给接口变量
        Timer aTimer = new Timer(100, listener);
        aTimer.start();
        JOptionPane.showMessageDialog(null, "Quit program?");//对话框将位于第一参数的组件中央，第一参数为null时位于屏幕中央
        System.exit(0);
    }
}

class TimePrinter implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        Date now = new Date();
        System.out.println("current time is " + now);
        Toolkit.getDefaultToolkit().beep(); //ubuntu下没有响声，没有查找原因
    }
}