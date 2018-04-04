package normal;

import org.apache.lucene.search.highlight.SimpleHTMLFormatter;

public class MyFormatter extends SimpleHTMLFormatter{
	public MyFormatter(){
		super("<font color='lightblue' size=8>","</font>");
	}
}
