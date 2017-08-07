import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
//listener for the start frame's spinners in the custom setting
	//notifies ViewGUI when spinner changed
public class ViewSpinnerListener implements ChangeListener{

	private ViewGUI myView;
	
	public ViewSpinnerListener(ViewGUI view)
	{
		myView = view;
	}

	public void stateChanged(ChangeEvent e) {
		if(myView!=null)
		{ //only used by spinners
			JSpinner spinner = (JSpinner) e.getSource();
			myView.setCustom(spinner);
		}
	}
	
}
