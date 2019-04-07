package mess.wkb.cm.tool.util.creatdata;

import java.text.SimpleDateFormat;  
import java.util.Date;  
  
import junit.framework.TestCase;  
  
public class RondomDateTest extends TestCase{  
      
    /** 
     * 获取随机日期 
     * @param beginDate 起始日期，格式为：yyyy-MM-dd 
     * @param endDate 结束日期，格式为：yyyy-MM-dd 
     * @return 
     */  
    public static String randomDate(){  
        try {  
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
            Date start = format.parse("2015-01-01");  // 构造开始日期  
            Date end = format.parse("2019-03-07");  // 构造结束日期  
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
            if(start.getTime() >= end.getTime()){  
                return null;  
            }  
              
            long date = random(start.getTime(),end.getTime());  
              
            return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format( new Date(date));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return "2019-01-01 12:00:00";  
    }  
      
    private static long random(long begin,long end){  
        long rtn = begin + (long)(Math.random() * (end - begin));  
// 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值  
        if(rtn == begin || rtn == end){  
            return random(begin,end);  
        }  
        return rtn;  
    }  
}  