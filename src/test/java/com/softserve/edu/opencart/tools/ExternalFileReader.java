package com.softserve.edu.opencart.tools;

import java.util.List;

public abstract class ExternalFileReader {
	public final String FILE_NOT_FOUND_EXCEPTION = "File %s could not be found";
	public final String FILE_NOT_READ_EXCEPTION = "File %s could not be read";
	public final String FILE_NOT_CLOSE_EXCEPTION = "File %s could not be closed";
	//
	public final int PATH_PREFIX = 6;
    public final String PATH_SEPARATOR = "/";
    //
    //public static Logger log = LogManager.GetCurrentClassLogger(); // for Slf4J

    public String name;
    public String path;

    protected ExternalFileReader(String name)
    {
        this.name = name;
		this.path = this.getClass().getResource(PATH_SEPARATOR + name).getPath(); //.substring(1);
    }

    protected ExternalFileReader(String name, String path)
    {
        this.name = name;
        this.path = path;
    }

    // getters
    
    public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public List<List<String>> getAllCells()
    {
        return getAllCells(path);
    }

    public abstract List<List<String>> getAllCells(String path);
}
