import java.io.*;
import java.util.*;
public class billboard {
 public static void main(String[] args) throws IOException {
  // initialize file I/O
  BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
  PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
  
  
  StringTokenizer st = new StringTokenizer(br.readLine());
  int a = Integer.parseInt(st.nextToken());
  int b = Integer.parseInt(st.nextToken());
  int c= Integer.parseInt(st.nextToken());
  int d = Integer.parseInt(st.nextToken());
  st = new StringTokenizer(br.readLine());
  int a1 = Integer.parseInt(st.nextToken());
  int b1 = Integer.parseInt(st.nextToken());
  int c1 = Integer.parseInt(st.nextToken());
  int d1 = Integer.parseInt(st.nextToken());
  st = new StringTokenizer(br.readLine());
  int a2 = Integer.parseInt(st.nextToken());
  int b2 = Integer.parseInt(st.nextToken());
  int c2 = Integer.parseInt(st.nextToken());
  int d2 = Integer.parseInt(st.nextToken());
  
  
  
  int area1 = area(a,b,c,d,a2,b2,c2,d2);
  int area2 = area(a1,b1,c1,d1,a2,b2,c2,d2);
  int m1 = (c - a) * (d - b);
  int m2 = (c1 - a1) * (d1 - b1);
  
  pw.println(m1 + m2 - area1 - area2);
  pw.close();
 }
 
 public static int area(int a, int b, int c, int e, int a1, int b1, int c1, int e1) {
   int d1 = 0;
   int d2 = 0;
   int d3 = 0;
   int d4 = 0;
   if(a > a1) {
     d1 = a;
   }else {
     d1 = a1;
   }
   if( b > b1) {
     d2 = b;
   }else {
     d2 = b1;
   }
   if( c < c1) {
     d3 = c;
   }else {
     d3 = c1;
   }
   if( e < e1) {
     d4 = e;
   }else {
     d4 = e1;
   }
   
   int j1 = d3 - d1;
   int j2 = d4 - d2;
   if((c1 < a) || (a1 > c)) {
     j1 = 0;
   }
   if((e1 < b) || (b1 > e)) {
     j2 = 0;
   }
   return j1 * j2;
 }
}