import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.text.*;
import java.util.*;
import java.math.*;
import java.util.Random;

public class effects extends d20weaponsystem
{
	static Random effectRandom = new Random();

	public String[] effectCalc(int lvlInt)
	{
		//----------------------------------------------------------------------------------------------------------
		//Initialize Variables
		//----------------------------------------------------------------------------------------------------------
		double lvlEffect1;
		double lvlEffect2;
		double lvlEffect3;
		double lvlEffect4;

		double[] lvlEffChance5 = {70,85,95,98,100};
		double[] lvlEffChance10 = {45,70,85,94,100};
		double[] lvlEffChance15 = {25,50,75,90,100};
		double[] lvlEffChance20 = {20,40,60,80,100};
		double[] lvlEffChanceTot = {0, 0, 0, 0, 0};

		lvlEffect1 = 80+(lvlInt-1)*.1;
		lvlEffect2 = (20+(lvlInt-1)*.4)+(lvlEffect1);
		if(lvlInt>=3){
			lvlEffect3 = (-10+(lvlInt-1)*5.5)+(lvlEffect2);
		}
		else{
			lvlEffect3 = lvlEffect2;
		}

		if(lvlInt>=7){
			lvlEffect4 = (-50+(lvlInt-1)*7.5)+(lvlEffect3);
		}
		else{
			lvlEffect4 = lvlEffect3;
		}


		String effectChance="";
		String effect="";
		String effectIntensity="";
		String effectNameMod="";

		if(lvlInt<=5)
			lvlEffChanceTot = lvlEffChance5;
		else if(lvlInt<=10)
			lvlEffChanceTot = lvlEffChance10;
		else if(lvlInt<=15)
			lvlEffChanceTot = lvlEffChance15;
		else if(lvlInt<=20)
			lvlEffChanceTot = lvlEffChance20;


		//----------------------------------------------------------------------------------------------------------
		//Determine Effect and Intensity
		//----------------------------------------------------------------------------------------------------------
		int effRndInt = effectRandom.nextInt(100)+1;
		int effIntensityInt = effectRandom.nextInt((int)lvlEffect4)+1;

		//Fire
		if(effRndInt<=13){
			effect = "Effect: Fire";
			if(effIntensityInt<=lvlEffect1){
				effectIntensity="Effect Intensity: 1";
				effectNameMod="Smoldering ";
			}
			else if(effIntensityInt<=lvlEffect2){
				effectIntensity="Effect Intensity: 2";
				effectNameMod="Burning ";
			}
			else if(effIntensityInt<=lvlEffect3){
				effectIntensity="Effect Intensity: 3";
				effectNameMod="Magma ";
			}
			else if(effIntensityInt<=lvlEffect4){
				effectIntensity="Effect Intensity: 4";
				effectNameMod="Inferno ";
			}
			else{
				effectIntensity="Whoops Intensity";
			}
		}

		//Shock
		else if(effRndInt<=26){
			effect = "Effect: Shock";
			if(effIntensityInt<=lvlEffect1){
				effectIntensity="Effect Intensity: 1";
				effectNameMod="Static ";
			}
			else if(effIntensityInt<=lvlEffect2){
				effectIntensity="Effect Intensity: 2";
				effectNameMod="Shocking ";
			}
			else if(effIntensityInt<=lvlEffect3){
				effectIntensity="Effect Intensity: 3";
				effectNameMod="Electric ";
			}
			else if(effIntensityInt<=lvlEffect4){
				effectIntensity="Effect Intensity: 4";
				effectNameMod="Lightning ";
			}
			else{
				effectIntensity="Whoops Intensity";
			}
		}

		//Acid
		else if(effRndInt<=39){
			effect = "Effect: Acid";
			if(effIntensityInt<=lvlEffect1){
				effectIntensity="Effect Intensity: 1";
				effectNameMod="Acidic ";
			}
			else if(effIntensityInt<=lvlEffect2){
				effectIntensity="Effect Intensity: 2";
				effectNameMod="Chemical ";
			}
			else if(effIntensityInt<=lvlEffect3){
				effectIntensity="Effect Intensity: 3";
				effectNameMod="Dissolving ";
			}
			else if(effIntensityInt<=lvlEffect4){
				effectIntensity="Effect Intensity: 4";
				effectNameMod="Caustic ";
			}
			else{
				effectIntensity="Whoops Intensity";
			}
		}

		//Explosive
		else if(effRndInt<=52){
			effect = "Effect: Explosive";
			if(effIntensityInt<=lvlEffect1){
				effectIntensity="Effect Intensity: 1";
				effectNameMod="Explosive ";
			}
			else if(effIntensityInt<=lvlEffect2){
				effectIntensity="Effect Intensity: 2";
				effectNameMod="Booming ";
			}
			else if(effIntensityInt<=lvlEffect3){
				effectIntensity="Effect Intensity: 3";
				effectNameMod="Detonating ";
			}
			else if(effIntensityInt<=lvlEffect4){
				effectIntensity="Effect Intensity: 4";
				effectNameMod="Exothermic ";
			}
			else{
				effectIntensity="Whoops Intensity";
			}
		}

		//Ice
		else if(effRndInt<=69){
			effect = "Effect: Ice";
			if(effIntensityInt<=lvlEffect1){
				effectIntensity="Effect Intensity: 1";
				effectNameMod="Cold ";
			}
			else if(effIntensityInt<=lvlEffect2){
				effectIntensity="Effect Intensity: 2";
				effectNameMod="Ice ";
			}
			else if(effIntensityInt<=lvlEffect3){
				effectIntensity="Effect Intensity: 3";
				effectNameMod="Frosty ";
			}
			else if(effIntensityInt<=lvlEffect4){
				effectIntensity="Effect Intensity: 4";
				effectNameMod="Freezing ";
			}
			else{
				effectIntensity="Whoops Intensity";
			}
		}

		//Disease
		else if(effRndInt<=78){
			effect = "Effect: Disease";
			if(effIntensityInt<=lvlEffect1){
				effectIntensity="Effect Intensity: 1";
				effectNameMod="Debilitating ";
			}
			else if(effIntensityInt<=lvlEffect2){
				effectIntensity="Effect Intensity: 2";
				effectNameMod="Sickening ";
			}
			else if(effIntensityInt<=lvlEffect3){
				effectIntensity="Effect Intensity: 3";
				effectNameMod="Afflicting ";
			}
			else if(effIntensityInt<=lvlEffect4){
				effectIntensity="Effect Intensity: 4";
				effectNameMod="Plague ";
			}
			else{
				effectIntensity="Whoops Intensity";
			}
		}

		//Anti-Matter
		else if(effRndInt<=83){
			effect = "Effect: Anti-Matter";
			if(effIntensityInt<=lvlEffect1){
				effectIntensity="Effect Intensity: 1";
				effectNameMod="Dark ";
			}
			else if(effIntensityInt<=lvlEffect2){
				effectIntensity="Effect Intensity: 2";
				effectNameMod="Rift ";
			}
			else if(effIntensityInt<=lvlEffect3){
				effectIntensity="Effect Intensity: 3";
				effectNameMod="Void ";
			}
			else if(effIntensityInt<=lvlEffect4){
				effectIntensity="Effect Intensity: 4";
				effectNameMod="Null ";
			}
			else{
				effectIntensity="Whoops Intensity";
			}
		}

		//Ultraviolet
		else if(effRndInt<=100){
			effect = "Effect: Ultraviolet";
			if(effIntensityInt<=lvlEffect1){
				effectIntensity="Effect Intensity: 1";
				effectNameMod="Impairing ";
			}
			else if(effIntensityInt<=lvlEffect2){
				effectIntensity="Effect Intensity: 2";
				effectNameMod="Dazing ";
			}
			else if(effIntensityInt<=lvlEffect3){
				effectIntensity="Effect Intensity: 3";
				effectNameMod="Stuning ";
			}
			else if(effIntensityInt<=lvlEffect4){
				effectIntensity="Effect Intensity: 4";
				effectNameMod="Blinding ";
			}
			else{
				effectIntensity="Whoops Intensity";
			}
		}
		else{
			effect = "Whoops eff.";
		}

		//----------------------------------------------------------------------------------------------------------
		//Effect Chance
		//----------------------------------------------------------------------------------------------------------
		int effChanceRndInt = effectRandom.nextInt(100)+1;
		if(effChanceRndInt<=lvlEffChanceTot[0]){
			effectChance="Very Low Effect Chance";
		}
		else if(effChanceRndInt<=lvlEffChanceTot[1]){
			effectChance="Low Effect Chance";
		}
		else if(effChanceRndInt<=lvlEffChanceTot[2]){
			effectChance="Moderate Effect Chance";
		}
		else if(effChanceRndInt<=lvlEffChanceTot[3]){
			effectChance="High Effect Chance";
		}
		else if(effChanceRndInt<=lvlEffChanceTot[4]){
			effectChance="Very High Effect Chance";
		}

		//----------------------------------------------------------------------------------------------------------
		//Return Variable
		//----------------------------------------------------------------------------------------------------------
		String[] effectArray = {effect, effectIntensity, effectChance, effectNameMod};

		return effectArray;
	}
}
