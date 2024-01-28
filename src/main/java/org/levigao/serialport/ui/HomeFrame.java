package org.levigao.serialport.ui;

import org.jdatepicker.JDatePicker;
import org.levigao.serialport.data.UIConfig;

import javax.swing.*;
import java.awt.*;

public class HomeFrame extends JFrame {
    private JLabel mTestDataLabel = new JLabel();
    private JPanel mHomePanel = new JPanel();

    // Create the JDatePicker
    final private JDatePicker mDatePicker = new JDatePicker();
    public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new HomeFrame().setVisible(true);
			}
		});
	}
    public HomeFrame() {
        initView();
        initComponents();
        actionListener();
        initData();
    }

    /**
     * 初始化窗口
     */
    private void initView() {
        // 关闭程序
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        // 禁止窗口最大化
        setResizable(false);
        // 设置程序窗口居中显示
        Point p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        setBounds(p.x - UIConfig.WINDOW_WIDTH / 2, p.y - UIConfig.WINDOW_HEIGHT / 2,
                UIConfig.WINDOW_WIDTH, UIConfig.WINDOW_HEIGHT);
        this.setLayout(null);
        setTitle(UIConfig.UITitle);
    }

    /**
     * 初始化控件
     */
    private void initComponents() {
        mHomePanel.setBorder(BorderFactory.createTitledBorder("H"));
        mHomePanel.setBounds(0, 0, UIConfig.WINDOW_WIDTH, UIConfig.WINDOW_HEIGHT);
        mHomePanel.setLayout(null);
        add(mHomePanel);



        mTestDataLabel.setForeground(Color.BLACK);
        mTestDataLabel.setText("测试日期");
        //x越大越向右，y越大越下
        mTestDataLabel.setBounds(5, 15,
                UIConfig.CHINESE_CHARACTER_WIDTH*4,
                UIConfig.CHINESE_CHARACTER_WIDTH);
        mTestDataLabel.setFont(UIConfig.TEXT_FONT);
        mTestDataLabel.setBackground(Color.RED);
        mTestDataLabel.setOpaque(true);
        mHomePanel.add(mTestDataLabel);


        mDatePicker.setBounds(5+UIConfig.CHINESE_CHARACTER_WIDTH*5,10,
                UIConfig.CHINESE_CHARACTER_WIDTH*7,
                UIConfig.CHINESE_CHARACTER_WIDTH+10);
        mHomePanel.add(mDatePicker);



    }

    /**
     * 按钮监听事件
     */
    private void actionListener() {}

    /**
     * 初始化数据
     */
    private void initData() {}
}
