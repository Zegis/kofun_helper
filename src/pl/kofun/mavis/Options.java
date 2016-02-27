package pl.kofun.mavis;

import java.util.Hashtable;

public class Options {

	private Hashtable<String, String> options;
	private OptionsStream parser;
	
	public Options(String[] args)
	{
		parser = new ArgumentParser();
		options = parser.load(args);
	}
	
	public String get(String key)
	{
		return options.get(key);
	}
	
	public boolean containsKey(String key)
	{
		return options.containsKey(key);		
	}
}
