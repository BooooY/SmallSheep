package getarry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Combination
{
	public List<int[]> combination(int[] a, int m)
	{
		Combination c = new Combination();
		List list = new ArrayList();
		int n = a.length;
		boolean end = false;

		int[] tempNum = new int[n];
		for (int i = 0; i < n; i++) {
			if (i < m) {
				tempNum[i] = 1;
			}
			else {
				tempNum[i] = 0;
			}
		}

		list.add(c.createResult(a, tempNum, m));
		int k = 0;
		while (!end) {
			boolean findFirst = false;
			boolean swap = false;

			for (int i = 0; i < n; i++) {
				int l = 0;
				if ((!findFirst) && (tempNum[i] == 1)) {
					k = i;
					findFirst = true;
				}
				if ((tempNum[i] == 1) && (tempNum[(i + 1)] == 0)) {
					tempNum[i] = 0;
					tempNum[(i + 1)] = 1;
					swap = true;
					for (l = 0; l < i - k; l++) {
						tempNum[l] = tempNum[(k + l)];
					}
					for (l = i - k; l < i; l++) {
						tempNum[l] = 0;
					}
					if ((k == i) && (i + 1 == n - m)) {
						end = true;
					}
				}
				if (swap)
				{
					break;
				}
			}
			list.add(c.createResult(a, tempNum, m));
		}
		return list;
	}

	public int[] createResult(int[] a, int[] temp, int m)
	{
		int[] result = new int[m];
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (temp[i] == 1) {
				result[j] = a[i];

				j++;
			}
		}
		return result;
	}

	public static boolean isPrime(int num)
	{
		if (num == 1) return true;
		if (num < 2) return false;
		if (num == 2) return true;
		if (num % 2 == 0) return false;
		for (int i = 3; i * i <= num; i += 2)
			if (num % i == 0) return false;
		return true;
	}

	public List<int[]> screen(List<int[]> list)
	{
		List newlist = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			int[] temp = (int[])list.get(i);
			int lastone = temp.length - 1;
			int num_mantissa = 0; int dif_mantissa = 0;
			int sum = 0; int count = 0; int count_ctn = 0; int count_odd = 0; int count_even = 0; int count_prime = 0;
			int count_zone1 = 0; int count_zone2 = 0; int count_zone3 = 0;
			int[] mantissa = new int[temp.length];
			for (int j = 0; j < temp.length; j++) {    
				if(temp[j]>=1&&temp[j]<=11)  //判断数字在不同分区的个数
				{
					count_zone1 +=1;
				}else if (temp[j]>=12&&temp[j]<=22){count_zone2 +=1;}else{count_zone3 +=1;}

				if(temp[j]%2!=0){
					count_odd += 1;   //奇数个数自加
				}
				else{
					count_even += 1;   //偶数个数自加
				}
				if(isPrime(temp[j])){   //判断是否有质数
					count_prime +=1;
				}
				if(temp[j]%10==1||temp[j]%10==2||temp[j]%10==6||temp[j]%10==7){ //判断尾数是否有1、2、6、7
					num_mantissa +=1;
				}
				sum += temp[j] ; 
				mantissa[j] = temp[j]%10;
			}
			Arrays.sort(mantissa); //将尾数数组进行排序，方便后面的统计
			for (int j = 0; j < temp.length -1; j++) {   
				//			if (temp[j+1]-temp[j]>20 ){
				//				count += 1;
				//			}
				if (temp[j+1]-temp[j]==1 ){
					if(j+2<temp.length&&temp[j+2]-temp[j+1]==1){
						count_ctn += 1;}
				}
				if(mantissa[j+1]!=mantissa[j]){
					dif_mantissa +=1;   //统计尾数不同的个数
				}
			}
			if (sum>=65  && sum<=136){    //固定条件第1个条件
				if(count_ctn <1){    //固定条件第2个条件
					if( temp[lastone] + temp [0]>=25 && temp[lastone] + temp [0]<=45 ){   //固定条件第3个条件
						if( temp[lastone] - temp [0]>=14 && temp[lastone] - temp [0] <=31 )  //固定条件第6个条件
							if(num_mantissa>=2){ //固定条件第7个条件
								if(dif_mantissa>=4){ //固定条件第8个条件
									if(count_odd==2 ||count_odd==3||count_odd==4){ //固定条件第9个条件
										if(count_prime==1||count_prime==2||count_prime==3){  //固定条件第2个条件
											if(count_zone1<=4&&count_zone2<=4&&count_zone3<=4)	//分区条件
											{
												newlist.add(temp);
											}
										}}}}}}}}
		return newlist;
	}
}