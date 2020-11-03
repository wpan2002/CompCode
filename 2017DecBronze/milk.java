import java.io.*;
import java.util.*;
public class milk {
 public static void main(String[] args) throws IOException {
  // initialize file I/O
  BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
  PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
  
  int Moo = 7;
  boolean ml = true;
  int Boo = 7;
  boolean bl = true;
  int Eoo = 7;
  boolean el = true;
  
  int max = 7;
  int maxnum = 3;
  
  int c = 0;
  
  StringTokenizer st = new StringTokenizer(br.readLine());
  int n = Integer.parseInt(st.nextToken());
  
  ArrayList<Data> x = new ArrayList<Data>();
  int[] y = new int[n];
  
  for(int i = 0 ; i < n; i++) {
    st = new StringTokenizer(br.readLine());
    String a = st.nextToken();
    int d = Integer.parseInt(a);
    y[i] = d;
    String b = st.nextToken();
    String g = st.nextToken();
    Data p = new Data(d,b,g);
    x.add(p);
 
  }
  Arrays.sort(y);
  
  for(int k = 0; k < n; k++) {
    boolean jum = false;
    int f = y[k];
    Data r = findN(f, x);
    if(r.getName().equals("Mildred")) {
      
      Moo = Moo + r.getIn();
      max = Math.max(Math.max(Moo,Boo),Eoo);
      
    }else if(r.getName().equals("Bessie")) {
      
      Boo = Boo + r.getIn();
      max = Math.max(Math.max(Moo,Boo),Eoo);
      
    }else if(r.getName().equals("Elsie")) {
      Eoo = Eoo + r.getIn();
      max = Math.max(Math.max(Moo,Boo),Eoo);
      
    }
    if(ml && Moo < max) {
      ml = false;
      jum = true;
    }else if(!ml && Moo == max) {
      ml = true;
      jum = true;
    }
    if(bl && Boo < max) {
      bl = false;
      jum = true;
    }else if(!bl && Boo == max) {
      bl = true;
      jum = true;
    }if(el && Eoo < max) {
      el = false;
      jum = true;
    }else if(!el && Eoo == max) {
      el = true;
      jum = true;
    }
    if(jum) {
      c++;
    }
  
  }
  pw.println(c);
  pw.close();
  }
 public static Data findN(int g, ArrayList<Data> x) {
   for(Data h : x) {
     if(h.getOr() == g) {
       return h;
     }
   }
   return null;
 }
 static class Data {
   int x = 0;
   String y = "";
   int z = 0;
   public Data(int a, String b, String c) {
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
   public String getName() {
     return y;
   }
   public int getIn() {
     return z;
   }
 }
 }