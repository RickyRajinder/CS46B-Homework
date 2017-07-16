package movies;

import java.util.ArrayList;
import java.util.TreeSet;

public class TreeFilmArchive extends TreeSet<Movie> implements FilmArchive {

	/**
	 * @return an array list of the sorted movies
	 */
	public ArrayList<Movie> getSorted(){
		ArrayList<Movie> sorted = new ArrayList<Movie>(this);
		return sorted;
	}
	
	/**
	 * Main method to test the archive
	 */
	public static void main(String[] args){
		TreeFilmArchive archive = new TreeFilmArchive();
		for (Movie m: Movie.getTestMovies()){
			archive.add(m);
		}
		for (Movie m: archive){
			System.out.println(m);
		}
	}
	
}
