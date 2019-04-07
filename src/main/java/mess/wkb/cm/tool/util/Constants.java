package mess.wkb.cm.tool.util;




import java.util.HashMap;
import java.util.Map;

/**
 * 系统常量
 * 
 * @author Aioria Email: zhengchao730@163.com 2013-3-29
 */
public class Constants {

	public static final String CONFIG_FILE_NAME = "/config.xml"; // 系统参数配置文件
	public static final String ACTION = "action"; // 前台传入动作控制标示符
	public static final Integer DEFAULT_PAGE_SIZE = 15; // 系统列表页容量
	public static final Integer DEVIATION = -1; // 纠偏

	public static final String EMPTY = "";

	public static final String ADD = "add";// 新增
	public static final String MODIFY = "modify";// 修改
	public static final String QUERY_PAGE = "queryPage";// 查询列表
	public static final String QUERY = "query";// 查询
	public static final String REMOVE = "remove";// 删除
	public static final String LOAD = "load";// 加载
	public static final String LOAD_OTHER = "loadOther";// 加载
	public static final String ENABLE = "enable";// 激活
	public static final String DISABLE = "disable";// 锁定

	// solr服务状态信息 用于展现
	// public static final Map<String,String> SOLR_STATUS = new
	// HashMap<String,String>(6);
	// static {
	// SOLR_STATUS.put("leader", "管理者");
	// SOLR_STATUS.put("active", "当前有效");
	// SOLR_STATUS.put("recovering", "正在尝试恢复");
	// SOLR_STATUS.put("down", "停机状态");
	// SOLR_STATUS.put("recovery failed", "无法自动恢复，当前失效");
	// SOLR_STATUS.put("gone", "无法挽回，服务完全停止");
	// }
	//
	// 状态展现
	public static final Map<Integer, String> STATUS_DISPLAY = new HashMap<Integer, String>(
			2);
	static {
		STATUS_DISPLAY.put(0, "锁定");
		STATUS_DISPLAY.put(1, "激活");
	}

	// 状态展现
	// public static final Map<String,String> SOLR_NODE_PATH = new
	// HashMap<String,String>();
	// static {
	// STATUS_DISPLAY.put(0, "锁定");
	// STATUS_DISPLAY.put(1, "激活");
	// }

	// replica 属性
	public static final String REPLICA_SHARD = "shard";
	public static final String REPLICA_STATE = "state";
	public static final String REPLICA_CORE = "core";
	public static final String REPLICA_COLLECTION = "collection";
	public static final String REPLICA_NAME = "node_name";
	public static final String REPLICA_URL = "base_url";
	public static final String REPLICA_LEADER = "leader";

	public static final Map<String,String> borrowInfoType = new
		 HashMap<String,String>();
	static {
		borrowInfoType.put("dyw", "抵押物照片");//
		borrowInfoType.put("sfz", "身份证明文件");
		borrowInfoType.put("cqzm", "抵押物产权证明");
		borrowInfoType.put("jkht", "借款合同文件");
		borrowInfoType.put("gzs", "公证书");//
		borrowInfoType.put("txqz", "他项权证");
		borrowInfoType.put("dbh", "担保函");
		borrowInfoType.put("mmht", "买卖及租赁合同");
		borrowInfoType.put("dyww", "抵押物处置文件");
		borrowInfoType.put("dkpz", "打款凭证");
		borrowInfoType.put("hkjl", "还款记录");
		borrowInfoType.put("qita", "其他");
	}
	
	// zk源字典
	public static String zkHost = null;

	public static Integer zkConnectTimeout = null;
	public static Integer zkClientTimeout = null;

	public final static String DUBBO_SUCCESS_MSG = "操作成功";
	public final static String DUBBO_FAILED_MSG = "操作失败";

	public final static String WEB_SUCCESS_MSG = "操作成功";
	public final static String WEB_FAILED_MSG = "操作失败";
	public final static String WEB_ERROR_MSG = "系统异常";

	// 字典类型
	public static String DICT_POSITION = "position";// 职位
	public static String DICT_LEVEL = "level";// 职级
	// 树形类型
	public static String DICT_DEPT = "dept";// 部门
	public static String DICT_REGION = "REGION";// 地区

	// 用户头像类型
	public static String AVATAR_LARGE = "large";// 大头像
	public static String AVATAR_MEDIUM = "medium";// 中等头像
	public static String AVATAR_SMALL = "small";// 小头像
	public static Integer AVATAR_LARGE_SIZE = 180;// 大头像
	public static Integer AVATAR_MEDIUM_SIZE = 96;// 中等头像
	public static Integer AVATAR_SMALL_SIZE = 50;// 小头像
	public static Integer AVATAR_MINI_SIZE = 25;// 迷你头像

	/**
	 * 配置文件路径.
	 */
	public final static String CONFIG_PROPERTIES_PATH = "/enterprise.properties";

	/**
	 * 权限树根节点
	 */
	public final static String OBJ_TREE_ROOT = "ROOT";

	/**
	 * 数据库中密码加密的密钥(固定了就不要改了).
	 */
	public final static String CIPHER_KEY_PWD = "ermp_pwd";

	/**
	 * cookie加密的密钥(固定了就不要改了).
	 */
	public final static String CIPHER_COOKIE_KEY = "ermp_cookie_575757";

	/**
	 * 初始化密码.
	 */
	public final static String DEFAULT_PWD = "abcd.1234";

	/**
	 * SESSION.
	 */
	public static final String SESSION = "SESSION";
	
	/**
	 * 超级管理员权限点.
	 */
	public static final String OBJ_ADMIN = "OBJ-ADMIN";
	
	/**
	 * 个人私有权限
	 */
	public static final String GEREN = "个人私有权限";
	/**
	 * 个人私有权限CODE
	 */
	public static final String PRIVATE_ROLECODE = "PRIVATE-ROLECODE";
	/**
	 * 网站开始运行时间
	 */
	public static final Long OPERATE_TIME = 1354291200000l;
	/**
	 * 网站累计成交金额
	 */
	public static Double ALL_DEAL_MONEY = 20000.00;
	/**
	 * 网站待收金额
	 */
	public static Double ALL_WAIT_MONEY = 0.00;

}
