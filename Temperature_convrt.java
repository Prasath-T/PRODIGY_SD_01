import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;


public class Temperature_convrt extends Frame implements ActionListener{ 
	

      Frame f = new Frame();  
  
       
      JLabel l = new JLabel("Enter a temperature value and selct a measurement scale:");
      

      JButton b = new JButton("Convert");  
  
      JTextField t = new JTextField(); 

      Choice c=new Choice();


	public Temperature_convrt(){ 

   
  
      // setting position of above components in the frame  
      l.setBounds(50, 60, 350, 30);  
      t.setBounds(50, 120, 100, 30);  
      b.setBounds(220, 120, 80, 30); 

      c.setBounds(150,125,37,30);



      c.add("C");
      c.add("F");
      c.add("K");

      //Adding  a color in components
      b.setBackground(Color.blue);
      b.setForeground(Color.white);
      t.setBackground(Color.orange);
      t.setForeground(Color.black);
      
      
      
      
      

      //Action event on bottom
      b.addActionListener(this); 
  
      //add component to frame   
      f.add(b);  
      f.add(l);  
      f.add(t);  
      f.add(c);
      
  
         
      // Add window listener 
		f.addWindowListener(new WindowAdapter() { 
			// Anonymous class to override windowClosing 
			// event 
			public void windowClosing(WindowEvent e) 
			{ 
				// Call dispose method 
				System.exit(0); 
			} 
		}); 


      f.setSize(400,300); 
      f.setBounds(500,100,500,400);

      Color color=new Color(230,150,150);
      f.setBackground(color);
     
      f.setTitle("Temperature converter");   
           
      f.setLayout(null); 
         
      f.setVisible(true);  



		
	} 

   public void actionPerformed(ActionEvent e){ 

      String data = c.getItem(c.getSelectedIndex()); 

      String a=t.getText();

      
     try
      {
         double f = Double.parseDouble(a);

         switch(data) {
            case "C":
                
                double fah = f * 9 / 5 + 32;
                double kvn = f + 273.15;            
   
               JOptionPane.showMessageDialog(this, "Fahrenheit: "+fah+"\n"+"Kelvin:  "+kvn, 
                                 "Temperature", 
                                 JOptionPane.INFORMATION_MESSAGE);
                
               break;
   
            case "F":
                double cel = (f - 32) * 5 / 9;
                String cel_string=String.format("%.3f",cel);
                double kvn_f = cel + 273.15;
                String kvn_string=String.format("%.3f",kvn_f);
   
   
                JOptionPane.showMessageDialog(this, "Celsius: "+cel_string+"\n"+"Kelvin:  "+kvn_string, 
                                 "Temperature", 
                                 JOptionPane.INFORMATION_MESSAGE);
   
                break;
   
   
            case "K":
   
                double fah_k = (f-273.15) * 9 / 5 + 32;
                String fah_Str=String.format("%.2f",fah_k);
                double cel_k = f-273.15;
                String cel_Str=String.format("%.2f", cel_k);
   
   
                JOptionPane.showMessageDialog(this, "Fahrenheit: "+fah_Str+"\n"+"Celsius:  "+cel_Str, 
                                 "Temperature", 
                                 JOptionPane.INFORMATION_MESSAGE);
   
                
   
                break;
            
   
         }
      }

      catch(NumberFormatException nfe)  
      {
         JOptionPane.showMessageDialog(this, "Enter a valid temperature ",
         "WARNING", JOptionPane.WARNING_MESSAGE);
      
      }
      

     
  

  }  

	// Main method 
	public static void main(String[] args) { new Temperature_convrt(); } 
}
