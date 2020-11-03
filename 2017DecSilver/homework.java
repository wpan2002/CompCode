import java.io.*;
import java.util.*;
public class homework {
 public static void main(String[] args) throws IOException {
  // initialize file I/O
  BufferedReader br = new BufferedReader(new FileReader("homework.in"));
  PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));

  StringTokenizer st = new StringTokenizer(br.readLine());
  int n = Integer.parseInt(st.nextToken());
  
  double max = 0;

  int[] x = new int[n];
  ArrayList<Integer> y = new ArrayList<Integer>();
  y.add(0);
  
  st = new StringTokenizer(br.readLine());
  for(int i = 0; i < n; i++) {
    x[i] = Integer.parseInt(st.nextToken());
    
  }
  for(int j = 1; j < n-1; j++) {
    double h = eat(x, j);
    if(h > max) {
      y = new ArrayList<Integer>();
      y.add(j);
      max = h;
    }else if(h == max) {
      y.add(j);
    }
  }
  
   for(int p: y) {
     pw.println(p);
   }
   
  
  pw.close();
 }
 public static double eat(int[] x, int y){
   int min = 100000;
   int mini = 0;
   for(int i = x.length - 1; i>= y; i--) {
     if(x[i] < min) {
       min = x[i];
       mini = i;
     }
   }
   double c = 0;
   /*for(int j = x.size() - 1; j>= y; j--) {
     if(j != mini) {
       c = c + x.get(j);
     }
   }*/
   int sum = Arrays.stream(x, y, x.length).sum();
   c = c + sum;
   return c/(x.length-y);
 }
}