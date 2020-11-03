import java.io.*;
import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class snakes {
  public static void main(String[] args) throws IOException{
    //Scanner br = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new FileReader("snakes.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("snakes.out")));
    
    StringTokenizer st= new StringTokenizer(br.readLine());
    //StringTokenizer st= new StringTokenizer(br.nextLine());
    
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    
    int[] x = new int[a];
    int[] y = new int[a];
    
    int[][][] dp = new int[a][b+1][a];
    
    //st= new StringTokenizer(br.nextLine());
    st= new StringTokenizer(br.readLine());
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < a; i++) {
      int intake =  Integer.parseInt(st.nextToken());
      x[i] = intake;
      y[i] = intake;
      if(intake > max) {
        max = intake;
      }
    }
    int[] z = new int[max+1];
    Arrays.sort(y);
    for(int i = 0; i < a; i++) {
      z[y[i]] = i;
    }
   
    int[][] mins = new int[a][b+1];
    
    for(int i = 0 ; i<a;i++) {
      for(int j = 0; j < b+1; j++) {
        Arrays.fill(dp[i][j], Integer.MAX_VALUE);
      }
    }
    int pos = z[x[0]];
    int min = Integer.MAX_VALUE;
    for(int i = pos; i < a; i++) {
      dp[0][0][i] = Math.min((y[i]-x[0]),dp[0][0][i]);
      if(dp[0][0][i] < min) {
        min = dp[0][0][i];
      }
      //System.out.println(dp[0][0][i] + " " + i + " " + y[i]);
    }
    mins[0][0] = min;
    //System.out.println(dp[2][2][1]);
    for(int i = 1; i < a; i++) {
      for(int j = 0; j < b+1; j++) {
        min = Integer.MAX_VALUE;
        if(j <= i) {
          pos = z[x[i]];
          for(int k = pos; k < a; k++) {
            if(j <= i-1) {
              if(dp[i-1][j][k] == Integer.MAX_VALUE) {
                dp[i][j][k] = Integer.MAX_VALUE;
                //System.out.println("ONE IMP");
              }else {
                dp[i][j][k] = dp[i-1][j][k] + (y[k]-y[pos]);
                //System.out.println("ONE " + dp[i][j][k] + " " + i + " " + j + " " + k + " " + pos + " " + x[i] + " " + y[k] + " " + y[pos]);
              }
              
            }
            if(j >= 1) {
              dp[i][j][k] = Math.min(dp[i][j][k], (mins[i-1][j-1]+y[k]-y[pos]));
              //System.out.println("TWO " + dp[i][j][k] + " " + i + " " + j + " " + k + " " + pos + " " + x[i]);
            }
            
            if(dp[i][j][k] < min) {
              min = dp[i][j][k];
            }
          }
          mins[i][j] = min;
          //System.out.println("FINAL " + i + " " + j + " " +  mins[i][j]);
        }
      }
    }
    int fin = Integer.MAX_VALUE;
    for(int i = 0; i < b+1 ;i++) {
      fin = Math.min(fin,mins[a-1][i]);
    }
    //System.out.println(dp[2][2][1]);
    //System.out.println(fin);
    pw.println(fin);
    pw.close();
  }
}