
public class Runner {

	public static void main(String[] args) {
		MyData d = new MyData(666);
		d.loadArray();
		System.out.println("Mean: " + d.mean());
		System.out.println("Median: "+ d.median());
		if(d.mode().size() > 1)
			System.out.println("Mode: " + d.mode());
		else if(d.mode().size() == 1){
			System.out.println("Mode: " + d.mode().get(0));
		}
		System.out.println("Array:");
		d.showArray();

	}

}
