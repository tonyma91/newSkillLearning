package com.laoma.socket.LiaoTianShi;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
  * @description 服务器类
  * @author majinming@xiaomi.com
  * @date 2021年 03月17日 16:30
  */
 public class Server {
 /**
  * @des 端口号
  */
 private static final int SERVER_PORT = 30000;
 /**
  * @des: 使用ChatroomMap对象来保存每个客户名字和对应输出流之间的对应关系
  */
 public static ChatroomMap<String, PrintStream> clients = new ChatroomMap<>();
  public void init(){
   //自动关闭资源的try语句，
   try(
       //建立监听的ServerSocket
       ServerSocket ss = new ServerSocket(SERVER_PORT))
   {
    //采用死循环来不断地接收来自客户端的请求
    while(true){
     Socket socket = ss.accept();
     new ServerThread(socket).start();
    }
   }//抛出异常
   catch(IOException e){
    System.out.println("服务器启动失败，是否端口" + SERVER_PORT + "被占用");
   }
  }
  public static void main(String[] args){

   Server server = new Server();
   server.init();
  }
 }
