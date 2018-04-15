package com.att.biq.day3.linkList;

public class Main
{
	public static void main(String[] args)
	{
		LinkList<Person> list = new LinkList<Person>();
		Person person = new Person("Ilan",100);
		Person person1 = new Person("Doron",1001);
		list.add(person);
		list.add(person1);
		list.add(new Person ("Guy",22));
		list.add(new Person("Guy",22));
		list.add(new Person("Guy2",42323));
		list.add(new Person("Guy3",342342));
		list.add(new Person("Guy4",3245345));
		list.add(new Person("Guy4",3245345));
		person1 = new Person("Doron",1001);
		list.add(person1);
		System.out.println(list);
		System.out.println("List Size:" + list.size());
		/*Node node = list.find(person);
		System.out.println("Find: " + node);
		System.out.println("List Size:" + list.size());
		list.remove(person);
		list.remove(person1);
		System.out.println(list);
		//list.clear();
		System.out.println("List Size:" + list.size());

		System.out.println("FirstNode: " + list.getHeadNode());
		System.out.println("LastNode: " + list.getLastNode());*/

		
		list.dellAllDuplicateName();
		System.out.println(list);
		System.out.println("List Size:" + list.size());
	}
}
