package com.ztom.library.vo;

import com.ztom.library.domain.Appointment;
import com.ztom.library.enums.AppointStateEnum;

/**
 * 封装执行预约操作后的结果
 * author:ztom
 * date:2018/10/25 18:06
 */
public class AppointVO {
    private Long bookId;
    private Integer state;
    private String stateInfo;
    private Appointment appointment;

    public AppointVO() {
    }

    /**
     * 预约失败
     * @param bookId
     * @param appointStateEnum
     */
    public AppointVO(Long bookId, AppointStateEnum appointStateEnum) {
        this.bookId = bookId;
        this.state = appointStateEnum.getState();
        this.stateInfo = appointStateEnum.getStateInfo();
    }

    /**
     * 预约成功
     * @param bookId
     * @param appointStateEnum
     * @param appointment
     */
    public AppointVO(Long bookId, AppointStateEnum appointStateEnum, Appointment appointment) {
        this.bookId = bookId;
        this.state = appointStateEnum.getState();
        this.stateInfo = appointStateEnum.getStateInfo();
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AppointVO{");
        sb.append("bookId=").append(bookId);
        sb.append(", state=").append(state);
        sb.append(", stateInfo='").append(stateInfo).append('\'');
        sb.append(", appointment=").append(appointment);
        sb.append('}');
        return sb.toString();
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
