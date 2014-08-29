package com.yaoge.threadlocal;

class MyThreadLocal {  
    // 用于全局记录user访问权限  
    private ThreadLocal<User> userLocal;  
    // 用于全局记录用户每一步的耗时  
    private ThreadLocal<TimeConsumer> timeLocal;  
    private static MyThreadLocal local = new MyThreadLocal();  
    private MyThreadLocal() {  
        userLocal = new ThreadLocal<User>();  
        timeLocal = new ThreadLocal<TimeConsumer>();  
    }  
    public static MyThreadLocal getInstanse() {  
        return local;  
    }  
    public void addUser(User user) {  
        userLocal.set(user);  
    }  
    public User getUser() {  
        return userLocal.get();  
    }  
    public void addTime(TimeConsumer timeConsumer) {  
        timeLocal.set(timeConsumer);  
    }  
    public void addTime(long l) {  
        TimeConsumer time = timeLocal.get();  
        timeLocal.remove();  
        time.andStep(l);  
        timeLocal.set(time);  
    }  
    public TimeConsumer getTime() {  
        return timeLocal.get();  
    } 
    public void opt_file(){
    	if(userLocal.get()!=null) {
    		userLocal.get().opt_file();
    	}
    }
}  
