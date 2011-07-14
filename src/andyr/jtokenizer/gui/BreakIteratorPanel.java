package andyr.jtokenizer.gui;

/**
 *
 * @author Andrew Roberts
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author  Andy Roberts
 */
public class BreakIteratorPanel extends javax.swing.JPanel {
    
    private Map<String, Locale> localeMap = new HashMap<String, Locale>();
    
    /** Creates new form BreakIteratorPanel */
    public BreakIteratorPanel() {
        initComponents();
    }
    
    public Locale getSelectedLocale() {
        return localeMap.get((String)cboLocales.getSelectedItem());
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        lblLocale = new javax.swing.JLabel();
        Vector<String> localeDisplay = new Vector<String>();

        Locale[] locales = Locale.getAvailableLocales();

        for (int i = 0; i < locales.length; i++) {
            localeDisplay.add(locales[i].getDisplayName());
            localeMap.put(locales[i].getDisplayName(), locales[i]);
        }
        Collections.sort(localeDisplay);
        cboLocales = new javax.swing.JComboBox();

        lblLocale.setText("Locale");

        cboLocales.setModel(new DefaultComboBoxModel(localeDisplay));
        cboLocales.setSelectedItem(Locale.getDefault().getDisplayName());

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(lblLocale)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cboLocales, 0, 344, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblLocale)
                    .add(cboLocales, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(267, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboLocales;
    private javax.swing.JLabel lblLocale;
    // End of variables declaration//GEN-END:variables
    
}
