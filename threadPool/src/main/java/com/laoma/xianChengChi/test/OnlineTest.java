//package com.laoma.xianChengChi.test;
///**
// * @author majinming@xiaomi.com
// * @description
// * @date 2021年 03月31日 15:14
// */
//import com.laoma.xianChengChi.test.onLineTest.VideoUtil;
//import lx.jave.AudioAttributes;
//import lx.jave.AudioInfo;
//import lx.jave.Encoder;
//import lx.jave.EncoderException;
//import lx.jave.EncodingAttributes;
//import lx.jave.InputFormatException;
//import lx.jave.MultimediaInfo;
//import lx.jave.VideoInfo;
//import lx.jave.VideoSize;
//import org.apache.commons.codec.digest.DigestUtils;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.ProtocolException;
//import java.net.URL;
//
//
///**
//     * jave多媒体工具类（需导出jave  jar包）
//     * @author longxiong
//     *
//     */
//    public class OnlineTest {
//
//        public static void main(String[] args) {
//
//
//            URL url = null;
//            try {
//                url = new URL("https://video.youpin.mi-img.com/goods_video/a0a2b9cc1073565fdef40c553b848eb8.mp4");
//            } catch (MalformedURLException malformedURLException) {
//                malformedURLException.printStackTrace();
//            }
//            HttpURLConnection connection = null;
//            ;
//            try (InputStream inputStream = connection.getInputStream();){
//
//                connection = (HttpURLConnection) url.openConnection();
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//            try {
//                connection.setRequestMethod("GET");
//            } catch (ProtocolException e) {
//                e.printStackTrace();
//            }
//            connection.setConnectTimeout(5 * 1000);
//            try{
//            InputStream inputStream = connection.getInputStream();
////            } catch (IOException ioException) {
////                ioException.printStackTrace();
////            }
////                    ;) {
////            try {
//                System.out.println(DigestUtils.md5Hex(inputStream));
////            } catch (IOException ioException) {
////                ioException.printStackTrace();
////            }
////            try {
//                inputStream.close();
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
////            }catch (Exception ioException){
////                thr/ow new RuntimeException("链接失败");
////                System.out.println("");
////            }finally {
//
////            }
////            catch (Exception e){
////                System.out.println("链接时报");
////            }
//
//
//        }
//    }
