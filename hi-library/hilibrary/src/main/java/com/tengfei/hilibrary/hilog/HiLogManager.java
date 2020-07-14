package com.tengfei.hilibrary.hilog;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 滕飞
 * date 2020/7/8 5:01 PM
 * email arrayadapter.cn@outlook.com
 * description
 */
public class HiLogManager {

    private static HiLogManager hiLogManager;

    private HiLogConfig hiLogConfig;

    private List<HiLogPrinter> hiLogPrinters = new ArrayList<>();

    private HiLogManager(HiLogConfig hiLogConfig,HiLogPrinter[] hiLogPrinters) {
        this.hiLogConfig = hiLogConfig;
        this.hiLogPrinters.addAll(Arrays.asList(hiLogPrinters));
    }

    public static HiLogManager getInstance(){
        if (null == hiLogManager){
            throw new IllegalArgumentException("HiLogManager 还没初始化");
        }
        return hiLogManager;
    }

    public static void init(@NonNull HiLogConfig hiLogConfig,HiLogPrinter...hiLogPrinters) {
        hiLogManager = new HiLogManager(hiLogConfig,hiLogPrinters);
    }

    public HiLogConfig getHiLogConfig(){
        return hiLogConfig;
    }

    public List<HiLogPrinter> getHiLogPrinters(){
        return hiLogPrinters;
    }

    public void addHiLogPrinter(HiLogPrinter hiLogPrinter){
        hiLogPrinters.add(hiLogPrinter);
    }

    public void removeHiLogPrinter(HiLogPrinter hiLogPrinter){
        if (hiLogPrinters!=null){
            hiLogPrinters.remove(hiLogPrinter);
        }
    }

}
