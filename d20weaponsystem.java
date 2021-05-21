import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.text.*;
import java.util.*;
import java.math.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.text.*;

public class d20weaponsystem extends JFrame implements ActionListener
{
	//------------------------------------------------------------------------------------------------------------------
	//Initialize Variables
	//------------------------------------------------------------------------------------------------------------------

	JButton runButton = new JButton("Make Weapon");
	JButton clearButton = new JButton("Clear Data");
	JTextField runTimesField = new JTextField(3);
	JComboBox charLvlChoice = new JComboBox();
	JTextPane display = new JTextPane();
	JPanel inputsPanel = new JPanel();
	JPanel displayPanel = new JPanel();
	JPanel timesPanel = new JPanel();
	JPanel levelPanel = new JPanel();

	JLabel timesLabel = new JLabel("Amount: ");
	JLabel levelLabel = new JLabel("Character Level: ");

	public DecimalFormat df = new DecimalFormat("+#;-#");
	public DecimalFormat df1 = new DecimalFormat("#");
	//System.out.println(df.format(i));

	public static Random randomBase = new Random();

	//Base stats variables
	public String weapType = "";
	public String accuracyBase = "";
		public int accuracyBaseInt;
	public String damageBase = "";
	public String magazineBase = "";
		public int magazineBaseInt;
	public String firerateBase = "";
		public double FRBaseDouble;
	public String rangeBase = "";
		public int rangeBaseInt;
	public String reloadBase = "";
	public String wgtBase = "";
	public String weapName = "";

	public String descriptionTxt = "";

	boolean clearBoolean = true;
	String displayArray[]={"","","","","","","","","","","","",""};
	public String displayText = "";
	public int lvlInt1;
	private int rarityInt;
	public Color rarityColor = new Color (140, 255, 140);

	//---------------------------------------------------------------------------------------------------------
	//d20weapsystem Method
	//---------------------------------------------------------------------------------------------------------
	public d20weaponsystem()
	{
	}

	//---------------------------------------------------------------------------------------------------------
	//create the content pane
	//---------------------------------------------------------------------------------------------------------
	public Container createContentPane()
	{
		//add items to lvl choice
		for(int g=1; g<21; g++)
		{
			charLvlChoice.addItem(String.valueOf(g));
		}

		//add stuff to panels
		inputsPanel.setLayout(new GridLayout(2,2,3,3));
		displayPanel.setLayout(new GridLayout(1,1,8,8));
		inputsPanel.add(runButton);
		inputsPanel.add(clearButton);
			timesPanel.add(timesLabel);
			timesPanel.add(runTimesField);
		inputsPanel.add(timesPanel);
			levelPanel.add(levelLabel);
			levelPanel.add(charLvlChoice);
		inputsPanel.add(levelPanel);
			runTimesField.setText("1");
		display.setEditable(false);

		runButton.addActionListener(this);
		clearButton.addActionListener(this);

		display.setBackground(Color.black);
		display.setForeground(Color.white);

		setTabsAndStyles(display);
		display = addTextToTextPane();
			JScrollPane scrollPane = new JScrollPane(display);
				scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				scrollPane.setPreferredSize(new Dimension(500, 200));
		displayPanel.add(scrollPane);

		//create Container and set attributes
		Container c = getContentPane();
			c.setLayout(new BorderLayout());
			c.add(inputsPanel, BorderLayout.NORTH);
			c.add(displayPanel, BorderLayout.CENTER);

		return c;
	}

	//-------------------------------------------------------------------------------------------------
	//set the style
	//-------------------------------------------------------------------------------------------------
	protected void setTabsAndStyles(JTextPane display)
	{
		//create Tab Stops
		TabStop[] tabs = new TabStop[2];
			tabs[0] = new TabStop(10, TabStop.ALIGN_LEFT, TabStop.LEAD_NONE);
			tabs[1] = new TabStop(350, TabStop.ALIGN_LEFT, TabStop.LEAD_NONE);
		TabSet tabset = new TabSet(tabs);

		//set Tab style
		StyleContext tabStyle = StyleContext.getDefaultStyleContext();
		AttributeSet aset =
			tabStyle.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.TabSet, tabset);
		display.setParagraphAttributes(aset, false);

		//set Font Style
		Style fontStyle =
			StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);

		Style regular = display.addStyle("regular", fontStyle);
		StyleConstants.setFontFamily(fontStyle, "SansSerif");

		Style s = display.addStyle("italic", regular);
		StyleConstants.setItalic(s, true);

		s = display.addStyle("bold", regular);
		StyleConstants.setBold(s, true);

		s = display.addStyle("stats", regular);
			StyleConstants.setForeground(s, Color.yellow);

		s = display.addStyle("name", regular);
			StyleConstants.setBold(s, true);
			StyleConstants.setForeground(s, rarityColor);
			StyleConstants.setFontSize(s, 13);

		s = display.addStyle("element", regular);
			StyleConstants.setForeground(s, Color.orange);

	}

	//-------------------------------------------------------------------------------------------------
	//Button action performed
	//-------------------------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == runButton){
			String aStr = runTimesField.getText()=="" ? "1":runTimesField.getText();
			int runTimesInt;
			runTimesInt = Integer.parseInt(aStr);

			lvlInt1 = charLvlChoice.getSelectedIndex()+1;

			for (int i=0; i<runTimesInt ; i++)
			{
				//Get the weapon type
				weapType = getWeaponType();

				//Get the base stats for a repeater
				if (weapType == "Repeater"){
					repeater repDisp = new repeater();
					displayArray = repDisp.repeaterStats(lvlInt1);
				}
				else if(weapType == "Revolver"){
					revolver revDisp = new revolver();
					displayArray = revDisp.revolverStats(lvlInt1);
				}
				else if(weapType == "Sub-Machine Gun"){
					SMG smgDisp = new SMG();
					displayArray = smgDisp.smgStats(lvlInt1);
				}
				else if(weapType == "Sniper Rifle"){
					sniper snDisp = new sniper();
					displayArray = snDisp.sniperStats(lvlInt1);
				}
				else if(weapType == "Shotgun"){
					shotgun sgDisp = new shotgun();
					displayArray = sgDisp.shotgunStats(lvlInt1);
				}
				else if(weapType == "Assault Rifle"){
					aRifle arDisp = new aRifle();
					displayArray = arDisp.aRifleStats(lvlInt1);
				}
				else if(weapType == "Light Machine Gun"){
					LMG lmgDisp = new LMG();
					displayArray = lmgDisp.LMGStats(lvlInt1);
				}
				else if(weapType == "Rocket Launcher"){
					rLauncher rlDisp = new rLauncher();
					displayArray = rlDisp.rLauncherStats(lvlInt1);
				}
				else if(weapType == "Grenade Launcher"){
					gLauncher glDisp = new gLauncher();
					displayArray = glDisp.gLauncherStats(lvlInt1);
				}

				rarityInt = Integer.parseInt(displayArray[12]);
				findRarityColor(rarityInt);
				clearBoolean = false;
				setTabsAndStyles(display);
				addTextToTextPane();
			}

		}
		else if(e.getSource() == clearButton){
			for (int j = 0; j<displayArray.length; j++)
			{
				displayArray[j]="";
			}
			clearBoolean = true;
			addTextToTextPane();
		}
		else{
			display.setText("Buttons Don't Work");
		}
	}

	//---------------------------------------------------------------------------------------------------
	//Determine weapon type
	//---------------------------------------------------------------------------------------------------
	public JTextPane addTextToTextPane()
	{
		Document doc = display.getDocument();
		try
		{
			//clear previous text
			if(clearBoolean == true)
				doc.remove(0, doc.getLength());
			else{
				doc.insertString(doc.getLength(), displayArray[0]+"\n", display.getStyle("italic"));
				doc.insertString(doc.getLength(), displayArray[1]+"\n", display.getStyle("name"));
				doc.insertString(doc.getLength(), displayArray[2]+"\n", display.getStyle("stats"));
				doc.insertString(doc.getLength(), displayArray[3]+"\n", display.getStyle("stats"));
				doc.insertString(doc.getLength(), displayArray[4]+"\n", display.getStyle("stats"));
				doc.insertString(doc.getLength(), displayArray[5]+"\n", display.getStyle("stats"));
				doc.insertString(doc.getLength(), displayArray[6]+"\n", display.getStyle("stats"));
				doc.insertString(doc.getLength(), displayArray[7]+"\n", display.getStyle("stats"));
				doc.insertString(doc.getLength(), displayArray[8]+"\n", display.getStyle("stats"));
				doc.insertString(doc.getLength(), displayArray[9], display.getStyle("regular"));
				doc.insertString(doc.getLength(), displayArray[10], display.getStyle("element"));
				doc.insertString(doc.getLength(), displayArray[11]+"\n", display.getStyle("regular"));
			}
		}
		catch (BadLocationException ble)
		{
			System.err.println("Couldn't insert text.");
		}

		return display;
	}

	//----------------------------------------------------------------------------------------------------
	//Determine Rarity Color
	//----------------------------------------------------------------------------------------------------
	public Color findRarityColor(int a)
	{
		//Color rarityColor = new Color(255, 255, 255);
		if(a<=50){
			//rarityColor = Color(255, 255, 255);
			rarityColor=Color.white;
		}
		else if(a<=80){
			//rarityColor = Color(25, 255, 25);
			rarityColor=Color.green;
		}
		else if(a<=130){
			//rarityColor = 25, 25, 255;
			Color c = new Color(60, 60, 230);
			rarityColor = c;
		}
		else if(a<=150){
			//rarityColor = Color(190, 25, 190);
			Color c = new Color(190,25,190);
			rarityColor = c;
		}
		else if(a>150){
			//rarityColor = Color(255, 180, 0);
			rarityColor= Color.orange;
		}

		return rarityColor;
	}

	//---------------------------------------------------------------------------------------------------
	//Determine weapon type
	//---------------------------------------------------------------------------------------------------
	public String getWeaponType()
	{
		String weaponType = new String("");
		int randomTypeInt = randomBase.nextInt(99)+1;

		if (randomTypeInt<=15){
			weaponType = "Repeater";
		}
		else if (randomTypeInt>15 && randomTypeInt<=25){
			weaponType = "Revolver";
		}
		else if (randomTypeInt>25 && randomTypeInt<=40){
			weaponType = "Sub-Machine Gun";
		}
		else if (randomTypeInt>40 && randomTypeInt<=55){
			weaponType = "Sniper Rifle";
		}
		else if (randomTypeInt>55 && randomTypeInt<=70){
			weaponType = "Shotgun";
		}
		else if (randomTypeInt>70 && randomTypeInt<=82){
			weaponType = "Assault Rifle";
		}
		else if (randomTypeInt>82 && randomTypeInt<=92){
			weaponType = "Light Machine Gun";
		}
		else if (randomTypeInt>92 && randomTypeInt<=95){
			weaponType = "Rocket Launcher";
		}
		else if (randomTypeInt>95 && randomTypeInt<=98){
			weaponType = "Grenade Launcher";
		}
		else if (randomTypeInt>98){
			weaponType = "Weapon Mod.";
		}
		else {
			weaponType = "Whoops.";
		}

		return weaponType;
	}

	public static void main(String args[])
	{
		d20weaponsystem f = new d20weaponsystem();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(f.createContentPane());
		f.setTitle("D20 Weapon Generation System");
		f.setBounds(100, 100, 360, 600);
		f.setVisible(true);
	}
 }