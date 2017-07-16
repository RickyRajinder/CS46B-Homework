package movies;

import java.util.ArrayList;
import java.util.TreeSet;

public class ListFilmArchive extends ArrayList<Movie> implements FilmArchive {
	
	/**
	 * @Override
	 */
	public boolean add(Movie m){
		for (int i = 0; i < this.size(); i++){
			if (m.equals(this.get(i)) == true){
				return false;
			}
		}
		boolean reallyAdded = super.add(m);
		return reallyAdded;
	}
	
	/**
	 * @return a sorted array list of movies
	 */
	public ArrayList<Movie> getSorted(){
		TreeSet<Movie> treeMovie = new TreeSet<Movie>(this);
		ArrayList<Movie> sorted = new ArrayList<Movie>(treeMovie);
		return sorted;
	}
	
	public static void main(String[] args){
		ListFilmArchive archive = new ListFilmArchive();
		for (Movie m: Movie.getTestMovies()){
			archive.add(m);
		}
		for (Movie m: archive){
			System.out.println(m);
		}
	}
	
}
