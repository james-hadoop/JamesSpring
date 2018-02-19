package com.james.spring.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.james.spring.entity.TEventPage;

public interface TEventPageMapper {
    @Select({ "select", "h_event_id, s_event_category_cd, r_event_category_desc, s_event_type_cd, r_event_type_desc, ",
            "s_event_title_url, s_event_content_url, s_event_sub_content_1_url, s_event_sub_content_2_str, ",
            "s_event_active_ind, create_ts, update_ts, s_event_search_content_txt", "from t_event_page" })
    @Results({ @Result(column = "h_event_id", property = "hEventId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "s_event_category_cd", property = "sEventCategoryCd", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_event_category_desc", property = "rEventCategoryDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_type_cd", property = "sEventTypeCd", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_event_type_desc", property = "rEventTypeDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_title_url", property = "sEventTitleUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_content_url", property = "sEventContentUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_sub_content_1_url", property = "sEventSubContent1Url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_sub_content_2_str", property = "sEventSubContent2Str", jdbcType = JdbcType.VARCHAR),
            @Result(column = "s_event_active_ind", property = "sEventActiveInd", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_ts", property = "createTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_ts", property = "updateTs", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "s_event_search_content_txt", property = "sEventSearchContentTxt", jdbcType = JdbcType.LONGVARCHAR) })
    List<TEventPage> getAll();
}
