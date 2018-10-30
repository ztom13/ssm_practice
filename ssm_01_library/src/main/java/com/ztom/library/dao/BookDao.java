package com.ztom.library.dao;

import com.ztom.library.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Q是平剑式，W是破剑式，E是浪剑式，R是离剑式加落剑式，旋风Q是撩剑式，EQ是荡剑式，EQ闪是截剑式，Q完反向E是挫剑式
 * author:ztom
 * date:2018/10/25 14:41
 */
public interface BookDao {

    /**
     * 分页查询所有图书信息
     *
     * @param offset   分页起始位置
     * @param pageSize 每页显示条数
     * @return
     */
    @Results({
            @Result(id = true, column = "book_id", property = "bookId")
    })
    @Select("select * from book order by book_id limit #{param1},#{param2}")
    List<Book> findAll(int offset, int pageSize);

    /**
     * 根据id查询图书
     *
     * @param id
     * @return
     */
    @Results({
            @Result(id = true, column = "book_id", property = "bookId")
    })
    @Select("select * from book where book_id=#{id}")
    Book findById(Long id);

    /**
     * 添加图书
     *
     * @param book
     */
    @Insert("insert into book values(null,#{name},#{number})")
    int save(Book book);

    /**
     * 修改图书信息
     *
     * @param book
     */
    @Results({
            @Result(id = true, column = "book_id", property = "bookId")
    })
    @Update("update book set name=#{name},number=#{number} where book_id=#{bookId}")
    int update(Book book);

    /**
     * 根据id减少图书数量
     *
     * @param id 图书id
     */
    @Results({
            @Result(id = true, column = "book_id", property = "bookId")
    })
    @Update("update book set number=number-1 where book_id=#{id} and number>0")
    int reduceNumber(Long id);

    /**
     * 根据id增加图书数量
     *
     * @param id 图书id
     */
    @Results({
            @Result(id = true, column = "book_id", property = "bookId")
    })
    @Update("update book set number=number+1 where book_id=#{id}")
    int addNumber(Long id);

    /**
     * 根据id删除此类所有图书
     *
     * @param id 图书id
     */
    @Results({
            @Result(id = true, column = "book_id", property = "bookId")
    })
    @Delete("delete from book where book_id=#{id}")
    int delById(Long id);
}
