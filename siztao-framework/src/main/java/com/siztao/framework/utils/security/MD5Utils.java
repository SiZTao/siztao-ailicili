package com.siztao.framework.utils.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.bouncycastle.util.encoders.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MD5Utils {
	
	private static final Logger logger = LoggerFactory.getLogger(MD5Utils.class);
	
	private MD5Utils() {
	}
	
	public static String getMD5(String src){
		try {
			// 创建加密对象
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");//提供信息摘要算法的功能
			byte[] md5bytes = messageDigest.digest(src.getBytes());//使用指定的 byte 数组对摘要进行最后更新，然后完成摘要计算
			return Hex.toHexString(md5bytes);
		} catch (NoSuchAlgorithmException e) {
			logger.info("MD5Utils.getMD5", e);
		}
		return null;
	}
}
