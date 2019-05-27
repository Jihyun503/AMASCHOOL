import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.*;
import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.TransferHandler;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class Game extends JPanel implements ActionListener{
	public void Play(String fileName)
    {
        try
        {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
            Clip clip = AudioSystem.getClip();
            clip.stop();
            clip.open(ais);
            clip.start();
        }
        catch (Exception ex)
        {
        }
    }
	
	ImageIcon mainbg = new ImageIcon("game_bg2.jpg");
	Image main_bg = mainbg.getImage();

	JLabel ingrePearl1, ingrePearl2, ingrePearl3;
	JLabel ingreJuice1, ingreJuice2, ingreJuice3, ingreJuice4;
	JLabel ingreFruit1, ingreFruit2, ingreFruit3, ingreFruit4;
	JLabel cup;
	ImageIcon ingrePearls1,ingrePearls2,ingrePearls3,ingreFruits1,ingreFruits2,ingreFruits3,ingreFruits4,ingreJuices1,ingreJuices3,ingreJuices4;
	JLabel pic1,pic2,pic3;
	int a,b,c,d; //과일
	int a1,b1,c1,d1;//음료
	int a2,b2,c2;//펄
	int su,oh,fa,chk; //chk은 슬라이더 값 받아오는 용도
	int ice;
	//private JSlider slider1 ;
	JLabel recipe1;
	JLabel hint_recipe; 
	int chk1, chk2, chk3, chkresult = 0;
	
    ImageIcon okbtn1 = new ImageIcon("ok.png");
    JButton ok_btn1 = new JButton(okbtn1);
    Point mouseClickedLocation = new Point(0, 0);

    String[] Labels ={"녹차쉐이크","블루베리에이드","딸기요거트"};

	String[] menu = new String[7];
	
	JLabel text = new JLabel();
	Random r = new Random();

	ImageIcon replay = new ImageIcon("replay.png");
    JButton replay_btn = new JButton(replay);
    
	ImageIcon middle = new ImageIcon("good.png");
	JLabel two = new JLabel(middle); 
	
	ImageIcon exit = new ImageIcon("exit.png");
    JButton exit_btn = new JButton(exit);
	
    ImageIcon middle2 = new ImageIcon("x.png");
	JLabel two2 = new JLabel(middle2); 

	Timer mTimer = new Timer(1000, this);//1초씩 증가
	int mTime = 60;//초 카운트
	
	JButton X_btn2;
	int check=0;
	
	Timer hTimer = new Timer(1000, this);//1초씩 증가
	int hTime = 10;//초 카운트
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(mTimer == arg0.getSource()){
			mTime--;//30초부터 감소
			if(mTime <= 0){ //mTime이 0이 되면 타이머를 멈추고 알림창 띄워주기
				mTimer.stop();
				 int num = 0;
				 if(num==0) {
					 ImageIcon middle = new ImageIcon("x.png");
						JLabel two = new JLabel(middle); 
						two.setBounds(270, 100, 1366,768);
						add(two);
				 }
			}
			repaint();//컨트롤 변화
		}//if
		
		if(hTimer == arg0.getSource()){
			hTime--;
			if(hTime <= 0){ 
				hTimer.stop();
				remove(hint_recipe);
				remove(X_btn2);
				hTime = 10;
			}
			repaint();//컨트롤 변화
		}//if
	}//actionPerformed

	@Override
	public void paint(Graphics g) {//글씨
		super.paint(g);
		
		String msg = "time: " + mTime;
		g.setFont(new Font("Serif", Font.BOLD, 30));//글씨
		g.drawString(msg, 0, 30);
	}//paint
	
	
	
	public Game(Main_frame frame) {
		setLayout(null);
		MouseListener m1 = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
//				JComponent jc=(JComponent)e.getSource();
//				TransferHandler th = jc.getTransferHandler();
//				
//				th.exportAsDrag(jc, e, TransferHandler.COPY);
//		
				   mouseClickedLocation.x = e.getX();
			       mouseClickedLocation.y = e.getY();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
	
			
		};
		MouseListener m2 = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				JComponent jc=(JComponent)e.getSource();
				TransferHandler th = jc.getTransferHandler();
				
				th.exportAsDrag(jc, e, TransferHandler.COPY);
		
		
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
	
			
		};
		ImageIcon Xbtn1 = new ImageIcon("error.png");
	    JButton X_btn1 = new JButton(Xbtn1);
	    X_btn1.setBorderPainted(false);
	    X_btn1.setContentAreaFilled(false);
	    X_btn1.setBounds(1290, 330, 32, 32);
	    add(X_btn1);
	    
	    ImageIcon recipe = new ImageIcon("recipe.png");
		recipe1 = new JLabel(recipe); 
		recipe1.setBounds(100, 0, 1700,1000);
		add(recipe1);
	    
	    X_btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(recipe1);
				remove(X_btn1);
				mTimer.start();
			}
		});
		//ImageIcon recipe = new ImageIcon("recipe.png");
		//JLabel recipe1 = new JLabel(recipe); 
		//recipe1.setBounds(350, 200, 1366,768);
		//add(recipe1);
	    
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
		
		replay_btn.setVisible(false);
		exit_btn.setVisible(false);
	    
	    
	    two.setBounds(270, 100, 1000,579);
		add(two);
		two.setVisible(false);
		
		two2.setBounds(270, 100, 1366,768);
		add(two2);
		two2.setVisible(false);
		
		ImageIcon hint = new ImageIcon("hint.png");
	    JButton Hint = new JButton(hint);
	    Hint.setBorderPainted(false);
	    Hint.setContentAreaFilled(false);
	    Hint.setBounds(70, -55, 150, 150);
	    add(Hint);

	    ImageIcon h_recipe = new ImageIcon("recipe.png");
		hint_recipe = new JLabel(h_recipe); 
		hint_recipe.setBounds(70, 0, 1366,768);
		
		ImageIcon Xbtn2 = new ImageIcon("error.png");
		X_btn2 = new JButton(Xbtn2);
	    X_btn2.setBorderPainted(false);
	    X_btn2.setContentAreaFilled(false);
	    X_btn2.setBounds(1100, 210, 32, 32);
	
	    Hint.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				add(X_btn2);
				add(hint_recipe);
				hTimer.start();
				
				check++;
				
				if(check==3) {
					Hint.setEnabled(false);
				}
				
				  X_btn2.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							remove(hint_recipe);
							remove(X_btn2);
							
						}
					});
			}
		});

		ingrePearls1 = new ImageIcon("ingrePearl1.png");
		ingrePearl1 = new JLabel(ingrePearls1);
		ingrePearl1.setBounds(70, 760, 140, 140);
		add(ingrePearl1);
		ingrePearl1.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				   int x = e.getX();
//				   int y = e.getY();
				  ingrePearl1.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x, e.getLocationOnScreen().y - mouseClickedLocation.y); // 위치 조정
				  if(e.getLocationOnScreen().x - mouseClickedLocation.x<850 && e.getLocationOnScreen().x - mouseClickedLocation.x>400&& e.getLocationOnScreen().y - mouseClickedLocation.y>100&& e.getLocationOnScreen().y - mouseClickedLocation.y<450) {
					  Play("Coin.wav"); 
					  ImageIcon manyta=new ImageIcon("manyta.png");
				
					  ingrePearl1.setIcon(manyta);
						a2=1;
				
					}
				  else {
					  ingrePearl1.setIcon(ingrePearls1);
				  }
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ingrePearls2 = new ImageIcon("ingrePearl2.png");
		ingrePearl2 = new JLabel(ingrePearls2);
		ingrePearl2.setBounds(260, 760, 140, 140);
		add(ingrePearl2);
		ingrePearl2.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				   int x = e.getX();
//				   int y = e.getY();
				  ingrePearl2.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x, e.getLocationOnScreen().y - mouseClickedLocation.y); // 위치 조정
				  if(e.getLocationOnScreen().x - mouseClickedLocation.x<850 && e.getLocationOnScreen().x - mouseClickedLocation.x>420&& e.getLocationOnScreen().y - mouseClickedLocation.y>100&& e.getLocationOnScreen().y - mouseClickedLocation.y<450) {
					  Play("Coin.wav"); 
					  ImageIcon manyco=new ImageIcon("manycoco.png");
					  ingrePearl2.setIcon(manyco);
						b2=1;
				
					}
				  else {
					  ingrePearl2.setIcon(ingrePearls2);
				  }
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ingrePearls3 = new ImageIcon("ingrePearl3.png");
		ingrePearl3 = new JLabel(ingrePearls3);
		ingrePearl3.setBounds(440, 760, 140, 140);
		add(ingrePearl3);
		ingrePearl3.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				   int x = e.getX();
//				   int y = e.getY();
			
				  ingrePearl3.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x, e.getLocationOnScreen().y - mouseClickedLocation.y); // 위치 조정
				  if(e.getLocationOnScreen().x - mouseClickedLocation.x<850 && e.getLocationOnScreen().x - mouseClickedLocation.x>420&& e.getLocationOnScreen().y - mouseClickedLocation.y>100&& e.getLocationOnScreen().y - mouseClickedLocation.y<450) {
					  Play("Coin.wav"); 
					  ImageIcon manyjelly=new ImageIcon("manyjelly.png");
					  ingrePearl3.setIcon(manyjelly);
						c2=1;
				
					}
				  else {
					  ingrePearl3.setIcon(ingrePearls3);
				  }
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ingreFruits1 = new ImageIcon("ingreFruit1.png");
		ingreFruit1 = new JLabel(ingreFruits1);
		ingreFruit1.setBounds(680, 710, 150, 135);
		add(ingreFruit1);
		ingreFruit1.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				   int x = e.getX();
//				   int y = e.getY();
				ingreFruit1.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x, e.getLocationOnScreen().y - mouseClickedLocation.y); // 위치 조정
			
			if(e.getLocationOnScreen().x - mouseClickedLocation.x<850 && e.getLocationOnScreen().x - mouseClickedLocation.x>420&& e.getLocationOnScreen().y - mouseClickedLocation.y>100&& e.getLocationOnScreen().y - mouseClickedLocation.y<450) {
				Play("Coin.wav"); 
				 ImageIcon manystraw=new ImageIcon("manystraw.png");
				 ingreFruit1.setIcon(manystraw);
				a=1;
				System.out.println("a:"+a);
			}
			else {
				ingreFruit1.setIcon(ingreFruits1);
			  }
				 
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ingreFruits2 = new ImageIcon("ingreFruit2.png");
		ingreFruit2 = new JLabel(ingreFruits2);
		ingreFruit2.setBounds(890, 720, 150, 112);
		add(ingreFruit2);
		ingreFruit2.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				   int x = e.getX();
//				   int y = e.getY();
				ingreFruit2.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x, e.getLocationOnScreen().y - mouseClickedLocation.y); // 위치 조정
				if(e.getLocationOnScreen().x - mouseClickedLocation.x<850 && e.getLocationOnScreen().x - mouseClickedLocation.x>420&& e.getLocationOnScreen().y - mouseClickedLocation.y>100&& e.getLocationOnScreen().y - mouseClickedLocation.y<450) {
//					ImageIcon cup = new ImageIcon("st.png");
//					JLabel cup1 = new JLabel(cup);
//					cup1.setBounds(480,100,800,800);
//					add(cup1);
					Play("Coin.wav"); 
					 ImageIcon manyblue=new ImageIcon("manyblue.png");
					 ingreFruit2.setIcon(manyblue);
					b=1;
					System.out.println("b:"+b);
				}
				else {
					ingreFruit2.setIcon(ingreFruits2);
				  }
		
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ingreFruits3 = new ImageIcon("ingreFruit3.png");
		ingreFruit3 = new JLabel(ingreFruits3);
		ingreFruit3.setBounds(680, 880, 150, 97);
		add(ingreFruit3);
		ingreFruit3.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				   int x = e.getX();
//				   int y = e.getY();
				ingreFruit3.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x, e.getLocationOnScreen().y - mouseClickedLocation.y); // 위치 조정
				if(e.getLocationOnScreen().x - mouseClickedLocation.x<850 && e.getLocationOnScreen().x - mouseClickedLocation.x>420&& e.getLocationOnScreen().y - mouseClickedLocation.y>100&& e.getLocationOnScreen().y - mouseClickedLocation.y<450) {
//					ImageIcon cup = new ImageIcon("st.png");
//					JLabel cup1 = new JLabel(cup);
//					cup1.setBounds(480,100,800,800);
//					add(cup1);
					Play("Coin.wav"); 
					 ImageIcon manyoreo=new ImageIcon("manyoreo.png");
					 ingreFruit3.setIcon(manyoreo);
					c=1;
					System.out.println("c:"+c);
				}
				else {
					ingreFruit3.setIcon(ingreFruits3);
				  }
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		ingreFruits4 = new ImageIcon("ingreFruit4.png");
		ingreFruit4 = new JLabel(ingreFruits4);
		ingreFruit4.setBounds(890, 850, 150, 140);
		add(ingreFruit4);
		ingreFruit4.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				   int x = e.getX();
//				   int y = e.getY();
				ingreFruit4.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x, e.getLocationOnScreen().y - mouseClickedLocation.y); // 위치 조정
				if(e.getLocationOnScreen().x - mouseClickedLocation.x<850 && e.getLocationOnScreen().x - mouseClickedLocation.x>420&& e.getLocationOnScreen().y - mouseClickedLocation.y>100&& e.getLocationOnScreen().y - mouseClickedLocation.y<450) {
//					ImageIcon cup = new ImageIcon("st.png");
//					JLabel cup1 = new JLabel(cup);
//					cup1.setBounds(480,100,800,800);
//					add(cup1);
					Play("Coin.wav"); 
					 ImageIcon manygreen=new ImageIcon("manygreen.png");
					 ingreFruit4.setIcon(manygreen);
					d=1;
					System.out.println("d:"+d);
				}
				else {
					ingreFruit4.setIcon(ingreFruits4);
				  }
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ingreJuices1 = new ImageIcon("ingreJuice1.png");
		ingreJuice1 = new JLabel(ingreJuices1);
		ingreJuice1.setBounds(1140, 795, 150, 84);
		add(ingreJuice1);
		
		
		ImageIcon ingreJuices2 = new ImageIcon("ingreJuice2.png");
		ingreJuice2 = new JLabel(ingreJuices2);
		ingreJuice2.setBounds(1340, 750, 100, 193);
		add(ingreJuice2);
		ingreJuice2.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				   int x = e.getX();
//				   int y = e.getY();
				ingreJuice2.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x, e.getLocationOnScreen().y - mouseClickedLocation.y); // 위치 조정
				if(e.getLocationOnScreen().x - mouseClickedLocation.x<850 && e.getLocationOnScreen().x - mouseClickedLocation.x>370&& e.getLocationOnScreen().y - mouseClickedLocation.y>40&& e.getLocationOnScreen().y - mouseClickedLocation.y<450) {
//					ImageIcon cup = new ImageIcon("st.png");
//					JLabel cup1 = new JLabel(cup);
//					cup1.setBounds(480,100,800,800);
//					add(cup1);
					Play("Coin.wav"); 
					ImageIcon yogert=new ImageIcon("yogert.png");
					ingreJuice2.setIcon(yogert);
					a1=1;
					System.out.println("a1:"+a1);
				}
				else {
					ingreJuice2.setIcon(ingreJuices2);
				  }
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		ingreJuices3 = new ImageIcon("ingreJuice3.png");
		ingreJuice3 = new JLabel(ingreJuices3);
		ingreJuice3.setBounds(1490, 750, 150, 189);
		add(ingreJuice3);
		ingreJuice3.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				   int x = e.getX();
//				   int y = e.getY();
				ingreJuice3.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x, e.getLocationOnScreen().y - mouseClickedLocation.y); // 위치 조정
				if(e.getLocationOnScreen().x - mouseClickedLocation.x<850 && e.getLocationOnScreen().x - mouseClickedLocation.x>420&& e.getLocationOnScreen().y - mouseClickedLocation.y>40&& e.getLocationOnScreen().y - mouseClickedLocation.y<450) {
//					ImageIcon cup = new ImageIcon("st.png");
//					JLabel cup1 = new JLabel(cup);
//					cup1.setBounds(480,100,800,800);
//					add(cup1);
					Play("Coin.wav"); 
					ImageIcon milk=new ImageIcon("milk.png");
					ingreJuice3.setIcon(milk);
					b1=1;
					System.out.println("b1:"+b1);
				}
				else {
					ingreJuice3.setIcon(ingreJuices3);
				  }
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		ingreJuices4 = new ImageIcon("ingreJuice4.png");
		ingreJuice4 = new JLabel(ingreJuices4);
		ingreJuice4.setBounds(1690, 700, 100, 287);
		add(ingreJuice4);
		ingreJuice4.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				   int x = e.getX();
//				   int y = e.getY();
				ingreJuice4.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x, e.getLocationOnScreen().y - mouseClickedLocation.y); // 위치 조정
				if(e.getLocationOnScreen().x - mouseClickedLocation.x<850 && e.getLocationOnScreen().x - mouseClickedLocation.x>420&& e.getLocationOnScreen().y - mouseClickedLocation.y>20&& e.getLocationOnScreen().y - mouseClickedLocation.y<450) {
//					ImageIcon cup = new ImageIcon("st.png");
//					JLabel cup1 = new JLabel(cup);
//					cup1.setBounds(480,100,800,800);
//					add(cup1);
					Play("Coin.wav"); 
					ImageIcon cida=new ImageIcon("cida.png");
					ingreJuice4.setIcon(cida);
					c1=1;
					System.out.println("c1:"+c1);
				}
				else {
					ingreJuice4.setIcon(ingreJuices4);
				  }
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		pic1=new JLabel();
		pic1.setBounds(720, 300, 150,150);
		add(pic1);
		
		pic2=new JLabel();
		pic2.setBounds(520, 140, 150, 150);
		add(pic2);
		
		pic3=new JLabel();
		pic3.setBounds(620,210, 150, 150);
		add(pic3);

		ingrePearl1.addMouseListener(m1);
		ingrePearl2.addMouseListener(m1);
		ingrePearl3.addMouseListener(m1);
		ingreFruit1.addMouseListener(m1);
		ingreFruit2.addMouseListener(m1);
		ingreFruit3.addMouseListener(m1);
		ingreFruit4.addMouseListener(m1);
		ingreJuice1.addMouseListener(m2);
		ingreJuice2.addMouseListener(m1);
		ingreJuice3.addMouseListener(m1);
		ingreJuice4.addMouseListener(m1);
		pic1.setTransferHandler(new TransferHandler("icon"));
		pic2.setTransferHandler(new TransferHandler("icon"));
		pic3.setTransferHandler(new TransferHandler("icon"));
		ingreJuice1.setTransferHandler(new TransferHandler("icon"));
		
		
		JLabel order = new JLabel("주문서");
		order.setBounds(1600, 80, 200, 200);
		order.setFont(new Font("맑은 고딕", Font.BOLD, 50));
	    add(order);
	    
	    text.setBounds(1570,250,400,200);
	    text.setFont(new Font("맑은 고딕", Font.BOLD, 30));
	    add(text);
	    
		random();
		
		chk();
		
	JSlider slider = new JSlider(JSlider.VERTICAL, 0, 100,0);
	  slider.setPaintLabels(true); 
	  slider.setPaintTicks(true);
	  slider.setPaintTrack(true);

	  slider.setMajorTickSpacing(50);
	  slider.setMinorTickSpacing(10);
	  slider.setBounds(300, 450, 50, 200);
	  slider.addChangeListener(new ChangeListener(){
		  public void stateChanged(ChangeEvent e) {
			  chk = slider.getValue();
		  }
	  });
	  add(slider);
	  
	ok_btn1.setBorderPainted(false);
    ok_btn1.setContentAreaFilled(false);
    ok_btn1.setBounds(1570, 500, 221, 76);
    add(ok_btn1);

    ok_btn1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ice=pic1.getIconTextGap()+pic2.getIconTextGap()+pic3.getIconTextGap();
			
			if(pic1.getIcon()!=null) {
				chk1=1;
				System.out.println("chk1이 맞습니다");
			}
			if(pic2.getIcon()!=null) {
				chk2=1;
				System.out.println("chk2이 맞습니다");
			}
			if(pic3.getIcon()!=null) {
				chk3=1;
				System.out.println("chk3이 맞습니다");
			}
			System.out.println("chk합니다"+chk1);
			System.out.println("chk합니다"+chk2);
			System.out.println("chk합니다"+chk3);
			
			chkresult=chk1+chk2+chk3;
			
			System.out.println("chkre"+chkresult);
		
			chk();
			
			//random();
			
			slider.setValue(0);
			
		
			System.out.println(oh);
			
				if(oh==1) {
					
					two.setVisible(true);
					replay_btn.setVisible(true);
					exit_btn.setVisible(true);

					
				}
				else if(oh==0) {

					
					two2.setVisible(true);
					replay_btn.setVisible(true);
					exit_btn.setVisible(true);
				
			}

			ingrePearl1.setBounds(70, 760, 140, 140);
			ingrePearl2.setBounds(260, 760, 140, 140);
			ingrePearl3.setBounds(440, 760, 140, 140);
			ingreFruit1.setBounds(680, 710, 150, 123);
			ingreFruit2.setBounds(890, 720, 150, 112);
			ingreFruit3.setBounds(680, 880, 150, 97);
			ingreFruit4.setBounds(890, 850, 150, 129);
			ingreJuice1.setBounds(1140, 795, 150, 84);
			ingreJuice2.setBounds(1340, 750, 100, 193);
			ingreJuice3.setBounds(1490, 750, 150, 189);
			ingreJuice4.setBounds(1690, 700, 100, 287);
			
			pic1.setIcon(null);
			pic1.revalidate();
			pic2.setIcon(null);
			pic2.revalidate();
			pic3.setIcon(null);
			pic3.revalidate();
			
			chk1 = 0;
			chk2 = 0;
			chk3 = 0;
			chkresult = 0;
			
		
			ingreJuice1.setBounds(1140, 795, 150, 84);

		}

	});
		setLayout(null);
}
	public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(main_bg,0,0,getWidth(),getHeight(),this);
    }
	
	public void chk() {

		if(menu[0].equals("녹차쉐이크")) {
			
			
			if(d==1&&b1==1&&chkresult==3&&b2==1) {
				System.out.println("녹차쉐이크 성공");
			
				oh+=1;
				
			}

		}

		if(menu[0].equals("블루베리에이드")) {
			
			
			if(b==1&&c1==1&&chkresult==2&&c2==1) {
				System.out.println("블루베리에이드 성공");
			
				oh+=1;
				
			}

		}
		if(menu[0].equals("딸기요거트")) {
			
			if(a==1&&a1==1&&chkresult==2&&a2==1) {
				System.out.println("딸기요거트 성공");
			
				oh+=1;
			
			}

		}

	}
	public void random() {
		
		for(int i=0;i<Labels.length; i++) {	
			  menu[i] = Labels[r.nextInt(3)];
			 for(int j=i-1;j>=0;j--) {
				 if(menu[i]==menu[j]) {
					 i--;
					 break;
				 }
			 }
		  }
			text.setText(menu[0]);
			
	}

	
}