package driver.model;

import java.util.*;

public class Location
{
	public static void main(String args[])
	{
		//构造需要点对象
		NodeT a=new NodeT("1");
		NodeT b=new NodeT("2");
		NodeT c=new NodeT("3");
		NodeT d=new NodeT("4");
		NodeT e=new NodeT("5");
		NodeT f=new NodeT("6");
		NodeT g=new NodeT("7");
		NodeT h=new NodeT("8");
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
        	Thread.sleep(5000);
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
	/* 点的所有关系的集合 */
	List<ArcT> outgoing;
	//点的字母
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
	NodeT start,end;/* 开始点，结束点 */
	public ArcT(NodeT start,NodeT end)
	{
		this.start=start;
		this.end=end;
	}

}
