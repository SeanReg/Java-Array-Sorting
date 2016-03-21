package sorting;


//Class used to test the speed of each sorting algorithm
public class SortSpeed {
	private static Integer[][] testArray;
	private static final int maxRandom = 32767;
	private static final int algorithmCount = 3;
	
	private SortSpeed()
	{
		
	}
	
	public static void Test(int iterations, int nStart, int nFinal, int nStep)
	{
		//Create an array of iterations x nFinal size and fill it with random values
		//Between 0 and maxRandom
		GenerateArray(iterations, nFinal);
		
		
		//Long[][] timeAlg = new Long[3][nFinal + 1];
		
		long averageRuntime = 0L;
		//Loop for all sorting algorithms
		for (int alg = 1; alg <= algorithmCount; ++alg)
		{
			//Multiple cycles from nStart to nFinal by nStep
			for (int k = nStart; k <= nFinal; k += nStep)
			{
				//timeAlg[alg - 1][k] = 0L;
				averageRuntime = 0L;
				//Multiple iterations for each cycle
				for (int i = 0; i < iterations; ++i)
				{
					//Copy a section from the generated array
					//To a new unsorted array
					Integer[] unsortedArray = new Integer[k];
					for (int j = 0; j < k; ++j)
					{
						unsortedArray[j] = testArray[i][j];
					}
					
					//Log the nanoTime
					long startTime = System.nanoTime();
					
					//Do the appropriate sorting algorithm
					DoAlg(unsortedArray, alg);
					
					//Find the amount of nanoTime it took and add it to the average
					averageRuntime += System.nanoTime() - startTime;
					//timeAlg[alg - 1][k] += System.nanoTime() - startTime;
					//System.out.println("Single time: " + (System.nanoTime() - startTime));
				}
				//timeAlg[alg - 1][k] /= iterations;
				
				//Calculate average
				averageRuntime /= iterations;
				
				//Output results for each cycle
				System.out.println("Alg " + alg + " Average runtime for cycle " + k + " is " + averageRuntime + " nanoseconds or " + averageRuntime / 1000 + " microseconds" ); //+ timeAlg[alg - 1][k] + " nano seconds");
			}
			System.out.println("\n");
		}

	}
	
	private static Integer[] DoAlg(Integer[] sortArray, int algNum)
	{
		//Assign an algorithm number to each sorting algorithm
		switch(algNum)
		{
		case 1:
			ArraySort.InsertionSort(sortArray);
			break;
		case 2:
			ArraySort.MergeSort(sortArray);
			break;
		case 3:
			ArraySort.QuickSort(sortArray);
			break;
		}
		
		return sortArray;
	}
	
	private static Integer[][] GenerateArray(int m, int n)
	{
		//Create a new array
		testArray = new Integer[m][n];
		
		for (int i = 0; i < m; ++i)
		{
			for (int j = 0; j < n; ++j)
			{
				//Generate a random number for the array index
				testArray[i][j] = new Integer((int)(Math.random() * maxRandom));
			}
		}
		
		//Return generated array
		return testArray;
	}
}
