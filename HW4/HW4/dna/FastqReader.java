package dna;

import java.io.*;


/**
 * Read from a buffered reader to construct a fastq record
 * @author singh
 *
 */


public class FastqReader 
{
	private BufferedReader theBufferedReader;
	
	public FastqReader(BufferedReader theBufferedReader){
		this.theBufferedReader = theBufferedReader;
	}
	
	/**
	 * Uses buffered reader to construct a Fastq record
	 * @return a FastqRecord as long as the file is not null
	 * @throws IOException
	 * @throws RecordFormatException
	 */
	public FastqRecord readRecord() throws IOException, RecordFormatException
	{
		// Reads the defline. If null, eof has been reached so returns null
		String currentLine = theBufferedReader.readLine();
		if (currentLine == null){
			return null;
		}
		// Read the sequence line, the plus sign line, and the quality line
		// Then construct a FastqRecord using the defline, sequence, and quality
		String nextLine = theBufferedReader.readLine();
		// nextLine1 is skipped because it is the '+' line
		String nextLine1 = theBufferedReader.readLine();
		String nextLine2 = theBufferedReader.readLine();
		return new FastqRecord(currentLine, nextLine, nextLine2);

	}
}
