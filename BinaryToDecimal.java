package thread;
public class BinaryToDecimal {
	public static void main(String[] args)  {
		System.out.println(binaryToDecimal(11000000));
	}
	public static int binaryToDecimal(int binaryNumber) {
		if (binaryNumber == 0) {
			return 0;
		} else {
			//记录结果
			int result = 0;
			//初始化 2^0
			int abs = 1;
			while (binaryNumber != 0) {
				//对10取模，取尾数
				int base = binaryNumber % 10;
				//左移一位
				binaryNumber /= 10;	
				//尾数为1，则加上2的指数次方，尾数为0则不做操作
				if (base == 1) {
					result += abs;	
				}
				//每次循环则将底数翻倍 比如  1*2^1,0*2^2,1*2^3
				abs *=2;
			}
			return result;
		}
	}
}
