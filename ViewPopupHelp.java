import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

//creates a popup jframe to display the given msg to help the user
public class ViewPopupHelp extends JFrame{

	private final int fontSize = 18;
	private ViewGUI myView;
	
	public ViewPopupHelp(ViewGUI view, String msg, int frameWidth, int frameHeight, boolean timer)
	{
		super("Help Window");
		myView = view;		
		
		//display the message
		JTextArea help = new JTextArea(msg);
		help.setBackground(getBackground());
		help.setFont(new Font("Arial",Font.BOLD,fontSize));
		help.setLineWrap(true);
		help.setWrapStyleWord(true);//wrap at word, not chars
		help.setEditable(false);
		
		//okay button for user to press
		JButton ok = new JButton("Okay");
		if(view!=null)
		{
			ok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
			    	myView.endHelpPopup(timer);
					dispose();
				}
			});
		}
		ok.setFont(new Font("Arial",Font.BOLD,fontSize));
		ok.setMnemonic(KeyEvent.VK_ENTER);
		ok.setAlignmentX(Component.CENTER_ALIGNMENT);
		
	    setSize(frameWidth,frameHeight); //using given width and height
	    setLayout(new BorderLayout());
	    setLocationRelativeTo(null);
	    
	    add(help,BorderLayout.PAGE_START);
	    add(ok,BorderLayout.PAGE_END);
	    
	    if(myView!=null)
	    { //if user hits exit
	    	addWindowListener(new WindowAdapter() {
		       public void windowClosing(WindowEvent windowEvent){
		    	   myView.endHelpPopup(timer);
		    	   dispose();
		       }        
	    	});
	    }
	    
	    setVisible(true);
	}
}
