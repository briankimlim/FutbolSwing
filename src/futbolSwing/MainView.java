package futbolSwing;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

import com.alee.laf.WebLookAndFeel;


public class MainView{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//WebLookAndFeel.install ();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebLookAndFeel.install ();
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Futbol 1.0");
		frame.setBounds(100, 100, 500, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e){
			e.printStackTrace();
		}*/
		
		
		JPanel outerPan = new JPanel(new BorderLayout());
		//outerPan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		JPanel topPan = new JPanel(new BorderLayout());
		topPan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		
		//frame.getContentPane().add(topPan, BorderLayout.CENTER);
		
		//JLabel lblFutbolImg = new JLabel("Futbol img");
		//panel.add(lblFutbolImg);
		String IMG_PATH = "src/futbol_logo.png";
		try{
			BufferedImage img = ImageIO.read(new File(IMG_PATH));
	         ImageIcon icon = new ImageIcon(img);
	         JLabel imgLabel = new JLabel(icon);
	         topPan.add(imgLabel);
			/*BufferedImage wPic = ImageIO.read(this.getClass().getResource("futbol_logo.png"));
			JLabel wIcon = new JLabel(new ImageIcon(wPic));
			topPan.add(wIcon);*/
		} 
		catch (Exception e){
			e.printStackTrace();
		}
		outerPan.add(topPan,BorderLayout.NORTH);
		
		JPanel ctrPan = new JPanel(new BorderLayout());
		ctrPan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		//frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JPanel ctrPan2_1 = new JPanel(new BorderLayout());
		ctrPan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		JPanel ctrPan1 = new JPanel();
		ctrPan1.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		JPanel ctrPan2 = new JPanel();
		ctrPan2.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		JPanel ctrPan3 = new JPanel();
		ctrPan3.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		JButton btnPlayerAnalysis = new JButton("Player Analysis");
		ctrPan1.add(btnPlayerAnalysis);
		
		// TEST
		/*public void addComponentToPane(Container pane) {
	        JTabbedPane tabbedPane = new JTabbedPane();
	 
	        //Create the "cards".
	        JPanel card1 = new JPanel() {
	            //Make the panel wider than it really needs, so
	            //the window's wide enough for the tabs to stay
	            //in one row.
	            public Dimension getPreferredSize() {
	                Dimension size = super.getPreferredSize();
	                size.width += extraWindowWidth;
	                return size;
	            }
	        };
	        card1.add(new JButton("Button 1"));
	        card1.add(new JButton("Button 2"));
	        card1.add(new JButton("Button 3"));
	 
	        JPanel card2 = new JPanel();
	        card2.add(new JTextField("TextField", 20));
	 
	        tabbedPane.addTab(BUTTONPANEL, card1);
	        tabbedPane.addTab(TEXTPANEL, card2);
	 
	        pane.add(tabbedPane, BorderLayout.CENTER);
	    }*/
		
		
		//
		
		btnPlayerAnalysis.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            /*JFrame frame = new JFrame ("MyPanel");
	            frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	            frame.getContentPane().add(new PlayerAnalysis());*/
	        	
	        	JPanel pAnaPanel = new PlayerAnalysisView();
	        	
	        	JPanel lAnaPanel = new LeagueAnalysisView(); 	
	        	JTabbedPane tabbedPane = new JTabbedPane();
	        	
	        	tabbedPane.addTab("Player Analysis", pAnaPanel);
		        tabbedPane.addTab("League Analysis", lAnaPanel);
	        	
	        	//frame.removeAll();
	        	//frame.dispose();
	        	frame.invalidate();
	        	frame.validate();
	        	frame.repaint();

	            //pAnaPanel.addComponentToPane(frame.getContentPane());
	        	
	        	//frame.setContentPane(pAnaPanel); 
	        	frame.setContentPane(tabbedPane);
	        	
	            //frame.pack();
	            frame.setVisible (true);

	        }
		});
		JButton btnLeagueAnalysis = new JButton("League Analysis");
		ctrPan2.add(btnLeagueAnalysis);
		
		btnLeagueAnalysis.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            /*JFrame frame = new JFrame ("MyPanel");
	            frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	            frame.getContentPane().add(new PlayerAnalysis());*/
	        	JPanel lAnaPanel = new LeagueAnalysisView();
	        	//frame.removeAll();
	        	//frame.dispose();
	        	frame.invalidate();
	        	frame.validate();
	        	frame.repaint();

	        	frame.setContentPane(lAnaPanel); 
	            //frame.pack();
	            frame.setVisible (true);

	        }
		});
		
		JButton btnLogin = new JButton("Scorekeeper Login");
		ctrPan3.add(btnLogin);
		
		btnLogin.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            
	        	//JPanel AuthPanel = new AuthenticationView();
	        	JPanel AuthPanel = new LiveScoreView();
	        	//frame.removeAll();
	        	//frame.dispose();
	        	frame.invalidate();
	        	frame.validate();
	        	frame.repaint();

	        	frame.setContentPane(AuthPanel); 
	            //frame.pack();
	            frame.setVisible (true);

	        }
		});
		
		
		
		ctrPan.add(ctrPan1,BorderLayout.NORTH);
		ctrPan.add(ctrPan2_1,BorderLayout.CENTER);
		ctrPan2_1.add(ctrPan2,BorderLayout.NORTH);
		ctrPan2_1.add(ctrPan3,BorderLayout.CENTER);
		
		outerPan.add(ctrPan,BorderLayout.CENTER);
		
		
		/*JPanel buttonPanel = new JPanel(); 
		final JButton previousButton = new JButton("PREVIOUS");
        previousButton.setBackground(Color.BLACK);
        previousButton.setForeground(Color.WHITE);
        buttonPanel.add(previousButton);
        
        PlayerAnalysisView win1 = new PlayerAnalysisView();
        outerPan.add(win1, "pAna");
        LeagueAnalysisView win2 = new LeagueAnalysisView();
        outerPan.add(win2, "lAna");
        
        frame.add(buttonPanel, BorderLayout.PAGE_END);
        
        previousButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                CardLayout cardLayout = (CardLayout) outerPan.getLayout();
                cardLayout.previous(outerPan);
            }
        });*/
		
		frame.setContentPane(outerPan);
		frame.pack();
	}

}
