import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//listener for the main game frame's JMenuBar
public class ViewMenuListener implements ActionListener {

	private ViewGUI myView;
	
	public ViewMenuListener(ViewGUI view)
	{
		myView = view;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(myView!=null)
		{
			String command = e.getActionCommand();
			if(command.equals("Exit"))
			{
				myView.exitGame();
			}else if(command.equals("Play Different Game"))
			{
				myView.playAgain();
			}else if(command.equals("New Game With Same Settings"))
			{
				myView.playGame();
			}else if(command.equals("Display Rules"))
			{
				myView.createPopUp(myView.getRules(),600,600,true);
			}
		}
	}
	
}
