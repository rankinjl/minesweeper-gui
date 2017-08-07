import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//listener for radio button changes 
	//for start frame's extra lives
	//for start frame's difficulties
public class ViewRadioButtonListener implements ActionListener{

	private ViewGUI myView;
	
	public ViewRadioButtonListener(ViewGUI v)
	{
		myView = v;
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(myView!=null)
		{
			//extra lives changed
			if(command.equals("1extra")||command.equals("2extra")||command.equals("3extra"))
				myView.setExtraLives(Integer.parseInt(command.substring(0, 1)));
			//difficulty changed
			else
				myView.setDifficulty(command);
		}
	}
	
	
}
