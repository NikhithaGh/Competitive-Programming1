import java.util.*;
class KeysAndRooms
{
	public static void main(String[] args) {

		int t[][] = new int[][]{
			{1},
			{0,2}, 
			{3},
		};
		System.out.println(ifAll(t));

		int t1[][] = new int[][]{
			{1,3},
			{3,0,1},
			{2},
			{0}
		};
		System.out.println(ifAll(t1));

		int t2[][] = new int[][]{
			{1,2,3},
			{0},
			{0},
			{0}
		};
		System.out.println(ifAll(t2));

		int t3[][] = new int[][]{
			{1},
			{0,2,4},
			{1,3,4}, 
			{2}, 
			{1,2}
		};
		System.out.println(ifAll(t3));

		int t4[][] = new int[][]{
			{1},
			{2,3},
			{1,2}, 
			{4}, 
			{1}, 
			{5}
		};
		System.out.println(ifAll(t4));

		int t5[][] = new int[][]{
			{1}, 
			{2}, 
			{3}, 
			{4}, 
			{2}
		};
		System.out.println(ifAll(t5));

		int t6[][] = new int[][]{
			{1}, 
			{1,3}, 
			{2}, 
			{2,4,6}, 
			{}, 
			{1,2,3}, 
			{1}
		};
		System.out.println(ifAll(t6));
		
	}

	public static boolean ifAll(int t[][])
	{
		boolean r[] = new boolean[t.length+1];
		boolean w[] = new boolean[t.length+1];
		for(int i=0;i<t.length;i++)
		{
			for(int j=0;j<t[i].length;j++)
			{
				r[t[i][j]]= true;
			}
		}
		//System.out.println(Arrays.toString(r));

		for(int y=0;y<t.length;y++)
		{
			if(y!=0 && r[y]!=true)
			{

				return false;
			}
		}

		for(int k=0;k<t.length;k++)
		{
				//System.out.println("in forloop");
			for(int f=0;f<t[k].length;f++)
			{
				
				if(w[t[k][f]]!= true)
				{
					if((t[k][f]!=0) && (t[k][f] <= k))
					{
						return false;
					}
				}
				//System.out.println(w[t[k][f]]);
				w[t[k][f]]=true;

			}
		}
		return true;
	}
}