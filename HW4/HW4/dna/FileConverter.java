package dna;

import java.io.*;
import java.util.*;


public class FileConverter 
{
	private File fasta;
	private File fastq;
	
	public FileConverter(File fastq, File fasta){
		this.fastq = fastq;
		this.fasta = fasta;
	}
	
	/**
	 * Converts a Fastq file into a Fasta file
	 * Will only translate a fastq record if its defline starts with '@'
	 * if it's quality is high
	 * and if it has not already been translated
	 * @throws IOException
	 * @throws RecordFormatException
	 */
	public void convert() throws IOException, RecordFormatException
	{
		// Input stream: chain of readers to read the fastq file
		FileReader fr = new FileReader(fastq);
		BufferedReader br = new BufferedReader(fr);
		FastqReader fqr = new FastqReader(br);
		
		// Output stream: chain of writers to write the fasta file
		FileWriter fw = new FileWriter(fasta);
		PrintWriter pw = new PrintWriter(fw);
		FastaWriter faw = new FastaWriter(pw);
		
		// Uses a HashSet to store unique deflines. 
		// Reads through each fastq record until eof is reached (null)
		// Will only translate a fastqrecord and write a fasta record if the defline has not already appeared,
		// if the first char is '@'
		// and if the quality of the record is high
		Set<String> hash = new HashSet<String>();
		boolean done = false;
		while (!done){
			try {
			FastqRecord fastqrec = fqr.readRecord();
			if (fastqrec == null){
				done = true;
				break;
			}
			if (!hash.contains(fastqrec.getDefline()) && fastqrec.getDefline().charAt(0)=='@' && fastqrec.qualityIsHigh()){
				hash.add(fastqrec.getDefline());
				FastaRecord fastarec = new FastaRecord(fastqrec);
				faw.writeRecord(fastarec);
			}
			}
			catch (RecordFormatException x){
				x.printStackTrace();
			}
		}
		
		// Closes the I/O streams fr, br, fw, and pw in reverse order of creation.
		pw.close();
		fw.close();
		br.close();
		fr.close();
	}
	
		
	/**
	 * Main method to test FileConverter
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("Starting");
		try
		{
			File fastq = new File("data/HW4.fastq");
			if (!fastq.exists())
			{
				System.out.println("Can't find input file " + fastq.getAbsolutePath());
				System.exit(1);
			}
			File fasta = new File("data/HW4.fasta");
			FileConverter converter = new FileConverter(fastq, fasta);
			converter.convert();
		}
		catch (IOException | RecordFormatException x)
		{
			System.out.println(x.getMessage());
			x.printStackTrace();
		}
		System.out.println("Done");
	}
}
