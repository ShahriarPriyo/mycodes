
import java.util.ArrayList;
import java.util.Scanner;

public class DES {
    
    public String shifting(String s,Integer sh)
{
    Integer shifts=sh;
    String string=s;
    char[] shifted=new char[28];
    Integer pos=0;
    for(int i=shifts;i<string.length();i++)
    {
       // System.out.println(""+i);
        shifted[pos]=string.charAt(i);
        pos++;
        
    }
    String str=String.valueOf(shifted);
 //   System.out.println(""+str);
  //  System.out.println("Shifting complete");
    for(int j=0;j<shifts;j++)
    {
    //    System.out.println(""+j);
       
        shifted[pos]=string.charAt(j);
         pos++;
    }
 //   str=String.valueOf(shifted);
 //   System.out.println(""+str);
  String str1=String.valueOf(shifted);      
    return  str1;
}   
    
    

    public static void main(String[] args) {
        ArrayList<String> leftkeylist=new ArrayList<String>();
        ArrayList<String> rightkeylist=new ArrayList<String>();
        ArrayList<String> mainkeylist=new ArrayList<String>();
       DES obj=new DES();
        Scanner in = new Scanner(System.in);

        int leftper[] = 
{
	  32,  1,  2,  3,  4,  5,
	   4,  5,  6,  7,  8,  9,
	   8,  9, 10, 11, 12, 13,
	  12, 13, 14, 15, 16, 17,
	  16, 17, 18, 19, 20, 21,
	  20, 21, 22, 23, 24, 25,
	  24, 25, 26, 27, 28, 29,
	  28, 29, 30, 31, 32,  1
};
        int sP[] = 
{
	  16,  7, 20, 21,
	  29, 12, 28, 17,
	   1, 15, 23, 26,
	   5, 18, 31, 10,
	   2,  8, 24, 14,
	  32, 27,  3,  9,
	  19, 13, 30,  6,
	  22, 11,  4, 25
};
             int initialper[]
                = {
             58, 50, 42, 34, 26, 18, 10, 2,
	  60, 52, 44, 36, 28, 20, 12, 4,
	  62, 54, 46, 38, 30, 22, 14, 6,
	  64, 56, 48, 40, 32, 24, 16, 8,
	  57, 49, 41, 33, 25, 17,  9, 1,
	  59, 51, 43, 35, 27, 19, 11, 3,
	  61, 53, 45, 37, 29, 21, 13, 5,
	  63, 55, 47, 39, 31, 23, 15, 7
                };
        int keycode[]
                = {
                    57, 49, 41, 33, 25, 17, 9,
                    1, 58, 50, 42, 34, 26, 18,
                    10, 2, 59, 51, 43, 35, 27,
                    19, 11, 3, 60, 52, 44, 36,
                    63, 55, 47, 39, 31, 23, 15,
                    7, 62, 54, 46, 38, 30, 22,
                    14, 6, 61, 53, 45, 37, 29,
                    21, 13, 5, 28, 20, 12, 4
                };
       int keyhash[] = 
{
	  14, 17, 11, 24,  1,  5,
	   3, 28, 15,  6, 21, 10,
	  23, 19, 12,  4, 26,  8,
	  16,  7, 27, 20, 13,  2,
	  41, 52, 31, 37, 47, 55,
	  30, 40, 51, 45, 33, 48,
	  44, 49, 39, 56, 34, 53,
	  46, 42, 50, 36, 29, 32
};
       int FP[] = 
{
	  40, 8, 48, 16, 56, 24, 64, 32,
	  39, 7, 47, 15, 55, 23, 63, 31,
	  38, 6, 46, 14, 54, 22, 62, 30,
	  37, 5, 45, 13, 53, 21, 61, 29,
	  36, 4, 44, 12, 52, 20, 60, 28,
	  35, 3, 43, 11, 51, 19, 59, 27,
	  34, 2, 42, 10, 50, 18, 58, 26,
	  33, 1, 41,  9, 49, 17, 57, 25
};
     int DesSbox[][][] = {

   {
   {14,  4, 13,  1,  2, 15, 11,  8,  3, 10,  6, 12,  5,  9,  0,  7},
   { 0, 15,  7,  4, 14,  2, 13,  1, 10,  6, 12, 11,  9,  5,  3,  8},
   { 4,  1, 14,  8, 13,  6,  2, 11, 15, 12,  9,  7,  3, 10,  5,  0},
   {15, 12,  8,  2,  4,  9,  1,  7,  5, 11,  3, 14, 10,  0,  6, 13},
   },

   {
   {15,  1,  8, 14,  6, 11,  3,  4,  9,  7,  2, 13, 12,  0,  5, 10},
   { 3, 13,  4,  7, 15,  2,  8, 14, 12,  0,  1, 10,  6,  9, 11,  5},
   { 0, 14,  7, 11, 10,  4, 13,  1,  5,  8, 12,  6,  9,  3,  2, 15},
   {13,  8, 10,  1,  3, 15,  4,  2, 11,  6,  7, 12,  0,  5, 14,  9},
   },

   {
   {10,  0,  9, 14,  6,  3, 15,  5,  1, 13, 12,  7, 11,  4,  2,  8},
   {13,  7,  0,  9,  3,  4,  6, 10,  2,  8,  5, 14, 12, 11, 15,  1},
   {13,  6,  4,  9,  8, 15,  3,  0, 11,  1,  2, 12,  5, 10, 14,  7},
   { 1, 10, 13,  0,  6,  9,  8,  7,  4, 15, 14,  3, 11,  5,  2, 12},
   },

   {
   { 7, 13, 14,  3,  0,  6,  9, 10,  1,  2,  8,  5, 11, 12,  4, 15},
   {13,  8, 11,  5,  6, 15,  0,  3,  4,  7,  2, 12,  1, 10, 14,  9},
   {10,  6,  9,  0, 12, 11,  7, 13, 15,  1,  3, 14,  5,  2,  8,  4},
   { 3, 15,  0,  6, 10,  1, 13,  8,  9,  4,  5, 11, 12,  7,  2, 14},
   },

   {
   { 2, 12,  4,  1,  7, 10, 11,  6,  8,  5,  3, 15, 13,  0, 14,  9},
   {14, 11,  2, 12,  4,  7, 13,  1,  5,  0, 15, 10,  3,  9,  8,  6},
   { 4,  2,  1, 11, 10, 13,  7,  8, 15,  9, 12,  5,  6,  3,  0, 14},
   {11,  8, 12,  7,  1, 14,  2, 13,  6, 15,  0,  9, 10,  4,  5,  3},
   },

   {
   {12,  1, 10, 15,  9,  2,  6,  8,  0, 13,  3,  4, 14,  7,  5, 11},
   {10, 15,  4,  2,  7, 12,  9,  5,  6,  1, 13, 14,  0, 11,  3,  8},
   { 9, 14, 15,  5,  2,  8, 12,  3,  7,  0,  4, 10,  1, 13, 11,  6},
   { 4,  3,  2, 12,  9,  5, 15, 10, 11, 14,  1,  7,  6,  0,  8, 13},
   },

   {
   { 4, 11,  2, 14, 15,  0,  8, 13,  3, 12,  9,  7,  5, 10,  6,  1},
   {13,  0, 11,  7,  4,  9,  1, 10, 14,  3,  5, 12,  2, 15,  8,  6},
   { 1,  4, 11, 13, 12,  3,  7, 14, 10, 15,  6,  8,  0,  5,  9,  2},
   { 6, 11, 13,  8,  1,  4, 10,  7,  9,  5,  0, 15, 14,  2,  3, 12},
   },

   {
   {13,  2,  8,  4,  6, 15, 11,  1, 10,  9,  3, 14,  5,  0, 12,  7},
   { 1, 15, 13,  8, 10,  3,  7,  4, 12,  5,  6, 11,  0, 14,  9,  2},
   { 7, 11,  4,  1,  9, 12, 14,  2,  0,  6, 10, 13, 15,  3,  5,  8},
   { 2,  1, 14,  7,  4, 10,  8, 13, 15, 12,  9,  0,  3,  5,  6, 11},
   },

};
       
        int SHIFTS[] = { 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 };
        String s;
        System.out.println("Enter the cipher text:");
        s = in.nextLine();
        String left, right;
       // left = s.substring(0, 32);
       // right = s.substring(32);
        String key, nkey = "", lkey, rkey;
        System.out.println("Enter key:");
        key = in.nextLine();
        
       String convert="";
        for (int i = 0; i < s.length(); i++) {
           String q=""+Integer.toBinaryString(Integer.parseInt(""+s.charAt(i), 16));
            while(q.length()<4)
            {
                q="0"+q;
            }
            convert=convert+q; 
          
        }
        
        
        for (int i = 0; i <64; i++) {
            nkey = nkey + convert.charAt(initialper[i]-1);
           
        }
        
        left = nkey.substring(0, 32);
        right = nkey.substring(32);
  
        nkey="";
 
    //  System.out.println("Left:" + left);
    ///  System.out.println("Right:" + right);
       // System.out.println(""+keyhash[47]);
        for (int i = 0; i < 56; i++) {
            nkey = nkey + key.charAt(keycode[i]-1);
        }
      //  System.out.println("Full key" + nkey);
        lkey = nkey.substring(0, 28);
        rkey = nkey.substring(28);
     //   System.out.println("previous lkey:"+lkey);
      //  System.out.println("previous rkey:"+rkey);
       leftkeylist.add(lkey);
       rightkeylist.add(rkey);
        for (int i = 0; i < 16; i++) {
           // System.out.println("Round:"+(i+1));
            lkey=obj.shifting(leftkeylist.get(i),SHIFTS[i]);
            rkey=obj.shifting(rightkeylist.get(i),SHIFTS[i]);
          
           // StringBuilder str=new StringBuilder(lkey+rkey);
            String lpkey=lkey+rkey;
         //   System.out.println(""+lkey);
        //    System.out.println(""+rkey);
          //  System.out.println("after shifting:"+lpkey+" "+lpkey.length());
             String newkey="";
             for (int j = 0; j <48; j++) {
              newkey=newkey+lpkey.charAt(keyhash[j]-1);
              
            }
             //System.out.println("key "+(i+1)+" "+newkey);
              mainkeylist.add(newkey);
       
           leftkeylist.add(lkey);
           rightkeylist.add(rkey);
        }
    
        for (int i = 0; i < 16; i++) {
          System.out.println("............................................................");
          System.out.println("Round "+(i+1));
          String temp=left;
          left=right;
          nkey="";
          System.out.println("Previous left:"+temp);
          System.out.println("Previous right:"+right); 
          String genkey=mainkeylist.get(i);
          System.out.println("Key:"+genkey); 
          StringBuilder str=new StringBuilder();
          StringBuilder main=new StringBuilder();
            for (int j = 0; j <48; j++) {
                 nkey=nkey+right.charAt(leftper[j]-1); 
            }
       
            for (int j = 0; j <48; j++) {
                str.append(nkey.charAt(j)^genkey.charAt(j));
            }
             System.out.println("After E(R):"+str);
          //  System.out.println(""+nkey);
            //System.out.println(""+genkey);
           // System.out.println(""+str+" "+str.length()); 
            int t=0;
            for (int j = 0; j <48; j=j+6) {
                String p=str.substring(j,j+6);
             //   System.out.println(""+p);
                int row=Integer.parseInt(p.charAt(0)+""+p.charAt(5),2);
                int col=Integer.parseInt(p.substring(1, 5),2);
              //  System.out.println("Row:"+row);
              //  System.out.println("col:"+col);
                int value=DesSbox[t][row][col];
                p=Integer.toBinaryString(value);
                t++;
                while(p.length()<4)
                {
                    String q="0";
                    p=q+""+p;
                }
                main.append(p);
                //System.out.println("After sbox:"+p);
                
            }
            System.out.println("After Completing Sbox:"+main);
            nkey="";
            for (int j = 0; j <32; j++) {
                nkey=nkey+main.charAt(sP[j]-1);
                
            }
           
            System.out.println(""+temp);
            System.out.println(""+nkey);
            System.out.println("After one more Permutation:"+nkey);
            right="";  
            for (int j = 0; j <32; j++) {
                right=right+(temp.charAt(j)^nkey.charAt(j));
            }
            System.out.println("Final left:"+left); 
            System.out.println("After L+E(R):"+right);
        }
        left=right+left;
        nkey="";
        for (int i = 0; i <64; i++) {
             nkey=nkey+left.charAt(FP[i]-1);
        }
        System.out.println(".........................................................");
        System.out.println("Final Cipher Text:"+nkey);
        convert="";
        for (int i = 0; i <64; i=i+4) {
            
             int decimal = Integer.parseInt(""+nkey.substring(i,i+4),2);
             String hexstr = Integer.toString(decimal,16);
            convert=convert+hexstr.toUpperCase();
        }
        System.out.println(""+convert);
 
    }
}
