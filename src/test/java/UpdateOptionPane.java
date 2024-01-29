
import javax.swing.JButton;
        import javax.swing.JFrame;
        import javax.swing.JOptionPane;
        import javax.swing.JScrollPane;
        import javax.swing.JTextArea;
        import javax.swing.Timer;
        import java.awt.BorderLayout;
        import java.awt.EventQueue;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class UpdateOptionPane {

    private static void showUI(){
        final JFrame testFrame = new JFrame( "TestFrame" );

        final JTextArea textArea = new JTextArea(  );
        testFrame.add( new JScrollPane( textArea ), BorderLayout.CENTER );

        Timer timer = new Timer( 1000, new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                textArea.append( "bla" );
            }
        } );
        timer.setRepeats( true );
        timer.start();
        JButton button = new JButton( "Click me" );
        button.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.out.println("Before option pane");

                int userOption =  JOptionPane.showConfirmDialog(null,"这是确认对话框吗？","提示",JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);	//确认对话框
//如果用户选择的是OK

                if (userOption == JOptionPane.OK_OPTION) {
                    System.err.println("是");
                }else {
                    System.out.println("否");
                }
                System.out.println("After option pane");
            }
        } );
        testFrame.add( button, BorderLayout.SOUTH );
        testFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        testFrame.pack();
        testFrame.setVisible( true );
    }

    public static void main( String[] args ) throws InterruptedException {
        EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {
                showUI();
            }
        } );
    }
}