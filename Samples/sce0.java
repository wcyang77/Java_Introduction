import java.awt.*;
import java.awt.event.*;

public class sce0 implements ActionListener {
  String[] bstr={"7","8","9","+","4","5","6","-",
                 "1","2","3","*","CE","0","=","/"};	
  Font  lfont=new Font("Helvetica",Font.BOLD,32);
  Font  mfont=new Font("Helvetica",Font.BOLD,24);
  Button[] b=new Button[16];
  Panel pl=new Panel();
  Label tf = new Label("0");
  Frame fr = new Frame("Small Calculator");
  StringBuffer sb = new StringBuffer("");
  int flag=0; 
  // flag=0:input & display the first integer, 
  // flag=1:input & display the second integer,
  int[] ip={0,0};
  int opid=0; 
  // opid=0, 1, 2, 3, and 4 when 
  // the opearation is none, +, -, *, and / ,repectively.
  
  public sce0() {
	fr.setSize(300,400);
	fr.addWindowListener(new AdapterDemo());
	fr.setBackground(Color.lightGray); 
    fr.setLayout(new BorderLayout()); 
    fr.setFont(lfont);
    
    tf.setBackground(Color.black);
    tf.setForeground(Color.green);
    tf.setAlignment(Label.RIGHT);
    
    pl.setLayout(new GridLayout(4,4,2,2));
    pl.setFont(mfont);
    for(int i=0; i<16; i++) {
      b[i]=new Button(bstr[i]);
      b[i].addActionListener(this);
      pl.add(b[i]);
    }
    fr.add("North",tf);    
    fr.add("Center",pl); 
    fr.setVisible(true);
  }  
  
  public void operate(int opid) {
	    switch(opid) {
	      case 0: 
	        ip[1]=0; flag=0; 
	        break;  
	      case 1: 
	        ip[0]+=ip[1]; ip[1]=0; flag=1;
	        tf.setText(Integer.toString(ip[0]));
	        break;  
	      case 2: 
	        ip[0]-=ip[1]; ip[1]=0; flag=1; 
	        tf.setText(Integer.toString(ip[0]));
	        break;  
	      case 3: 
	        ip[0]*=ip[1]; ip[1]=0; flag=1;
	        tf.setText(Integer.toString(ip[0]));
	        break;  
	      case 4: 
	        if(ip[1]==0) ip[0]=1;
	        else ip[0]/=ip[1]; 
	        ip[1]=0; flag=1;
	        tf.setText(Integer.toString(ip[0]));
	    }
  }  
  
  
  public void actionPerformed(ActionEvent e) throws NumberFormatException {
    int i;
    for(i=0; i<16; i++) {
      if(e.getSource()==b[i]) {
        switch(i) {
          case  0:   case  1:     case  2:
          case  4:   case  5:     case  6:
          case  8:   case  9:     case 10:
          case 13:
              ip[flag]=ip[flag]*10+Integer.parseInt(bstr[i]);
              if(ip[flag]<0) ip[flag]=0;
              tf.setText(Integer.toString(ip[flag]));
              break;

          case  3: operate(opid); opid=1; flag=1; break;
          case  7: operate(opid); opid=2; flag=1; break;
          case 11: operate(opid); opid=3; flag=1; break;
          case 15: operate(opid); opid=4; flag=1; break;
          
          case 12: 
            ip[0]=0; ip[1]=0; flag=0; opid=0; 
            tf.setText("0");
            break;   
          
          case 14: operate(opid); opid=0;
        } //switch
      } //if  
    }//for
  }
    
  public static void main(String[] args) {
	sce0 cal = new sce0();
  }
  
} 


class AdapterDemo extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}