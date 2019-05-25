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



public class Game3 extends JPanel implements ActionListener{
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
	JLabel ingreJuice,ingreJuice1, ingreJuice2, ingreJuice3, ingreJuice4;
	JLabel ingreFruit1, ingreFruit2, ingreFruit3, ingreFruit4;
	JLabel cup;
	JLabel pic1,pic2,pic3;
	int a,b,c,d; //����
	int a1,b1,c1,d1;//����
	int a2,b2,c2;//��
	int su,oh,fa,chk; //chk�� �����̴� �� �޾ƿ��� �뵵
	int ice;
	//private JSlider slider1 ;
	JLabel recipe1;
	JLabel hint_recipe; 
	JButton X_btn2;
	int chk1, chk2, chk3, chkresult = 0;
	

    
    ImageIcon okbtn1 = new ImageIcon("ok.png");
    JButton ok_btn1 = new JButton(okbtn1);
    Point mouseClickedLocation = new Point(0, 0);

    String[] Labels ={"������������Ƽ","�������ڳӹ���Ƽ","���϶����Ƽ"};

	String[] menu = new String[7];
	
	JLabel text = new JLabel();
	Random r = new Random();

	
	Timer mTimer = new Timer(1000, this);//1�ʾ� ����
	int mTime = 30;//�� ī��Ʈ
	
	int check = 0;
	
	//��Ʈ
	Timer hTimer = new Timer(1000, this);
	int hTime = 5;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(mTimer == arg0.getSource()){
			mTime--;//30�ʺ��� ����
			if(mTime <= 0){ //mTime�� 0�� �Ǹ� Ÿ�̸Ӹ� ���߰� �˸�â ����ֱ�
				mTimer.stop();
				 int num = 0;
				 if(num==0) {
					 ImageIcon middle = new ImageIcon("x.png");
						JLabel two = new JLabel(middle); 
						two.setBounds(270, 100, 1366,768);
						add(two);
				 }
			}
			repaint();//��Ʈ�� ��ȭ
		}//if
		
		if(hTimer == arg0.getSource()){
			hTime--;
			if(hTime <= 0){ 
				hTimer.stop();
				remove(hint_recipe);
				remove(X_btn2);
				hTime = 5;
			}
			repaint();//��Ʈ�� ��ȭ
		}//if
	}//actionPerformed

	@Override
	public void paint(Graphics g) {//�۾�
		super.paint(g);
		
		String msg = "time: " + mTime;
		g.setFont(new Font("Serif", Font.BOLD, 30));//�۾�
		g.drawString(msg, 0, 30);
	}//paint
	
	public Game3(Main_frame frame) {

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
	    X_btn1.setBounds(1690, 10, 32, 32);
	    add(X_btn1);
	    
	    ImageIcon recipe = new ImageIcon("recipe3.png");
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


      ImageIcon hint = new ImageIcon("hint.png");
	    JButton Hint = new JButton(hint);
	    Hint.setBorderPainted(false);
	    Hint.setContentAreaFilled(false);
	    Hint.setBounds(70, -55, 150, 150);
	    add(Hint);

	    ImageIcon h_recipe = new ImageIcon("recipe3.png");
		hint_recipe = new JLabel(h_recipe); 
		hint_recipe.setBounds(70, 0, 1366,768);
		
		ImageIcon Xbtn2 = new ImageIcon("error.png");
	    X_btn2 = new JButton(Xbtn2);
	    X_btn2.setBorderPainted(false);
	    X_btn2.setContentAreaFilled(false);
	    X_btn2.setBounds(1290, 10, 32, 32);
	
        Hint.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				add(X_btn2);
				add(hint_recipe);
				hTimer.start();
				
				check++;
				
				if(check==2) {
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

		
		ImageIcon ingrePearls1 = new ImageIcon("ingrePearl1.png");
		ingrePearl1 = new JLabel(ingrePearls1);
		ingrePearl1.setBounds(70, 760, 140, 140);
		add(ingrePearl1);
		ingrePearl1.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				   int x = e.getX();
//				   int y = e.getY();
				  ingrePearl1.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x, e.getLocationOnScreen().y - mouseClickedLocation.y); // ��ġ ����
				  if(e.getLocationOnScreen().x - mouseClickedLocation.x<850 && e.getLocationOnScreen().x - mouseClickedLocation.x>450&& e.getLocationOnScreen().y - mouseClickedLocation.y>200&& e.getLocationOnScreen().y - mouseClickedLocation.y<400) {
					  Play("Coin.wav"); 
						a2=1;
				
					}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ImageIcon ingrePearls2 = new ImageIcon("ingrePearl2.png");
		ingrePearl2 = new JLabel(ingrePearls2);
		ingrePearl2.setBounds(260, 760, 140, 140);
		add(ingrePearl2);
		ingrePearl2.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				   int x = e.getX();
//				   int y = e.getY();
				  ingrePearl2.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x, e.getLocationOnScreen().y - mouseClickedLocation.y); // ��ġ ����
				  if(e.getLocationOnScreen().x - mouseClickedLocation.x<850 && e.getLocationOnScreen().x - mouseClickedLocation.x>450&& e.getLocationOnScreen().y - mouseClickedLocation.y>200&& e.getLocationOnScreen().y - mouseClickedLocation.y<400) {
					  Play("Coin.wav"); 
						b2=1;
				
					}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ImageIcon ingrePearls3 = new ImageIcon("ingrePearl3.png");
		ingrePearl3 = new JLabel(ingrePearls3);
		ingrePearl3.setBounds(440, 760, 140, 140);
		add(ingrePearl3);
		ingrePearl3.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				   int x = e.getX();
//				   int y = e.getY();
				  ingrePearl3.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x, e.getLocationOnScreen().y - mouseClickedLocation.y); // ��ġ ����
				  if(e.getLocationOnScreen().x - mouseClickedLocation.x<850 && e.getLocationOnScreen().x - mouseClickedLocation.x>450&& e.getLocationOnScreen().y - mouseClickedLocation.y>200&& e.getLocationOnScreen().y - mouseClickedLocation.y<400) {
					  Play("Coin.wav"); 
						c2=1;
				
					}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ImageIcon ingreFruits1 = new ImageIcon("ingreFruit1.png");
		ingreFruit1 = new JLabel(ingreFruits1);
		ingreFruit1.setBounds(620, 710, 150, 123);
		add(ingreFruit1);
		ingreFruit1.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				   int x = e.getX();
//				   int y = e.getY();
				ingreFruit1.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x, e.getLocationOnScreen().y - mouseClickedLocation.y); // ��ġ ����
			
			if(e.getLocationOnScreen().x - mouseClickedLocation.x<850 && e.getLocationOnScreen().x - mouseClickedLocation.x>450&& e.getLocationOnScreen().y - mouseClickedLocation.y>200&& e.getLocationOnScreen().y - mouseClickedLocation.y<400) {
				Play("Coin.wav"); 
				a=1;
				System.out.println("a:"+a);
			}
				 
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ImageIcon ingreFruits2 = new ImageIcon("painapple.png");
		ingreFruit2 = new JLabel(ingreFruits2);
		ingreFruit2.setBounds(830, 685, 150, 200);
		add(ingreFruit2);
		ingreFruit2.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				   int x = e.getX();
//				   int y = e.getY();
				ingreFruit2.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x, e.getLocationOnScreen().y - mouseClickedLocation.y); // ��ġ ����
				if(e.getLocationOnScreen().x - mouseClickedLocation.x<850 && e.getLocationOnScreen().x - mouseClickedLocation.x>450&& e.getLocationOnScreen().y - mouseClickedLocation.y>200&& e.getLocationOnScreen().y - mouseClickedLocation.y<400) {
//					ImageIcon cup = new ImageIcon("st.png");
//					JLabel cup1 = new JLabel(cup);
//					cup1.setBounds(480,100,800,800);
//					add(cup1);
					Play("Coin.wav"); 
					b=1;
					System.out.println("b:"+b);
				}
		
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ImageIcon ingreFruits3 = new ImageIcon("orange.png");
		ingreFruit3 = new JLabel(ingreFruits3);
		ingreFruit3.setBounds(620, 850, 150,150);
		add(ingreFruit3);
		ingreFruit3.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				   int x = e.getX();
//				   int y = e.getY();
				ingreFruit3.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x, e.getLocationOnScreen().y - mouseClickedLocation.y); // ��ġ ����
				if(e.getLocationOnScreen().x - mouseClickedLocation.x<850 && e.getLocationOnScreen().x - mouseClickedLocation.x>450&& e.getLocationOnScreen().y - mouseClickedLocation.y>200&& e.getLocationOnScreen().y - mouseClickedLocation.y<400) {
//					ImageIcon cup = new ImageIcon("st.png");
//					JLabel cup1 = new JLabel(cup);
//					cup1.setBounds(480,100,800,800);
//					add(cup1);
					Play("Coin.wav"); 
					c=1;
					System.out.println("c:"+c);
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		ImageIcon ingreFruits4 = new ImageIcon("kokonut.png");
		ingreFruit4 = new JLabel(ingreFruits4);
		ingreFruit4.setBounds(830, 880, 150, 129);
		add(ingreFruit4);
		ingreFruit4.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				   int x = e.getX();
//				   int y = e.getY();
				ingreFruit4.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x, e.getLocationOnScreen().y - mouseClickedLocation.y); // ��ġ ����
				if(e.getLocationOnScreen().x - mouseClickedLocation.x<850 && e.getLocationOnScreen().x - mouseClickedLocation.x>450&& e.getLocationOnScreen().y - mouseClickedLocation.y>200&& e.getLocationOnScreen().y - mouseClickedLocation.y<400) {
//					ImageIcon cup = new ImageIcon("st.png");
//					JLabel cup1 = new JLabel(cup);
//					cup1.setBounds(480,100,800,800);
//					add(cup1);
					Play("Coin.wav"); 
					d=1;
					System.out.println("d:"+d);
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		
		ImageIcon ingreJuices = new ImageIcon("ingreJuice2.png");
		ingreJuice = new JLabel(ingreJuices);
		ingreJuice.setBounds(970, 750, 200, 193);
		add(ingreJuice);
		ingreJuice.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				   int x = e.getX();
//				   int y = e.getY();
				ingreJuice.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x, e.getLocationOnScreen().y - mouseClickedLocation.y); // ��ġ ����
				if(e.getLocationOnScreen().x - mouseClickedLocation.x<850 && e.getLocationOnScreen().x - mouseClickedLocation.x>450&& e.getLocationOnScreen().y - mouseClickedLocation.y>200&& e.getLocationOnScreen().y - mouseClickedLocation.y<400) {
//					ImageIcon cup = new ImageIcon("st.png");
//					JLabel cup1 = new JLabel(cup);
//					cup1.setBounds(480,100,800,800);
//					add(cup1);
					Play("Coin.wav"); 
					d1=1;
					System.out.println("a1:"+a1);
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ImageIcon ingreJuices1 = new ImageIcon("ingreJuice1.png");
		ingreJuice1 = new JLabel(ingreJuices1);
		ingreJuice1.setBounds(1140, 795, 150, 84);
		add(ingreJuice1);
		
		
		ImageIcon ingreJuices2 = new ImageIcon("tiback.png");
		ingreJuice2 = new JLabel(ingreJuices2);
		ingreJuice2.setBounds(1200, 750, 250, 193);
		add(ingreJuice2);
		ingreJuice2.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				   int x = e.getX();
//				   int y = e.getY();
				ingreJuice2.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x, e.getLocationOnScreen().y - mouseClickedLocation.y); // ��ġ ����
				if(e.getLocationOnScreen().x - mouseClickedLocation.x<850 && e.getLocationOnScreen().x - mouseClickedLocation.x>450&& e.getLocationOnScreen().y - mouseClickedLocation.y>200&& e.getLocationOnScreen().y - mouseClickedLocation.y<400) {
//					ImageIcon cup = new ImageIcon("st.png");
//					JLabel cup1 = new JLabel(cup);
//					cup1.setBounds(480,100,800,800);
//					add(cup1);
					Play("Coin.wav"); 
					a1=1;
					System.out.println("a1:"+a1);
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		ImageIcon ingreJuices3 = new ImageIcon("ingreJuice3.png");
		ingreJuice3 = new JLabel(ingreJuices3);
		ingreJuice3.setBounds(1490, 750, 150, 189);
		add(ingreJuice3);
		ingreJuice3.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				   int x = e.getX();
//				   int y = e.getY();
				ingreJuice3.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x, e.getLocationOnScreen().y - mouseClickedLocation.y); // ��ġ ����
				if(e.getLocationOnScreen().x - mouseClickedLocation.x<850 && e.getLocationOnScreen().x - mouseClickedLocation.x>450&& e.getLocationOnScreen().y - mouseClickedLocation.y>200&& e.getLocationOnScreen().y - mouseClickedLocation.y<400) {
//					ImageIcon cup = new ImageIcon("st.png");
//					JLabel cup1 = new JLabel(cup);
//					cup1.setBounds(480,100,800,800);
//					add(cup1);
					Play("Coin.wav"); 
					b1=1;
					System.out.println("b1:"+b1);
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		ImageIcon ingreJuices4 = new ImageIcon("h.png");
		ingreJuice4 = new JLabel(ingreJuices4);
		ingreJuice4.setBounds(1680, 700, 150, 287);
		add(ingreJuice4);
		ingreJuice4.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				   int x = e.getX();
//				   int y = e.getY();
				ingreJuice4.setLocation(e.getLocationOnScreen().x - mouseClickedLocation.x, e.getLocationOnScreen().y - mouseClickedLocation.y); // ��ġ ����
				if(e.getLocationOnScreen().x - mouseClickedLocation.x<850 && e.getLocationOnScreen().x - mouseClickedLocation.x>450&& e.getLocationOnScreen().y - mouseClickedLocation.y>200&& e.getLocationOnScreen().y - mouseClickedLocation.y<400) {
//					ImageIcon cup = new ImageIcon("st.png");
//					JLabel cup1 = new JLabel(cup);
//					cup1.setBounds(480,100,800,800);
//					add(cup1);
					Play("Coin.wav"); 
					c1=1;
					System.out.println("c1:"+c1);
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
		
		
		JLabel order = new JLabel("�ֹ���");
		order.setBounds(1600, 80, 200, 200);
		order.setFont(new Font("���� ����", Font.BOLD, 50));
	    add(order);
	    
	    text.setBounds(1570,250,400,200);
	    text.setFont(new Font("���� ����", Font.BOLD, 30));
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
				System.out.println("chk1�� �½��ϴ�");
			}
			if(pic2.getIcon()!=null) {
				chk2=1;
				System.out.println("chk2�� �½��ϴ�");
			}
			if(pic3.getIcon()!=null) {
				chk3=1;
				System.out.println("chk3�� �½��ϴ�");
			}
			System.out.println("chk�մϴ�"+chk1);
			System.out.println("chk�մϴ�"+chk2);
			System.out.println("chk�մϴ�"+chk3);
			
			chkresult=chk1+chk2+chk3;
			
			System.out.println("chkre"+chkresult);
		
			chk();
			
			//random();
			
			slider.setValue(0);
			
		
			System.out.println(oh);
			
				if(oh==1) {
					ImageIcon middle = new ImageIcon("good.jpg");
					JLabel two = new JLabel(middle); 
					two.setBounds(270, 100, 1500,768);
					add(two);
				}
				else if(oh==0) {
			
				 ImageIcon middle = new ImageIcon("x.png");
					JLabel two = new JLabel(middle); 
					two.setBounds(270, 100, 1366,768);
					add(two);
				
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
			
			if(oh==1) {
				ImageIcon middle = new ImageIcon("good.jpg");
				JLabel two = new JLabel(middle); 
				two.setBounds(270, 100, 1500,768);
				add(two);
			}
			else if(oh==0) {
		
			 ImageIcon middle = new ImageIcon("x.png");
				JLabel two = new JLabel(middle); 
				two.setBounds(270, 100, 1366,768);
				add(two);
			
		}
	
		}

	});
		setLayout(null);
}
	public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(main_bg,0,0,getWidth(),getHeight(),this);
    }
	
	public void chk() {

if(menu[0].equals("������������Ƽ")) {
			
	
			if(c1==1&&a1==1&&b1==1&&chk>=45&&chk<=55&&chkresult==2&&a2==1) {
				System.out.println("������������Ƽ ����");
				
				oh+=1;
				
			}

		}
		if(menu[0].equals("�������ڳӹ���Ƽ")) {
			
			
			if(a==1&&d==1&&d1==1&&chk>=45&&chk<=55&&chkresult==1&&a2==1) {
				System.out.println("�������ڳӹ���Ƽ ����");
				
				oh+=1;
				
			}

		}
		if(menu[0].equals("���϶����Ƽ")) {
			
		
			if(a==1&&b==1&&c==1&&chk>=65&&chk<=75&&chkresult==3&&b2==1) {
				System.out.println("���϶����Ƽ o");
				
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