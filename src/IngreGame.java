import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class IngreGame extends JPanel{
	
	ImageIcon mainbg = new ImageIcon("game_bg2.jpg");
	Image main_bg = mainbg.getImage();
	
	JLabel ingrePearl1, ingrePearl2, ingrePearl3;
	JLabel ingreJuice1, ingreJuice2, ingreJuice3, ingreJuice4;
	JLabel ingreFruit1, ingreFruit2, ingreFruit3, ingreFruit4;
	JLabel cup;
	JLabel pic1,pic2,pic3;
	
	JLabel mong;
	JLabel pointAdd;
	int point = 0, showPoint = 0;
	String pointS;
	Timer m_timer;
	TimerTask m_task;
	int ck = 0;
	int ck1 = 0, ck2 = 0, ck3 = 0, ck4 = 0, ck5 = 0;
	int x = 700, y = 682;
	int x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0, x6 = 0, x7 = 0, x8 = 0, x9 = 0, x10 = 0, x11 = 0, x12 = 0;
	int y1 = 0, y2 = 0, y3 = 0, y4 = 0, y5 = 0, y6 = 0, y7 = 0, y8 = 0, y9 = 0, y10 = 0, y11 = 0, y12 = 0;
	
	ImageIcon startbtn = new ImageIcon("start_btn.png");
	JButton start_btn = new JButton(startbtn);
	
	IngreGame(Main_frame frame){
		setLayout(null);
		start_btn.setBorderPainted(false);
	    start_btn.setContentAreaFilled(false);
	    start_btn.setBounds(1650, 900, 221, 76);
	    add(start_btn);
	    
	    start_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.change("select");
				
			}
		});
	    
		ImageIcon doraemong = new ImageIcon("people.png");
		mong = new JLabel(doraemong);
		
		ImageIcon ingre1 = new ImageIcon("img/ingrePearl1.png");
		ImageIcon ingre2 = new ImageIcon("img/ingrePearl2.png");
		ImageIcon ingre3 = new ImageIcon("img/ingrePearl3.png");
		ImageIcon ingre4 = new ImageIcon("img/ingreFruit1.png");
		ImageIcon ingre5 = new ImageIcon("img/ingreFruit1.png");
		
		ImageIcon mouse = new ImageIcon("img/ingreJuice1.png");
		
		ingrePearl1 = new JLabel(ingre1);
		ingrePearl2 = new JLabel(ingre2);
		ingrePearl3 = new JLabel(ingre3);
		ingreFruit1 = new JLabel(ingre4);
		ingreFruit2 = new JLabel(ingre5);
		
		
		ingreJuice1 = new JLabel(mouse);
		ingreJuice2 = new JLabel(mouse);
		ingreJuice3 = new JLabel(mouse);
		ingreJuice4 = new JLabel(mouse);
		
		x1 = (int)(Math.random() * 1100);
		x2 = (int)(Math.random() * 1100);
		x3 = (int)(Math.random() * 1100);
		x4 = (int)(Math.random() * 1100);
		x5 = (int)(Math.random() * 1100);
		
		x6 = (int)(Math.random() * 1100);
		x7 = (int)(Math.random() * 1100);
		x8 = (int)(Math.random() * 1100);
		x9 = (int)(Math.random() * 1100);
		x10 = (int)(Math.random() * 1100);
		x11 = (int)(Math.random() * 1100);
		x12 = (int)(Math.random() * 1100);
		
		mong.setLocation(x, y);
		mong.setSize(170, 308);
		
		ingrePearl1.setBounds(x1, 0, 70, 70);
		ingrePearl2.setBounds(x2, 0, 70, 70);
		ingrePearl3.setBounds(x4, 0, 70, 70);
		ingreFruit1.setBounds(x5, 0, 75, 62);
		
		ingreJuice1.setBounds(x7, 0, 75, 42);
		ingreJuice2.setBounds(x10, 0, 75, 42);
		ingreJuice3.setBounds(x11, 0, 75, 42);
		ingreJuice4.setBounds(x12, 0, 75, 42);
		
		add(mong);
		
		add(ingrePearl1);
		add(ingrePearl2);
		add(ingrePearl3);
		add(ingreFruit1);
		
		add(ingreJuice1);
		add(ingreJuice2);
		add(ingreJuice3);
		add(ingreJuice4);
		
		
		

				frame.setFocusable(true);
			    frame.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent e) {
						this.KeyPressed(e);
					}

					private void KeyPressed(KeyEvent e) {
						if(e.getKeyCode() == KeyEvent.VK_LEFT) {
							x -= 10;
							mong.setLocation(x, y);
						}
						if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
							x += 10;
							mong.setLocation(x, y);
						}
						
					}
				});
			    
		
	}
	private boolean hit(int x, int y, int w, int h){
	    
	    if(targetContains(x,y)
	            ||targetContains(x+w-1,y)
	            ||targetContains(x+w-1,y+h-1)
	            ||targetContains(x,y+h-1))
	        return true;
	    else
	        return false;
	}

	private boolean targetContains(int x, int y){
	    if(((mong.getX()<=x)&&(x<mong.getX()+mong.getWidth()))   
	            &&((mong.getY()<=y)&&(y<mong.getY()+mong.getHeight())))
	        return true;
	    
	    else
	        return false;
	}

	public void paintComponent(Graphics g) {
		g.drawImage(main_bg,0,0,getWidth(),getHeight(),this);
		
	}

	public void start() {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				ingrePearl1.setVisible(true);
				ingrePearl2.setVisible(true);
				ingrePearl3.setVisible(true);
				ingreFruit1.setVisible(true);
				
				 do {
					 ck1 = 0;
					 ck2 = 0;
					 ck3 = 0;
					 ck4 = 0;
					 ck5 = 0;
					 x1 = ingrePearl1.getX();
					 y1 = ingrePearl1.getY()+6;
					 x2 = ingrePearl2.getX();
					 y2 = ingrePearl2.getY()+5;
					 x4 = ingrePearl3.getX();
					 y4 = ingrePearl3.getY()+3;
					 x5 = ingreFruit1.getX();
					 y5 = ingreFruit1.getY()+5;
					 
					 x7 = ingreJuice1.getX();
					 y7 = ingreJuice1.getY()+7;
					 x10 = ingreJuice2.getX();
					 y10 = ingreJuice2.getY()+6;
					 x11 = ingreJuice3.getX();
					 y11 = ingreJuice3.getY()+5;
					 x12 = ingreJuice4.getX();
					 y12 = ingreJuice4.getY()+5;
					 
					 ingrePearl1.setLocation(x1, y1);
					 ingrePearl2.setLocation(x2, y2);
					 ingrePearl3.setLocation(x4, y4);
					 ingreFruit1.setLocation(x5, y5);
						 
					 ingreJuice1.setLocation(x7, y7);
					 ingreJuice2.setLocation(x10, y10);
					 ingreJuice3.setLocation(x11, y11);
					 ingreJuice4.setLocation(x12, y12);
						 
						 
					
						 if(y1 > 900) {
							 ingrePearl1.setLocation(x1, 0);
								do{
									x1 = (int)(Math.random() * 1500);
									y1 = ingrePearl1.getY()+((int)((Math.random() * 10)+1));
									

									ingrePearl1.setLocation(x1, y1);
									ingrePearl1.setVisible(true);
									
							}while(!(y1 > 0));
						}
						 
						 else if(y2 > 900) {
							 ingrePearl2.setLocation(x2, 0);
								do{
									x2 = (int)(Math.random() * 1500);
									y2 = ingrePearl2.getY()+((int)((Math.random() * 10)+1));
									ingrePearl2.setLocation(x2, y2);
									ingrePearl2.setVisible(true);
								
							}while(!(y2 > 0));
						}
						 
						 else if(y4 > 900) {
							 ingrePearl3.setLocation(x4, 0);
								do{
									x4 = (int)(Math.random() * 1500);
									y4 = ingrePearl3.getY()+((int)((Math.random() * 10)+1));
									ingrePearl3.setLocation(x4, y4);
									ingrePearl3.setVisible(true);
								
							}while(!(y4 > 0));
						}
						 
						 else if(y5 > 900) {
							 ingreFruit1.setLocation(x5, 0);
								do{
									x5 = (int)(Math.random() * 1500);
									y5 = ingreFruit1.getY()+((int)((Math.random() * 10)+1));
									ingreFruit1.setLocation(x5, y5);
									ingreFruit1.setVisible(true);
								
							}while(!(y5 > 0));
						}
						 
						 else if(y7 > 900) {
							 ingreJuice1.setLocation(x7, 0);
								do{
									x7 = (int)(Math.random() * 1500);
									y7 = ingreJuice1.getY()+((int)((Math.random() * 10)+1));
									ingreJuice1.setLocation(x7, y7);
								
							}while(!(y7 > 0));
						}
						 
						 else if(y10 > 900) {
							 ingreJuice2.setLocation(x10, 0);
								do{
									x10 = (int)(Math.random() * 1500);
									y10 = ingreJuice2.getY()+((int)((Math.random() * 10)+1));
									ingreJuice2.setLocation(x10, y10);
								
							}while(!(y10 > 0));
						}
						 
						 else if(y11 > 900) {
							 ingreJuice3.setLocation(x11, 0);
								do{
									x11 = (int)(Math.random() * 1500);
									y11 = ingreJuice3.getY()+((int)((Math.random() * 10)+1));
									ingreJuice3.setLocation(x11, y11);
									System.out.println(x11+" "+y11);
								
							}while(!(y11 > 0));
						}
						 
						 else if(y12 > 900) {
							 ingreJuice4.setLocation(x12, 0);
								do{
									x12 = (int)(Math.random() * 1500);
									y12 = ingreJuice4.getY()+((int)((Math.random() * 10)+1));
									ingreJuice4.setLocation(x12, y12);
								
							}while(!(y12 > 0));
						}
						 
						 if(hit(ingreJuice1.getX(), ingreJuice1.getY(), ingreJuice1.getWidth(), ingreJuice1.getHeight()))
						 {	
						 	 
							break;
								
						 }
						 else if(hit(ingreJuice2.getX(), ingreJuice2.getY(), ingreJuice2.getWidth(), ingreJuice2.getHeight()))
						 {
							  
								break;
						 }
						 else if(hit(ingreJuice3.getX(), ingreJuice3.getY(), ingreJuice3.getWidth(), ingreJuice3.getHeight()))
						 {
							 
								break;
						 }
						 else if(hit(ingreJuice4.getX(), ingreJuice4.getY(), ingreJuice4.getWidth(), ingreJuice4.getHeight()))
						 {
							 
								break;
						 }
						 else if(hit(ingrePearl1.getX(), ingrePearl1.getY(), ingrePearl3.getWidth(), ingrePearl1.getHeight()))
						 {	 
						 	ingrePearl1.setVisible(false);
							 System.out.println("1");
							 repaint();
							 
						 }
						 else if(hit(ingrePearl2.getX(), ingrePearl2.getY(), ingrePearl2.getWidth(), ingrePearl2.getHeight()))
						 {
							 
							 ingrePearl2.setVisible(false);
							 System.out.println("2");
							 repaint();
						 }
						 else if(hit(ingrePearl3.getX(), ingrePearl3.getY(), ingrePearl3.getWidth(), ingrePearl3.getHeight()))
						 {
							 
							 ingrePearl3.setVisible(false);
							 System.out.println("4");
							 repaint();
						 }
						 else if(hit(ingreFruit1.getX(), ingreFruit1.getY(), ingreFruit1.getWidth(), ingreFruit1.getHeight()))
						 {
							 
							 ingreFruit1.setVisible(false);
							 System.out.println("5");
							 repaint();
						 }
						 
						 
						 try {
							 Thread.sleep(60);
						 }
						 catch (Exception e) {
							 
						}
						 
						 
					 }while(!(y > 1420));
			 }
		 });
				t1.start();
				Time();
				
				
	}

	public void Time() {
		Timer myTimer = new Timer();
		TimerTask myTask = new TimerTask() {

			@Override
			public void run() {
				ck1 = 1;
			}
			
		};
		myTimer.schedule(myTask, 30000);
	}

}
	
