package question;
//Transformez la methode Counter.increment() pour que elle supporte l'accès concurrentiel de plusieurs threads?
public class Counter {
	private static int count=0;
	public static int increment(){
		count=count+1;
		return count;
	}
}
