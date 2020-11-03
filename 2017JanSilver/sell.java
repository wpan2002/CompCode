import java.io.*;
import java.util.*;
public class sell {
 public static void main(String[] args) throws IOException {
  // initialize file I/O
  BufferedReader br = new BufferedReader(new FileReader("rental.in"));
  PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
  
  StringTokenizer st = new StringTokenizer(br.readLine());
  int a = Integer.parseInt(st.nextToken());
  int b = Integer.parseInt(st.nextToken());
  int c = Integer.parseInt(st.nextToken());
  int m = 0;
  
  ArrayList<Integer> x = new ArrayList<Integer>();
  TreeMap<Integer,Integer> z = new TreeMap<Integer, Integer>(Collections.reverseOrder());
  ArrayList<Integer> y = new ArrayList<Integer>();
  
  for(int i = 0; i < a; i++) {
    st = new StringTokenizer(br.readLine());
    x.add(Integer.parseInt(st.nextToken()));
  }
  for(int j = 0; j < b; j++) {
    st = new StringTokenizer(br.readLine());
    int p = Integer.parseInt(st.nextToken());
    int u = Integer.parseInt(st.nextToken());
    z.put(u,p);
  }
  for(int k = 0; k < c; k++) {
    st = new StringTokenizer(br.readLine());
    y.add(Integer.parseInt(st.nextToken()));
  }
 
  
  Collections.sort(x);
  Collections.sort(y);
  Collections.reverse(y);
  int in = 0;
  m = mon(x,z,y);
  pw.print(m);
  pw.close();
 }
 public static int money(int x, TreeMap y) {
   int c = 0;
   Set o = y.entrySet();
   Iterator i = o.iterator();
   while(i.hasNext()) {
     Map.Entry entry = (Map.Entry)i.next();
     int a = (int) entry.getKey();
     int b = (int) entry.getValue();
     if(x == 0) {
       return c;
     }
     if(x >= b) {
       c = c+ b * a;
       x = x - b;
     }else {
       c = c + x * a;
       x = 0;
     }
   }
   return c;
 }
 public static void sim(int x, Map y) {
  Set o = y.entrySet();
   Iterator i = o.iterator();
   while(i.hasNext()) {
     Map.Entry entry = (Map.Entry)i.next();
     int a = (int) entry.getKey();
     int b = (int) entry.getValue();
     if(x == 0) {
       break;
     }
     if(x >= b) {
       x = x-b;
       y.replace(a,0);
     }else {
       x = 0;
       y.replace(a,b-x);
     }
   }
 }
 public static int mon(ArrayList<Integer> x, TreeMap p, ArrayList<Integer> y) {
   int in = -1;
   int m = 0;
   for(int k = 0; k < x.size(); k++) {
     if(money(x.get(k),p) >= y.get(0)) {
       in = k;
       break;
     }else {
       m = m + y.get(0);
       y.remove(0);
     }
   }
   if(in != -1) {
     ArrayList<Integer> ki = new ArrayList<Integer>(x.subList(in,x.size()));
     Collections.reverse(ki);
     m = m + mon2(ki,p,y);
   }
   return m;
 }
 public static int mon2(ArrayList<Integer> x, TreeMap z, ArrayList<Integer> y) {
   int in = -1;
   int m = 0;
   for(int k = 0; k < x.size(); k++) {
     if(money(x.get(k),z) >= y.get(0)) {
       m = m + money(x.get(k),z);
       Set ik = z.entrySet();
       Iterator po = ik.iterator();
       while(po.hasNext()) {
         Map.Entry entry = (Map.Entry)po.next();
         int ad = (int) entry.getKey();
         int bd = (int) entry.getValue();
         if(x.get(k) == 0) {
           break;
         }
         if(x.get(k) >= bd) {
           x.set(k,x.get(k)-bd);
           z.replace(ad,0);
         }else {
           z.replace(ad,bd - x.get(k));
           x.set(k,0);
         }
       }
     }else {
      in = k;
      break;
     }
   }
   if(in != -1) {
     ArrayList<Integer> ki = new ArrayList<Integer>(x.subList(in,x.size()));
     Collections.reverse(ki);
     m = m + mon(ki, z, y);
   }
   return m;
 }
}