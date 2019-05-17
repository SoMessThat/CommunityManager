package mess.wkb.cm.tool.util.alipay;
public class AlipayConfig {
	public static String APPID = "2016092900622914";
    // 私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDr/anEcFDUnVbe"+
											"GaDBGsN5RbGKKF2UqApTk3Ady/8MFGfcSqrz73dI6yRWSdhABM+OZpO301HDSS+f"+
											"yW/GTRgIPM1qOR/t9qGhUkudYGZds9Vfkl2vg97SAEbFcbONsXj0/qUD996Jxacr"+
											"PQwph9i+hjRuzExrvnGulztp5NxT/ycDS7dSSyzrMV+bqck6qZ9GLSpJO2WdvanC"+
											"p3UUwt337dphLd1jsGeT6PG12Rt8eMBTB8wUktGfAJULXUoAgHLkx9rS/BW66bI8"+
											"+bVLNmnOUPrClykMdTXDl0QYR6oSFiFxHaPXTqsXwlsjL8qoMPBZsxF5qT8b0F0Y"+
											"HXPGMAznAgMBAAECggEBALxiNg9WCXBwWVPa6XS9RKWeeOds6actrXCiFbHzkpm2"+
											"AGLeSDGKS5KuAsfPEw2nyXhHckwgKPjXh2jqiIuoJzMMNn5BM7fmVYhOBYaP2aeb"+
											"Uw2D7b2aa1kAV35uEYNe1MveKyRLzh305kmh5f+RLfiJcXmxJKAt2togZ5FU3H0/"+
											"fR1k+ton8S1ptsiFfu/sOrvA7DD+uEyvgAfPSCeiIGf0oSHgsraVe7Bt3sR+Oabm"+
											"WaLuNIFd2ac3paZOZFTCdTXpEGFRJV++QLrPdlAJZa57I28Y63oIwJuzKcAHZkQy"+
											"awHE7dL21iOmfSZ+TrZQfzyjIFeyOIvTXnoSk786xkECgYEA9dPcAI9HjcyO0QVD"+
											"5LUPDJq0fK3+46rdN/ec03VgyaA9sT33AafxUlnx57K0sXo7veAmIQN9ojH4CdgZ"+
											"vqqRomz9KS5yEf18gRg1fmv9S1zjbqu0gErmI+Ai9C9EDOtGKYNxiXFLsD1qbbBD"+
											"TE8R9WB9653jrQNnuqJDtKIbJa8CgYEA9cGZmYX9hJdUa04rwy53nxlWnuq/qZFx"+
											"B4hgxhzWU1HFm5ceaIcw5BF/zVfFyTVEHLC77v0HMfIWM6OYXMFWfBrdqzsH/sOT"+
											"C2amQviDaTbDNeCbUj83/qBHmXiKOmzwvPj3Z2GLscX77cbgaS+wJf17jGi6AGud"+
											"kbzWhxf0EkkCgYEAsq155EJAXRXI3K56Cbt8o8my1EjX0n03690jdSOE5Sh+jtye"+
											"M+rw4c2Uobdn1PQmhj1tGWPjJkgxpF4ZYFe0IR4c6JjkuqTHoUGKaEhvxB5RBPjy"+
											"6qkGHB9m6JuOV+GOjtAGb0MVI5WQTQfn8ogqYnLvM5oAiZnHBIW6tol5N+sCgYEA"+
											"gwCTl2H0lVRx3M2LyHyhqX7BTO9IAeUUwnYxWAoROdLyKpFw1TmTl0+4t8ZdGXe6"+
											"eiy/0ZKx3i71JMvFMVSifH95wIg0J9srLD2ozTRaIKDfiH3Vbg9jEulvoWC/Fovx"+
											"/Foez84QwFAQjlygTZHtLSMlU+CTnhu/n+tw1Ayxv3kCgYAnvFGpUdLlslKtPJsc"+
											"vh4MoZlGFXgpOW3cVAi4feNAiYSBkGyUU+adaxjkpscHSvU1CuC00a9fCOZyng23"+
											"JE6u8etSkg2fdbBCOcIOg4np/r1TGzypGsAAy903M2Ez+Vy/lS9pwJOhuimUcuh+"+
											"0/BVQ1+CLQ8Zmub5I34oAKDB/Q==";
    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://www.bemess.xyz/CommunityManager/";
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "http://www.bemess.xyz/CommunityManager/";
    // 请求网关地址
    public static String URL = "https://openapi.alipaydev.com/gateway.do";
    // 编码
    public static String CHARSET = "UTF-8";
    // 返回格式
    public static String FORMAT = "json";
    // 支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhUg0wNQMuOL1dtK0h/Q/q+TwWMFwPrIc9HICDccuhJoi1yJWp5eEIaHfvrng5hGaDWU7hgRf4t97hTv+pCnhDpW12DKENXl4Z7bFBcHAiEwus1O9e2h1xopAKjgghRJOCu5iDpPPHnuOCA1dsqTkFwbDguAWlYkpJqYLSLfN5V0w6hGsf9ViP+PASB8fNKOt9BGy/a1Gh2ejQkKw3ImayGLUQ1kKPaO4YVMv1IcDl6NJ9IP9im3xKr44ukUzXtUYSogh/qROnMkikpqaKydoKyeM/MvZc+DVsFdNViwcqg5ZHbJgQ8lW3EMNskiRW5C/b0Eym8Bd8PsUgLsbNR1qaQIDAQAB";
    // 日志记录目录
    public static String log_path = "E:\\log";
    // RSA2
    public static String SIGNTYPE = "RSA2";

}