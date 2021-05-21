import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.text.*;
import java.util.*;
import java.math.*;
import java.util.Random;

public class aRifle extends d20weaponsystem
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

	String[] effectArray = {"","",""};
	String effect="", effectIntensity="", effectChance="";

	static Random randomBaseAR = new Random();

	//-------------------------------------------------------------------
	//Begin aRifleStats Method
	//-------------------------------------------------------------------
	public String[] aRifleStats(int lvlI)
	{
		lvlInt = lvlI; //gets level
		damageModInt = 0; //sets the damage modifier variable to 0

		int randomBaseIntAR = randomBaseAR.nextInt(100)+1;

		if(randomBaseIntAR<=25){
			manuName = "M:I ";
			baseName = "Raptor ";
			weapName = "M:I Assault Rifle";
			dmgDiceModel = "B";

			accuracyBaseInt = -1;
			damageBase = "1d8";
			magazineBaseInt = 18;
			FRBaseDouble = 3;
			rangeBaseInt = 40;
			reloadBase = "3 Std.";
			wgtBase = "15 lbs.";
			rarityInt = 20;
		}
		else if(randomBaseIntAR>25 && randomBaseIntAR<=38){
			manuName = "Arista ";
			baseName = "Warhawk ";
			weapName = "Arista Assault Rifle";
			dmgDiceModel = "H";

			accuracyBaseInt = +1;
			damageBase = "2d4";
			magazineBaseInt = 18;
			FRBaseDouble = 2;
			rangeBaseInt = 50;
			reloadBase = "1 Std.";
			wgtBase = "12 lbs.";
			rarityInt = 30;
		}
		else if(randomBaseIntAR>38 && randomBaseIntAR<=63){
			manuName = "MechTec ";
			baseName = "Avenger ";
			weapName = "MechTec Assault Rifle";
			dmgDiceModel = "M";

			accuracyBaseInt = 0;
			damageBase = "1d6";
			magazineBaseInt = 18;
			FRBaseDouble = 3;
			rangeBaseInt = 40;
			reloadBase = "1 Std.";
			wgtBase = "15 lbs.";
			rarityInt = 20;
		}
		else if(randomBaseIntAR>63 && randomBaseIntAR<=81){
			manuName = "K&L ";
			baseName = "Vector ";
			weapName = "K&L Assault Rifle";
			dmgDiceModel = "M";

			accuracyBaseInt = -1;
			damageBase = "1d6";
			magazineBaseInt = 18;
			FRBaseDouble = 5;
			rangeBaseInt = 40;
			reloadBase = "1 Move";
			wgtBase = "10 lbs.";
			rarityInt = 30;
		}
		else if(randomBaseIntAR>81 && randomBaseIntAR<=92){
			manuName = "Rubicore ";
			baseName = "Genesis ";
			weapName = "Rubicore Assault Rifle";
			dmgDiceModel = "H";

			accuracyBaseInt = +1;
			damageBase = "2d4";
			magazineBaseInt = 18;
			FRBaseDouble = 3;
			rangeBaseInt = 30;
			reloadBase = "1 Std.";
			wgtBase = "12 lbs.";
			rarityInt = 30;
		}
		else if(randomBaseIntAR>92 && randomBaseIntAR<=100){
			manuName = "Rubicore ";
			baseName = "Zodiac ";
			weapName = "Rubicore Special Assault Rifle";
			dmgDiceModel = "H";

			accuracyBaseInt = +3;
			damageBase = "2d4";
			magazineBaseInt = 24;
			FRBaseDouble = 3;
			rangeBaseInt = 40;
			reloadBase = "1 Std.";
			wgtBase = "12 lbs.";
			rarityInt = 35;
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
			rarityInt =rarityInt+40;
		}

		//-----------------------------------------------------------------------------------------------------------
		//Acc. Modification.
		//-----------------------------------------------------------------------------------------------------------

		int randomAccModInt = randomBase.nextInt(100)+1;
		int randomAccModInt2 = randomBase.nextInt(100)+1;
		int randomAccModInt3 = randomBase.nextInt(100)+1;

		if(randomAccModInt<= (10+((lvlInt-1)*3))){

			if(randomBase.nextInt(100)+1<= (50+((lvlInt-1)*3)) ){

				if(randomAccModInt2<=lvlModInt1){
					accModInt = accModInt + 1;
					accDisp = accDisp+1;
					rarityInt =rarityInt+10;

					if(randomBase.nextInt(100)+1<= 20){
						damageModInt = damageModInt - 1;
						rarityInt =rarityInt-10;
					}
				}
				else if(randomAccModInt2<=lvlModInt2){
					accModInt = accModInt + 2;
					accDisp = accDisp+2;
					rarityInt =rarityInt+20;

					if(randomBase.nextInt(100)+1<= 15){
						damageModInt = damageModInt - 1;
						rarityInt =rarityInt-10;
					}
				}
				else if(randomAccModInt2<=lvlModInt3){
					accModInt = accModInt + 3;
					accDisp = accDisp+3;
					rarityInt =rarityInt+30;

					if(randomBase.nextInt(100)+1<= 10){
						damageModInt = damageModInt - 1;
						rarityInt =rarityInt-10;
					}
				}
				else if(randomAccModInt2<=lvlModInt4){
					accModInt = accModInt + 4;
					accDisp = accDisp+4;
					rarityInt =rarityInt+40;

					if(randomBase.nextInt(100)+1<= 5){
						damageModInt = damageModInt - 1;
						rarityInt =rarityInt-10;
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
					rarityInt =rarityInt-10;
				}
				else if(randomAccModInt3<=92){
					accModInt = accModInt - 2;
					accDisp = accDisp-2;
					rarityInt =rarityInt-20;
				}
				else if(randomAccModInt3<=98){
					accModInt = accModInt - 3;
					accDisp = accDisp-3;
					rarityInt =rarityInt-30;
				}
				else if(randomAccModInt3<=100){
					accModInt = accModInt - 4;
					accDisp = accDisp-4;
					rarityInt =rarityInt-40;
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

		if(randomDamModInt<= (10+((lvlInt-1)*3))){

			if(randomBase.nextInt(100)+1<= (50+((lvlInt-1)*3)) ){

				if(randomDamModInt2<=lvlModInt1){
					damageModInt = damageModInt + 1;
					rarityInt =rarityInt+10;

					if(randomBase.nextInt(100)+1<= 20){
						accModInt = accModInt - 1;
						accDisp = accDisp-1;
						rarityInt =rarityInt-10;
					}
				}
				else if(randomDamModInt2<=lvlModInt2){
					damageModInt = damageModInt + 2;
					rarityInt =rarityInt+20;

					if(randomBase.nextInt(100)+1<= 15){
						accModInt = accModInt - 1;
						accDisp = accDisp-1;
						rarityInt =rarityInt-10;
					}
				}
				else if(randomDamModInt2<=lvlModInt3){
					damageModInt = damageModInt + 3;
					rarityInt =rarityInt+30;

					if(randomBase.nextInt(100)+1<= 10){
						accModInt = accModInt - 1;
						accDisp = accDisp-1;
						rarityInt =rarityInt-10;
					}
				}
				else if(randomDamModInt2<=lvlModInt4){
					damageModInt = damageModInt + 4;
					rarityInt =rarityInt+40;

					if(randomBase.nextInt(100)+1<= 5){
						accModInt = accModInt - 1;
						accDisp = accDisp-1;
						rarityInt =rarityInt-10;
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
					rarityInt =rarityInt-10;
				}
				else if(randomDamModInt3<=92){
					damageModInt = damageModInt - 2;
					rarityInt =rarityInt-20;
				}
				else if(randomDamModInt3<=98){
					damageModInt = damageModInt - 3;
					rarityInt =rarityInt-30;
				}
				else if(randomDamModInt3<=100){
					damageModInt = damageModInt - 4;
					rarityInt =rarityInt-40;
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

		if(randomMagModInt<= (10+((lvlInt-1)*2))){

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
					magModInt = magModInt - 4;
					magDisp = magDisp-4;
					rarityInt = rarityInt-5;
				}
				else if(randomMagModInt3<=100){
					magModInt = magModInt - 6;
					magDisp = magDisp-6;
					rarityInt = rarityInt-10;
				}
				else{
					descriptionTxt = descriptionTxt + "Whoops Mag -\n";
				}
			}
		}

		//---------------------------------------------------------------------------------------------------------------
		//Fire Rate Modification *Burst Fire*
		//---------------------------------------------------------------------------------------------------------------

		int randomFRModInt = randomBase.nextInt(100)+1;
		int randomFRModInt2 = randomBase.nextInt(100)+1;

		/*if(randomFRModInt<= (7+((lvlInt-1)*4))){
			if(randomFRModInt2<=80-((lvlInt-1)*2)){
				FRModInt = FRModInt + 1;
				FRDisp = FRDisp+1;
			}
			else{
				FRModInt = FRModInt + 2;
				FRDisp = FRDisp+2;
			}
		}*/

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
				scopeModel= "J";
				rarityInt = rarityInt+10;
			}
			else if(randomScModInt2<=85){
				rngModInt = 2 * rngModInt;
				rngDisp = "  2.0x Scope";
				scopeBoolean=true;
				scopeModel= "V";
				rarityInt = rarityInt+20;
			}
			else if(randomScModInt2<=95){
				rngModInt = 2.5 * rngModInt;
				rngDisp = "  2.5x Scope";
				scopeBoolean=true;
				scopeModel= "I";
				rarityInt = rarityInt+30;
			}
			else if(randomScModInt2<=100){
				rngModInt = 3 * rngModInt;
				rngDisp = "  3.0x Scope";
				scopeBoolean=true;
				scopeModel= "R";
				rarityInt = rarityInt+40;
			}
			else{
				descriptionTxt = descriptionTxt + "Whoops Scope\n";
			}
		}

		//---------------------------------------------------------------------------------------------------------------
		//Critical Hit Modification
		//---------------------------------------------------------------------------------------------------------------

		/*boolean critTxt = false;
		int randomCritModInt = randomBase.nextInt(100)+1;

		if(randomCritModInt<=(-1+((lvlInt-1)*.5))){
			critTxt = true;
		}*/

		//---------------------------------------------------------------------------------------------------------------
		//Melee Damage Modification
		//---------------------------------------------------------------------------------------------------------------

		int randomMeleeModInt = randomBase.nextInt(100)+1;
		int randomMeleeModInt2 = randomBase.nextInt(100)+1;

		if(randomMeleeModInt<= (1+((lvlInt-1)*1))){
			if(randomMeleeModInt2<=70){
				descriptionTxt = descriptionTxt+"  Melee Damage: 1d4\n";
				bladeBoolean = true;
				meleeModel= "Y";
				rarityInt = rarityInt+15;
			}
			else if(randomMeleeModInt2<=100){
				descriptionTxt = descriptionTxt+"  Melee Damage: 1d6\n";
				bladeBoolean = true;
				meleeModel= "U";
				rarityInt = rarityInt+25;
			}
			else{
				descriptionTxt = descriptionTxt + "Whoops Melee\n";
			}
		}

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
			accModel="J";
		else if(accModInt==1)
			accModel="R";
		else if(accModInt==2)
			accModel="B";
		else if(accModInt==3)
			accModel="I";
		else if(accModInt==4)
			accModel="O";
		else if(accModInt==5)
			accModel="Z";
		else if(accModInt==6)
			accModel="P";
		else if(accModInt==7)
			accModel="N";
		else if(accModInt==-1)
			accModel="D";
		else if(accModInt==-2)
			accModel="U";
		else if(accModInt==-3)
			accModel="F";
		else if(accModInt==-4)
			accModel="G";
		else if(accModInt==-5)
			accModel="J";
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
//		if(critTxt == true)
//			descriptionTxt = descriptionTxt + "  300% Critical Hit Damage\n";

		displayText = displayText+"Assault Rifle"+"\n"+weapName+"\nDamage: "+damageBase+"\nAccuracy: "+accuracyBase+"\nMagazine: "
			+magazineBase+"\nFire Rate: "+firerateBase+"\nRange: "+rangeBase+" ft.\nReload: "+reloadBase+"\nWeight: "+wgtBase
			+"\n"+descriptionTxt+"\n";

		displayArray[0] = "Assault Rifle";
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