import java.io.*;
import java.util.*;
public class sort {
 public static void main(String[] args) throws IOException {
  // initialize file I/O
  BufferedReader br = new BufferedReader(new FileReader("sort.in"));
  PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
  
  int x = Integer.parseInt(br.readLine());
   //Scanner scan = new Scanner(System.in);
   //int x = scan.nextInt();
  int[] y = new int[x];
  int m = -1;
  for(int i = 0; i < x; i++) {
    int a = Integer.parseInt(br.readLine());
    //int a = scan.nextInt();
    y[i] = a;
    if(a > m) {
      m = a;
    }
  }
  int[] z = new int[m+1];
  for(int k = 0; k < x; k++) {
    z[y[k]] = k;
  }
  Arrays.sort(y);
  int max = -1;
  for(int j = 0; j < x; j++) {
    if(j < x-1) {
      while(y[j+1] == y[j]) {
        j++;
        if(j == x-1) {
          break;
        }
      }
    }
    int b = y[j];
    int c = z[b];
    //System.out.println(j + " " + b + " " + c);
    max= Math.max(max,c-j);
  }
  pw.println(max+1);
  pw.close();
  //System.out.println(max+1);
 }
}