package com.att.biq.day5.vote;

public class Envelop
{
	private Integer id;
	private int total;
	private Vote vote;

	public Envelop(Integer id, Vote vote)
	{
		this.id = id;
		this.vote = vote;
		this.total=0;
	}
	public Envelop(Integer id, Vote vote,int total)
	{
		this.id = id;
		this.vote = vote;
		this.total = total;
	}
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Vote getVote()
	{
		return vote;
	}

	public void setVote(Vote vote)
	{
		this.vote = vote;
	}

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}

}
