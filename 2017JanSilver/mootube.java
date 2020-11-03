import java.io.*;
import java.util.*;
public class mootube {
 public static void main(String[] args) throws IOException {
  //initialize file I/O
  BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
  PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
  
  StringTokenizer st = new StringTokenizer(br.readLine());
  int a = Integer.parseInt(st.nextToken()) + 1;
  int b = Integer.parseInt(st.nextToken());
  LinkedList<Integer> ad[] = new LinkedList[a];
  for (int i=0; i<a; ++i) {
            ad[i] = new LinkedList();
  }
  HashMap<String, Integer> x = new HashMap<String, Integer>();;
  /*ad[2].add(4);
  ad[4].add(2);
  x.put("2 4",4);
  x.put("4 2",4);
  ad[1].add(2);
  ad[2].add(1);
  x.put("1 2",3);
  x.put("2 1",3);
  ad[3].add(2);
  ad[2].add(3);
  x.put("3 2",2);
  x.put("2 3",2);
  System.out.println(DFS(2, a, 1,ad,x));*/
  for(int ds = 0 ; ds < a-2; ds++) {
    st = new StringTokenizer(br.readLine());
    int p = Integer.parseInt(st.nextToken());
    int u = Integer.parseInt(st.nextToken());
    int hi = Integer.parseInt(st.nextToken());
    ad[p].add(u);
    ad[u].add(p);
    x.put(p + " " + u, hi);
    x.put(u + " " + p, hi);
  }
  for(int j = 0; j < b; j++) {
    st = new StringTokenizer(br.readLine());
    int f = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());
    pw.println(DFS(t,a,f,ad,x));
  }
  pw.close();
 }
 public static int DFS2(int x, boolean v[], int y, int z, LinkedList<Integer> ad[], HashMap<String,Integer> g)
    {
        int c = 0;
        v[x] = true;
        Iterator<Integer> i = ad[x].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            
            if (!v[n]) {
              int j = g.get(x + " "+ n);
              j = Math.min(j,z);
              if(j >= y) {
                c++;
              }
              c = c + DFS2(n, v, y,j, ad, g);
            }
        }
        return c;
    }
 
   public static int DFS(int x ,int a, int y, LinkedList<Integer> ad[],HashMap<String,Integer> g)
    {
        boolean v[] = new boolean[a];
 
        return DFS2(x, v,y,10000000, ad, g);
    }
}