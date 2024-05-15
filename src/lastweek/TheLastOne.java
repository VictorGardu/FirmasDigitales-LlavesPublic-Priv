package lastweek;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JFileChooser;

public class TheLastOne extends javax.swing.JFrame {
     
     PrivateKey llavePrivada = null;
     PublicKey llavePublica = null;
     byte[] digitalSignature = null;
     Signature signature = null;
     
    public TheLastOne() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Verificar Firma");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Texto Plano");

        jButton2.setText("Encriptar Archivo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Firmar Documento");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Generar Llaves");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton5.setText("Desencriptar Archivo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setText("Texto Cifrado");

        jButton6.setText("Obtener HASH");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(161, 161, 161)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(68, 68, 68)
                                .addComponent(jButton2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton5)
                                        .addGap(118, 118, 118)
                                        .addComponent(jButton6)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton3)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jButton2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jLabel2)
                            .addComponent(jButton6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
               
             JFileChooser fileChooser = new JFileChooser();
             fileChooser.setDialogTitle("Seleccione la clave pública");
             int userSelection = fileChooser.showOpenDialog(null);
             
             if (userSelection == JFileChooser.APPROVE_OPTION) {
                 File publicKeyFile = fileChooser.getSelectedFile();
                 byte[] keyBytes = null;
                 try {
                     keyBytes = readKeyFile(publicKeyFile);
                 } catch (IOException ex) {
                     Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
                 KeyFactory keyFactory = null;
                 try {
                     keyFactory = KeyFactory.getInstance("RSA");
                 } catch (NoSuchAlgorithmException ex) {
                     Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 try {
                     llavePublica = keyFactory.generatePublic(spec);
                     
                 } catch (InvalidKeySpecException ex) {
                     Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
                 }
             } else {
                 try {
                     throw new Exception("Selección de clave pública cancelada por el usuario.");
                 } catch (Exception ex) {
                     Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             
             
             JFileChooser fileChooser5 = new JFileChooser();
             //Con esto, abrimos la ventana para elegir el archivo.
             int returnValue = fileChooser5.showOpenDialog(null);
             //Si le damos al boton de aceptar o abrir, entonces hara lo sigueinte.
             if (returnValue == JFileChooser.APPROVE_OPTION) {
                 FileInputStream inputStream = null;
                 try {
                     //Primeramente, crearemos un objeto de tipo File
                     //Con el objeto que tomamos o el seleccionado en la ventana pues.
                     File inputFile = fileChooser.getSelectedFile();
                     inputStream = new FileInputStream(inputFile);
                     byte[] firma = new byte[(int) inputFile.length()];
                     // Crear un objeto Signature para verificar la firma
                     
                     
                     try {
                         signature.initVerify(llavePublica);
                     } catch (InvalidKeyException ex) {
                         Logger.getLogger(TheLastOne.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     
                     //Seleccionar la informacion del archivo firmado.
                     JFileChooser fileChooser3 = new JFileChooser();
                //Con esto, abrimos la ventana para elegir el archivo.
                int returnValue2 = fileChooser3.showOpenDialog(null);
                //Si le damos al boton de aceptar o abrir, entonces hara lo sigueinte.
                if (returnValue2 == JFileChooser.APPROVE_OPTION) {
                    //Primeramente, crearemos un objeto de tipo File
                    //Con el objeto que tomamos o el seleccionado en la ventana pues.
                    File inputFile3 = fileChooser3.getSelectedFile();
                    
                    FileInputStream inputStream2 = null;
                    try {
                        inputStream2 = new FileInputStream(inputFile3);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(TheLastOne.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    byte[] inputBytess = new byte[(int) inputFile3.length()];
                    try {
                        //Y leeremos su contenido como tal.
                        inputStream.read(inputBytess);
                    } catch (IOException ex) {
                        Logger.getLogger(TheLastOne.class.getName()).log(Level.SEVERE, null, ex);
                    }
                         
                         
                         
                         try {
                             // Actualizar el objeto Signature con el contenido del documento
                             signature.update(inputBytess);
                         } catch (SignatureException ex) {
                             Logger.getLogger(TheLastOne.class.getName()).log(Level.SEVERE, null, ex);
                         }
                         
                         // Verificar la firma digital
                         boolean isValid = false;
                         try {
                             isValid = signature.verify(digitalSignature);
                         } catch (SignatureException ex) {
                             Logger.getLogger(TheLastOne.class.getName()).log(Level.SEVERE, null, ex);
                         }
                         
                         if (isValid) {
                             System.out.println("La firma digital es válida.");
                         } else {
                             System.out.println("La firma digital no es válida.");
                         }
                         
                     }
                 } catch (FileNotFoundException ex) {
                     Logger.getLogger(TheLastOne.class.getName()).log(Level.SEVERE, null, ex);
                 } finally {
                     try {
                         inputStream.close();
                     } catch (IOException ex) {
                         Logger.getLogger(TheLastOne.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
             }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     //Primeramente tenemos un try-catch para tomar los errores que se vayan presnetando en las libterias.
        try {
            //Instanciamos el generador de llaves con RSA.
            KeyPairGenerator keyGen =
                 KeyPairGenerator.getInstance("RSA");
            //SecureRandom random =
              //   SecureRandom.getInstance("SHA1PRNG", "SUN");
            keyGen.initialize(1024); //o 2048
            //De tamaño 1024 en vez de 2048 por lo basico, y quitamos el SHA1 porque siento que no viene al caso.
            KeyPair pair = keyGen.generateKeyPair();
            //Entonces tomamos ambas llaves, con su metodo get.
            PrivateKey priv = pair.getPrivate();
            PublicKey pub = pair.getPublic();

            
            //Y las dos llaves las guardamos en donde mismo, en disco local en la carpeta de llaves.
            //Y mostramos su formato pos si las dudas.
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
            
            System.err.println("Private key format: " + priv.getFormat());
            // prints "Private key format: PKCS#8" on my machine

            System.err.println("Public key format: " + pub.getFormat());
            // prints "Public key format: X.509" on my machine
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        //Entonces, procedemos a crear un objeto de tipo fileChooser
        JFileChooser fileChooser = new JFileChooser();
        //Con esto, abrimos la ventana para elegir el archivo.
        int returnValue = fileChooser.showOpenDialog(null);
        //Si le damos al boton de aceptar o abrir, entonces hara lo siguiente.
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            //Primeramente, crearemos un objeto de tipo File
            //Con el objeto que tomamos o el seleccionado en la ventana pues.
            File inputFile = fileChooser.getSelectedFile();

                try {                                         
            //le pedimos que seleccione la clave publica.
            JFileChooser fileChooser2 = new JFileChooser();
            fileChooser.setDialogTitle("Seleccione la clave pública");
            int userSelection = fileChooser2.showOpenDialog(null);
            
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File publicKeyFile = fileChooser2.getSelectedFile();
                byte[] keyBytes = null;
                try {
                    //por aca leemos el contenido de la llave.
                    keyBytes = readKeyFile(publicKeyFile);
                } catch (IOException ex) {
                    Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
                }
                //Le aplicamos su conversion de formato.
                X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
                KeyFactory keyFactory = null;
                try {
                    keyFactory = KeyFactory.getInstance("RSA");
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    //Y por aca le damos el contenido a nuestra PublicKey de la llave publica.
                    llavePublica = keyFactory.generatePublic(spec);
                    
                } catch (InvalidKeySpecException ex) {
                    Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    throw new Exception("Selección de clave pública cancelada por el usuario.");
                } catch (Exception ex) {
                    Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //por aca inciiamos el cipher con el encrypt mode y con la llave publica.
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance("RSA");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                cipher.init(Cipher.ENCRYPT_MODE, llavePublica);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                //Y el cambio es que vamos a seleccionar un archivo en vez de solo texto.
                //Y ahora haremos uso del FileInputStream, con esto
                //Tomaremos el archivo previamente seleccionado y lo convertiremos a un arreglo de bytes.
                FileInputStream inputStream = new FileInputStream(inputFile);
                byte[] inputBytes = new byte[(int) inputFile.length()];
                //Y leeremos su contenido como tal.
                inputStream.read(inputBytes);
                //Y le daremos salida en su forma encriptada por asi decirlo.
                byte[] outputBytes = cipher.doFinal(inputBytes);

                //Aqui, estoy abriendo otra ventana de explorador de archivos pero ahora en modo de 
                //guardado, para seleccionar donde guardaremos el archivo encriptado.
                JFileChooser saveFileChooser = new JFileChooser();
                int saveReturnValue = saveFileChooser.showSaveDialog(null);
                //Si le damos en ok o aceptar o seleccionar entonces.
                if (saveReturnValue == JFileChooser.APPROVE_OPTION) {
                    //entonces procederemos a guardar el archivo.
                    File encryptedFile = saveFileChooser.getSelectedFile();
                    //Tecnicamente es crear un archivo outputStream, con el otro archivo encriptado.
                    FileOutputStream outputStream = new FileOutputStream(encryptedFile);
                    //Escribirlo
                    outputStream.write(outputBytes);
                    //Y cerrarlo y ya estaria.
                    outputStream.close();
                }

                inputStream.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }       
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                //En el boton de generar la firma digital, requerimos la llave privada para esto.
                JFileChooser fileChooser2 = new JFileChooser();
                fileChooser2.setDialogTitle("Seleccione la clave privada");
                int userSelection2 = fileChooser2.showOpenDialog(null);
                
                if (userSelection2 == JFileChooser.APPROVE_OPTION) {
                    try {
                        //Al igual que en el encriptado, estamos seleccionando el archivo de la llave privada.
                        File privateKeyFile = fileChooser2.getSelectedFile();
                        byte[] keyBytes = readKeyFile(privateKeyFile);
                        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
                        KeyFactory keyFactory = null;
                        try {
                            keyFactory = KeyFactory.getInstance("RSA");
                        } catch (NoSuchAlgorithmException ex) {
                            Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            //Y por aca ya con los valores convertidos y con formato, ya tenemos la llave privada.
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
                     
                
                // Crear un objeto Signature
                //Y aca generamos la signature, instanciandose con el SHA2.
                try {
                    signature = Signature.getInstance("SHA256withRSA");
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(TheLastOne.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    //Iniciamos la signature con la llave privada previamente instanciada.
                    signature.initSign(llavePrivada);
                } catch (InvalidKeyException ex) {
                    Logger.getLogger(TheLastOne.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                //Y por aca vamos a seleccionar la informacion del archivo que queremos firmar.
                JFileChooser fileChooser3 = new JFileChooser();
                //Con esto, abrimos la ventana para elegir el archivo.
                int returnValue = fileChooser3.showOpenDialog(null);
                //Si le damos al boton de aceptar o abrir, entonces hara lo sigueinte.
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    //Primeramente, crearemos un objeto de tipo File
                    //Con el objeto que tomamos o el seleccionado en la ventana pues.
                    File inputFile = fileChooser3.getSelectedFile();
                    
                    FileInputStream inputStream = null;
                    try {
                        inputStream = new FileInputStream(inputFile);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(TheLastOne.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    byte[] inputBytes = new byte[(int) inputFile.length()];
                    try {
                        //Y leeremos su contenido como tal.
                        inputStream.read(inputBytes);
                    } catch (IOException ex) {
                        Logger.getLogger(TheLastOne.class.getName()).log(Level.SEVERE, null, ex);
                    }
                              
                    try {
                        // Firmar el documento, con esto lo firmamos, introduciendo sus datos dentor del signature.
                        signature.update(inputBytes);
                    } catch (SignatureException ex) {
                        Logger.getLogger(TheLastOne.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                    try {
                        digitalSignature = signature.sign();
                    } catch (SignatureException ex) {
                        Logger.getLogger(TheLastOne.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                    try {
                        //Y con esto, guardaremos la firma en un archivo .bin dentro de la carpeta de llaves y listo.
                        saveDigitalSignature("C:\\Llaves\\firma_digital.bin", digitalSignature);
                    } catch (IOException ex) {
                        Logger.getLogger(TheLastOne.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                System.out.println("Firma digital generada con éxito.");
                }         
            
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    //Entonces, procedemos a crear un objeto de tipo fileChooser
        JFileChooser fileChooser = new JFileChooser();
        //Con esto, abrimos la ventana para elegir el archivo.
        int returnValue = fileChooser.showOpenDialog(null);
        //Si le damos al boton de aceptar o abrir, entonces hara lo sigueinte.
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            //Primeramente, crearemos un objeto de tipo File
            //Con el objeto que tomamos o el seleccionado en la ventana pues.
            File inputFile = fileChooser.getSelectedFile();

                try {                                         
            
            JFileChooser fileChooser2 = new JFileChooser();
            fileChooser.setDialogTitle("Seleccione la clave privada");
            int userSelection = fileChooser2.showOpenDialog(null);
            
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File privateKeyFile = fileChooser2.getSelectedFile();
                byte[] keyBytes = null;
                try {
                    keyBytes = readKeyFile(privateKeyFile);
                } catch (IOException ex) {
                    Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
                }
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
            } else {
                try {
                    throw new Exception("Selección de clave pública cancelada por el usuario.");
                } catch (Exception ex) {
                    Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //Iniciamos el cipher, en modo desencriptado con su llave privada previamente instanciada.
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance("RSA");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                cipher.init(Cipher.DECRYPT_MODE, llavePrivada);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(LastHome.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                //Y ahora haremos uso del FileInputStream, con esto
                //Tomaremos el archivo previamente seleccionado y lo convertiremos a un arreglo de bytes.
                FileInputStream inputStream = new FileInputStream(inputFile);
                byte[] inputBytes = new byte[(int) inputFile.length()];
                //Y leeremos su contenido como tal.
                inputStream.read(inputBytes);
                //Y le daremos salida en su forma encriptada por asi decirlo.
                byte[] outputBytes = cipher.doFinal(inputBytes);

                //Aqui, estoy abriendo otra ventana de explorador de archivos pero ahora en modo de 
                //guardado, para seleccionar donde guardaremos el archivo encriptado.
                JFileChooser saveFileChooser = new JFileChooser();
                int saveReturnValue = saveFileChooser.showSaveDialog(null);
                //Si le damos en ok o aceptar o seleccionar entonces.
                if (saveReturnValue == JFileChooser.APPROVE_OPTION) {
                    //entonces procederemos a guardar el archivo.
                    File encryptedFile = saveFileChooser.getSelectedFile();
                    //Tecnicamente es crear un archivo outputStream, con el otro archivo encriptado.
                    FileOutputStream outputStream = new FileOutputStream(encryptedFile);
                    //Escribirlo
                    outputStream.write(outputBytes);
                    //Y cerrarlo y ya estaria.
                    outputStream.close();
                }

                inputStream.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }       
     
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //Para el boton hash, hacemos un trycatch para errores posibles.
        try {
            //Seleccionamos el documento que vamos a generar su hash, lo seleccionamos.
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getAbsolutePath();
                //Y llamamos al metood calculate hash para calcular el hash del archivo que seleccionamos con SHA 256.
                byte[] fileHash = calculateHash(filePath, "SHA-256");
                    
                // Imprimir el hash como una cadena hexadecimal
                jTextArea3.setText(("Hash del archivo: " + bytesToHex(fileHash)));
                
                // Guardar el hash en un archivo
                saveHashToFile("C:\\Llaves\\hash.txt", bytesToHex(fileHash));
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }    
        
    }//GEN-LAST:event_jButton6ActionPerformed

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
    private static void saveDigitalSignature(String signaturePath, byte[] digitalSignature) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(signaturePath)) {
            fos.write(digitalSignature);
        }
    }
    private static byte[] calculateHash(String filePath, String algorithm) throws Exception {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        try (FileInputStream fis = new FileInputStream(filePath);
             DigestInputStream dis = new DigestInputStream(fis, digest)) {

            byte[] buffer = new byte[4096];
            while (dis.read(buffer) != -1) {
                // Leemos el archivo para calcular el hash
            }
        }

        // Obtenemos el hash calculado
        return digest.digest();
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
    private static void saveHashToFile(String filePath, String hash) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(hash);
        }
    }
    private static byte[] readBytesFromFile(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            return bos.toByteArray();
        }
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TheLastOne().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables
}
