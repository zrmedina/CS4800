
public class Search {
	
	public Search() {
		
	}
	
	public int binarySearch(int[] array, int searchValue) { 
		   int first; int last; int middle; int position;  
		   boolean found; // Flag 
		   first = 0; last = array.length - 1; position = -1; found = false; 
		   while (!found && first <= last) { 
			   middle = (first + last) / 2; 
			   if (array[middle] == searchValue) 
		         	{found = true; position = middle;} 
			   else if (array[middle] > searchValue) 
				   last = middle - 1; 
			   else 
				   first = middle + 1; 
		   } 
		   return position; 
	}
}
