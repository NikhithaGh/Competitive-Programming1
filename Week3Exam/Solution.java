import java.io.*;

class Solution
{
    public static int count=0;
    public void paranthesis(char[] s, int pos, int n, int open, int close)
    {
        
        if(close==n)
        {
            for(int i=0;i<s.length;i++)
            {
                System.out.print(s[i]);
            }
            count++;
            System.out.println();
            return;
        }
        else
        {
            if(open>close)
            {
                s[pos]=')';
                paranthesis(s,pos+1,n,open,close+1);
            }
            if(open<n)
            {
                s[pos]='(';
                paranthesis(s,pos+1,n,open+1,close);
            }
        }
    }
    public void printing(char[] s, int n)
    {
        
        if(n>0)
        {
            paranthesis(s,0,n,0,0);
            //count++;
        }
        
        return;
    }
    public static void main(String[] args) {
        Solution p = new Solution();
        int n;
        n=3;
        char[] s = new char[2*n];
        p.printing(s,n);
        System.out.println(count);

        /*int z=2;
        char[] s1 = new char[2*z];
        p.printing(s1,z);
        System.out.println(count);

        int y=4;
        char[] s2 = new char[2*y];
        p.printing(s2,y);
        System.out.println(count);

        int r=1;
        char[] s3 = new char[2*r];
        p.printing(s3,r);
        System.out.println(count);

        int u=5;
        char[] s4 = new char[2*u];
        p.printing(s4,u);
        System.out.println(count);

        int k=6;
        char[] s5 = new char[2*k];
        p.printing(s5,k);
        System.out.println(count);*/

    }
}



        

        
































 
