package BookInvSysUI;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import javax.swing.*;
import java.text.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 * @author Aniruddha Nandy
 */
public class BookInvSysUI extends javax.swing.JFrame {
    private static final String username="root";
    private static final String password="Anir12()320()4";
    private static final String dbName="jdbc:mysql://localhost:3306/bookinvsys";
    
    Connection dbConn=null;
    PreparedStatement pst=null;
    ResultSet rst=null;
    
    public BookInvSysUI(){
        initComponents();
        updateDB();
        setSize(1000, 1000);
        }
    
    public void updateDB(){
        try{
            // Establish DB connection
            dbConn = DriverManager.getConnection(dbName, username, password);
            
            // Prepare SQL statement
            pst = dbConn.prepareStatement("SELECT * FROM inventory");
            
            // Execute query and get result set
            rst = pst.executeQuery();
            
            //Get metadata to fetch column count
            ResultSetMetaData rstMD = rst.getMetaData();
            int columnCount = rstMD.getColumnCount();
            
            // Get table model for the JTable
            DefaultTableModel recordTable = (DefaultTableModel) bookTable.getModel();
            
            // Clear any existing rows in table
            recordTable.setRowCount(0);
            
            // Loop through ResultSet and add rows to table
            while (rst.next()){
                // Create an Object array to hold row data
                Object[] row = new Object[columnCount];
                
                // Fill the row array with values from ResultSet
                for (int i = 0; i < columnCount; i++){
                    row[i] = rst.getString(i + 1);
                    }
                
                // Add the row to the table
                recordTable.addRow(row);
                }
            }catch (SQLException ex){
                Logger.getLogger(BookInvSysUI.class.getName()).log(Level.SEVERE, "Database error", ex);
                JOptionPane.showMessageDialog(this, "An error occurred while fetching data. Please try again later.");
                }
        }
             
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();
        filterButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        mainMenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        authorField = new java.awt.TextField();
        genreField = new java.awt.TextField();
        isbnField = new java.awt.TextField();
        titleField = new java.awt.TextField();
        pubDateField = new java.awt.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("  Book Inventory Management System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        addButton.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        addButton.setText("ADD");
        addButton.setPreferredSize(new java.awt.Dimension(115, 39));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        exportButton.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        exportButton.setText("EXPORT");
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        filterButton.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        filterButton.setText("FILTER");
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        exitButton.setText("EXIT");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(filterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(exportButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        mainMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel2.setText("Title");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel3.setText("Genre");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel4.setText("ISBN");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel5.setText("Publication Date");

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel7.setText("Author");

        authorField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        authorField.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        authorField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorFieldActionPerformed(evt);
            }
        });

        genreField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        genreField.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        genreField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genreFieldActionPerformed(evt);
            }
        });

        isbnField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        isbnField.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        isbnField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isbnFieldActionPerformed(evt);
            }
        });

        titleField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        titleField.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        titleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleFieldActionPerformed(evt);
            }
        });

        pubDateField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        pubDateField.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        pubDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pubDateFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainMenuLayout = new javax.swing.GroupLayout(mainMenu);
        mainMenu.setLayout(mainMenuLayout);
        mainMenuLayout.setHorizontalGroup(
            mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainMenuLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainMenuLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainMenuLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(authorField, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainMenuLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(genreField, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainMenuLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(isbnField, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainMenuLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(pubDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        mainMenuLayout.setVerticalGroup(
            mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(authorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(14, 14, 14)
                .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pubDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainMenuLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(isbnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainMenuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addGap(36, 36, 36))
        );

        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Entry ID", "Title", "Author", "Genre", "Pulication Date", "ISBN"
            }
        ));
        jScrollPane1.setViewportView(bookTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(mainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 1000));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pubDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pubDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pubDateFieldActionPerformed

    private void titleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleFieldActionPerformed

    private void isbnFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isbnFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isbnFieldActionPerformed

    private void genreFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genreFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genreFieldActionPerformed

    private void authorFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_authorFieldActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        frame=new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Are you sure?", "Exit Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // Get text from each input field
        String title = titleField.getText().trim();
        String author = authorField.getText().trim();
        String genre = genreField.getText().trim();
        String pubDate = pubDateField.getText().trim();
        String isbn = isbnField.getText().trim();

        // Check for empty field
        if (title.isEmpty() || author.isEmpty() || genre.isEmpty() || pubDate.isEmpty() || isbn.isEmpty()){
            JOptionPane.showMessageDialog(this, "All fields must be filled out!", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
            }
        
        // Validate ISBN-13 format (only 13 digits)
        String isbn13Regex = "^[0-9]{13}$";
        if (!isbn.matches(isbn13Regex)){
            JOptionPane.showMessageDialog(this, "Does not match ISBN-13 format.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
            }
        
        try{
            dbConn = DriverManager.getConnection(dbName, username, password);
            
            String sql = "INSERT INTO inventory(Title, Author, Genre, Publication_Date, ISBN) VALUES(?, ?, ?, ?, ?)";
            
            pst = dbConn.prepareStatement(sql);
            
            // Set the parameters from text fields
            pst.setString(1, title);
            pst.setString(2, author);
            pst.setString(3, genre);
            pst.setString(4, pubDate);
            pst.setString(5, isbn);
            
            // Execute update of rows
            int rowsAffected = pst.executeUpdate();
            
            if (rowsAffected > 0){
                JOptionPane.showMessageDialog(this, "Book Added!");
                updateDB();
                } else{
                JOptionPane.showMessageDialog(this, "Error: Book could not be added.");
                }
            } catch (SQLException ex){
                Logger.getLogger(BookInvSysUI.class.getName()).log(Level.SEVERE, "Database error", ex);
                JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
                }
    }//GEN-LAST:event_addButtonActionPerformed

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        try{
            dbConn = DriverManager.getConnection(dbName, username, password);
            
            StringBuilder query = new StringBuilder("SELECT * FROM inventory WHERE 1=1");  // 1=1 for queries that use appends
            
            // Filter title if field not empty
            if (!titleField.getText().trim().isEmpty()){
                query.append(" AND title LIKE ?");
                }
            
            // Filter author if field not empty
            if (!authorField.getText().trim().isEmpty()){
                query.append(" AND author LIKE ?");
                }
            
            // Filter genre if field not empty
            if (!genreField.getText().trim().isEmpty()){
                query.append(" AND genre LIKE ?");
                }
            
            // Filter publication date if field not empty
            if (!pubDateField.getText().trim().isEmpty()){
                query.append(" AND publication_date LIKE ?");
                }
            
            // Filter ISBN if field not empty
            if (!isbnField.getText().trim().isEmpty()){
                query.append(" AND ISBN LIKE ?");
                }
            
            // Prepare the statement based on the dynamically built query
            pst = dbConn.prepareStatement(query.toString());
            
            // Set parameters for each filter in the query
            int paramIndex = 1;
            if (!titleField.getText().trim().isEmpty()){
                pst.setString(paramIndex++, "%" + titleField.getText() + "%");
                }
            if (!authorField.getText().trim().isEmpty()){
                pst.setString(paramIndex++, "%" + authorField.getText() + "%");
                }
            if (!genreField.getText().trim().isEmpty()){
                pst.setString(paramIndex++, "%" + genreField.getText() + "%");
                }
            if (!pubDateField.getText().trim().isEmpty()) {
                pst.setString(paramIndex++, "%" + pubDateField.getText() + "%");
                }
            if (!isbnField.getText().trim().isEmpty()) {
                pst.setString(paramIndex++, "%" + isbnField.getText() + "%");
                }
            
           ResultSet rs = pst.executeQuery();
           
           // Get metadata of ResultSet (to determine number of columns)
           ResultSetMetaData rstMD = rs.getMetaData();
           int columnCount = rstMD.getColumnCount();
           
           DefaultTableModel recordTable = (DefaultTableModel) bookTable.getModel();
           
           recordTable.setRowCount(0);
           
           while (rs.next()){ 
               Vector<String> columnData = new Vector<>();
               
               for (int i = 1; i <= columnCount; i++){
                   columnData.add(rs.getString(i));
                   }
               recordTable.addRow(columnData);
               }
           
           // If no records found
           if (recordTable.getRowCount() == 0){
               JOptionPane.showMessageDialog(this, "No records found matching the criteria.");
               }
           } catch (SQLException ex){
               JOptionPane.showMessageDialog(null, ex);
               }    
    }//GEN-LAST:event_filterButtonActionPerformed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        try{
            dbConn = DriverManager.getConnection(dbName, username, password);

            String sql = "SELECT * FROM inventory";
            pst = dbConn.prepareStatement(sql);
            rst = pst.executeQuery();

            // Show location to save file
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save CSV File");
            fileChooser.setSelectedFile(new File("inventory.csv"));  // Default filename
            int userChoice = fileChooser.showSaveDialog(this);

            if (userChoice == JFileChooser.APPROVE_OPTION){
                // Get file chosen by user
                File fileToSave = fileChooser.getSelectedFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave));

                // Write CSV header (column names) to file
                writer.write("Entry_ID,Title,Author,Genre,Publication_Date,ISBN");
                writer.newLine();

                // Write each row from ResultSet to CSV file
                while (rst.next()){
                    String entryId = rst.getString("entry_id");
                    String title = rst.getString("title");
                    String author = rst.getString("author");
                    String genre = rst.getString("genre");
                    String pubDate = rst.getString("publication_date");
                    String isbn = rst.getString("isbn");

                    writer.write(entryId + "," + title + "," + author + "," + genre + "," + pubDate + "," + isbn);
                    writer.newLine();
                    }
                
                // Close the writer and ResultSet
                writer.close();
                rst.close();
                pst.close();
                
                JOptionPane.showMessageDialog(this, "Data exported successfully!", "Export Successful", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex){
                JOptionPane.showMessageDialog(this, "Error during export: " + ex.getMessage(), "Export Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex){
                    Logger.getLogger(BookInvSysUI.class.getName()).log(Level.SEVERE, null, ex);
                    } finally{
            try{
                // Ensure DB connection closed
                if (dbConn != null){
                    dbConn.close();
                    }
                } catch (SQLException ex){
                    }
            }
    }//GEN-LAST:event_exportButtonActionPerformed

    private JFrame frame;
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
            java.util.logging.Logger.getLogger(BookInvSysUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookInvSysUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookInvSysUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookInvSysUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookInvSysUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private java.awt.TextField authorField;
    private javax.swing.JTable bookTable;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton exportButton;
    private javax.swing.JButton filterButton;
    private java.awt.TextField genreField;
    private java.awt.TextField isbnField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainMenu;
    private java.awt.TextField pubDateField;
    private java.awt.TextField titleField;
    // End of variables declaration//GEN-END:variables
}