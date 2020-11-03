import java.io.*;
import java.util.*;
public class reststops {
 public static void main(String[] args) throws IOException {
  // initialize file I/O
 BufferedReader br = new BufferedReader(new FileReader("reststops.in"));
  PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
  
  
  StringTokenizer st = new StringTokenizer(br.readLine());
  int l = Integer.parseInt(st.nextToken());
  int n = Integer.parseInt(st.nextToken());
  int rf = Integer.parseInt(st.nextToken());
  int rc = Integer.parseInt(st.nextToken());
  
  int[] y= new int[l+1];
  ArrayList<dank> x = new ArrayList<dank>();
  for(int i = 0; i < n; i++) {
    st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    y[a] = b;
    x.add(new dank(a,b));
  }
  /*int l = 11;
  int n = 4;
  int rf = 4;
  int rc = 3;
  int[] y= new int[l+1];
  ArrayList<dank> x = new ArrayList<dank>();
  y[5] = 1;
  y[8] =4 ;
  y[9] =2;
  y[10] = 3;
  x.add(new dank(5,1));
  x.add(new dank(8,4));
  x.add(new dank(9,2));
  x.add(new dank(10,3));*/
  Collections.sort(x,Collections.reverseOrder());
  int lastpos = 0;
  int c =  0;
  for(int j = 0; j < x.size(); j++) {
    int p = x.get(j).gett();
    int o = x.get(j).getd();
    if(o > lastpos) {
      c+= (rf-rc)*(o-lastpos)*(p);
      lastpos = o;
    }
  }
  //System.out.println(c);
  
  pw.println(c);
  pw.close();
 }
 public static class dank implements Comparable<dank>{
   int x;
   int y;
   public dank(int a, int b) {
     x = a;
     y = b;
   }
   public int getd() {
     return x;
   }
   public int gett() {
     return y;
   }
   public int compareTo(dank compareFruit) {

     int z = ((dank) compareFruit).gett();
     int p = ((dank) compareFruit).getd();
     if(this.y == z) {
       return p - this.x;
     }
     return this.y - z;
     
   }
 } 
}
