package com.haier.m.service.item.impl;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

import org.apache.log4j.Category;
import org.apache.log4j.FileAppender;
import org.springframework.stereotype.Service;

import com.haier.common.ServiceResult;
import com.haier.m.service.item.ItemLogService;

@Service("itemLogService")
public class ItemLogServiceImpl implements ItemLogService {
	private static org.apache.log4j.Logger log = org.apache.log4j.LogManager.getLogger(ItemLogServiceImpl.class);

	@Override
	public ServiceResult<List> getLog(Integer startLine, Integer endLine, String prefix, String suffix, String search) {
		ServiceResult<List> s = new ServiceResult<List>();
		String CONFIG_DIR = "/conf/";

		Category tempLogger = log;
		List<File> l = new ArrayList<File>();

		try {
			while (tempLogger != null) {
				Enumeration enumer = tempLogger.getAllAppenders();

				while (enumer.hasMoreElements()) {
					Object obj = enumer.nextElement();
					if (FileAppender.class.isAssignableFrom(obj.getClass())) {
						File file = new File(prefix + ((FileAppender) obj).getFile() + suffix);
						if (file.exists()) {
							l.add(file);
						}
					}
				}
				tempLogger = tempLogger.getParent();
			}

			StringBuffer sb = new StringBuffer();
			Map<String, Integer> map = new HashMap<String, Integer>();

			InetAddress addr = null;
			try {
				addr = InetAddress.getLocalHost();
				String ip = addr.getHostAddress().toString();// 获得本机IP
				String host = addr.getHostName().toString();// 获得本机名称
				sb.append("Response Server IP:" + ip + ",Response Host Name [" + host + "]\r\n");
			} catch (UnknownHostException e1) {
				log.error(e1);
			}

			for (File f : l) {
				BufferedReader br = null;
				if (map.get(f.getAbsolutePath()) == null) {
					map.put(f.getAbsolutePath(), 1);
				} else {
					continue;
				}
				try {
					br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
					String line = "";
					int lineNum = 0;
					while ((line = br.readLine()) != null) {
						if (lineNum >= startLine && (lineNum <= endLine || endLine <= 0)) {
							if ((search != null && !search.trim().equalsIgnoreCase("") && line.contains(search))
									|| search == null) {
								sb.append(lineNum + "\t" + line + "\n");
							}
						}
						if (lineNum > endLine && endLine >= 0) {
							break;
						}
						lineNum++;
					}
				} catch (FileNotFoundException e) {
					sb.append(e.getMessage());
				} catch (IOException e) {
					sb.append(e.getMessage());
				} finally {
					try {
						if (br != null)
							br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

					sb.append("\n\n\n\n\n\n\n\n<!------------------------------------endof file " + f.getName()
							+ "-------------------------------------------------------->\n\n\n\n\n\n\n\n");
				}
			}
			List<Byte> l_data = new ArrayList<Byte>();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			GZIPOutputStream gzip = new GZIPOutputStream(baos);
			gzip.write(sb.toString().getBytes("utf-8"));
			gzip.close();

			for (byte b : baos.toByteArray()) {
				l_data.add(b);
			}
			s.setSuccess(true);
			s.setResult(l_data);
		} catch (Exception ex) {
			s.setSuccess(false);
			s.setResult(null);
			String errorMsg = ex.getMessage() + "\r\n";
			for (StackTraceElement ste : ex.getStackTrace()) {
				errorMsg += ste.toString() + "\r\n";
			}
			s.setMessage(errorMsg);
		} finally {

		}
		return s;

	}
}
