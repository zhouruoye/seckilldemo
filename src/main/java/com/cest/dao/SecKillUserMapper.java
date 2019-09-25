package com.cest.dao;

import com.cest.pojo.entity.SecKillUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cestlavie on 2019/9/23.
 */
@Repository
public interface SecKillUserMapper {

    List<SecKillUser> queryList();

    SecKillUser queryUserById(@Param("id")String id);
}
