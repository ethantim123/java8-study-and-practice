package com.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Test {

	final static Base64.Decoder decoder = Base64.getDecoder();
	final static Base64.Encoder encoder = Base64.getEncoder();

	public static void main(String[] args) throws UnsupportedEncodingException {

		String text = "Hello Java!!";
		byte[] textByte = text.getBytes("UTF-8");

		// ½s½X
		String encodedText = encoder.encodeToString(textByte);
		System.out.println(encodedText);
		// ¸Ñ½X
		System.out.println(new String(decoder.decode(encodedText), "UTF-8"));

	}

}
