import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Battleship {
	public char[] Rowindex = {'A', 'B', 'C', 'D', 'E', 'F', 'I', 'J'};
	
	public static void main(String[] args) throws IOException {
		String fulladdress = "C:\\Users\\user\\eclipse-workspace\\PA2\\src\\";
		Scanner scan = new Scanner(System.in);
		
		System.out.print("The number of bombs: ");
		int Nnombs = scan.nextInt();
		
		System.out.print(" // Program mode:");
		String programmode = scan.nextLine();
		System.out.println();
		
		System.out.print("The name of the board input file: ");
		String fileaddress = scan.nextLine();
		System.out.println();
		
		fulladdress = fulladdress+fileaddress;
		
		InputStream fis = new FileInputStream(fulladdress);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		
		
	}
	
	// public char[][] changetxt()
	
	public char[][] outputMap(char[][] inputMap){
		char[][] returnMap = new char[12][35];
		
		for(int i=0;i<12;i++) {								// 공백초기화
			for(int j=0;j<35;j++)
				returnMap[i][j]=' ';
		}
		
		for(int i=0;i<12;i++) {
			for(int j=0;j<35;j++) {
				if(i>=2) {									// 3번째 줄부터 입력받기
					if(j==0) {								// 행번호 입력
						if(i==11) {							// 10예외처리
							returnMap[i][j]='1';
							returnMap[i][j]='0';
						}
						returnMap[i][j]=(char)(i-1);
					}
					
					if(j==4)
						returnMap[i][j]='|';
					
					if(j>4 && j/3==0)
						returnMap[i][j] = inputMap[i-2][j/3-2];
					
				}
				
				if(i==0) { 									// 첫두줄 작성
					if(j%3==0&&j!=3)
						returnMap[i][j] = Rowindex[j/3-2];
				}
				if(i==1) {
					if(j%3==0&&j!=3)
						returnMap[i][j] = '-';
				}
		}
			
		}
		
		return returnMap;
	}
	
}

class ship{
	String type;
	int size;
	int hits=0;
}

class Aircraft_Carrier extends ship{
	int size=6;
	String type="carrier";
}

class MbattleShip extends ship{
	int size=4;
	String type="battleship";
}

class Submarine extends ship{
	int size=3;
	String type="submarine";
}

class Destroyer extends ship{
	int size=3;
	String type="destroyer";
}

class Patrol_Boat extends ship{
	int size=2;
	String type="Patrol_Boat";
}