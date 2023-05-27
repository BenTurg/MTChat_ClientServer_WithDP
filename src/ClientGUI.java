import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI implements StringConsumer, StringProducer {

    private StringConsumer consumer;

    private JFrame frame;
    private JTextField tf;
    private JButton bt;
    private JPanel panelSouth, panelCenter, panelNorth;

    private JButton btConnect, btDisconnect;

    public ClientGUI() {
        frame = new JFrame();
        tf = new JTextField(10);
        bt = new JButton("Send");
        btConnect = new JButton("Connect");
        btDisconnect = new JButton("Disconnect");
        panelSouth = new JPanel();
        panelCenter = new JPanel();
        panelNorth = new JPanel();
    }

    public void start() {
        frame.setLayout(new BorderLayout());
        panelNorth.setBackground(Color.WHITE);
        panelNorth.add(btConnect);
        panelNorth.add(btDisconnect);
        panelSouth.setBackground(Color.WHITE);
        panelCenter.setBackground(Color.PINK);
        panelSouth.setLayout(new FlowLayout());
        panelSouth.add(tf);
        panelSouth.add(bt);
        frame.add(panelNorth,BorderLayout.NORTH);
        frame.add(panelCenter,BorderLayout.CENTER);
        frame.add(panelSouth,BorderLayout.SOUTH);
        frame.setSize(800,500);
        frame.setVisible(true);
        bt.addActionListener(new ButtonsObserver() );
    }



    @Override
    public void consume(String text) throws ChatException {

    }

    @Override
    public void addConsumer(StringConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void removeConsumer(StringConsumer consumer) {
        if(this.consumer!=null) {
            this.consumer = null;
        }
    }

    class ButtonsObserver implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                System.out.println("inside actionPerformed... thread="+Thread.currentThread().getName()+" tf.getText()="+tf.getText());
                consumer.consume(tf.getText());
                System.out.println(tf.getText()+" was sent to the server by calling the consumer.consume() method thread="+Thread.currentThread().getName());
            } catch (ChatException ex) {
                ex.printStackTrace();
                //...
            }
        }
    }

}