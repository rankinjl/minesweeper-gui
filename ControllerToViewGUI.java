import java.util.ArrayList;
//implemented by the ViewGUI and used by the Controller to communicate with the View
public interface ControllerToViewGUI {
	
	public final int NULL_EXIT_CODE = -1;
	
	public void go(ArrayList<String> diffs);
	public void refresh(boolean[][] exposed, String emptyTileText);
}
