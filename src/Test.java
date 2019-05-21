import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;

public class Test extends JPanel{
	    BufferedImage file;
	    File img;
	    ImageIcon icon;

	    JLabel image;
	    JPanel panel;
	    String[] path = {"story1.jpg", "story2.jpg", "story3.jpg"};

	    JButton next = new JButton("NEXT");
	    static int num = 0;
	    
public Test(Main_frame frame){
		setLayout(null); 

        panel = new JPanel();
        next.setBounds(0, 10, 32, 32);
        
        JLabel piclabel = new JLabel();

        frame.getContentPane().add(panel);

        next.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                img = new File(path[num]);
             try{
                 file = ImageIO.read(img);
                 icon = new ImageIcon(file);
                 if(image != null) frame.remove(image);
                 image = new JLabel("", icon, SwingConstants.CENTER);

                 image.setVisible(true);
                 frame.getContentPane().add(image);
                 frame.revalidate();
                 frame.repaint();
            }
          catch (IOException g){
          }
                if (num < path.length - 1) {
                    num++;
                } else {
                    num = 0;}
            }
        });
        panel.add(next);
	 }//test
}//class