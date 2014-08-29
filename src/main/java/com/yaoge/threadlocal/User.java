package com.yaoge.threadlocal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class User {  
    private String name;  
    private boolean isAllow;  
    public User(String name, boolean isAllow) {  
        this.name = name;  
        this.isAllow = isAllow;  
    }  
    public String getName() {  
        return name;  
    }  
    public boolean isAllow() {  
        return isAllow;  
    }  
    @Override  
    public String toString() {  
        return "用户名：" + name + "\t 是否允许访问：" + isAllow;  
    }
    public void opt_file() {
    	File file =new File("D:/distest.txt");
    	//File file2 =new File("D:/"+name+".txt");//观察threadlocal对于文件的操作情况，最后的效果如通同步控制一样，是作为同步控制同一层面的解决办法但是说具体到文件下面依旧是抛给操作系统去解决类似文件的问题，依然是竞争，进行同步控制，所以threadlocal适用于单一模式下的轻对象且只需要操作副本
    	File file2 =new File("D:/distest2.txt");
    	try {
			FileInputStream fileinput = new FileInputStream(file);
			FileOutputStream fileout = new FileOutputStream(file2,true);
			
			byte bytes[] = new byte[1024];
			int flag=0;
			try {
				while((flag=fileinput.read(bytes))!=-1) {
					
					System.out.println("用户名：" + name +":"+new String(bytes));
					fileout.write(("用户名：" + name).getBytes("utf-8") );
					String s = new String(bytes).trim();
					fileout.write(s.getBytes("utf-8"));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				if(fileout!=null) {
					try {
						fileinput.close();
						fileout.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }	
}  

