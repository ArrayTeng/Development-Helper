package com.tengfei.hilibrary.hilog;

import androidx.annotation.NonNull;

/**
 * @author 滕飞
 * date 2020/7/8 5:01 PM
 * email arrayadapter.cn@outlook.com
 * description
 */
public class HiLogManager {

    private HiLogConfig hiLogConfig;

    private HiLogManager() {
    }

    public static HiLogManager instance() {
        return Holder.HI_LOG_MANAGER;
    }

    private static final class Holder {
        private static final HiLogManager HI_LOG_MANAGER = new HiLogManager();
    }


    public void init(@NonNull HiLogConfig hiLogConfig) {
        this.hiLogConfig = hiLogConfig;
    }

    public HiLogConfig getHiLogConfig() {
        return this.hiLogConfig;
    }
}
