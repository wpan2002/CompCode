import java.io.*;
import java.util.*;
public class multimoo {
 public static void main(String[] args) throws IOException {
  // initialize file I/O
  BufferedReader br = new BufferedReader(new FileReader("multimoo.in"));
  PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("multimoo.out")));
  
  int x = Integer.parseInt(br.readLine());
  //Scanner scan = new Scanner(System.in);
  //int x = scan.nextInt();
  int[][] y = new int[x+2][x+2];
  for(int i = 0; i < x+2; i++) {
    Arrays.fill(y[i],-1);
  }
  for(int j = 1; j < x+1; j++) {
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int k = 1; k < x+1; k++) {
      int a = Integer.parseInt(st.nextToken());
      //int a = scan.nextInt();
      y[j][k] = a;
    }
  }
  int m = -1;
  int m1= -1;
  boolean[][] o = new boolean[x+2][x+2];
  for(int p = 1; p < x+1; p++) {
    for(int l = 1; l < x+1; l++) {
       m = Math.max(m,ffill(y,p,l,y[p][l], o));
       m1 = Math.max(m1,fffill(y,p,l,y[p][l],y[p+1][l],new boolean[x+2][x+2]));
    }
  }
  pw.println(m);
  pw.println(m1);
  pw.close();
  //System.out.println(m + " " + m1);
 }
 public static int ffill(int[][] y, int a, int b, int c, boolean[][] p) {
   if(!p[a][b] && y[a][b] == c) {
     p[a][b] = true;
     int i = 1+ ffill(y,a+1,b,c,p) + ffill(y,a-1,b,c,p) + ffill(y,a,b+1,c,p) + ffill(y,a,b-1,c,p);
     return i;
   }
   return 0;
 }
  public static int fffill(int[][] y, int a, int b, int c, int d, boolean[][] p) {
    if(c == -1 || d == -1) {
      return 0;
    }
   if(!p[a][b] && (y[a][b] == c || y[a][b] == d)) {
    
     p[a][b] = true;
     //display(y);
     int i = 1+ fffill(y,a+1,b,c,d,p) + fffill(y,a-1,b,c,d,p) + fffill(y,a,b+1,c,d,p) + fffill(y,a,b-1,c,d,p);
     return i;
   }
   return 0;
 }
  public static void display(int[][] arr)
    {
        System.out.println("\nGrid : ");
        for (int i = 1; i < arr.length - 1; i++)
        {
            for (int j = 1; j < arr[i].length - 1; j++)
                System.out.print(arr[i][j] +" ");
            System.out.println();
        }
    }
}