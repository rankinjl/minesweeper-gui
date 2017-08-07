import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//listener for the timer object in the game frame
	//should get event every second to increment the time
public class ViewTimerActionListener implements ActionListener{

	private ViewGameTilesFrame myView;
	
	public ViewTimerActionListener(ViewGameTilesFrame view){
		myView = view;
	}
		
	public void actionPerformed(ActionEvent e){
		if(myView!=null)
			myView.incrementTime();
	}

}
