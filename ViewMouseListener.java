import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

//listener for mouse clicks on game tile buttons
public class ViewMouseListener extends MouseAdapter{

	private ViewGUI myView;
	
	public ViewMouseListener(ViewGUI view)
	{
		myView = view;
	}
	
	public void mouseClicked(MouseEvent e)
	{
		if(e.getButton()!=MouseEvent.NOBUTTON && myView!=null)
		{ //game tile button clicked
			try
			{
				JButton button = (JButton)e.getSource();
				if(SwingUtilities.isRightMouseButton(e))
					myView.placeFlag(button);
				else	
					myView.tilePressed(button.getActionCommand());
			}catch(Exception ex)
			{
				ex.printStackTrace(System.out);
			}
		}
	}
	
}
