/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.jmeter.protocol.smtp.config.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.config.gui.AbstractConfigGui;
import org.apache.jmeter.gui.util.HorizontalPanel;
import org.apache.jmeter.gui.util.VerticalPanel;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jmeter.protocol.smtp.sampler.SmtpSampler;
//import org.apache.jmeter.protocol.smtp.sampler.SmtpSampler;

public class SmtpConfigGui extends AbstractConfigGui{

	/**
	 * 
	 */
	  private JTextField server;
	  
	  private JTextField port;
 
	  private JTextField addressTo;
	  
	  private JTextField addressFrom;
	  
	  private JTextField addressToCC;
	  
	  private JTextField addressToBCC;
	  
	  private JTextField addressReplyTo;
	  
	  	      
	private static final long serialVersionUID = 1L;
		
	public SmtpConfigGui() {
		init();        
	}	
	 /**
     * Helper method to set up the GUI screen
     */
    
	private void init() {
		 setLayout(new BorderLayout(0, 5));
		 setBorder(makeBorder());
	     add(makeTitlePanel(), BorderLayout.NORTH);
	    	     // MAIN PANEL
	     VerticalPanel mainPanel = new VerticalPanel();
	     JPanel serverPanel = new HorizontalPanel();
	     serverPanel.setBorder(BorderFactory.createTitledBorder(
	                BorderFactory.createEtchedBorder(),
	                JMeterUtils.getResString("smtp_server_settings"))); // $NON-NLS-1$
	     serverPanel.add(setServerTo(), BorderLayout.CENTER);
	     serverPanel.add(setServerPortTo(), BorderLayout.AFTER_LINE_ENDS);
	     JPanel mailSettingsPanel = new HorizontalPanel();
	     mailSettingsPanel.setBorder(BorderFactory.createTitledBorder(
	                BorderFactory.createEtchedBorder(),
	                JMeterUtils.getResString("smtp_mail_settings")));
	     mailSettingsPanel.add(setAddressTo(), BorderLayout.CENTER);
	     mainPanel.add(serverPanel);
	     mainPanel.add(mailSettingsPanel);
	     
	     add(mainPanel, BorderLayout.CENTER);
    }

	@Override
	public String getLabelResource() {
		// TODO Auto-generated method stub
		return "smtp_config_gui_title";
	}

	@Override
	public TestElement createTestElement() {
		ConfigTestElement element = new ConfigTestElement();
        modifyTestElement(element);
        return element;
	}

	@Override
	public void modifyTestElement(TestElement config) {
		configureTestElement(config);
		config.setProperty(SmtpSampler.SERVER, server.getText());
		config.setProperty(SmtpSampler.SERVER_PORT, port.getText());
		config.setProperty(SmtpSampler.RECEIVER_TO, addressTo.getText());
		//config.setProperty(SmtpSampler.MAIL_FROM, addressFrom.getText());
		//config.setProperty(SmtpSampler.MAIL_REPLYTO, addressReplyTo.getText());
		//config.setProperty(SmtpSampler.RECEIVER_CC, addressToCC.getText());
		//config.setProperty(SmtpSampler.RECEIVER_BCC, addressToBCC.getText());
	}
	
    @Override
    public void configure(TestElement element) {
    	super.configure(element);
    	server.setText(element.getPropertyAsString(SmtpSampler.SERVER));
    	port.setText(element.getPropertyAsString(SmtpSampler.SERVER_PORT));
    	addressTo.setText(element.getPropertyAsString(SmtpSampler.RECEIVER_TO));
    	//addressFrom.setText(element.getPropertyAsString(SmtpSampler.MAIL_FROM));
    	//addressToCC.setText(element.getPropertyAsString(SmtpSampler.RECEIVER_CC));
    	//addressToBCC.setText(element.getPropertyAsString(SmtpSampler.RECEIVER_BCC));
    	//addressReplyTo.setText(element.getPropertyAsString(SmtpSampler.MAIL_REPLYTO));
    }
	   /**
     * {@inheritDoc}
     */
    @Override
    public void clearGui() {
        super.clearGui();
        addressTo.setText("");
    }
    
    public JPanel setAddressTo() {
        JLabel label = new JLabel(JMeterUtils.getResString("smtp_to")); //$NON-NLS-1$
        addressTo = new JTextField(25);
        label.setLabelFor(addressTo);
        JPanel configPanel = new JPanel(new BorderLayout(5, 0));
        configPanel.add(label, BorderLayout.WEST);
        configPanel.add(addressTo, BorderLayout.CENTER);
        return configPanel;    	
    }
    
    
    public JPanel setAddressFromTo() {
    	JLabel label = new JLabel(JMeterUtils.getResString("smtp_from"));
    	addressFrom = new JTextField(25);
    	label.setLabelFor(addressFrom);
    	JPanel configPanel = new JPanel(new BorderLayout(5, 0));
    	configPanel.add(label, BorderLayout.WEST);
    	configPanel.add(addressFrom, BorderLayout.CENTER);
    	return configPanel;    	
    }
    
    public JPanel setAddressToCC() {
    	JLabel label = new JLabel(JMeterUtils.getResString("smtp_cc"));
    	addressToCC = new JTextField(25);
    	label.setLabelFor(addressToCC);
    	JPanel configPanel = new JPanel(new BorderLayout(5, 0));
    	configPanel.add(label, BorderLayout.WEST);
    	configPanel.add(addressToCC, BorderLayout.CENTER);
    	return configPanel; 	
    }
    
    public JPanel setAddressToBCC() {
    	JLabel label = new JLabel(JMeterUtils.getResString("smtp_bcc"));
    	addressToBCC = new JTextField(25);
    	label.setLabelFor(addressToBCC);
    	JPanel configPanel = new JPanel(new BorderLayout(5, 0));
    	configPanel.add(label, BorderLayout.WEST);
    	configPanel.add(addressToBCC, BorderLayout.CENTER);
    	return configPanel;    	
    }
    
    public JPanel setAddressReplyTo() {
    	JLabel label = new JLabel(JMeterUtils.getResString("smtp_replyto"));
    	addressReplyTo = new JTextField(25);
    	label.setLabelFor(addressReplyTo);
    	JPanel configPanel = new JPanel(new BorderLayout(5, 0));
    	configPanel.add(label, BorderLayout.WEST);
    	configPanel.add(addressReplyTo, BorderLayout.CENTER);
    	return configPanel;
    	
    }
    
    
    
    
    public JPanel setServerTo() {
    	JLabel label = new JLabel(JMeterUtils.getResString("smtp_server"));
    	server = new JTextField(10);
    	label.setLabelFor(server);
    	JPanel configPanel = new JPanel(new BorderLayout(5, 0));
    	configPanel.add(label, BorderLayout.WEST);
    	configPanel.add(server, BorderLayout.CENTER);
    	return configPanel;
    }
    
    public JPanel setServerPortTo() {
    	JLabel label = new JLabel(JMeterUtils.getResString("smtp_server_port"));
    	port = new JTextField(4);
    	label.setLabelFor(port);
    	JPanel configPanel = new JPanel(new BorderLayout(5, 0));
    	configPanel.add(label, BorderLayout.WEST);
    	configPanel.add(port, BorderLayout.CENTER);
    	return configPanel;
    }
}