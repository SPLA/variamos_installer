package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import controller.GUIDirectorioController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
/**
 *
 * @author José David Henao Ocampo - Monitor Especialización en Desarrollo de Software
 *    &    Hassler Castro Cuesta - Monitor Especialización en Diseño Mecánico
 */
public class Directorio extends javax.swing.JFrame {
    private Object[] acept = {"OK"};
    
    public Directorio() throws SAXException, IOException, ParserConfigurationException {
        initComponents();
        variamos.utility.Configuration config = new variamos.utility.Configuration();
        config.loadConfigurationFile();
        this.setTitle("VariaMos and SWI-Prolog Installer");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        variamosRuteTxt.setEditable(false);
        printTxt.setText("VariaMos " + config.variamosVersion + "\nSWI-Prolog " + config.solverVersion); 
        printTxt.setEditable(false);
        
        installBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                instalarBtnActionPerformed(ae);
            }
        });
        
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                atrasBtnActionPerformed(ae);
            }
        });
        
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    buscarBtnActionPerformed(ae);
                } catch (NullPointerException npe) {
                    System.err.println("ruta invalida");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Directorio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Directorio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
    
    private void instalarBtnActionPerformed(ActionEvent ae) {
        if(variamosRuteTxt.getText().equals("") || variamosRuteTxt.getText().equals(" ")) {
            JOptionPane.showOptionDialog(null, "     Invalid directory", "Message", 
                                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, acept, acept[0]);
            return;
        } else {
            this.setVisible(false);
            new ProgressInstaller(variamosRuteTxt.getText());
        }
    }
    
    private void buscarBtnActionPerformed(ActionEvent ae) throws NullPointerException, InterruptedException, IOException{
        GUIDirectorioController controlador = new GUIDirectorioController();
        variamosRuteTxt.setText(controlador.ejecucionDeRuta());
    }
    
    private void atrasBtnActionPerformed(ActionEvent ae){
        this.dispose();
        Inicio ini = new Inicio();
        ini.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        variamosTitle = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        installBtn = new javax.swing.JButton();
        infoLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        printTxt = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        variamosRuteTxt = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        lblDownloadings = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        variamosTitle.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        variamosTitle.setText("VariaMos Installer");

        backBtn.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        backBtn.setText("Back");

        installBtn.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        installBtn.setText("Install");

        infoLbl.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        infoLbl.setText("These software will be installed");

        printTxt.setColumns(20);
        printTxt.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        printTxt.setRows(5);
        jScrollPane1.setViewportView(printTxt);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("Destination folder:");

        searchBtn.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        searchBtn.setText("Browse");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(installBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(lblDownloadings, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(variamosRuteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(infoLbl))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(searchBtn))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(variamosTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(variamosTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(variamosRuteTxt))
                .addGap(31, 31, 31)
                .addComponent(infoLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(installBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDownloadings, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel infoLbl;
    private javax.swing.JButton installBtn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDownloadings;
    public javax.swing.JTextArea printTxt;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField variamosRuteTxt;
    private javax.swing.JLabel variamosTitle;
    // End of variables declaration//GEN-END:variables
}
