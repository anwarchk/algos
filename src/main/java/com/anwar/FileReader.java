package com.anwar;

import java.util.*;
import java.io.*;

public class FileReader {

	private static Set<IpCounter> pq = new TreeSet<>();

	public static void main(String[] args) throws IOException {
      InputStreamReader fis = new InputStreamReader(new FileInputStream("File.log"));
      BufferedReader infile = new BufferedReader(fis);
      String line = null;
      while((line = infile.readLine()) != null) {
    	  String[] strs = line.split("\t");
    	  IpCounter counter = new IpCounter(strs[0], 0);
    	  //IpCounter existing = pq.
    	  
    	  
      }
	}

	static class IpCounter {
		String ip;
		int count;

		public IpCounter(String ip, int count) {
			this.ip = ip;
			this.count = count;
		}

		@Override
		public boolean equals(Object obj) {
			return Objects.equals(ip, ((IpCounter) obj).ip);
		}

		@Override
		public int hashCode() {
			return Objects.hashCode(ip);
		}
	}

}
