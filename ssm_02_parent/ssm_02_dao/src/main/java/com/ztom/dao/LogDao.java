package com.ztom.dao;

import com.ztom.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;

/**
 * author:ztom
 * date:2018/11/5 11:14
 */
public interface LogDao {

    @SelectKey(keyColumn = "id",keyProperty = "id",before = true,resultType = Integer.class,
    statement = "select log_seq.nextval from dual")
    @Insert("insert into sys_log values(#{id},to_date(#{visitTime},'yyyy-mm-dd hh24:mi:ss'),#{username}," +
            "#{ip},#{method})")
    void save(SysLog log);
}
