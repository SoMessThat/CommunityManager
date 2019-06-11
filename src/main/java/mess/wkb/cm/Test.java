package mess.wkb.cm;

public class Test {

	public static int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
	public static int[] height1={};
	public static int[] height3={0,1,0,2,1,0,1,3,2,1,2,1,1,0};
	public static void main(String[] args) {
		name(height);
		name(height3);
		name(height1);
	}
	public static int name(int[] height) {
		int bigHeight = 0;
		int smallHeiht = 0;
		int totalNum = 0;
		if( height==null||height.length==0){
			System.out.println(totalNum);
			return 0;
		}
		//求1
		for (int i = 0; i < height.length; i++) {
			if (height[i] > bigHeight) {
				bigHeight = height[i];
			}else{
				totalNum += bigHeight - height[i];
			}
		}
		//求2
		for (int i = height.length-1; height[i] < bigHeight; i--) {
			if (height[i] > smallHeiht) {
				//跳过3的面积
				smallHeiht = height[i];
			}
			totalNum -= bigHeight-smallHeiht;
		}
		System.out.println(totalNum);
		return totalNum;
	}
}
