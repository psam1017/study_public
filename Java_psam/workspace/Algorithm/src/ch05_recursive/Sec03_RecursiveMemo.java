package ch05_recursive;

public class Sec03_RecursiveMemo {
	
	public static void main(String[] args) {
		
		int x = 4;
		memo = new String[x + 2];
		recur(x);
	}
	
  private static String[] memo;

  private static void recur(int n) {
      if (memo[n + 1] != null)
          System.out.print(memo[n + 1]);
      else {
          if (n > 0) {
              recur(n - 1);
              System.out.println(n);
              recur(n - 2);
              memo[n + 1] = memo[n] + n + "\n" + memo[n - 1];
          } else {
              memo[n + 1] = "";
          }
      }
  }
}
