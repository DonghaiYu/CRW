package com.crw.constant;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Md5 {
	public static String trans(String password) {
		MessageDigest md;
		String pwd = "";
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			pwd = new BigInteger(1, md.digest()).toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pwd;
	}
}
