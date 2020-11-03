import java.io.*;
import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class cowland {
  public static void main(String[] args) throws IOException{
    //Scanner br = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new FileReader("cowland.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowland.out")));
    //System.out.println(4^16^16);
    
    StringTokenizer st= new StringTokenizer(br.readLine());
    //StringTokenizer st= new StringTokenizer(br.nextLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    
    int[] val = new int[a];
    DisjointUnionSets dis = new DisjointUnionSets(a+1);
    
    st= new StringTokenizer(br.readLine());
    //st= new StringTokenizer(br.nextLine());
    for(int i = 0; i <a; i++) {
       int a1 = Integer.parseInt(st.nextToken());
       val[i] = a1;
    }
    
    for(int i = 0; i < a-1; i++) {
      st= new StringTokenizer(br.readLine());
      //st= new StringTokenizer(br.nextLine());
      int b1 = Integer.parseInt(st.nextToken());
      int b2 = Integer.parseInt(st.nextToken());
      dis.union(b1,b2);
    }
    //dis.print();
    for(int i = 0; i < b; i++ ) {
      st= new StringTokenizer(br.readLine());
      //st= new StringTokenizer(br.nextLine());
      int m1 = Integer.parseInt(st.nextToken());
      int m2 = Integer.parseInt(st.nextToken());
      int m3 = Integer.parseInt(st.nextToken());
      if(m1 == 2) {
        //System.out.println(dis.xor(m2,m3,val));
        pw.println(dis.xor(m2,m3,val));
      }else {
        val[m2-1] = m3;
        dis.clear();
      }
    }
   pw.close();
  }
  public static class DisjointUnionSets 
  { 
    static int[] rank, parent; 
    static int n; 
    static int[][] dp;
  
    public DisjointUnionSets(int n) 
    { 
        rank = new int[n]; 
        parent = new int[n]; 
        this.n = n; 
        makeSet();
        dp = new int[n+1][n+1];
        for(int i = 0; i < n+1; i++) {
          Arrays.fill(dp[i],-1);
        }
    } 
  
    static void makeSet() 
    { 
        for (int i=0; i<n; i++) 
        { 
            parent[i] = i; 
        } 
    } 
  
    static int find(int x) 
    { 
        if (parent[x]!=x) 
        { 
            parent[x] = find(parent[x]); 
        } 
  
        return parent[x]; 
    } 
  
    static void union(int x, int y) 
    { 
        int xRoot = x, yRoot = y; 
  
        if (xRoot == yRoot) 
            return; 
        if (rank[xRoot] < rank[yRoot]) 
            parent[xRoot] = yRoot; 
  
        else if (rank[yRoot] < rank[xRoot]) 
            parent[yRoot] = xRoot; 
  
        else
        { 
            parent[yRoot] = xRoot; 
            rank[xRoot] = rank[xRoot] + 1; 
        } 
    }
    public static void print() {
      for(int i: parent) {
        System.out.print(i +" ");
      }
      System.out.println();
    }
    public static void clear() {
      dp = new int[n+1][n+1];
      for(int i = 0; i < n+1; i++) {
        Arrays.fill(dp[i],-1);
      }
    }
    public static int xor(int a, int b, int[] val) {
      int f = b;
      int g = a;
      int sum = 0;
    
      boolean hm = true;
      if(rank[a] < rank[b]) {
        f = a;
        g = b;
      }
      int farpar = f;
      int gpar = g;
      //System.out.println(f + " " + g);
      while(rank[farpar] < rank[gpar]) {
        //System.out.println(farpar);
        farpar = parent[farpar];
      }
      while(farpar != gpar) {
        farpar = parent[farpar];
        gpar = parent[gpar];
      }
      int s = 0;
      int s1 = 0;
      s = deep(f,gpar,val);
      if(g == farpar) {
        s1 = 0;
      }else {
        s1 = deep(g,gpar,val);
      }
      
      return s^s1;
    }
    public static int deep(int a, int b,int[] val) {
      if(dp[a][b] != -1) {
        return dp[a][b];
      }
      if(a == b) {
        dp[a][b] = val[a-1];
        return dp[a][b];
      }
      int v = val[a-1];
      int f = v^deep(parent[a],b,val);
      dp[a][b] = f;
      return dp[a][b];
    }
  } 
}