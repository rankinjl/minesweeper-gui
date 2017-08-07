import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
//the frame for the end of a single game of minesweeper
public class ViewEndFrame extends JFrame{

	private final int fontSize = 18;
	private ViewGUI myView;
		
	//won - true if user won, false if user did not win
	//timeTaken - time it took the user to complete the game
	//bestTimes - has the best times for beginner/intermediate/expert/custom when applicable
	//gamesPlayed - number of total games played so far
	//gamesWon - number of total games won so far
	public ViewEndFrame(ViewGUI view, boolean won, long timeTaken, String bestTimes, long gamesPlayed, long gamesWon)
	{
		super();
		myView = view;
		
	    setSize(700,350);
	    setLayout(new GridLayout(1,2));
	    setLocationRelativeTo(null);
	    
	    JPanel left = new JPanel();
	    left.setLayout(new BoxLayout(left,BoxLayout.Y_AXIS));
	    JPanel right = new JPanel();
	    right.setLayout(new BoxLayout(right,BoxLayout.Y_AXIS));
	    
	    addLabel("\n", left);
	    addLabel("\n", right);
		
		if(won)
		{
			setTitle("Congrats, you won!");
			addLabel("Congrats, you won!", left);
		}
		else
		{
			setTitle("Sorry, try again.");
			addLabel("Sorry, you lost. Try again.",left)	;		
		}
		
		addLabel("\n",left);
		addLabel("Time taken: "+timeTaken+" seconds",left);
		addLabel("\n",left);
	    addPlayAgainExitButtons(left);
		
		addLabel("Total games played: "+gamesPlayed, right);
		addLabel("\n",right);
		addLabel("Total games won: "+gamesWon,right);
		addLabel("\n",right);
		if(gamesPlayed>0)
		{
			double fraction = (double) gamesWon/gamesPlayed;
			int percent = (int) (fraction*100);
			addLabel("Percent games won: "+ percent +"%",right); //will make it an integer percent
			addLabel("\n",right);
		}
		
		if(bestTimes!=null)
		{
			JTextArea times = new JTextArea(bestTimes);
			times.setBackground(getBackground());
			times.setFont(new Font("Arial",Font.BOLD,fontSize));
			times.setLineWrap(true);
			times.setWrapStyleWord(true);//wrap at word, not chars
			times.setEditable(false);
			
			right.add(times);
			addLabel("\n",right);
		}
				
	    add(left);
	    add(right);
	    
	    addWindowListener(new WindowAdapter() {
		       public void windowClosing(WindowEvent windowEvent){
		          System.exit(0);
		       }        
		});
	    
	    setVisible(true);
	}
	
	//add a single label with this msg to this panel
	private void addLabel(String msg, JPanel panel)
	{
		if(panel!=null && msg!=null)
		{
			JLabel label = new JLabel(msg);
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			label.setFont(new Font("Arial",Font.BOLD,fontSize));
			panel.add(label);
		}
	}
	
	//add buttons to this buttonpanel
	private void addPlayAgainExitButtons(JPanel buttonpanel)
	{
		if(buttonpanel!=null)
		{
			JPanel subpanel = new JPanel();
			JButton playbutton = createButton("Play Again","Play Again");
			if(playbutton!=null)
			{
				playbutton.setMnemonic(KeyEvent.VK_ENTER);
				JButton exitbutton = createButton("Exit","Exit Game");
				subpanel.add(playbutton);
				if(exitbutton!=null)
					subpanel.add(exitbutton);
				
			}
			buttonpanel.add(subpanel);
		}
	}
	
	//create and return a single button with the given information
	private JButton createButton(String buttontext,String actiontext)
	{
		if(buttontext!=null && actiontext!=null)
		{
			JButton thisbutton = new JButton(buttontext);
			thisbutton.setActionCommand(actiontext);
			if(myView!=null)
				thisbutton.addActionListener(new ViewButtonClickListener(myView));
			thisbutton.setFont(new Font("Arial",Font.BOLD,fontSize));
			return thisbutton;
		}
		return null;
	}
	
}
