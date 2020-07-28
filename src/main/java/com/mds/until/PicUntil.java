package com.mds.until;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.Part;

public class PicUntil {

	public static byte[] getPartPicture(Part part) throws IOException {
		InputStream in = part.getInputStream();
		byte[] b = new byte[in.available()];
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		in.read(b);
		out.write(b);
		out.flush();
		out.close();
		in.close();
		return out.toByteArray();
	}

	public static List<String> getMimeType() {
		List<String> mime = new ArrayList<String>();
		mime.add("image/jpg");
		mime.add("image/png");
		mime.add("image/jpeg");
		mime.add("image/bmp");
		mime.add("image/gif");
		mime.add("image/webp");
		return mime;
	}

	public static byte[] getDefaultPicture(String path) {
		FileInputStream in = null;
		ByteArrayOutputStream out = null;
		try {
			in = new FileInputStream(path);
			out = new ByteArrayOutputStream();
			byte[] b = new byte[in.available()];
			in.read(b);
			out.write(b);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return out.toByteArray();
	}

	public static void outputImg(ServletResponse res, byte[] img) {
		try {
			ServletOutputStream out = res.getOutputStream();
			out.write(img);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getFileNameFromPart(Part part) {
		String header = part.getHeader("content-disposition");
		String filename = new File(header.substring(header.lastIndexOf("=") + 2, header.length() - 1)).getName();
		if (filename.length() == 0) {
			return null;
		}
		return filename;
	}
}
