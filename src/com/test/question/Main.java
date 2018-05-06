package question;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int i=0; 
		//		System.out.println(test());
		//		System.out.println(Planet.MERCURY==Planet.VENUS);
		//		System.out.println(Planet.MERCURY.equals(Planet.MERCURY));
		double[][] pts=new double[100000][2];
		for (i = 0; i < pts.length ; i++)				   
		{								   
			pts[i][0]=Math.random();      // Throw a dart			   
			pts[i][1]=Math.random();						   
		}	
		System.out.println(approx(pts));
		//locateUniverseFormula();
		int coins[] = {2,5,10};
        System.out.println("Result: " +
				Soluction.monnaieOptimale(42).piece10);
	}
	public static int test(){
		ArrayList l=new ArrayList(2);
		l.add(1);
		l.add(1);
		l.add(1);
		return l.size();
	}

	enum Planet{
		MERCURY,VENUS,EARTH
	}
	public static double approx(double[][] pts){
		int i;								   
		int nThrows = 0;						   
		int nSuccess = 0;						   

		double x, y;							   

		for (i = 0; i < pts.length ; i++)				   
		{								   
			x = pts[i][0];      // Throw a dart			   
			y = pts[i][1];						   
			nThrows++;							   
			if ( x*x + y*y <= 1 )		   
				nSuccess++;						   
		}								   
		//	      System.out.println("Pi/4 = " + (double)nSuccess/(double)nThrows ); 
		return 4*(double)nSuccess/(double)nThrows; 
	}
	public static String locateUniverseFormula() throws IOException{
		Path startDir = Paths.get("C:\\");

		String pattern = "*.{txt,doc}";

		FileSystem fs = FileSystems.getDefault();
		final PathMatcher matcher = fs.getPathMatcher("glob:" + pattern);

		FileVisitor<Path> matcherVisitor = new SimpleFileVisitor<Path>() {
		    @Override
		    public FileVisitResult visitFile(Path file, BasicFileAttributes attribs) {
		        Path name = file.getFileName();
		        if (matcher.matches(name)) {
		            System.out.print(String.format("Found matched file: '%s'.%n", file));
		        }
		        return FileVisitResult.CONTINUE;
		    }
		};
		Files.walkFileTree(startDir, matcherVisitor);
		return pattern;

	}
}
