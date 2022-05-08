

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class MyFrame
        extends JFrame
          implements ActionListener{

    // Components of the Form
    private Container container;
    private JTextField tname, pname, experience, personality, ideals, bonds, flaws;
    //initializing text entry boxes
    private JLabel title, name,rac, cal, bak, alg, pln, exp, str, dex, con, intl, prt, idl, bnd, flw;
    //initializing labels
    private JComboBox race, class_and_level, background, alignment, strength, dexterity, constitution, intelligence;
    //initializing dropdown boxes
    private JButton submit, reset;
    //initializes submit and reset buttons

    private String allocated_points[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15" };
    private String classes[] = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"};
    private String races[] = { "Aarakocra", "Aasimar", "Bugbear", "Centaur", "Changeling", "Dhampir", "Dragonborn", "Dwarve", "Elves", "Firbolg", "Genasi", "Gith", "Gnome", "Goblin", "Goliath", "Half-Elf", "Half-Orc", "Hexblood", "Hobgoblin", "Human", "Kalashtar", "Kenku", "Kobold", "Leonin", "Lizardfolk", "Loxodon", "Minotaur", "Orc", "Reborn", "Satyr", "Shifter", "Simic Hybrid", "Tabaxi", "Tiefling", "Tortle", "Triton", "Vedalken", "Verdan", "Warforged", "Yuan-Ti Pureblood"};
    private String backgrounds[] = {"Acolyte", "Anthropologist"};
    private String alignments[] = {"Lawful Good", "Lawful Neutral", "Lawful Evil","Neutral Good", "True Neutral", "Neutral Evil","Chaotic Good", "Chaotic Neutral", "Chaotic Evil"};

    //data for selections
    public MyFrame()
    {
    //creates all entries, their locations, and displays them
        setTitle("Registration Form");
        setBounds(300, 90, 1400, 1400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        //creates an empty form
        container = getContentPane();
        container.setLayout(null);

        title = new JLabel("Dungeons and Dragons");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(350, 30);
        title.setLocation(10, 20);
        container.add(title);
        //- Character Name
        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(200, 20);
        tname.setLocation(20, 60);
        container.add(tname);
        name = new JLabel("Character Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(300, 20);
        name.setLocation(20, 90);
        container.add(name);
        //- Class and Level
        cal = new JLabel("Class");
        cal.setFont(new Font("Arial", Font.PLAIN, 20));
        cal.setSize(100, 20);
        cal.setLocation(380, 20);
        container.add(cal);
        class_and_level = new JComboBox(classes);
        class_and_level.setFont(new Font("Arial", Font.PLAIN, 15));
        class_and_level.setSize(150, 20);
        class_and_level.setLocation(450, 20);
        container.add(class_and_level);
        //-Race
        rac = new JLabel("Race");
        rac.setFont(new Font("Arial", Font.PLAIN, 20));
        rac.setSize(100, 20);
        rac.setLocation(380, 60);
        container.add(rac);
        race = new JComboBox(races);
        race.setFont(new Font("Arial", Font.PLAIN, 15));
        race.setSize(150, 20);
        race.setLocation(450, 60);
        container.add(race);
        //-Background
        bak = new JLabel("Background");
        bak.setFont(new Font("Arial", Font.PLAIN, 20));
        bak.setSize(150, 20);
        bak.setLocation(630, 20);
        container.add(bak);
        background = new JComboBox(backgrounds);
        background.setFont(new Font("Arial", Font.PLAIN, 15));
        background.setSize(150, 20);
        background.setLocation(750, 20);
        container.add(background);
        //-Alignment
        alg = new JLabel("Alignment");
        alg.setFont(new Font("Arial", Font.PLAIN, 20));
        alg.setSize(150, 20);
        alg.setLocation(630, 60);
        container.add(alg);
        alignment = new JComboBox(alignments);
        alignment.setFont(new Font("Arial", Font.PLAIN, 15));
        alignment.setSize(150, 20);
        alignment.setLocation(750, 60);
        container.add(alignment);
        //-Player Name
        pln = new JLabel("Player Name");
        pln.setFont(new Font("Arial", Font.PLAIN, 20));
        pln.setSize(150, 20);
        pln.setLocation(920, 20);
        container.add(pln);
        pname = new JTextField();
        pname.setFont(new Font("Arial", Font.PLAIN, 15));
        pname.setSize(200, 20);
        pname.setLocation(1050, 20);
        container.add(pname);
        //- Experience
        exp = new JLabel("Experience");
        exp.setFont(new Font("Arial", Font.PLAIN, 20));
        exp.setSize(150, 20);
        exp.setLocation(920, 60);
        container.add(exp);
        experience = new JTextField();
        experience.setFont(new Font("Arial", Font.PLAIN, 15));
        experience.setSize(200, 20);
        experience.setLocation(1050, 60);
        container.add(experience);
        //-Strength
        str = new JLabel("Strength");
        str.setFont(new Font("Arial", Font.PLAIN, 20));
        str.setSize(150, 20);
        str.setLocation(20, 200);
        container.add(str);
        strength = new JComboBox(allocated_points);
        strength.setFont(new Font("Arial", Font.PLAIN, 15));
        strength.setSize(50, 20);
        strength.setLocation(120, 200);
        container.add(strength);

        //-Dexterity
        dex = new JLabel("Dexterity");
        dex.setFont(new Font("Arial", Font.PLAIN, 20));
        dex.setSize(150, 20);
        dex.setLocation(20, 240);
        container.add(dex);
        dexterity = new JComboBox(allocated_points);
        dexterity.setFont(new Font("Arial", Font.PLAIN, 15));
        dexterity.setSize(50, 20);
        dexterity.setLocation(120, 240);
        container.add(dexterity);

        //-Constitution
        con = new JLabel("Constitution");
        con.setFont(new Font("Arial", Font.PLAIN, 20));
        con.setSize(150, 20);
        con.setLocation(20, 280);
        container.add(con);
        constitution = new JComboBox(allocated_points);
        constitution.setFont(new Font("Arial", Font.PLAIN, 15));
        constitution.setSize(50, 20);
        constitution.setLocation(120, 280);
        container.add(constitution);
        //-Intelligence
        intl = new JLabel("Intelligence");
        intl.setFont(new Font("Arial", Font.PLAIN, 20));
        intl.setSize(150, 20);
        intl.setLocation(20, 320);
        container.add(intl);
        intelligence = new JComboBox(allocated_points);
        intelligence.setFont(new Font("Arial", Font.PLAIN, 15));
        intelligence.setSize(50, 20);
        intelligence.setLocation(120, 320);
        container.add(intelligence);
        //-Personality Traits
        prt = new JLabel("Experience");
        prt.setFont(new Font("Arial", Font.PLAIN, 20));
        prt.setSize(150, 20);
        prt.setLocation(920, 60);
        container.add(prt);
        personality = new JTextField();
        personality.setFont(new Font("Arial", Font.PLAIN, 15));
        personality.setSize(350, 200);
        personality.setLocation(400, 200);
        container.add(personality);

        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.PLAIN, 15));
        submit.setSize(100, 20);
        submit.setLocation(150, 450);
        submit.addActionListener(this);
        container.add(submit);
        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 450);
        container.add(reset);



        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {        //when the action listener detects the button press
        Map<String, ArrayList<String>> stats_entry = new HashMap<String, ArrayList<String>>();
        //creates an array list hasmap to store the data from each entry in
        if (e.getSource() == submit) {
            stats_entry.put(tname.getText(), new ArrayList<String>());  //gets the entry and assigns it the key of the character name
            stats_entry.get(tname.getText()).add(pname.getText());                                  //assigns all inputted values to the hasmap
            stats_entry.get(tname.getText()).add((String) class_and_level.getSelectedItem());
            stats_entry.get(tname.getText()).add((String) race.getSelectedItem());
            stats_entry.get(tname.getText()).add((String) background.getSelectedItem());
            stats_entry.get(tname.getText()).add((String) alignment.getSelectedItem());
            stats_entry.get(tname.getText()).add(experience.getText());
            stats_entry.get(tname.getText()).add((String) strength.getSelectedItem());
            stats_entry.get(tname.getText()).add((String) dexterity.getSelectedItem());
            stats_entry.get(tname.getText()).add((String) constitution.getSelectedItem());
            stats_entry.get(tname.getText()).add((String) intelligence.getSelectedItem());




            System.out.println(stats_entry);
        }

        else if (e.getSource() == reset) {
            //doesnt work

        }
    }
}

class Registration {

    public static void main(String[] args) throws Exception
    {
        MyFrame f = new MyFrame();
    }
}

