import java.io.*;
import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class balance {
  public static void main(String[] args) throws IOException{
    //Scanner br = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new FileReader("balance.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balance.out")));
    
    StringTokenizer st= new StringTokenizer(br.readLine());
    //StringTokenizer st= new StringTokenizer(br.nextLine());
    int a = Integer.parseInt(st.nextToken());
    
    int l = 0;
    int lo = 0;
    int lz = 0;
    int r = 0;
    int ro = 0;
    int rz = 0;
    
    int le = 0;
    int re = 0;
    
    int lc = 0;
    int rc = 0;
    
    st= new StringTokenizer(br.readLine());
    //st = new StringTokenizer(br.nextLine());
    for(int i = 0; i < a; i++) {
      int b = Integer.parseInt(st.nextToken());
      if(b == 1) {
        lo = i;
        if(i == a-1) {
          le = 1;
        }else {
          lc++;
        }
      }else {
        l += lc;
        lz = i;
        if(i == a-1) {
          le = 0;
        }
      }
    }
    boolean boo = true;
    boolean boi = true;
    int rco = 0;
    for(int i = 0; i < a; i++) {
      int b = Integer.parseInt(st.nextToken());
      if(b == 1) {
        rc++;
        if(boi) {
          ro = i;
          boi = false;
        }
        if(i == 0) {
          re = 1;
        }
      }else {
        r += rc;
        if(boo) {
          rz = i;
          boo = false;
        }
        //rz = i;
        if(i == 0) {
          re = 0;
          rco--;
        }
      }
    }
    rco += (a-rc);
    
    int s = r-l;
    //System.out.println(r + " " + rco + " " + l + " " + lc + " " + s);
    int mid = 0;
    int eff = 1;
    if(re== 0 && le == 1) {
      mid = rco - lc;
      if(Math.signum(s) == Math.signum(mid)) {
        eff += a-lz;
        eff += ro;
        mid = rco-lc+2;
      }
      //mid *= -1;
    }else if(le == 0 && re == 1) {
      mid = lc-rco;
      //System.out.println(mid);
      if(Math.signum(s) == Math.signum(mid)) {
        eff += a-lo;
        eff += rz;
        mid = lc-rco;
      }
      //mid *= -1;
    }else if(le == 0 && re == 0) {
      if(Math.signum(s) !=  Math.signum((rco-lc))) {
        eff += a-lo;
        mid = rco-lc +1;
      }else {
        eff += ro;
        System.out.println(ro);
        mid = lc-rco-1;
      }
    }else {
      //0 1 0 1 0 1 1 1 0 1 1 0
      if(Math.signum(s) !=  Math.signum((rco-lc))) {
        eff += rz;
        mid = rco-lc-1;
      }else {
        eff += a - lz;
        mid = lc-rco+1;
      }
    }
    //mid *= -1;
    int fin = Math.abs(s);
    
    if(Math.abs(mid) <= Math.abs(s) && Math.abs(mid) > eff) {
      fin = eff + (Math.abs(s)-Math.abs(mid));
    }else if(Math.abs(mid) > Math.abs(s) && eff+(Math.abs(mid)-Math.abs(s)) < s) {
      fin = eff + Math.abs(mid) - Math.abs(s);
    }
    //System.out.println(s + " " + mid + " " + eff + " " + (rco-lc) + " " + rco + " " + lc + " " + le + " " + re);
    //System.out.println(fin);
    pw.println(fin);
    pw.close();
  }
}