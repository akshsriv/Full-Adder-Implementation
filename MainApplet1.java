import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class MainApplet1 extends Applet implements ActionListener,Runnable {
 Gates ga[]=new Gates[9];
 Lines li[]=new Lines[15];
 Label l[]=new Label[2];
 Button ba[]=new Button[3];
 Thread t;
 Font myFont = new Font("Courier", Font.BOLD,30);
	Font myFont2 = new Font("Courier", Font.BOLD,40);
 
	
	
	public void init()
 {
		setLayout(null);
	 for(int i=0;i<9;i++)
	 {
		 ga[i]=new Gates();
	 }
	 for(int i=0;i<15;i++)
	 {
		 li[i]=new Lines();
	 }
	 for(int i=0;i<2;i++)
	 {
		 l[i]=new Label();
	 }
	 for(int i=0;i<3;i++)
	 {
		 ba[i]=new Button("0");
	 }
	 
	    setBackground(Color.gray);
	    addLabel(l[0],1700,265,40,40);
		addLabel(l[1],1700,575,40,40);
		
		addButton(ba[0],80,240,40,40);
		addButton(ba[1],80,290,40,40);
		addButton(ba[2],80,510,40,40);
 }
	public void addLabel(Label la,int x,int y,int w,int h)
	{
		add(la);
		la.setBounds(x,y,w,h);
        la.setBackground(Color.red);
		la.setFont(myFont);
		la.setAlignment(Label.CENTER);
        la.setText("0");
	}
	public void addButton(Button b,int x,int y,int width,int height)
	{
		add(b);
		b.addActionListener(this);
        b.setBounds(x,y,width,height);
		b.setBackground(Color.red);
		b.setFont(myFont);
	}
 public void paint(Graphics g)
 {
	//paintGrid(g);
	 Graphics2D g1=(Graphics2D)g;
		g1.setStroke(new BasicStroke(3));
		g.setFont(myFont2);
		g.drawString("MODULE-2 IMPLEMENTATION OF FULL ADDER",450,40);
		g.drawLine(440, 50, 1340, 50);
		g.drawString("( USING ONLY NAND GATES )",550,810);
		g.drawLine(550, 820, 1150, 820);
		
		ga[0].drawNAND(g,250,270);
		int x1[]={100,228,150,150,150,480};
		int y1[]={260,260,260,140,140,140};
		li[0].drawl(g,x1,y1,3);
		int x2[]={100,228,150,150,150,480};
		int y2[]={310,310,310,430,430,430};
		li[1].drawl(g1, x2, y2, 3);
		int x3[]={290,390,390,390,390,480,390,390,390,1480,390,480};
		int y3[]={285,285,285,190,190,190,285,620,620,620,380,380};
		li[2].drawl(g1, x3, y3, 6);
		
		ga[1].drawNAND(g,500,150);
		int x4[]={540,640,640,640,640,730};
		int y4[]={165,165,165,260,260,260};
		li[3].drawl(g1, x4, y4, 3);
		
		ga[2].drawNAND(g,500,390);
		int x5[]={540,640,640,640,640,730};
		int y5[]={405,405,405,310,310,310};
		li[4].drawl(g1, x5, y5, 3);
		
		
		ga[3].drawNAND(g1, 750, 270);
		int x6[]={ 790,900,900,900,900,980,900,900,900,1230};
		int y6[]={285,285,285,260,260,260,260,140,140,140};
		li[5].drawl(g1, x6, y6, 5);
		
        ga[4].drawNAND(g,1000,270);
        int x7[]={100,900,900,900,900,980,900,1230};
        int y7[]={530,530,530,310,310,310,430,430};
        li[6].drawl(g1, x7, y7, 4);
        int x8[]={1040,1140,1140,1140,1140,1230,1140,1140,1140,1480,1140,1230};
        int y8[]={285,285,285,190,190,190,285,580,580,580,380,380};
        li[7].drawl(g1, x8, y8, 6);
		
		ga[5].drawNAND(g,1250,150);
		int x9[]={1290,1390,1390,1390,1390,1480};
		int y9[]={165,165,165,260,260,260};
		li[8].drawl(g1, x9, y9, 3);
		
		ga[6].drawNAND(g,1250,390);
		int x10[]={1290,1390,1390,1390,1390,1480};
		int y10[]={405,405,405,310,310,310};
		li[9].drawl(g1, x10, y10, 3);
		
		ga[7].drawNAND(g1, 1500, 270);
		li[10].drawl(g1, 1540,285,1700,285);
		
		ga[8].drawNAND(g1, 1500, 580);
		li[11].drawl(g1,1540,595,1700,595);
		
		 l[0].setBackground(li[10].xyz[li[10].c]);
	     l[0].setText(Integer.toString(li[10].c));
	     l[1].setBackground(li[11].xyz[li[11].c]);
	     l[1].setText(Integer.toString(li[11].c));
	     
	     g.setColor(Color.black);
	    g.drawString("A", 80, 230);
	    g.drawString("B", 80, 360);
	    g.drawString("Cin", 80, 590);
	    g.drawString("SUM", 1700, 260);
	    g.drawString("Cout", 1700,570);
		
		
	
 }
 public void actionPerformed(ActionEvent ae)
 {
	Button a=(Button)ae.getSource();
	if(a==ba[0])//if A clicked
	{
		li[0].c++;
		a.setLabel(Integer.toString(li[0].c%2));
		a.setBackground(li[0].xyz[li[0].c%2]);

		//t[m++].start();
	}
	
	else if(a==ba[1])
	{
	  li[1].c++;
		a.setLabel(Integer.toString(li[1].c%2));
		a.setBackground(li[1].xyz[li[1].c%2]);
//		count=1;
		//t[m++].start();
	}
	
	else if(a==ba[2])
	{
		li[6].c++;
		a.setLabel(Integer.toString(li[6].c%2));
		a.setBackground(li[2].xyz[li[6].c%2]);
	//	count=1;
		//t[m++].start();
	}
	
	
	
     
     t=new Thread(this);
     t.start();
	//repaint();
 }
 public void run()
 {
	 try{
        repaint();
        Thread.sleep(500);
	    li[2].c=(((li[0].c%2) & (li[1].c%2))+1)%2;
	    repaint();
        Thread.sleep(200);
		li[3].c=(((li[0].c%2) &(li[2].c%2))+1)%2;
		repaint();
        Thread.sleep(200);
		li[4].c=(((li[1].c%2) &(li[2].c%2))+1)%2;
		repaint();
        Thread.sleep(200);
		li[5].c=(((li[3].c%2) &(li[4].c%2))+1)%2;
		repaint();
        Thread.sleep(200);
		li[7].c=(((li[5].c%2) &(li[6].c%2))+1)%2;
		repaint();
        Thread.sleep(200);
		li[8].c=(((li[5].c%2) &(li[7].c%2))+1)%2;
		repaint();
        Thread.sleep(200);
		li[9].c=(((li[6].c%2) &(li[7].c%2))+1)%2;
		repaint();
        Thread.sleep(200);
		li[10].c=(((li[8].c%2) &(li[9].c%2))+1)%2;
		repaint();
        Thread.sleep(500);
		li[11].c=(((li[2].c%2) &(li[7].c%2))+1)%2;
		repaint();
 }
	 catch(InterruptedException e){}
	 finally{
		 t=null;
	 }
 }
 public void update(Graphics g)
 {
	 paint(g);
 }
 public void paintGrid(Graphics g)
	{
		for(int i=0;i<=2000;i+=10)
		{
			g.setColor(Color.red);
			g.drawLine(0, i, 2000, i);

			g.drawString(Integer.toString(i), 0, i);
	        g.setColor(Color.green);
			g.drawLine(i, 0, i, 1000);
			g.setColor(Color.black);
			if(i%50==0)
			g.drawString(Integer.toString(i), i, 10);

		}
	}
}
