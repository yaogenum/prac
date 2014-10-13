package com.yaoge.jnitest;

public class HelloWorld {
	  public native void SayHello(String name);

	    static
	    {
	        System.loadLibrary("examdll");
	    }

	    public static void main(String [] args)
	    {
	        HelloWorld hello = new HelloWorld();
	        hello.SayHello("myName");
	    }
	
}
