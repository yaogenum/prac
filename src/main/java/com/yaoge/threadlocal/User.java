package com.yaoge.threadlocal;
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
}  

