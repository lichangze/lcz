package com.bmzy.report.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 * FTP上传文件
 * 
 * @author July_whj
 * @param _ftpUrl
 *            ：ftp地址
 * @param _ftpPost
 *            ： 端口：默认21
 * @param _ftpUser
 *            ： 用户名
 * @param _ftpPwd
 *            ： 密码
 * @param _ftpPath
 *            ： 上传路径
 * @param _filePath
 *            ： 本地文件路径
 */
public class FTPUtil {
	private String _ftpUrl;
	private String _ftpPost;
	private String _ftpUser;
	private String _ftpPath;
	private String _ftpPwd;
	private String _filePath;

	/**
	 * FTP上传文件
	 * 
	 * @author July_whj
	 * @param _ftpUrl
	 *            ：ftp地址
	 * @param _ftpPost
	 *            ： 端口：默认21
	 * @param _ftpUser
	 *            ： 用户名
	 * @param _ftpPwd
	 *            ： 密码
	 * @param _ftpPath
	 *            ： 上传路径
	 * @param _filePath
	 *            ： 本地文件路径
	 */
	public FTPUtil(String _ftpUrl, String _ftpPost, String _ftpUser, String _ftpPwd, String _ftpPath,
			String _filePath) {
		this._ftpUrl = _ftpUrl;
		this._ftpPost = _ftpPost;
		this._ftpUser = _ftpUser;
		this._ftpPwd = _ftpPwd;
		this._ftpPath = _ftpPath;
		this._filePath = _filePath;
	}

	public  void upfileload() {
		// 创建客户端对象
		FTPClient ftp = new FTPClient();
		InputStream local = null;
		try {
			// 连接ftp服务器
			ftp.connect(_ftpUrl, Integer.parseInt(_ftpPost));
			// 登录
			ftp.login(_ftpUser, _ftpPwd);
			// 设置上传路径
			// 检查上传路径是否存在 如果不存在返回false
			boolean flag = ftp.changeWorkingDirectory(_ftpPath);
			if (!flag) {
				// 创建上传的路径 该方法只能创建一级目录，在这里如果/home/ftpuser存在则可创建image
				ftp.makeDirectory(_ftpPath);
			}
			// 指定上传路径
			ftp.changeWorkingDirectory(_ftpPath);
			// 指定上传文件的类型 二进制文件
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			// 读取本地文件
			File file = new File(_filePath);
			local = new FileInputStream(file);
			// 第一个参数是文件名
			ftp.storeFile(file.getName(), local);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭文件流
				local.close();
				// 退出
				ftp.logout();
				// 断开连接
				ftp.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		File file = new File("C:/Users/sjsj/Desktop/tadw_zd_kilometer_i_20171011.dat");
		System.out.println(file.getParent());
	}
}
