package cn.zm.trip.web.controller;

import cn.zm.trip.web.service.UserService;
import cn.zm.trip.web.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 文件上传控制器
 */
@RequestMapping(value = "upload")
@Controller
public class UploadController {
	@Autowired
	private UserService userService;
	@Autowired
	private ViewPointService viewPointService;

	/**
	 * 文件上传
	 * @param dropFile
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "viewavatar", method = RequestMethod.POST)
	public Map<String, Object> viewAvatar(MultipartFile dropFile, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		//文件存放路径
		String filePath = "D:\\ideaPro\\tripweb\\src\\main\\webapp\\static\\upload\\viewavatar";

		//获取文件后缀
		String fileName = dropFile.getOriginalFilename();
		String fileSuffix = fileName.substring(fileName.lastIndexOf('.'));
		File file = new File(filePath);
		//判断文件是否存在
		if (!file.exists()){
			file.mkdir();
		}
		file = new File(filePath,UUID.randomUUID() + fileSuffix);
		try {
			dropFile.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		result.put("fileName",file.getName());

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "useravatar", method = RequestMethod.POST)
	public Map<String, Object> userAvatar(MultipartFile dropFile, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		//文件存放路径
		String filePath = "D:\\ideaPro\\tripweb\\src\\main\\webapp\\static\\upload\\useravatar";
		//获取文件后缀
		String fileName = dropFile.getOriginalFilename();
		String fileSuffix = fileName.substring(fileName.lastIndexOf('.'));
		File file = new File(filePath);
		//判断文件是否存在
		if (!file.exists()){
			file.mkdir();
		}
		file = new File(filePath,UUID.randomUUID() + fileSuffix);
		try {
			dropFile.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		result.put("fileName",file.getName());

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "contenimg", method = RequestMethod.POST)
	public Map<String, Object> contenImg(MultipartFile dropFile, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		//前缀路径 Scheme服务端提供的协议 getServerName服务器名称 port 端口
		//String server = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();

		//图片显示路径
		String prefix = "/static/upload/contentFile/";

		//String resourcesPath = server + prefix;

		//文件存放路径
		//String filePath = "D:\\ideaPro\\tripweb\\src\\main\\webapp\\static\\upload\\contentFile";
		//获取文件后缀
		String fileName = dropFile.getOriginalFilename();
		String fileSuffix = fileName.substring(fileName.lastIndexOf('.'));

		//文件存放路径
		String realPath = request.getSession().getServletContext().getRealPath("static/upload/contentFile");

		File file = new File(realPath);
		//判断文件是否存在
		if (!file.exists()){
			file.mkdir();
		}
		file = new File(realPath, UUID.randomUUID() + fileSuffix);
		try {
			dropFile.transferTo(file);
			result.put("errno",0);
			result.put("data",new String[] {prefix + file.getName()});
		} catch (IOException e) {
			e.printStackTrace();
		}
		//result.put("fileName",file.getName());
		return result;
	}
}
