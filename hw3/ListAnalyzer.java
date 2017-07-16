package movies;

public class ListAnalyzer {
	
	/**
	 * Test the speed of the ListFilmArchive by creating and inserting one hundred thousand fake movies
	 */
	public static void main(String[] args) {
		ListFilmArchive archive = new ListFilmArchive();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++){
			archive.add(new Movie("Movie" + i, 2017));
			if (i%1000 == 0){
				System.out.println(i);
			}
		}
		long finishTime = System.currentTimeMillis();
		System.out.println("That took: "+(finishTime-startTime)+ " sec");
	}

}
