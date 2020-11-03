import java.io.*;
import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class dishes {
  public static void main(String[] args) throws IOException{
    //Scanner br = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new FileReader("dishes.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("dishes.out")));
    
    StringTokenizer st= new StringTokenizer(br.readLine());
    //StringTokenizer st= new StringTokenizer(br.nextLine());
    int a = Integer.parseInt(st.nextToken());
    
    ArrayList<Stack> f = new ArrayList<Stack>();
    
    int look = -1;
    int[] k = new int[a];
    for(int i = 0; i < a; i++) {
      st= new StringTokenizer(br.readLine());
      //st = new StringTokenizer(br.nextLine());
      int b1 = Integer.parseInt(st.nextToken());
      k[i] = b1;
      
    }
    int fin = a;
    boolean bool = true;
    for(int o = 0; o < a; o++) {
      int t = k[o];
      bool = true;
      if(t < look) {
        fin = o; 
        //bool = true;
        //System.out.println(look);
        break;
        
      }
      int c = 0;
      if(f.size() == 0) {
        Stack soi = new Stack(t);
        f.add(soi);
      }
      //System.out.println("FUK YOU " + c + " " + f.size());
      while(f.get(c).hm(t)) {
        c++;
        if(c >= f.size()) {
          //System.out.println("ADD " + t);
          Stack s = new Stack(t);
          f.add(s);
          bool =  false;
        }
        
      }
      //System.out.print("LIST " + c + " " + bool + " " + o + " " );
      //f.get(c).toStr();
      if(bool && o > 0) {
        f.get(c).append(t);
        //System.out.println("APPEND " + c + " " + t);
        //f.get(c).toStr();
      }
      
      if(f.get(c).is(t)) {
        int l = f.get(c).the(t);
        //System.out.println(c + " " + t  + " " + l);
        if(l > look) {
          look = l;
          //System.out.println(look);
        }
      }
    }
    /*for(Stack s : f) {
      s.toStr();
    }*/
    pw.println(fin);
    pw.close();
    //System.out.println(fin);
    
  }
  public static class Stack {
    LinkedList<Integer> x;
    int min;
    int max;
    public Stack(int h) {
      x = new LinkedList<Integer>();
      max = h;
      min = h;
      x.add(h);
    }
    public void append(int h) {
      if(h < min) {
        min = h;
      }
      x.add(h);
    }
    public boolean is(int h) {
      if(h > min && h < max) {
        return true;
      }
      return false;
    }
    public boolean hm(int h) {
      //System.out.println(h + " " + max);
      return h > max;
    }
    public int the(int h) {
      for(int i : x) {
        if(h > i) {
          return i;
        }
      }
      return -1;
    }
    public void toStr() {
      for(int k : x) {
        System.out.print(k + " ");
      }
      System.out.println(min);
    }
  }
  
}