package org.levigao.serialport.ui;

import org.levigao.serialport.manager.SerialPortManager;
import org.levigao.serialport.utils.ByteUtils;
import org.levigao.serialport.utils.ShowUtils;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * 主界面
 * 
 * @author yangle
 */
@SuppressWarnings("all")
public class MainFrame extends JFrame {

	// 程序界面宽度
	public final int WIDTH = 530;
	// 程序界面高度
	public final int HEIGHT = 390;

	// 数据显示区
	private JTextArea mDataView = new JTextArea();

	//数据显示区可以翻滚
	private JScrollPane mScrollDataView = new JScrollPane(mDataView);

	// 串口设置面板
	private JPanel mSerialPortPanel = new JPanel();

	//串口下拉框左边显示串口文本
	private JLabel mSerialPortLabel = new JLabel("串口");

	//波特率下拉框左边显示波特率文本
	private JLabel mBaudrateLabel = new JLabel("波特率");

	//串口选择下拉框
	private JComboBox mCommChoice = new JComboBox();

	//波特率选择下拉框
	private JComboBox mBaudrateChoice = new JComboBox();

	//按键组，ASCIIChoice和HexChoice 按钮放入
	private ButtonGroup mDataChoice = new ButtonGroup();
	private JRadioButton mDataASCIIChoice = new JRadioButton("ASCII", true);
	private JRadioButton mDataHexChoice = new JRadioButton("Hex");

	// 操作面板
	private JPanel mOperatePanel = new JPanel();

	//todo 操作面板中显示的数据待发送，后期记得线程安全考虑
	private JTextArea mDataInput = new JTextArea();

	//打开和关闭串口按钮上面的字可以改变
	private JButton mSerialPortOperate = new JButton("打开串口");

	//发送数据按钮
	private JButton mSendData = new JButton("发送数据");

	// 串口列表
	private List<String> mCommList = null;

	// 串口对象
	private SerialPort mSerialport;

	public MainFrame() {
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
		setBounds(p.x - WIDTH / 2, p.y - HEIGHT / 2, WIDTH, HEIGHT);
		this.setLayout(null);

		setTitle("串口通信");
	}

	/**
	 * 初始化控件
	 */
	private void initComponents() {
		// 数据显示
		mDataView.setFocusable(false);
		mScrollDataView.setBounds(10, 10, 505, 200);
		add(mScrollDataView);

		// 串口设置
		mSerialPortPanel.setBorder(BorderFactory.createTitledBorder("串口设置"));
		mSerialPortPanel.setBounds(10, 220, 170, 130);
		mSerialPortPanel.setLayout(null);
		add(mSerialPortPanel);

		mSerialPortLabel.setForeground(Color.gray);
		mSerialPortLabel.setBounds(10, 25, 40, 20);
		mSerialPortPanel.add(mSerialPortLabel);

		mCommChoice.setFocusable(false);
		mCommChoice.setBounds(60, 25, 100, 20);
		mSerialPortPanel.add(mCommChoice);

		mBaudrateLabel.setForeground(Color.gray);
		mBaudrateLabel.setBounds(10, 60, 40, 20);
		mSerialPortPanel.add(mBaudrateLabel);

		mBaudrateChoice.setFocusable(false);
		mBaudrateChoice.setBounds(60, 60, 100, 20);
		mSerialPortPanel.add(mBaudrateChoice);

		mDataASCIIChoice.setBounds(20, 95, 55, 20);
		mDataHexChoice.setBounds(95, 95, 55, 20);
		mDataChoice.add(mDataASCIIChoice);
		mDataChoice.add(mDataHexChoice);
		mSerialPortPanel.add(mDataASCIIChoice);
		mSerialPortPanel.add(mDataHexChoice);

		// 操作
		mOperatePanel.setBorder(BorderFactory.createTitledBorder("操作"));
		mOperatePanel.setBounds(200, 220, 315, 130);
		mOperatePanel.setLayout(null);
		add(mOperatePanel);

		mDataInput.setBounds(25, 25, 265, 50);
		mDataInput.setLineWrap(true);
		mDataInput.setWrapStyleWord(true);
		mOperatePanel.add(mDataInput);

		mSerialPortOperate.setFocusable(false);
		mSerialPortOperate.setBounds(45, 95, 90, 20);
		mOperatePanel.add(mSerialPortOperate);

		mSendData.setFocusable(false);
		mSendData.setBounds(180, 95, 90, 20);
		mOperatePanel.add(mSendData);
	}

	/**
	 * 初始化数据
	 */
	private void initData() {
		mCommList = SerialPortManager.findPorts();
		// 检查是否有可用串口，有则加入选项中
		if (mCommList == null || mCommList.size() < 1) {
			ShowUtils.warningMessage("没有搜索到有效串口！");
		} else {
			for (String s : mCommList) {
				mCommChoice.addItem(s);
			}
		}

		mBaudrateChoice.addItem("9600");
		mBaudrateChoice.addItem("19200");
		mBaudrateChoice.addItem("38400");
		mBaudrateChoice.addItem("57600");
		mBaudrateChoice.addItem("115200");
	}

	/**
	 * 按钮监听事件
	 */
	private void actionListener() {
		// 串口
		mCommChoice.addPopupMenuListener(new PopupMenuListener() {

			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				mCommList = SerialPortManager.findPorts();
				// 检查是否有可用串口，有则加入选项中
				if (mCommList == null || mCommList.size() < 1) {
					ShowUtils.warningMessage("没有搜索到有效串口！");
				} else {
					int index = mCommChoice.getSelectedIndex();
					mCommChoice.removeAllItems();
					for (String s : mCommList) {
						mCommChoice.addItem(s);
					}
					mCommChoice.setSelectedIndex(index);
				}
			}

			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				// NO OP
			}

			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
				// NO OP
			}
		});

		// 打开|关闭串口
		mSerialPortOperate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ("打开串口".equals(mSerialPortOperate.getText()) && mSerialport == null) {
					openSerialPort(e);
				} else {
					closeSerialPort(e);
				}
			}
		});

		// 发送数据
		mSendData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sendData(e);
			}
		});
	}

	/**
	 * 打开串口
	 * 
	 * @param evt
	 *            点击事件
	 */
	private void openSerialPort(ActionEvent evt) {
		// 获取串口名称
		String commName = (String) mCommChoice.getSelectedItem();
		// 获取波特率，默认为9600
		int baudrate = 9600;
		String bps = (String) mBaudrateChoice.getSelectedItem();
		baudrate = Integer.parseInt(bps);

		// 检查串口名称是否获取正确
		if (commName == null || commName.equals("")) {
			ShowUtils.warningMessage("没有搜索到有效串口！");
		} else {
			try {
				mSerialport = SerialPortManager.openPort(commName, baudrate);
				if (mSerialport != null) {
					mDataView.setText("串口已打开" + "\r\n");
					mSerialPortOperate.setText("关闭串口");
				}
			} catch (PortInUseException e) {
				ShowUtils.warningMessage("串口已被占用！");
			}
		}

		// 添加串口监听
		SerialPortManager.addListener(mSerialport, new SerialPortManager.DataAvailableListener() {

			@Override
			public void dataAvailable() {
				byte[] data = null;
				try {
					if (mSerialport == null) {
						ShowUtils.errorMessage("串口对象为空，监听失败！");
					} else {
						// 读取串口数据
						data = SerialPortManager.readFromPort(mSerialport);

						// 以字符串的形式接收数据
						if (mDataASCIIChoice.isSelected()) {
							mDataView.append(new String(data) + "\r\n");
						}

						// 以十六进制的形式接收数据
						if (mDataHexChoice.isSelected()) {
							mDataView.append(ByteUtils.byteArrayToHexString(data) + "\r\n");
						}
					}
				} catch (Exception e) {
					ShowUtils.errorMessage(e.toString());
					// 发生读取错误时显示错误信息后退出系统
					System.exit(0);
				}
			}
		});
	}

	/**
	 * 关闭串口
	 * 
	 * @param evt
	 *            点击事件
	 */
	private void closeSerialPort(ActionEvent evt) {
		SerialPortManager.closePort(mSerialport);
		mDataView.setText("串口已关闭" + "\r\n");
		mSerialPortOperate.setText("打开串口");
		mSerialport = null;
	}

	/**
	 * 发送数据
	 * 
	 * @param evt
	 *            点击事件
	 */
	private void sendData(ActionEvent evt) {
		// 待发送数据
		String data = mDataInput.getText().toString();

		if (mSerialport == null) {
			ShowUtils.warningMessage("请先打开串口！");
			return;
		}

		if ("".equals(data) || data == null) {
			ShowUtils.warningMessage("请输入要发送的数据！");
			return;
		}

		// 以字符串的形式发送数据
		if (mDataASCIIChoice.isSelected()) {
			SerialPortManager.sendToPort(mSerialport, data.getBytes());
		}

		// 以十六进制的形式发送数据
		if (mDataHexChoice.isSelected()) {
			SerialPortManager.sendToPort(mSerialport, ByteUtils.hexStr2Byte(data));
		}
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}
}