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
    private JTextField mReductionRateTextField = new JTextField();

    ///////
    private JLabel mScaleLabel = new JLabel("天平");

    //////
    private JLabel mPumpTypeLabel = new JLabel("泵的型号");

    ///////
    private JLabel mProductNo = new JLabel("产品编号");
    ///////
    private  JLabel mClientName = new JLabel("客户略称");

    private  JLabel mLiquidName = new JLabel("液体名称");

    private  JTextField mLiquidNameTextField = new JTextField();

    private  JLabel mLiquidRate = new JLabel("液体比重");

    private  JTextField mLiquidRateTextField = new JTextField();

    private  JLabel mLiquidViscosity = new JLabel("液体粘度");

    private  JTextField mLiquidViscosityTextField = new JTextField();

    private  JLabel mLiquidViscosityUnit = new JLabel("cP(Mpa.s)");

    private  JLabel mLiquidTemperature = new JLabel("液温");

    private  JTextField mLiquidTemperatureTextField = new JTextField();

    private  JLabel mLiquidTemperatureUnit = new JLabel("℃");

    private  JLabel mMaxThroughputRate = new JLabel("最大吞吐量");

    private  JTextField mMaxThroughputRateTextField = new JTextField();

    private JButton mMaxThroughputRateUnitButton = new JButton("ml");

    private  JLabel mThroughputRatePerTurn = new JLabel("每转吐出量");

    private  JTextField mThroughputRatePerTurnTextField = new JTextField();

    private  JLabel mThroughputRatePerTurnUnit = new JLabel("ml/rev");

    private JPanel mHomePanel = new DrawLineJPanel();

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
        mHomePanel.setBorder(BorderFactory.createTitledBorder("v0"));
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
        mTestDataLabel.setBackground(Color.lightGray);
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


        mReductionRateTextField.setBounds(20+UIConfig.CHINESE_CHARACTER_WIDTH*5,
                25+UIConfig.CHINESE_CHARACTER_WIDTH*6,
                UIConfig.CHINESE_CHARACTER_WIDTH*10,
                UIConfig.CHINESE_CHARACTER_WIDTH+10);
        mReductionRateTextField.setFont(UIConfig.TEXT_FONT);
        mHomePanel.add(mReductionRateTextField);

        //第四行第一个组件
        mScaleLabel.setForeground(Color.BLACK);
        mScaleLabel.setBounds(20, 30+UIConfig.CHINESE_CHARACTER_WIDTH*9,
                UIConfig.CHINESE_CHARACTER_WIDTH*4,
                UIConfig.CHINESE_CHARACTER_WIDTH);
        mScaleLabel.setFont(UIConfig.TEXT_FONT);
       // mScaleLabel.setBackground(Color.lightGray);
        mScaleLabel.setOpaque(true);
        mHomePanel.add(mScaleLabel);

        //第五行第一个组件
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
        ///////////////////////////////////////////////
        //第一行第二个组件
        mLiquidName.setForeground(Color.BLACK);
        mLiquidName.setBounds(20+UIConfig.CHINESE_CHARACTER_WIDTH*18 ,
                30, UIConfig.CHINESE_CHARACTER_WIDTH*4,
                UIConfig.CHINESE_CHARACTER_WIDTH);
        mLiquidName.setFont(UIConfig.TEXT_FONT);
        //mClientName.setBackground(Color.lightGray);
        mLiquidName.setOpaque(true);
        mHomePanel.add(mLiquidName);


        mLiquidNameTextField.setBounds(20+UIConfig.CHINESE_CHARACTER_WIDTH*24,
                25, UIConfig.CHINESE_CHARACTER_WIDTH*10,
                UIConfig.CHINESE_CHARACTER_WIDTH+10);
        mLiquidNameTextField.setFont(UIConfig.TEXT_FONT);
        mHomePanel.add(mLiquidNameTextField);

        //第二行第二个组件
        mLiquidRate.setForeground(Color.BLACK);
        mLiquidRate.setBounds(20+UIConfig.CHINESE_CHARACTER_WIDTH*18 ,
                30+UIConfig.CHINESE_CHARACTER_WIDTH*3, UIConfig.CHINESE_CHARACTER_WIDTH*4,
                UIConfig.CHINESE_CHARACTER_WIDTH);
        mLiquidRate.setFont(UIConfig.TEXT_FONT);
        //mClientName.setBackground(Color.lightGray);
        mLiquidRate.setOpaque(true);
        mHomePanel.add(mLiquidRate);

        mLiquidRateTextField.setBounds(20+UIConfig.CHINESE_CHARACTER_WIDTH*24,
                25+UIConfig.CHINESE_CHARACTER_WIDTH*3, UIConfig.CHINESE_CHARACTER_WIDTH*10,
                UIConfig.CHINESE_CHARACTER_WIDTH+10);
        mLiquidRateTextField.setFont(UIConfig.TEXT_FONT);
        mHomePanel.add(mLiquidRateTextField);
        //第三行第二个组件
        mLiquidViscosity.setForeground(Color.BLACK);
        mLiquidViscosity.setBounds(20+UIConfig.CHINESE_CHARACTER_WIDTH*18 ,
                30+UIConfig.CHINESE_CHARACTER_WIDTH*6, UIConfig.CHINESE_CHARACTER_WIDTH*4,
                UIConfig.CHINESE_CHARACTER_WIDTH);
        mLiquidViscosity.setFont(UIConfig.TEXT_FONT);
        //mLiquidViscosity.setBackground(Color.RED);
        mLiquidViscosity.setOpaque(true);
        mHomePanel.add(mLiquidViscosity);


        mLiquidViscosityTextField.setBounds(20+UIConfig.CHINESE_CHARACTER_WIDTH*24,
                25+UIConfig.CHINESE_CHARACTER_WIDTH*6, UIConfig.CHINESE_CHARACTER_WIDTH*10,
                UIConfig.CHINESE_CHARACTER_WIDTH+10);
        mLiquidViscosityTextField.setFont(UIConfig.TEXT_FONT);
        mHomePanel.add(mLiquidViscosityTextField);



        mLiquidViscosityUnit.setForeground(Color.BLACK);
        mLiquidViscosityUnit.setBounds(20+UIConfig.CHINESE_CHARACTER_WIDTH*34+5 ,
                30+UIConfig.CHINESE_CHARACTER_WIDTH*6, UIConfig.CHINESE_CHARACTER_WIDTH*3+5,
                UIConfig.CHINESE_CHARACTER_WIDTH);
        mLiquidViscosityUnit.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        //mLiquidViscosityUnit.setBackground(Color.RED);
        mLiquidViscosityUnit.setOpaque(true);
        mHomePanel.add(mLiquidViscosityUnit);


        //第四行第二个控件
        mLiquidTemperature.setForeground(Color.BLACK);
        mLiquidTemperature.setBounds(20+UIConfig.CHINESE_CHARACTER_WIDTH*18 ,
                30+UIConfig.CHINESE_CHARACTER_WIDTH*9, UIConfig.CHINESE_CHARACTER_WIDTH*4,
                UIConfig.CHINESE_CHARACTER_WIDTH);
        mLiquidTemperature.setFont(UIConfig.TEXT_FONT);
        //mLiquidViscosity.setBackground(Color.RED);
        mLiquidTemperature.setOpaque(true);
        mHomePanel.add(mLiquidTemperature);


        mLiquidTemperatureTextField.setBounds(20+UIConfig.CHINESE_CHARACTER_WIDTH*24,
                25+UIConfig.CHINESE_CHARACTER_WIDTH*9, UIConfig.CHINESE_CHARACTER_WIDTH*10,
                UIConfig.CHINESE_CHARACTER_WIDTH+10);
        mLiquidTemperatureTextField.setFont(UIConfig.TEXT_FONT);
        mHomePanel.add(mLiquidTemperatureTextField);



        mLiquidTemperatureUnit.setForeground(Color.BLACK);
        mLiquidTemperatureUnit.setBounds(20+UIConfig.CHINESE_CHARACTER_WIDTH*34+5 ,
                30+UIConfig.CHINESE_CHARACTER_WIDTH*9, UIConfig.CHINESE_CHARACTER_WIDTH*3+5,
                UIConfig.CHINESE_CHARACTER_WIDTH);
        mLiquidTemperatureUnit.setFont( new Font("微软雅黑", Font.PLAIN, 18));
        //mLiquidViscosityUnit.setBackground(Color.RED);
        mLiquidTemperatureUnit.setOpaque(true);
        mHomePanel.add(mLiquidTemperatureUnit);

        //第六行第二个控件
        mMaxThroughputRate.setForeground(Color.BLACK);
        mMaxThroughputRate.setBounds(20+UIConfig.CHINESE_CHARACTER_WIDTH*18 ,
                30+UIConfig.CHINESE_CHARACTER_WIDTH*15, UIConfig.CHINESE_CHARACTER_WIDTH*5,
                UIConfig.CHINESE_CHARACTER_WIDTH);
        mMaxThroughputRate.setFont(UIConfig.TEXT_FONT);
        //mLiquidViscosity.setBackground(Color.RED);
        mMaxThroughputRate.setOpaque(true);
        mHomePanel.add(mMaxThroughputRate);

        mMaxThroughputRateTextField.setBounds(20+UIConfig.CHINESE_CHARACTER_WIDTH*24,
                25+UIConfig.CHINESE_CHARACTER_WIDTH*15, UIConfig.CHINESE_CHARACTER_WIDTH*10,
                UIConfig.CHINESE_CHARACTER_WIDTH+10);
        mMaxThroughputRateTextField.setFont(UIConfig.TEXT_FONT);
        //mMaxThroughputRateTextField.setEditable(false);
        mHomePanel.add(mMaxThroughputRateTextField);


        mMaxThroughputRateUnitButton.setFocusable(false);
        //mMaxThroughputRateUnitButton.setText("g");
        mMaxThroughputRateUnitButton.setFont( new Font("微软雅黑", Font.PLAIN, 18));
        mMaxThroughputRateUnitButton.setBounds(20+UIConfig.CHINESE_CHARACTER_WIDTH*34+1,
                25+UIConfig.CHINESE_CHARACTER_WIDTH*15,
                57, 27);
        mHomePanel.add(mMaxThroughputRateUnitButton);
        //第七行第二个控件

        mThroughputRatePerTurn.setForeground(Color.BLACK);
        mThroughputRatePerTurn.setBounds(20+UIConfig.CHINESE_CHARACTER_WIDTH*18 ,
                30+UIConfig.CHINESE_CHARACTER_WIDTH*18, UIConfig.CHINESE_CHARACTER_WIDTH*5,
                UIConfig.CHINESE_CHARACTER_WIDTH);
        mThroughputRatePerTurn.setFont(UIConfig.TEXT_FONT);
        //mLiquidViscosity.setBackground(Color.RED);
        mThroughputRatePerTurn.setOpaque(true);
        mHomePanel.add(mThroughputRatePerTurn);


        mThroughputRatePerTurnTextField.setBounds(20+UIConfig.CHINESE_CHARACTER_WIDTH*24,
                25+UIConfig.CHINESE_CHARACTER_WIDTH*18, UIConfig.CHINESE_CHARACTER_WIDTH*10,
                UIConfig.CHINESE_CHARACTER_WIDTH+10);
        mThroughputRatePerTurnTextField.setFont(UIConfig.TEXT_FONT);
        mHomePanel.add(mThroughputRatePerTurnTextField);


        mThroughputRatePerTurnUnit.setForeground(Color.BLACK);
        mThroughputRatePerTurnUnit.setBounds(20+UIConfig.CHINESE_CHARACTER_WIDTH*34+5 ,
                30+UIConfig.CHINESE_CHARACTER_WIDTH*18, UIConfig.CHINESE_CHARACTER_WIDTH*3+5,
                UIConfig.CHINESE_CHARACTER_WIDTH);
        mThroughputRatePerTurnUnit.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        //mLiquidViscosityUnit.setBackground(Color.RED);
        mThroughputRatePerTurnUnit.setOpaque(true);
        mHomePanel.add(mThroughputRatePerTurnUnit);

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
