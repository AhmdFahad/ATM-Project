package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame {

	int money = 0;
	int i;
	JFrame frame;
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JLabel lbl;
	JLabel lb2;
	JLabel lb3;

	public Frame() {

		frame = new JFrame("ATM");
		btn1 = new JButton("INFO");
		btn2 = new JButton("DEPOSIT");
		btn3 = new JButton("Withdraw");
		btn4 = new JButton("Exit");
		JFormattedTextField in = new JFormattedTextField();

		lbl = new JLabel(
				"<html><head><link href=\"https://fonts.googleapis.com/css2?family=Open+Sans&display=swap\" rel=\"stylesheet\">"
						+ "</head><span style='font-size:30px;color: White;font-family: 'Open Sans', sans-serif;'>"
						+ "Welcome to Atm" + "</span></html>");
		lb2 = new JLabel("You Cant not input String just int");
		lb3 = new JLabel();

		lbl.setBounds(250, 0, 350, 200);
		lb2.setBounds(250, 150, 250, 50);
		lb3.setBounds(250, 300, 250, 50);

		lb2.setForeground(Color.white);
		lb3.setForeground(new Color(204, 204, 204));

		in.setBounds(250, 200, 250, 50);
		in.setEditable(false);
		in.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				char c = ke.getKeyChar();
				if (Character.isLetter(c)) {
					in.setEditable(false);
					lb2.setText("You can not input text");
				} else {
					in.setEditable(true);
					lb2.setText("You Cant not input String just int");
				}

			}
		});

		btn1.setBounds(250, 350, 250, 50);
		btn2.setBounds(250, 450, 250, 50);
		btn3.setBounds(250, 550, 250, 50);
		btn4.setBounds(250, 650, 250, 50);

		btn1.setBackground(new Color(0, 139, 139));
		btn2.setBackground(new Color(0, 139, 139));
		btn3.setBackground(new Color(0, 139, 139));
		btn4.setBackground(Color.white);
		btn1.setForeground(Color.white);
		btn2.setForeground(Color.white);
		btn3.setForeground(Color.white);
		btn4.setForeground(new Color(0, 139, 139));

		btn1.setLayout(null);
		btn2.setLayout(null);
		btn3.setLayout(null);
		btn4.setLayout(null);

		frame.getContentPane().setBackground(new Color(47, 79, 79));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(800, 800);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);
		frame.add(btn4);

		frame.add(in);

		frame.add(lbl);
		frame.add(lb2);
		frame.add(lb3);

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lb3.setText("You Have =" + money + "$");

			}

		});
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (i >= 0) {
					i = Integer.parseInt(in.getText());
					money = i + money;
					lb3.setText("You deposit =" + i + "$");
				} else {
					lb3.setText("you can not deposit ");

				}
			}
		});
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				i = Integer.parseInt(in.getText());
				if (i <= money) {
					money = i - money;
					lb3.setText("you Withdraw" + i + "$");
				} else {
					lb3.setText("You dont hava money ");
				}

			}
		});
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

	}

}
