import java.io.*;
import java.util.*;
public class lemonade {
 public static void main(String[] args) throws IOException {
  // initialize file I/O
  BufferedReader br = new BufferedReader(new FileReader("lemonade.in"));
  PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
  
  int x = Integer.parseInt(br.readLine());
  int[] y = new int[x];
  StringTokenizer st = new StringTokenizer(br.readLine());
  for(int i = 0; i < x; i++) {
    
    int a = Integer.parseInt(st.nextToken());
    y[i] = a;
  }
  Arrays.sort(y);
  int b = 0;
  if(x > 0) {
    while(y[x-1-b] >= b) {
      b++;
      if(b == x) {
        break;
      }
    }
  }
  pw.println(b);
  pw.close();
 }
}