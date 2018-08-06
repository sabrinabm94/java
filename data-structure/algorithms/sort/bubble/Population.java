package ordenacoes;

public class Population {
	public void crescent(int v[]){
		for(int i = 0; i  < v.length; i++){
			v[i] = i + 1;
			System.out.println("Crescent - added value: " + v[i]);
		} 
	}
	public void decreasing(int v[]){
		for(int i = v.length -1;  i >= 0; i--){
			v[i] = i +1;
			System.out.println("Decreasing - added value: " + v[i]);
		}
	}
	public void random(int v[]){
		for(int i = 0; i < v.length; i++){
			v[i] = (int)(Math.random()*100);	
			System.out.println("Random - added value: " + v[i]);
		}		
	}
}
