import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.text.*;
import java.util.*;
import java.math.*;
import java.util.Random;

public class repeater extends d20weaponsystem
{
	//-----------------------------------------------------------------------------------------------------------------------
	//initialize variables
	//-----------------------------------------------------------------------------------------------------------------------
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
	private int rarityInt=0;

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

	static Random randomBaseR = new Random();
	String[] effectArray = {"","",""};
	String effect="", effectIntensity="", effectChance="";

	//----------------------------------------------------------------------------------------------------------------------
	//Begin repeaterStats Method
	//----------------------------------------------------------------------------------------------------------------------
	public String[] repeaterStats(int lvlI)
	{
		lvlInt = lvlI;
		damageModInt = 0;
		int randomBaseIntR = randomBaseR.nextInt(100)+1;

		if(randomBaseIntR<=18){
			manuName = "M:I ";
			baseName = "Hornet ";
			weapName = "M:I Repeater";
			dmgDiceModel = "L";

			accuracyBaseInt=-1;
			damageBase = "1d6";
			magazineBaseInt=10;
			FRBaseDouble=2;
			rangeBaseInt = 30;
			reloadBase = "1 Std.";
			wgtBase = "4 lbs.";
			rarityInt = 20;
		}
		else if(randomBaseIntR>18 && randomBaseIntR<=29){
			manuName = "Bohr ";
			baseName = "Stinger ";
			weapName = "Bohr Repeater";
			dmgDiceModel = "S";

			accuracyBaseInt=-1;
			damageBase = "1d8";
			magazineBaseInt = 10;
			FRBaseDouble = 1;
			rangeBaseInt = 30;
			reloadBase = "1 Std.";
			wgtBase = "3 lbs.";
			rarityInt = 30;
		}
		else if(randomBaseIntR>29 && randomBaseIntR<=37){
			manuName = "Spectre ";
			baseName = "Wraith ";
			weapName = "Spectre Repeater";
			dmgDiceModel = "G";

			accuracyBaseInt = -1;
			damageBase = "1d4";
			magazineBaseInt = 16;
			FRBaseDouble = 3;
			rangeBaseInt = 20;
			reloadBase = "1 Std.";
			wgtBase = "3 lbs.";
			rarityInt = 30;
		}
		else if(randomBaseIntR>37 && randomBaseIntR<=48){
			manuName = "Radkov ";
			baseName = "Partisan ";
			weapName = "Radkov Repeater";
			dmgDiceModel = "L";

			accuracyBaseInt = +0;
			damageBase = "1d6";
			magazineBaseInt = 16;
			FRBaseDouble = 2;
			rangeBaseInt = 30;
			reloadBase = "1 Rnd.";
			wgtBase = "3 lbs.";
			rarityInt = 30;
		}
		else if(randomBaseIntR>48 && randomBaseIntR<=59){
			manuName = "Granzik ";
			baseName = "Impact ";
			weapName = "Granzik Repeater";
			dmgDiceModel = "S";

			accuracyBaseInt = -1;
			damageBase = "1d8";
			magazineBaseInt = 6;
			FRBaseDouble = 2;
			rangeBaseInt = 30;
			reloadBase = "1 Move";
			wgtBase = "3 lbs.";
			rarityInt = 30;
		}
		else if(randomBaseIntR>59 && randomBaseIntR<=77){
			manuName = "MechTec ";
			baseName = "Blaster ";
			weapName = "MechTec Repeater";
			dmgDiceModel = "G";

			accuracyBaseInt = +0;
			damageBase = "1d4";
			magazineBaseInt = 10;
			FRBaseDouble = 2;
			rangeBaseInt = 30;
			reloadBase = "1 Std.";
			wgtBase = "4 lbs.";
			rarityInt = 20;
		}
		else if(randomBaseIntR>77 && randomBaseIntR<=84){
			manuName = "K&L ";
			baseName = "Machine Pistol ";
			weapName = "K&L Repeater";
			dmgDiceModel = "G";

			accuracyBaseInt = -1;
			damageBase = "1d4";
			magazineBaseInt = 10;
			FRBaseDouble = 3;
			rangeBaseInt = 30;
			reloadBase = "1 Move";
			wgtBase = "2 lbs.";
			rarityInt = 30;
		}
		else if(randomBaseIntR>84 && randomBaseIntR<=89){
			manuName = "K&L ";
			baseName = "Dynamo ";
			weapName = "K&L Special Repeater";
			dmgDiceModel = "L";

			accuracyBaseInt = +0;
			damageBase = "1d6";
			magazineBaseInt = 10;
			FRBaseDouble = 4;
			rangeBaseInt = 30;
			reloadBase = "1 Move";
			wgtBase = "2 lbs.";
			rarityInt = 35;
		}
		else if(randomBaseIntR>89 && randomBaseIntR<=100){
			manuName = "Rockholm ";
			baseName = "Outlaw ";
			weapName = "Rockholm Repeater";
			dmgDiceModel = "L";

			accuracyBaseInt = +1;
			damageBase = "1d6";
			magazineBaseInt = 10;
			FRBaseDouble = 1;
			rangeBaseInt = 40;
			reloadBase = "1 Std.";
			wgtBase = "4 lbs.";
			rarityInt = 30;
		}
		else{
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

		if(randomAccModInt<= (10+((lvlInt-1)*4))){

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

		if(randomDamModInt<= (10+((lvlInt-1)*4))){

			if(randomBase.nextInt(100)+1<= (50+((lvlInt-1)*3)) ){

				if(randomDamModInt2<=lvlModInt1){
					damageModInt = damageModInt + 1;
					rarityInt = rarityInt+10;

					if(randomBase.nextInt(100)+1<= 20){
						accModInt = accModInt - 1;
						accDisp = accDisp-1;
						rarityInt = rarityInt-10;
					}
				}
				else if(randomDamModInt2<=lvlModInt2){
					damageModInt = damageModInt + 2;
					rarityInt = rarityInt+20;

					if(randomBase.nextInt(100)+1<= 15){
						accModInt = accModInt - 1;
						accDisp = accDisp-1;
						rarityInt = rarityInt-10;
					}
				}
				else if(randomDamModInt2<=lvlModInt3){
					damageModInt = damageModInt + 3;
					rarityInt = rarityInt+30;

					if(randomBase.nextInt(100)+1<= 10){
						accModInt = accModInt - 1;
						accDisp = accDisp-1;
						rarityInt = rarityInt-10;
					}
				}
				else if(randomDamModInt2<=lvlModInt4){
					damageModInt = damageModInt + 4;
					rarityInt = rarityInt+40;

					if(randomBase.nextInt(100)+1<= 5){
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
					damageModInt = damageModInt - 4;
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
					magModInt = magModInt + 2;
					magDisp = magDisp+2;
					rarityInt = rarityInt+5;
				}
				else if(randomMagModInt2<=lvlModInt2){
					magModInt = magModInt + 4;
					magDisp = magDisp+4;
					rarityInt = rarityInt+10;
				}
				else if(randomMagModInt2<=lvlModInt3){
					magModInt = magModInt + 6;
					magDisp = magDisp+6;
					rarityInt = rarityInt+15;
				}
				else if(randomMagModInt2<=lvlModInt4){
					magModInt = magModInt + 8;
					magDisp = magDisp+8;
					rarityInt = rarityInt+20;
				}
				else{
					descriptionTxt = descriptionTxt + "Whoops Mag +\n";
				}
			}
			else
			{
				if(randomMagModInt3<=80){
					magModInt = magModInt - 1;
					magDisp = magDisp-1;
					rarityInt = rarityInt-5;
				}
				else if(randomMagModInt3<=100){
					magModInt = magModInt - 2;
					magDisp = magDisp-2;
					rarityInt = rarityInt-10;
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

		if(randomFRModInt<= (7+((lvlInt-1)*4))){
			if(randomFRModInt2<=80-((lvlInt-1)*2)){
				FRModInt = FRModInt + 1;
				FRDisp = FRDisp+1;
				rarityInt = rarityInt+15;
			}
			else{
				FRModInt = FRModInt + 2;
				FRDisp = FRDisp+2;
				rarityInt = rarityInt+25;
			}
		}

		//---------------------------------------------------------------------------------------------------------------
		//Scope Modification
		//---------------------------------------------------------------------------------------------------------------

		int randomScModInt = randomBase.nextInt(100)+1;
		int randomScModInt2 = randomBase.nextInt(100)+1;

		if(randomScModInt<= (1+((lvlInt-1)*1))){
			if(randomScModInt2<=60){
				rngModInt = 1.5 * rngModInt;
				rngDisp = "  1.5x Scope";
				scopeBoolean=true;
				scopeModel= "N";
				rarityInt = rarityInt+10;
			}
			else if(randomScModInt2<=85){
				rngModInt = 2 * rngModInt;
				rngDisp = "  2.0x Scope";
				scopeBoolean=true;
				scopeModel= "S";
				rarityInt = rarityInt+20;
			}
			else if(randomScModInt2<=95){
				rngModInt = 2.5 * rngModInt;
				rngDisp = "  2.5x Scope";
				scopeBoolean=true;
				scopeModel= "H";
				rarityInt = rarityInt+30;
			}
			else if(randomScModInt2<=100){
				rngModInt = 3 * rngModInt;
				rngDisp = "  3.0x Scope";
				scopeBoolean=true;
				scopeModel= "K";
				rarityInt = rarityInt+40;
			}
			else{
				descriptionTxt = descriptionTxt + "Whoops Scope\n";
			}
		}

		//---------------------------------------------------------------------------------------------------------------
		//Critical Hit Modification
		//---------------------------------------------------------------------------------------------------------------

		boolean critTxt = false;
		int randomCritModInt = randomBase.nextInt(100)+1;

		if(randomCritModInt<=(-1+((lvlInt-1)*.5))){
			critTxt = true;
			rarityInt = rarityInt+40;
		}

		//---------------------------------------------------------------------------------------------------------------
		//Melee Damage Modification
		//---------------------------------------------------------------------------------------------------------------

		int randomMeleeModInt = randomBase.nextInt(100)+1;
		int randomMeleeModInt2 = randomBase.nextInt(100)+1;

		if(randomMeleeModInt<= (1+((lvlInt-1)*2))){
			if(randomMeleeModInt2<=70){
				descriptionTxt = descriptionTxt+"  Melee Damage: 1d4\n";
				bladeBoolean = true;
				meleeModel= "R";
				rarityInt = rarityInt+15;
			}
			else if(randomMeleeModInt2<=90){
				descriptionTxt = descriptionTxt+"  Melee Damage: 1d6\n";
				bladeBoolean = true;
				meleeModel= "B";
				rarityInt = rarityInt+25;
			}
			else if(randomMeleeModInt2<=100){
				descriptionTxt = descriptionTxt+"  Melee Damage: 1d8\n";
				bladeBoolean = true;
				meleeModel= "L";
				rarityInt = rarityInt+35;
			}
			else{
				descriptionTxt = descriptionTxt + "Whoops Melee\n";
			}
		}

		//---------------------------------------------------------------------------------------------------------------
		//Red Text
		//---------------------------------------------------------------------------------------------------------------


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
			accModel="K";
		else if(accModInt==1)
			accModel="V";
		else if(accModInt==2)
			accModel="P";
		else if(accModInt==3)
			accModel="O";
		else if(accModInt==4)
			accModel="E";
		else if(accModInt==5)
			accModel="X";
		else if(accModInt==6)
			accModel="";
		else if(accModInt==7)
			accModel="";
		else if(accModInt==-1)
			accModel="A";
		else if(accModInt==-2)
			accModel="J";
		else if(accModInt==-3)
			accModel="N";
		else if(accModInt==-4)
			accModel="R";
		else if(accModInt==-5)
			accModel="B";
		else if(accModInt==-6)
			accModel="G";
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

		//---------------------------------------------------------------------------------------------------------------
		//output
		//---------------------------------------------------------------------------------------------------------------

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
		if(critTxt == true)
			descriptionTxt = descriptionTxt + "  300% Critical Hit Damage\n";

		displayArray[0] = "Repeater";
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