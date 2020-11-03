import java.io.*;
import java.util.*;
public class teleport {
 public static void main(String[] args) throws IOException {
  // initialize file I/O
  BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
  PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
  
  
  StringTokenizer st = new StringTokenizer(br.readLine());
  int a = Integer.parseInt(st.nextToken());
  ArrayList<dank> y = new ArrayList<dank>();
  ArrayList<dank> z = new ArrayList<dank>();
  int r = 0;
  int l = 0;
  int c = 0;
  int rmin = Integer.MAX_VALUE;
  int rmax = Integer.MIN_VALUE;
  int lmin = Integer.MAX_VALUE;
  int lmax = Integer.MIN_VALUE;
  int rsum = 0;
  int lsum = 0;
  int rnum = 0;
  int lnum = 0;
  for(int i = 0 ; i < a; i++) {
    st = new StringTokenizer(br.readLine());
    int p = Integer.parseInt(st.nextToken());
    int o = Integer.parseInt(st.nextToken());
    if(Math.abs(p-0) <= Math.abs(p-o)) {
      
      
      if(p < o) {
        r+= Math.abs(p-o);
        if(p < rmin) {
          rmin = p;
        }
        if(o > rmax) {
          rmax = o;
        }
        rsum += o;
        rnum++;
        y.add(new dank(p,o));
      }else if(p > o) {
         l+= Math.abs(p-o);
          if(p > lmax) {
            lmax = p;
          }
          if(o < lmin) {
            lmin = o;
          }
          lsum += o;
          lnum++;
          z.add(new dank(p,o));
        }
    }else {
      c += Math.abs(p-o);
    }
  }
  int mink = Integer.MAX_VALUE;
  boolean t = true;
  if(r > l) {
    int j = rsum/rnum;
    //while(t) {
      int k = c + l;
      int k1 = time(y,j);
      k += k1;
      if(k < mink) {
        mink = k;
      }
      //int j1 = (rmin +j)/2;
      //int j2 = (rmax+j)/2;
      j++;
    //}
    pw.println(mink);
  }else {
    int j = lsum/lnum;
    //while(t) {
    
      int k = c + r;
      int k1 = time(z,j);
      k += k1;
      if(k < mink) {
        mink = k;
      }
      //int j1 = (lmin +j)/2;
      //int j2 = (lmax+j)/2;
      j++;
      pw.println(mink);
    //}
  }
   pw.close();
    }
  

 public static int time(ArrayList<dank> y, int j) {
   int k = 0;
   for(dank f: y) {
      int f1 = f.getx();
      int f2 = f.gety();
      if(Math.abs(f1-0) + Math.abs(f2-j) < Math.abs(f1-f2)) {
        k+= Math.abs(f1-0) + Math.abs(f2-j);
      }else {
        k+= Math.abs(f1-f2);
      }
    }
   return k;
 }
 public static class dank {
   int x;
   int y;
   public dank(int a, int b) {
     x = a;
     y = b;
   }
   public int getx() {
     return x;
   }
   public int gety() {
     return y;
   }
 } 
}