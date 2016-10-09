package java.briup.basic;

import java.util.Arrays;

/**
 * Created by ZH on 2016/2/3.
 */
public class ConvertMoney {
    private String[] hanArr= {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    private String[] unitArr = {"十","百","千"};

    /** 把一个浮点数分解成整数部分和小数部分字符串
     * @param num 需要被分解的浮点数
     * @return 分解出来的整数部分和小数部分构成的数组。第一个数组元素是整数部分，第二个数组元素是小数部分。
     */
    private String[] divide(double num){
        //将一个浮点数强制类型转换为long，即得到它的整数部分。
        long zheng = (long)num;
        //浮点数减去整数部分，得到小数部分，小数部分乘以100后再取整得到2位小数。
        //Math类的round方法，返回与参数最接近(经四舍五入后)的整数。
        long xiao = Math.round((num - zheng) * 100);
        //下面用了2种方法把整数转换为字符串。
        //return一个匿名数组。
        //String类的valueOf(int i)方法,返回整数参数的字符串表达式。
        return new String[]{zheng + ","+ String.valueOf(xiao)};
    }

    /**
     * 把一个12位以内的数字字符串变成汉字字符串
     * @param numStr 需要被转换的数字字符串
     * @return 数字字符串被转换成的汉字字符串。
     */

    private String toHanStr(String numStr){
        int strLen = numStr.length();
        int yu = strLen % 4;
        //partNum表示该数字字符串可划分成的节数（每4位为一节）。
        //如余数等于0，则将strLen/4赋值给partNum；否则将strLen/4 + 1赋值给partNum。
        int partNum = yu == 0 ? strLen/4 : strLen/4 + 1;
        //firstPartLen表示第一节的长度
        int firstPartLen = strLen - (partNum - 1)*4;
        String resultFirst = "";
        String resultSecond = "";
        String resultThird = "";

        //依次遍历数字字符串的每一节
        for (int i = 0 ; i < partNum ; i ++ ){
            //转换第一节
            if (i == 0){
                //通过调用String类的substring方法来返回子串 [beginIndex, endIndex)，
                //即：包括起始索引，不包括结束索引。
                String firstPart = numStr.substring(0, firstPartLen);
                //依次遍历第一节中的每一位数字
                for (int j = 0 ; j < firstPartLen ; j ++ ){
                    //String类的charAt(int index)，返回指定索引处的字符串值。(类似于数组)。
                    //把char型数字转换成的int型数字，因为它们的ASCII码值恰好相差48;
                    //因此把char型数字减去48得到int型数字，例如'4'被转换成4。
                    int num = firstPart.charAt(j) - 48;
                    //如果不是最后一位数字，而且数字不是零，则需要添加单位（十、百、千）
                    if (j != firstPartLen-1 && num != 0){
                        resultFirst += hanArr[num] + unitArr[firstPartLen - 2 - j];
                    } else if (j == firstPartLen - 1 && num != 0){
                        //如果是最后一位数字，而且数字不是零，则不要添加单位
                        resultFirst += hanArr[num];
                    }else if (j == 2 && num == 0 && firstPart.charAt(1) - 48 == 0
                            && firstPart.charAt(0) - 48 != 0
                            && firstPart.charAt(firstPartLen - 1) - 48 != 0){
                        //如果这一节的中间两个数字为0, 且第一位和最后一位数字不为0, 则需要读出一个零
                        resultFirst += hanArr[num];
                    }
                    //剩下的就是hanArr和unitArr都不需要读出来的情况
                }
            }else if (i == 1){
                //转换第二节
                String secondPart = numStr.substring(firstPartLen, (firstPartLen + 4));
                int secPartLen = secondPart.length();
                for (int k = 0 ; k < secPartLen ; k ++ ){
                    int num = secondPart.charAt(k) - 48;
                    if (k != secPartLen-1 && num != 0){
                        resultSecond += hanArr[num] + unitArr[secPartLen - 2 - k];
                    }else if (k == secPartLen - 1 && num != 0){
                        resultSecond += hanArr[num];
                    }else if (k == 2 && num == 0 && secondPart.charAt(1) - 48 == 0
                            && secondPart.charAt(secPartLen - 1) - 48 != 0){
                        resultSecond += hanArr[num];
                    }
                }
                //如果四位数字全是0, 且第二节不是最后一节, 则只需读出一个零。
                //Integer类的parseInt(String s)方法：将整数字符串参数解析成一个带符号的十进制整数。
                if (Integer.parseInt(secondPart) == 0 && partNum == 3){
                    resultSecond = hanArr[0];
                }
            }else if (i == 2){
                //转换第三节
                String thirdPart = numStr.substring((firstPartLen + 4), strLen);
                int thirdPartLen = thirdPart.length();
                for (i = 0 ; i < thirdPartLen ; i ++ ){
                    int num = thirdPart.charAt(i) - 48;
                    if (i != thirdPartLen-1 && num != 0){
                        resultThird += hanArr[num] + unitArr[thirdPartLen - 2 - i];
                    }else if (i == thirdPartLen - 1 && num != 0){
                        resultThird += hanArr[num];
                    }
                    else if (i == 2 && num == 0 && thirdPart.charAt(1) - 48 == 0
                            && thirdPart.charAt(thirdPartLen - 1) - 48 != 0){
                        resultThird += hanArr[num];
                    }
                }
            }
        }
        String result = "";
        if (partNum == 1){
            //如果数字仅为0
            if (resultFirst == ""){
                result = hanArr[0] + "元";
            }else{
                result = resultFirst + "元";
            }
        }
        else if (partNum == 2){
            //如果第二节全为0
            if (Integer.parseInt(numStr.substring(firstPartLen, (firstPartLen + 4))) == 0){
                result = resultFirst + "万";
            }else{
                result = resultFirst + "万" + " " + resultSecond+ "元";
            }
        }
        else if (partNum == 3){

            result = resultFirst + "亿" + " " + resultSecond + "万" + " " + resultThird+ "元";
            //如果第二节和第三节均全为0
            if (Integer.parseInt(numStr.substring(firstPartLen, (firstPartLen + 4))) == 0
                    && Integer.parseInt(numStr.substring((firstPartLen + 4), strLen)) == 0){
                result = resultFirst + "亿";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ConvertMoney nr = new ConvertMoney();
        System.out.println(Arrays.toString(nr.divide(236711125.123)));
        System.out.println(nr.toHanStr("123456789123"));
    }
}
