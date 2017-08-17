package com.james.spring.dao.mapper.master;

import com.james.spring.entity.LeyaoWeb;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface LeyaoWebMapper {
    @Delete({
        "delete from leyao_web",
        "where item_id = #{itemId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer itemId);

    @Insert({
        "insert into leyao_web (item_id, item_parent_id, ",
        "item_type, item_name, ",
        "item_url, item_order, ",
        "item_length, item_width, ",
        "is_delete, create_username, ",
        "create_timestamp, update_username, ",
        "update_timestamp)",
        "values (#{itemId,jdbcType=INTEGER}, #{itemParentId,jdbcType=INTEGER}, ",
        "#{itemType,jdbcType=INTEGER}, #{itemName,jdbcType=VARCHAR}, ",
        "#{itemUrl,jdbcType=VARCHAR}, #{itemOrder,jdbcType=INTEGER}, ",
        "#{itemLength,jdbcType=INTEGER}, #{itemWidth,jdbcType=INTEGER}, ",
        "#{isDelete,jdbcType=INTEGER}, #{createUsername,jdbcType=VARCHAR}, ",
        "#{createTimestamp,jdbcType=TIMESTAMP}, #{updateUsername,jdbcType=VARCHAR}, ",
        "#{updateTimestamp,jdbcType=TIMESTAMP})"
    })
    int insert(LeyaoWeb record);

    @InsertProvider(type=LeyaoWebSqlProvider.class, method="insertSelective")
    int insertSelective(LeyaoWeb record);

    @Select({
        "select",
        "item_id, item_parent_id, item_type, item_name, item_url, item_order, item_length, ",
        "item_width, is_delete, create_username, create_timestamp, update_username, update_timestamp",
        "from leyao_web",
        "where item_id = #{itemId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="item_id", property="itemId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item_parent_id", property="itemParentId", jdbcType=JdbcType.INTEGER),
        @Result(column="item_type", property="itemType", jdbcType=JdbcType.INTEGER),
        @Result(column="item_name", property="itemName", jdbcType=JdbcType.VARCHAR),
        @Result(column="item_url", property="itemUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="item_order", property="itemOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="item_length", property="itemLength", jdbcType=JdbcType.INTEGER),
        @Result(column="item_width", property="itemWidth", jdbcType=JdbcType.INTEGER),
        @Result(column="is_delete", property="isDelete", jdbcType=JdbcType.INTEGER),
        @Result(column="create_username", property="createUsername", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_timestamp", property="createTimestamp", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_username", property="updateUsername", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_timestamp", property="updateTimestamp", jdbcType=JdbcType.TIMESTAMP)
    })
    LeyaoWeb selectByPrimaryKey(Integer itemId);
    
    @Select({
        "select",
        "item_id, item_parent_id, item_type, item_name, item_url, item_order, item_length, ",
        "item_width, is_delete, create_username, create_timestamp, update_username, update_timestamp",
        "from leyao_web"
    })
    @Results({
        @Result(column="item_id", property="itemId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item_parent_id", property="itemParentId", jdbcType=JdbcType.INTEGER),
        @Result(column="item_type", property="itemType", jdbcType=JdbcType.INTEGER),
        @Result(column="item_name", property="itemName", jdbcType=JdbcType.VARCHAR),
        @Result(column="item_url", property="itemUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="item_order", property="itemOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="item_length", property="itemLength", jdbcType=JdbcType.INTEGER),
        @Result(column="item_width", property="itemWidth", jdbcType=JdbcType.INTEGER),
        @Result(column="is_delete", property="isDelete", jdbcType=JdbcType.INTEGER),
        @Result(column="create_username", property="createUsername", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_timestamp", property="createTimestamp", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_username", property="updateUsername", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_timestamp", property="updateTimestamp", jdbcType=JdbcType.TIMESTAMP)
    })
    List<LeyaoWeb> getAll();

    @UpdateProvider(type=LeyaoWebSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LeyaoWeb record);

    @Update({
        "update leyao_web",
        "set item_parent_id = #{itemParentId,jdbcType=INTEGER},",
          "item_type = #{itemType,jdbcType=INTEGER},",
          "item_name = #{itemName,jdbcType=VARCHAR},",
          "item_url = #{itemUrl,jdbcType=VARCHAR},",
          "item_order = #{itemOrder,jdbcType=INTEGER},",
          "item_length = #{itemLength,jdbcType=INTEGER},",
          "item_width = #{itemWidth,jdbcType=INTEGER},",
          "is_delete = #{isDelete,jdbcType=INTEGER},",
          "create_username = #{createUsername,jdbcType=VARCHAR},",
          "create_timestamp = #{createTimestamp,jdbcType=TIMESTAMP},",
          "update_username = #{updateUsername,jdbcType=VARCHAR},",
          "update_timestamp = #{updateTimestamp,jdbcType=TIMESTAMP}",
        "where item_id = #{itemId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(LeyaoWeb record);
}