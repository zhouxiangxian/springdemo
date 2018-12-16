package cn.xiaoxian.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import cn.xiaoxian.dao.IDeptDAO;
import cn.xiaoxian.vo.Dept;
@Repository
public class DeptDAOImpl implements IDeptDAO{

	@Override
	public boolean doCreate(Dept vo) {
		Logger.getLogger(DeptDAOImpl.class).info(vo.toString());
		return true;
	}

}
