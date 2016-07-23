package com.shiyanlou.fileeditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FileEditor extends JFrame{
	private JTextField _pathsel;
	private JButton _btnBrowse;
	JTextArea editArea;
	private JButton saveBtn;
	
	public FileEditor(){
		this.init();
	}
	
	private void init(){
		this.setTitle("Editor");
		
		this.setBounds(300, 500, 600, 650);
		
		_pathsel = new JTextField(40);
		
		_btnBrowse = new JButton("Browse");
		
		_btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				FileDialog fd = new FileDialog(FileEditor.this, "Open File");
				fd.setMode(FileDialog.LOAD);
				fd.setVisible(true);
				String fileName = fd.getFile();
				String dir = fd.getDirectory();
				_pathsel.setText(dir + File.separator + fileName);
				openDirOrFile(dir + File.separator + fileName);
			}
		});
		
		JPanel upPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		upPanel.setBackground(Color.CYAN);
		upPanel.add(_pathsel);
		upPanel.add(_btnBrowse);
		this.add(upPanel, BorderLayout.NORTH);
		editArea = new JTextArea();
		ScrollPane scollPanel = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
		scollPanel.add(editArea);
		this.add(scollPanel, BorderLayout.CENTER);
		
		saveBtn = new JButton("save");
		saveBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				saveFile();
			}
		});
		
		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.green);
		southPanel.add(saveBtn);
		this.add(southPanel, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void openDirOrFile(String absolutePath) {
		// TODO Auto-generated method stub
		File file = new File(absolutePath);
		if (!file.exists()){
			editArea.setText("The file does not exist!");
		}
		else if(file.isDirectory()){
			editArea.setText(null);
			//showDir(file);
		}
		else if(file.isFile()){
			try{
				FileInputStream fis = new FileInputStream(file);
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));
				String str = null;
				editArea.setText(null);
				while((str = br.readLine()) != null){
					editArea.append(str + "\r\n");
				}
				br.close();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
	}

	private void saveFile() {
		// TODO Auto-generated method stub
		FileDialog fd = new FileDialog(this, "Save File");
		fd.setFile("untitled.txt");
		fd.setMode(FileDialog.SAVE);
		fd.setVisible(true);
		String fileName = fd.getFile();
		String dir = fd.getDirectory();
		File newFile = new File(dir + File.separator + fileName);
		PrintWriter pw = null;
		try{
			pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(newFile)));
			String str = editArea.getText();
			pw.println(str);
			pw.flush();
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}
	
	

	public static void main(String[] args)
	{
		new FileEditor();
	}
}
