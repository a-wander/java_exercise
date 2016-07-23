package com.zhy.testftpclient;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.net.SocketException;
//
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.IOUtils;
//import org.apache.commons.net.ftp.FTPClient;
//import org.apache.commons.net.ftp.FTPClientConfig;
//import org.apache.commons.net.ftp.FTPFile;
//import org.apache.commons.net.ftp.FTPReply;
//
//
//public class TestClient {
//    private FTPClient ftpClient = new FTPClient();
//    private OutputStream outSteam = null;
// 
//    /**
//     * ftp服务器地址
//     */
//    private String hostName = "localhost";
//    private int port = 2121;
// 
//    /**
//     * 登录名\登录密码\需要访问的远程目录
//     */
//    private String userName = "admin";//匿名登录，空字符串不行
//    private String password = "123";//随便一个地址
//    private String remoteDir = "./";
// 
//    /**
//     * 下载
//     */
//    private void download() {
//        try {
//            // 链接到ftp服务器
//            ftpClient.connect(hostName,port);
//            System.out.println("连接到ftp服务器：" + hostName + " 成功..开始登录");
//            // 登录.用户名 密码
//            boolean b = ftpClient.login(userName, password);
//            System.out.println("登录成功:" + b);
//             
////          检测连接是否成功
//            int reply = ftpClient.getReplyCode();
//            if(!FTPReply.isPositiveCompletion(reply)) {
//                ftpClient.disconnect();
//                System.err.println("FTP server refused connection.");
//                System.exit(1);
//            }
//             
//            ftpClient.setControlEncoding("GBK");
//            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT); 
//            conf.setServerLanguageCode("zh");
//            FTPFile[] remoteFiles = ftpClient.listFiles(remoteDir);
//            if (remoteFiles != null) {
//                for (int i = 0; i < remoteFiles.length; i++) {
//                    String name = remoteFiles[i].getName();
//
//                    //下载
//                    File localFile = new File("e:\\" + name);
//                    OutputStream is = new FileOutputStream(localFile);
//                    //retrieveFile的第一个参数需要是 ISO-8859-1 编码,并且必须是完整路径！
//                    String fileName = remoteDir + name;
//                    ftpClient.retrieveFile(new String(fileName.getBytes("GBK"),"ISO-8859-1"), is);
//                    is.close();
//
//                    //打印
//                    long length = remoteFiles[i].getSize();
//                    String readableLength = FileUtils.byteCountToDisplaySize(length);
//                    System.out.println(name + ":\t"+remoteFiles[i].isFile()+"\t" + readableLength);
//                }
//            }
// 
//            ftpClient.logout();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            IOUtils.closeQuietly(outSteam);
//            try {
//                ftpClient.disconnect();
//            } catch (IOException ioe) {
//                ioe.printStackTrace();
//            }
//        }
//    }
//     
//    /**
//     * 上传
//     * */
//    public void upload(){
//        String srcUrl = "e://a.txt";
//        String targetFileName = "安之畅资料.doc";
//        try {
//            ftpClient.connect(hostName,port);
//            boolean b = ftpClient.login(userName, password);
//            // 检测连接是否成功
//            int reply = ftpClient.getReplyCode();
//            if (!FTPReply.isPositiveCompletion(reply)) {
//                ftpClient.disconnect();
//                System.err.println("FTP server refused connection.");
//                System.exit(1);
//            }
//             
//            ftpClient.setControlEncoding("GBK");
//            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT); 
//            conf.setServerLanguageCode("zh");
//             
//            File srcFile = new File(srcUrl);
//            FileInputStream fis = null;
//            fis = new FileInputStream(srcFile);
// 
//            // 设置上传目录
//            ftpClient.changeWorkingDirectory(remoteDir);
//            ftpClient.setBufferSize(1024);
//            ftpClient.setControlEncoding("GBK");
// 
//            // 设置文件类型（二进制）
//            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
//            // 上传
//            b = ftpClient.storeFile(targetFileName, fis);
//            IOUtils.closeQuietly(fis);
//
//            /*boolean bool = ftpClient.changeWorkingDirectory("/NC");
//            System.out.println("changeWorkingDirectory="+bool);
//            bool = ftpClient.makeDirectory("/NC");
//            System.out.println("makeDirectory="+bool);*/
//
//            ftpClient.logout();
//        } catch (SocketException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally{
//            try {
//                ftpClient.disconnect();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//         
//    }
// 
//    /**
//     * 测试
//     * */
//    public static void main(String[] args) {
//    	TestClient listFtpfiles = new TestClient();
//        listFtpfiles.download();
//        listFtpfiles.upload();
//    }
//}

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class TestClient {
    private FTPClient ftp;
    /**
     * @param path     上传到ftp服务器哪个路径下
     * @param addr     地址
     * @param port     端口号
     * @param username 用户名
     * @param password 密码
     * @return
     * @throws Exception
     */
    private boolean connect(String path, String addr, int port, String username, String password) throws Exception {
        boolean result = false;
        ftp = new FTPClient();
        int reply;
        ftp.connect(addr, port);
        Boolean blogin = ftp.login(username, password);
        if (!blogin){
        	System.out.println("login error");
        	System.out.println(ftp.getReplyString());
        	return false;
        }
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            System.out.println(ftp.getReplyString());
            return result;
        }
        ftp.changeWorkingDirectory(path);
        result = true;
        return result;
    }

    /**
     * @param file 上传的文件或文件夹
     * @throws Exception
     */
    private void upload(File file) throws Exception {
        if (file.isDirectory()) {
            ftp.makeDirectory(file.getName());
            ftp.changeWorkingDirectory(file.getName());
            String[] files = file.list();
            for (int i = 0; i < files.length; i++) {
                File file1 = new File(file.getPath() + "\\" + files[i]);
                if (file1.isDirectory()) {
                    upload(file1);
                    ftp.changeToParentDirectory();
                } else {
                    File file2 = new File(file.getPath() + "\\" + files[i]);
                    FileInputStream input = new FileInputStream(file2);
                    ftp.storeFile(file2.getName(), input);
                    input.close();
                }
            }
        } else {
            File file2 = new File(file.getPath());
            FileInputStream input = new FileInputStream(file2);
            ftp.storeFile(file2.getName(), input);
            input.close();
        }
    }

//下载
	public void downLoad(String ftpFile, String dstFile) throws IOException {
		File file = new File(dstFile);
		FileOutputStream fos = new FileOutputStream(file);
		if (!ftp.retrieveFile(ftpFile, fos)) {
			System.out.println(ftp.getReplyString());
		}
		fos.close();
	}

    public static void main(String[] args) throws Exception {
    	TestClient t = new TestClient();
        if (t.connect("", "123.57.236.81", 21, "fileser", "newbee-wgx")) {
        	File file = new File("E:\\a.txt");
            t.upload(file);
            t.downLoad("README.txt", "E:\\b.txt");
        }
    }
}