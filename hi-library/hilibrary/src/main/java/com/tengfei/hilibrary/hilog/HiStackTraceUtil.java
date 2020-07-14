package com.tengfei.hilibrary.hilog;


import androidx.annotation.NonNull;

/**
 * @author 滕飞
 * date 2020/7/14 10:08 PM
 * email arrayadapter.cn@outlook.com
 * description
 */
class HiStackTraceUtil {

    public static StackTraceElement[] getCopyRealStackTrace(StackTraceElement[] elements,@NonNull String ignorePackage,int maxDepth){
        return copyStackTrace(getRealStackTrace(elements,ignorePackage),maxDepth);
    }


    /**
     * 堆栈信息的裁剪
     *
     * @param elements
     * @param maxDepth
     * @return
     */
    private static StackTraceElement[] copyStackTrace(StackTraceElement[] elements, int maxDepth) {
        int realDepth = elements.length;
        if (maxDepth > 0) {
            realDepth = Math.min(realDepth, maxDepth);
        }
        StackTraceElement[] realStackTraceElement = new StackTraceElement[realDepth];
        System.arraycopy(elements, 0, realStackTraceElement, 0, realDepth);
        return realStackTraceElement;
    }

    /**
     * 获取真实的堆栈信息
     *
     * @return
     */
    private static StackTraceElement[] getRealStackTrace(StackTraceElement[] elements, @NonNull String ignorePackage) {
        int ignoreDepth = 0;
        int allStackDepth = elements.length;
        String className;

        for (int i = allStackDepth - 1; i >= 0; i--) {
            className = elements[i].getClassName();
            if (className.startsWith(ignorePackage)) {
                ignoreDepth = i + 1;
                break;
            }
        }

        int realDepth = allStackDepth - ignoreDepth;
        StackTraceElement[] realStackTraceElement = new StackTraceElement[realDepth];
        System.arraycopy(elements, ignoreDepth, realStackTraceElement, 0, realDepth);
        return realStackTraceElement;
    }
}
