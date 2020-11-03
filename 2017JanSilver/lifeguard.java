import java.io.*;
import java.util.*;
public class lifeguard {
 public static void main(String[] args) throws IOException {
  // initialize file I/O
  BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
  PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
  StringTokenizer st = new StringTokenizer(br.readLine());
  int w = Integer.parseInt(st.nextToken());
  
  TreeMap<Integer, Integer> x= new TreeMap<Integer, Integer>();
  
  
  int c = 0;
  int min = 100000000;
  int n = 0;
  for(int i = 0; i < w; i++) {
    st = new StringTokenizer(br.readLine());
    int p = Integer.parseInt(st.nextToken());
    int u = Integer.parseInt(st.nextToken());
    x.put(p, u);
    n = intleng(p, u ,x);
    c = c + n;
  }
  for(Map.Entry<Integer,Integer> entry : x.entrySet()) {
  int a = entry.getKey();
  int b = entry.getValue();
  n = intleng(a,b,x);
  if(n < min) {
    min = n;
  }
  }
  
  pw.println(c - min);
  pw.close();
 }
public static int intleng(int x, int y, TreeMap z) {
  for(int i = (int) z.firstKey(); i < x; i++) {
    if(z.containsKey(i)) {
      if((int)z.get(i) <= y && (int)z.get(i) >= x) {
        x = (int) z.get(i);
      }else if((int)z.get(i) > y) {
        return 0;
      }
    }
  
  }
  int max = 0;
  boolean t = false;
  for(int l = x; l < y; l++) {
    if(z.containsKey(l)) {
      if((int)z.get(l) <= y && (int)z.get(l) >= x && !(l == x && (int) z.get(l) == y)) {
        t = true;
        int h = (int) z.get(l) - l;
        if( h > max) {
          max = h;
        }
      }else if((int) z.get(l) > y) {
        y = l;
      }
  }
  }
  if(t) {
    System.out.println("hi");
    return y-x-max;
  }
  return y - x;
}
}