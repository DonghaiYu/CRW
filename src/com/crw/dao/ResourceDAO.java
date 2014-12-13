package com.crw.dao;

import java.util.List;
import java.util.Set;

import com.crw.entity.Resource;

public interface ResourceDAO {
	public List<Resource> toGetMembers(long id,int num);
	public void uploadOne(Resource resource);
	public void downloadTimesAddById(long id);
	public List<Resource> toGetUsersResById(long id,int pnum);
	public Resource deleteById(long id);
	public List<Resource> toGetResourcesOf(int num);
	public List<Resource> searchFor(String queryCondition,int pnum);
	public int resultNumOfSearch(String queryCondition,int pnum);
	public int toGetItemNum();
	public int toGetNumForOneCourse(long id);
	public int toGetNumForOneUser(long id);
	public String toGetTypeById(long id);
}
