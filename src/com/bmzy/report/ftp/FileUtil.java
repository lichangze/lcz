package com.bmzy.report.ftp;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import com.bmzy.report.model.FileRecordEntity;
/**
 * @author July_whj
 *
 */
public class FileUtil {
	// 文件路径+名称
	private static String filenameTemp;
	static DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
	static DateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
	static char FIELD_SPR = 0x01; // 十六进制分隔符
	static String LINE_SPR = "\n"; // 换行符
	static String FIELD = " ";

	/**
	 * 创建文件
	 * 
	 * @param fileName
	 *            文件名称
	 * @param filecontent
	 *            文件内容
	 * @return 是否创建成功，成功则返回文件名+路径
	 */
	public static String createFile(String fileName) {
		File file = new File(fileName);
		try {
			// 如果文件不存在，则创建新的文件
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("success create file,the file is " + filenameTemp);
				// 创建文件成功后，写入内容到文件里
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return filenameTemp;
	}

	/**
	 * 删除文件
	 * 
	 * @param filePath
	 *            文件路径
	 * @return
	 */
	public static boolean delFile(String filePath) {
		Boolean bool = false;
		File file = new File(filePath);
		try {
			if (file.exists()) {
				file.delete();
				bool = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bool;
	}

	/**
	 * 追加文件：使用FileWriter
	 * 
	 * @param fileName
	 * @param content
	 */
	public static void method2(String fileName, String content) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(fileName, true);
			writer.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	

	/**
	 * @param fileName
	 *            被校验文件名称
	 * @param tableName
	 *            表名
	 * @param sum
	 *            条数
	 * @return FileRecordEntity
	 */
	public static FileRecordEntity fileCheckChk(String filePath, String tableName, int sum) {
		FileRecordEntity entity = new FileRecordEntity();
		String system = "/tadw_";
		String checkPath = "";
		File file = new File(filePath);
		String fileName = file.getName();
		System.out.println("wenj"+fileName);
		fileName = fileName.replace(".dat",".chk");
		String fileDate = formatDate.format(new Date());
		checkPath = file.getParent() + "/" + fileName;
		long modifiedTime = file.lastModified();
		Date d = new Date(modifiedTime);
		String date = format.format(d);
		//checkPath = file.getParent() + fileName;
		method2(checkPath, file.getName() + FIELD + file.length() + FIELD + sum + FIELD + date + LINE_SPR);
		entity.setFileName(file.getName());
		entity.setFilePath(filePath);
		entity.setFileSize(file.length());
		entity.setFileTime(d);
		entity.setCheckFilePath(checkPath);
		entity.setIp(getIP());
		entity.setCreateTime(new Date());
		entity.setDataRecords(sum);
		return entity;
	}

	
	public static FileRecordEntity fileCheckChk2(String filePath, String tableName, int sum) {
		FileRecordEntity entity = new FileRecordEntity();
		String system = "/tadw_";
		String checkPath = "";
		File file = new File(filePath);
		String fileName = file.getName();
		System.out.println("wenj"+fileName);
		fileName = fileName.replace(".dat",".chk");
		String fileDate = formatDate.format(new Date());
		checkPath = file.getParent()  + "/"+ fileName;
		long modifiedTime = file.lastModified();
		Date d = new Date(modifiedTime);
		String date = format.format(d);
		method2(checkPath, file.getName() + FIELD + file.length() + FIELD + sum + FIELD + date + LINE_SPR);
		entity.setFileName(file.getName());
		entity.setFilePath(filePath);
		entity.setFileSize(file.length());
		entity.setFileTime(d);
		entity.setCheckFilePath(checkPath);
		entity.setIp(getIP());
		entity.setCreateTime(new Date());
		entity.setDataRecords(sum);
		return entity;
	}
	public static FileRecordEntity fileCheckChk3(String filePath, String tableName, int sum) {
		FileRecordEntity entity = new FileRecordEntity();
		String system = "/tadw_";
		String checkPath = "";
		File file = new File(filePath);
		String fileDate = formatDate.format(new Date());
		CreateFile cf = new CreateFile();
		
		checkPath = file.getParent() + system + tableName +'_'+ 'i'+'_'+fileDate + ".chk";
		long modifiedTime = file.lastModified();
		
		Date d = new Date(modifiedTime);
		String date = format.format(d);
		method2(checkPath, file.getName() + FIELD + file.length() + FIELD + sum + FIELD + date + LINE_SPR);
		entity.setFileName(file.getName());
		entity.setFilePath(filePath);
		entity.setFileSize(file.length());
		entity.setFileTime(d);
		entity.setCheckFilePath(checkPath);
		entity.setIp(getIP());
		entity.setCreateTime(new Date());
		entity.setDataRecords(sum);
		return entity;
	}
	public  static String getIP() {
		Enumeration<NetworkInterface> allNetInterfaces;
		String str = null;
		try {
			allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			InetAddress ip = null;
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
				Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					ip = (InetAddress) addresses.nextElement();
					if (ip != null && ip instanceof Inet4Address) {
						str =  ip.getHostAddress();
						return str;
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return str;
	}

}
