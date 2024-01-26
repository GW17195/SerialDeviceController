package org.levigao.serialport.ui;

import org.levigao.serialport.data.UIConfig;

import javax.swing.*;
import java.awt.*;

public class HomeFrame extends JFrame {
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
