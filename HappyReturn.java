import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HappyReturn {
	// 3명에 대한 배열에 만족도가 저장됨
	// 3명 모두에게 동일한 만족도가 될 수 있도록 배분할 수 있는 경우의 수 return
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int result = 0;
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] foods = new int[N];
		int sum = 0;
		for(int i=0;i<5;i++) {
			foods[i] = Integer.parseInt(st.nextToken());
			sum += foods[i];
		}
		
		int happy = sum / 3;
		
		
		if(foods.length < 3) {
			result = -1;
		}
		
		int sumF = 0;
		for(int i=0;i<foods.length-2;i++){
            sumF += foods[i];

            if(sumF == happy) {
            	System.out.println("[1] : " + i + "값 :" + sumF);
            	int sumS = 0;
            	for(int j=i+1;j<foods.length-1;j++){
            		sumS += foods[j];
            		
            		if(sumS == happy) {
            			System.out.println("[2]: " + j + " 값: " + sumS);
            			int sumT = 0;
            			for(int k=j+1;k<foods.length;k++){
            				sumT += foods[k];

            				if(sumT == happy) {
            					System.out.println("[3] : " + k + "값 :" + sumT);
            					System.out.println("=================");
            					result++;
            				}
            			}
                    }
                }
            }
        }
		
		System.out.println(result);
	}
	
}
