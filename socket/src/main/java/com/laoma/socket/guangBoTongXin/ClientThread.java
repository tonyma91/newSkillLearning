package com.laoma.socket.guangBoTongXin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
  * @description 客户端线程：
  * @author majinming@xiaomi.com
  * @date 2021年 03月17日 11:58
  */
 public class ClientThread implements Runnable{
 /**
  * @des 该线程负责处理的Socket
  */
  private Socket s;
 /**
  * @des: 该线程所处理的Socket对应的输入流
 */
  BufferedReader br = null;
  public ClientThread(Socket s) throws IOException {
   this.s = s;
   br = new BufferedReader(new InputStreamReader(s.getInputStream()));
  }
  @Override
  public void run(){
   try{
    String content = null;
    //不断地读取Socket输入流中的内容，并将这些内容打印输出
    while ((content = br.readLine()) != null){
     System.out.println(content);
    }
   }catch (Exception e){
    e.printStackTrace();
   }

  }
 }
