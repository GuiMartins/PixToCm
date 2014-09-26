
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class MainFrame extends javax.swing.JFrame {
    private static final double POLEGADA = 2.54;
    private String link = "https://www.youtube.com/watch?v=MGWeUg7P0tw";
    
    public MainFrame() {
        super.setLocationRelativeTo(null);
        initComponents();
        resultadoLabel.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        larguraLabel = new javax.swing.JLabel();
        larguraText = new javax.swing.JTextField();
        resultadoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        mainPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        mainPanel.setName("mainPanel"); // NOI18N

        larguraLabel.setText("Largura da tela (cm):");
        larguraLabel.setName("larguraLabel"); // NOI18N
        larguraLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                larguraLabelMouseClicked(evt);
            }
        });

        larguraText.setColumns(2);
        larguraText.setName("larguraText"); // NOI18N
        larguraText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                larguraTextKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(larguraLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(larguraText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(larguraLabel)
                    .addComponent(larguraText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        resultadoLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        resultadoLabel.setText("resultado");
        resultadoLabel.setName("resultadoLabel"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(resultadoLabel)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resultadoLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void larguraTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_larguraTextKeyPressed
        larguraText.addKeyListener
                (
                    new KeyAdapter()
                    {
                        @Override
                        public void keyPressed(KeyEvent e)
                        {
                            int key = e.getKeyCode();
                            if(key == KeyEvent.VK_ENTER)
                            {
                               int screenSize = getScreenResolution();
                               double resp = screenSize/(Integer.parseInt(larguraText.getText())*POLEGADA);
                               resultadoLabel.setText(String.format("%.2f cm", resp));
                               resultadoLabel.setVisible(true);
                            }
                        }
                    }
                );
    }//GEN-LAST:event_larguraTextKeyPressed

    private void larguraLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_larguraLabelMouseClicked
        URL url = null;
        try {
            url = new URL(link);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        openWebpage(url);
        
    }//GEN-LAST:event_larguraLabelMouseClicked
    
    public static void openWebpage(URI uri)
    {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE))
        {
            try
            {
                desktop.browse(uri);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void openWebpage(URL url)
    {
        try
        {
            openWebpage(url.toURI());
        }
        catch (URISyntaxException e)
        {
            e.printStackTrace();
        }
    }
    
    private int getScreenResolution()
    {
        //size of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return (screenSize.width);
    }
    
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel larguraLabel;
    private javax.swing.JTextField larguraText;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel resultadoLabel;
    // End of variables declaration//GEN-END:variables
}
