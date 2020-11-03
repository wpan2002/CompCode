import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;
@SuppressWarnings("unchecked")
public class dining {
  public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new FileReader("dining.in"));
     PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("dining.out")));
     StringTokenizer st= new StringTokenizer(br.readLine());
     int a = Integer.parseInt(st.nextToken());
     int b = Integer.parseInt(st.nextToken());
     int c = Integer.parseInt(st.nextToken());
     
     LinkedList<point> x[] = new LinkedList[a];
     for(int i = 0; i < a; i++) {
       x[i] = new LinkedList();
     }
     for(int i = 0; i < b; i++) {
       st= new StringTokenizer(br.readLine());
       int d = Integer.parseInt(st.nextToken());
       int e = Integer.parseInt(st.nextToken());
       int f = Integer.parseInt(st.nextToken());
       
       x[d-1].add(new point(e-1,f));
       x[e-1].add(new point(d-1,f));
     }
     
     point[] list = new point[c];
     for(int i = 0; i < c; i++) {
       st= new StringTokenizer(br.readLine());
       int d = Integer.parseInt(st.nextToken());
       int e = Integer.parseInt(st.nextToken());
       list[i] = new point(d,e);
     }
     int[] x1 = dijkstra(x,a,a);
    int[] truth = new int[a];
    for(int i = 0; i < c; i++) {
       int[] x2 = dijkstra(x,list[i].getP(),a);
       for(int j = 0; j < a; j++) {
         if(x2[j]+x2[a-1]-x1[j] <= list[i].getC()) {
           truth[j] = 1;
         }
       }
    }
    for(int k = 0; k <a-1; k++) {
      pw.println(truth[k]);
    }
      pw.close();
    
  }
  public static int[] dijkstra(LinkedList<point> x[], int c, int a) {
     boolean[] v = new boolean[a];
     PriorityQueue<point> y = new PriorityQueue<point>();
    for(point pp: x[c-1]) {
      y.add(pp);
    }
    v[c-1] = true;
    int[] x1= new int[a];
    while(y.size() > 0) {
       point g = y.poll();
       int g1 = g.getP();
       int g2 = g.getC();
      
       if(!v[g1]) {
         x1[g1] = g2;
         v[g1] = true;
         for(point pp : x[g1]) {
           y.add(new point(pp.getP(), pp.getC() + g2));
         }
       }
     }
    return x1;
  }
  public static class point implements Comparable<point> {
    int x;
    int y;
    public point(int a, int b) {
      x = a;
      y = b;
    }
    public int getP() {
      return x;
    }
    public int getC() {
      return y;
    }
    public int compareTo(point o) {
      return y - o.y;
    }
    public String toString() {
      return x + " " + y;
    }
  }
}