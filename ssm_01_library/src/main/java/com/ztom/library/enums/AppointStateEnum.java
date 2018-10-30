package com.ztom.library.enums;

/**
 * author:ztom
 * date:2018/10/25 17:59
 */
public enum AppointStateEnum {
    SUCCESS(1,"预约成功"),NO_NUM(0,"库存不足"),
    REPEAT_APPOINT(-1,"重复预约"),INNER_ERROR(-2,"系统异常");

    private Integer state;
    private String stateInfo;

    AppointStateEnum(Integer state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public Integer getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static AppointStateEnum stateOf(int index){
        for (AppointStateEnum state : values()) {
            if(state.getState() == index){
                return state;
            }
        }
        return null;
    }
}
