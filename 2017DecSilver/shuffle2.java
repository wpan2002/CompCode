import java.io.*;
import java.util.*;
public class shuffle2 {
 public static void main(String[] args) throws IOException {
  // initialize file I/O
  BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
  PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
  
  int c = 0;
  
  StringTokenizer st = new StringTokenizer(br.readLine());
  int n = Integer.parseInt(st.nextToken());
  

  
  ArrayList<Integer> g = new ArrayList<Integer>();
  ArrayList<Integer> b = new ArrayList<Integer>();
  
  st = new StringTokenizer(br.readLine());
  for(int i = 0; i < n; i++) {
    g.add(Integer.parseInt(st.nextToken()));
    b.add(i);
  }
  alt(g,b);
  for(int j : g) {
    if(j != 0) {
      c++;
    }
  }
  pw.println(c);
  pw.close();
 }
 public static void alt(ArrayList<Integer> x, ArrayList<Integer> b) {
   boolean j = true;
   while(j) {
     j = false;
     ArrayList<Integer> l = new ArrayList<Integer>();
     for(int i : b) {
       if(!(x.contains(i+1))) {
         j = true;
         x.set(i,0);
       }else {
         l.add(i);
       }
     }
     b = l;
   }
 }
}