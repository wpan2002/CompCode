import java.io.*;
import java.util.*;
public class snowboots {
 public static void main(String[] args) throws IOException {
  // initialize file I/O
  BufferedReader br = new BufferedReader(new FileReader("snowboots.in"));
  PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
  
  
  StringTokenizer st = new StringTokenizer(br.readLine());
  int a = Integer.parseInt(st.nextToken());
  int b = Integer.parseInt(st.nextToken());
  int[] x = new int[a];
  ArrayList<dank> y = new ArrayList<dank>();
  st = new StringTokenizer(br.readLine());
  for(int i = 0; i < a; i++) {
    int p = Integer.parseInt(st.nextToken());
    x[i] = p;
  }
  for(int j = 0; j < b; j++) {
    st = new StringTokenizer(br.readLine());
    int o = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());
    y.add(new dank(o,l));
  }
  /*int[] x = new int[]{0, 2, 8, 3, 6, 7, 5, 1, 4, 0};
  ArrayList<dank> y = new ArrayList<dank>();
  int a = 10;
  y.add(new dank(2,3));
  y.add(new dank(4,2));
  y.add(new dank(3,4));
  y.add(new dank(7,1));*/
  boolean t = false;
  int c = 0;
  //for(int k = 0; k < a; k++) {
  int k = 0;
  while(k < a-1) {
    t= false;
    while(t == false) {
      dank ap = y.get(0);
      if(ap.gets() < x[k]) {
        y.remove(0);
        ap = y.get(0);
        c++;
      }
      for(int m = ap.getd(); m > 0; m--) {
        if(k+m < a) {
          if(x[k+m] <= ap.gets()) {
            t = true;
            k = k + m;
            break;
          }
        }
      }
      if(!t) {
        y.remove(0);
        c++;
      }
    }
  }
  //}
  //System.out.println(c);
  pw.println(c);
  pw.close();
 }
 public static class dank {
   int x;
   int y;
   public dank(int a, int b) {
     x = a;
     y = b;
   }
   public int gets() {
     return x;
   }
   public int getd() {
     return y;
   }
 } 
}