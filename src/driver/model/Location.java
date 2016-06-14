package driver.model;

import java.util.*;

import server.problemdomain.matching.Matching;

public class Location
{
	//private static Matching match;

	public static void main(String args[])
	{

		//match.getFrom();  출발지
		//match.getTo();  도착지

		/*
		 * 매칭 정보 어떻게 받아요.....
		 *
		 * */


		//Node
		NodeT a=new NodeT("A");
		NodeT b=new NodeT("B");
		NodeT c=new NodeT("C");
		NodeT d=new NodeT("D");
		NodeT e=new NodeT("E");
		NodeT f=new NodeT("F");
		NodeT g=new NodeT("G");
		NodeT h=new NodeT("H");
		ArcT ab=new ArcT(a,b);
		ArcT ac=new ArcT(a,c);
		ArcT ad=new ArcT(a,d);
		ArcT ah=new ArcT(a,h);
		ArcT bc=new ArcT(b,c);
		ArcT de=new ArcT(d,e);
		ArcT ef=new ArcT(e,f);
		ArcT eg=new ArcT(e,g);
		ArcT hg=new ArcT(h,g);

		//建立它们的关系
		a.outgoing.add(ab);
		a.outgoing.add(ac);
		a.outgoing.add(ad);
		a.outgoing.add(ah);
		b.outgoing.add(bc);
		d.outgoing.add(de);
		e.outgoing.add(ef);
		e.outgoing.add(eg);
		h.outgoing.add(hg);

		//构造本对象
		Location search=new Location();



		//深度遍历
		System.out.println("경로:");
		List<NodeT> visited=new ArrayList<NodeT>();
		search.deptFisrtSearch(a,visited);

	}

		/*
		 * cur
		 * visited
		 */
	void deptFisrtSearch(NodeT cur,List<NodeT> visited)
	{
		//Visited
		if(visited.contains(cur))
			return;
		visited.add(cur);
		System.out.println("지금 위치 -> "+cur.word);
		try {
        	Thread.sleep(1500);
		}
	catch (InterruptedException e)
	{
        e.printStackTrace();
	}
		for(int i=0;i<cur.outgoing.size();i++)
		{
			//end
			deptFisrtSearch(cur.outgoing.get(i).end,visited);
		}
	}


}

	/**
	  * point of graph
	  */
class NodeT
{
	/* List of outgoing */
	List<ArcT> outgoing;
	//node word
	String word;
	public NodeT(String word)
	{
		this.word=word;
		outgoing=new ArrayList<ArcT>();
	}
}

	/**
	  * 单个图点的关系
	  */
class ArcT
{
	NodeT start,end;/* start node, end node */
	public ArcT(NodeT start,NodeT end)
	{
		this.start=start;
		this.end=end;
	}

}
