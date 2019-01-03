package _04_Base64_Decoder;

import java.util.Arrays;

public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text. Each number 0-63 is
	 * mapped to a character. NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE
	 * ENCODING! Since the numbers 0 through 63 can be represented using 6 bits,
	 * every four (4) characters will represent twenty four (24) bits of data. 4 * 6
	 * = 24
	 * 
	 * For this exercise, we won't worry about what happens if the total bits being
	 * converted do not divide evenly by 24.
	 * 
	 * If one char is 8 bits, is this an efficient way of storing binary data?
	 * (hint: no)
	 * 
	 * It is, however, useful for things such as storing media data inside an HTML
	 * file (for web development), so that way a web site does not have to look for
	 * an image, sound, library, or whatever in a separate location.
	 * 
	 * View this link for a full description of Base64 encoding
	 * https://en.wikipedia.org/wiki/Base64
	 */

	final static char[] base64Chars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', '+', '/' };

	// 1. Complete this method so that it returns the the element in
	// the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c) {
		for (int i = 0; i < base64Chars.length; i++) {
			if (base64Chars[i] == c) {
				System.out.println((byte) i);
				return (byte) i;
			}
		}
		
		return (byte) 0;
	}

	// 2. Complete this method so that it will take in a string that is 4
	// characters long and return an array of 3 bytes (24 bits). The byte
	// array should be the binary value of the encoded characters.
	public static byte[] convert4CharsTo24Bits(String s) {
		int[] array = new int[s.length()];
		for(int i =0; i < s.length(); i++) {
			for(int j = 0; j < base64Chars.length; j++) {
				if(s.charAt(i) == base64Chars[j]) {
					array[i] = convertBase64Char(base64Chars[j]);
				}
				
			}
		}
		
		System.out.println(Arrays.toString(array));
		
		String[] arr = new String[s.length()];
		for(int i = 0; i < s.length(); i++) {
			String x = "";
			if(Integer.toBinaryString(array[i]).length() != 6) {
				for(int j = 0; j < 6-Integer.toBinaryString(array[i]).length(); j++) {
					x += "0";
				}
				x+=Integer.toBinaryString(array[i]);
				arr[i] = x;
			}
			else {
				arr[i] = Integer.toBinaryString(array[i]);
			}
		}
		
		System.out.println(Arrays.toString(arr));
		
		String tot = "";
		for(int i = 0; i < arr.length; i++) {
			tot += arr[i];
		}
		
		System.out.println(tot);
		
		String[] arrr = new String[3];
		for(int i = 0; i <= 2; i++) {
			String x = ""; 
			for(int j = 0; j < 8; j++) {
				x += tot.charAt(j+i*8);
				
			}
			arrr[i] = x;
		}
		
		System.out.println(Arrays.toString(arrr));
		
		byte[] arrrr = new byte[3];
		for(int i = 0; i < arrr.length; i++) {
			arrrr[i] = (byte) Integer.parseInt(arrr[i],2);
		}
		
		System.out.println(Arrays.toString(arrrr));

		return arrrr;
	}

	// 3. Complete this method so that it takes in a string of any length
	// and returns the full byte array of the decoded base64 characters.
	public static byte[] base64StringToByteArray(String file) {
		int[] array = new int[file.length()];
		for(int i =0; i < file.length(); i++) {
			for(int j = 0; j < base64Chars.length; j++) {
				if(file.charAt(i) == base64Chars[j]) {
					array[i] = convertBase64Char(base64Chars[j]);
				}
				
			}
		}
		
		System.out.println(Arrays.toString(array));
		
		String[] arr = new String[file.length()];
		for(int i = 0; i < file.length(); i++) {
			String x = "";
			if(Integer.toBinaryString(array[i]).length() != 6) {
				for(int j = 0; j < 6-Integer.toBinaryString(array[i]).length(); j++) {
					x += "0";
				}
				x+=Integer.toBinaryString(array[i]);
				arr[i] = x;
			}
			else {
				arr[i] = Integer.toBinaryString(array[i]);
			}
		}
		
		System.out.println(Arrays.toString(arr));
		
		String tot = "";
		for(int i = 0; i < arr.length; i++) {
			tot += arr[i];
		}
		
		System.out.println(tot);
		
		int totLength = tot.length()/8;
		System.out.println("total length/8=" + totLength + " total length=" + tot.length());
		String[] arrr = new String[totLength];
		for(int i = 0; i < totLength; i++) {
			String x = ""; 
			for(int j = 0; j < 8; j++) {
				x += tot.charAt(j+i*8);
			}
			arrr[i] = x;
		}
		
		System.out.println(Arrays.toString(arrr));
		
		byte[] arrrr = new byte[tot.length()/8];
		for(int i = 0; i < arrr.length; i++) {
			arrrr[i] = (byte) Integer.parseInt(arrr[i],2);
		}
		
		System.out.println(Arrays.toString(arrrr));

		return arrrr;
	}
}
