package org.linlinjava.litemall.core.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Colin Wang on 2015/7/4.
 */
public class StringUtil {
    private static final int VALUE_10 = 10;
    private static final int VALUE_13 = 13;
    private static final int VALUE_32 = 32;
    private static final int VALUE_60 = 60;
    private static final int VALUE_62 = 62;
    private static final int VALUE_38 = 38;
    private static final int VALUE_34 = 34;
    private static final int VALUE_165 = 165;
    private static final int VALUE_174 = 174;
    private static final int VALUE_8482 = 8482;
    private static final int VALUE_8364 = 8364;
    private static final int VALUE_169 = 169;
    private static final int OffsetBig = 256;
    private static final int OffsetSmall = 16;

    private static final int MOBIL_F_TAG = 3;
    private static final int MOBIL_L_TAG = 7;
    private static final int WEEK_TAG = 7;
    private static final int MOBIL_P_TAG_PREFIX = 6;
    private static final int MOBIL_N_TAG_PREFIX = 10;

    private static final String ENCRYPT_SALTE = "hitgou";
    private static final String TAG = "StringUtil";

    /**
     * 得到n位随机数
     *
     * @param s
     * @return
     */
    public static String getRndNumber(int s) {
        Random ra = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s; i++) {
            sb.append(String.valueOf(ra.nextInt(10)));
        }
        return sb.toString();
    }

    /**
     * 判断是否以字符串开头
     *
     * @param str
     * @param s
     * @return
     */
    // public boolean startWith(String str, String s) {
    // return Strings.sNull(str).startsWith(Strings.sNull(s));
    // }

    /**
     * 判断是否包含字符串
     *
     * @param str
     * @param s
     * @return
     */
    // public boolean contains(String str, String s) {
    // return Strings.sNull(str).contains(Strings.sNull(s));
    // }

    /**
     * 字符串去空格，回车，换行，制表符
     * 
     * @param str
     *            要修改的字符串
     * @return 修改完成的字符串
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * 将输入的字符串进行html编码
     * 
     * @param input
     *            输入的字符串
     * @return html编码后的结果
     */
    public static String htmEncode(String input) {
        if (null == input || "".equals(input)) {
            return input;
        }

        StringBuffer stringbuffer = new StringBuffer();
        int j = input.length();
        for (int i = 0; i < j; i++) {
            char c = input.charAt(i);
            switch (c) {
            case VALUE_60:
                stringbuffer.append("&lt;");
                break;
            case VALUE_62:
                stringbuffer.append("&gt;");
                break;
            case VALUE_38:
                stringbuffer.append("&amp;");
                break;
            case VALUE_34:
                stringbuffer.append("&quot;");
                break;
            case VALUE_169:
                stringbuffer.append("&copy;");
                break;
            case VALUE_174:
                stringbuffer.append("&reg;");
                break;
            case VALUE_165:
                stringbuffer.append("&yen;");
                break;
            case VALUE_8364:
                stringbuffer.append("&euro;");
                break;
            case VALUE_8482:
                stringbuffer.append("&#153;");
                break;
            case VALUE_13:
                if (i < j - 1 && input.charAt(i + 1) == VALUE_10) {
                    stringbuffer.append("<br>");
                    i++;
                }
                break;
            case VALUE_32:
                if (i < j - 1 && input.charAt(i + 1) == ' ') {
                    stringbuffer.append(" &nbsp;");
                    i++;
                    break;
                }
            default:
                stringbuffer.append(c);
                break;
            }
        }
        return new String(stringbuffer.toString());
    }

    /**
     * 判断字符串是否为null或者空字符串
     * 
     * @param input
     *            输入的字符串
     * @return 如果为null或者空字符串，返回true；否则返回false
     */
    public static boolean isNullOrEmpty(String input) {
        if (null == input || "".equals(input)) {
            return true;
        }
        return false;
    }

    /**
     * 如果字符串为空，则返回默认值
     */
    public static String checkStrIfNullWithDefault(String resStr, String defaultValue) {
        return isNullOrEmpty(resStr) ? defaultValue : resStr;
    }

    /**
     * 判断字符串中是否含有中文字符
     * 
     * @param s
     *            需要判断的字符串
     * @return true为包含中文
     */
    public static boolean containChinese(String s) {
        if (null == s) {
            return false;
        }

        Pattern pattern = Pattern.compile(".*[\u4e00-\u9fbb]+.*");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    /**
     * @Method: isChinese 判断输入的是否为汉字字符 @param a a @return boolean 是否为中文 @throws
     */
    public static boolean isChinese(char a) {
        // return (v >=19968 && v <= 171941);
        return String.valueOf(a).matches("[\u4E00-\u9FA5]"); // 利用正则表达式，经测试可以区分开中文符号
    }

    /**
     * @Method: isChinese 判断输入的是否为汉字字符 @param str str @return boolean 是否为中文 @throws
     */
    public static boolean isChinese(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!isChinese(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取MD5加密后Hash字符串
     * 
     * @param strOriginal
     *            初始字符串
     * 
     * @return MD5加密后Hash字符串
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    private static String getMd5Hash(String strOriginal) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        StringBuilder sbList = new StringBuilder();

        MessageDigest mMD5 = MessageDigest.getInstance("MD5");
        byte[] data = strOriginal.getBytes("utf-8");
        byte[] dataPWD = mMD5.digest(data);
        for (int offset = 0; offset < dataPWD.length; offset++) {
            int i = dataPWD[offset];
            if (i < 0) {
                i += OffsetBig;
            }
            if (i < OffsetSmall) {
                sbList.append("0");
            }
            sbList.append(Integer.toHexString(i));
        }
        return sbList.toString();
    }

    /**
     * 获取MD5加密后Hash字符串
     * 
     * 
     * @param strOriginal
     *            初始字符串
     * 
     * @param strSalt
     *            种子字符串
     * 
     * @return MD5加密后Hash字符串
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public static String getMd5Hash(String strOriginal, String strSalt)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String mStrSalt;
        String mStrOriginal = strOriginal;
        // 如果调用未给Salt值,则默认
        if (strSalt == null) {
            mStrSalt = ENCRYPT_SALTE;
        } else {
            mStrSalt = strSalt;
        }
        mStrOriginal = mStrOriginal + mStrSalt;
        return getMd5Hash(mStrOriginal);
    }

    /**
     * @Method: getProcessedDrawMobile @Description: 处理手机号码 @param userMobile
     *          需要处理的手机号码 @return String 处理后的手机号码 @throws
     */
    public static String getProcessedMobile(String userMobile) {
        String mProcessedDrawMobile = "";
        if (!StringUtil.isNullOrEmpty(userMobile)) {
            // 判断是否是+86开头的手机号码
            if ('+' == userMobile.charAt(0)) {
                mProcessedDrawMobile = userMobile.substring(0, MOBIL_P_TAG_PREFIX) + "****"
                        + userMobile.substring(MOBIL_N_TAG_PREFIX);
            } else {
                mProcessedDrawMobile = userMobile.substring(0, MOBIL_F_TAG) + "****"
                        + userMobile.substring(MOBIL_L_TAG);
            }
        }
        return mProcessedDrawMobile;
    }

    /**
     * 
     * 获取当期是星期几（从星期天开始）
     * 
     * @param weeknum
     *            当前是第几天（0-6）
     * @return 星期*
     */
    public static String getDayOfWeek(int weeknum) {
        weeknum--;
        if (weeknum > WEEK_TAG) {
            weeknum = weeknum % WEEK_TAG;
        }

        if (weeknum < 0) {
            weeknum = -weeknum;
        }

        String[] weekArray = new String[] { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        return weekArray[weeknum];

    }

    /**
     * 重载方法，获取当期是星期几
     * 
     * @param c
     *            日历
     * @return 星期*
     */
    public static String getDayOfWeek(Calendar c) {
        return getDayOfWeek(c.get(Calendar.DAY_OF_WEEK));
    }

    /**
     * 检查是不是中文
     * 
     * @Method: checkStringIsChinses @param str 检查字符串 @return boolean 是否为中文 @throws
     */
    public static boolean checkStringIsChinese(String str) {
        if (null == str) {
            return false;
        }
        Pattern pattern = Pattern.compile("[\\u4E00-\\u9FA5]+");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    /**
     * 转换保留小数位 字符串
     * 
     * @param i
     *            小数位数
     * @param numStr
     *            数字字符串
     * @return String
     */
    public static String getDecimalFormat(int i, String numStr) {
        try {
            if (numStr != null && !"".equals(numStr)) {
                BigDecimal bd = new BigDecimal(numStr);
                bd = bd.setScale(i, BigDecimal.ROUND_HALF_UP);

                return bd.toString();
            } else {
                return "";
            }
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 转换保留小数位
     * 
     * @param i
     *            小数位数
     * @param num
     *            要转换的数字
     * @return double 返回类型
     */
    public static double decimalFormat(int i, Double num) {
        String temp = getDecimalFormat(i, num.toString());
        double numFormat = Double.valueOf(temp);
        return numFormat;
    }

    /**
     * 检查是否是字符串
     * 
     * @param input
     *            被检查字符串
     * @return 是否是数字组成的字符串，包括0开头;<br>
     *         如果为空或者空字符串，返回true；比如："011"返回true，"a11"返回false
     */
    public static boolean isNumberString(String input) {
        if (!isNullOrEmpty(input)) {
            if (input.matches("[0-9]+")) {
                return true;
            }
        }

        return false;
    }

    /**
     * 检查输入字符串是否是合法的http地址，这个检查方法不完整，只是初步的检查是否以http://开头兵器后面有字符串
     * 
     * @param input
     *            输入的网址
     * @return 输入字符串是否合法
     */
    public static boolean isHttpUrl(String input) {
        if (!isNullOrEmpty(input)) {
            // String regexExpression =
            // "http://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
            // ((http|ftp|https|file):\/\/([\w\-]+\.)+[\w\-]+((\:)?(\d+)?)+(\/)?)
            String regexExpression = "http://([\\w\\WW-]+\\.)+[\\w\\W-]+(/[\\w\\W- ./?%&=]*)?";
            if (input.matches(regexExpression)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 检查输入字符串是否是合法的tcp地址，这个检查方法不完整，只是初步的检查是否以tcp://开头兵器后面有字符串
     * 
     * @param input
     *            输入的网址
     * @return 输入字符串是否合法
     */
    public static boolean isTcpUrl(String input) {
        if (!isNullOrEmpty(input)) {
            String regexExpression = "tcp://([\\w\\WW-]+\\.)+[\\w\\W-]+(/[\\w\\W- ./?%&=]*)?";
            if (input.matches(regexExpression)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 使用java正则表达式去掉多余的.与0
     * 
     * @param str
     *            str
     * @return String
     */
    public static String filterZeroAndDot(String str) {
        if (!isNullOrEmpty(str) && str.indexOf(".") > 0) {
            // 去掉多余的0
            str = str.replaceAll("0+?$", "");
            // 如最后一位是.则去掉
            str = str.replaceAll("[.]$", "");
        }
        return str;
    }

    /**
     * @Method: getDecimalFormatString @param input input @param digits
     *          digits @return String @throws
     */
    public static String getDecimalFormatString(double input, int digits) {
        BigDecimal bd = new BigDecimal(input);
        bd = bd.setScale(digits, BigDecimal.ROUND_HALF_UP);

        return filterZeroAndDot(bd.toString());
    }

    /**
     * 半角转换为全角（用于textview换行不整齐时使用）
     * 
     * @param input
     *            input
     * @return String
     */
    public static String toDBC(String input) {
        if (input == null) {
            return "";
        }
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }

    /**
     * @Method: sortString @param str str @return String @throws
     */
    public static String sortString(String str) {
        String[] orderDishID = str.split(",");
        Arrays.sort(orderDishID);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < orderDishID.length; i++) {
            sb.append(orderDishID[i]);
            if (i + 1 < orderDishID.length) {
                sb.append(",");
            }
        }
        orderDishID = null;
        str = null;
        return sb.toString();
    }

    /**
     * @Method: isTelNumAvailable @param telNum telNum @return boolean @throws
     */
    public static boolean isTelNumAvailable(String telNum) {
        boolean result = false;
        if (!isNullOrEmpty(telNum) && telNum.matches("^1[3-9]{1}[0-9]{9}$")) {
            result = true;
        }
        return result;
    }

    /**
     * 是否是汉字，英文，数字或者其中几个组成
     * 
     * @param s
     *            s
     * @return boolean
     */
    public static boolean isValidEngOrChOrNum(String s) {
        if (null == s) {
            return false;
        }
        Pattern pattern = Pattern.compile("[\u4E00-\u9FA5A-Za-z0-9]*$");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    /**
     * 
     * @Title: listToString
     * @Description: 把list集合数据转化成带逗号的字符串
     * @param list
     *            list
     * @param spec
     *            spec
     * @return String
     */
    public static String listToString(List<String> list, String spec) {
        StringBuilder sb = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (i < list.size() - 1) {
                    sb.append(list.get(i) + spec);
                } else {
                    sb.append(list.get(i));
                }
            }
        }
        return sb.toString();
    }

    /**
     * 
     * @Title: listToString
     * @Description: 把list集合数据转化成带逗号的字符串
     * @param list
     *            list
     * @return String
     */
    public static String listToString(List<String> list) {
        return listToString(list, ",");
    }

    public static String StringArrayToString(String[] list, String spec) {
        StringBuilder sb = new StringBuilder();
        if (list != null && list.length > 0) {
            for (int i = 0; i < list.length; i++) {
                if (i < list.length - 1) {
                    sb.append(list[i] + spec);
                } else {
                    sb.append(list[i]);
                }
            }
        }

        return sb.toString();
    }

    /**
     * 
     * @Title: listToString
     * @Description: 把list集合数据转化成带逗号的字符串
     * @param list
     *            list
     * @return String
     */
    public static String StringArrayToString(String[] list) {
        return StringArrayToString(list, ",");
    }

    /**
     * JAVA判断字符串数组中是否包含某字符串元素
     * 
     * @param substring
     *            某字符串
     * @param source
     *            源字符串数组
     * @return 包含则返回true，否则返回false
     */
    public static boolean isInArray(String substring, String[] source) {
        if (source == null || source.length == 0) {
            return false;
        }

        for (int i = 0; i < source.length; i++) {
            String aSource = source[i];
            if (aSource.equals(substring)) {
                return true;
            }
        }

        return false;
    }

    /**
     * JAVA判断字符串数组中是否包含某字符串元素
     * 
     * @param substring
     *            某字符串
     * @param source
     *            源字符串数组
     * @return 包含则返回true，否则返回false
     */
    public static boolean isIn(String substring, String... source) {
        if (substring == null || source == null || source.length == 0) {
            return false;
        }

        for (int i = 0; i < source.length; i++) {
            String aSource = source[i];
            if (substring.equals(aSource)) {
                return true;
            }
        }

        return false;
    }

    public static boolean contain(String substring, String source) {
        if (substring == null || source == null) {
            return false;
        }

        if (source.indexOf(substring) >= 0) {
            return true;
        }

        return false;
    }

    public static String getHtmlMemberCardInfoDesc(List<String> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            text.append(i + 1);
            text.append("、");
            text.append(list.get(i));

            if (i < list.size() - 1) {
                text.append("\n");
            }
        }

        return text.toString();

    }

    /**
     * 字符串转化为数字
     * 
     * @param str
     * @return
     */
    public static int toDigit(String str) {
        if (isNumberString(str)) {
            return Integer.parseInt(str);
        } else {
            return 0;
        }
    }

    /**
     * 字符串转化为数字
     * 
     * @param str
     * @return
     */
    public static Integer toDigit(Object str) {
        if (str != null) {
            String v = str.toString();
            if (isNumberString(v)) {
                return Integer.parseInt(v);
            }
        }

        return null;
    }

    public static String string2Unicode(String s) {
        try {
            StringBuffer out = new StringBuffer("");
            // 直接获取字符串的unicode二进制
            byte[] bytes = s.getBytes("unicode");
            // 然后将其byte转换成对应的16进制表示即可
            for (int i = 0; i < bytes.length - 1; i += 2) {
                out.append("\\u");
                String str = Integer.toHexString(bytes[i + 1] & 0xff);
                for (int j = str.length(); j < 2; j++) {
                    out.append("0");
                }
                String str1 = Integer.toHexString(bytes[i] & 0xff);
                out.append(str1);
                out.append(str);
            }
            return out.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String unicode2String(String unicode) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(unicode);
        char ch;
        while (matcher.find()) {
            // group 6728
            String group = matcher.group(2);
            // ch:'木' 26408
            ch = (char) Integer.parseInt(group, 16);
            // group1 \u6728
            String group1 = matcher.group(1);
            unicode = unicode.replace(group1, ch + "");
        }
        return unicode;
    }

    public static int countNumber(String str) {
        int count = 0;
        Pattern p = Pattern.compile("\\d");
        Matcher m = p.matcher(str);
        while (m.find()) {
            count++;
        }
        return count;
    }

    public static int countLetter(String str) {
        int count = 0;
        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(str);
        while (m.find()) {
            count++;
        }
        return count;
    }

    public static int countChinese(String str) {
        int count = 0;
        Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]");
        Matcher m = p.matcher(str);
        while (m.find()) {
            count++;
        }
        return count;
    }

    public static Boolean greaterThanZero(Integer input) {
        return input != null && input > 0;
    }

    public static String replace(String inString, String oldPattern, String newPattern) {
        if (!hasLength(inString) || !hasLength(oldPattern) || newPattern == null) {
            return inString;
        }
        StringBuilder sb = new StringBuilder();
        int pos = 0; // our position in the old string
        int index = inString.indexOf(oldPattern);
        // the index of an occurrence we've found, or -1
        int patLen = oldPattern.length();
        while (index >= 0) {
            sb.append(inString.substring(pos, index));
            sb.append(newPattern);
            pos = index + patLen;
            index = inString.indexOf(oldPattern, pos);
        }
        sb.append(inString.substring(pos));
        // remember to append any characters to the right of a match
        return sb.toString();
    }

    public static boolean hasLength(String str) {
        return hasLength((CharSequence) str);
    }

    public static boolean hasLength(CharSequence str) {
        return (str != null && str.length() > 0);
    }

    /**
     * 随机指定范围内N个不重复的数 在初始化的无重复待选数组中随机产生一个数放入结果中， 将待选数组被随机到的数，用待选数组(len-1)下标对应的数替换
     * 然后从len-2里随机产生下一个随机数，如此类推
     * 
     * @param max
     *            指定范围最大值
     * @param min
     *            指定范围最小值
     * @param n
     *            随机数个数
     * @return int[] 随机数结果集
     */
    public static int[] randomArray(int min, int max, int n) {
        int len = max - min + 1;

        if (max < min || n > len) {
            return null;
        }

        // 初始化给定范围的待选数组
        int[] source = new int[len];
        for (int i = min; i < min + len; i++) {
            source[i - min] = i;
        }

        int[] result = new int[n];
        Random rd = new Random();
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            // 待选数组0到(len-2)随机一个下标
            index = Math.abs(rd.nextInt() % len--);
            // 将随机到的数放入结果集
            result[i] = source[index];
            // 将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换
            source[index] = source[len];
        }
        return result;
    }

    public static int getCount(String str, String key) {
        if (str == null || key == null || "".equals(str.trim()) || "".equals(key.trim())) {
            return 0;
        }
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(key, index)) != -1) {
            index = index + key.length();
            count++;
        }
        return count;
    }
}
