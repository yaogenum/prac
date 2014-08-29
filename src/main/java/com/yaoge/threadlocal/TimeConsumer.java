package com.yaoge.threadlocal;

import java.util.ArrayList;
import java.util.List;

class TimeConsumer {  
    // 名称  
    private String name;  
    // 耗时数据列表  
    private List<Long> steps;  
    public TimeConsumer(String name, long start) {  
        this.name = name;  
        steps = new ArrayList<Long>();  
        steps.add(start);  
    }  
    public void andStep(long step) {  
        steps.add(step);  
    }  
    @Override  
    public String toString() {  
        StringBuffer br = new StringBuffer("操作[" + name + "]共有"  
                + (steps.size() - 1) + "步\n");  
        for (int i = 1; i < steps.size(); i++) {  
            br.append("\t|--耗时[" + (steps.get(i) - steps.get(0))  
                    + "ms]\n");  
        }  
        br.append("\n");  
        return br.toString();  
    }  
}  