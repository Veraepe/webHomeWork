package dao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CreateImage {
	
	private static final int width=100;
	private static final int height=40;
	private static final int length=4;//生成的码的数据内容长度
	private static final int linecount=20;
	
	private static final String str="23456789"
									+"qwertyupasdfghjkzxcvbnm"
									+"QWERTYUPASDFGHJKLZXCVBNM";
	private static Random rom=new Random();
	
	public CreateImage()
	{
		
	}
	
	public String genreateRancode()//产生string类型的随机码
	{
		String code="";
		for(int i=0;i<this.length;i++)
		{
			char c=this.str.charAt(this.rom.nextInt(this.length));
			code+=c;
		}
		return code;
	}
	
	
	public Color getColor()
	{
		Color c=new Color(this.rom.nextInt(255),this.rom.nextInt(255),this.rom.nextInt(255));
		return c;
	}
	
	public Font getFont()
	{
		return new Font("Fixedsys",Font.CENTER_BASELINE,22);
	}
	
	public void drawChar(Graphics g,String code)//绘制字符
	{
		g.setFont(getFont());
		for(int i=0;i<this.length;i++)
		{
			char c=code.charAt(i);
			g.setColor(getColor());
			g.drawString(c+"",20*i+20,20);
			//绘制字符
			//            string x y
		}
	}
	
	public void drawLine(Graphics g)
	{
		int x=this.rom.nextInt(this.width);
		int y=this.rom.nextInt(this.height);
		int xl=this.rom.nextInt(10);
		int yl=this.rom.nextInt(10);//y的第二个坐标
				//g.drawline
		g.setColor(getColor());
		g.drawLine(x, y, x+xl, y+yl);
		
	}
	
	public BufferedImage Createimg(String code)//将生成的code输入到该函数中，最后生成图片
	{
		BufferedImage img=new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		Graphics g=img.getGraphics();//获取画笔 这个g很像指针
		//设置背景颜色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.width, this.height);//生成图片的矩形
		drawChar(g, code);
		drawLine(g);
		g.dispose();
		//竟然这样就可以关联了img
		return img;
	}
	
	
	
	
	
}
