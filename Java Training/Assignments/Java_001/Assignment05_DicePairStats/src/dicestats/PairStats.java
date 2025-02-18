package dicestats;


public class PairStats {
	
	public static int dieRoll(int min, int max) {
		return (int)(Math.random() * ((max - min) + 1)) + min;
	}

	public static void main(String[] args) {

		//create a 2-d array for the 2 dice combinations
		int[][] dicePair = new int[6][6];
		
		//store dice rolls
		int x = 0, y = 0, small = 1, big = 6;
		
		/*
		 * fill array with dice combinations, 
		 * but fill dice areas where lower number comes first
		 * with -1
		 */
		dicePair[0][0] = 0;
		dicePair[0][1] = -1;
		dicePair[0][2] = -1;
		dicePair[0][3] = -1;
		dicePair[0][4] = -1;
		dicePair[0][5] = -1;
		dicePair[1][0] = 0;
		dicePair[1][1] = 0;
		dicePair[1][2] = -1;
		dicePair[1][3] = -1;
		dicePair[1][4] = -1;
		dicePair[1][5] = -1;
		dicePair[2][0] = 0;
		dicePair[2][1] = 0;
		dicePair[2][2] = 0;
		dicePair[2][3] = -1;
		dicePair[2][4] = -1;
		dicePair[2][5] = -1;
		dicePair[3][0] = 0;
		dicePair[3][1] = 0;
		dicePair[3][2] = 0;
		dicePair[3][3] = 0;
		dicePair[3][4] = -1;
		dicePair[3][5] = -1;
		dicePair[4][0] = 0;
		dicePair[4][1] = 0;
		dicePair[4][2] = 0;
		dicePair[4][3] = 0;
		dicePair[4][4] = 0;
		dicePair[4][5] = -1;
		dicePair[5][0] = 0;
		dicePair[5][1] = 0;
		dicePair[5][2] = 0;
		dicePair[5][3] = 0;
		dicePair[5][4] = 0;
		dicePair[5][5] = 0;
		
		//loops 1000 times
		for (int i =0; i < 1000; i++){
			//roll first die
			x = dieRoll(small, big);
			
			//roll second die
			y = dieRoll(small, big);
			
			//store with high number first
			if (x > y) {
				dicePair[x-1][y-1]++;
			}else {
				dicePair[y-1][x-1]++;
			}
		}
		
		int max = dicePair[0][0];
		int first = -1;
		int second = -1;
		int q = 0;
		
		do {
			max = 0;
			//loop through first layer
			for(int a=0;a<6;a++) {
				//loop through second layer
				for(int b=0;b<6;b++) {
					if (dicePair[a][b] > max) {
						max = dicePair[a][b];
						//since array starts with [0][0], increments a and b by 1 before setting them.
						first = a + 1;
						second = b + 1;
					}
				}
			}
			
			//Print out largest roll left
			System.out.println("Dice " + first + " and " + second + ": " + max + " times");
			
			//change array value to -1 
			dicePair[first-1][second-1] = -1;
			q++;
		}while (q < 21);
		
	}
}