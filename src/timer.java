import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class timer extends JPanel implements ActionListener{	
	Timer mTimer = new Timer(1000, this);//1초씩 증가
	int mTime = 30;//초 카운트
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(mTimer == arg0.getSource()){
			mTime--;//30초부터 감소
			if(mTime <= 0){ //mTime이 0이 되면 타이머를 멈추고 알림창 띄워주기
				mTimer.stop();
				JOptionPane.showMessageDialog(null, "30초가 지났습니다.");
			}//fi
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
	
	public timer(){
		mTimer.start();
	}//timer
	
}//main