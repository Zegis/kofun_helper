import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LinesCounter{
	
	private RandomAccessFile file;
	private String filter; 
	
	public LinesCounter(String fileToAccess){
		
		try{
			file = new RandomAccessFile(fileToAccess, "rw");
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		
		filter = "";
	}
	
	public LinesCounter(String fileToAccess, String filter)
	{
		this(fileToAccess);
		
		this.filter = new String(filter);
	}
	
	public int countAllLines(){
		
		int ret = 0;
		
		try
		{
			while(file.readLine() != null)
			{
				ret++;
			}
			
			return ret;
		}
		catch(IOException e)
		{
			ret = 0;
			return ret;
		}
	}
	
	public int countLinesWithFilter(){
		if(filter.isEmpty())
			return countAllLines();
		else{
			System.out.println(filter);
			int ret = 0;
			String currLine;
			try{
				file.seek(0);
				
				while( (currLine = file.readLine()) != null)
					if(currLine.contains(filter))
						++ret;
				
			}
			catch(IOException e){
				ret = 0;
			}
			
			return ret;
		}
	}
	
	public void setFilter(String filterToApply){
		if(!filterToApply.equals(filter))
			filter = "(" +	filterToApply + ")";
	}
	
}
