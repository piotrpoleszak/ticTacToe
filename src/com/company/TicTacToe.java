package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener
{
    Random rnd = new Random();
    JFrame jf = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel txtField = new JLabel();
    JButton[] bttns = new JButton[9];
    boolean plOneTurn;

    TicTacToe()
    {
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(800,800);
        jf.getContentPane().setBackground(new Color(50,50,50));
        jf.setLayout(new BorderLayout());
        jf.setVisible(true);

        txtField.setBackground(new Color(30,30,30));
        txtField.setForeground(new Color(0,0,255));
        txtField.setFont(new Font("Helvetica font", Font.BOLD,75));
        txtField.setHorizontalAlignment(JLabel.CENTER);
        txtField.setText("Tic-Tac-Toe");
        txtField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,800,100);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(35,35,35));

        for (int i = 0; i < 9; i++)
        {
            bttns[i] = new JButton();
            buttonPanel.add(bttns[i]);
            bttns[i].setFont(new Font("Helvetica font", Font.BOLD,120));
            bttns[i].setFocusable(false);
            bttns[i].addActionListener(this);
        }

        titlePanel.add(txtField);
        jf.add(titlePanel, BorderLayout.NORTH);
        jf.add(buttonPanel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (int i = 0; i < 9; i++)
        {
            if  (e.getSource() == bttns[i])
            {
                if (plOneTurn)
                {
                    if (bttns[i].getText().equals(""))
                    {
                        bttns[i].setForeground(new Color(255, 0, 0));
                        bttns[i].setText("X");
                        plOneTurn = false;
                        txtField.setText("O turn");
                        check();
                    }
                }
                else
                {
                    if (bttns[i].getText().equals(""))
                    {
                        bttns[i].setForeground(new Color(0, 0, 255));
                        bttns[i].setText("O");
                        plOneTurn = true;
                        txtField.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn()
    {
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        if  (rnd.nextInt(2) == 0)
        {
            plOneTurn = true;
            txtField.setText("X turn");
        }
        else
        {
            plOneTurn = false;
            txtField.setText("O turn");
        }
    }

    public void check()
    {
        //check X wins
        if ((bttns[0].getText().equals("X")) && (bttns[1].getText().equals("X")) && (bttns[2].getText().equals("X")))
        {
            xWins(0,1,2);
        }
        else if ((bttns[3].getText().equals("X")) && (bttns[4].getText().equals("X")) && (bttns[5].getText().equals("X")))
        {
            xWins(3,4,5);
        }
        else if ((bttns[6].getText().equals("X")) && (bttns[7].getText().equals("X")) && (bttns[8].getText().equals("X")))
        {
            xWins(6,7,8);
        }
        else if ((bttns[0].getText().equals("X")) && (bttns[3].getText().equals("X")) && (bttns[6].getText().equals("X")))
        {
            xWins(0,3,6);
        }
        else if ((bttns[1].getText().equals("X")) && (bttns[4].getText().equals("X")) && (bttns[7].getText().equals("X")))
        {
            xWins(1,4,7);
        }
        else if ((bttns[2].getText().equals("X")) && (bttns[5].getText().equals("X")) && (bttns[8].getText().equals("X")))
        {
            xWins(2,5,8);
        }
        else if ((bttns[0].getText().equals("X")) && (bttns[4].getText().equals("X")) && (bttns[8].getText().equals("X")))
        {
            xWins(0,4,8);
        }
        else if ((bttns[2].getText().equals("X")) && (bttns[4].getText().equals("X")) && (bttns[6].getText().equals("X")))
        {
            xWins(2,4,6);
        }

        //check O wins
        else if ((bttns[0].getText().equals("O")) && (bttns[1].getText().equals("O")) && (bttns[2].getText().equals("O")))
        {
            oWins(0,1,2);
        }
        else if ((bttns[3].getText().equals("O")) && (bttns[4].getText().equals("O")) && (bttns[5].getText().equals("O")))
        {
            oWins(3,4,5);
        }
        else if ((bttns[6].getText().equals("O")) && (bttns[7].getText().equals("O")) && (bttns[8].getText().equals("O")))
        {
            oWins(6,7,8);
        }
        else if ((bttns[0].getText().equals("O")) && (bttns[3].getText().equals("O")) && (bttns[6].getText().equals("O")))
        {
            oWins(0,3,6);
        }
        else if ((bttns[1].getText().equals("O")) && (bttns[4].getText().equals("O")) && (bttns[7].getText().equals("O")))
        {
            oWins(1,4,7);
        }
        else if ((bttns[2].getText().equals("O")) && (bttns[5].getText().equals("O")) && (bttns[8].getText().equals("O")))
        {
            oWins(2,5,8);
        }
        else if ((bttns[0].getText().equals("O")) && (bttns[4].getText().equals("O")) && (bttns[8].getText().equals("O")))
        {
            oWins(0,4,8);
        }
        else if ((bttns[2].getText().equals("O")) && (bttns[4].getText().equals("O")) && (bttns[6].getText().equals("O")))
        {
            oWins(2,4,6);
        }
    }

    public void xWins(int a, int b, int c)
    {
        bttns[a].setBackground(Color.GREEN);
        bttns[b].setBackground(Color.GREEN);
        bttns[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++)
        {
            bttns[i].setEnabled(false);
        }

        txtField.setText("X wins");
    }

    public void oWins(int a, int b, int c)
    {
        bttns[a].setBackground(Color.GREEN);
        bttns[b].setBackground(Color.GREEN);
        bttns[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++)
        {
            bttns[i].setEnabled(false);
        }

        txtField.setText("O wins");
    }
}