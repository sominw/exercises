package dp;

public class LCSRecursive {
	
	public static int lcs(String s, String t) {
		
		if (s.length() == 0 || t.length() == 0) {
			return 0;
		}
		
		if (s.charAt(0) == t.charAt(0)) {
			return 1 + lcs(s.substring(1), t.substring(1));
		} else {
			int opt1 = lcs(s, t.substring(1));
			int opt2 = lcs(s.substring(1),t);
			
			return Math.max(opt1, opt2);
		}
		
		
	}
	
	public static void main(String[] args) {
		String s = "agih";
		String t = "bhigh";
		System.out.println(lcs(s,t));
	}
	
}
