package tictactoepackage;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class tictactoe implements ActionListener {
    Random rand=new Random();
    JFrame jFrame=new JFrame();
    JPanel titlejPanel=new JPanel();
    JPanel jbuttonPanel=new JPanel();
    JLabel textfield=new JLabel();
    JButton [] buttons=new JButton[9];
    boolean player1_turn;
    tictactoe(){
        jFrame.setTitle("Tic-Tac-Toe");
        jFrame.setSize(800,800);
        jFrame.setBounds(10,50,800,700);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().setBackground(new Color(50,50,50));
        jFrame.setLayout(new BorderLayout());
        jFrame.setVisible(true);

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,65));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);


        titlejPanel.setLayout(new BorderLayout());
        titlejPanel.setBounds(3,10,800,100);
        titlejPanel.add(textfield);
        jFrame.add(titlejPanel,BorderLayout.NORTH);

        jbuttonPanel.setLayout(new GridLayout(3,3));
        jbuttonPanel.setBackground(new Color(0x0B34EA));
        jFrame.add(jbuttonPanel);

        for (int i=0;i<9;i++){
            buttons[i]=new JButton();
            jbuttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        firstTurn();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++){
            if (e.getSource()==buttons[i]){
                if (player1_turn){
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255, 0, 0, 216));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textfield.setText("O turn");
                        textfield.setForeground(Color.GREEN);
                        check();
                    }
                }else {
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,255,0));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textfield.setText("X turn");
                        textfield.setForeground(Color.RED);
                        check();
                    }
                }
            }
        }

    }
    public  void firstTurn()  {
        try {
            Thread.sleep(400);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (rand.nextInt(2)==0){
            player1_turn=true;
            textfield.setText("X turn");
        } else {
            player1_turn=false;
            textfield.setText("O turn");
        }
    }
    public void check(){
        //checks X condition;
       if(      (buttons[0].getText()=="X") &&
                (buttons[1].getText()=="X") &&
                (buttons[2].getText()=="X"))
                {Xwins(0,1,2);}
       else if( (buttons[3].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[5].getText()=="X"))
                {Xwins(3,4,5);}
       else if( (buttons[6].getText()=="X") &&
                (buttons[7].getText()=="X") &&
                (buttons[8].getText()=="X"))
                 {Xwins(6,7,8);}
       else if( (buttons[0].getText()=="X") &&
                (buttons[3].getText()=="X") &&
                (buttons[6].getText()=="X"))
                 {Xwins(0,3,6);}
       else if( (buttons[1].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[7].getText()=="X"))
                {Xwins(1,4,7);}
       else if( (buttons[2].getText()=="X") &&
                (buttons[5].getText()=="X") &&
                (buttons[8].getText()=="X"))
                 {Xwins(2,5,8);}
       else if( (buttons[0].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[8].getText()=="X"))
                 {Xwins(0,4,8);}
       else if( (buttons[2].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[6].getText()=="X"))
                 {Xwins(2,4,6);}
        //check O condition
       else if( (buttons[0].getText()=="O") &&
                (buttons[1].getText()=="O") &&
                (buttons[2].getText()=="O"))
                 {Owins(0,1,2);}
       else if( (buttons[3].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[5].getText()=="O"))
                 {Owins(3,4,5);}
       else if( (buttons[6].getText()=="O") &&
                (buttons[7].getText()=="O") &&
                (buttons[8].getText()=="O"))
                 {Owins(6,7,8);}
       else if( (buttons[0].getText()=="O") &&
                (buttons[3].getText()=="O") &&
                (buttons[6].getText()=="O"))
                 {Owins(0,3,6);}
       else if( (buttons[1].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[7].getText()=="O"))
                {Owins(1,4,7);}
       else if( (buttons[2].getText()=="O") &&
                (buttons[5].getText()=="O") &&
                (buttons[8].getText()=="O"))
                 {Owins(2,5,8);}
       else  if( (buttons[0].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[8].getText()=="O"))
                {Owins(0,4,8);}
       else if( (buttons[2].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[6].getText()=="O"))
                {Owins(2,4,6);}
            //checks draw
       else if((buttons[0].getText()!="")&&
               (buttons[1].getText()!="")&&
               (buttons[2].getText()!="")&&
               (buttons[3].getText()!="")&&
               (buttons[4].getText()!="")&&
               (buttons[5].getText()!="")&&
               (buttons[6].getText()!="")&&
               (buttons[7].getText()!="")&&
               (buttons[8].getText()!=""))
                {Draw();}
    }
    public  void  Xwins(int a,int b,int c){
        JFrame xwins=new JFrame("X-wins");
        xwins.setBounds(820,120,520,300);
        xwins.getContentPane().setBackground(new Color(255,153,153));
        xwins.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        xwins.setVisible(true);

        JLabel jl=new JLabel(" X-wins");

        jl.setFont(new Font("MV Boli",Font.BOLD, 120));
        jl.setBounds(15,5,25,10);
        jl.setForeground(new Color(255,0,0));
        xwins.add(jl);

        buttons[a].setBackground(Color.RED);
        buttons[b].setBackground(Color.RED);
        buttons[c].setBackground(Color.RED);
        for (int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X-wins");
        textfield.setForeground(Color.RED);
        jFrame.setTitle("X-wins");
    }
    public void Owins(int a,int b,int c){
        JFrame owins=new JFrame("O-wins");
        owins.setBounds(820,120,520,300);
        owins.getContentPane().setBackground(new Color(152,255,152));
        owins.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        owins.setVisible(true);

        JLabel jl=new JLabel(" O-wins");
        jl.setFont(new Font("MV Boli",Font.BOLD, 120));
        jl.setBounds(5,2,25,10);
        jl.setForeground(Color.GREEN);
        owins.add(jl);

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("O-wins");
        textfield.setForeground(Color.GREEN);
        jFrame.setTitle("O-wins");
    }
    public  void  Draw(){
        JFrame draw=new JFrame("Draw");
        draw.setBounds(820,120,520,300);
        draw.getContentPane().setBackground(new Color(255,255,190));
        draw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        draw.setVisible(true);

        JLabel jl=new JLabel("  Draw");

        jl.setFont(new Font("MV Boli",Font.BOLD, 120));
        jl.setBounds(5,5,25,10);
        jl.setForeground(new Color(255,255,0));
        draw.add(jl);


        for (int j=0;j<9;j++){
            buttons[j].setBackground(new Color(255,255,0));
            buttons[j].setEnabled(false);
        }
        textfield.setText("Draw");
        textfield.setForeground(new Color(255,255,0));
        jFrame.setTitle("Draw");
    }
    }



