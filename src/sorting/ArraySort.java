package sorting;

//Class to wrap all sorting algorithms into a single ArraySort class
public class  ArraySort {

	private ArraySort()
	{
		
	}
	
	public static Integer[] InsertionSort(Integer[] sortArray)
	{
		return InsertionSort.Start(sortArray);
	}
	
	public static Integer[] MergeSort(Integer[] sortArray)
	{
		return MergeSort.Start(sortArray);
	}
	
	public static Integer[] QuickSort(Integer[] sortArray)
	{
		return QuickSort.Start(sortArray);
	}
}
