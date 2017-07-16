package movies;

public class TreeAnalyzer {

	/**
	 * Test the speed of the TreeFilmArchive by creating and inserting one hundred thousand fake movies
	 */
	public static void main(String[] args) {
		TreeFilmArchive archive = new TreeFilmArchive();
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
