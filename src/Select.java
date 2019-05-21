import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Select extends JPanel{
	 Game game;
	 JButton high_btn = new JButton("»ó");
	 JButton midium_btn = new JButton("Áß");
	 JButton low_btn = new JButton("ÇÏ");
	
	Select(Main_frame frame){
		add(high_btn);
		high_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.change("game3");
			}
		});
		add(midium_btn);
		midium_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.change("game2");
				
			}
		});
		add(low_btn);
		low_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				frame.change("game");
				
			}
		});
	}


}