package cn.xiaoxian.service.impl;

import org.apache.log4j.Logger;

import cn.xiaoxian.service.IMessageService;

public class MessageServiceImpl implements IMessageService {

	@Override
	public boolean remove(String mid) {
		Logger.getLogger(IMessageService.class).info(("【业务层处理】执行删除操作，删除的id="+mid));
		return false;
	}

}
