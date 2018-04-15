package com.att.biq.day5.vote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Envelopes
{
	private ArrayList<Envelop> envelopes = new ArrayList<Envelop>();
	HashMap<Integer, Envelop> goodVoters = new HashMap<Integer, Envelop>();

	public void add(int id, VoteOptionsEnum voteEnum)
	{
		Envelop envelop = new Envelop(id, new Vote(voteEnum));
		envelopes.add(envelop);
	}

	private void removeMultipleVotes()
	{
		for (Envelop envelop : envelopes)
		{
			if (goodVoters.get(envelop.getId()) == null)
			{
				Envelop newEnv = new Envelop(envelop.getId(), envelop.getVote(), 1);
				goodVoters.put(envelop.getId(), newEnv);
			}
			else
			{
				Envelop env = goodVoters.get(envelop.getId());
				int sum = env.getTotal();
				sum = sum + 1;
				env.setTotal(sum);
				goodVoters.put(envelop.getId(), env);
			}
		}
	}

	private HashMap<VoteOptionsEnum, Integer> calc()
	{
		HashMap<VoteOptionsEnum, Integer> calcMap = new HashMap<VoteOptionsEnum, Integer>();
		for (Entry<Integer, Envelop> ent : goodVoters.entrySet())
		{
			if (ent.getValue().getTotal() == 1)
			{
				{
					if (calcMap.get(ent.getValue().getVote().getVoteEnum()) == null)
					{
						calcMap.put(ent.getValue().getVote().getVoteEnum(), 1);
					}
					else
					{
						int sum = calcMap.get(ent.getValue().getVote().getVoteEnum());
						sum = sum + 1;
						calcMap.put(ent.getValue().getVote().getVoteEnum(), sum);
					}
				}
			}
			else
			{
				System.err.println("Failed: " + ent.getKey() + " Votes: " +  ent.getValue().getTotal());
			}
		}
		return calcMap;
	}

	public HashMap<VoteOptionsEnum, Integer> getTotal()
	{
		removeMultipleVotes();
		HashMap<VoteOptionsEnum, Integer> calcMap = calc();
		return calcMap;
	}

}
