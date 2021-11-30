package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUI_Presentacion extends JFrame {
    //Atributos
    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones,panelDatos;
    private Titulos titulo;
    private JLabel labelImage;
    private JTextArea texto;
    private Escucha escucha;
    //Metodos
    public GUI_Presentacion() {
        initGUI();
        //Configuracion base de la ventana
        this.setTitle("MiPresentacion");
        this.setSize(1280,800);
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Definir container y layout del JFrame
        //Crear objetos escucha y control
        escucha = new Escucha();
        //Configurar JComponents
        titulo = new Titulos("Hola",Color.BLACK);
        this.add(titulo,BorderLayout.NORTH);

        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null,"Un poco mas de mi",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font("Calibri", Font.PLAIN,20),Color.BLACK));
        this.add(panelDatos, BorderLayout.CENTER);

        miFoto = new JButton("Este soy yo");
        miFoto.addMouseListener(escucha);
        miFoto.addKeyListener(escucha);
        miHobby = new JButton("Mis Hobbies");
        miHobby.addMouseListener(escucha);
        miHobby.addKeyListener(escucha);
        misExpectativas = new JButton("Mis expectativas");
        misExpectativas.addKeyListener(escucha);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);
        panelBotones.addKeyListener(escucha);
        panelBotones.setFocusable(true);
        this.add(panelBotones, BorderLayout.SOUTH);

        labelImage = new JLabel();
        texto = new JTextArea(10, 20);
        texto.setEditable(false);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
                public void run() {
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();

            }
        });
    }

    private class Escucha extends MouseAdapter implements KeyListener{
        private ImageIcon image;
        @Override
        public void mouseClicked(MouseEvent e) {
            panelDatos.removeAll();
            if(e.getSource() == miFoto){
                image = new ImageIcon(getClass().getResource("/recursos/imagen1.png"));
                labelImage.setIcon(image);
                panelDatos.add(labelImage);
                texto.setText("Soy una persona timida, al igual que los erizos,\n" +
                        "por eso me gustan mucho.");
                texto.setBackground(Color.GRAY);
                panelDatos.add(texto);
            }else{
                if(e.getSource() == miHobby && e.getClickCount() == 2){
                    image = new ImageIcon(getClass().getResource("/recursos/imagen2.jfif"));
                    labelImage.setIcon(image);
                    panelDatos.add(labelImage);
                    texto.setText("Me gusta mucho ver anime, especialmente\n" +
                            "animes de romance");
                    texto.setBackground(Color.GRAY);
                    panelDatos.add(texto);
                }
            }
            revalidate();
            repaint();
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            panelDatos.removeAll();
            if(e.getKeyChar() == KeyEvent.VK_M){
                texto.setText("Hay muchas cosas que no se... pero aun asi\n" +
                        "espero aprender poco a poco para poder aplicar\n" +
                        "esos conocimientos en cosas que me gusten.");
                texto.setBackground(null);
                panelDatos.add(texto);
            }
            revalidate();
            repaint();

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}


