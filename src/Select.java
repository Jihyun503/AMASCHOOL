import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Select extends JPanel{
	
	ImageIcon mainbg = new ImageIcon("game_bg4.jpg");
	Image main_bg = mainbg.getImage();
	JLabel lab;
	
	Select(Main_frame frame){
		setLayout(null);
        ImageIcon high = new ImageIcon("high.png");
	    JButton high_btn = new JButton(high);
	    high_btn.setBorderPainted(false);
	    high_btn.setContentAreaFilled(false);
	    high_btn.setBounds(850, 320, 100, 60);
		add(high_btn);
		
		high_btn.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.change("game3");
			}
		});
	
		    ImageIcon middle = new ImageIcon("middle.png");
		    JButton middle_btn = new JButton(middle);
		    middle_btn.setBorderPainted(false);
		    middle_btn.setContentAreaFilled(false);
		    middle_btn.setBounds(640, 430, 100, 60);
			add(middle_btn);
			middle_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.change("game2");
				
			}
		});
			ImageIcon low = new ImageIcon("low.png");
		    JButton low_btn = new JButton(low);
		    low_btn.setBorderPainted(false);
		    low_btn.setContentAreaFilled(false);
		    low_btn.setBounds(1080, 490, 100, 60);
			add(low_btn);
		low_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				frame.change("game");
				
			}
		});
		
		ImageIcon im = new ImageIcon("s.png");
		lab = new JLabel(im);
		lab.setBounds(650, 370, 522, 635);
		add(lab);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(main_bg,0,0,getWidth(),getHeight(),this);
		
	}
}