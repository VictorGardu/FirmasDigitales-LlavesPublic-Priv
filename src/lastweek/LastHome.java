package lastweek;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JFileChooser;
public class LastHome extends javax.swing.JFrame {
    PublicKey llavePublica = null;
    PrivateKey llavePrivada = null;
    public LastHome() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Generar Llaves");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Encriptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Desencriptar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel1.setText("Texto Plano");

        jLabel2.setText("Texto Cifrado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(56, 56, 56)
                        .addComponent(jButton3)
                        .addGap(0, 107, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Como tal, abrimo la sentencia try y catch para prevenir de errores.
        try {
            //Crearemos una KeyPairGenerator que es un objeto para generar las llaves.
            //En este caso con el nombre keyGen, obteniendo una instancia del metodo RSA.
            KeyPairGenerator keyGen =
                 KeyPairGenerator.getInstance("RSA");
            //Esta parte de aqui del SHA1 no se utilizo ya que aun no lo entendi o sabia que era parte del codigo
            //por lo tanto no lo agregue.
            //SecureRandom random =
              //   SecureRandom.getInstance("SHA1PRNG", "SUN");
              //Debajo iniciamos las llaves con el tamaño 1024 pero puede ser 2048 dependiendo.
            keyGen.initialize(1024); //o 2048
            //Generamos el par de llaves
            KeyPair pair = keyGen.generateKeyPair();
            //Las obtenemos separadas con los respectivos metodos get().
            PrivateKey priv = pair.getPrivate();
            PublicKey pub = pair.getPublic();

            //Y crearemos dos archivos, para poder guardas las llaves donde queramos.
            //Ambas en el disco local C en la carpeta llaves, con su nombre/indentificador.
            byte[] encPriv = priv.getEncoded();
            FileOutputStream privfos =
                new FileOutputStream("C:\\Llaves\\PrivateKey.key");
            privfos.write(encPriv);
            privfos.close();

            byte[] encPub = pub.getEncoded();
            FileOutputStream pubfos =
                new FileOutputStream("C:\\Llaves\\PublicKey.key");
            pubfos.write(encPub);
            pubfos.close();
            
            //Aqui unicamente se añade esto para saber el fomrato de las llaves generadas.
            System.err.println("Private key format: " + priv.getFormat());
            // prints "Private key format: PKCS#8" on my machine

            System.err.println("Public key format: " + pub.getFormat());
            // prints "Public key format: X.509" on my machine
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Nuevamente metemos todo dentro una instruccion try para tratar de hacer lo del codigo
        //pero teniendo sus exepctiones.
        try {                                         
            //Crearemos un fileChooser, que le damos el nombre de clave publica, permitiendo que el usuario
            //seleccione la llave publica que quiera para encriptar.
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Seleccione la clave pública");
            int userSelection = fileChooser.showOpenDialog(null);
            
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File publicKeyFile = fileChooser.getSelectedFile();
                byte[] keyBytes = null;
                try {
                    //Este metodo de aqui, es creado por mi para leer el contenido de la llave y poder usarla.
                    keyBytes = readKeyFile(publicKeyFile);
                } catch (IOException ex) {
                    Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
                }
                //Aca debajo le cambiamos el tipo de formato a la llave para que se adapte al JCE.
                X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
                KeyFactory keyFactory = null;
                try {
                    //Le damos la instancia de tipo RSA.
                    keyFactory = KeyFactory.getInstance("RSA");
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    //Y le damos el valor a nuestra variable llavePublica que es de tipo PublicKey en la parte de arriba.
                    llavePublica = keyFactory.generatePublic(spec);
                    
                } catch (InvalidKeySpecException ex) {
                    Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    //Excepcion por si el usuario cancela.
                    throw new Exception("Selección de clave pública cancelada por el usuario.");
                } catch (Exception ex) {
                    Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //Iniciamos el cipher, le damos la instancia de RSA para encriptar.
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance("RSA");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                //Y seleccionamos el modo de encriptado pero con la llave publica que elegimos.
                cipher.init(Cipher.ENCRYPT_MODE, llavePublica);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Tomamos el texto del textArea1 y l mostraremos en el 2 con formato base64.
            byte[] encryptedBytes = cipher.doFinal(jTextArea1.getText().getBytes());
            
            jTextArea2.setText(Base64.getEncoder().encodeToString(encryptedBytes));
    
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //creamos un try catch para errores entre los metodos JCE y FileChooser
        try {
            //Le pedimos tomar su clave privada para desencriptar.
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Seleccione la clave privada");
            int userSelection = fileChooser.showOpenDialog(null);
            
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                try {
                    File privateKeyFile = fileChooser.getSelectedFile();
                    byte[] keyBytes = readKeyFile(privateKeyFile);
                    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
                    KeyFactory keyFactory = null;
                    try {
                        keyFactory = KeyFactory.getInstance("RSA");
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                         llavePrivada = keyFactory.generatePrivate(spec);
                    } catch (InvalidKeySpecException ex) {
                        Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    throw new Exception("Selección de clave privada cancelada por el usuario.");
                } catch (Exception ex) {
                    Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //Iniciamos el cipher pero con el modo desencriptado o decrypt y con la llave privada como key.
            Cipher cipher = Cipher.getInstance("RSA");
            try {
                cipher.init(Cipher.DECRYPT_MODE, llavePrivada);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
            }
            byte[] decryptedBytes = null;
            try {
                //Tomamos el texto cifrado y le quitamos el formato para poder transformarlo comoe staba y desencriptarlo.
                //Para luego mostrarlo en el textArea1.
                decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(jTextArea2.getText()));
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
            }
             jTextArea1.setText(new String(decryptedBytes));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }//GEN-LAST:event_jButton3ActionPerformed

    // Método para seleccionar la clave pública desde un archivo
    public static PublicKey selectPublicKey() throws Exception {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione la clave pública");
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File publicKeyFile = fileChooser.getSelectedFile();
            byte[] keyBytes = readKeyFile(publicKeyFile);
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(spec);
        } else {
            throw new Exception("Selección de clave pública cancelada por el usuario.");
        }
    }

    // Método para seleccionar la clave privada desde un archivo
    public static PrivateKey selectPrivateKey() throws Exception {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione la clave privada");
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File privateKeyFile = fileChooser.getSelectedFile();
            byte[] keyBytes = readKeyFile(privateKeyFile);
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePrivate(spec);
        } else {
            throw new Exception("Selección de clave privada cancelada por el usuario.");
        }
    }

    // Método para leer el contenido de un archivo de clave
    private static byte[] readKeyFile(File keyFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(keyFile)) {
            byte[] keyBytes = new byte[(int) keyFile.length()];
            fis.read(keyBytes);
            return keyBytes;
        }
    }    

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LastHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
