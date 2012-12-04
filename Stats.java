public class Stats
{
	String first;
	String last;
	String team;
	double minutes;
	double rebounds;
	double assists;
	double points;

	/**
	 * @param first
	 * @param last
	 * @param team
	 * @param minutes
	 * @param rebounds
	 * @param assists
	 * @param points
	 */
	public Stats(String first, String last, String team, double minutes,
			double rebounds, double assists, double points) {
		this.first = first;
		this.last = last;
		this.team = team;
		this.minutes = minutes;
		this.rebounds = rebounds;
		this.assists = assists;
		this.points = points;
	}

	/**
	 * @return the first
	 */
	public String getFirst() {
		return first;
	}

	/**
	 * @param first the first to set
	 */
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * @return the last
	 */
	public String getLast() {
		return last;
	}

	/**
	 * @param last the last to set
	 */
	public void setLast(String last) {
		this.last = last;
	}

	/**
	 * @return the team
	 */
	public String getTeam() {
		return team;
	}

	/**
	 * @param team the team to set
	 */
	public void setTeam(String team) {
		this.team = team;
	}

	/**
	 * @return the minutes
	 */
	public double getMinutes() {
		return minutes;
	}

	/**
	 * @param minutes the minutes to set
	 */
	public void setMinutes(double minutes) {
		this.minutes = minutes;
	}

	/**
	 * @return the rebounds
	 */
	public double getRebounds() {
		return rebounds;
	}

	/**
	 * @param rebounds the rebounds to set
	 */
	public void setRebounds(double rebounds) {
		this.rebounds = rebounds;
	}

	/**
	 * @return the assists
	 */
	public double getAssists() {
		return assists;
	}

	/**
	 * @param assists the assists to set
	 */
	public void setAssists(double assists) {
		this.assists = assists;
	}

	/**
	 * @return the points
	 */
	public double getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(double points) {
		this.points = points;
	}

	/**
	* @return the last name, first name
	*/
	public String getName() {
		return last + ", " + first;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return first + ", " + last + ", " + team + ", \t MPG: " + minutes + ", RPG:" + rebounds	+ ", APG:" + assists + ", PPG:" + points;
	}

	public static void main(String[] args) {
		Stats stats = new Stats("Marco", "Belinelli", "Bulls", 21.2, 1.7, 1.3, 8.7);
		System.out.println(stats);
	}
}