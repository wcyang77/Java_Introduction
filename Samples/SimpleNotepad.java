import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class SimpleNotepad implements ActionListener {
	JFrame fr = new JFrame("²���O�ƥ�");
	JMenuBar mb = new JMenuBar();
	JMenu m1 = new JMenu("�ɮ�");
	JMenu m2 = new JMenu("�s��");
	JMenu m3 = new JMenu("����");
	JMenuItem m11 = new JMenuItem("�}�s�ɮ�");
	JMenuItem m12 = new JMenuItem("�}���ɮ�");
	JMenuItem m13 = new JMenuItem("�x�s�ɮ�");
	JMenuItem m21 = new JMenuItem("�j�M...");
	JMenuItem m22 = new JMenuItem("���N...");
	JMenuItem m31 = new JMenuItem("���󥻵{��");
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	FileDialog fd;
	String fileDir,fileName; // ======
	Font f = new Font("Arial Unicode MS",Font.BOLD,20);
	Font f1 = new Font("Arial Unicode MS",Font.PLAIN,18);
	
	public SimpleNotepad() {
		m1.add(m11);  m1.add(m12);   m1.add(m13);  m1.setFont(f);
		m11.addActionListener(this); m11.setFont(f1);
		m12.addActionListener(this); m12.setFont(f1);
		m13.addActionListener(this); m13.setFont(f1);
		
		m2.add(m21);  m2.add(m22);  m2.setFont(f);
		m21.addActionListener(this); m21.setFont(f1);
		m22.addActionListener(this); m22.setFont(f1);
		
		m3.add(m31);  m3.setFont(f);
		m31.addActionListener(this); m31.setFont(f1);
		
		mb.add(m1);  mb.add(m2);  mb.add(m3);
		ta.setFont(f1);
		ta.setEditable(false);
		fr.setLocation(100, 100);
		fr.setSize(800,600);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setJMenuBar(mb);
		fr.add(BorderLayout.CENTER,sp);
		fr.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==m11) {
			ta.setText("");
			ta.setEditable(true);
			ta.setForeground(Color.blue);
			fileName = new String("new");
			fr.setTitle("²���O�ƥ� - "+fileName);
		}
		if(e.getSource()==m12) {
			//fd = new FileDialog(fr,"�}���ɮ�",FileDialog.LOAD);
			JFileChooser fd = new JFileChooser();
			//fd.setVisible(true);
			fd.showOpenDialog(fr);
			ta.setText("");
			ta.setEditable(true);
			ta.setForeground(Color.blue);
			//fileDir = fd.getDirectory();
			//fileName = fd.getFile();
			File file = fd.getSelectedFile();
			//fr.setTitle("²���O�ƥ� - "+fileName);
			fr.setTitle("²���O�ƥ� - "+file.getName());
			try {
				FileReader fin = new FileReader(file);
				BufferedReader in = new BufferedReader(fin);
				String str;
				while((str=in.readLine())!=null) ta.append(str+"\n");
				fin.close();    in.close();
			}
			catch(IOException e1) {
				ta.append("�ɮ׳B�z���~!\n");
			}
		}
		if(e.getSource()==m13) {
			fd = new FileDialog(fr,"�x�s�ɮ�",FileDialog.SAVE);
			fd.setVisible(true);
			fileDir=fd.getDirectory();
			fileName=fd.getFile();
			try {
				FileWriter fout = new FileWriter(fileDir+fileName);
				String str = ta.getText();
				fout.write(str);
				fout.close();
			}
			catch(IOException e1) {
				ta.append("�ɮ׳B�z���~!\n");
			}
			fr.setTitle("²���O�ƥ� - "+fileName);
		}
		if(e.getSource()==m21) {
			ta.setText("���U�j�M");
		}
		if(e.getSource()==m22) {
			ta.setText("���U���N");
		}
		if(e.getSource()==m31) {
			JDialog dl = new JDialog(fr,"����²��O�ƥ�");
			JTextArea dlta = new JTextArea();
			dlta.setEditable(false);
			dlta.setFont(f);
			dlta.setText("�@��:�q�u�j��\n���:2013.05.14");
			dlta.setBackground(Color.lightGray);
			dl.setLocation(200, 200);
			dl.setSize(200,100);
			dl.add(dlta);
			dl.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		SimpleNotepad demo = new SimpleNotepad();
		demo.ta.append("�}�l����....\n");
	}

}