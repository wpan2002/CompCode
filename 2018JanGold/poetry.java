import java.io.*;
import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class poetry {
  public static void main(String[] args) throws IOException{
    //Scanner br = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new FileReader("poetry.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("poetry.out")));
    StringTokenizer st= new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    
    TreeMap<Integer,ArrayList<Integer>> y = new  TreeMap<Integer,ArrayList<Integer>>();
    int[] set = new int[c+1];
    long[] dp =  new long[c+1];
    Arrays.fill(dp,-1);
    for(int i = 0; i < a; i++) {
      st= new StringTokenizer(br.readLine());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      if(!y.containsKey(w)) {
        ArrayList<Integer> f = new ArrayList<Integer>();
        f.add(v);
        y.put(w,f);
      }else {
        ArrayList<Integer> ff = y.get(w);
        ff.add(v);
        y.put(w,ff);
      }
      set[v]++;
    }
    long sad = 0;
    long max = 1;
    
    //System.out.println(sad);
    TreeMap<String,Integer> s = new TreeMap<String,Integer>();
    for(int i = 0; i < b; i++) {
      st= new StringTokenizer(br.readLine());
      String str = st.nextToken();
      if(!s.containsKey(str)) {
        s.put(str,1);
      }else {
        s.put(str,s.get(str)+1);
      }
    }
    long m = 0;
    for(String key: s.keySet()) {
      sad = 0;
      m = 0;
      for(int ke: y.keySet()) {
        //System.out.println(key);
        sad = find(c,ke,set,y,dp);
        //System.out.println(sad);
        m += Math.pow(sad,s.get(key));
        //System.out.println(m);
      }
      max *= m;
    }
    //System.out.println(max%1000000007);
    pw.println(max%1000000007);
    pw.close();
  }
  public static long find(int l, int r, int[] set, TreeMap<Integer, ArrayList<Integer>> y,long[] dp) {
    
    if(l == 0) {
      return 1;
    }

    int o = set.length;
    long sum = 0;
    if(r == -1) {
      if(dp[l] != -1) {
        return dp[l];
      }
      if(l < o) {
        o = l;
      }
      for(int i = 0; i <= o; i++) {
        
        if(set[i] != 0) {
          sum += find(l-i,-1,set,y,dp) * set[i];
          //System.out.println(l + " " +i + " " + sum);
        }
        
      }
      dp[l] = sum;
    }else {
      ArrayList<Integer> g = y.get(r);
      for(int k: g) {
        if(l-k >= 0) {
          
          sum += find(l-k,-1,set,y,dp);
          //System.out.println(k + " " + sum);
        }
      }
    }
    return sum;
  }
}
