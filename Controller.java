import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private final Model model;

    public Controller(Viewer viewer) {
        model = new Model(viewer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println(command);
        model.initializeWindows(command);
    }
}
