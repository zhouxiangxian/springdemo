package cn.xiaoxian.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xiaoxian.dao.IDeptDAO;
import cn.xiaoxian.service.IDeptService;
import cn.xiaoxian.vo.Dept;
@Service
public class DeptServiceImpl implements IDeptService {
	@Resource
	private IDeptDAO deptDAO;

	public boolean add(Dept vo) {
		return this.deptDAO.doCreate(vo);
	}

}
