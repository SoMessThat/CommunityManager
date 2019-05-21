package mess.wkb.cm.tool.util.creatdata;


import java.io.UnsupportedEncodingException;
import java.util.Random;
 
public class ChineseName {
	private static final String[] email_suffix = "@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn".split(",");

    public static String base = "abcdefghijklmnopqrstuvwxyz0123456789";
    
	public static String getname() {
		Random random=new Random(System.currentTimeMillis());
		/* 598 百家姓 */
		String[] Surname= {"赵","钱","孙","李","周","吴","郑","王","冯","陈","褚","卫","蒋","沈","韩","杨","朱","秦","尤","许",
				  "何","吕","施","张","孔","曹","严","华","金","魏","陶","姜","戚","谢","邹","喻","柏","水","窦","章","云","苏","潘","葛","奚","范","彭","郎",
				  "鲁","韦","昌","马","苗","凤","花","方","俞","任","袁","柳","酆","鲍","史","唐","费","廉","岑","薛","雷","贺","倪","汤","滕","殷",
				  "罗","毕","郝","邬","安","常","乐","于","时","傅","皮","卞","齐","康","伍","余","元","卜","顾","孟","平","黄","和",
				  "穆","萧","尹","姚","邵","湛","汪","祁","毛","禹","狄","米","贝","明","臧","计","伏","成","戴","谈","宋","茅","庞","熊","纪","舒",
				  "屈","项","祝","董","梁","杜","阮","蓝","闵","席","季","麻","强","贾","路","娄","危","江","童","颜","郭","梅","盛","林","刁","钟",
				  "徐","邱","骆","高","夏","蔡","田","樊","胡","凌","霍","虞","万","支","柯","昝","管","卢","莫","经","房","裘","缪","干","解","应",
				  "宗","丁","宣","贲","邓","郁","单","杭","洪","包","诸","左","石","崔","吉","钮","龚","程","嵇","邢","滑","裴","陆","荣","翁","荀",
				  "羊","于","惠","甄","曲","家","封","芮","羿","储","靳","汲","邴","糜","松","井","段","富","巫","乌","焦","巴","弓","牧","隗","山",
				  "谷","车","侯","宓","蓬","全","郗","班","仰","秋","仲","伊","宫","宁","仇","栾","暴","甘","钭","厉","戎","祖","武","符","刘","景",
				  "詹","束","龙","叶","幸","司","韶","郜","黎","蓟","溥","印","宿","白","怀","蒲","邰","从","鄂","索","咸","籍","赖","卓","蔺","屠",
				  "蒙","池","乔","阴","郁","胥","能","苍","双","闻","莘","党","翟","谭","贡","劳","逄","姬","申","扶","堵","冉","宰","郦","雍","却",
				  "璩","桑","桂","濮","牛","寿","通","边","扈","燕","冀","浦","尚","农","温","别","庄","晏","柴","瞿","阎","充","慕","连","茹","习",
				  "宦","艾","鱼","容","向","古","易","慎","戈","廖","庾","终","暨","居","衡","步","都","耿","满","弘","匡","国","文","寇","广","禄",
				  "阙","东","欧","殳","沃","利","蔚","越","夔","隆","师","巩","厍","聂","晁","勾","敖","融","冷","訾","辛","阚","那","简","饶","空",
				  "曾","毋","沙","乜","养","鞠","须","丰","巢","关","蒯","相","查","后","荆","红","游","郏","竺","权","逯","盖","益","桓","公","仉",
				  "督","岳","帅","缑","亢","况","郈","有","琴","归","海","晋","楚","闫","法","汝","鄢","涂","钦","商","牟","佘","佴","伯","赏","墨",
				  "闾","辜","纵","侴","万俟","司马","上官","欧阳","夏侯","诸葛","闻人","东方","赫连","皇甫","羊舌","尉迟","公羊","澹台","公冶","宗正",
				  "毋丘","贺兰","綦毋","屋庐","独孤","南郭","北宫","王孙"};
		
		int index=random.nextInt(Surname.length-1);		
		String name = Surname[index]; //获得一个随机的姓氏
		
		/* 从常用字中选取一个或两个字作为名 */
		if(random.nextBoolean()){
			name+=getChinese()+getChinese();
		}else {
			name+=getChinese();
		}
		return name;
	}
	
	public static String getChinese() {
		String str = null;
		int highPos, lowPos;
		Random random = new Random();
		highPos = (176 + Math.abs(random.nextInt(71)));//区码，0xA0打头，从第16区开始，即0xB0=11*16=176,16~55一级汉字，56~87二级汉字
		random=new Random();
		lowPos = 161 + Math.abs(random.nextInt(94));//位码，0xA0打头，范围第1~94列
 
		byte[] bArr = new byte[2];
		bArr[0] = (new Integer(highPos)).byteValue();
		bArr[1] = (new Integer(lowPos)).byteValue();
		try {
			str = new String(bArr, "GB2312");	//区位码组合成汉字
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
			return str;
	}
	public static String getTel() {
		int index=getNum(0,telFirst.length-1);
		String first=telFirst[index];
		String second=String.valueOf(getNum(1,888)+10000).substring(1);
		String third=String.valueOf(getNum(1,9100)+10000).substring(1);
		return first+second+third;
	}
 
	public static String getTandF() {
		Random rand = new Random();
		int a = rand.nextInt(4);
		if(a>2){
			return "是";
		}
		else {
			return "否";
		}
	}
	
	public static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }
	private static String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");
	
	/**
     * 返回Email
     *
     * @param lMin 最小长度
     * @param lMax 最大长度
     * @return
     */
    public static String getEmail() {
        int length = getNum(5, 10);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = (int) (Math.random() * base.length());
            sb.append(base.charAt(number));
        }
        sb.append(email_suffix[(int) (Math.random() * email_suffix.length)]);
        return sb.toString();
    }
    
    private static String[] street=("鼓楼区鼓东街,鼓楼区道鼓西街,鼓楼区道温泉街,鼓楼区道东街街道,鼓楼区南街街道,鼓楼区安泰街道,鼓楼区华大街道,鼓楼区水部街道,"
    		+ "台江区瀛洲街道,台江区后洲街道,台江区义洲街道,台江区新港街道,台江区上海街道,台江区苍霞街道,台江区茶亭街道,台江区洋中街道,"
    		+ "马尾区罗星街道,马尾区马尾镇,马尾区亭江镇,马尾区琅岐镇,"
    		+ "晋安区茶园街道,晋安区王庄街道,晋安区象园街道,晋安区鼓山镇,晋安区新店镇,晋安区岳峰镇,晋安区宦溪镇,晋安区寿山乡,"
    		+ "闽侯县甘蔗街道,闽侯县白沙镇,闽侯县南屿镇,闽侯县尚干镇,闽侯县祥谦镇,闽侯县青口镇,闽侯县南通镇,闽侯县上街镇,"
    		+ "连江县凤城镇,连江县敖江镇,连江县东岱镇,连江县琯头镇,连江县晓澳镇,连江县东湖镇,连江县丹阳镇,连江县长龙镇,连江县透堡镇,连江县马鼻镇,连江县官坂镇,连江县筱埕镇,连江县黄岐镇,连江县苔菉镇,连江县浦口镇,连江县坑园镇,连江县潘渡乡,连江县江南乡,连江县蓼沿乡,连江县安凯乡,连江县下宫乡,连江县小沧畲族乡,连江县马祖乡,"
    		+ "罗源县凤山镇,罗源县松山镇,罗源县起步镇,罗源县中房镇,罗源县飞竹镇,罗源县鉴江镇,罗源县白塔乡,罗源县洪洋乡,罗源县西兰乡,罗源县霍口畲族乡,罗源县碧里乡,"
    		+ "闽清县梅城镇,闽清县梅溪镇,闽清县白樟镇,闽清县金沙镇,闽清县白中镇,闽清县池园镇,闽清县坂东镇,闽清县塔庄镇,"
    		+ "永泰县樟城镇,永泰县嵩口镇,永泰县梧桐镇,永泰县葛岭镇,永泰县城峰镇,永泰县清凉镇,永泰县长庆镇,永泰县同安镇,"
    		+ "平潭县潭城镇,平潭县苏澳镇,平潭县流水镇,平潭县澳前镇,平潭县北厝镇,平潭县平原镇,平潭县敖东镇,平潭县白青乡,"
    		+ "福清市玉屏街道,福清市龙山街道,福清市龙江街道,福清市宏路街道,福清市石竹街道,福清市音西街道,福清市阳下街道,福清市海口镇,"
    		+ "长乐市吴航街道,长乐市航城街道,长乐市营前街道,长乐市漳港街道,长乐市首占镇,长乐市玉田镇,长乐市松下镇,长乐市江田镇").split(",");	
    public static String getAddress() {
    	int index=getNum(0,street.length-1);
    	String address=street[index];
    	return address;
    }
    
    public static String getName() {
    	Random rand = new Random();
		int a = rand.nextInt(3);
		int b = rand.nextInt(5);
		StringBuffer name = new StringBuffer();
		for (int i = 0; i <= b; i++) {
			name.append(getChinese());
		}
		switch (a) {
		case 0:
			name.append("科技有限公司");
			break;

		case 1:
			name.append("股份有限公司");
			break;
			
		default:
			name.append("有限责任公司");
			break;
		}
		
		return name.toString();
    }
    
    private static String[] code=("0,1,2,3,4,5,6,7,8,9").split(",");
    public static String get6Code() {
    	String code1=code[getNum(0,code.length-1)]+code[getNum(0,code.length-1)]+
	    			code[getNum(0,code.length-1)]+code[getNum(0,code.length-1)]+
	    			code[getNum(0,code.length-1)]+code[getNum(0,code.length-1)];
    	return code1;
    }
    
}
