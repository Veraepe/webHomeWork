package dao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CreateImage {
	
	private static final int width=100;
	private static final int height=40;
	private static final int length=4;//���ɵ�����������ݳ���
	private static final int linecount=20;
	
	private static final String str="23456789"
									+"qwertyupasdfghjkzxcvbnm"
									+"QWERTYUPASDFGHJKLZXCVBNM";
	private static Random rom=new Random();
	
	public CreateImage()
	{
		
	}
	
	public String genreateRancode()//����string���͵������
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
	
	public void drawChar(Graphics g,String code)//�����ַ�
	{
		g.setFont(getFont());
		for(int i=0;i<this.length;i++)
		{
			char c=code.charAt(i);
			g.setColor(getColor());
			g.drawString(c+"",20*i+20,20);
			//�����ַ�
			//            string x y
		}
	}
	
	public void drawLine(Graphics g)
	{
		int x=this.rom.nextInt(this.width);
		int y=this.rom.nextInt(this.height);
		int xl=this.rom.nextInt(10);
		int yl=this.rom.nextInt(10);//y�ĵڶ�������
				//g.drawline
		g.setColor(getColor());
		g.drawLine(x, y, x+xl, y+yl);
		
	}
	
	public BufferedImage Createimg(String code)//�����ɵ�code���뵽�ú����У��������ͼƬ
	{
		BufferedImage img=new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		Graphics g=img.getGraphics();//��ȡ���� ���g����ָ��
		//���ñ�����ɫ
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.width, this.height);//����ͼƬ�ľ���
		drawChar(g, code);
		drawLine(g);
		g.dispose();
		//��Ȼ�����Ϳ��Թ�����img
		return img;
	}
	
	
	
	
	
}
