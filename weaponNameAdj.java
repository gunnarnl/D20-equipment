import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.text.*;
import java.util.*;
import java.math.*;
import java.util.Random;

public class weaponNameAdj extends d20weaponsystem
{
	static Random adjRandom = new Random();
	private String adj = "";

	public String adjCalc(int acc, int dmg)
	{

		int adjRanInt = adjRandom.nextInt(100)+1;
		if(acc==2&&acc>dmg){
			if(adjRanInt<=50){
				adj="";
			}
			else if(adjRanInt<=67){
				adj="Reliable ";
			}
			else if(adjRanInt<=84){
				adj="Steady ";
			}
			else if(adjRanInt<=100){
				adj="Stabilized ";
			}
		}
		else if(acc==3&&acc>dmg){
			if(adjRanInt<=25){
				adj="";
			}
			else if(adjRanInt<=50){
				adj="Surefire ";
			}
			else if(adjRanInt<=75){
				adj="Precise ";
			}
			else if(adjRanInt<=100){
				adj="Deft ";
			}
		}
		else if(acc==4&&acc>dmg){
			if(adjRanInt<=33){
				adj="Visceral ";
			}
			else if(adjRanInt<=66){
				adj="Keen ";
			}
			else if(adjRanInt<=100){
				adj="Infalliable ";
			}
		}
		else if(dmg==2&&dmg>acc){
			if(adjRanInt<=50){
				adj="";
			}
			else if(adjRanInt<=67){
				adj="Hostile ";
			}
			else if(adjRanInt<=84){
				adj="Aggressive ";
			}
			else if(adjRanInt<=100){
				adj="Cruel ";
			}
		}
		else if(dmg==3&&dmg>acc){
			if(adjRanInt<=50){
				adj="";
			}
			else if(adjRanInt<=67){
				adj="Brutal ";
			}
			else if(adjRanInt<=84){
				adj="Barbaric ";
			}
			else if(adjRanInt<=100){
				adj="Vicious ";
			}
		}
		else if(dmg==4&&dmg>acc){
			if(adjRanInt<=33){
				adj="Devastating ";
			}
			else if(adjRanInt<=66){
				adj="Savage ";
			}
			else if(adjRanInt<=100){
				adj="Merciless ";
			}
		}
		else if(acc==2&&dmg==2){
			adj = "Virtuous ";}
		else if(acc==3&&dmg==3){
			adj = "Infamous ";}
		else if(acc==4&&dmg==4){
			adj = "Legendary ";}
		else if(acc==-1&&dmg>=0){
			adj = "Unstable ";
		}
		else if(acc==-2&&dmg>=0){
			if(adjRanInt<=66)
				adj = "Unstable ";
			else if(adjRanInt<=100)
				adj = "Erratic ";
		}
		else if(acc==-3&&dmg>=0){
			if(adjRanInt<=34)
				adj = "Unstable ";
			else if(adjRanInt<=100)
				adj = "Erratic ";
		}
		else if(acc<=-4&&dmg>=0){
			adj = "Erratic ";
		}
		else if(dmg==-1&&acc>=0){
			adj = "Faulty ";
		}
		else if(dmg==-2&&acc>=0){
			if(adjRanInt<=66)
				adj = "Faulty ";
			else if(adjRanInt<=100)
				adj = "Weak ";
		}
		else if(dmg==-3&&acc>=0){
			if(adjRanInt<=66)
				adj = "Weak ";
			else if(adjRanInt<=100)
				adj = "Faulty ";
		}
		else if(dmg<=-4&&acc>=0){
			adj = "Weak ";
		}
		else if(dmg==-1&&acc==-1){
			adj = "Bad ";
		}
		else if(dmg==-2&&acc==-2){
			adj = "Awful ";
		}
		else if(dmg==-3&&acc==-3){
			adj = "Terrible ";
		}
		else if(dmg<=-4&&acc<=-4){
			adj = "Horrendous ";
		}

		return adj;
	}
}