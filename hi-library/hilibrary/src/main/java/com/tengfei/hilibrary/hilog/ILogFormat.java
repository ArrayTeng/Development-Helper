package com.tengfei.hilibrary.hilog;

/**
 * @author 滕飞
 * date 2020/7/13 8:28 PM
 * email arrayadapter.cn@outlook.com
 * description
 */
public interface ILogFormat<T> {

    /**
     * 格式化log信息
     * @return String
     */
    public String format(T data);

}
