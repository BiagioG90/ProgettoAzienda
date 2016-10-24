package util;

import java.security.MessageDigest;

public class CodificaPassword{
	
	public static String codificaPassword(String password) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] array = md.digest(password.getBytes());
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < array.length; ++i) {
					sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
							.substring(1, 3));
				}
				return sb.toString();
			} catch (java.security.NoSuchAlgorithmException e) {
			}
			return null;
		}
}