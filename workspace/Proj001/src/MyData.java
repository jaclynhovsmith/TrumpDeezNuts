import java.util.Random;
import java.util.ArrayList;

public class MyData {
	
	private int arraySize;
	private int[] array;

	public MyData(int arraySize){
		this.arraySize = arraySize;
		array = new int[arraySize];
	}
	
	public void loadArray() {
		Random r = new Random();
		for(int i = 0; i < array.length; i++){
			array[i] = r.nextInt(arraySize);
		}
	}
	
	public double mean() {
		int sum = 0;
		for(int i = 0; i < array.length; i++){
			sum += array[i];
		}
		return 1.0*sum/array.length;
	}
	
	public int median() {
		for(int i = 0; i < array.length - 1; i++){
			for(int j = i + 1; j < array.length; j++){
				if(array[j] < array[i]){
					int temp = array[i];
					array[i] = array[j];
					array[j]= temp;
				}
			}
		}
		int middleNumber = array[array.length/2 - 1];
		return middleNumber;
	}
	
	public ArrayList<Integer> mode() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int streak = 0;
		for(int i = 0; i < array.length; i++){
			int tempStreak = 0;
			boolean ran = false;
			for(int j = i + 1; j < array.length - 1; j++){
				if(array[i] == array[j]) {
					tempStreak++;
				}
				if(tempStreak > streak){
					streak = tempStreak;
					list.clear();
					list.add(array[i]);
				} else if(tempStreak == streak && !ran){
					list.add(array[i]);
					ran = true;
				}
				
			}
		}
		return list;
	}
	
	public void showArray() {
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + ", ");
		}
	}
}
