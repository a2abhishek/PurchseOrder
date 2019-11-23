package com.project.daos;

import com.project.models.Status;

public interface StatusDao {
	public boolean addStatus(Status statusObj);
	public boolean updateStatus(String statusName);
	public Status viewStatus(int statusId);
}
