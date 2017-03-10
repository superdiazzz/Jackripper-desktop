package com.jackripper.desktop.main;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import com.jackripper.desktop.config.Configur;
import com.jackripper.desktop.modul.FirstFrame;

public class JackRipperDesktopApp extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JackRipperDesktopApp(Configur config){
		initVoid(config);
	}
	
	private void initVoid(Configur config){
		
		defaultTemplate(config);
		
	}

	private void defaultTemplate(Configur config) {
		// bagian dasar template main
		setTitle("JackRipperApps"+config.getUser());
		setSize(300, 200);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JButton quitButton = new JButton("Test");
        createLayout(quitButton);
		quitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FirstFrame testFrame = new FirstFrame();
				testFrame.setVisible(true);
			}
		});
		
		
	}

	private void createLayout(JComponent... arg) {
		Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );
	}

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		try {
			prop.load(JackRipperDesktopApp.class.getResourceAsStream("/jackRipper.properties"));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		final Configur config = new Configur();
		config.setUser(prop.getProperty("user"));
		config.setPass(prop.getProperty("pass"));
		
		
		Runnable run = new Runnable() {
			@Override
			public void run() {
				JackRipperDesktopApp ex = new JackRipperDesktopApp(config);
			    ex.setVisible(true);				
			}
		};
		
		EventQueue.invokeLater(run);
		
	}

}
