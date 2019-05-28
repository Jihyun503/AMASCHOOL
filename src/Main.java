import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

class Main_frame extends JFrame{
	
	ImageIcon gamebg = new ImageIcon("game_bg2.jpg");
    Image game_bg = gamebg.getImage();
	
	Index index;
	Game game;
	Game2 game2;
	Game3 game3;
	Select select;
	Result result;
	Result2 result2;
	Test test;
	IngreGame ingregame;
	
	public Main_frame(){
		
		setTitle("아마스쿨"); //타이틀바 문자열
		setLocation(0, 0);//시작위치 (x,y)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//종료 버튼 눌렀을때 행동
		setLocation(300, 0);
	  	setPreferredSize(new Dimension(1280, 870));
	}
	
	public void change(String PanelName)
    {
		if(PanelName.equals("select")) {
    		this.select = new Select(this);
    		getContentPane().removeAll();
			getContentPane().add(select);
			revalidate();
			repaint();
    	}
		if(PanelName.equals("game")) {
    		this.game = new Game(this);
    		getContentPane().removeAll();
			getContentPane().add(game);
			revalidate();
			repaint();
    	}
		if(PanelName.equals("game2")) {
    		this.game2 = new Game2(this);
    		getContentPane().removeAll();
			getContentPane().add(game2);
			revalidate();
			repaint();
    	}
		if(PanelName.equals("game3")) {
    		this.game3 = new Game3(this);
    		getContentPane().removeAll();
			getContentPane().add(game3);
			revalidate();
			repaint();
    	}
		if(PanelName.equals("result")) {
    		this.result = new Result(this);
    		getContentPane().removeAll();
			getContentPane().add(result);
			revalidate();
			repaint();
    	}
		if(PanelName.equals("result2")) {
    		this.result2 = new Result2(this);
    		getContentPane().removeAll();
			getContentPane().add(result2);
			revalidate();
			repaint();
    	}
		if(PanelName.equals("ingregame")) {
    		this.ingregame = new IngreGame(this);
    		getContentPane().removeAll();
			getContentPane().add(ingregame);
			revalidate();
			repaint();
    	}
		if(PanelName.equals("test")) {
    		this.test = new Test(this);
    		getContentPane().removeAll();
			getContentPane().add(test);
			revalidate();
			repaint();
    	}
		if(PanelName.equals("index")) {
    		this.index = new Index(this);
    		getContentPane().removeAll();
			getContentPane().add(index);
			revalidate();
			repaint();
    	}
    }
	
}

public class Main {

	public static void main(String[] args) {
		Main_frame frame = new Main_frame();
		frame.index = new Index(frame);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.add(frame.index);
		frame.pack();
		frame.setVisible(true);//창을 보이게 함

	}

}