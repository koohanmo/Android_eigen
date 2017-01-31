package com.tistory.coderkoo.androideigen.model;

/**
 * Created by koohanmo on 2017-01-31.
 */

public class EigenOperation {
    private String op;
    private String desc;
    private Class<?> mClass;

    public EigenOperation(String op, String desc, Class<?> mClass){
        this.op = op;
        this.desc=desc;
        this.mClass=mClass;
    }

    public String getOp() {
        return op;
    }

    public String getDesc() {
        return desc;
    }

    public Class<?> getmClass() {
        return mClass;
    }
}