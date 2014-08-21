package com.yaoge.prac.prac;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class Niotest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Niotest test=new Niotest();
		test.newio();
		System.out.println("ok");
		
	}
	
	
	public void directnio() {
		File file=new File("D:/test.txt");
		FileChannel fc=null;
		FileInputStream input=null;
		
		File disfile=new File("D:/distest.txt");
		FileChannel disfc=null;
		FileOutputStream output=null;
		
		try {
			input=new FileInputStream(file);
			fc=input.getChannel();
			
			output=new FileOutputStream(disfile);
			disfc=output.getChannel();
			
			try {
				
				ByteBuffer buffer=ByteBuffer.allocateDirect((int)fc.size());
				
				while(fc.read(buffer)!=-1){
					buffer.flip();
					disfc.write(buffer);
					//buffer.clear();
					buffer.clear();
					System.out.println("2");
				}
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(fc!=null){
				try {
					fc.close();
					disfc.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(input!=null){
				try {
					input.close();
					output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		System.out.println("ok");
		
		
		
	}
	
	public void mapnio() throws IOException {
		File file=new File("D:/test.txt");
		FileChannel fc=null;
		FileInputStream input=null;
		
		File disfile=new File("D:/distest.txt");
		FileChannel disfc=null;
		FileOutputStream output=null;
		
		try {
			input=new FileInputStream(file);
			fc=input.getChannel();
			
			output=new FileOutputStream(disfile);
			disfc=output.getChannel();
			
			try {
				ByteBuffer buffer=fc.map(FileChannel.MapMode.READ_ONLY, 0,fc.size());
				//byte bytes[]=new byte[(int) (fc.size()/4)];
				//disfc.write(buffer.get(bytes));
				//while(buffer.hasRemaining()) {
					//disfc.write(ByteBuffer.wrap(null, buffer.getChar(), 0));
				//}
				disfc.write(buffer);
				System.out.println();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(fc!=null){
				try {
					fc.close();
					disfc.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(input!=null){
				input.close();
				output.close();
			}
		}
		System.out.println("ok");
		
		
	}
	
	public void oldchar(){
		File file=new File("D:/test.txt");
		FileInputStream input=null;
		try{
			input=new FileInputStream(file);
			StringBuilder b=new StringBuilder();
			int postion;
			while((postion=input.read())!=-1){
				b.append((char)postion);
			}
			System.out.print(new String(b.toString().getBytes("ISO-8859-1"),"utf-8"));
			
		}
		catch(Exception e) {
			
		}
		finally{
			if(input!=null){
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 这里是使用io进行操作输出测试
	 * 
	 * @author Administrator
	 * @return no
	 * @param no
	 * @exception IOException
	 * 
	 */
	public void oldio(){
		File file=new File("D:/test.txt");
		File newfile =new File ("D:/newtest.txt");
		
		FileInputStream input=null;
		FileOutputStream output=null;
		
		try{
			//这里我的文本很小，使用1024一下就可以读取完，所以使用16（大本文我也试了也不行，并不是网上说的1024可以正确读取每个内容单元）
			int size=16;
			input=new FileInputStream(file);
			output=new FileOutputStream(newfile);
			
			byte bytes[]=new byte[size];
			int postion;
			while((postion=input.read(bytes))!=-1){
				//这里读取，也在输出，会出现间接乱码
				output.write(bytes,0,postion);
				System.out.println(new String(bytes,0,postion));//这里应该不是编码问题，我曾也设置了ISO-8859-1---->UTF-8
			}
			
			
		}
		catch(Exception e) {
			try {
				System.err.println(new String(e.toString().getBytes("ISO-8859-1"),"UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally{
			if(input!=null){
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.err.println(e.toString());
				}
			}
			if(output!=null){
				try {
					output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.err.println(e.toString());
				}
			}
		}
		
	}
	
	public void newio() throws IOException{
		File file=new File("D:/test.txt");
		if(file.exists()) {
			
		}
		else{
			file.createNewFile();
		}
		FileChannel fchannel=null;
		FileInputStream finput=null;
		try {
			finput=new FileInputStream(file);
			
			fchannel=finput.getChannel();
			
			ByteBuffer buffer=ByteBuffer.allocate(20);
			
			int length;
			
			while((length=fchannel.read(buffer))!=-1){
				
				System.out.println(length+":"+new String(buffer.array(),0,length,"UTF-8"));
				
				buffer.clear();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(fchannel!=null){
				fchannel.close();
			}
			if(finput!=null){
				finput.close();
			}
		}
		
	}

}
