package com.laoma.socket.jiChuLianJie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
  * @description 客户端
  * @author majinming@xiaomi.com
  * @date 2021年 03月17日 11:41
  */
 public class Client {

  public static void main(String[] args) throws IOException {
   //其中“1227.0.0.1”代表本机的IP地址，因为服务端和客户端都是在本机运行
   Socket socket = new Socket("127.0.0.1", 30000);
   int i = socket.getLocalPort();
   int j = socket.getPort();
   System.out.println("getLocalPort"+i);
   System.out.println("getPort"+j);
   //将Socket对应的输入流包装成BufferedReader
   BufferedReader br = new BufferedReader(
           new InputStreamReader(socket.getInputStream()));
   //进行普通IO操作
   String line = br.readLine();
   System.out.println("来自服务器的数据:" + line);
   //向服务端打招呼
   Scanner input = new Scanner(System.in);
   PrintStream printStream = new PrintStream(socket.getOutputStream());
   printStream.println(input.nextLine());
   //等待服务端的回应
   System.out.println(br.readLine());
   input.close();
   //关闭输入流，关闭输出流关闭Socket
   br.close();
   printStream.close();
   socket.close();
  }
 }
