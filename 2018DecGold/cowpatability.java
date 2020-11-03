import java.util.*;
import java.lang.*;
import java.io.*;

public class cowpatability {
  public static void main(String[] args) throws IOException {
     //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader in = new BufferedReader(new FileReader("cowpatibility.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowpatibility.out")));
    StringTokenizer st = new StringTokenizer(in.readLine());
    
    int a = Integer.parseInt(st.nextToken());
    
    TreeMap<Integer, ArrayList<Integer>> t = new TreeMap<Integer, ArrayList<Integer>>();

    //int max = Integer.MIN_VALUE;
    for(int i = 0; i < a; i++) {
      st = new StringTokenizer(in.readLine());
      for(int j = 0; j < 5; j++) {
        int b = Integer.parseInt(st.nextToken());
        if(!(t.containsKey(b))) {
          t.put(b,new ArrayList<Integer>());
        }
        t.get(b).add(i);
      }
    }
    int[][] g = new int[a][a];
    
    int s = 0;
    for(int i =0; i < t.lastKey(); i++) {
      if(t.containsKey(i)) {
      for(int k : t.get(i)) {
        for(int l: t.get(i)) {
          if(k!=l && g[k][l] == 0) {
            s++;
            g[k][l] = 1;
            g[l][k] = 1;
          }
        }
      }
      }
    }
    //System.out.println(a*(a-1)/2 -s);
    pw.println(a*(a-1)/2 - s);
    pw.close();
  }
}