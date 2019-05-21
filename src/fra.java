import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;

class fra {
    public static void main(String args[]) {
        frame f = new frame();
        f.gui();
        f.actions();
    }
}

class frame {
    BufferedImage file;
    File img;
    ImageIcon icon;

    JLabel image;
    JFrame frame;
    JPanel panel;
    String[] path = { "story1.jpg", "story2.jpg", "story3.jpg"};

    JButton next = new JButton("NEXT");
    static int num = 0;

    public void gui() {
        frame = new JFrame("pic gallery");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        FlowLayout flow = new FlowLayout();
        frame.setLayout(flow);
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.add(next);
        
        JLabel piclabel = new JLabel();

        frame.getContentPane().add(panel);
    }

    void actions() {

        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img = new File(path[num]);
                System.out.println(num);
try
{
     file = ImageIO.read(img);
     icon = new ImageIcon(file);
     if(image != null) frame.remove(image);
     image = new JLabel("", icon, SwingConstants.CENTER);

     image.setVisible(true);
     frame.getContentPane().add(image);
     frame.revalidate();
     frame.repaint();
}
catch (IOException g)
{
}
                if (num < path.length - 1) {
                    num++;
                } else {
                    num = 0;
                }
            }
        });
    }
}