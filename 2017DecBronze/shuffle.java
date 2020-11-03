import java.io.*;
import java.util.*;
public class shuffle {
 public static void main(String[] args) throws IOException {
  // initialize file I/O
  BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
  PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
  
  StringTokenizer st = new StringTokenizer(br.readLine());
  int n = Integer.parseInt(st.nextToken());
  
  int[] x = new int[n];
  int[] y = new int[n];
  
  st = new StringTokenizer(br.readLine());
  for(int i = 0; i < n; i++) {
    x[i] = Integer.parseInt(st.nextToken());
  }
  
  st = new StringTokenizer(br.readLine());
  for(int j = 0; j < n; j++) {
    y[j] = Integer.parseInt(st.nextToken());
  }
  
  int[] z = new int[n];
  
  for(int k = 0; k < 3; k++) {
    for(int l = 0; l < n; l++) { 
      z[l] = y[x[l] - 1];
    }
    y = z;
    z = new int[n];
  }
  
  for(int p = 0; p < n; p++) {
    pw.println(y[p]);
  }
  pw.close();
 }
}