import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;

public class Test extends JPanel{
	
	JLabel story1, story2, story3;
	ImageIcon startbtn = new ImageIcon("next.png");
    JButton start_btn = new JButton(startbtn);
    ImageIcon howtobtn = new ImageIcon("start_btn.png");
    JButton howto_btn = new JButton(howtobtn);
    ImageIcon skipbtn = new ImageIcon("skip.png");
    JButton skip_btn = new JButton(skipbtn);
    int chk = 1;
    ImageIcon mainbg = new ImageIcon("white_bg.jpg");
	Image main_bg = mainbg.getImage();
	    
public Test(Main_frame frame){
		setLayout(null);
		
		start_btn.setBorderPainted(false);
	    start_btn.setContentAreaFilled(false);
	    start_btn.setBounds(1630, 900, 100, 39);
	    add(start_btn);
	    
	    howto_btn.setBorderPainted(false);
	    howto_btn.setContentAreaFilled(false);
	    
	    skip_btn.setBorderPainted(false);
	    skip_btn.setContentAreaFilled(false);
	    skip_btn.setBounds(160, 900, 100, 39);
	    add(skip_btn);
	    
		ImageIcon img1 = new ImageIcon("story1.jpg");
		story1 = new JLabel(img1);
		ImageIcon img2 = new ImageIcon("story3.jpg");
		story2 = new JLabel(img2); 
		ImageIcon img3 = new ImageIcon("story2.jpg");
		story3 = new JLabel(img3); 
		
		
		story1.setBounds(100, 0, 1700, 1000);
		add(story1);
		
	    
	    start_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chk==1) {
					System.out.println("chk 1");
					remove(story1);
					add(story2);
					story2.setBounds(100, 0, 1700,1000);
					
				}
				if(chk==2) {
					System.out.println("chk 2");
					remove(story2);
					remove(start_btn);
					add(howto_btn);
					add(story3);
					story3.setBounds(100, 0, 1700,1000);
				    howto_btn.setBounds(1520, 860, 221, 76);
				}
				chk++;
			}
		});
	    
	    howto_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.change("ingregame");
			}
		});
	    
	    skip_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.change("ingregame");
			}
		});
        
	 }//test

		public void paintComponent(Graphics g) {
			g.drawImage(main_bg,0,0,getWidth(),getHeight(),this);
			
		}
}//class