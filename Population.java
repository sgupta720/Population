import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *	Population - <description goes here>
 *
 *	Requires FileUtils and Prompt classes.
 *
 *	@author	Sahil Gupta
 *	@since	Jan 10 2022
 */
public class Population {
	
	// List of cities
	private List<City> cities = new ArrayList<City>();  ;
	long startMillisec = 0;
	long endMillisec = 0;
	// US data file
	private  String DATA_FILE = "usPopData2017.txt";
	public static void main(String[] args)
	{
		Population pop = new Population();
		pop.printIntroduction();
		pop.run();
	}
	
	public void printArr(List<City> arr)
	{
        long endMillisec = System.currentTimeMillis();
		Scanner scan = FileUtils.openToRead("usPopData2017.txt");
		int i  = arr.size()-1;
		 System.out.printf("%-22s %-22s %-12s %12s", "State", "City", "Type","Population");
		 System.out.println();
		while(i>(arr.size()-50))
		{
			System.out.println(arr.get(i).toString());
			i--;
		}
		System.out.println();
		System.out.println("Elapsed Time: "+endMillisec+" milliseconds");
		System.out.println();
		run();
	}
	//runner method which calls different sort methods
	public void run()
	{
		SortMethods sort = new SortMethods();
		
		Scanner scan = new Scanner(System.in);
		readFile();
		int input = 0;
		while(input!=9)
		{
			System.out.println("31765 cities in database\n");
			 startMillisec = 0;
			 endMillisec = 0;
			printMenu();
			input = Prompt.getInt(("Enter selection"));
			if(input ==1) { 
				long startMillisec = System.currentTimeMillis();
				printArr(sort.selectionSort(cities));
				
			
			}
			if(input ==2) { }
			if(input ==3) {} 
			if(input ==4) {}
			if(input ==5) {}
			if(input ==6) {}
			if(input ==7) {}
			if(input ==8) {}
			
			else {
				System.exit(1);
			}
		}
	}
	//stores data and reads file
	public void readFile()
	{
		FileUtils file = new FileUtils();
		Scanner sca = file.openToRead("usPopData2017.txt");
		sca.useDelimiter("[\t\n]");

		int numOfCities  = 0;
		String line = "";
		int i = 0;
		String state = "";
		String type = "";
		String name = "";
		String population ="";
		while(sca.hasNext())
		{
			numOfCities++;
			line = sca.next();
			
			if(i==0)
			{
				state=line;
			}
			else if(i==1)
			{
				name = line;
			}
			else if(i==2)
			{
				type = line;
			}
			else if(i==3)
			{
				population = line;
				cities.add(new City(state,name,type,Integer.parseInt(population)));
				
				i=-1;
			}
		i++;
			
		}
		
	}
	/**	fifty most populous cities in given state
	 *	@param 				array
	 *	@return				sorted array
	 */
	public void mostPopulous(List<City> arr,String city)
	{
	      int n = arr.size();
	        for (int i = 0; i < n - 1; i++)
	            for (int j = 0; j < n - i - 1; j++)
	                if (arr.get(j).population > arr.get(j+1).population) {
	                    // swap arr[j+1] and arr[j]
	                    int temp = arr.get(j).population;
	                    arr.get(j).population = arr.get(j+1).population;
	                    arr.get(j+1).population = temp;
	                }
	        printArr(arr);
	    }
	/**	 All cities matching a name sorted by population
	 *	@param other		array of cities
	 *	@return sorted cities		
	 */
	public void matchName(List<City> arr,String city)
	{
		for(int i = 0;i<arr.size();i++)
		{
			if(arr.get(i).name.equals(city))
			{
				System.out.println(arr.get(i).name+arr.get(i).state);
			}
		}
	}
	


	/**	Prints the introduction to Population */
	public void printIntroduction() {
		System.out.println("   ___                  _       _   _");
		System.out.println("  / _ \\___  _ __  _   _| | __ _| |_(_) ___  _ __ ");
		System.out.println(" / /_)/ _ \\| '_ \\| | | | |/ _` | __| |/ _ \\| '_ \\ ");
		System.out.println("/ ___/ (_) | |_) | |_| | | (_| | |_| | (_) | | | |");
		System.out.println("\\/    \\___/| .__/ \\__,_|_|\\__,_|\\__|_|\\___/|_| |_|");
		System.out.println("           |_|");
		System.out.println();
	}
	
	/**	Print out the choices for population sorting */
	public void printMenu() {
		System.out.println("1. Fifty least populous cities in USA (Selection Sort)");
		System.out.println("2. Fifty most populous cities in USA (Merge Sort)");
		System.out.println("3. First fifty cities sorted by name (Insertion Sort)");
		System.out.println("4. Last fifty cities sorted by name descending (Merge Sort)");
		System.out.println("5. Fifty most populous cities in named state");
		System.out.println("6. All cities matching a name sorted by population");
		System.out.println("9. Quit");
	}
	
}