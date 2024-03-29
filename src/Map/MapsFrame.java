package Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author asimsinanyuksel
 */
public class MapsFrame extends javax.swing.JFrame {
    private final MapsViewer mapview = new MapsViewer();
    private final Filter filter = new Filter(mapview);

    /**
     * Creates new form GoogleMapsFrame
     */
    public MapsFrame() {
        initComponents();
        mapview.setSize(mapsPanel.getSize());
        mapsPanel.add(mapview);
        mapview.loadMap("./Map/map.html");
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mapsPanel = new javax.swing.JPanel();
        addRandomMarkersButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        centerXTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        centerYTextField = new javax.swing.JTextField();
        removeAllMarkersButton = new javax.swing.JButton();
        Filter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        mapsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout mapsPanelLayout = new javax.swing.GroupLayout(mapsPanel);
        mapsPanel.setLayout(mapsPanelLayout);
        mapsPanelLayout.setHorizontalGroup(
            mapsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mapsPanelLayout.setVerticalGroup(
            mapsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
        );

        addRandomMarkersButton.setText("Добавить случайные точки");
        addRandomMarkersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRandomMarkersButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Ваша координата X:");

        centerXTextField.setEditable(false);
        centerXTextField.setText("55.10806033311338");

        jLabel4.setText("Ваша координата Y:");

        centerYTextField.setEditable(false);
        centerYTextField.setText("36.606742884436514");
        centerYTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                centerYTextFieldActionPerformed(evt);
            }
        });

        removeAllMarkersButton.setText("Убрать все точки");
        removeAllMarkersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllMarkersButtonActionPerformed(evt);
            }
        });

        Filter.setText("Фильтр");
        Filter.setActionCommand("FIlter");
        Filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(centerXTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(centerYTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(125, 125, 125)
                        .addComponent(addRandomMarkersButton)
                        .addGap(54, 54, 54)
                        .addComponent(removeAllMarkersButton, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                        .addGap(169, 169, 169)
                        .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mapsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mapsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(centerXTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addRandomMarkersButton)
                    .addComponent(removeAllMarkersButton)
                    .addComponent(Filter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(centerYTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addRandomMarkersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRandomMarkersButtonActionPerformed
        mapview.loadMarkerFromDb();
    }//GEN-LAST:event_addRandomMarkersButtonActionPerformed

    private void removeAllMarkersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAllMarkersButtonActionPerformed
       mapview.removeAllMarkers();  
    }//GEN-LAST:event_removeAllMarkersButtonActionPerformed

    private void centerYTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_centerYTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_centerYTextFieldActionPerformed

    private void FilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterActionPerformed
        filter.setVisible(true);
        filter.setAlwaysOnTop(true);
    }//GEN-LAST:event_FilterActionPerformed

    public void startload(String X, String Y)
    {
        centerXTextField.setText(X);
        centerYTextField.setText(Y);
        mapview.createUser(X, Y);
        mapview.loadMarkerFromDb();
    }
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
            java.util.logging.Logger.getLogger(MapsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MapsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MapsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MapsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MapsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Filter;
    private javax.swing.JButton addRandomMarkersButton;
    private javax.swing.JTextField centerXTextField;
    private javax.swing.JTextField centerYTextField;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel mapsPanel;
    private javax.swing.JButton removeAllMarkersButton;
    // End of variables declaration//GEN-END:variables
}
