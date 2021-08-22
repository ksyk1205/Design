package com.company.design;

import com.company.design.adapter.Cleaner;
import com.company.design.adapter.Electronic100V;
import com.company.design.adapter.HairDryer;
import com.company.design.adapter.SocketAdapter;
import com.company.design.aop.AopBrowser;
import com.company.design.decorator.*;
import com.company.design.facade.Ftp;
import com.company.design.facade.Reader;
import com.company.design.facade.SftpClient;
import com.company.design.facade.Writer;
import com.company.design.observer.Button;
import com.company.design.observer.IButtonListener;
import com.company.design.proxy.Browser;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.IBrowser;
import com.company.design.singleton.Aclazz;
import com.company.design.singleton.Bclazz;
import com.company.design.singleton.SocketClient;
import com.company.design.strategy.*;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;


public class Main {

    public static void main(String[] args) {
        //전략패턴
        Encoder encoder = new Encoder(); //사용하기위한 기본 객체

        //base64
        EncodingStrategy base64 = new Base64Strategy();

        //normal
        EncodingStrategy normal = new NormalStrategy();

        String message = "hello.java";

        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);

        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);

        /* 파사드 패턴
        Ftp ftpClient = new Ftp("www.foo.co.kr",22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.writer();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisConnect();
        writer.fileDisConnect();
        ftpClient.disConnect();

        SftpClient sftpClient = new SftpClient("www.foo.co.kr",22,"/home/etc","text.tmp");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();*/


        /* 옵저버 패턴
        Button button = new Button("버튼");
        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });

        button.click("메세지 전달 : click1");
        button.click("메세지 전달 : click2");
        button.click("메세지 전달 : click3");
        button.click("메세지 전달 : click4");*/

       /* 데코레이터 패턴
        ICar audi = new Audi(1000);
        audi.showPrice();

        //a3
        ICar audi3 = new A3(audi,"A3");
        audi3.showPrice();
        //a4
        ICar audi4 = new A4(audi,"A4");
        audi4.showPrice();
        //a5
        ICar audi5 = new A5(audi,"A5");
        audi5.showPrice();*/

        /* Aop 프록시 패턴
       //시간 체크
        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                () ->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()->{
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
        );
        aopBrowser.show();
        System.out.println("looading time : "+end.get());

        aopBrowser.show();
        System.out.println("looading time : "+end.get());*/

       /* 프록시 패턴
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();

        IBrowser browser = new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        */
        /* 싱글톤 패턴
        Aclazz aclazz = new Aclazz();
        Bclazz bclazz = new Bclazz();

        SocketClient aClient = aclazz.getSocketClient();
        SocketClient bClient = bclazz.getSocketClient();

        System.out.println("두 개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));
         */
        /* 어댑터 패턴
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic100V adapter = new SocketAdapter(cleaner);
        connect(adapter);
         */
    }

    //콘센트
    public static void connect(Electronic100V electronic100V){
        electronic100V.powerOn();
    }
}
