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
	
	ImageIcon mainbg = new ImageIcon("game_bg4.jpg");
	Image main_bg = mainbg.getImage();

	JLabel ingreJuice1, ingreJuice2, ingreJuice3, ingreJuice4, ingreJuice5;
	JLabel ingreFruit1, ingreFruit2, ingreFruit3, ingreFruit4, ingreFruit5;
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
	
	
	ImageIcon skipbtn = new ImageIcon("skip.png");
	JButton skip_btn = new JButton(skipbtn);
	
	IngreGame(Main_frame frame){
		setLayout(null);
		skip_btn.setBorderPainted(false);
		skip_btn.setContentAreaFilled(false);
		skip_btn.setBounds(1650, 900, 221, 76);
	    add(skip_btn);
	    
	    skip_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.change("select");
				
			}
		});
	    
		ImageIcon doraemong = new ImageIcon("people.png");
		mong = new JLabel(doraemong);
		
		ImageIcon ingre1 = new ImageIcon("img/ingreFruit1.png");
		ImageIcon ingre2 = new ImageIcon("img/ingreFruit2.png");
		ImageIcon ingre3 = new ImageIcon("img/ingreFruit5.png");
		ImageIcon ingre4 = new ImageIcon("img/ingreFruit6.png");
		ImageIcon ingre5 = new ImageIcon("img/ingreFruit7.png");
		
		ImageIcon app = new ImageIcon("img/app.png");
		
		ingreFruit1 = new JLabel(ingre1);
		ingreFruit2 = new JLabel(ingre2);
		ingreFruit3 = new JLabel(ingre3);
		ingreFruit4 = new JLabel(ingre4);
		ingreFruit5 = new JLabel(ingre5);
		
		
		ingreJuice1 = new JLabel(app);
		ingreJuice2 = new JLabel(app);
		ingreJuice3 = new JLabel(app);
		ingreJuice4 = new JLabel(app);
		
		x1 = (int)(Math.random() * 1600);
		x2 = (int)(Math.random() * 1600);
		x3 = (int)(Math.random() * 1600);
		x4 = (int)(Math.random() * 1600);
		x5 = (int)(Math.random() * 1600);
		
		x6 = (int)(Math.random() * 1600);
		x7 = (int)(Math.random() * 1600);
		x8 = (int)(Math.random() * 1600);
		x9 = (int)(Math.random() * 1600);
		x10 = (int)(Math.random() * 1600);
		x11 = (int)(Math.random() * 1600);
		x12 = (int)(Math.random() * 1600);
		
		mong.setLocation(x, y);
		mong.setSize(170, 308);
		
		ingreFruit1.setBounds(x1, 0, 75, 70);
		ingreFruit2.setBounds(x2, 0, 75, 70);
		ingreFruit3.setBounds(x4, 0, 75, 88);
		ingreFruit4.setBounds(x5, 0, 75, 68);
		ingreFruit5.setBounds(x3, 0, 75, 49);
		
		ingreJuice1.setBounds(x7, 0, 54, 70);
		ingreJuice2.setBounds(x10, 0, 54, 70);
		ingreJuice3.setBounds(x11, 0, 54, 70);
		ingreJuice4.setBounds(x12, 0, 54, 70);
		
		add(mong);
		
		add(ingreFruit1);
		add(ingreFruit2);
		add(ingreFruit3);
		add(ingreFruit4);
		add(ingreFruit5);
		
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
				
				
				ingreFruit1.setVisible(true);
				ingreFruit2.setVisible(true);
				ingreFruit3.setVisible(true);
				ingreFruit4.setVisible(true);
				ingreFruit5.setVisible(true);
				
				 do {
					 /*ck1 = 0;
					 ck2 = 0;
					 ck3 = 0;
					 ck4 = 0;
					 ck5 = 0;*/
					 x1 = ingreFruit1.getX();
					 y1 = ingreFruit1.getY()+7;
					 x2 = ingreFruit2.getX();
					 y2 = ingreFruit2.getY()+8;
					 x3 = ingreFruit5.getX();
					 y3 = ingreFruit5.getY()+7;
					 x4 = ingreFruit3.getX();
					 y4 = ingreFruit3.getY()+9;
					 x5 = ingreFruit4.getX();
					 y5 = ingreFruit4.getY()+5;
					 
					 x7 = ingreJuice1.getX();
					 y7 = ingreJuice1.getY()+18;
					 x10 = ingreJuice2.getX();
					 y10 = ingreJuice2.getY()+15;
					 x11 = ingreJuice3.getX();
					 y11 = ingreJuice3.getY()+17;
					 x12 = ingreJuice4.getX();
					 y12 = ingreJuice4.getY()+19;
					 
					 ingreFruit1.setLocation(x1, y1);
					 ingreFruit2.setLocation(x2, y2);
					 ingreFruit3.setLocation(x4, y4);
					 ingreFruit4.setLocation(x5, y5);
					 ingreFruit5.setLocation(x3, y3);
						 
					 ingreJuice1.setLocation(x7, y7);
					 ingreJuice2.setLocation(x10, y10);
					 ingreJuice3.setLocation(x11, y11);
					 ingreJuice4.setLocation(x12, y12);
						 
						 
					
						 if(y1 > 900) {
							 ingreFruit1.setLocation(x1, 0);
								do{
									x1 = (int)(Math.random() * 1600);
									y1 = ingreFruit1.getY()+((int)((Math.random() * 10)+3));
									ingreFruit1.setLocation(x1, y1);
									ingreFruit1.setVisible(true);
									
							}while(!(y1 > 0));
						}
						 
						 else if(y2 > 900) {
							 ingreFruit2.setLocation(x2, 0);
								do{
									x2 = (int)(Math.random() * 1600);
									y2 = ingreFruit2.getY()+((int)((Math.random() * 10)+3));
									ingreFruit2.setLocation(x2, y2);
									ingreFruit2.setVisible(true);
								
							}while(!(y2 > 0));
						}
						 
						 else if(y4 > 900) {
							 ingreFruit3.setLocation(x4, 0);
								do{
									x4 = (int)(Math.random() * 1600);
									y4 = ingreFruit3.getY()+((int)((Math.random() * 10)+3));
									ingreFruit3.setLocation(x4, y4);
									ingreFruit3.setVisible(true);
								
							}while(!(y4 > 0));
						}
						 
						 else if(y5 > 900) {
							 ingreFruit4.setLocation(x5, 0);
								do{
									x5 = (int)(Math.random() * 1600);
									y5 = ingreFruit4.getY()+((int)((Math.random() * 10)+3));
									ingreFruit4.setLocation(x5, y5);
									ingreFruit4.setVisible(true);
								
							}while(!(y5 > 0));
						}
						 
						 else if(y3 > 900) {
							 ingreFruit5.setLocation(x3, 0);
								do{
									x3 = (int)(Math.random() * 1600);
									y3 = ingreFruit5.getY()+((int)((Math.random() * 10)+3));
									ingreFruit5.setLocation(x3, y3);
									ingreFruit5.setVisible(true);
								
							}while(!(y5 > 0));
						}
						 
						 else if(y7 > 900) {
							 ingreJuice1.setLocation(x7, 0);
								do{
									x7 = (int)(Math.random() * 1600);
									y7 = ingreJuice1.getY()+((int)((Math.random() * 20)+7));
									ingreJuice1.setLocation(x7, y7);
								
							}while(!(y7 > 0));
						}
						 
						 else if(y10 > 900) {
							 ingreJuice2.setLocation(x10, 0);
								do{
									x10 = (int)(Math.random() * 1600);
									y10 = ingreJuice2.getY()+((int)((Math.random() * 20)+7));
									ingreJuice2.setLocation(x10, y10);
								
							}while(!(y10 > 0));
						}
						 
						 else if(y11 > 900) {
							 ingreJuice3.setLocation(x11, 0);
								do{
									x11 = (int)(Math.random() * 1600);
									y11 = ingreJuice3.getY()+((int)((Math.random() * 20)+7));
									ingreJuice3.setLocation(x11, y11);
									System.out.println(x11+" "+y11);
								
							}while(!(y11 > 0));
						}
						 
						 else if(y12 > 900) {
							 ingreJuice4.setLocation(x12, 0);
								do{
									x12 = (int)(Math.random() * 1600);
									y12 = ingreJuice4.getY()+((int)((Math.random() * 20)+7));
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
						 else if(hit(ingreFruit1.getX(), ingreFruit1.getY(), ingreFruit1.getWidth(), ingreFruit1.getHeight()))
						 {	 
							 ingreFruit1.setVisible(false);
							 ck1++;
							 System.out.println("ck1:"+ck1);
							 repaint();
							 
						 }
						 else if(hit(ingreFruit2.getX(), ingreFruit2.getY(), ingreFruit2.getWidth(), ingreFruit2.getHeight()))
						 {
							 ingreFruit2.setVisible(false);
							 ck2++;
							 System.out.println("ck2:"+ck2);
							 repaint();
						 }
						 else if(hit(ingreFruit3.getX(), ingreFruit3.getY(), ingreFruit3.getWidth(), ingreFruit3.getHeight()))
						 {
							 
							 ingreFruit3.setVisible(false);
							 ck3++;
							 System.out.println("ck3:"+ck3);
							 repaint();
						 }
						 else if(hit(ingreFruit4.getX(), ingreFruit4.getY(), ingreFruit4.getWidth(), ingreFruit4.getHeight()))
						 {
							 
							 ingreFruit4.setVisible(false);
							 ck4++;
							 System.out.println("ck4:"+ck4);
							 repaint();
						 }

						 else if(hit(ingreFruit5.getX(), ingreFruit5.getY(), ingreFruit5.getWidth(), ingreFruit5.getHeight()))
						 {
							 
							 ingreFruit5.setVisible(false);
							 ck5++;
							 System.out.println("ck5:"+ck5);
							 repaint();
						 }
						 
						 
						 try {
							 Thread.sleep(60);
						 }
						 catch (Exception e) {
							 
						}
						 
					if(ck1>1&&ck2>1&&ck3>1&&ck4>1&&ck5>1) {
						break;
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
	
