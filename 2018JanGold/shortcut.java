import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;
@SuppressWarnings("unchecked")
public class shortcut {
  public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new FileReader("shortcut.in"));
     PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shortcut.out")));
     //Scanner br = new Scanner(System.in);
     StringTokenizer st= new StringTokenizer(br.readLine());
     int a = Integer.parseInt(st.nextToken());
     int b = Integer.parseInt(st.nextToken());
     int c = Integer.parseInt(st.nextToken());
     
     int[] z= new int[a];
     st= new StringTokenizer(br.readLine());
     for(int i = 0; i < a; i++) {
       int aa = Integer.parseInt(st.nextToken());
       z[i] = aa;
     }
     LinkedList<point> x[] = new LinkedList[a];
     for(int i = 0; i < a; i++) {
       x[i] = new LinkedList();
     }
     for(int i = 0; i < b; i++) {
       st= new StringTokenizer(br.readLine());
       int d = Integer.parseInt(st.nextToken());
       int e = Integer.parseInt(st.nextToken());
       int f = Integer.parseInt(st.nextToken());
       
       x[d-1].add(new point(e-1,f,d-1));
       x[e-1].add(new point(d-1,f,e-1));
     }
     
    int[] list = new int[a];
    
    LinkedList<Integer> y[] = new LinkedList[a];
     for(int i = 0; i < a; i++) {
       y[i] = new LinkedList();
     }
     list[0] = 0;
    for(int i = 2; i < a+1; i++) {
      //System.out.println(i);
      int[] cc = dijkstra(x,i,a,0);
      list[i-1] = cc[a];
      //System.out.println(cc[a]);
      int ccc = 0;
      while(ccc != -1) {
        //System.out.println(ccc + " " + cc[ccc]);
        y[ccc].add(i-1);
        ccc = cc[ccc];
      }
    }
    
    //System.out.println("hi");
    
    long max = Integer.MIN_VALUE;
    for(int i = 0; i < a; i++) {
      long m = 0;
      if(c < list[i]) {
        for(int h: y[i]) {
          
          m += z[h] * (list[i] - c);
        }
      }
      if(m > max) {
        //System.out.println(i);
        max = m;
      }
    }
    //System.out.println(max);
    pw.println(max);
    pw.close();
    
    
  }
  public static int[] dijkstra(LinkedList<point> x[], int c, int a, int t) {
     boolean[] v = new boolean[a];
     PriorityQueue<point> y = new PriorityQueue<point>();
    for(point pp: x[c-1]) {
      y.add(pp);
    }
    int[] parent = new int[a+1];
    parent[c-1] = -1;
    v[c-1] = true;
    int[] x1= new int[a];
    //System.out.println("dijkstra " + c);
    while(y.size() > 0) {
       point g = y.poll();
       int g1 = g.getP();
       int g2 = g.getC();
       int g3 = g.getPa();
      //System.out.println(g1 + " " + g2 + " " + g3);
       if(!v[g1] || (g2 <= x1[g1])) {
         x1[g1] = g2;
         if(parent[g1] == 0) {
           parent[g1] = g3;
         }else {
         int c1 = parent[g1];
         int c2 = g3;
         //System.out.println(c1 + " " + c2);
         while(parent[c1] != c-1 && parent[c1] != -1) {
           //System.out.println(c1 + " " + parent[c1] + " " + c);
           c1 = parent[c1];
           
         }
         while(parent[c2] != c-1 && parent[c2] != -1) {
           c2 = parent[c2];
         }
         //System.out.println(c1 + " " + c2);
         
         if((c1 < c2 && c2 != c-1) || c1 == c-1) {
           parent[g1] = parent[g1];
           //System.out.println("winner " +parent[g1]);
         }else {
           parent[g1] = g3;
           //System.out.println("winner " + g3);
         }
         }
         v[g1] = true;
         if(g1 == t) {
           parent[a] = g2;
         }
         for(point pp : x[g1]) {
           y.add(new point(pp.getP(), pp.getC() + g2,pp.getPa()));
         }
       }
     }
    
    return parent;
  }
  public static class point implements Comparable<point> {
    int x;
    int y;
    int p;
    public point(int a, int b,int c) {
      x = a;
      y = b;
      p = c;
    }
    public int getP() {
      return x;
    }
    public int getC() {
      return y;
    }
    public int getPa() {
      return p;
    }
    public int compareTo(point o) {
      if(y-o.y == 0) {
        return x - o.x;
      }
      return y - o.y;
    }
    public String toString() {
      return x + " " + y;
    }
  }
}