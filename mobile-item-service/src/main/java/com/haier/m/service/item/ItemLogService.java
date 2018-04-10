package com.haier.m.service.item;

import java.util.List;

import com.haier.common.ServiceResult;

public interface ItemLogService {
	public ServiceResult<List> getLog(Integer startLine, Integer endLine, String prefix, String suffix, String search);
}
