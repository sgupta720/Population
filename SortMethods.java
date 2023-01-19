import java.util.List;
//Sort methods for population
public class SortMethods
{
	 public void merge(int arr[], int left, int mid, int right) {

		    int len1 = mid - left + 1;
		    int len2 = right - mid;

		    int leftArr[] = new int[len1];
		    int rightArr[] = new int[len2];

		    for (int i = 0; i < len1; i++)
		    {
		      leftArr[i] = arr[left + i];
		    }
		    for (int j = 0; j < len2; j++)
		    {
		      rightArr[j] = arr[mid + 1 + j];
		    }

		    int i, j, k;
		    i = 0;
		    j = 0;
		    k = left;
		    while (i < len1 && j < len2) {
		      if (leftArr[i] <= rightArr[j]) {
		        arr[k] = leftArr[i];
		        i++;
		      } else {
		        arr[k] = rightArr[j];
		        j++;
		      }
		      k++;
		    }
		    while (i < len1) {
		      arr[k] = leftArr[i];
		      i++;
		      k++;
		      }
		    while (j < len2) {
		      arr[k] = rightArr[j];
		      j++;
		      k++;
		       }
		  }

		  public void mergeSort(int arr[], int start, int right) {
		    if (start < right) {

		      int mid = (start + right) / 2;

		      mergeSort(arr, start, mid);
		      mergeSort(arr, mid + 1, right);

		      merge(arr, start, mid, right);
		    }
		  }
		  public List<City> selectionSort(List<City> arr)
			{
				int n = arr.size();
		        for (int i = 0; i < n-1; i++)
		        {
		            int min_idx = i;
		            for (int j = i+1; j < n; j++)
		            {
		                if (arr.get(j).population < arr.get(min_idx).population)
		                {
		                    min_idx = j;
		                }
		            }
		 
		      
		            int temp = arr.get(min_idx).population;
		            arr.get(min_idx).population = arr.get(i).population;
		            arr.get(i).population= temp;
		        }
		        return arr;
			}
			 public List<City> insertion(List<City> arr)
			    {
			        int n = arr.size();
			        for (int i = 1; i < n; ++i) {
			            int key = arr.get(i).population;
			            int j = i - 1;
			 
			           
			            while (j >= 0 && arr.get(j).population > key) {
			                arr.get(j+1).population = arr.get(j).population;
			                j = j - 1;
			            }
			            arr.get(j+1).population = key;
			        }
			        return arr;
			    }
		    void bubbleSort(int arr[])
		    {
		        int n = arr.length;
		        for (int i = 0; i < n - 1; i++)
		            for (int j = 0; j < n - i - 1; j++)
		                if (arr[j] > arr[j + 1]) {
		                    // swap arr[j+1] and arr[j]
		                    int temp = arr[j];
		                    arr[j] = arr[j + 1];
		                    arr[j + 1] = temp;
		                }
		    }

}
