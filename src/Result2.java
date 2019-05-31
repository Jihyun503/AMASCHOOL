import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Result2 extends JPanel{
	
	ImageIcon goodbg = new ImageIcon("x.png");
    Image good_bg = goodbg.getImage();
    
    ImageIcon replay = new ImageIcon("replay.png");
    JButton replay_btn = new JButton(replay);

    ImageIcon exit = new ImageIcon("exit.png");
    JButton exit_btn = new JButton(exit);
	
	Result2(Main_frame frame){
		setLayout(null);
		replay_btn.setBorderPainted(false);
	    replay_btn.setContentAreaFilled(false);
	    replay_btn.setBounds(1100, 700, 169, 63);
		add(replay_btn);
		
		replay_btn.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.change("select");
			}
		});

	    exit_btn.setBorderPainted(false);
	    exit_btn.setContentAreaFilled(false);
	    exit_btn.setBounds(1300, 720, 107, 40);
		add(exit_btn);
		
		exit_btn.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.change("index");
			}
		});
		
	}
	public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(good_bg,0,0,getWidth(),getHeight(),this);
    }

}
