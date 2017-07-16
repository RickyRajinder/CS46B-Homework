package movies;

/*
 * A class that models a movie. 
 * Has instance variables title and year. 
 * @author Ricky Singh
 */
public class Movie implements Comparable<Movie> {
	
private String title;
private int year;

	public Movie(String title, int year){
		this.title = title;
		this.year = year;
	}
	
	/**
	 * @return the title of the movie
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * @return the year the movie was released
	 */
	public int getYear(){
		return year;
	}
	
	/**
	 * 
	 * @param other a Movie to test equality
	 * @return true if the movies have the same year and title, otherwise false
	 */
	public boolean equals(Object other){
		return (this.compareTo((Movie) other) == 0);
	}
		
	
	@Override
	public int hashCode(){
		return title.hashCode() + year;
	}
	
	public int compareTo(Movie other){
		if (this.title.compareTo(other.title) !=0){
			return this.title.compareTo(other.title);
		}
			return Integer.compare(this.year, other.year);
		}
	
	/**
	 * @return the string form of the movie
	 */
	public String toString(){
		return "Movie " + title + " (" + year + ")"; 
		}
	/**
	 * @return an array of 10 unique movies
	 * 
	 */
	public static Movie[] getTestMovies(){ 
		Movie movie1 = new Movie("The Thomas Crown Affair", 1968);
		Movie movie2 = new Movie("The Thomas Crown Affair", 1999);
		Movie movie3 = new Movie("The Martian", 2015);
		Movie movie4 = new Movie("Bridge of Spies", 2015);
		Movie movie5 = new Movie("Hancock", 2008);
		Movie movie6 = new Movie("Hancock", 2008);
		Movie movie7 = new Movie("I Am Legend", 2007);
		Movie movie8 = new Movie("Concussion", 2015);
		Movie movie9 = new Movie("Independence Day", 1996);
		Movie movie10 = new Movie("Focus", 2015);
		Movie[] test = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10};
		return test;
	}
	
	public static void main(String[] args){
		Movie movie3 = new Movie("The Martian", 2015);
		Movie movie4 = new Movie("The Martian", 2015);
		int t = movie3.compareTo(movie4);
		boolean o = movie3.equals(movie4);
		System.out.println(t + "\n" + o);
		}
}


