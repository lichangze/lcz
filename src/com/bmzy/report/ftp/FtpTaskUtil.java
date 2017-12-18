package com.bmzy.report.ftp;

import org.springframework.beans.factory.annotation.Value;
/**
 * FTP任务标签
 * @author July_whj
 *
 */
public class FtpTaskUtil {
	@Value("${ftp.url}")
	public String _ftpUrl;
	@Value("${ftp.post}")
	public String _ftpPost;
	@Value("${ftp.user}")
	public String _ftpUser;
	@Value("${ftp.pwd}")
	public String _ftpPwd;
	@Value("${ftp.ener.path}")
	public String _enerftpPath;
	@Value("${ftp.file.path}")
	public String _filePath;
	
	/**
	 * 能耗
	 */
	@Value("${ener}")
	public  String ener;
	
	
	
	
	
}
