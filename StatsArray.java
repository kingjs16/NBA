
import java.util.*;
import java.io.File;

public class StatsArray
{
	Stats[] sa;
	int n;
	final int maxRecords = 1000;

	/*
	* @return stats array from readFile();
	*/
	public StatsArray()
	{
		sa = new Stats[maxRecords];
		readFile();
	}

	/*
	* @return file at root directory called data.txt
	*/
	public void readFile()
	{
		try {
			Scanner sc = new Scanner(new File("data.txt"));
			int i = 0;

			while (sc.hasNext())
			{
				String s = sc.nextLine();
				String[] sd = s.split(",");
				sa[i] = new Stats(sd[0], sd[1], sd[2], Double.parseDouble(sd[3]),Double.parseDouble(sd[4]),Double.parseDouble(sd[5]),Double.parseDouble(sd[6]));
				i++;

		}
			n = i;
			sc.close();
		} catch (Exception e) {
			System.out.println("Exception with StatsArray readFile");
		}
	}

	/*
	* @return total minutes for all teams in data set
	*/

	public double calcTotalMinutes()
	{
		double total = 0;
		for(int i=0; i<n; i++)
		{
			total += sa[i].getMinutes();
		}
		return total;
	}

	/*
	* @return total points for all teams in data set
	*/

	public double calcTotalPoints()
	{
		double total = 0;
		for(int i=0; i<n; i++)
		{
			total += sa[i].getPoints();
		}
		return total;
	}

	/*
	* @return total rebounds for all teams in data set
	*/

	public double calcTotalRebounds()
	{
		double total = 0;
		for(int i=0; i<n; i++)
		{
			total += sa[i].getRebounds();
		}
		return total;
	}

	/*
	* @return total assists for all teams in data set
	*/

	public double calcTotalAssists()
	{
		double total = 0;
		for(int i=0; i<n; i++)
		{
			total += sa[i].getAssists();
		}
		return total;
	}

	/*
	* @param Stats s1
	* @param Stats s2
	* @return comparison of params
	*/

	class SortByName implements Comparator<Stats>
	{
		public int compare(Stats s1, Stats s2)
		{
			return s1.getName().compareTo(s2.getName());
		}
	}

	/*
	* @return array of all players sorted by name alphabetically
	*/

	public void sortByName()
	{
		Arrays.sort(sa, 0, n, new SortByName());
	}

	/*
	* @param Stats s1
	* @param Stats s2
	* @return comparison of params
	*/

	class SortByTeam implements Comparator<Stats>
	{
		public int compare(Stats s1, Stats s2)
		{
			return s1.getTeam().compareTo(s2.getTeam());
		}
	}

	/*
	* @return array of all players sorted by team alphabetically
	*/

	public void sortByTeam()
	{
		Arrays.sort(sa, 0, n, new SortByTeam());
	}

	/*
	* @param Stats s1
	* @param Stats s2
	* @return comparison of params
	*/

	class SortByMinutes implements Comparator<Stats>
	{
		public int compare(Stats s1, Stats s2)
		{
			if (s1.getMinutes() > s2.getMinutes() ) return -1;
			else if (s1.getMinutes() < s2.getMinutes() ) return 1;
			else return 0;
		}
	}

	/*
	* @return array of all players sorted by MPG alphabetically
	*/

	public void sortByMinutes()
	{
		Arrays.sort(sa, 0, n, new SortByMinutes());
	}

	/*
	* @param Stats s1
	* @param Stats s2
	* @return comparison of params
	*/

	class SortByPoints implements Comparator<Stats>
	{
		public int compare(Stats s1, Stats s2)
		{
			if (s1.getPoints() > s2.getPoints() ) return -1;
			else if (s1.getPoints() < s2.getPoints() ) return 1;
			else return 0;
		}
	}

	/*
	* @return array of all players sorted by PPG alphabetically
	*/

	public void sortByPoints()
	{
		Arrays.sort(sa, 0, n, new SortByPoints());
	}

	/*
	* @param Stats s1
	* @param Stats s2
	* @return comparison of params
	*/

	class SortByRebounds implements Comparator<Stats>
	{
		public int compare(Stats s1, Stats s2)
		{
			if (s1.getRebounds() > s2.getRebounds() ) return -1;
			else if (s1.getRebounds() < s2.getRebounds() ) return 1;
			else return 0;
		}
	}

	/*
	* @return array of all players sorted by RPG alphabetically
	*/

	public void sortByRebounds()
	{
		Arrays.sort(sa, 0, n, new SortByRebounds());
	}

	/*
	* @param Stats s1
	* @param Stats s2
	* @return comparison of params
	*/

	class SortByAssists implements Comparator<Stats>
	{
		public int compare(Stats s1, Stats s2)
		{
			if (s1.getAssists() > s2.getAssists() ) return -1;
			else if (s1.getAssists() < s2.getAssists() ) return 1;
			else return 0;
		}
	}

	/*
	* @return array of all players sorted by APG alphabetically
	*/

	public void sortByAssists()
	{
		Arrays.sort(sa, 0, n, new SortByAssists());
	}

	/*
	* @param fname
	* @param lname
	* @return records for player with the correct fname and lname
	*/

	public String listPlayer(String fname, String lname)
	{
		String s = "";

		for (int i=0; i<n; i++)
			if (fname.equalsIgnoreCase(sa[i].getFirst()) &&
				lname.equalsIgnoreCase(sa[i].getLast()))
					s += sa[i] + "\n";

		return s;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
 	*/

	public String toString()
	{
		String s = "";

		for (int i=0; i<n; i++)
			s += sa[i] + "\n";

		return s;
	}
}