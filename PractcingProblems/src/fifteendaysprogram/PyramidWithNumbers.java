package fifteendaysprogram;

public class PyramidWithNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		1 
//		2 2 
//		3 3 3 
//		4 4 4 4 
//		5 5 5 5 5 
	/*	
		int n = 5;
		
		for(int i = 1; i<=n; i++)
		{
			for(int j=1; j<=i;j++)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}
*/
		
//		1 
//		1 2 
//		1 2 3 
//		1 2 3 4 
//		1 2 3 4 5 
		
	/*	int rows = 5;
		for(int i=1; i<=rows; i++)
		{
			for(int j= 1; j<=i; j++)
			{
				System.out.print(j+" ");
			}
			System.out.println();
		}
		*/
//		0 
//		1 2 
//		3 4 5 
//		6 7 8 9 
//		10 11 12 13 14
	/*	
		int rows = 5;
		int count = 0;
		for(int i = 1; i<=rows; i++)
		{
			for(int j=1;j<=i; j++)
			{
				System.out.print(count+" ");
				count++;
			}
			System.out.println();
		}
		
		*/
		
		int rows = 5;
		
		for(int i = 1; i<=rows; i++)
		{
			for(int j=5;j>=i; j--)
			{
				System.out.print(i+" ");
			}
//			for(int k=0; k>=i; k++)
//			{
//				System.out.print(" ");
//			}
			System.out.println();
		}
	}

}
