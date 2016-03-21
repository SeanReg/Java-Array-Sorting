package sorting;

//Merge sort sorting algorithm
public class MergeSort {
	
	private MergeSort()
	{
		
	}
	
	public static Integer[] Start(Integer[] sort)
	{
		//Call default SortArray arguments
		return SortArray(sort, 0, sort.length - 1);
	}
	
	private static Integer[] SortArray(Integer[] sort, int p, int r)
	{
		//Base case
		if (p < r)
		{
			//Divide array size in half
			int q = (int) Math.floor((p + r) / 2.0);
			
			//Recursive calls - make further divide the array
			sort = SortArray(sort, p, q);
			sort = SortArray(sort, q + 1, r);
			
			//Merge the two sorted halves
			sort = Merge(sort, p, q, r);
		}
		
		//Return the sorted array
		return sort;
	}
	
	private static Integer[] Merge(Integer[] sort, int p, int q, int r)
	{
		//Find the sizes of the two halves
		int nA = q - p + 1, nB = r - q;
		
		Integer[] L = new Integer[nA + 1], R = new Integer[nB + 1];
		
		//Get the left half
		for (int i = 0; i < nA; ++i)
		{
			L[i] = sort[p + i];
		}
		
		//Get the right half
		for (int j = 0; j < nB; ++j)
		{
			R[j] = sort[q + j + 1];
		}
		
		//Set the last index to a big value
		L[nA] = Integer.MAX_VALUE;
		R[nB] = Integer.MAX_VALUE;
		
		//Merge the two halves into the sorted array
		int i = 0, j = 0;
		for (int k = p; k <= r; ++k)
		{
			if (L[i] <= R[j])
			{
				sort[k] = L[i];
				++i;
			}
			else
			{
				sort[k] = R[j];
				++j;
			}
		}
		
		return sort;
	}
}
