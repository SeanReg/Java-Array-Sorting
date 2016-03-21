package sorting;

//Insertion sort sorting algorithm
public class InsertionSort {
	//Do not allow the class to be instanced
	private InsertionSort()
	{
		
	}
	
	//Insertion sort algorithm 
	public static Integer[] Start(Integer[] sort)
	{
		//Loop through array
		for (int i = 1; i < sort.length; ++i)
		{
			Integer key = sort[i];
			
			//Swap keys of a lesser value
			int j = i - 1;
			while (j >= 0 && sort[j] > key)
			{
				sort[j + 1] = sort[j];
				--j;
			}
			
			sort[j + 1] = key;
		}
		
		//Return sorted array
		return sort;
	}
}
