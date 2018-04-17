package com.att.biq.day5.vote;

public class Vote
{
	private VoteOptionsEnum voteEnum;

	public Vote(VoteOptionsEnum voteEnum)
	{
		this.voteEnum = voteEnum;
	}

	public VoteOptionsEnum getVoteEnum()
	{
		return voteEnum;
	}

	public void setVoteEnum(VoteOptionsEnum voteEnum)
	{
		this.voteEnum = voteEnum;
	}

}
