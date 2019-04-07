package mess.wkb.cm.tool.util;




import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.sourceforge.pinyin4j.PinyinHelper;


/**
 * 拼音工具类.
 * 
 * @author:ZhengChao
 * @email:zhengchao730@163.com
 */
public class PinyinUtil {

	/**
	 * 获得单个汉子的拼音(有音标).
	 * 
	 * @param word
	 * @return
	 */
	public static String[] getPinyin(char word) {
		String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
		return pinyinArray;
	}

	/**
	 * 获得单个汉子的拼音(无音标).
	 * 
	 * @param word
	 * @return
	 */
	public static String[] getPinyinDistinct(char word) {
		Map<String, String> map = new HashMap<String, String>();
		String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
		if (pinyinArray == null) {
			return null;
		}
		int length = 0;
		for (int i = 0; i < pinyinArray.length; i++) {
			String pinyin = pinyinArray[i];
			pinyin = pinyin.substring(0, pinyin.length() - 1);
			if (!map.containsKey(pinyin)) {
				map.put(pinyin, pinyinArray[i]);
				length++;
			}
		}
		int index = 0;
		String[] retArry = new String[length];
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			retArry[index] = it.next();
			index++;
		}
		return retArry;
	}
	
	/**
	 * 获取词语拼音首字母 多音字获取第一个
	 * @param s
	 * @return
	 */
	public static String getPinyinFirst(String s){
		char[] cArr = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(char c : cArr){
			try {
				sb.append(PinyinUtil.getPinyinDistinct(c)[0].substring(0,1));
			} catch (Exception e) {
				return s;
			}
		}
		return sb.toString();
		
		
	}
	
	/**
	 * 获取词语拼音 多音字获取第一个
	 * @param s
	 * @return
	 */
	public static String getPinyinAll(String s){
		char[] cArr = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		try {
			for(char c : cArr){
				sb.append(PinyinUtil.getPinyinDistinct(c)[0]);
			}
			return sb.toString();
		} catch (Exception e) {
			return s;
		}
		
	}
	
	public static void main(String[] args) {
//		char[] test = {'郑','超'};
//		for(char c : test){
//			System.out.println(PinyinUtil.getPinyinDistinct(c)[0]);
//		}
		
		String test = "郑超";
		System.out.println(getPinyinFirst(test));
		
	}
	
}
