package com.james.spring.dao.mapper.slave;

import com.james.spring.entity.LeyaoWeb2;
import org.apache.ibatis.jdbc.SQL;

public class LeyaoWeb2SqlProvider {

    public String insertSelective(LeyaoWeb2 record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("leyao_web2");
        
        if (record.getItemId() != null) {
            sql.VALUES("item_id", "#{itemId,jdbcType=INTEGER}");
        }
        
        if (record.getItemParentId() != null) {
            sql.VALUES("item_parent_id", "#{itemParentId,jdbcType=INTEGER}");
        }
        
        if (record.getItemType() != null) {
            sql.VALUES("item_type", "#{itemType,jdbcType=INTEGER}");
        }
        
        if (record.getItemName() != null) {
            sql.VALUES("item_name", "#{itemName,jdbcType=VARCHAR}");
        }
        
        if (record.getItemUrl() != null) {
            sql.VALUES("item_url", "#{itemUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getItemOrder() != null) {
            sql.VALUES("item_order", "#{itemOrder,jdbcType=INTEGER}");
        }
        
        if (record.getItemLength() != null) {
            sql.VALUES("item_length", "#{itemLength,jdbcType=INTEGER}");
        }
        
        if (record.getItemWidth() != null) {
            sql.VALUES("item_width", "#{itemWidth,jdbcType=INTEGER}");
        }
        
        if (record.getIsDelete() != null) {
            sql.VALUES("is_delete", "#{isDelete,jdbcType=INTEGER}");
        }
        
        if (record.getCreateUsername() != null) {
            sql.VALUES("create_username", "#{createUsername,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTimestamp() != null) {
            sql.VALUES("create_timestamp", "#{createTimestamp,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUsername() != null) {
            sql.VALUES("update_username", "#{updateUsername,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTimestamp() != null) {
            sql.VALUES("update_timestamp", "#{updateTimestamp,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(LeyaoWeb2 record) {
        SQL sql = new SQL();
        sql.UPDATE("leyao_web2");
        
        if (record.getItemParentId() != null) {
            sql.SET("item_parent_id = #{itemParentId,jdbcType=INTEGER}");
        }
        
        if (record.getItemType() != null) {
            sql.SET("item_type = #{itemType,jdbcType=INTEGER}");
        }
        
        if (record.getItemName() != null) {
            sql.SET("item_name = #{itemName,jdbcType=VARCHAR}");
        }
        
        if (record.getItemUrl() != null) {
            sql.SET("item_url = #{itemUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getItemOrder() != null) {
            sql.SET("item_order = #{itemOrder,jdbcType=INTEGER}");
        }
        
        if (record.getItemLength() != null) {
            sql.SET("item_length = #{itemLength,jdbcType=INTEGER}");
        }
        
        if (record.getItemWidth() != null) {
            sql.SET("item_width = #{itemWidth,jdbcType=INTEGER}");
        }
        
        if (record.getIsDelete() != null) {
            sql.SET("is_delete = #{isDelete,jdbcType=INTEGER}");
        }
        
        if (record.getCreateUsername() != null) {
            sql.SET("create_username = #{createUsername,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTimestamp() != null) {
            sql.SET("create_timestamp = #{createTimestamp,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUsername() != null) {
            sql.SET("update_username = #{updateUsername,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTimestamp() != null) {
            sql.SET("update_timestamp = #{updateTimestamp,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("item_id = #{itemId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}