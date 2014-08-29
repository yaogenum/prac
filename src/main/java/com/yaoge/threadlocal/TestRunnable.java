package com.yaoge.threadlocal;
class TestRunnable implements Runnable {  
    String name;  
    long l;  
    boolean isAllow;  
  TestRunnable(String name, long l, boolean isAllow) {  
        this.name = name;  
        this.l = l;  
        this.isAllow = isAllow;  
    }  
    public void run() {  
        MyThreadLocal local = MyThreadLocal.getInstanse();  
        local.addUser(new User(name, isAllow));  
        local.addTime(new TimeConsumer(name, System.currentTimeMillis()));  
        // 做某个业务，并记录时间  
        doThings(l);  
        local.addTime(System.currentTimeMillis());  
        local.opt_file();
        // 做某个业务，并记录时间  
        doThings(l);  
        local.addTime(System.currentTimeMillis());  
        // 业务做完，打印日志  
        System.out.println(local.getUser());  
        System.out.println(local.getTime());  
    }  
    // 模拟具体业务的处理步骤  
    private void doThings(long l) {  
        try {  
            Thread.sleep(l);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }  
}  