package com.paladin.account.util;

import com.paladin.account.core.Constant;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * @author: paladin
 * @Description:
 * @date: created in 2020/8/27 23:15
 */
public class FileUploadUtil {

	public static List<String> uploadFile(HttpServletRequest request) throws Exception {
		List<String> list = new ArrayList<>();
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iterator = multiRequest.getFileNames();
			while (iterator.hasNext()) {
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iterator.next());
				if (file != null) {
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						String fileTyps = myFileName.substring(myFileName.lastIndexOf("."));
						// String tempName="demo"+fileTyps;
						String tempName = UUID.randomUUID().toString() + fileTyps;
						// 创建文件夹
						String folderPath = Constant.SAVEFILEPATH + File.separator + folderName();
						File fileFolder = new File(folderPath);
						if (!fileFolder.exists() && !fileFolder.isDirectory()) {
							fileFolder.mkdir();
						}
						File uploadFile = new File(folderPath + File.separator + tempName);
						file.transferTo(uploadFile);
						myFileName = folderName() + File.separator + tempName;
						list.add(Constant.SAVEFILEPATH + "//" + myFileName);
					}
				}
			}
		}
		return list;
	}

	/**
	 * 得年月日的文件夹名称
	 *
	 * @return
	 */
	public static String getCurrentFilderName() throws Exception {
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.YEAR) + "" + (now.get(Calendar.MONTH) + 1) + "" + now.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 创建文件夹
	 *
	 * @param filderName
	 */
	public static void createFilder(String filderName) throws Exception {
		File file = new File(filderName);
		// 如果文件夹不存在则创建
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
		}
	}

	/**
	 * 文件扩展名
	 *
	 * @param fileName
	 * @return
	 */
	public static String extFile(String fileName) throws Exception {
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * 当前日期当文件夹名
	 *
	 * @return
	 */
	public static String folderName() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String str = sdf.format(new Date());
		return str;
	}

}
