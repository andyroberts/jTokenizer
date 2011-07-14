package andyr.jtokenizer.gui;

import andyr.jtokenizer.BreakIteratorTokenizer;
import andyr.jtokenizer.RegexSeparatorTokenizer;
import andyr.jtokenizer.RegexTokenizer;
import andyr.jtokenizer.SentenceTokenizer;
import andyr.jtokenizer.StringTokenizer;
import andyr.jtokenizer.Tokenizer;
import andyr.jtokenizer.WhiteSpaceTokenizer;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author  Andrew Roberts
 */
public class jTokeniser extends javax.swing.JFrame {
    
    private BreakIteratorPanel breakIteratorPanel;
    private RegexSeparatorPanel regexSeparatorPanel;
    private RegexTokeniserPanel regexPanel;
    private StringTokeniserPanel stringTokeniserPanel;
    private WhiteSpacePanel whiteSpacePanel;
    private SentencePanel sentencePanel;
    private AnnotateTokenPanel annotateTokenPanel;
    
    private FileDialog dlgOpenDialog;
    private FileDialog dlgSaveDialog;
    
    private Map<String, String> fileEncodings;
        
    /** Creates new form jTokeniser */
    public jTokeniser() {
        // Get the native look and feel class name
        String nativeLF = UIManager.getSystemLookAndFeelClassName();
        //System.out.println("Native laf: " + nativeLF);
        if (nativeLF.equals("com.sun.java.swing.plaf.motif.MotifLookAndFeel")) {
            nativeLF = UIManager.getCrossPlatformLookAndFeelClassName();
        }
    
        // Install the look and feel
        try {
            UIManager.setLookAndFeel(nativeLF);
        } catch (InstantiationException e) {
        } catch (ClassNotFoundException e) {
        } catch (UnsupportedLookAndFeelException e) {
        } catch (IllegalAccessException e) {
        }
        
        breakIteratorPanel = new BreakIteratorPanel();
        regexSeparatorPanel = new RegexSeparatorPanel();
        regexPanel = new RegexTokeniserPanel();
        stringTokeniserPanel = new StringTokeniserPanel();
        whiteSpacePanel = new WhiteSpacePanel();
        sentencePanel = new SentencePanel();
        
        annotateTokenPanel = new AnnotateTokenPanel();
        
        initComponents();
    }
    
    private FileDialog getOpenDialog() {
        if (dlgOpenDialog == null) {
            dlgOpenDialog = new FileDialog(this, true, FileDialog.OPEN, getAvailableEncodings());
            
        }
        
        return dlgOpenDialog;
    }
    
    private FileDialog getSaveDialog() {
        if (dlgSaveDialog == null) {
            dlgSaveDialog = new FileDialog(this, false, FileDialog.SAVE, getAvailableEncodings());
            
        }
        
        return dlgSaveDialog;
    }
    
    private Map<String, String> getAvailableEncodings() {
        if (fileEncodings == null) {
            fileEncodings = new HashMap<String,String>();
            fileEncodings.put("Big5","Big5 (Traditional Chinese)");
            fileEncodings.put("Big5-HKSCS","Big5-HKSCS (Traditional Chinese with Hong Kong extensions)");
            fileEncodings.put("EUC-JP","EUC-JP (Japanese)");
            fileEncodings.put("EUC-KR","EUC-KR (Korean)");
            fileEncodings.put("GB18030","GB18030 (Simplified Chinese)");
            fileEncodings.put("GBK","GBK (Simplified Chinese)");
            fileEncodings.put("ISCII91","ISCII91 (Indic scripts)");
            fileEncodings.put("ISO-2022-JP","ISO-2022-JP (Japanese)");
            fileEncodings.put("ISO-2022-KR","ISO-2022-KR (Korean)");
            fileEncodings.put("ISO-8859-1","ISO-8859-1 (Western)");
            fileEncodings.put("ISO-8859-13","ISO-8859-13 (Baltic)");
            fileEncodings.put("ISO-8859-15","ISO-8859-15 (Western)");
            fileEncodings.put("ISO-8859-2","ISO-8859-2 (Central European)");
            fileEncodings.put("ISO-8859-3","ISO-8859-3 (Southern European)");
            fileEncodings.put("ISO-8859-4","ISO-8859-4 (Baltic)");
            fileEncodings.put("ISO-8859-5","ISO-8859-5 (Cyrillic)");
            fileEncodings.put("ISO-8859-6","ISO-8859-6 (Arabic)");
            fileEncodings.put("ISO-8859-7","ISO-8859-7 (Greek)");
            fileEncodings.put("ISO-8859-8","ISO-8859-8 (Hebrew)");
            fileEncodings.put("ISO-8859-9","ISO-8859-9 (Turkish)");
            fileEncodings.put("KOI8-R","KOI8-R (Russian)");
            fileEncodings.put("MacArabic","MacArabic (Arabic)");
            fileEncodings.put("MacCentralEurope","MacCentralEurope (Central European)");
            fileEncodings.put("MacCroatian","MacCroatian (Croatian)");
            fileEncodings.put("MacCyrillic","MacCyrillic (Cyrillic)");
            fileEncodings.put("MacGreek","MacGreek (Greek)");
            fileEncodings.put("MacHebrew","MacHebrew (Hebrew)");
            fileEncodings.put("MacIceland","MacIceland (Iceland)");
            fileEncodings.put("MacRoman","MacRoman (Roman)");
            fileEncodings.put("MacRomania","MacRomania (Romania)");
            fileEncodings.put("MacThai","MacThai (Thai)");
            fileEncodings.put("MacTurkish","MacTurkish (Turkish)");
            fileEncodings.put("MacUkraine","MacUkraine (Ukraine)");
            fileEncodings.put("Shift_JIS","Shift_JIS (Japanese)");
            fileEncodings.put("TIS-620","TIS-620 (Thai)");
            fileEncodings.put("US-ASCII","US-ASCII (ASCII)");
            fileEncodings.put("UTF-16","UTF-16 (Unicode)");
            fileEncodings.put("UTF-16BE","UTF-16BE (Unicode Big-Endian)");
            fileEncodings.put("UTF-16LE","UTF-16LE (Unicode Little-Endian)");
            fileEncodings.put("UTF-8","UTF-8 (Unicode Eight-bit)");
            fileEncodings.put("windows-1250","windows-1250 (Eastern European)");
            fileEncodings.put("windows-1251","windows-1251 (Cyrillic)");
            fileEncodings.put("windows-1252","windows-1252 (Latin-1)");
            fileEncodings.put("windows-1253","windows-1253 (Greek)");
            fileEncodings.put("windows-1254","windows-1254 (Turkish)");
            fileEncodings.put("windows-1255","windows-1255 (Hebrew)");
            fileEncodings.put("windows-1256","windows-1256 (Arabic)");
            fileEncodings.put("windows-1257","windows-1257 (Baltic)");
            fileEncodings.put("windows-1258","windows-1258 (Vietnamese)");
            fileEncodings.put("windows-31j","windows-31j (Japanese)");
            fileEncodings.put("x-EUC-CN","x-EUC-CN (Simplified Chinese)");
            fileEncodings.put("x-EUC-JP-LINUX","x-EUC-JP-LINUX (Japanese)");
            fileEncodings.put("x-EUC-TW","x-EUC-TW (Traditional Chinese)");
            fileEncodings.put("x-MS950-HKSCS","x-MS950-HKSCS (Traditional Chinese with Hong Kong extensions)");
            fileEncodings.put("x-mswin-936","x-mswin-936 (Simplified Chinese)");
            fileEncodings.put("x-windows-949","x-windows-949 (Korean)");
            fileEncodings.put("x-windows-950","x-windows-950 (Traditional Chinese)");
        }
        
        return fileEncodings;
    }
    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        splitMain = new javax.swing.JSplitPane();
        pnlConfig = new javax.swing.JPanel();
        pnlTokeniser = new javax.swing.JPanel();
        cboTokenisers = new javax.swing.JComboBox();
        pnlOptions = new javax.swing.JPanel();
        pnlAnnotation = new javax.swing.JPanel();
        btnTokenise = new javax.swing.JButton();
        splitTexts = new javax.swing.JSplitPane();
        pnlSource = new javax.swing.JPanel();
        lblSource = new javax.swing.JLabel();
        scrSource = new javax.swing.JScrollPane();
        txtSource = new javax.swing.JTextArea();
        btnSource = new javax.swing.JButton();
        pnlOutput = new javax.swing.JPanel();
        lblOutput = new javax.swing.JLabel();
        scrOutput = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();
        btnOutput = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("jTokeniser");
        splitMain.setDividerLocation(225);
        pnlTokeniser.setBorder(javax.swing.BorderFactory.createTitledBorder("Tokeniser"));
        cboTokenisers.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BreakIteratorTokeniser", "RegexTokeniser", "RegexSeparatorTokeniser", "StringTokeniser", "SentenceTokeniser", "WhiteSpaceTokeniser" }));
        cboTokenisers.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTokenisersItemStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout pnlTokeniserLayout = new org.jdesktop.layout.GroupLayout(pnlTokeniser);
        pnlTokeniser.setLayout(pnlTokeniserLayout);
        pnlTokeniserLayout.setHorizontalGroup(
            pnlTokeniserLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlTokeniserLayout.createSequentialGroup()
                .addContainerGap()
                .add(cboTokenisers, 0, 168, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTokeniserLayout.setVerticalGroup(
            pnlTokeniserLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, pnlTokeniserLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(cboTokenisers, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlOptions.setLayout(new java.awt.CardLayout());

        pnlOptions.setBorder(javax.swing.BorderFactory.createTitledBorder("Options"));
        pnlOptions.add(breakIteratorPanel, "BreakIteratorTokeniser");
        pnlOptions.add(regexPanel, "RegexTokeniser");
        pnlOptions.add(regexSeparatorPanel, "RegexSeparatorTokeniser");
        pnlOptions.add(sentencePanel, "SentenceTokeniser");
        pnlOptions.add(stringTokeniserPanel, "StringTokeniser");
        pnlOptions.add(whiteSpacePanel, "WhiteSpaceTokeniser");
        ((CardLayout)pnlOptions.getLayout()).first(pnlOptions);

        pnlAnnotation.setLayout(new java.awt.BorderLayout());

        pnlAnnotation.setBorder(javax.swing.BorderFactory.createTitledBorder("Token annotation"));
        pnlAnnotation.add(annotateTokenPanel, BorderLayout.CENTER);

        btnTokenise.setText("Tokenise");
        btnTokenise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTokeniseActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout pnlConfigLayout = new org.jdesktop.layout.GroupLayout(pnlConfig);
        pnlConfig.setLayout(pnlConfigLayout);
        pnlConfigLayout.setHorizontalGroup(
            pnlConfigLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, pnlConfigLayout.createSequentialGroup()
                .addContainerGap()
                .add(pnlConfigLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, pnlOptions, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, pnlAnnotation, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, pnlTokeniser, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(btnTokenise))
                .addContainerGap())
        );
        pnlConfigLayout.setVerticalGroup(
            pnlConfigLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlConfigLayout.createSequentialGroup()
                .addContainerGap()
                .add(pnlTokeniser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pnlOptions, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 208, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pnlAnnotation, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnTokenise)
                .addContainerGap())
        );
        splitMain.setLeftComponent(pnlConfig);

        splitTexts.setBorder(null);
        splitTexts.setDividerLocation(300);
        splitTexts.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        lblSource.setText("Source");
        lblSource.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 2, 1, 1));

        txtSource.setColumns(20);
        txtSource.setRows(5);
        txtSource.setText("The cat sat on the mat.");
        txtSource.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSourceKeyReleased(evt);
            }
        });

        scrSource.setViewportView(txtSource);

        btnSource.setText("Load source");
        btnSource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSourceActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout pnlSourceLayout = new org.jdesktop.layout.GroupLayout(pnlSource);
        pnlSource.setLayout(pnlSourceLayout);
        pnlSourceLayout.setHorizontalGroup(
            pnlSourceLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlSourceLayout.createSequentialGroup()
                .add(lblSource)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 433, Short.MAX_VALUE)
                .add(btnSource))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, scrSource, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );
        pnlSourceLayout.setVerticalGroup(
            pnlSourceLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlSourceLayout.createSequentialGroup()
                .add(pnlSourceLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblSource)
                    .add(btnSource))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(scrSource, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
        );
        splitTexts.setTopComponent(pnlSource);

        lblOutput.setText("Output");
        lblOutput.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 2, 1, 1));

        txtOutput.setColumns(20);
        txtOutput.setEditable(false);
        txtOutput.setRows(5);
        scrOutput.setViewportView(txtOutput);

        btnOutput.setText("Save output");
        btnOutput.setEnabled(false);
        btnOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutputActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout pnlOutputLayout = new org.jdesktop.layout.GroupLayout(pnlOutput);
        pnlOutput.setLayout(pnlOutputLayout);
        pnlOutputLayout.setHorizontalGroup(
            pnlOutputLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlOutputLayout.createSequentialGroup()
                .add(lblOutput)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 435, Short.MAX_VALUE)
                .add(btnOutput))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, scrOutput, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );
        pnlOutputLayout.setVerticalGroup(
            pnlOutputLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlOutputLayout.createSequentialGroup()
                .add(pnlOutputLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblOutput)
                    .add(btnOutput))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(scrOutput, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
        );
        splitTexts.setRightComponent(pnlOutput);

        splitMain.setRightComponent(splitTexts);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(splitMain, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(splitMain, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
        );
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-800)/2, (screenSize.height-600)/2, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutputActionPerformed
    final FileDialog fd = getSaveDialog();
        int returnVal = fd.showDialog();
        
        if (returnVal == FileDialog.OK) {
            SwingUtilities.invokeLater(new Runnable(){
		@Override
                public void run() {
                    String selectedEncoding = fd.getSelectedEncoding();
                    try {
                        
                        String linebuffer = "";
                        String buffer = "";
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fd.getFilename()), selectedEncoding));
                    
                        writer.write(txtOutput.getText());
                        
                        writer.close();
                        
                        
                    }
                    catch (IOException ioe) {
                        // TODO: open a message box here...
                    }
                }
                
            });
        }
    }//GEN-LAST:event_btnOutputActionPerformed

    private void btnSourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSourceActionPerformed
        final FileDialog fd = getOpenDialog();
        int returnVal = fd.showDialog();
        
        if (returnVal == FileDialog.OK) {
            SwingUtilities.invokeLater(new Runnable(){
		@Override
                public void run() {
                    String selectedEncoding = fd.getSelectedEncoding();
                    System.out.println("Encoding: " + selectedEncoding);
                    try {
                        
                        String linebuffer = "";
                        String buffer = "";
                        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fd.getFilename()), selectedEncoding));
                    
                        while ((linebuffer = reader.readLine()) != null) {
                            buffer += linebuffer + '\n';
                        }
                        reader.close();
                        
                        txtSource.setText(buffer.trim());
                        txtOutput.setText("");
                        btnOutput.setEnabled(false);
                    }
                    catch (IOException ioe) {
                        // TODO: open a message box here...
                    }
                }
                
            });
        }
        
    }//GEN-LAST:event_btnSourceActionPerformed

    private void btnTokeniseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTokeniseActionPerformed

        
        String selectedTokeniser = (String)cboTokenisers.getSelectedItem();
        Tokenizer tokenizer;
        if (selectedTokeniser.equals("BreakIteratorTokenizer")) {
            tokenizer = new BreakIteratorTokenizer(txtSource.getText(), breakIteratorPanel.getLocale());
        }
        else if (selectedTokeniser.equals("RegexSeparatorTokenizer")) {
            tokenizer = new RegexSeparatorTokenizer(txtSource.getText(), regexSeparatorPanel.getRegex(), regexSeparatorPanel.isKeepDelim());
        }
        else if (selectedTokeniser.equals("RegexTokenizer")) {
            tokenizer = new RegexTokenizer(txtSource.getText(), regexPanel.getRegex(), regexPanel.isKeepDelim());
        }
        else if (selectedTokeniser.equals("SentenceTokenizer")) {
            tokenizer = new SentenceTokenizer(txtSource.getText(), sentencePanel.getLocale());
        }
        else if (selectedTokeniser.equals("StringTokenizer")) {
            tokenizer = new StringTokenizer(txtSource.getText(), stringTokeniserPanel.getDelimiter(), stringTokeniserPanel.isKeepDelim());
        }
        else if (selectedTokeniser.equals("WhiteSpaceTokenizer")) {
            tokenizer = new WhiteSpaceTokenizer(txtSource.getText());
        }
        else {
            tokenizer = new WhiteSpaceTokenizer(txtSource.getText());
        }
        
        String output = "";
        
        while (tokenizer.hasMoreTokens()) {
            output += annotateTokenPanel.getPrefix() + tokenizer.nextToken() + annotateTokenPanel.getSuffix();
        }
        
        txtOutput.setText(output);
        
        if (txtOutput.getText().trim().equals("")) {
            btnOutput.setEnabled(false);
        }
        else {
            btnOutput.setEnabled(true);
        }
        
    }//GEN-LAST:event_btnTokeniseActionPerformed

    private void txtSourceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSourceKeyReleased
        updateTokenizeButton();
    }//GEN-LAST:event_txtSourceKeyReleased

    private void cboTokenisersItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTokenisersItemStateChanged

        CardLayout cl = (CardLayout)(pnlOptions.getLayout());
        cl.show(pnlOptions, (String)evt.getItem());
    }//GEN-LAST:event_cboTokenisersItemStateChanged
    
    private void updateTokenizeButton() {
        if (txtSource.getText().trim().equals("")) {
            btnTokenise.setEnabled(false);
        }
        else {
            btnTokenise.setEnabled(true);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
	    @Override
            public void run() {
                new jTokeniser().setVisible(true);
            }
        });
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOutput;
    private javax.swing.JButton btnSource;
    private javax.swing.JButton btnTokenise;
    private javax.swing.JComboBox cboTokenisers;
    private javax.swing.JLabel lblOutput;
    private javax.swing.JLabel lblSource;
    private javax.swing.JPanel pnlAnnotation;
    private javax.swing.JPanel pnlConfig;
    private javax.swing.JPanel pnlOptions;
    private javax.swing.JPanel pnlOutput;
    private javax.swing.JPanel pnlSource;
    private javax.swing.JPanel pnlTokeniser;
    private javax.swing.JScrollPane scrOutput;
    private javax.swing.JScrollPane scrSource;
    private javax.swing.JSplitPane splitMain;
    private javax.swing.JSplitPane splitTexts;
    private javax.swing.JTextArea txtOutput;
    private javax.swing.JTextArea txtSource;
    // End of variables declaration//GEN-END:variables
    
}