import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
import javax.swing.JCheckBox;

public class MyGUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private JTextField aTextField = new JTextField();
	private JButton onOff = new JButton("ON/OFF");
	private String ceilingFan = "OFF";
	private boolean powerSupply = true;
	
	private class OnOffActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			if (ceilingFan == "OFF" && powerSupply == true)
			{
				ceilingFan = "ON";
			} else if (ceilingFan == "ON" || powerSupply == false)
			{
				ceilingFan = "OFF";
			}
			
			updateText();
		}
	}
	
	private void circuitBreaker()
	{
		if (powerSupply == true)
		{
			powerSupply = false;
		} 
		else if (powerSupply == false)
		{
			powerSupply = true;
		}
		updateText();
	}
	
	private void updateText()
	{
		aTextField.setText("Ceiling Fan: " + ceilingFan);
		validate();
	}
	
	private JMenuBar getMyMenuBar()
	{
		JMenuBar jmenuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("Circuit Breaker");
		fileMenu.setMnemonic('P');
		jmenuBar.add(fileMenu);
		
		JCheckBox enableAllCeilingFans = new JCheckBox("Ceiling Fan");
		enableAllCeilingFans.setMnemonic('C');
		fileMenu.add(enableAllCeilingFans);
		
		enableAllCeilingFans.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				circuitBreaker();
			}
		});
		
		return jmenuBar;
	}
	
	
	public MyGUI()
	{
		super("Ceiling Fan Controls");
		setLocationRelativeTo(null);
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(onOff, BorderLayout.SOUTH);
		onOff.addActionListener(new OnOffActionListener());
		getContentPane().add(aTextField, BorderLayout.CENTER);
		//aTextField.setText("Ceiling Fan:" + ceilingFan);
		setJMenuBar(getMyMenuBar());
		updateText();
		setVisible(true);
	}
	
	
	public static void main(String[] args)
	{
		new MyGUI();
	}
}
