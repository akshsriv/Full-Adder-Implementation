import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class MainApplet2 extends Applet implements ActionListener,Runnable
{
	Button b[]=new Button[5];
	Label l[]=new Label[10];
	Lines li[]=new Lines[12];
	Gates ga[]=new Gates[7];
	Font myFont = new Font("Courier", Font.BOLD,30);
	Font myFont2 = new Font("Courier", Font.BOLD,40);
	//Thread t=null;
	//Thread t1=null;
	//Thread[]t =new Thread[1000];
	Thread test;
	Button a;
	int m=0;
	int count=0;
	
	public void init()
	{
		setLayout(null);
		setBackground(Color.gray);
		
		for(int i=0;i<5;i++)
			b[i]=new Button("0");
		
		for(int i=0;i<10;i++)
			l[i]=new Label();
		
		for(int i=0;i<12;i++)
			li[i]=new Lines();
		
		for(int i=0;i<7;i++)
			ga[i]=new Gates();
		
		addButton(b[0],50,100,40,40);
		addButton(b[1],50,200,40,40);
		addButton(b[2],50,300,40,40);
		addButton(b[3],50,585,40,40);
		addButton(b[4],50,700,40,40);
		
		addLabel(l[0],1220,175,40,40);
		addLabel(l[1],1220,300,40,40);
		addLabel(l[2],700,595,40,40);
		addLabel(l[3],700,795,40,40);
		
		//for(int i=0;i<1000;i++){
			//t[i]=new Thread(this);
			
		}
		//t=null;
	
	
	public void addButton(Button b,int x,int y,int width,int height)
	{
		add(b);
		b.addActionListener(this);
        b.setBounds(x,y,width,height);
		b.setBackground(Color.red);
		b.setFont(myFont);
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
	
	
	public void paint(Graphics g)
	{
		//paintGrid(g);
		
		Graphics2D g1=(Graphics2D)g;
		g1.setStroke(new BasicStroke(3));
		
		g.setFont(myFont2);
		g.drawString("FULL ADDER USING XOR GATES/TWO HALF ADDERS",450,40);
		g.drawLine(450, 50, 1450, 50);
		g.drawString("HALF ADDER USING XOR GATES",600,510);
		g.drawLine(590,520,1230,520);
		
		g.setFont(myFont);
		g.setColor(Color.black);
		
		//FOR FULL ADDER
		
		g.drawString("A", 60, 90);
		g.drawString("B", 60, 190);
		g.drawString("Cin",60,290);
		g.drawString("XOR",420, 190);
		g.drawString("XOR",920, 250);
		g.drawString("AND",770, 360);
		g.drawString("AND",360,450);
		g.drawString("OR",1060, 380);
		g.drawString("SUM",1220,160);
		g.drawString("Cout", 1220, 290);
		//FOR HALF ADDER
		g.drawString("A", 60, 575);
		g.drawString("B", 60, 695);
		g.drawString("SUM",752,625);
		g.drawString("Cout", 752, 820);
		g.drawString("XOR",420, 670);
		g.drawString("AND",420,870);
		
		//FOR FULL ADDER
		
		int xa[]={90,400,300,300,300,400};
		int ya[]={120,120,120,380,380,380};
		li[0].drawl(g,xa,ya,3);//a
		
        int xb[]={90,250,250,250,250,400,250,250,250,400};
        int yb[]={220,220,220,150,150,150,220,410,410,410};
        li[1].drawl(g, xb, yb, 5);//b
        
        int xc[]={90,700,700,700,700,900,700,810};
        int yc[]={320,320,320,210,210,210,320,320};
        li[2].drawl(g, xc, yc, 4);           //cin
        
		ga[0].drawXOR(g, 400, 120);
		int xxor1[]={500,700,700,700,700,900,750,750,750,810};
		int yxor1[]={135,135,135,180,180,180,180,290,290,290};
		li[3].drawl(g,xxor1,yxor1,5); //xor1
		
		ga[1].drawXOR(g,900,180);
		li[4].drawl(g,1000,195,1220,195);		//xor2
		
		ga[2].drawAND(g,795,290);
		li[5].drawl(g,825,305,1050,305);		//and1
		
		ga[3].drawAND(g,385,380);
		int xand2[]={415,1000,1000,1000,1000,1050};
		int yand2[]={395,395,395,335,335,335};
		li[6].drawl(g,xand2,yand2,3);//and2
		
		ga[4].drawOR(g,1035,305);
		li[7].drawl(g,1135,320,1220,320);		//or
		
		//FOR HALF ADDER
		    int xd[]={90,403,300,300,300,430};
	        int yd[]={605,605,605,805,805,805};//half adder a
	        li[10].drawl(g,xd,yd,3);
	        
	        int xe[]={90,250,250,250,250,400,250,250,250,430};
	        int ye[]={720,720,720,635,635,635,720,835,835,835};//half adder b
	        li[11].drawl(g1, xe, ye, 5);
	        
		    ga[5].drawXOR(g1, 400, 600);
		    li[8].drawl(g, 500, 615, 700,615);
		
		    ga[6].drawAND(g, 450, 800);
		    li[9].drawl(g, 480, 815, 700,815);
		    
		    
		       l[2].setBackground(li[8].xyz[li[8].c]);
		       l[2].setText(Integer.toString(li[8].c));
		       l[3].setBackground(li[9].xyz[li[9].c]);
		       l[3].setText(Integer.toString(li[9].c));
		       l[0].setBackground(li[4].xyz[li[4].c]);
		        l[0].setText(Integer.toString(li[4].c));
		        l[1].setBackground(li[7].xyz[li[7].c]);
		        l[1].setText(Integer.toString(li[7].c));
		    fTruthTable(g);
		
	}
	public void run(){
		try{
			
               //HALF ADDER
			if(count==0){
				repaint();
			   Thread.sleep(500);
			   li[8].c=(li[10].c%2)^(li[11].c%2);
			   repaint();
			   Thread.sleep(500);
		       li[9].c=(li[10].c%2)&(li[11].c%2);
		       repaint();
		      
		       
			}
		       //FULL ADDER
			if(count==1){
				repaint();
		        Thread.sleep(200);
		        li[3].c= (li[0].c%2)^(li[1].c%2);
		        repaint();
		        Thread.sleep(500);
		        li[4].c= (li[3].c%2)^(li[2].c%2);
		        repaint();
		        Thread.sleep(500);
		        li[5].c= (li[3].c%2)&(li[2].c%2);
		        repaint();
		        Thread.sleep(500);
		        li[6].c= (li[0].c%2)&(li[1].c%2);
		        repaint();
		        Thread.sleep(500);
		        li[7].c= (li[5].c%2)|(li[6].c%2);
		        repaint();
			}
			test=null;
		}
		catch(InterruptedException e){}
	}
	public void update(Graphics g){
		paint(g);
	}
	public void actionPerformed(ActionEvent ae)
	{
        a=(Button)ae.getSource();
		
		if(a==b[0])//if A clicked
		{
			li[0].c++;
			a.setLabel(Integer.toString(li[0].c%2));
			a.setBackground(li[0].xyz[li[0].c%2]);
			count=1;
			//t[m++].start();
		}
		
		else if(a==b[1])
		{
		  li[1].c++;
			a.setLabel(Integer.toString(li[1].c%2));
			a.setBackground(li[1].xyz[li[1].c%2]);
			count=1;
			//t[m++].start();
		}
		
		else if(a==b[2])
		{
			li[2].c++;
			a.setLabel(Integer.toString(li[2].c%2));
			a.setBackground(li[2].xyz[li[2].c%2]);
			count=1;
			//t[m++].start();
		}
		else if(a==b[3]){
			li[10].c++;
			a.setLabel(Integer.toString(li[10].c%2));
			a.setBackground(li[10].xyz[li[10].c%2]);
			count=0;
			
		}
		else if(a==b[4]){
			li[11].c++;
			a.setLabel(Integer.toString(li[11].c%2));
			a.setBackground(li[11].xyz[li[11].c%2]);
			count=0;
			//t[m++].start();
		}
	        
	        
        
       test=new Thread(this);
       test.start();
        
        //FOR FULL ADDER
        
       
        
        
        
       
		
		//repaint();
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
    public void fTruthTable(Graphics g){
    	g.setColor(Color.black);
    	for(int i=60;i<=510;i+=50)
    		g.drawLine(1500, i, 1750, i);
    	for(int j=1500;j<=1750;j+=50)
    		g.drawLine(j, 60, j, 510);
    	g.drawString("A", 1525, 85);
    	g.drawString("B", 1575, 85);
    	g.drawString("Ci", 1610, 85);
    	g.drawString("S", 1660, 85);
    	g.drawString("CO", 1710, 85);
    	 int k=0,l=0;
    	 int c[][]={{0,0,0,0,0},{0,0,1,1,0},{0,1,0,1,0},{0,1,1,0,1},{1,0,0,1,0},{1,0,0,1,0},{1,1,0,0,1},{1,1,1,1,1}};
    	 for(int i=135;i<=485;i+=50){
    		 k=0;
    		 for(int j=1525;j<=1725;j+=50){
                   g.drawString(Integer.toString(c[l][k]), j, i);
                   k++;
    		 }
	                  l++;
                                }
    }
}