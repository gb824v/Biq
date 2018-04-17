package com.att.biq.day5.vote;

public class Main
{

	public static void main(String[] args)
	{
		Envelopes envelopes = new Envelopes();
		envelopes.add(12349, VoteOptionsEnum.CCC);
		envelopes.add(12349, VoteOptionsEnum.CCC);
		envelopes.add(12349, VoteOptionsEnum.CCC);
		envelopes.add(12349, VoteOptionsEnum.CCC);
		envelopes.add(12349, VoteOptionsEnum.CCC);
		envelopes.add(12348, VoteOptionsEnum.CCC);
		envelopes.add(12348, VoteOptionsEnum.CCC);
		envelopes.add(12346, VoteOptionsEnum.CCC);
		envelopes.add(12345, VoteOptionsEnum.CCC);
		envelopes.add(12343, VoteOptionsEnum.CCC);
		envelopes.add(12343, VoteOptionsEnum.CCC);
		envelopes.add(12378, VoteOptionsEnum.FFF);
		
		System.out.println(envelopes.getTotal());
//		envelopes.add(12349, VoteOptionsEnum.AAA);
//		envelopes.add(12349, VoteOptionsEnum.AAA);
//		envelopes.add(12349, VoteOptionsEnum.AAA);
	}

}
