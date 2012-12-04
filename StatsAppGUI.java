public class StatsAppGUI
{
	public StatsAppGUI()
	{
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUIPanel();
            }
        });
	}

	public static void main(String[] args)
	{
		new StatsAppGUI();
	}
}

