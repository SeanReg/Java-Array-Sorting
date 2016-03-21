package sorting;

//Quick sort sorting algorithm
public class QuickSort {

	public static Integer[] Start(Integer[] sort)
	{
		return SortArray(sort, 0, sort.length - 1);
	}
	
	private static Integer[] SortArray(Integer[] sort, int p, int r)
	{
		//Base case
		if (p < r)
		{
			//Partition the array
			int q = Partition(sort, p, r);
			//Recursive calls
			SortArray(sort, p, q - 1);
			SortArray(sort, q + 1, r);
		}	
		
		return sort;
	}
	
	private static int Partition(Integer[] sort, int p, int r)
	{
		//Get the back value
		int x = sort[r].intValue();
		
		int i = p - 1;
		for (int j = p; j <= r - 1; ++j)
		{
			//Check the back value against the front
			if (sort[j].intValue() <= x)
			{
				//Swap if the back is less
				++i;
				Integer temp = sort[i];
				sort[i] = sort[j];
				sort[j] = temp;
			}
		}
		//Swap the back 
		Integer temp = sort[i + 1];
		sort[i + 1] = sort[r];
		sort[r] = temp;
		
		//Return the next q
		return i + 1;
	}
}