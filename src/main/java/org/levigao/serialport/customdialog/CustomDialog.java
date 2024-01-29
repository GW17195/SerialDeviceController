package org.levigao.serialport.customdialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author tianjh
 * @date 2021/3/8
 * 当点击JFrame窗口的关闭按钮时，触发窗口监听事件
 * 弹框询问是否真的需要关闭程序
 */
 class MyCustomDialog extends JFrame {
    JPanel jPanel;
    static final String TITLE = "提示";
    static final String CONTENT = "确定要关闭JFrame窗口吗？";

    public MyCustomDialog() {
        jPanel = new JPanel();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new CustomDialog(TITLE, CONTENT).setVisible(true);
            }
        });
        JButton jButton = new JButton("点我或关闭按钮看看效果");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomDialog(TITLE, CONTENT).setVisible(true);
            }
        });
        jPanel.add(jButton,BorderLayout.CENTER);
        add(jPanel);
        setTitle("JFrame窗口");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyCustomDialog();
    }

}

/**
 * 自定义Dialog对话框
 */
class CustomDialog extends JDialog implements ActionListener {
    String title;
    String content;
    String ok = "确定";
    String cancel = "取消";

    public CustomDialog(String title, String content) {
        this.title = title;
        this.content = content;
        int width = 45, height = 45;
        // 创建1个图标实例,注意image目录要与src同级
        ImageIcon icon = new ImageIcon("image//tu.png");
        icon.setImage(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        // 1个图片标签,显示图片
        JLabel jlImg = new JLabel(icon);
        jlImg.setSize(width, height);
        jlImg.setBounds(20, 44, width, height);
        // 1个文字标签,显示文本
        JLabel jLabel = new JLabel(content);
        jLabel.setFont(new Font("", Font.PLAIN, 14));
        // 设置文字的颜色为蓝色
        jLabel.setForeground(Color.black);
        jLabel.setBounds(75, 43, 180, 45);
        JButton okBut = new JButton(ok);
        JButton cancelBut = new JButton(cancel);
        //okBut.setBackground(Color.LIGHT_GRAY);
        okBut.setBorderPainted(true);
        okBut.setFocusable(false);
        okBut.setBounds(30, 126, 98, 31);

        cancelBut.setBounds(175, 126, 98, 31);
        //cancelBut.setBackground(Color.LIGHT_GRAY);
        cancelBut.setBorderPainted(false);
        cancelBut.setFocusable(false);
        // 给按钮添加响应事件
        okBut.addActionListener(this);
        cancelBut.addActionListener(this);
        // 向对话框中加入各组件
        add(jlImg);
        add(jLabel);
        add(okBut);
        add(cancelBut);
        // 对话框流式布局
        setLayout(null);
        // 窗口左上角的小图标
        setIconImage(icon.getImage());
        // 设置标题
        setTitle(title);
        // 设置为模态窗口,此时不能操作父窗口
        setModal(true);
        // 设置对话框大小
        setSize(300, 210);
        // 对话框局域屏幕中央
        setLocationRelativeTo(null);
        // 对话框不可缩放
        setResizable(false);
        // 点击对话框关闭按钮时,销毁对话框
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * 当按钮被点击时会执行下面的方法
     *
     * @param e 事件
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // 判断是不是确定按钮被点击
        if (ok.equals(e.getActionCommand())) {
            // 对话框不可见
            this.setVisible(false);
            System.out.println("我退出程序了...");
            System.exit(0);
        }
        if (cancel.equals(e.getActionCommand())) {
            this.setVisible(false);
            this.dispose();
            System.out.println("我啥也没干...");
        }
    }
}