package com.app.model.user;

import com.app.domain.common.BaseDao;

public interface UserMasterRepository extends BaseDao<UserMaster, Integer> {

	UserMaster getUserMasterByUserId(String userId);

}
