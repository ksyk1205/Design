package com.company.design.facade;

public class Writer {

    private String fileName;
    public Writer(String fileName){
        this.fileName =fileName;
    }
    public void fileConnect(){
        String msg = String.format("Writer %s 로 연결 합니다." ,fileName);
        System.out.println(msg);
    }
    public void fileDisConnect(){
        String msg = String.format("Writer %s 로 연결 종료합니다." ,fileName);
        System.out.println(msg);
    }
    public void writer(){
        String msg = String.format("Writer %s 로 파일쓰기를 합니다." ,fileName);
        System.out.println(msg);
    }
}
