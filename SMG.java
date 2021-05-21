import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.text.*;
import java.util.*;
import java.math.*;
import java.util.Random;

public class SMG extends d20weaponsystem
{
	//-------------------------------------------------------------------
	//initialize variables
	//-------------------------------------------------------------------
	private int damageModInt=0;
	private int accModInt = 0;
	private int magModInt = 0;
	private double FRModInt = 0;
	private double rngModInt = 0;
	private String rngDisp;
	private int magDisp = 0;
	private int accDisp = 0;
	private int FRDisp = 0;
	private int lvlInt = 0;
	private String displayArray[]={"","","","","","","","","","","","",""};
	private int rarityInt = 0;

	private String manuName="";
	private String baseName="";
	private String effName="";
	private String adjName="";
	private String equiName="";

	private String accModel="";
	private String dmgDiceModel="";
	private String dmgModel="";
	private String FRModel = "";
	private String meleeModel="";
	private String scopeModel="";

	private boolean accBoolean=false;
	private boolean dmgBoolean=false;
	private boolean scopeBoolean=false;
	private boolean bladeBoolean=false;

	static Random randomBaseSMG = new Random();
	String[] effectArray = {"","",""};
	String effect="", effectIntensity="", effectChance="";

	//-------------------------------------------------------------------
	//Begin smgStats Method
	//-------------------------------------------------------------------
	public String[] smgStats(int lvlI)
	{
		lvlInt = lvlI; //gets level
		damageModInt = 0; //sets the damage modifier variable to 0

		int randomBaseIntSMG = randomBaseSMG.nextInt(100)+1;
		if(randomBaseIntSMG<=22){
			manuName = "M:I ";
			baseName = "Puma ";
			weapName = "M:I Sub-Machine Gun";
			dmgDiceModel = "Z";

			accuracyBaseInt = -3;
			damageBase = "1d6";
			magazineBaseInt = 24;
			FRBaseDouble = 4;
			rangeBaseInt = 30;
			reloadBase = "1 Std.";
			wgtBase = "8 lbs.";
			rarityInt = 20;
		}
		else if(randomBaseIntSMG>22 && randomBaseIntSMG<=31){
			manuName = "Spectre ";
			baseName = "Ghost ";
			weapName = "Spectre Sub-Machine Gun";
			dmgDiceModel = "R";

			accuracyBaseInt = -3;
			damageBase = "1d4";
			magazineBaseInt = 30;
			FRBaseDouble = 6;
			rangeBaseInt = 25;
			reloadBase = "1 Std.";
			wgtBase = "7 lbs.";
			rarityInt = 30;
		}
		else if(randomBaseIntSMG>31 && randomBaseIntSMG<=38){
			manuName = "Spectre ";
			baseName = "Phantom ";
			weapName = "Spectre Special Sub-Machine Gun";
			dmgDiceModel = "Z";

			accuracyBaseInt = -3;
			damageBase = "1d6";
			magazineBaseInt = 36;
			FRBaseDouble = 7;
			rangeBaseInt = 25;
			reloadBase = "1 Std.";
			wgtBase = "7 lbs.";
			rarityInt = 35;
		}
		else if(randomBaseIntSMG>38 && randomBaseIntSMG<=53){
			manuName = "Radkov ";
			baseName = "Guerrilla ";
			weapName = "Radkov Sub-Machine Gun";
			dmgDiceModel = "Z";

			accuracyBaseInt = -2;
			damageBase = "1d6";
			magazineBaseInt = 30;
			FRBaseDouble = 4;
			rangeBaseInt = 30;
			reloadBase = "1 Rnd.";
			wgtBase = "7 lbs.";
			rarityInt = 30;
		}
		else if(randomBaseIntSMG>53 && randomBaseIntSMG<=75){
			manuName = "MechTec ";
			baseName = "Fury ";
			weapName = "MechTec Sub-Machine Gun";
			dmgDiceModel = "R";

			accuracyBaseInt = -2;
			damageBase = "1d4";
			magazineBaseInt = 24;
			FRBaseDouble = 4;
			rangeBaseInt = 30;
			reloadBase = "1 Std.";
			wgtBase = "8 lbs.";
			rarityInt = 20;
		}
		else if(randomBaseIntSMG>75 && randomBaseIntSMG<=90){
			manuName = "K&L ";
			baseName = "Pulse ";
			weapName = "K&L Sub-Machine Gun";
			dmgDiceModel = "R";

			accuracyBaseInt = -3;
			damageBase = "1d4";
			magazineBaseInt = 24;
			FRBaseDouble = 5;
			rangeBaseInt = 30;
			reloadBase = "1 Move";
			wgtBase = "5 lbs.";
			rarityInt = 30;
		}
		else if(randomBaseIntSMG>90 && randomBaseIntSMG<=100){
			manuName = "Rubicore ";
			baseName = "Sabre ";
			weapName = "Rubicore Sub-Machine Gun";
			dmgDiceModel = "K";

			accuracyBaseInt = -2;
			damageBase = "2d4";
			magazineBaseInt = 20;
			FRBaseDouble = 4;
			rangeBaseInt = 25;
			reloadBase = "1 Std.";
			wgtBase = "7 lbs.";
			rarityInt = 30;
		}
		else{
			accuracyBase = "whoops";
			damageBase = "whoops";
			magazineBase = "whoops";
			firerateBase = "whoops";
			weapName = "whoops";
		}

		magModInt = magazineBaseInt;
		accModInt = accuracyBaseInt;
		FRModInt = FRBaseDouble;
		rngModInt = rangeBaseInt;
		accDisp = 0;
		magDisp = 0;

		int lvlModInt1 = (80-((lvlInt-1)*5));
		double lvlModInt2 = (100-lvlModInt1)*(.60)+lvlModInt1;
		double lvlModInt3 = (100-lvlModInt1)*(.30)+(lvlModInt2);
		double lvlModInt4 = (100-lvlModInt1)*(.10)+(lvlModInt3);

		//---------------------------------------------------------------------------------------------------------------
		//Call effect calculator
		//---------------------------------------------------------------------------------------------------------------

		effects effectsFinder = new effects();
		if(randomBase.nextInt(100)+1<=(lvlInt*2)){
			effectArray = effectsFinder.effectCalc(lvlInt);
			effect="  "+effectArray[0]+"\n";
			effectIntensity="  "+effectArray[1]+"\n";
			effectChance="  "+effectArray[2]+"\n";
			effName = effectArray[3];
			rarityInt = rarityInt+40;
		}

		//-----------------------------------------------------------------------------------------------------------
		//Acc. Modification.
		//-----------------------------------------------------------------------------------------------------------

		int randomAccModInt = randomBase.nextInt(100)+1;
		int randomAccModInt2 = randomBase.nextInt(100)+1;
		int randomAccModInt3 = randomBase.nextInt(100)+1;

		if(randomAccModInt<= (10+((lvlInt-1)*2))){

			if(randomBase.nextInt(100)+1<= (50+((lvlInt-1)*3)) ){

				if(randomAccModInt2<=lvlModInt1){
					accModInt = accModInt + 1;
					accDisp = accDisp+1;
					rarityInt = rarityInt+10;

					if(randomBase.nextInt(100)+1<= 20){
						damageModInt = damageModInt - 1;
						rarityInt = rarityInt-10;
					}
				}
				else if(randomAccModInt2<=lvlModInt2){
					accModInt = accModInt + 2;
					accDisp = accDisp+2;
					rarityInt = rarityInt+20;

					if(randomBase.nextInt(100)+1<= 15){
						damageModInt = damageModInt - 1;
						rarityInt = rarityInt-10;
					}
				}
				else if(randomAccModInt2<=lvlModInt3){
					accModInt = accModInt + 3;
					accDisp = accDisp+3;
					rarityInt = rarityInt+30;

					if(randomBase.nextInt(100)+1<= 10){
						damageModInt = damageModInt - 1;
						rarityInt = rarityInt-10;
					}
				}
				else if(randomAccModInt2<=lvlModInt4){
					accModInt = accModInt + 4;
					accDisp = accDisp+4;
					rarityInt = rarityInt+40;

					if(randomBase.nextInt(100)+1<= 5){
						damageModInt = damageModInt - 1;
						rarityInt = rarityInt-10;
					}
				}
				else{
					descriptionTxt = descriptionTxt + "Whoops ACC +\n";
				}
			}
			else
			{
				if(randomAccModInt3<=80){
					accModInt = accModInt - 1;
					accDisp = accDisp-1;
					rarityInt = rarityInt-10;
				}
				else if(randomAccModInt3<=92){
					accModInt = accModInt - 2;
					accDisp = accDisp-2;
					rarityInt = rarityInt-20;
				}
				else if(randomAccModInt3<=98){
					accModInt = accModInt - 3;
					accDisp = accDisp-3;
					rarityInt = rarityInt-30;
				}
				else if(randomAccModInt3<=100){
					accModInt = accModInt - 4;
					accDisp = accDisp-4;
					rarityInt = rarityInt-40;
				}
				else{
					descriptionTxt = descriptionTxt + "Whoops ACC -\n";
				}
			}
		}

		//-----------------------------------------------------------------------------------------------------------------
		//Damage Modification
		//-----------------------------------------------------------------------------------------------------------------

		int randomDamModInt = randomBase.nextInt(100)+1;
		int randomDamModInt2 = randomBase.nextInt(100)+1;
		int randomDamModInt3 = randomBase.nextInt(100)+1;

		if(randomDamModInt<= (5+((lvlInt-1)*1))){

			if(randomBase.nextInt(100)+1<= (50+((lvlInt-1)*3)) ){

				if(randomDamModInt2<=80){
					damageModInt = damageModInt + 1;
					rarityInt = rarityInt+10;

					if(randomBase.nextInt(100)+1<= 20){
						accModInt = accModInt - 1;
						accDisp = accDisp-1;
						rarityInt = rarityInt-10;
					}
				}
				else if(randomDamModInt2<=100){
					damageModInt = damageModInt + 2;
					rarityInt = rarityInt+20;

					if(randomBase.nextInt(100)+1<= 25){
						accModInt = accModInt - 1;
						accDisp = accDisp-1;
						rarityInt = rarityInt-10;
					}
				}
				else{
					descriptionTxt = descriptionTxt + "Whoops Dam +\n";
				}
			}
			else
			{
				if(randomDamModInt3<=80){
					damageModInt = damageModInt - 1;
					rarityInt = rarityInt-10;
				}
				else if(randomDamModInt3<=92){
					damageModInt = damageModInt - 2;
					rarityInt = rarityInt-20;
				}
				else if(randomDamModInt3<=98){
					damageModInt = damageModInt - 3;
					rarityInt = rarityInt-30;
				}
				else if(randomDamModInt3<=100){
					damageModInt = damageModInt - 3;
					rarityInt = rarityInt-40;
				}
				else{
					descriptionTxt = descriptionTxt + "Whoops Dam -\n";
				}
			}
		}

		//---------------------------------------------------------------------------------------------------------------
		//Magazine Modification
		//---------------------------------------------------------------------------------------------------------------

		int randomMagModInt = randomBase.nextInt(100)+1;
		int randomMagModInt2 = randomBase.nextInt(100)+1;
		int randomMagModInt3 = randomBase.nextInt(100)+1;

		if(randomMagModInt<= (20+((lvlInt-1)*3))){

			if(randomBase.nextInt(100)+1<= (50+((lvlInt-1)*3)) ){

				if(randomMagModInt2<=lvlModInt1){
					magModInt = magModInt + 4;
					magDisp = magDisp+4;
					rarityInt = rarityInt+5;
				}
				else if(randomMagModInt2<=lvlModInt2){
					magModInt = magModInt + 6;
					magDisp = magDisp+6;
					rarityInt = rarityInt+10;
				}
				else if(randomMagModInt2<=lvlModInt3){
					magModInt = magModInt + 8;
					magDisp = magDisp+8;
					rarityInt = rarityInt+15;
				}
				else if(randomMagModInt2<=lvlModInt4){
					magModInt = magModInt + 12;
					magDisp = magDisp+12;
					rarityInt = rarityInt+20;
				}
				else{
					descriptionTxt = descriptionTxt + "Whoops Mag +\n";
				}
			}
			else
			{
				if(randomMagModInt3<=80){
					magModInt = magModInt - 4;
					magDisp = magDisp-4;
					rarityInt = rarityInt-10;
				}
				else if(randomMagModInt3<=100){
					magModInt = magModInt - 8;
					magDisp = magDisp-8;
					rarityInt = rarityInt-15;
				}
				else{
					descriptionTxt = descriptionTxt + "Whoops Mag -\n";
				}
			}
		}

		//---------------------------------------------------------------------------------------------------------------
		//Fire Rate Modification
		//---------------------------------------------------------------------------------------------------------------

		int randomFRModInt = randomBase.nextInt(100)+1;
		int randomFRModInt2 = randomBase.nextInt(100)+1;

		if(randomFRModInt<= (20-((lvlInt-1)*2))){
			if(randomFRModInt2<=100){
				FRModInt = FRModInt - 1;
				FRDisp = FRDisp-1;
				rarityInt = rarityInt-15;
			}
			else{
				descriptionTxt = descriptionTxt + "Whoops FR -\n";
			}
		}

		//---------------------------------------------------------------------------------------------------------------
		//Scope Modification
		//---------------------------------------------------------------------------------------------------------------

		int randomScModInt = randomBase.nextInt(100)+1;
		int randomScModInt2 = randomBase.nextInt(100)+1;

		if(randomScModInt<= (1+((lvlInt-1)*1))){
			if(randomScModInt2<=70){
				rngModInt = 1.5 * rngModInt;
				rngDisp = "  1.5x Scope";
				scopeBoolean=true;
				scopeModel= "M";
				rarityInt = rarityInt+10;
			}
			else if(randomScModInt2<=100){
				rngModInt = 2 * rngModInt;
				rngDisp = "  2.0x Scope";
				scopeBoolean=true;
				scopeModel= "K";
				rarityInt = rarityInt+20;
			}
			else{
				descriptionTxt = descriptionTxt + "Whoops Scope\n";
			}
		}

		//---------------------------------------------------------------------------------------------------------------
		//Critical Hit Modification *NO CRIT CHANCE*
		//---------------------------------------------------------------------------------------------------------------

		/*boolean critTxt = false;
		int randomCritModInt = randomBase.nextInt(100)+1;

		if(randomCritModInt<=(-1+((lvlInt-1)*.5))){
			critTxt = true;
		}*/

		//---------------------------------------------------------------------------------------------------------------
		//Melee Damage Modification *NO MELEE DAM*
		//---------------------------------------------------------------------------------------------------------------

		/*int randomMeleeModInt = randomBase.nextInt(100)+1;
		int randomMeleeModInt2 = randomBase.nextInt(100)+1;

		if(randomMeleeModInt<= (1+((lvlInt-1)*2))){
			if(randomMeleeModInt2<=70){
				descriptionTxt = descriptionTxt+"  Melee Damage: 1d4\n";
				weapName = "Bladed "+weapName;
			}
			else if(randomMeleeModInt2<=90){
				descriptionTxt = descriptionTxt+"  Melee Damage: 1d6\n";
				weapName = "Bladed "+weapName;
			}
			else if(randomMeleeModInt2<=100){
				descriptionTxt = descriptionTxt+"  Melee Damage: 1d8\n";
				weapName = "Bladed "+weapName;
			}
			else{
				descriptionTxt = descriptionTxt + "Whoops Melee\n";
			}
		}*/

		//---------------------------------------------------------------------------------------------------------------
		//Determine names
		//---------------------------------------------------------------------------------------------------------------

		weaponNameAdj adj = new weaponNameAdj();
		adjName = adj.adjCalc(accDisp, damageModInt);

		if(scopeBoolean==true&&bladeBoolean==true)
			equiName = "Equipped ";
		else if(scopeBoolean==true&&bladeBoolean==false)
			equiName = "Scoped ";
		else if(bladeBoolean==true&&scopeBoolean==false)
			equiName = "Bladed ";
		else
			equiName = "";

		//Determine Accuracy Model
		if(accModInt==0)
			accModel="P";
		else if(accModInt==1)
			accModel="F";
		else if(accModInt==2)
			accModel="J";
		else if(accModInt==3)
			accModel="Q";
		else if(accModInt==4)
			accModel="C";
		else if(accModInt==5)
			accModel="H";
		else if(accModInt==6)
			accModel="W";
		else if(accModInt==7)
			accModel="V";
		else if(accModInt==-1)
			accModel="M";
		else if(accModInt==-2)
			accModel="A";
		else if(accModInt==-3)
			accModel="L";
		else if(accModInt==-4)
			accModel="R";
		else if(accModInt==-5)
			accModel="S";
		else if(accModInt==-6)
			accModel="K";
		else if(accModInt==-7)
			accModel="Y";
		else
			accModel="Whoops";

		//Determine Damage Model
		if(damageModInt==0)
			dmgModel="0";
		else if(damageModInt==1)
			dmgModel="1";
		else if(damageModInt==2)
			dmgModel="2";
		else if(damageModInt==3)
			dmgModel="3";
		else if(damageModInt==4)
			dmgModel="4";
		else if(damageModInt==-1)
			dmgModel="5";
		else if(damageModInt==-2)
			dmgModel="6";
		else if(damageModInt==-3)
			dmgModel="7";
		else if(damageModInt==-4)
			dmgModel="8";
		else
			dmgModel="Whoops";

		if(FRModInt<1)
			FRModel="H";
		else if(FRModInt<2)
			FRModel="M";
		else if(FRModInt<3)
			FRModel="Z";
		else if(FRModInt<4)
			FRModel="J";
		else if(FRModInt<5)
			FRModel="N";
		else if(FRModInt<6)
			FRModel="Y";
		else if(FRModInt<7)
			FRModel="K";
		else if(FRModInt<8)
			FRModel="F";
		else
			FRModel="Whoops";

		weapName = manuName+
			accModel+dmgDiceModel+dmgModel+"-"+FRModel+magModInt+" "+ //Model
				adjName+equiName+effName+baseName+
					meleeModel+scopeModel; //Model

		//-----------------------------------------------------------------------------------
		//output
		//-----------------------------------------------------------------------------------

		accuracyBase = df.format(accModInt)+"";
		magazineBase = magModInt+"";
		damageBase = damageBase+df.format(damageModInt)+"";
		rangeBase = rngModInt+"";
		if(FRModInt<1){
			firerateBase="1 Per Full";
		}
		else{
			firerateBase=df1.format(FRModInt)+" Per Std.";
		}

		if(accuracyBaseInt != accModInt)
			descriptionTxt = descriptionTxt +"  Acc: "+df.format(accDisp)+"\n";
		if(damageModInt != 0)
			descriptionTxt = descriptionTxt +"  Dam: "+df.format(damageModInt)+"\n";
		if(magazineBaseInt != magModInt)
			descriptionTxt = descriptionTxt +"  Mag: "+df.format(magDisp)+"\n";
		if(FRBaseDouble != FRModInt)
			descriptionTxt = descriptionTxt +"  Fire Rate: "+df.format(FRDisp)+"\n";
		if(rangeBaseInt!=rngModInt)
			descriptionTxt = descriptionTxt + rngDisp+"\n";
		//if(critTxt == true)
			//descriptionTxt = descriptionTxt + "  300% Critical Hit Damage\n";

		displayText = displayText+"Sub-Machine Gun"+"\n"+weapName+"\nDamage: "+damageBase+"\nAccuracy: "+accuracyBase+"\nMagazine: "
			+magazineBase+"\nFire Rate: "+firerateBase+"\nRange: "+rangeBase+" ft.\nReload: "+reloadBase+"\nWeight: "+wgtBase
			+"\n"+descriptionTxt+"\n";

		displayArray[0] = "Sub-Machine Gun";
		displayArray[1] = weapName;
		displayArray[2] = "Accuracy: "+accuracyBase;
		displayArray[3] = "Damage: "+damageBase;
		displayArray[4] = "Magazine: "+magazineBase;
		displayArray[5] = "Fire Rate: "+firerateBase;
		displayArray[6] = "Range: "+rangeBase+" ft.";
		displayArray[7] = "Reload: "+reloadBase;
		displayArray[8] = "Weight: "+wgtBase;
		displayArray[9] = "";
		displayArray[10] = effect+effectIntensity+effectChance;
		displayArray[11] = descriptionTxt;
		displayArray[12] = ""+rarityInt;

		return displayArray;
	}
}