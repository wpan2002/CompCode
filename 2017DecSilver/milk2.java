import java.io.*;
import java.util.*;
public class milk2 {
 public static void main(String[] args) throws IOException {
  // initialize file I/O
  BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
  PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
  int c = 0;
  
  StringTokenizer st = new StringTokenizer(br.readLine());
  int n = Integer.parseInt(st.nextToken());
  int n1 = Integer.parseInt(st.nextToken());
  String s = "";
  
  ArrayList<Data> x = new ArrayList<Data>();
  ArrayList<Integer> cow = new ArrayList<Integer>();
  ArrayList<Integer> milk = new ArrayList<Integer>();
  ArrayList<Integer> jo = new ArrayList<Integer>();
  
  int[] y = new int[n];
  int max = n1;
  

  for(int i = 0 ; i < n; i++) {
    st = new StringTokenizer(br.readLine());
    String a = st.nextToken();
    int d = Integer.parseInt(a);
    y[i] = d;
    jo.add(d);
    int b = Integer.parseInt(st.nextToken());
    String g = st.nextToken();
    Data p = new Data(d,b,g);
    x.add(p);
    if((cow.indexOf(b) == -1)) {
      cow.add(b); 
      milk.add(n1);
      s = s+b;
    }
  }
  Arrays.sort(y);
  
  for(int k = 0; k < n; k++) {
    Data p = findN(y[k] ,x, jo);
    changev(p, cow, milk);
    
    /*for(Cow ke: cow) {
      pw.print(ke.getId() + " " + ke.getMilk() + " ");
    }*/
    //pw.println();
    max = Collections.max(milk);
    String ko = change(cow,milk,max,s);
    if(!(ko.equals(s))) {
      s = ko;
      c++;
    }
  
  }
  pw.println(c);
  pw.close();
  System.out.println(c);
  }
 public static void changev(Data x, ArrayList<Integer> y, ArrayList<Integer> z) {
   int g = y.indexOf(x.getName());
   z.set(g,z.get(g) + x.getIn());
 }
 public static String change(ArrayList<Integer> x, ArrayList<Integer> y, int max, String s) {
   boolean b = false;
   s = "";
   
   for(int p = 0; p < x.size(); p++) {
     if(y.get(p) == max) {
       s = s+x.get(p);
     }
   }
   return s;
 }

 public static Data findN(int g, ArrayList<Data> x, ArrayList<Integer> y) {
   int k = y.indexOf(g);
   return x.get(k);
 }
 static class Data {
   int x = 0;
   int y = 0;
   int z = 0;
   public Data(int a, int b, String c) {
     x = a;
     y = b;
     z = Integer.parseInt(c.substring(1));
     if(c.substring(0,1).equals("-")) {
       z = z * -1;
     }
   }
   public int getOr() {
     return x;
   }
   public int getName() {
     return y;
   }
   public int getIn() {
     return z;
   }
 }
 
 
 }