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
//     * ftp��������ַ
//     */
//    private String hostName = "localhost";
//    private int port = 2121;
// 
//    /**
//     * ��¼��\��¼����\��Ҫ���ʵ�Զ��Ŀ¼
//     */
//    private String userName = "admin";//������¼�����ַ�������
//    private String password = "123";//���һ����ַ
//    private String remoteDir = "./";
// 
//    /**
//     * ����
//     */
//    private void download() {
//        try {
//            // ���ӵ�ftp������
//            ftpClient.connect(hostName,port);
//            System.out.println("���ӵ�ftp��������" + hostName + " �ɹ�..��ʼ��¼");
//            // ��¼.�û��� ����
//            boolean b = ftpClient.login(userName, password);
//            System.out.println("��¼�ɹ�:" + b);
//             
////          ��������Ƿ�ɹ�
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
//                    //����
//                    File localFile = new File("e:\\" + name);
//                    OutputStream is = new FileOutputStream(localFile);
//                    //retrieveFile�ĵ�һ��������Ҫ�� ISO-8859-1 ����,���ұ���������·����
//                    String fileName = remoteDir + name;
//                    ftpClient.retrieveFile(new String(fileName.getBytes("GBK"),"ISO-8859-1"), is);
//                    is.close();
//
//                    //��ӡ
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
//     * �ϴ�
//     * */
//    public void upload(){
//        String srcUrl = "e://a.txt";
//        String targetFileName = "��֮������.doc";
//        try {
//            ftpClient.connect(hostName,port);
//            boolean b = ftpClient.login(userName, password);
//            // ��������Ƿ�ɹ�
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
//            // �����ϴ�Ŀ¼
//            ftpClient.changeWorkingDirectory(remoteDir);
//            ftpClient.setBufferSize(1024);
//            ftpClient.setControlEncoding("GBK");
// 
//            // �����ļ����ͣ������ƣ�
//            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
//            // �ϴ�
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
//     * ����
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
     * @param path     �ϴ���ftp�������ĸ�·����
     * @param addr     ��ַ
     * @param port     �˿ں�
     * @param username �û���
     * @param password ����
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
     * @param file �ϴ����ļ����ļ���
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

//����
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