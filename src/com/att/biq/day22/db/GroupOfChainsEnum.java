package com.att.biq.day22.db;

public enum GroupOfChainsEnum
{
	GROUP_ID("group_id"), GROUP_NAME("group_name"), GROUP_TYPE("group_type");

	String value;

	private GroupOfChainsEnum(String value)
	{
		this.value = value;
	}
}