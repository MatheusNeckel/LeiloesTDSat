
import java.sql.Connection;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class produtosVendidosVIEW extends javax.swing.JFrame {

    public produtosVendidosVIEW() {
        initComponents();
        preencherTabela();
    }
    
    Connection conn;
    
    private void preencherTabela() {
        
        ProdutosDAO produtosDAO = new ProdutosDAO();
        
        conn = new conectaDAO().connectDB();

        List<ProdutosDTO> listarProdutosVendidos = produtosDAO.listarProdutosVendidos();

        DefaultTableModel tabelaProdutosVendidos = (DefaultTableModel) tblProdutosVendidos.getModel();

        tabelaProdutosVendidos.setNumRows(0);

        tblProdutosVendidos.setRowSorter(new TableRowSorter(tabelaProdutosVendidos));
        
        for (ProdutosDTO prod : listarProdutosVendidos) {
            Object[] obj = new Object[]{
                prod.getId(),
                prod.getNome(),
                prod.getValor(),
                prod.getStatus()
            };

            tabelaProdutosVendidos.addRow(obj);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblListaProdutosVendidos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutosVendidos = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblListaProdutosVendidos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblListaProdutosVendidos.setText("Lista de Produtos Vendidos");
        jPanel1.add(lblListaProdutosVendidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        tblProdutosVendidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Valor", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblProdutosVendidos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 270));

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVoltar.setText("Voltar");
        jPanel1.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new produtosVendidosVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblListaProdutosVendidos;
    private javax.swing.JTable tblProdutosVendidos;
    // End of variables declaration//GEN-END:variables
}
