import java.io.*;
import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class walk {
  public static void main(String[] args) throws IOException{
    //Scanner br = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new FileReader("walk.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("walk.out")));
    
    StringTokenizer st= new StringTokenizer(br.readLine());
    //StringTokenizer st= new StringTokenizer(br.nextLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    
    //long[] x = new long[a];
    ArrayList<dist> d = new ArrayList<dist>();
   
    boolean[][] bool = new boolean[a][a];
    
    for(int i = 1; i < a+1; i++) {
      for(int j = 1; j < a+1; j++) {
        if(i!= j && !bool[i-1][j-1]) {
          long x = mulmod(i,2019201913,2019201997);
          
          long y = mulmod(j,2019201949,2019201997);
          long z = x + y;
          z = z%2019201997;
          //System.out.println(i + " " + j + " " + z + " " + x + " " + y);
          d.add(new dist(z,i,j));
          bool[i-1][j-1] = true;
        }
      }
    }
    
    int[] disj = new int[a];
    //sub[] disj = new sub[a];
    for(int i = 0; i < a; i++) {
      //disj[i] = new sub(i,0);
      disj[i] = i;
    }
    int[] count = new int[a];
    int tot = a;

    while(tot > b) {
      dist q = d.get(0);
      long q0 = q.dis;
      int q1 = q.a;
      int q2 = q.b;
      int aa = q1;
      int bb = q2;
      while(disj[aa] != aa) {
        aa = disj[aa];
      }
      while(disj[bb] != bb) {
        bb = disj[bb];
      }
      //System.out.println(q1 + " " + q2 + " " + q0);
      /*if(find(disj,q1) != find(disj,q2)) {
        tot--;
        Union(disj,q1,q2);
      }*/
      if(aa != bb) {
        tot--;
        disj[q2] = q1;
      }
      d.remove(0);
    }
    
    //dist q = d.get(0);
    /*while(find(disj,q.a) == find(disj,q.b)) {
      d.remove(0);
      q = d.get(0);
    }*/
    dist q = d.get(0);
     long q0 = q.dis;
      int q1 = q.a;
      int q2 = q.b;
      int aa = q1;
      int bb = q2;
      while(disj[aa] != aa) {
        aa = disj[aa];
      }
      while(disj[bb] != bb) {
        bb = disj[bb];
      }
      //System.out.println(q1 + " " + q2 + " " + q0);
      /*if(find(disj,q1) != find(disj,q2)) {
        tot--;
        Union(disj,q1,q2);
      }*/
      if(aa != bb) {
        
        disj[q2] = q1;
      }
      d.remove(0);
    
    //System.out.println(q.dis);
    pw.println(q.dis);
    //pw.println(2019201769);
    pw.close();
  }
  public static class dist implements Comparable<dist> {
    long dis;
    int a;
    int b;
    
    public dist(long d, int x, int y) {
      dis = d;
      a = Math.min(x,y)-1;
      b = Math.max(x,y)-1;
    }
    public int compareTo(dist o) {
      if(dis > o.dis) {
        return 1;
      }
      return -1;
    }
  }
  public static class sub {
    int parent;
    int rank;
    public sub(int a, int b) {
      parent = a;
      rank = b;
    }
  }
  /*public static int find(sub[] subsets , int i) 
{ 
if (subsets[i].parent != i) 
    subsets[i].parent = find(subsets,  
                             subsets[i].parent); 
    return subsets[i].parent; 
} 
  

  public static void Union(sub[] subsets,  
           int x , int y ) 
  { 
    int xroot = find(subsets, x); 
        int yroot = find(subsets, y); 
  
    if (subsets[xroot].rank < subsets[yroot].rank) 
        subsets[xroot].parent = yroot; 
    else if (subsets[yroot].rank < subsets[xroot].rank) 
        subsets[yroot].parent = xroot; 
    else
    { 
        subsets[xroot].parent = yroot; 
        subsets[yroot].rank++; 
    } 
  }*/
  public static long mulmod(long a, long b,  
                            long mod)  
    { 
        long res = 0; // Initialize result  
        a = a % mod; 
        while (b > 0) 
        { 
            // If b is odd, add 'a' to result  
            if (b % 2 == 1)  
            { 
                res = (res + a) % mod; 
            } 
  
            // Multiply 'a' with 2  
            a = (a * 2) % mod; 
  
            // Divide b by 2  
            b /= 2; 
        } 
  
        // Return result  
        return res % mod; 
    } 
}