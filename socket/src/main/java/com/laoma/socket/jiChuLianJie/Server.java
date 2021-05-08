package com.laoma.socket.jiChuLianJie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
  * @description 服务端
  * @author majinming@xiaomi.com
  * @date 2021年 03月17日 11:25
  */
 public class Server {

  public static void main(String[] args) throws IOException {

   //创建一个ServerSocket，用于监听客户端Socket的连接请求
   ServerSocket ss = new ServerSocket(30000);
   //采用循环换不断地接收来自客户端的请求
   while (true){
    //每当接收到客户端Socket的请求时，服务器端也对应产生一个Socket
    Socket s = ss.accept();
    //将Socket对应的输出流包装成PrintStream
    PrintStream ps = new PrintStream(s.getOutputStream());
    //进行普通的IO操作
    ps.println("您好，您收到了服务器的问候！");
    //接收来自客户端的消息
    BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(s.getInputStream())
    );
    String str = bufferedReader.readLine();
    System.out.println(str);
    //回应客户端的消息
    ps.println("谢谢．我很好");
    //关闭输出流，关闭Socket
    ps.close();
    s.close();
   }
  }
 }