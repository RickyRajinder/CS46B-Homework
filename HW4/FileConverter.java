package dna;

import java.io.*;
import java.util.*;


public class FileConverter 
{
	
	//
	// Writes a fasta file consisting of conversion of all records from the fastq with
	// sufficient quality and unique defline.
	//
	// Use a HashSet<String> to check for unique deflines. When you read a fastq record,
	// check if its defline is in the set. If it's in the set, don't do anything with the
	// record. If the defline isn't in the set, add it to the set, build a fasta record,
	// and write the fasta record using the fasta writer.
	//
	public void convert() throws IOException
	{
		// Build chain of readers.
		FileReader fr = 
		BufferedReader br = 
		FastqReader fqr =

		// Build chain of writers.
		FileWriter fw =
		PrintWriter pw = 
		FastaWriter faw = 
		
		// Read, translate, write.
		
		// Close fr, br, fw, and pw in reverse order of creation.
	}
	
		
	
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
		catch (IOException x)
		{
			System.out.println(x.getMessage());
		}
		System.out.println("Done");
	}
}
