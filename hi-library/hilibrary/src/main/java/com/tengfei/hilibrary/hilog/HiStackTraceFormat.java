package com.tengfei.hilibrary.hilog;

/**
 * @author 滕飞
 * date 2020/7/13 9:01 PM
 * email arrayadapter.cn@outlook.com
 * description 堆栈信息格式化
 */
public class HiStackTraceFormat implements ILogFormat<StackTraceElement[]> {

    @Override
    public String format(StackTraceElement[] data) {
        StringBuilder builder = new StringBuilder(128);
        if (null == data || data.length == 0) {
            return "";
        } else if (data.length == 1) {
            return "\t- " + data[0].toString();
        } else {
            for (int i = 0; i < data.length; i++) {
                if (i == 0) {
                    builder.append("StackTrace:\n");
                }
                if (i != data.length - 1) {
                    builder.append("\t |～");
                    builder.append(data[i].toString());
                    builder.append("\n");
                } else {
                    builder.append("\t -|");
                    builder.append(data[i].toString());
                }
            }
        }
        return builder.toString();
    }
}
