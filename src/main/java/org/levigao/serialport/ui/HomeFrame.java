package org.levigao.serialport.ui;

import org.jdatepicker.JDatePicker;
import org.levigao.serialport.data.UIConfig;

import javax.swing.*;
import java.awt.*;

public class HomeFrame extends JFrame {
    ///////
    private JLabel mTestDataLabel = new JLabel("测试日期");
    final private JDatePicker mDatePicker = new JDatePicker();
    ///////
    private JLabel mMotorLabel = new JLabel("电机");



    ///////
    private JLabel mReductionRateLabel = new JLabel("减速比");
    private JTextArea mReductionRateTextArea = new JTextArea();

    ///////
    private JLabel mScaleLabel = new JLabel("天平");

    //////
    private JLabel mPumpTypeLabel = new JLabel("泵的型号");

    ///////
    private JLabel mProductNo = new JLabel("产品编号");
    ///////
    private  JLabel mClientName = new JLabel("客户略称");






    private JPanel mHomePanel = new JPanel();

    // Create the JDatePicker

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

        ///////////////Home页面布局///////////////////////////
        //第一行第一个组件
        mTestDataLabel.setForeground(Color.BLACK);
        //mTestDataLabel.setText();
        //x越大越向右，y越大越下
        mTestDataLabel.setBounds(20, 30,
                UIConfig.CHINESE_CHARACTER_WIDTH*4,
                UIConfig.CHINESE_CHARACTER_WIDTH);
        mTestDataLabel.setFont(UIConfig.TEXT_FONT);
       // mTestDataLabel.setBackground(Color.lightGray);
        mTestDataLabel.setOpaque(true);
        mHomePanel.add(mTestDataLabel);


        mDatePicker.setBounds(20+UIConfig.CHINESE_CHARACTER_WIDTH*5,25,
                UIConfig.CHINESE_CHARACTER_WIDTH*10,
                UIConfig.CHINESE_CHARACTER_WIDTH+10);
        mHomePanel.add(mDatePicker);

        //第二行第一个组件
        mMotorLabel.setForeground(Color.BLACK);
        mMotorLabel.setBounds(20, 30+UIConfig.CHINESE_CHARACTER_WIDTH*3,
                UIConfig.CHINESE_CHARACTER_WIDTH*4,
                UIConfig.CHINESE_CHARACTER_WIDTH);
        mMotorLabel.setFont(UIConfig.TEXT_FONT);
       // mMotorLabel.setBackground(Color.lightGray);
        mMotorLabel.setOpaque(true);
        mHomePanel.add(mMotorLabel);








       //第三行第一个组件
        mReductionRateLabel.setForeground(Color.BLACK);
        mReductionRateLabel.setBounds(20, 30+UIConfig.CHINESE_CHARACTER_WIDTH*6,
                UIConfig.CHINESE_CHARACTER_WIDTH*4,
                UIConfig.CHINESE_CHARACTER_WIDTH);
        mReductionRateLabel.setFont(UIConfig.TEXT_FONT);
       // mReductionRateLabel.setBackground(Color.lightGray);
        mReductionRateLabel.setOpaque(true);
        mHomePanel.add(mReductionRateLabel);


        mReductionRateTextArea.setBounds(20+UIConfig.CHINESE_CHARACTER_WIDTH*5,
                25+UIConfig.CHINESE_CHARACTER_WIDTH*6,
                UIConfig.CHINESE_CHARACTER_WIDTH*10,
                UIConfig.CHINESE_CHARACTER_WIDTH+10);
        mReductionRateTextArea.setLineWrap(true);
        mReductionRateTextArea.setWrapStyleWord(true);
        mReductionRateTextArea.setFont(UIConfig.TEXT_FONT);
        mHomePanel.add(mReductionRateTextArea);

        //第四行第一个组件
        mScaleLabel.setForeground(Color.BLACK);
        mScaleLabel.setBounds(20, 30+UIConfig.CHINESE_CHARACTER_WIDTH*9,
                UIConfig.CHINESE_CHARACTER_WIDTH*4,
                UIConfig.CHINESE_CHARACTER_WIDTH);
        mScaleLabel.setFont(UIConfig.TEXT_FONT);
       // mScaleLabel.setBackground(Color.lightGray);
        mScaleLabel.setOpaque(true);
        mHomePanel.add(mScaleLabel);

        //第五章第一个组件
        mPumpTypeLabel.setForeground(Color.BLACK);
        mPumpTypeLabel.setBounds(20, 30+UIConfig.CHINESE_CHARACTER_WIDTH*12,
                UIConfig.CHINESE_CHARACTER_WIDTH*4,
                UIConfig.CHINESE_CHARACTER_WIDTH);
        mPumpTypeLabel.setFont(UIConfig.TEXT_FONT);
       // mPumpTypeLabel.setBackground(Color.lightGray);
        mPumpTypeLabel.setOpaque(true);
        mHomePanel.add(mPumpTypeLabel);

        //第六行第一个组件
        mProductNo.setForeground(Color.BLACK);
        mProductNo.setBounds(20, 30+UIConfig.CHINESE_CHARACTER_WIDTH*15,
                UIConfig.CHINESE_CHARACTER_WIDTH*4,
                UIConfig.CHINESE_CHARACTER_WIDTH);
        mProductNo.setFont(UIConfig.TEXT_FONT);
       // mProductNo.setBackground(Color.lightGray);
        mProductNo.setOpaque(true);
        mHomePanel.add(mProductNo);

        //第七行第一个组件
        mClientName.setForeground(Color.BLACK);
        mClientName.setBounds(20, 30+UIConfig.CHINESE_CHARACTER_WIDTH*18,
                UIConfig.CHINESE_CHARACTER_WIDTH*4,
                UIConfig.CHINESE_CHARACTER_WIDTH);
        mClientName.setFont(UIConfig.TEXT_FONT);
        //mClientName.setBackground(Color.lightGray);
        mClientName.setOpaque(true);
        mHomePanel.add(mClientName);


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
