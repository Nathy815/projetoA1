/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula09_geral.view;

import java.awt.Color;
import sd_aula09_geral.control.SD_Aula09_Control;

/**
 *
 * @author abdiel.cordeiro
 */
public class ControleHome extends javax.swing.JFrame {

    private static String controleSmart;
    private static String tempVol;
    private static SD_Aula09_Control controller = new SD_Aula09_Control();

    /**
     * Creates new form ControleHome
     */
    public ControleHome() {
        initComponents();
        lblVisor.setText("0");
        DisableEnableControls();
    }

    private void alteraCorBotao(String nome) {
        if (nome != null) {
            switch (nome) {
                case "aquecedor":
                    this.aquecedorAgua.setBackground(new java.awt.Color(0, 204, 255));
                    controleSmart = null;
                    break;
                case "Tv":
                    this.televisao.setBackground(new java.awt.Color(0, 204, 255));
                    controleSmart = null;
                    break;
                case "porta":
                    this.porta.setBackground(new java.awt.Color(0, 204, 255));
                    controleSmart = null;
                    break;
                case "luz":
                    this.luz.setBackground(new java.awt.Color(0, 204, 255));
                    controleSmart = null;
                    break;
                case "arCondicionado":
                    this.arCondicionado.setBackground(new java.awt.Color(0, 204, 255));
                    controleSmart = null;
                    break;
                case "volume":
                    this.volume.setBackground(new java.awt.Color(0, 204, 255));
                    tempVol = null;
                    break;
                case "temperatura":
                    this.temperatura.setBackground(new java.awt.Color(0, 204, 255));
                    tempVol = null;
                case "intensidade":
                    this.intensidade.setBackground(new java.awt.Color(0, 204, 255));
                    tempVol = null;
                    break;
                case "ventilador":
                    this.ventilador.setBackground(new java.awt.Color(0, 204, 255));
                    tempVol = null;
                    break;
                case "canal":
                    this.canal.setBackground(new java.awt.Color(0, 204, 255));
                    tempVol = null;
                    break;
                case "on":
                    this.btnOn.setBackground(new java.awt.Color(0, 204, 255));
                    tempVol = null;
                    break;
                case "off":
                    this.btnOff.setBackground(new java.awt.Color(0, 204, 255));
                    tempVol = null;
                    break;
            }
        }
        
        DisableEnableControls();
    }

    private void Digitar(String value)
    {
        String valorAtual = lblVisor.getText();
        
        if (value.equals("."))
        {
            if (!valorAtual.contains("."))
                lblVisor.setText(valorAtual + ".");
        }
        else
        {
            if (valorAtual.equals("0"))
                lblVisor.setText(value);
            else
                lblVisor.setText(valorAtual + value);
        }
    }
    
    private void RemoveSelectionOp()
    {
        String[] operacoes = new String[7];
        operacoes[0] = "on";
        operacoes[1] = "off";
        operacoes[2] = "ventilador";
        operacoes[3] = "canal";
        operacoes[4] = "volume";
        operacoes[5] = "intensidade";
        operacoes[6] = "temperatura";
        
        for (int i = 0; i < operacoes.length; i++)
            alteraCorBotao(operacoes[i]);
    }
    
    private void DisableEnableControls()
    {
        if (controleSmart == null)
        {
            DisableEnableTeclado(false);
            
            btnOn.setEnabled(false);
            btnOff.setEnabled(false);
            ventilador.setEnabled(false);
            canal.setEnabled(false);
            volume.setEnabled(false);
            intensidade.setEnabled(false);
            temperatura.setEnabled(false);
            bntDot.setEnabled(false);
        } 
        else
        {
            btnOn.setEnabled(true);
            btnOff.setEnabled(true);
            bntDot.setEnabled(false);
            if (tempVol != null && !tempVol.equals("off") && !tempVol.equals("on"))
                DisableEnableTeclado(true);
            else
            {
                DisableEnableTeclado(false);
                if (tempVol != null)
                    btnSend.setEnabled(true);
            }
                    
            switch(controleSmart)
            {
                case "luz":
                    ventilador.setEnabled(false);
                    canal.setEnabled(false);
                    volume.setEnabled(false);
                    intensidade.setEnabled(true);
                    temperatura.setEnabled(false);
                    bntDot.setEnabled(false);
                    break;
                case "arCondicionado":
                    ventilador.setEnabled(false);
                    canal.setEnabled(false);
                    volume.setEnabled(false);
                    intensidade.setEnabled(false);
                    temperatura.setEnabled(true);
                    if (tempVol != null && !tempVol.equals("off") && !tempVol.equals("on"))
                        bntDot.setEnabled(true);
                    break;
                case "Tv":
                    ventilador.setEnabled(false);
                    canal.setEnabled(true);
                    volume.setEnabled(true);
                    intensidade.setEnabled(false);
                    temperatura.setEnabled(false);
                    break;
                case "porta":
                    ventilador.setEnabled(false);
                    canal.setEnabled(false);
                    volume.setEnabled(false);
                    intensidade.setEnabled(false);
                    temperatura.setEnabled(false);
                    if (tempVol != null && tempVol.equals("on"))
                        DisableEnableTeclado(true);
                    break;
                case "aquecedor":
                    ventilador.setEnabled(true);
                    canal.setEnabled(false);
                    volume.setEnabled(false);
                    intensidade.setEnabled(false);
                    temperatura.setEnabled(true);
                    if (tempVol != null && !tempVol.equals("off") && !tempVol.equals("on"))
                        bntDot.setEnabled(true);
                    break;
            }
        }
    }
        
    private void DisableEnableTeclado(boolean enable)
    {
        btn0.setEnabled(enable);
        btn1.setEnabled(enable);
        btn2.setEnabled(enable);
        btn3.setEnabled(enable);
        btn4.setEnabled(enable);
        btn5.setEnabled(enable);
        btn6.setEnabled(enable);
        btn7.setEnabled(enable);
        btn8.setEnabled(enable);
        btn9.setEnabled(enable);
        bntBack.setEnabled(enable);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        luz = new javax.swing.JButton();
        arCondicionado = new javax.swing.JButton();
        porta = new javax.swing.JButton();
        televisao = new javax.swing.JButton();
        aquecedorAgua = new javax.swing.JButton();
        btnOn = new javax.swing.JButton();
        temperatura = new javax.swing.JButton();
        volume = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        bntDot = new javax.swing.JButton();
        bntBack = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btnSend = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblVisor = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        btnOff = new javax.swing.JButton();
        intensidade = new javax.swing.JButton();
        ventilador = new javax.swing.JButton();
        canal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        luz.setBackground(new java.awt.Color(0, 204, 255));
        luz.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        luz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sd_aula09_assets/Imagem/smart-light.png"))); // NOI18N
        luz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luzActionPerformed(evt);
            }
        });

        arCondicionado.setBackground(new java.awt.Color(0, 204, 255));
        arCondicionado.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        arCondicionado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sd_aula09_assets/Imagem/air-conditioner.png"))); // NOI18N
        arCondicionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arCondicionadoActionPerformed(evt);
            }
        });

        porta.setBackground(new java.awt.Color(0, 204, 255));
        porta.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        porta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sd_aula09_assets/Imagem/knob.png"))); // NOI18N
        porta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portaActionPerformed(evt);
            }
        });

        televisao.setBackground(new java.awt.Color(0, 204, 255));
        televisao.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        televisao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sd_aula09_assets/Imagem/smart-tv.png"))); // NOI18N
        televisao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                televisaoActionPerformed(evt);
            }
        });

        aquecedorAgua.setBackground(new java.awt.Color(0, 204, 255));
        aquecedorAgua.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        aquecedorAgua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sd_aula09_assets/Imagem/water-heater.png"))); // NOI18N
        aquecedorAgua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aquecedorAguaActionPerformed(evt);
            }
        });

        btnOn.setBackground(new java.awt.Color(0, 204, 255));
        btnOn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnOn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sd_aula09_assets/Imagem/stand-by.png"))); // NOI18N
        btnOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOnActionPerformed(evt);
            }
        });

        temperatura.setBackground(new java.awt.Color(0, 204, 255));
        temperatura.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        temperatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sd_aula09_assets/Imagem/thermometer.png"))); // NOI18N
        temperatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temperaturaActionPerformed(evt);
            }
        });

        volume.setBackground(new java.awt.Color(0, 204, 255));
        volume.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        volume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sd_aula09_assets/Imagem/speaker.png"))); // NOI18N
        volume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volumeActionPerformed(evt);
            }
        });

        btn2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn0.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });

        btn9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        bntDot.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bntDot.setText(".");
        bntDot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDotActionPerformed(evt);
            }
        });

        bntBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bntBack.setText("<");
        bntBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntBackActionPerformed(evt);
            }
        });

        btn8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btnSend.setBackground(new java.awt.Color(0, 204, 255));
        btnSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sd_aula09_assets/Imagem/plane.png"))); // NOI18N
        btnSend.setEnabled(false);
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        lblVisor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnOff.setBackground(new java.awt.Color(0, 204, 255));
        btnOff.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnOff.setText("Off/Fechar");
        btnOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOffActionPerformed(evt);
            }
        });

        intensidade.setBackground(new java.awt.Color(0, 204, 255));
        intensidade.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        intensidade.setText("Intensidade");
        intensidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intensidadeActionPerformed(evt);
            }
        });

        ventilador.setBackground(new java.awt.Color(0, 204, 255));
        ventilador.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        ventilador.setText("Ventilador");
        ventilador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventiladorActionPerformed(evt);
            }
        });

        canal.setBackground(new java.awt.Color(0, 204, 255));
        canal.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        canal.setText("Canal");
        canal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVisor, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(luz, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(arCondicionado, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(televisao, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(porta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(aquecedorAgua, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(volume, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(intensidade, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(temperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(bntDot, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bntBack, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnOff, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ventilador, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(canal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnOn)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(luz)
                    .addComponent(arCondicionado)
                    .addComponent(televisao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(porta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aquecedorAgua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVisor, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOff, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(canal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ventilador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(volume, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(temperatura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(intensidade, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntDot, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntBack, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void luzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luzActionPerformed

        if (controleSmart != null)
            alteraCorBotao(this.controleSmart);
        else {
            this.controleSmart = "luz";
            this.luz.setBackground(Color.yellow);
            lblInfo.setText("");
            RemoveSelectionOp();
            DisableEnableControls();
        }
    }//GEN-LAST:event_luzActionPerformed

    private void arCondicionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arCondicionadoActionPerformed

        if (controleSmart != null)
            alteraCorBotao(this.controleSmart);
        else {
            this.controleSmart = "arCondicionado";
            this.arCondicionado.setBackground(Color.yellow);
            lblInfo.setText("");
            RemoveSelectionOp();
            DisableEnableControls();
        }
    }//GEN-LAST:event_arCondicionadoActionPerformed

    private void portaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portaActionPerformed

        if (controleSmart != null)
            alteraCorBotao(this.controleSmart);
        else {
            this.controleSmart = "porta";
            this.porta.setBackground(Color.yellow);
            lblInfo.setText("");
            RemoveSelectionOp();
            DisableEnableControls();
        }
    }//GEN-LAST:event_portaActionPerformed

    private void televisaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_televisaoActionPerformed

        if (controleSmart != null)
            alteraCorBotao(this.controleSmart);
        else {
            this.controleSmart = "Tv";
            this.televisao.setBackground(Color.yellow);
            lblInfo.setText("");
            RemoveSelectionOp();
            DisableEnableControls();
        }
    }//GEN-LAST:event_televisaoActionPerformed

    private void aquecedorAguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aquecedorAguaActionPerformed

        if (controleSmart != null)
            alteraCorBotao(this.controleSmart);
        else {
            this.controleSmart = "aquecedor";
            this.aquecedorAgua.setBackground(Color.yellow);
            lblInfo.setText("");
            RemoveSelectionOp();
            DisableEnableControls();
        }
    }//GEN-LAST:event_aquecedorAguaActionPerformed

    private void btnOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOnActionPerformed
        if (tempVol != null)
            alteraCorBotao(this.tempVol);
        else {
            this.tempVol = "on";
            this.btnOn.setBackground(Color.yellow);
            DisableEnableControls();
        }
    }//GEN-LAST:event_btnOnActionPerformed

    private void bntDotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDotActionPerformed
        Digitar(".");
    }//GEN-LAST:event_bntDotActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        Digitar("0");
    }//GEN-LAST:event_btn0ActionPerformed

    private void bntBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntBackActionPerformed
        String valorAtual = lblVisor.getText();
        
        if (valorAtual.length() == 1)
            lblVisor.setText("0");
        else
            lblVisor.setText(valorAtual.substring(0, valorAtual.length() - 1));
    }//GEN-LAST:event_bntBackActionPerformed

    private void volumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volumeActionPerformed

        if (tempVol != null)
            alteraCorBotao(this.tempVol);
        else {
            this.tempVol = "volume";
            this.volume.setBackground(Color.yellow);
            DisableEnableControls();
        }
    }//GEN-LAST:event_volumeActionPerformed

    private void temperaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temperaturaActionPerformed

        if (tempVol != null)
            alteraCorBotao(this.tempVol);
        else {
            this.tempVol = "temperatura";
            this.temperatura.setBackground(Color.yellow);
            DisableEnableControls();
        }
    }//GEN-LAST:event_temperaturaActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed

        if (this.controleSmart != null) {
            switch (controleSmart) {
                case "luz":
                    if (this.tempVol == null)
                        lblInfo.setText("Selecione uma operação!");
                    if (this.tempVol.equals("on") || this.tempVol.equals("off"))
                    {
                        controller.SmartLight_TurnOffOn();
                        lblInfo.setText("Luzes (des)ligadas.");
                    }
                    else if (this.tempVol.equals("intensidade"))
                    {
                        int intensity = Integer.parseInt(lblVisor.getText());
                        controller.SmartLight_ChangeIntensity(intensity);
                        lblInfo.setText("Intesidade alterada para " + lblVisor.getText() + ".");
                    }
                    break;
                case "Tv":
                    if (tempVol == null)
                        lblInfo.setText("Selecione uma operação!");
                    else if (tempVol.equals("canal"))
                    {
                        int channel = Integer.parseInt(lblVisor.getText());
                        controller.SmartTV_Channel(channel);
                    }
                    else if (tempVol.equals("volume"))
                    {
                        int volume = Integer.parseInt(lblVisor.getText());
                        controller.SmartTV_Volume(volume);
                    }
                    else if (tempVol.equals("on") || tempVol.equals("off"))
                        controller.SmartTV_TurnOnOff();
                    break;
                case "arCondicionado":
                    if (tempVol == null) {
                        lblInfo.setText("Selecione uma operação!");
                    } else if (tempVol.equals("ventilador")) {
                        controller.SmartAr_TurnOnOffWind();
                    }
                    else if (tempVol.equals("temperatura")) {
                        float temp = Float.parseFloat(lblVisor.getText());
                        controller.SmartAr_ChangeTempeture(temp);
                    }
                    else if (tempVol.equals("on") || tempVol.equals("off"))
                        controller.SmartAr_TurnOnOff();
                    break;
                case "aquecedor":
                    if (this.tempVol == null)
                        lblInfo.setText("Selecione uma operação!");
                    else if (tempVol.equals("on") || tempVol.equals("off"))
                    {
                        controller.SmartAquecedor_TurnOffOn();
                        lblInfo.setText("Aquecedor (des)ligado.");
                    }
                    else if (this.tempVol.equals("temperatura"))
                    {
                        float temp = Float.parseFloat(lblVisor.getText());
                        controller.SmartAquecedor_ChangeTemperature(temp);
                        lblInfo.setText("Temperatura alterada para " + lblVisor.getText() + ".");
                    }   
                    break;
                case "porta":
                    if (this.tempVol == null)
                       lblInfo.setText("Selecione uma operação!");
                    else if (this.tempVol.equals("on"))
                    {
                        boolean result = controller.SmartDoor_Open(lblVisor.getText());
                        if (!result)
                            lblInfo.setText("Senha incorreta.");
                        else
                            lblInfo.setText("Porta aberta.");
                    }
                    else if (this.tempVol.equals("off"))
                    {
                        controller.SmartDoor_Close();
                        lblInfo.setText("Porta fechada.");
                    }
                    break;
            }
            
            lblVisor.setText("0");
            alteraCorBotao(this.tempVol);
            alteraCorBotao(this.controleSmart);
            this.bntDot.setBackground(new java.awt.Color(0, 204, 255));
            this.bntBack.setBackground(new java.awt.Color(0, 204, 255));
        } else {
            lblInfo.setText("Selecione um Smart!");
        }

    }//GEN-LAST:event_btnSendActionPerformed

    private void btnOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOffActionPerformed
        if (tempVol != null)
            alteraCorBotao(this.tempVol);
        else {
            this.tempVol = "off";
            this.btnOff.setBackground(Color.yellow);
            DisableEnableControls();
        }
    }//GEN-LAST:event_btnOffActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        Digitar("1");
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        Digitar("2");
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        Digitar("3");
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        Digitar("4");
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        Digitar("5");
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        Digitar("6");
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        Digitar("7");
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        Digitar("8");
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        Digitar("9");
    }//GEN-LAST:event_btn9ActionPerformed

    private void intensidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intensidadeActionPerformed
        if (tempVol != null)
            alteraCorBotao(this.tempVol);
        else {
            this.tempVol = "intensidade";
            this.intensidade.setBackground(Color.yellow);
            DisableEnableControls();
        }
    }//GEN-LAST:event_intensidadeActionPerformed

    private void ventiladorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventiladorActionPerformed
        if (tempVol != null)
            alteraCorBotao(this.tempVol);
        else {
            this.tempVol = "ventilador";
            this.ventilador.setBackground(Color.yellow);
            DisableEnableControls();
        }
    }//GEN-LAST:event_ventiladorActionPerformed

    private void canalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canalActionPerformed
        if (tempVol != null)
            alteraCorBotao(this.tempVol);
        else {
            this.tempVol = "canal";
            this.canal.setBackground(Color.yellow);
            DisableEnableControls();
        }
    }//GEN-LAST:event_canalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControleHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleHome().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aquecedorAgua;
    private javax.swing.JButton arCondicionado;
    private javax.swing.JButton bntBack;
    private javax.swing.JButton bntDot;
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnOff;
    private javax.swing.JButton btnOn;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton canal;
    private javax.swing.JButton intensidade;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblVisor;
    private javax.swing.JButton luz;
    private javax.swing.JButton porta;
    private javax.swing.JButton televisao;
    private javax.swing.JButton temperatura;
    private javax.swing.JButton ventilador;
    private javax.swing.JButton volume;
    // End of variables declaration//GEN-END:variables
}
