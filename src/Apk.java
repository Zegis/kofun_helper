import java.util.LinkedList;

public class Apk {

	public static void main(String args[])
	{
				
		if(args.length > 0)
		{
			System.out.println(args[1]);
			
			LinesCounter counter = new LinesCounter(args[0],args[1]);
			
			System.out.println("There are " + counter.countLinesWithFilter() + " lines in " + args[0] + " file."  );
			
			LinkedList<String> tmp = counter.getLinesWithFilter();

			for(int i = 0; i < tmp.size(); ++i)
			{
				System.out.println(tmp.get(i));
			}
		}
		else
		{
			System.out.println("Need filename!");
		} 
	}	
}
