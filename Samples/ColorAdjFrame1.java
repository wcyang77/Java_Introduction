import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ColorAdjFrame1 implements AdjustmentListener{

	JFrame fr = new JFrame("顏色調整");
	JTextArea ta = new JTextArea();
	JScrollBar sr,sg,sb;
	JPanel srgb = new JPanel();
	int r=0, g=0, b=0;
	JLabel lb = new JLabel("(0,0,0)");
	
	public ColorAdjFrame1() {
		sr = new JScrollBar(JScrollBar.HORIZONTAL,0,10,0,265);
		sr.setBackground(Color.RED);
		sr.addAdjustmentListener(this);
		sg = new JScrollBar(JScrollBar.HORIZONTAL,0,10,0,265);
		sg.setBackground(Color.GREEN);
		sg.addAdjustmentListener(this);
		sb = new JScrollBar(JScrollBar.HORIZONTAL,0,10,0,265);
		sb.setBackground(Color.BLUE);
		sb.addAdjustmentListener(this);
		srgb.setLayout(new GridLayout(3,0));
		srgb.add(sr);  srgb.add(sg);  srgb.add(sb);
		lb.setHorizontalAlignment(SwingConstants.CENTER);
		ta.setEditable(false);
		fr.setSize(400, 500);
		fr.setLayout(new BorderLayout());
		fr.add(BorderLayout.CENTER,ta);
		fr.add(BorderLayout.NORTH, lb);
		fr.add(BorderLayout.SOUTH, srgb);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
	}
	
	public void adjustmentValueChanged(AdjustmentEvent e) {
		if(e.getSource()==sr) r = sr.getValue();
		if(e.getSource()==sg) g = sg.getValue();
		if(e.getSource()==sb) b = sb.getValue();
		ta.setBackground(new Color(r,g,b));
		lb.setText("("+r+","+g+","+b+")");
	}
	
	public static void main(String[] args) {
		ColorAdjFrame1 app = new ColorAdjFrame1(); 
		app.lb.setText("開始調整顏色");
	}

}

