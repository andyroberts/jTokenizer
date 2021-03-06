package andyr.jtokenizer.gui;

/**
 *
 * @author  Andrew Roberts
 */
public class RegexTokeniserPanel extends javax.swing.JPanel {
    
    /** Creates new form RegexTokeniser */
    public RegexTokeniserPanel() {
        initComponents();
    }
    
    public String getRegex() {
        return txtRegex.getText();
    }
    
    public boolean isKeepDelim() {
        return chkKeepDelim.isSelected();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        lblRegex = new javax.swing.JLabel();
        txtRegex = new javax.swing.JTextField();
        chkKeepDelim = new javax.swing.JCheckBox();
        lblKeepDelim = new javax.swing.JLabel();

        lblRegex.setText("Regular expression");

        txtRegex.setText("\\S+");

        chkKeepDelim.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        chkKeepDelim.setMargin(new java.awt.Insets(0, 0, 0, 0));

        lblKeepDelim.setText("Keep delimiter");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblRegex)
                    .add(lblKeepDelim))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(chkKeepDelim)
                    .add(txtRegex, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblRegex)
                    .add(txtRegex, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(chkKeepDelim)
                    .add(lblKeepDelim))
                .addContainerGap(250, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkKeepDelim;
    private javax.swing.JLabel lblKeepDelim;
    private javax.swing.JLabel lblRegex;
    private javax.swing.JTextField txtRegex;
    // End of variables declaration//GEN-END:variables
    
}
