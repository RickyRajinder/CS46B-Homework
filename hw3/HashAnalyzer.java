package movies;


public class HashAnalyzer {

	/**
	 * Test the speed of the HashFilmArchive by creating and inserting one hundred thousand fake movies
	 */
	public static void main(String[] args) {
		HashFilmArchive archive = new HashFilmArchive();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++){
			archive.add(new Movie("Movie" + i, 2017));
			if (i%1000 == 0){
				System.out.println(i);
			}
		}
		long finishTime = System.currentTimeMillis();
		System.out.println("That took: "+(finishTime-startTime)+ " ms");

	}

}
