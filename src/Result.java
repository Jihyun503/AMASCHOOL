import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Result extends JPanel{
	
	ImageIcon goodbg = new ImageIcon("good.jpg");
    Image good_bg = goodbg.getImage();
	
	Result(Main_frame frame){
		
	}
	public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(good_bg,0,0,getWidth(),getHeight(),this);
    }

}
