import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//listener for buttons in the view
public class ViewButtonClickListener implements ActionListener{

	ViewGUI myView;
	
	public ViewButtonClickListener(ViewGUI view){
		myView = view;
	}
	
	//listen to buttons pushed in the view
	public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();  
        if(myView!=null)
        {
	        if(command.equals("Play")){
	        	myView.playGame();
	        }else if(command.equals("Exit")){
	        	myView.exitGame();
	        }else if(command.equals("Play Again")){
	        	myView.playAgain();
	        }else if(command.equals("Exit Game")){
	        	myView.exitGame();
	        }
        }
	}

}
