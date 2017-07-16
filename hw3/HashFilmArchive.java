package movies;

import java.util.ArrayList;
import java.util.HashSet;

public class HashFilmArchive extends HashSet<Movie> implements FilmArchive {

	/**
	 * @return an array list of the sorted movies
	 */
	public ArrayList<Movie> getSorted(){
		ArrayList<Movie> sorted = new ArrayList<Movie>(this);
		return sorted;
	}
	
	public static void main(String[] args){
		HashFilmArchive archive = new HashFilmArchive();
		for (Movie m: Movie.getTestMovies()){
			archive.add(m);
		}
		for (Movie m: archive){
			System.out.println(m);
		}
	}
	
		
	}

