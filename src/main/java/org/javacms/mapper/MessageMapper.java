package org.javacms.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.javacms.beans.Message;
import org.springframework.stereotype.Component;

@Component
public interface MessageMapper {
    @Select("SELECT COUNT(msg_id) msgCount FROM jc_message WHERE msg_receiver_user = #{userId} AND msg_status = 0")
    public Integer getMessageCountByUserId(@Param("userId") Integer userId);
}
