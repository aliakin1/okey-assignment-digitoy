package okey.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import okey.model.Color;
import okey.model.Number;
import okey.model.Stone;
public class OkeyController {


	// Ta�lar� de�erlerine g�re �retece�iz
	public List<Stone> createAndMixOkeyStones(){
		List<Stone> list=new ArrayList<Stone>();

		int stoneValue=0;
		//create
		for(int j=0;j<Color.values().length;j++)
			for(int i=0;i<Number.values().length;i++)
				for(int k=0;k<2;k++)
				{
					stoneValue=stoneValue+1;
					Stone stone= new Stone(Number.getEnum(i+1).name()+" - "+ Color.getEnum(j).name(), stoneValue, false, false,j,i+1);
					list.add(stone);
				}
		//sahte okey
		Stone stone1= new Stone("sahte OKEY", stoneValue+1, false, false, null, null);
		stone1.setFakeOkey(true);
		list.add(stone1);
		Stone stone2= new Stone("sahte OKEY", stoneValue+2, false, false, null, null);
		stone2.setFakeOkey(true);
		list.add(stone2);


		//create


		//mix
		List<Stone> mixList=new ArrayList<Stone>();

		Random rand = new Random();

		for(int i=106;i>0;i--)
		{
			int  n = rand.nextInt(i) ;
			mixList.add(list.get(n));
			list.remove(n);
		}

		//mix

		return mixList;
	}

	// kar��t�r�lm�� ta�lardan en alttakini a��p 
	//okey olan ta�lar� i�aretleyece�iz.
	public List<Stone> findIsOpenAndIsOkey(List<Stone> mixStones){
		Stone selected=null;
		Integer okeyNumber=0;
		Integer okeyColor=0;
		int intUseLast=105;
		if(mixStones.get(intUseLast).isFakeOkey())
			if(mixStones.get(intUseLast--).isFakeOkey())
				if(mixStones.get(intUseLast--).isFakeOkey())

					mixStones.get(intUseLast).setIsOpened(true);
		selected=mixStones.get(intUseLast);
		okeyColor=selected.getStoneColor();
		if(selected.getStoneNumber()<13)
			okeyNumber= selected.getStoneNumber()+1;
		if(selected.getStoneNumber()==13)
			okeyNumber= 1;
		for(int i=105;i>-1;i--)
		{
			if(!mixStones.get(i).getIsOpened() && !mixStones.get(i).isFakeOkey() && mixStones.get(i).getStoneNumber()==okeyNumber && mixStones.get(i).getStoneColor()==okeyColor)
			{
				mixStones.get(i).setIsOkey(true);
			}
			if(mixStones.get(i).isFakeOkey() )
			{
				mixStones.get(i).setStoneColor(okeyColor);
				mixStones.get(i).setStoneNumber(okeyNumber);

			}
		}

		return mixStones;
	}


	//Kar��t�r�lm�� ta�lar� da��taca��z. 5 farkl� liste olarak g�nderece�iz.
	// Bunlardan 4 tanesi 15 14 14 14 olacak �ekilde 1 tanesi de kalan ta�lar olacakt�r.
	public ArrayList<List<Stone>> distributeOkeyStones(List<Stone> mixStones){
		ArrayList<List<Stone>> hands= new ArrayList<List<Stone>>();
		List<Stone> listA=new ArrayList<Stone>();
		List<Stone> listB=new ArrayList<Stone>();
		List<Stone> listC=new ArrayList<Stone>();
		List<Stone> listD=new ArrayList<Stone>();

		hands.add(listA);
		hands.add(listB);
		hands.add(listC);
		hands.add(listD);



		int count=0;
		for(int k=0;k<2;k++) //TUR
		{
			for(int i=0;i<4;i++)  // K���LER
			{
				for(int j=0;j<7;j++)  //her bir 7 ta� 
				{

					hands.get(i).add(mixStones.get(count));
					count=count+1;
				}	
			}
		}
		hands.get(0).add(mixStones.get(count));// art� bir ta� 
		return hands;
	}
	//en iyi eli bulmaya �al��aca��z ve sonras�ndada bunu d�nece�iz.
	public List<Stone> findBestOfHands(ArrayList<List<Stone>> hands){

		OkeyRules or=new OkeyRules();
		int valueOfmin=100;
		int minHand=0;
		for(int i=0;i<4;i++){
			int result= or.getValueOfWin(hands.get(1));
			if(result<valueOfmin)
			{
			valueOfmin=result;
			minHand=i;
			}
			System.out.println(result);
		}

		return hands.get(minHand);
	}


}
