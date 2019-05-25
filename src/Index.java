import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Index extends JPanel{
	
	ImageIcon mainbg = new ImageIcon("main_bg.jpg");
	Image main_bg = mainbg.getImage();
	
	ImageIcon startbtn = new ImageIcon("start_btn.png");
    ImageIcon howtobtn = new ImageIcon("howto_btn.png");
    JButton start_btn = new JButton(startbtn);
    JButton howto_btn = new JButton(howtobtn);
	
	public Index(Main_frame frame) {
		
	    setLayout(null);
	    
	    start_btn.setBorderPainted(false);
	    start_btn.setContentAreaFilled(false);
	    start_btn.setBounds(550, 750, 221, 76);
	    add(start_btn);
	    
	    
	    howto_btn.setBorderPainted(false);
	    howto_btn.setContentAreaFilled(false);
		howto_btn.setBounds(1200, 750, 221, 76);
		add(howto_btn);
		
		start_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.change("test");
				
			}
		});
		
		howto_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Howto();
				
			}
		});
		
	}
	
	public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(main_bg,0,0,getWidth(),getHeight(),this);
    }

}

class Howto extends JFrame {
    public Howto() {
        setTitle("아마스쿨은 어떻게 하는 건가요?");
        setSize(778, 550);
        setLocation(600, 100);
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JLabel game_way = new JLabel(new ImageIcon("howto.jpg"));
        //setPreferredSize(new Dimension(500, 700));
        add(game_way);
        
        setVisible(true);
    }
}