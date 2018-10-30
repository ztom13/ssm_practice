package com.ztom.library.dao;

import com.ztom.library.domain.Appointment;
import com.ztom.library.domain.Book;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

/**
 * author:ztom
 * date:2018/10/25 14:43
 */
public interface AppointmentDao {

    /**
     * 插入一条预约记录
     * 主键冲突问题: 插入时,主键对应的值已经存在.
     * 解决: 1) insert ignore into  忽略新值,返回0
     * 2) insert replace into  替换旧值,返回1
     * 3) insert into ... on duplicate key update 存在则更新,不存在则插入
     *
     * @param appointment
     * @return
     */
    @Results({
            @Result(id = true, column = "student_id", property = "studentId"),
            @Result(id = true, column = "book_id", property = "bookId"),
            @Result(column = "appoint_time", property = "appointTime")
    })
    @Insert("insert ignore into appointment values(#{studentId},#{bookId},#{appointTime})")
    int insertAppointment(Appointment appointment);

    /**
     * 根据学号查询预约信息
     *
     * @param studentId
     * @param bookId
     * @return
     */
    @Results({
            @Result(id = true, column = "student_id", property = "studentId"),
            @Result(column = "book_id", property = "bookId"),
            @Result(column = "appoint_time", property = "appointTime"),
            @Result(column = "book_id", property = "book", javaType = Book.class,
                    one = @One(select = "com.ztom.library.dao.BookDao.findById",
                            fetchType = FetchType.LAZY))
    })
    @Select("select * from appointment where student_id=#{param1} and book_id=#{param2}")
    Appointment findAppointById(Long studentId, Long bookId);

    /**
     * 根据studentID和bookId删除预约记录
     * @param studentId
     * @param bookId
     * @return
     */
    @Results({
            @Result(id = true, column = "student_id", property = "studentId"),
            @Result(id = true, column = "book_id", property = "bookId"),
            @Result(column = "appoint_time", property = "appointTime")
    })
    @Delete("delete from appointment where student_id=#{param1} and book_id=#{param2}")
    int delAppointment(Long studentId, Long bookId);
}
