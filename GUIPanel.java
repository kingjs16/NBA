/**
 *
 */
/**
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GUIPanel
{
	private JFrame 		frame;
	private JPanel 		framePanel, dataPanel;
	private JTextArea 	dataTA;
	private JMenuItem	printMI, exitMI, aboutMI, calcTotalMinutesMI, calcTotalPointsMI, calcTotalReboundsMI, calcTotalAssistsMI, sortByNameMI, sortByTeamMI, sortByMinutesMI;
	private JMenuItem	sortByPointsMI, sortByReboundsMI, sortByAssistsMI, displayPlayerMI;
	private StatsArray 	statsData;

	public GUIPanel()
	{
		framePanel = new JPanel();
		dataPanel = new JPanel();

		dataTA = new JTextArea(10, 40);
		dataTA.setBackground(new Color(200,200,200));
		dataTA.setLineWrap(true);
		dataTA.setWrapStyleWord(true);
		dataTA.setEditable(true);
		JScrollPane dataSP = new JScrollPane(dataTA,
			ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		dataPanel.add(dataSP);


        framePanel.setOpaque(true);
        framePanel.setLayout(new BorderLayout());
        framePanel.add(dataPanel, BorderLayout.CENTER);

		frame = new JFrame("Stats App GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(createMenuBar());
		frame.setContentPane(framePanel);
		frame.pack();
		frame.setLocation(500, 400);
		frame.setResizable(true);
		frame.setVisible(true);

		statsData = new StatsArray();

	} // end GUIPanel constructor

    public JMenuBar createMenuBar()
    {
		JMenuBar menuBar;
		JMenu menu;

		menuBar = new JMenuBar();

		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(menu);

		printMI = new JMenuItem("Print...");
		printMI.addActionListener(new PrintListener());
		menu.add(printMI);

		exitMI = new JMenuItem("Exit");
		exitMI.addActionListener(new ExitListener());
		menu.add(exitMI);

		menu = new JMenu("Calculation");
		menu.setMnemonic(KeyEvent.VK_C);
		menuBar.add(menu);

		calcTotalMinutesMI = new JMenuItem("Total Minutes");
		calcTotalMinutesMI.addActionListener(new calcTotalMinutesListener());
		menu.add(calcTotalMinutesMI);

		calcTotalPointsMI = new JMenuItem("Total Points");
		calcTotalPointsMI.addActionListener(new calcTotalPointsListener());
		menu.add(calcTotalPointsMI);

		calcTotalReboundsMI = new JMenuItem("Total Rebounds");
		calcTotalReboundsMI.addActionListener(new calcTotalReboundsListener());
		menu.add(calcTotalReboundsMI);

		calcTotalAssistsMI = new JMenuItem("Total Assists");
		calcTotalAssistsMI.addActionListener(new calcTotalAssistsListener());
		menu.add(calcTotalAssistsMI);

		menu = new JMenu("Sort");
		menu.setMnemonic(KeyEvent.VK_S);
		menuBar.add(menu);

		sortByNameMI = new JMenuItem("Sort by Name");
		sortByNameMI.addActionListener(new SortByNameListener());
		menu.add(sortByNameMI);

		sortByTeamMI = new JMenuItem("Sort by Team");
		sortByTeamMI.addActionListener(new SortByTeamListener());
		menu.add(sortByTeamMI);

		sortByMinutesMI = new JMenuItem("Sort by Minutes");
		sortByMinutesMI.addActionListener(new SortByMinutesListener());
		menu.add(sortByMinutesMI);

		sortByPointsMI = new JMenuItem("Sort by Points");
		sortByPointsMI.addActionListener(new SortByPointsListener());
		menu.add(sortByPointsMI);

		sortByReboundsMI = new JMenuItem("Sort by Rebounds");
		sortByReboundsMI.addActionListener(new SortByReboundsListener());
		menu.add(sortByReboundsMI);

		sortByAssistsMI = new JMenuItem("Sort by Assists");
		sortByAssistsMI.addActionListener(new SortByAssistsListener());
		menu.add(sortByAssistsMI);

		menu = new JMenu("Players");
		menu.setMnemonic(KeyEvent.VK_P);
		menuBar.add(menu);

		displayPlayerMI = new JMenuItem("Display Player");
		displayPlayerMI.addActionListener(new displayPlayerListener());
		menu.add(displayPlayerMI);

		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);
		menuBar.add(menu);

		aboutMI = new JMenuItem("About");
		aboutMI.addActionListener(new AboutListener());
		menu.add(aboutMI);

		return menuBar;
    } // end createMenuBar

	class PrintListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				dataTA.print();
			} catch (Exception pe) {
			}
		}
	}

	class ExitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}

	class calcTotalMinutesListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dataTA.setText(String.format("Total Minutes  %10.2f",
				statsData.calcTotalMinutes()));
		}
	}

	class calcTotalPointsListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dataTA.setText(String.format("Total Points  %10.2f",
				statsData.calcTotalPoints()));
		}
	}

	class calcTotalReboundsListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dataTA.setText(String.format("Total Rebounds  %10.2f",
				statsData.calcTotalRebounds()));
		}
	}

	class calcTotalAssistsListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dataTA.setText(String.format("Total Assists  %10.2f",
				statsData.calcTotalAssists()));
		}
	}

	class AboutListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(framePanel,
				"StatsAppGUI by Patrick Deitrick, Christopher Hume, and Jeremy King on 12/4/12",
				"About", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	class SortByNameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			statsData.sortByName();

			dataTA.setText(statsData.toString());
		}
	}

	class SortByTeamListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			statsData.sortByTeam();

			dataTA.setText(statsData.toString());
		}
	}

	class SortByMinutesListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			statsData.sortByMinutes();

			dataTA.setText(statsData.toString());
		}
	}

	class SortByPointsListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			statsData.sortByPoints();

			dataTA.setText(statsData.toString());
		}
	}

	class SortByReboundsListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			statsData.sortByRebounds();

			dataTA.setText(statsData.toString());
		}
	}

	class SortByAssistsListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			statsData.sortByAssists();

			dataTA.setText(statsData.toString());
		}
	}

	public static class PicPopup extends JFrame
	{
		private static final long serialVersionUID = 1L;

		public PicPopup(String fn, String ln, String tn)
			{
				String player = "image\\"  + tn + "\\" + fn + ln + ".png";

				setSize(390,274);
				JPanel panel = new JPanel();
				panel.setBackground(Color.WHITE);
				ImageIcon icon = new ImageIcon(player);
				JLabel label = new JLabel();
				label.setIcon(icon);
				panel.add(label);
				this.getContentPane().add(panel);
				this.setLocation(110,400);
				setVisible(true);
			}
	}

	public static class TeamPopup extends JFrame
	{
		private static final long serialVersionUID = 1L;

		public TeamPopup(String tn)
		{
			String team = "image\\"  + tn + "\\" + tn + ".png";
			setSize(260,260);
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			ImageIcon icon = new ImageIcon(team);
			JLabel label = new JLabel();
			label.setIcon(icon);
			panel.add(label);
			this.getContentPane().add(panel);
			this.setLocation(984,400);
			setVisible(true);
		}
	}



	class displayPlayerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String fn = JOptionPane.showInputDialog(frame,
			"Enter player first name");
			String ln = JOptionPane.showInputDialog(frame,
			"Enter player last name");
			String tn = JOptionPane.showInputDialog(frame,
			"Enter player team");

			dataTA.setText(statsData.listPlayer(fn, ln));

			new PicPopup(fn, ln, tn);
			new TeamPopup(tn);
		}
	}



} // end class GUIPanel

