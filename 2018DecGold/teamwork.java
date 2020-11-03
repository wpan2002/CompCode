import java.util.*;
import java.lang.*;
import java.io.*;

public class teamwork {
  public static void main(String[] args) throws IOException {
    //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader in = new BufferedReader(new FileReader("teamwork.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("teamwork.out")));
    StringTokenizer st = new StringTokenizer(in.readLine());
    
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    
    long[] x= new long[a];
    BIT boi = new BIT(a);
    point[] y = new point[a];
    for(int i = 0; i < a; i++) {
      st = new StringTokenizer(in.readLine());
      long c = Integer.parseInt(st.nextToken());
      x[i] = c;
      y[i] = new point(c,i);
      boi.update(i,c);
    }
    Arrays.sort(y);
    long s = 0;
    //System.out.prlongln("hi");
    //System.out.prlongln(boi.query(3));
    for(int i = 0; i < a; i++) {
      
      long n = y[i].getP();
      //System.out.prlongln(n);
      int p = (int) y[i].getC();
      int ls = Math.max(p-b+1,0);
      while(x[ls] > n && ls < p) {
        ls++;
      }
      int rs = ls;
      int mls = p;
      int mrs = p;
      //System.out.println( n + " " + ls + " " + rs);
      /*for(long o : x) {
        System.out.prlong(o + " ");
      }*/
      //System.out.prlongln();
      while(rs < a && x[rs] <= n  && rs-ls < b-1) {
        rs++;
      }
      if(rs < a && x[rs] > n) {
        rs--;
      }
      //System.out.println(ls + " " + rs);
      boolean t = true;
      if(ls == rs) {
        t = false;
      }
      //boolean t = true;
      long min = Integer.MAX_VALUE;
      long sum = 0;
      while(t && ls <= p && rs < a) {
        //System.out.prlongln(n + " " + p + " " +ls + " " + rs);
        if(ls > 0 && (boi.query(rs)-boi.query(ls-1)) < min) {
          min = (boi.query(rs)-boi.query(ls-1));
          //System.out.prlongln(min);
          mls = ls;
          mrs = rs;
        }else if((boi.query(rs) < min)) {
          min = (boi.query(rs));
          //System.out.prlongln(min);
          mls = ls;
          mrs = rs;
        }
        ls++;
        rs++;
        if(rs < a && x[rs] > n) {
          t = false;
        }
      }
      for(int j = mls; j <= mrs; j++) {
        boi.update(j,n-x[j]);
        x[j] = n;
        
      }
      
      //System.out.println(n + " " + mls + " " + mrs);
    }
    //System.out.println(boi.query(a-1));
    pw.println(boi.query(a-1));
    pw.close();
  }
  static class BIT {
    public long[] tree;
    public BIT(int n) {
      tree = new long[n+5];
    }
    public void update(int index, long val) {
      index++;
      while(index < tree.length) {
    tree[index] += val;
    index += index & -index;
   }
  }
  public long query(int index) {
   long ret = 0;
   index++;
   while(index > 0) {
    ret += tree[index];
    index -= index & -index;
   }
   return ret;
  }
 }
  public static class point implements Comparable<point> {
    long x;
    int y;
    public point(long a, int b) {
      x = a;
      y = b;
    }
    public long getP() {
      return x;
    }
    public int getC() {
      return y;
    }
    public int compareTo(point o) {
      return (int) (o.x - x);
    }
    public String toString() {
      return x + " " + y;
    }
  }
}